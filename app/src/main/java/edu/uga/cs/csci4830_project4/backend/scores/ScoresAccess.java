package edu.uga.cs.csci4830_project4.backend.scores;

import static edu.uga.cs.csci4830_project4.backend.utils.BackendUtilMethods.getColumnIndex;
import static edu.uga.cs.csci4830_project4.common.CommonUtilMethods.dateToString;
import static edu.uga.cs.csci4830_project4.common.CommonUtilMethods.stringToDate;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.uga.cs.csci4830_project4.backend.contracts.IAccess;
import edu.uga.cs.csci4830_project4.backend.contracts.IDatabase;
import edu.uga.cs.csci4830_project4.backend.contracts.IDatabaseHelper;
import edu.uga.cs.csci4830_project4.backend.quizzes.QuizTableValues;
import edu.uga.cs.csci4830_project4.common.QuizType;

/**
 * This class provides access to the scores table in the database and encapsulates the
 * CRUD (Create, Read, Update, Delete) operations for the score data.
 */
public class ScoresAccess implements IAccess<ScoreModel> {

    private final IDatabaseHelper helper;
    private IDatabase db;

    /**
     * Constructs a new {@link ScoresAccess} instance with the provided context.
     *
     * @param context The application context used to initialize the database helper.
     */
    public ScoresAccess(Context context) {
        helper = ScoresDatabaseHelper.getInstance(context);
    }

    /**
     * Package-private constructor meant only for testing, DO NOT USE IN PRODUCTION.
     *
     * @param helper the database helper.
     */
    ScoresAccess(IDatabaseHelper helper) {
        this.helper = helper;
    }

    @Override
    public void open() {
        db = helper.getModifiableDatabase();
    }

    @Override
    public void close() {
        if (helper != null) {
            helper.close();
        }
    }

    private Map<String, Object> getValues(ScoreModel scoreModel) {
        Map<String, Object> values = new HashMap<>();

        String score = String.valueOf(scoreModel.getScore());
        values.put(ScoreTableValues.COLUMN_SCORE, score);

        String timeCompleted = dateToString(scoreModel.getTimeCompleted());
        values.put(ScoreTableValues.COLUMN_TIME_COMPLETED, timeCompleted);

        String quizType = scoreModel.getQuizType().name();
        values.put(ScoreTableValues.COLUMN_QUIZ_TYPE, quizType);

        return values;
    }

    @Override
    public ScoreModel store(ScoreModel model) {
        Map<String, Object> values = getValues(model);
        long id = db.insert(ScoreTableValues.TABLE_NAME, null, values);
        model.setId(id);
        return model;
    }

    @Override
    public ScoreModel getById(long id) {
        List<ScoreModel> models = retrieve(null, "_id = ?", new String[]{String.valueOf(id)},
                null, null, null, null);
        return models.isEmpty() ? null : models.get(0);
    }

    @Override
    public List<ScoreModel> retrieve(String[] columns, String selection, String[] selectionArgs,
                                     String groupBy, String having, String orderBy, String limit) {
        List<ScoreModel> models = new ArrayList<>();

        try (Cursor cursor = db.query(ScoreTableValues.TABLE_NAME, columns, selection,
                selectionArgs, groupBy, having, orderBy, limit)) {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    long id = cursor.getLong(getColumnIndex(cursor, QuizTableValues.COLUMN_ID));
                    String score = cursor.getString(getColumnIndex(cursor,
                            ScoreTableValues.COLUMN_SCORE));
                    String dateCompleted = cursor.getString(getColumnIndex(cursor,
                            ScoreTableValues.COLUMN_TIME_COMPLETED));
                    String quizType = cursor.getString(getColumnIndex(cursor,
                            ScoreTableValues.COLUMN_QUIZ_TYPE));

                    ScoreModel model = new ScoreModel();
                    model.setId(id);
                    model.setScore(score);
                    model.setQuizType(QuizType.valueOf(quizType));
                    model.setTimeCompleted(stringToDate(dateCompleted));

                    models.add(model);
                } while (cursor.moveToNext());
            }
        }

        return models;
    }

    @Override
    public List<ScoreModel> retrieveAll() {
        return retrieve(null, null, null, null, null, null, null);
    }

    @Override
    public int update(ScoreModel model) {
        Map<String, Object> values = getValues(model);
        return db.update(ScoreTableValues.TABLE_NAME, values, "_id = ?",
                new String[]{String.valueOf(model.getId())});
    }

    @Override
    public int deleteById(long id) {
        if (db == null) {
            return -1;
        }
        return db.delete(ScoreTableValues.TABLE_NAME, "_id = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public void deleteAll() {
        if (db == null) {
            return;
        }
        db.delete(ScoreTableValues.TABLE_NAME, null, null);
    }
}

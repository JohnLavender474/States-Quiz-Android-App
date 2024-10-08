package edu.uga.cs.csci4830_project4.frontend.dto;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.uga.cs.csci4830_project4.backend.quizzes.QuizModel;
import edu.uga.cs.csci4830_project4.common.QuizType;

/**
 * DTO for a quiz.
 */
public class QuizDTO implements Serializable {

    private long quizId;
    private QuizType quizType;
    private List<String> questions;
    private List<List<String>> choices;
    private List<String> responses;
    private List<String> answers;
    private List<String> stateNames;
    private LocalDateTime timeCreated;
    private LocalDateTime timeUpdated;

    /**
     * Default constructor.
     */
    public QuizDTO() {
        quizId = -1L;
    }

    /**
     * Constructor for this DTO.
     *
     * @param quizId     The ID of the quiz.
     * @param questions  The questions.
     * @param choices    The choices.
     * @param responses  The responses.
     * @param answers    The answers.
     * @param stateNames The state names.
     */
    public QuizDTO(long quizId, QuizType quizType, List<String> questions,
                   List<List<String>> choices, List<String> responses, List<String> answers,
                   List<String> stateNames, LocalDateTime timeCreated, LocalDateTime timeUpdated) {
        this.quizId = quizId;
        this.quizType = quizType;
        this.questions = questions;
        this.choices = choices;
        this.responses = responses;
        this.answers = answers;
        this.stateNames = stateNames;
        this.timeCreated = timeCreated;
        this.timeUpdated = timeUpdated;
    }

    public long getQuizId() {
        return quizId;
    }

    public void setQuizId(long quizId) {
        this.quizId = quizId;
    }

    public List<String> getQuestions() {
        return questions;
    }

    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    public List<List<String>> getChoices() {
        return choices;
    }

    public void setChoices(List<List<String>> choices) {
        this.choices = choices;
    }

    public List<String> getResponses() {
        return responses;
    }

    public void setResponses(List<String> responses) {
        this.responses = responses;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getStateNames() {
        return stateNames;
    }

    public void setStateNames(List<String> stateNames) {
        this.stateNames = stateNames;
    }

    public QuizType getQuizType() {
        return quizType;
    }

    public void setQuizType(QuizType quizType) {
        this.quizType = quizType;
    }

    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(LocalDateTime timeCreated) {
        this.timeCreated = timeCreated;
    }

    public LocalDateTime getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(LocalDateTime timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    /**
     * Converts the given {@link QuizModel} to a {@link QuizDTO}.
     *
     * @param model The {@link QuizModel} to convert.
     * @return The {@link QuizDTO} representation of the given {@link QuizModel}.
     */
    public static QuizDTO fromModel(QuizModel model) {
        long id = model.getId();
        List<String> questions = new ArrayList<>(model.getQuestions());
        List<List<String>> choices = new ArrayList<>(model.getChoices());
        List<String> responses = new ArrayList<>(model.getResponses());
        List<String> answers = new ArrayList<>(model.getAnswers());
        List<String> stateNames = new ArrayList<>(model.getStateNames());
        return new QuizDTO(id, model.getQuizType(), questions, choices, responses, answers,
                stateNames, model.getTimeCreated(), model.getTimeUpdated());
    }

    /**
     * Converts this DTO to a {@link QuizModel}.
     *
     * @return The {@link QuizModel} representation of this DTO.
     */
    public QuizModel toModel() {
        QuizModel model = new QuizModel();
        model.setId(quizId);
        model.setQuizType(quizType);
        model.setQuestions(new ArrayList<>(questions));
        model.setChoices(new ArrayList<>(choices));
        model.setResponses(new ArrayList<>(responses));
        model.setAnswers(new ArrayList<>(answers));
        model.setStateNames(new ArrayList<>(stateNames));
        model.setTimeCreated(timeCreated);
        model.setTimeUpdated(timeUpdated);
        return model;
    }

    /**
     * Sets the response for the question at the given index.
     *
     * @param index    The index of the question to set the response for.
     * @param response The response to set.
     */
    public void setResponse(int index, String response) {
        responses.set(index, response);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof QuizDTO q && quizId == q.quizId && quizType == q.quizType && Objects.equals(questions, q.questions) && Objects.equals(choices, q.choices) && Objects.equals(responses, q.responses) && Objects.equals(answers, q.answers) && Objects.equals(stateNames, q.stateNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quizId, quizType, questions, choices, responses, answers, stateNames);
    }

    @NonNull
    @Override
    public String toString() {
        return "QuizDTO{" + "quizId=" + quizId + ", quizType=" + quizType + ", questions=" +
                questions + ", choices=" + choices + ", responses=" + responses + ", answers=" +
                answers + ", stateNames=" + stateNames + '}';
    }
}


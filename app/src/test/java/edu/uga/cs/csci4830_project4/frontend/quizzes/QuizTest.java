package edu.uga.cs.csci4830_project4.frontend.quizzes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import static edu.uga.cs.csci4830_project4.common.CommonUtilMethods.stringToDate;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.uga.cs.csci4830_project4.common.QuizType;
import edu.uga.cs.csci4830_project4.frontend.dto.QuizDTO;

public class QuizTest {

    private static final String TIME_CREATED = "2023-10-30 12:00";
    private static final String TIME_UPDATED = "2023-10-31 05:00";

    private Quiz quiz;
    private QuizDTO quizDTO;

    @Before
    public void setUp() {
        // Prepare test data
        long quizId = 1L;
        List<String> questions = new ArrayList<>();
        questions.add("Question 1");
        questions.add("Question 2");

        List<List<String>> choices = new ArrayList<>();
        choices.add(new ArrayList<>());
        choices.add(new ArrayList<>());

        List<String> responses = new ArrayList<>();
        responses.add("");
        responses.add("");

        List<String> answers = new ArrayList<>();
        answers.add("Answer1");
        answers.add("Answer2");

        List<String> stateNames = new ArrayList<>();
        stateNames.add("State1");
        stateNames.add("State2");

        LocalDateTime timeCreated = stringToDate(TIME_CREATED);
        LocalDateTime timeUpdated = stringToDate(TIME_UPDATED);

        quizDTO = new QuizDTO(quizId, QuizType.CAPITALS_QUIZ, questions, choices, responses,
                answers, stateNames, timeCreated, timeUpdated);
        quiz = new Quiz(quizDTO);
    }

    @Test
    public void testGetQuizDTO() {
        QuizDTO retrievedQuizDTO = quiz.getQuizDTO();
        assertNotNull(retrievedQuizDTO);
        assertEquals(quizDTO, retrievedQuizDTO);
    }

    @Test
    public void testGetQuestionAt() {
        String question1 = quiz.getQuestionAt(0);
        assertEquals("Question 1", question1);

        String question2 = quiz.getQuestionAt(1);
        assertEquals("Question 2", question2);
    }

    @Test
    public void testGetChoicesAt() {
        List<String> choices1 = quiz.getChoicesAt(0);
        assertNotNull(choices1);
        assertEquals(0, choices1.size());

        List<String> choices2 = quiz.getChoicesAt(1);
        assertNotNull(choices2);
        assertEquals(0, choices2.size());
    }

    @Test
    public void testSetResponse() {
        quiz.setResponse(0, "Response 1");
        quiz.setResponse(1, "Response 2");

        assertEquals("Response 1", quizDTO.getResponses().get(0));
        assertEquals("Response 2", quizDTO.getResponses().get(1));
    }

    @Test
    public void testGetSizeOfQuiz() {
        int size = quiz.getSizeOfQuiz();
        assertEquals(2, size);
    }
}
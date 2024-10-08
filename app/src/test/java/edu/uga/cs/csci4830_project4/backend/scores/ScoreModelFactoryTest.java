package edu.uga.cs.csci4830_project4.backend.scores;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import edu.uga.cs.csci4830_project4.common.QuizType;

@RunWith(MockitoJUnitRunner.class)
public class ScoreModelFactoryTest {

    private ScoresAccess scoresAccess;
    private ScoreModelFactory scoreModelFactory;

    @Before
    public void setUp() {
        scoresAccess = Mockito.mock(ScoresAccess.class);
        scoreModelFactory = new ScoreModelFactory(scoresAccess);
    }

    @Test
    public void testCreateScoreModel() {
        // Prepare test data
        String scoreValue = "90";

        // Mock behavior for dependencies
        Mockito.when(scoresAccess.store(Mockito.any(ScoreModel.class))).thenAnswer(invocation -> {
            ScoreModel scoreModel = invocation.getArgument(0);
            scoreModel.setId(1L);
            return scoreModel;
        });

        // Call the method to test
        ScoreModelFactory.ScoreModelFactoryParams params =
                new ScoreModelFactory.ScoreModelFactoryParams(scoreValue, QuizType.CAPITALS_QUIZ);
        ScoreModel scoreModel = scoreModelFactory.createAndStore(params);

        // Verify the behavior
        assertNotNull(scoreModel);
        assertEquals(scoreValue, scoreModel.getScore());
        assertEquals(1L, scoreModel.getId());
        assertEquals(QuizType.CAPITALS_QUIZ, scoreModel.getQuizType());
        assertNotNull(scoreModel.getTimeCompleted());
    }
}

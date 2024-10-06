package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringProcessorTest {

    @Test
    void testStrongPassword() {
        var processor = new StringProcessor();
        assertTrue(processor.isStrongPassword("Strong@123"),
                "Password should be considered strong.");
    }

    @Test
    void testCalculateDigits() {
        var processor = new StringProcessor();
        assertEquals(4, processor.calculateDigits("There are 1234 digits."),
                "The sentence contains 4 digits.");
    }

    @Test
    void testCalculateWords() {
        var processor = new StringProcessor();
        assertEquals(5, processor.calculateWords("This is a test sentence."),
                "The sentence contains 5 words.");
    }

    @Test
     void testCalculateExpression() {
        var evaluator = new StringProcessor.ExpressionEvaluator();
        assertEquals(8.0, evaluator.calculateExpression("3 + 5"), 0.01);
        assertEquals(22.0, evaluator.calculateExpression("10 + 2 * 6"), 0.01);
    }

}

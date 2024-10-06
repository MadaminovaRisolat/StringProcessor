StringProcessorTest class:

testStrongPassword():

1.Purpose: Verifies if the isStrongPassword() method correctly identifies a strong password.
2.Test case: Asserts that "Strong@123" meets the conditions for a strong password (contains uppercase, lowercase, digit, and special character).

testCalculateDigits():

1.Purpose: Tests the calculateDigits() method to ensure it counts the number of digits in a sentence.
2.Test case: Verifies that the sentence "There are 1234 digits." correctly returns 4 digits.

testCalculateWords():

1.Purpose: Validates the calculateWords() method, ensuring it accurately counts words in a sentence.
2.Test case: Confirms that the sentence "This is a test sentence." contains 5 words.

testCalculateExpression():

1.Purpose: Tests the calculateExpression() method (via ExpressionEvaluator) for correct evaluation of mathematical expressions.
2.Test cases:
"3 + 5" should return 8.0.
"10 + 2 * 6" should return 22.0.

package org.example;

import java.util.Stack;

public class StringProcessor {

    // Method to check if the password is strong
    public boolean isStrongPassword(String password) {
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Define special characters
        String specialChars = "!@#$%^&*()-+";

        // Iterate through each character in the password
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (specialChars.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }

        // Password is strong if it meets all the conditions
        return hasUppercase && hasLowercase && hasDigit && hasSpecialChar;
    }

    // Method to count the number of digits in a sentence
    public int calculateDigits(String sentence) {
        int count = 0;
        // Iterate through each character in the sentence
        for (char c : sentence.toCharArray()) {
            // If the character is a digit, increment the count
            if (Character.isDigit(c)) {
                count++;
            }
        }
        return count;
    }

    // Method to count the number of words in a sentence
    public int calculateWords(String sentence) {
        // Split the sentence by spaces and count the words
        String[] words = sentence.trim().split("\\s+");
        return (words.length == 1 && words[0].isEmpty()) ? 0 : words.length;
    }

    // Inner class to evaluate expressions
    public static class ExpressionEvaluator {
        private int index;

        public double calculateExpression(String expression) {
            index = 0;
            return evaluate(expression);
        }

        private double evaluate(String expression) {
            Stack<Double> values = new Stack<>();
            Stack<Character> operators = new Stack<>();

            while (index < expression.length()) {
                char ch = expression.charAt(index);

                if (ch == ' ') {
                    index++;
                    continue;
                }

                if (Character.isDigit(ch) || ch == '.') {
                    StringBuilder number = new StringBuilder();
                    while (index < expression.length() && (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
                        number.append(expression.charAt(index++));
                    }
                    values.push(Double.parseDouble(number.toString()));
                } else if (ch == '(') {
                    index++; // Move past '('
                    values.push(evaluate(expression)); // Recursively evaluate the expression inside the parentheses
                } else if (ch == ')') {
                    index++; // Move past ')'
                    break; // End of the current expression
                } else if (isOperator(ch)) {
                    while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                        values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                    }
                    operators.push(ch);
                    index++; // Move to the next character
                }
            }

            while (!operators.isEmpty()) {
                values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
            }

            return values.pop();
        }

        private boolean isOperator(char ch) {
            return ch == '+' || ch == '-' || ch == '*' || ch == '/';
        }

        private int precedence(char operator) {
            return (operator == '+' || operator == '-') ? 1 : 2;
        }

        private double applyOperator(char operator, double b, double a) {
            return switch (operator) {
                case '+' -> a + b;
                case '-' -> a - b;
                case '*' -> a * b;
                case '/' -> a / b;
                default -> throw new UnsupportedOperationException("Operator not supported: " + operator);
            };
        }
    }
}

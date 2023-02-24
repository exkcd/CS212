/*
 * Write a program SentenceReverser that reverses the words in a sentence by reading words into a Stack until you find a period.
 * Your program should then pop off the words from the stack.  Begin your reverse sentence with a capital letter and end it with a period.
 * Your program should be able to handle multiple sentences.  Use while (scan.hasNext()) to capture your input.
 * Please no spaces before the period. Also, the first letter of your sentences should start in the upper case.
 *
 * R Stone
 */

import java.util.*;

public class reverseSentence {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Type a sentence and I'll reverse the order of the words:");
        String input = in.nextLine();

        reverse(input);
    }

    static void reverse(String input) {
        String[] sentences = input.split("\\.");


        for (String sentence : sentences) {
            Stack<String> stack = new Stack<>();
            String[] words = sentence.trim().split("\\s+");

            for (String word : words) {
                stack.push(word);
            }

            String reversed = "";


            while (!stack.isEmpty()) {
                String word = stack.pop();
                String firstLetter = word.substring(0, 1);
                String remaningLetters = word.substring(1);
                reversed += firstLetter.toLowerCase() + remaningLetters + " ";
            }

            reversed = reversed.trim();

            reversed = Character.toUpperCase(reversed.charAt(0)) + reversed.substring(1) + ". ";

            System.out.print(reversed);
        }
    }
}
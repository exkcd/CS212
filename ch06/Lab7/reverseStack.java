/*
 * Write a program using the java.util.Stack data structure that prompts for an integer and reverses it: 7359 becomes 9537.
 *
 * R Stone
 */

import java.util.*;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        Scanner in = new Scanner(System.in);

        System.out.print("Write down a number and I'll reverse the order of the digits: ");
        int num = in.nextInt();

        while (num != 0) {
            int digit = num % 10;
            stack.push(digit);
            num = num / 10;
        }

        System.out.println("Stacked elements are: " + stack);

        Stack<Integer> revStack = new Stack<>();

        int rev_num = 0;

        int power = 0;

        while (!stack.isEmpty()) {
            int digit = stack.pop();
            revStack.push(digit);
            rev_num = rev_num + digit * (int) Math.pow(10, power);
            power++;
        }

        System.out.println("Reversed stack: " + revStack);
        System.out.println("Reversed number: " + rev_num);
    }
}

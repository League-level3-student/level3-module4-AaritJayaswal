package _00_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
    public static void main(String[] args) {
        // 1. Create a Stack of Doubles
        //    Don't forget to import the Stack class
Stack<Double> numbers = new Stack<Double>();
        // 2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
Random ran = new Random();
for (int i = 0; i < 100; i++) {
	double rand = ran.nextInt();
	numbers.push(rand);
}
        // 3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
String input1 = JOptionPane.showInputDialog("Choose A Number Between 0 And 100");
String input2 = JOptionPane.showInputDialog("Choose A Different Number Between 0 And 100");
int num1 = Integer.parseInt(input1);
int num2 = Integer.parseInt(input2);
        // 4. Pop all the elements off of the Stack. Every time a double is popped that is
        //    between the two numbers entered by the user, print it to the screen.

while(! numbers.isEmpty()) {
	System.out.println(numbers.pop());
}

        // EXAMPLE:
        // NUM 1: 65
        // NUM 2: 75

        // Popping elements off stack...
        // Elements between 65 and 75:
        // 66.66876846
        // 74.51651681
        // 70.05110654
        // 69.21350456
        // 71.54506465
        // 66.47984807
        // 74.12121224
    }
}

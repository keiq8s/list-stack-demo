import java.util.*;

public class Main {
    public static void main(String[] args) {
        String str_1 = "AaBbCcDd";

        List<Character> li_1 = new ArrayList<>();
        List<Character> li_2 = new ArrayList<>();

        Deque<Character> stack_1 = new ArrayDeque<>();
        Deque<Character> stack_2 = new ArrayDeque<>();

        for (char letter : str_1.toCharArray()) {
            if (Character.isUpperCase(letter)) {
                li_1.add(letter);
                stack_1.push(letter);
            } else {
                li_2.add(letter);
                stack_2.push(letter);
            }
        }

        for (char c : li_1) System.out.print(c + " ");
        System.out.println("\n");

        for (char c : li_2) System.out.print(c + " ");
        System.out.println("\n");

        while (!stack_1.isEmpty()) {
            System.out.print(stack_1.pop() + " ");
        }
        System.out.println("\n");

        while (!stack_2.isEmpty()) {
            System.out.print(stack_2.pop() + " ");
        }
        System.out.println();
    }
}

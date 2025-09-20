import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // Реализация списка на языке Java
        ArrayList<Integer> li = new ArrayList<>();

        li.add(1);
        li.add(2);
        li.add(3);

        System.out.println(li.get(1)); // должно вывести 2, то есть можно получить доступ не только к последнему элементу в отличие от стэка

        // Реализация стека на языке Java
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Кол-во до удаления: " + stack.size());
        System.out.println(stack.pop()); // должно вывести 3 а также кол-во элементов должно стать равным двум
        System.out.println("Кол-во после удаления: " + stack.size());
    }
}

package Easytasks;

public class Main {
    public static void main(String[] args) {
        Cards cards = new Cards();
        Cards.Bubble bubble = cards.new Bubble(5);

        bubble.into(34);
        bubble.into(12);
        bubble.into(45);
        bubble.into(8);
        bubble.into(19);
        System.out.println("Before sorting:");
        bubble.printer();
        bubble.bubbleSorter();
        System.out.println("\nAfter sorting:");
        bubble.printer();
    }
}

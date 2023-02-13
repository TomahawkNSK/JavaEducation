import java.util.Scanner;

class App {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.printf("%s", "Hello world! (C way)\n");

        /*System.out.println("Enter the text, please...");
        Scanner in = new Scanner(System.in);
        String tmp1 = in.nextLine();
        System.out.println("Result: " + tmp1);*/

        /*Integer a = Integer.valueOf(5);
        Integer b = Integer.valueOf("10");
        System.out.println(a + b);*/

        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.SIZE);
        //System.out.println(Double.MAX_VALUE);

        Scanner in = new Scanner(System.in);
        Integer a = Integer.valueOf(in.nextLine());
        Integer b = Integer.valueOf(in.nextLine());
        String op = in.nextLine();

        switch (op) {
            case "+":
                System.out.println(a + b);
                break;
            case "-":
                System.out.println(a - b);
                break;
            default:
                System.out.println(a * b);
                break;
        }

    }
}
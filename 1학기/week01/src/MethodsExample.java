public class MethodsExample {

    public static void main(String[] args) {
        int remainder = remainderOf(3, 2);
        System.out.println(remainder);

        printNumber(10);
        System.out.println(greeting());
        printGreeting();
    }

    // 입력과 반환값이 모두 있는 메서드
    private static int remainderOf(int dividend, int divisor) {
        return dividend % divisor;
    }

    // 입력은 받지만 결과를 반환하지 않는 메서드
    private static void printNumber(int number) {
        System.out.println(number);
    }

    // 입력 없이 결과를 반환하는 메서드
    private static String greeting() {
        return "Hello!";
    }

    // 입력도 반환값도 없는 메서드
    private static void printGreeting() {
        System.out.println(greeting());
    }
}

public class MethodsExample {
    public static void main(String[] args) {
        int mod_result = mod(3, 2);
        System.out.println(mod_result);
    }
    
    static int mod (int a, int b) {
        int result =  a % b;
        return result;
    }

    void printNum (int a){
        System.out.println(a);
    }

    static String greeting(){
        return "Hello!";
    }

    void greeting_2(){
        System.out.println("Hello!");
    }
}
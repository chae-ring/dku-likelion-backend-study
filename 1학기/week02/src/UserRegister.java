import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserRegister {

    private static final String YES = "y";
    private static final String NO = "n";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Map<String, String>> users = new ArrayList<>();

            System.out.println("=== 회원 등록 ===");
            while (askToContinue(scanner, "회원가입을 진행할까요? (y/n): ")) {
                Map<String, String> user = readUser(scanner);
                users.add(user);
                printWelcome(user);
            }

            System.out.println("회원가입을 종료합니다. 등록된 회원 수: " + users.size());
        }
    }

    private static Map<String, String> readUser(Scanner scanner) {
        Map<String, String> user = new HashMap<>();
        user.put("username", readRequiredValue(scanner, "아이디: "));
        user.put("password", readMatchingPassword(scanner));
        user.put("name", readRequiredValue(scanner, "이름: "));
        user.put("birthDate", readBirthDate(scanner));
        user.put("email", readRequiredValue(scanner, "이메일: "));
        return user;
    }

    private static String readRequiredValue(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("값을 비워둘 수 없습니다.");
        }
    }

    private static String readMatchingPassword(Scanner scanner) {
        while (true) {
            String password = readRequiredValue(scanner, "비밀번호: ");
            String confirmation = readRequiredValue(scanner, "비밀번호 확인: ");
            if (password.equals(confirmation)) {
                return password;
            }
            System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해주세요.");
        }
    }

    private static String readBirthDate(Scanner scanner) {
        while (true) {
            System.out.print("생년월일 6자리: ");
            String birthDate = scanner.nextLine().trim();
            if (birthDate.matches("\\d{6}")) {
                return birthDate;
            }
            System.out.println("생년월일은 숫자 6자리로 입력해주세요.");
        }
    }

    private static boolean askToContinue(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String answer = scanner.nextLine().trim();
            if (YES.equalsIgnoreCase(answer)) {
                return true;
            }
            if (NO.equalsIgnoreCase(answer)) {
                return false;
            }
            System.out.println("y 또는 n으로 입력해주세요.");
        }
    }

    private static void printWelcome(Map<String, String> user) {
        System.out.printf("%s님, 가입을 환영합니다. (ID: %s)%n",
                user.get("name"), user.get("username"));
    }
}

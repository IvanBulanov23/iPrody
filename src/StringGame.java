import java.util.Random;
import java.util.Scanner;

public class StringGame {
    public StringGame() {
    }

    private static final String[] strGame = {"apple", "leak",
            "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi",
            "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
            "pineapple", "pumpkin", "potato"};

    public static void startGame() {

        System.out.println("You wanna play? Let`s play!\n" + "Введите слово");
        int index = new Random().nextInt(strGame.length);
        String slovo = strGame[index];
//        System.out.println(slovo); // для проверки рандомного слова
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String scan = scanner.nextLine();
            sravnenye(scan, slovo);
            if (!scan.equals(slovo)) {
                System.out.println("\nУпс. Не угадали. Пробуем ещё раз");
            } else {
                System.out.println("\nПоздравляю, вы угадали задуманное слово " + scan);
                break;
            }
        }
        scanner.close();
    }

    public static void sravnenye(String scan, String slovo) {
        int minLength = Math.min(scan.length(), slovo.length());

        for (int i = 0; i < minLength; i++) {
            if (scan.charAt(i) == slovo.charAt(i)) {
                System.out.print(scan.charAt(i));
            } else {
                System.out.print("#");
            }
        }
        if (!scan.equals(slovo)) {
            System.out.print("#".repeat(14));
        }
    }
}
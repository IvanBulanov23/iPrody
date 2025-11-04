// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int count = findSymbolOccurance("Helo moto", 'o');
        System.out.println(count);
        int value = findWordPosition("Apollo", "polla");
        System.out.println(value);
        stringReverse("Hello");
        System.out.println(isPalindrome("ohg3gho"));
        StringGame.startGame();
    }

    public static int findSymbolOccurance(String str, char chr) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == chr)
                count++;

        }
        return count;

    }

    public static int findWordPosition(String source, String target) {
        if (source.contains(target))
            return 1;
        else return -1;

    }

    public static void stringReverse(String stringBuilder) {
        StringBuilder strb = new StringBuilder(stringBuilder);
        strb.reverse().toString();
        System.out.println(strb);
    }


    public static boolean isPalindrome(String strb) {
        int length = strb.length();
        for (int i = 0; i < length / 2; i++) {
            if (strb.charAt(i) != strb.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
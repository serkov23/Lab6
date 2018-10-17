package lab2;

public class Main {
    private static boolean isDigitOrDot(char c) {
        return Character.isDigit(c) || (c == '.');
    }

    private static String parse(String str) {
        StringBuilder strBuf = new StringBuilder('#' + str);
        for (int i = 0; i < strBuf.length() - 2; i++) {
            if (strBuf.charAt(i + 1) == '0' && !isDigitOrDot(strBuf.charAt(i)) && Character.isDigit(strBuf.charAt(i + 2))) {
                strBuf.deleteCharAt(i + 1);
                i--;
            }
        }
        return strBuf.substring(1);
    }

    private static String parse2(String str) {
        return (str).replaceAll("(^|[^0.])(0+)(\\d+\\.?\\d*)", "$1$3");
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("N " + i + " = \"" + args[i] + '\"');
            System.out.println("Answer: \"" + parse2(args[i]) + '\"');
        }
    }
}

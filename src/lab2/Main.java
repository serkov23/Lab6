package lab2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static boolean isDigitOrDot(char c){
        return Character.isDigit(c)||(c=='.');
    }
    private static String parse(String str) {
        StringBuilder strBuf = new StringBuilder('#'+str);
        for (int i = 0; i < strBuf.length() - 2; i++) {
            if (strBuf.charAt(i + 1) == '0' && !isDigitOrDot(strBuf.charAt(i)) && Character.isDigit(strBuf.charAt(i + 2))) {
                strBuf.deleteCharAt(i + 1);
                i--;
            }
        }
        return strBuf.substring(1);
    }
//    private static String parse1(String str){
//        StringBuilder stringBuilder=new StringBuilder(str);
//        Pattern pattern=Pattern.compile("((0+)\\d+\\.?\\d*)");
//        Matcher  m = pattern.matcher(stringBuilder);
//        while (m.find()){
//            Matcher bufm=pattern.matcher(stringBuilder.substring(m.end(1)));
//            stringBuilder.delete(m.start(2),m.end(2));
//            m=bufm;
//        }
//        return new String(stringBuilder);
//    }
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("N " + i + " = \"" + args[i] + '\"');
            System.out.println(parse(args[i]));
        }
    }
}

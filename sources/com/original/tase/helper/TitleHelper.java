package com.original.tase.helper;

import com.original.tase.Logger;
import java.text.Normalizer;

public class TitleHelper {
    public static String a(String str) {
        return b(str);
    }

    public static String b(String str) {
        try {
            str = Normalizer.normalize(str, Normalizer.Form.NFKD);
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
        }
        try {
            str = str.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        } catch (Throwable th2) {
            Logger.d(th2, new boolean[0]);
        }
        return str.replace("&quot;", "\"").replace("&amp;", "&").replace("‘", "'").replace("’", "'").replace("`", "'").replace("´", "'").replace("“", "\"").replace("”", "\"");
    }

    public static String c(String str) {
        return b(str).replace(" (UK)", "").replace(" (US)", "").replace(" US", "").replace("The Americans (2013)", "The Americans").replace("Once Upon a Time (2011)", "Once Upon a Time").replace("Castle (2009)", "Castle").replace("Scandal (2012)", "Scandal").replace("National Geographic: ", "").replace("National Geographic:", "").replace("The Late Show with Stephen Colbert", "Late Show with Stephen Colbert");
    }

    public static String d(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        String b2 = b(str);
        if (str.endsWith(" ") || str.endsWith(".")) {
            b2 = str.substring(0, str.length() - 1);
        }
        if (str.startsWith(" ")) {
            b2 = str.substring(1, str.length());
        }
        return b2.replace("\"", "").replace("'", "").replace("*", "").replace("?", "").replace("!", "").replace("%", "").replace("/", "").replace("\\", "").replace("·", "-").replace(". ", "-").replace(" .", "-").replace(".", "-").replace(", ", "-").replace(" ,", "-").replace(",", "-").replace(": ", "-").replace(" :", "-").replace(":", "-").replace(" ", "-").replaceAll("--+", "-");
    }

    public static String e(String str) {
        return b(c(a(str))).replace(" ! ", "").replace(" !", "").replace("! ", "").replace("!", "").replace(" ? ", "").replace(" ?", "").replace("? ", "").replace("?", "").replace(" # ", "").replace(" #", "").replace("# ", "").replace("#", "").replace(" / ", "").replace("/ ", "").replace(" /", "").replace("/", "").replace(" % ", "").replace("% ", "").replace(" %", "").replace("%", "").replace(" & ", " ").replace("& ", " ").replace(" &", " ").replace("&", " ");
    }

    public static String f(String str) {
        return b(str).replaceAll("\n|([\\[].+?[\\]])|([\\(].+?[\\)])|\\s(vs|v[.])\\s|(:|;|-|–|\"|,|·|'|_|\\.|\\?|!)|\\s", "").toLowerCase();
    }

    public static String g(String str) {
        return d(str).toLowerCase();
    }

    public static String h(String str, String str2) {
        return str.replaceAll("([ .-](?:and|AND|And|&)[ .-])", " ").replace("'", "").replaceAll("(\\\\|\\/| -|:|\\(|\\)|;|-|\\.|\\*|\\?|\"|\\'|<|>|,)", " ").replace("  ", " ").replace(" ", str2);
    }
}

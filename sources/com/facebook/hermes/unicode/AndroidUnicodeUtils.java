package com.facebook.hermes.unicode;

import com.facebook.proguard.annotations.DoNotStrip;
import java.text.Collator;
import java.text.DateFormat;
import java.text.Normalizer;
import java.util.Locale;

@DoNotStrip
public class AndroidUnicodeUtils {
    @DoNotStrip
    public static String convertToCase(String str, int i2, boolean z2) {
        Locale locale;
        if (z2) {
            locale = Locale.getDefault();
        } else {
            locale = Locale.ENGLISH;
        }
        if (i2 == 0) {
            return str.toUpperCase(locale);
        }
        if (i2 == 1) {
            return str.toLowerCase(locale);
        }
        throw new RuntimeException("Invalid target case");
    }

    @DoNotStrip
    public static String dateFormat(double d2, boolean z2, boolean z3) {
        DateFormat dateFormat;
        if (z2 && z3) {
            dateFormat = DateFormat.getDateTimeInstance(2, 2);
        } else if (z2) {
            dateFormat = DateFormat.getDateInstance(2);
        } else if (z3) {
            dateFormat = DateFormat.getTimeInstance(2);
        } else {
            throw new RuntimeException("Bad dateFormat configuration");
        }
        return dateFormat.format(Long.valueOf((long) d2)).toString();
    }

    @DoNotStrip
    public static int localeCompare(String str, String str2) {
        return Collator.getInstance().compare(str, str2);
    }

    @DoNotStrip
    public static String normalize(String str, int i2) {
        if (i2 == 0) {
            return Normalizer.normalize(str, Normalizer.Form.NFC);
        }
        if (i2 == 1) {
            return Normalizer.normalize(str, Normalizer.Form.NFD);
        }
        if (i2 == 2) {
            return Normalizer.normalize(str, Normalizer.Form.NFKC);
        }
        if (i2 == 3) {
            return Normalizer.normalize(str, Normalizer.Form.NFKD);
        }
        throw new RuntimeException("Invalid form");
    }
}

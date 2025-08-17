package kotlin.text;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

public final class _OneToManyTitlecaseMappingsKt {
    public static final String a(char c2) {
        String valueOf = String.valueOf(c2);
        Intrinsics.d(valueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        Intrinsics.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c2));
        }
        if (c2 == 329) {
            return upperCase;
        }
        char charAt = upperCase.charAt(0);
        Intrinsics.d(upperCase, "null cannot be cast to non-null type java.lang.String");
        String substring = upperCase.substring(1);
        Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
        Intrinsics.d(substring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return charAt + lowerCase;
    }
}

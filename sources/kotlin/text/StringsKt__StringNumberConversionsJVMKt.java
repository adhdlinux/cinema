package kotlin.text;

import kotlin.jvm.internal.Intrinsics;

class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public static Double i(String str) {
        Intrinsics.f(str, "<this>");
        try {
            if (ScreenFloatValueRegEx.f40558b.g(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }
}

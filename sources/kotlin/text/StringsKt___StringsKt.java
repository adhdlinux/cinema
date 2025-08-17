package kotlin.text;

import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.SlidingWindowKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static List<String> Q0(CharSequence charSequence, int i2) {
        Intrinsics.f(charSequence, "<this>");
        return Z0(charSequence, i2, i2, true);
    }

    public static String R0(String str, int i2) {
        boolean z2;
        Intrinsics.f(str, "<this>");
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            String substring = str.substring(RangesKt___RangesKt.d(i2, str.length()));
            Intrinsics.e(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static char S0(CharSequence charSequence) {
        boolean z2;
        Intrinsics.f(charSequence, "<this>");
        if (charSequence.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return charSequence.charAt(StringsKt__StringsKt.Q(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static CharSequence T0(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        StringBuilder reverse = new StringBuilder(charSequence).reverse();
        Intrinsics.e(reverse, "StringBuilder(this).reverse()");
        return reverse;
    }

    public static char U0(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        } else if (length == 1) {
            return charSequence.charAt(0);
        } else {
            throw new IllegalArgumentException("Char sequence has more than one element.");
        }
    }

    public static String V0(String str, int i2) {
        boolean z2;
        Intrinsics.f(str, "<this>");
        if (i2 >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            String substring = str.substring(0, RangesKt___RangesKt.d(i2, str.length()));
            Intrinsics.e(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final <C extends Collection<? super Character>> C W0(CharSequence charSequence, C c2) {
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(c2, "destination");
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            c2.add(Character.valueOf(charSequence.charAt(i2)));
        }
        return c2;
    }

    public static List<Character> X0(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            return CollectionsKt__CollectionsKt.f();
        }
        if (length != 1) {
            return Y0(charSequence);
        }
        return CollectionsKt__CollectionsJVMKt.b(Character.valueOf(charSequence.charAt(0)));
    }

    public static final List<Character> Y0(CharSequence charSequence) {
        Intrinsics.f(charSequence, "<this>");
        return (List) W0(charSequence, new ArrayList(charSequence.length()));
    }

    public static final List<String> Z0(CharSequence charSequence, int i2, int i3, boolean z2) {
        Intrinsics.f(charSequence, "<this>");
        return a1(charSequence, i2, i3, z2, StringsKt___StringsKt$windowed$1.f40566f);
    }

    public static final <R> List<R> a1(CharSequence charSequence, int i2, int i3, boolean z2, Function1<? super CharSequence, ? extends R> function1) {
        int i4;
        boolean z3;
        Intrinsics.f(charSequence, "<this>");
        Intrinsics.f(function1, ViewProps.TRANSFORM);
        SlidingWindowKt.a(i2, i3);
        int length = charSequence.length();
        int i5 = length / i3;
        if (length % i3 == 0) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        ArrayList arrayList = new ArrayList(i5 + i4);
        int i6 = 0;
        while (true) {
            if (i6 < 0 || i6 >= length) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (!z3) {
                break;
            }
            int i7 = i6 + i2;
            if (i7 < 0 || i7 > length) {
                if (!z2) {
                    break;
                }
                i7 = length;
            }
            arrayList.add(function1.invoke(charSequence.subSequence(i6, i7)));
            i6 += i3;
        }
        return arrayList;
    }
}

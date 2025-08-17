package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1<String, String> b(String str) {
        boolean z2;
        if (str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return StringsKt__IndentKt$getIndentFunction$1.f40559f;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    private static final int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (!CharsKt__CharJVMKt.c(str.charAt(i2))) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 == -1) {
            return str.length();
        }
        return i2;
    }

    public static final String d(String str, String str2) {
        int i2;
        String invoke;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "newIndent");
        List<String> e02 = StringsKt__StringsKt.e0(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (Object next : e02) {
            if (!StringsKt__StringsJVMKt.v((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.p(arrayList, 10));
        for (String c2 : arrayList) {
            arrayList2.add(Integer.valueOf(c(c2)));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.M(arrayList2);
        int i3 = 0;
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        int length = str.length() + (str2.length() * e02.size());
        Function1<String, String> b2 = b(str2);
        int h2 = CollectionsKt__CollectionsKt.h(e02);
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : e02) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.o();
            }
            String str3 = (String) next2;
            if ((i3 == 0 || i3 == h2) && StringsKt__StringsJVMKt.v(str3)) {
                str3 = null;
            } else {
                String R0 = StringsKt___StringsKt.R0(str3, i2);
                if (!(R0 == null || (invoke = b2.invoke(R0)) == null)) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i3 = i4;
        }
        String sb = ((StringBuilder) CollectionsKt___CollectionsKt.H(arrayList3, new StringBuilder(length), ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.e(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static final String e(String str, String str2, String str3) {
        int i2;
        String invoke;
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "newIndent");
        Intrinsics.f(str3, "marginPrefix");
        if (!StringsKt__StringsJVMKt.v(str3)) {
            List<String> e02 = StringsKt__StringsKt.e0(str);
            int length = str.length() + (str2.length() * e02.size());
            Function1<String, String> b2 = b(str2);
            int h2 = CollectionsKt__CollectionsKt.h(e02);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (Object next : e02) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.o();
                }
                String str4 = (String) next;
                String str5 = null;
                if ((i3 == 0 || i3 == h2) && StringsKt__StringsJVMKt.v(str4)) {
                    str4 = null;
                } else {
                    int length2 = str4.length();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            i2 = -1;
                            break;
                        } else if (!CharsKt__CharJVMKt.c(str4.charAt(i5))) {
                            i2 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (i2 != -1) {
                        int i6 = i2;
                        if (StringsKt__StringsJVMKt.F(str4, str3, i2, false, 4, (Object) null)) {
                            Intrinsics.d(str4, "null cannot be cast to non-null type java.lang.String");
                            str5 = str4.substring(i6 + str3.length());
                            Intrinsics.e(str5, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (!(str5 == null || (invoke = b2.invoke(str5)) == null)) {
                        str4 = invoke;
                    }
                }
                if (str4 != null) {
                    arrayList.add(str4);
                }
                i3 = i4;
            }
            String sb = ((StringBuilder) CollectionsKt___CollectionsKt.H(arrayList, new StringBuilder(length), ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
            Intrinsics.e(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static String f(String str) {
        Intrinsics.f(str, "<this>");
        return d(str, "");
    }

    public static final String g(String str, String str2) {
        Intrinsics.f(str, "<this>");
        Intrinsics.f(str2, "marginPrefix");
        return e(str, "", str2);
    }

    public static /* synthetic */ String h(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "|";
        }
        return g(str, str2);
    }
}

package com.original.tase.helper.js;

import com.original.tase.Logger;
import com.original.tase.utils.Regex;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

public final class HunterPacker {
    public static final HunterPacker INSTANCE = new HunterPacker();

    private HunterPacker() {
    }

    private final int duf(String str, int i2, int i3) {
        int i4 = i2;
        int i5 = i3;
        Iterable X0 = StringsKt___StringsKt.X0("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ+/");
        List U = CollectionsKt___CollectionsKt.U(X0, i4);
        List U2 = CollectionsKt___CollectionsKt.U(X0, i5);
        double d2 = 0.0d;
        int i6 = 0;
        for (Character charValue : StringsKt___StringsKt.X0(StringsKt___StringsKt.T0(str).toString())) {
            int i7 = i6 + 1;
            char charValue2 = charValue.charValue();
            if (U.contains(Character.valueOf(charValue2))) {
                d2 += ((double) U.indexOf(Character.valueOf(charValue2))) * Math.pow((double) i4, (double) i6);
            }
            i6 = i7;
        }
        String str2 = "";
        while (d2 > 0.0d) {
            double d3 = (double) i5;
            double d4 = d2 % d3;
            str2 = ((Character) U2.get((int) d4)).charValue() + str2;
            d2 = (d2 - d4) / d3;
        }
        Integer k2 = StringsKt__StringNumberConversionsKt.k(str2);
        if (k2 != null) {
            return k2.intValue();
        }
        return 0;
    }

    static /* synthetic */ int duf$default(HunterPacker hunterPacker, String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 10;
        }
        return hunterPacker.duf(str, i2, i3);
    }

    private final String hunter(String str, String str2, int i2, int i3) {
        String str3 = str;
        String str4 = str2;
        String str5 = "";
        int i4 = 0;
        while (i4 < str.length()) {
            String str6 = "";
            while (str3.charAt(i4) != str4.charAt(i3)) {
                str6 = str6 + str3.charAt(i4);
                i4++;
            }
            String str7 = str6;
            for (int i5 = 0; i5 < str2.length(); i5++) {
                str7 = StringsKt__StringsJVMKt.B(str7, str4.charAt(i5), CharsKt__CharKt.d(i5), false, 4, (Object) null);
            }
            str5 = str5 + ((char) (duf$default(this, str7, i3, 0, 4, (Object) null) - i2));
            i4++;
        }
        return str5;
    }

    public final String decodesource(String str) {
        boolean z2;
        Intrinsics.f(str, "html");
        if (!detect(str)) {
            return null;
        }
        String jSString = getJSString(str);
        if (jSString.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return dehunt(jSString);
        }
        return null;
    }

    public final String dehunt(String str) {
        Intrinsics.f(str, "hunterJS");
        try {
            Matcher matcher = Pattern.compile("\\}\\(\"([^\"]+)\",[^,]+,\\s*\"([^\"]+)\",\\s*(\\d+),\\s*(\\d+)").matcher(str);
            Intrinsics.e(matcher, "matcher(...)");
            if (!matcher.find() || matcher.groupCount() != 4) {
                return null;
            }
            String group = matcher.group(1);
            Intrinsics.c(group);
            String str2 = group.toString();
            String group2 = matcher.group(2);
            Intrinsics.c(group2);
            String str3 = group2.toString();
            String group3 = matcher.group(3);
            Intrinsics.c(group3);
            int parseInt = Integer.parseInt(group3);
            String group4 = matcher.group(4);
            Intrinsics.c(group4);
            return hunter(str2, str3, parseInt, Integer.parseInt(group4));
        } catch (Exception e2) {
            Logger.d(e2, new boolean[0]);
            return null;
        }
    }

    public final boolean detect(String str) {
        Intrinsics.f(str, "hunterJS");
        return Pattern.compile("eval\\(function\\(h,u,n,t,e,r\\)").matcher(str).find();
    }

    public final String getJSString(String str) {
        Intrinsics.f(str, "html");
        String a2 = Regex.a(str, "(eval\\(function\\(h,u,n,t,e,r\\)\\{.*\\}\\(.*\\)\\))", 1);
        Intrinsics.e(a2, "m33107(...)");
        return a2;
    }
}

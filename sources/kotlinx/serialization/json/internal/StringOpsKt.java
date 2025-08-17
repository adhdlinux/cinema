package kotlinx.serialization.json.internal;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;

public final class StringOpsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f41277a;

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f41278b;

    static {
        String[] strArr = new String[93];
        for (int i2 = 0; i2 < 32; i2++) {
            char e2 = e(i2 >> 12);
            char e3 = e(i2 >> 8);
            char e4 = e(i2 >> 4);
            char e5 = e(i2);
            strArr[i2] = "\\u" + e2 + e3 + e4 + e5;
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f41277a = strArr;
        byte[] bArr = new byte[93];
        for (int i3 = 0; i3 < 32; i3++) {
            bArr[i3] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f41278b = bArr;
    }

    public static final byte[] a() {
        return f41278b;
    }

    public static final String[] b() {
        return f41277a;
    }

    public static final void c(StringBuilder sb, String str) {
        Intrinsics.f(sb, "<this>");
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        sb.append('\"');
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            String[] strArr = f41277a;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb.append(str, i2, i3);
                sb.append(strArr[charAt]);
                i2 = i3 + 1;
            }
        }
        if (i2 != 0) {
            sb.append(str, i2, str.length());
        } else {
            sb.append(str);
        }
        sb.append('\"');
    }

    public static final Boolean d(String str) {
        Intrinsics.f(str, "<this>");
        if (StringsKt__StringsJVMKt.t(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (StringsKt__StringsJVMKt.t(str, Constants.CASEFIRST_FALSE, true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final char e(int i2) {
        int i3 = i2 & 15;
        return (char) (i3 < 10 ? i3 + 48 : (i3 - 10) + 97);
    }
}

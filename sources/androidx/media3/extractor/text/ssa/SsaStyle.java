package androidx.media3.extractor.text.ssa;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Ints;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SsaStyle {

    /* renamed from: a  reason: collision with root package name */
    public final String f8988a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8989b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f8990c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f8991d;

    /* renamed from: e  reason: collision with root package name */
    public final float f8992e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8993f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f8994g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f8995h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f8996i;

    /* renamed from: j  reason: collision with root package name */
    public final int f8997j;

    static final class Format {

        /* renamed from: a  reason: collision with root package name */
        public final int f8998a;

        /* renamed from: b  reason: collision with root package name */
        public final int f8999b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9000c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9001d;

        /* renamed from: e  reason: collision with root package name */
        public final int f9002e;

        /* renamed from: f  reason: collision with root package name */
        public final int f9003f;

        /* renamed from: g  reason: collision with root package name */
        public final int f9004g;

        /* renamed from: h  reason: collision with root package name */
        public final int f9005h;

        /* renamed from: i  reason: collision with root package name */
        public final int f9006i;

        /* renamed from: j  reason: collision with root package name */
        public final int f9007j;

        /* renamed from: k  reason: collision with root package name */
        public final int f9008k;

        private Format(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f8998a = i2;
            this.f8999b = i3;
            this.f9000c = i4;
            this.f9001d = i5;
            this.f9002e = i6;
            this.f9003f = i7;
            this.f9004g = i8;
            this.f9005h = i9;
            this.f9006i = i10;
            this.f9007j = i11;
            this.f9008k = i12;
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static androidx.media3.extractor.text.ssa.SsaStyle.Format a(java.lang.String r17) {
            /*
                r0 = 7
                r1 = r17
                java.lang.String r1 = r1.substring(r0)
                java.lang.String r2 = ","
                java.lang.String[] r1 = android.text.TextUtils.split(r1, r2)
                r2 = -1
                r3 = 0
                r4 = 0
                r6 = -1
                r7 = -1
                r8 = -1
                r9 = -1
                r10 = -1
                r11 = -1
                r12 = -1
                r13 = -1
                r14 = -1
                r15 = -1
            L_0x001a:
                int r5 = r1.length
                if (r4 >= r5) goto L_0x00c1
                r5 = r1[r4]
                java.lang.String r5 = r5.trim()
                java.lang.String r5 = com.google.common.base.Ascii.e(r5)
                r5.hashCode()
                int r16 = r5.hashCode()
                switch(r16) {
                    case -1178781136: goto L_0x009b;
                    case -1026963764: goto L_0x0090;
                    case -192095652: goto L_0x0085;
                    case -70925746: goto L_0x007a;
                    case 3029637: goto L_0x006f;
                    case 3373707: goto L_0x0064;
                    case 366554320: goto L_0x0059;
                    case 767321349: goto L_0x004e;
                    case 1767875043: goto L_0x0041;
                    case 1988365454: goto L_0x0034;
                    default: goto L_0x0031;
                }
            L_0x0031:
                r0 = -1
                goto L_0x00a5
            L_0x0034:
                java.lang.String r0 = "outlinecolour"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x003d
                goto L_0x0031
            L_0x003d:
                r0 = 9
                goto L_0x00a5
            L_0x0041:
                java.lang.String r0 = "alignment"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x004a
                goto L_0x0031
            L_0x004a:
                r0 = 8
                goto L_0x00a5
            L_0x004e:
                java.lang.String r0 = "borderstyle"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0057
                goto L_0x0031
            L_0x0057:
                r0 = 7
                goto L_0x00a5
            L_0x0059:
                java.lang.String r0 = "fontsize"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0062
                goto L_0x0031
            L_0x0062:
                r0 = 6
                goto L_0x00a5
            L_0x0064:
                java.lang.String r0 = "name"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x006d
                goto L_0x0031
            L_0x006d:
                r0 = 5
                goto L_0x00a5
            L_0x006f:
                java.lang.String r0 = "bold"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0078
                goto L_0x0031
            L_0x0078:
                r0 = 4
                goto L_0x00a5
            L_0x007a:
                java.lang.String r0 = "primarycolour"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0083
                goto L_0x0031
            L_0x0083:
                r0 = 3
                goto L_0x00a5
            L_0x0085:
                java.lang.String r0 = "strikeout"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x008e
                goto L_0x0031
            L_0x008e:
                r0 = 2
                goto L_0x00a5
            L_0x0090:
                java.lang.String r0 = "underline"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x0099
                goto L_0x0031
            L_0x0099:
                r0 = 1
                goto L_0x00a5
            L_0x009b:
                java.lang.String r0 = "italic"
                boolean r0 = r5.equals(r0)
                if (r0 != 0) goto L_0x00a4
                goto L_0x0031
            L_0x00a4:
                r0 = 0
            L_0x00a5:
                switch(r0) {
                    case 0: goto L_0x00bb;
                    case 1: goto L_0x00b9;
                    case 2: goto L_0x00b7;
                    case 3: goto L_0x00b5;
                    case 4: goto L_0x00b3;
                    case 5: goto L_0x00b1;
                    case 6: goto L_0x00af;
                    case 7: goto L_0x00ad;
                    case 8: goto L_0x00ab;
                    case 9: goto L_0x00a9;
                    default: goto L_0x00a8;
                }
            L_0x00a8:
                goto L_0x00bc
            L_0x00a9:
                r9 = r4
                goto L_0x00bc
            L_0x00ab:
                r7 = r4
                goto L_0x00bc
            L_0x00ad:
                r15 = r4
                goto L_0x00bc
            L_0x00af:
                r10 = r4
                goto L_0x00bc
            L_0x00b1:
                r6 = r4
                goto L_0x00bc
            L_0x00b3:
                r11 = r4
                goto L_0x00bc
            L_0x00b5:
                r8 = r4
                goto L_0x00bc
            L_0x00b7:
                r14 = r4
                goto L_0x00bc
            L_0x00b9:
                r13 = r4
                goto L_0x00bc
            L_0x00bb:
                r12 = r4
            L_0x00bc:
                int r4 = r4 + 1
                r0 = 7
                goto L_0x001a
            L_0x00c1:
                if (r6 == r2) goto L_0x00cd
                androidx.media3.extractor.text.ssa.SsaStyle$Format r0 = new androidx.media3.extractor.text.ssa.SsaStyle$Format
                int r1 = r1.length
                r5 = r0
                r16 = r1
                r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                goto L_0x00ce
            L_0x00cd:
                r0 = 0
            L_0x00ce:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ssa.SsaStyle.Format.a(java.lang.String):androidx.media3.extractor.text.ssa.SsaStyle$Format");
        }
    }

    static final class Overrides {

        /* renamed from: c  reason: collision with root package name */
        private static final Pattern f9009c = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: d  reason: collision with root package name */
        private static final Pattern f9010d = Pattern.compile(Util.G("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: e  reason: collision with root package name */
        private static final Pattern f9011e = Pattern.compile(Util.G("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: f  reason: collision with root package name */
        private static final Pattern f9012f = Pattern.compile("\\\\an(\\d+)");

        /* renamed from: a  reason: collision with root package name */
        public final int f9013a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f9014b;

        private Overrides(int i2, PointF pointF) {
            this.f9013a = i2;
            this.f9014b = pointF;
        }

        private static int a(String str) {
            Matcher matcher = f9012f.matcher(str);
            if (matcher.find()) {
                return SsaStyle.e((String) Assertions.f(matcher.group(1)));
            }
            return -1;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|(1:7)|8|9|(2:11|18)(1:17)|15|1) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0021 */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0027  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0009 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static androidx.media3.extractor.text.ssa.SsaStyle.Overrides b(java.lang.String r5) {
            /*
                java.util.regex.Pattern r0 = f9009c
                java.util.regex.Matcher r5 = r0.matcher(r5)
                r0 = -1
                r1 = 0
                r2 = -1
            L_0x0009:
                boolean r3 = r5.find()
                if (r3 == 0) goto L_0x002b
                r3 = 1
                java.lang.String r3 = r5.group(r3)
                java.lang.Object r3 = androidx.media3.common.util.Assertions.f(r3)
                java.lang.String r3 = (java.lang.String) r3
                android.graphics.PointF r4 = c(r3)     // Catch:{ RuntimeException -> 0x0021 }
                if (r4 == 0) goto L_0x0021
                r1 = r4
            L_0x0021:
                int r3 = a(r3)     // Catch:{ RuntimeException -> 0x0029 }
                if (r3 == r0) goto L_0x0009
                r2 = r3
                goto L_0x0009
            L_0x0029:
                goto L_0x0009
            L_0x002b:
                androidx.media3.extractor.text.ssa.SsaStyle$Overrides r5 = new androidx.media3.extractor.text.ssa.SsaStyle$Overrides
                r5.<init>(r2, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.ssa.SsaStyle.Overrides.b(java.lang.String):androidx.media3.extractor.text.ssa.SsaStyle$Overrides");
        }

        private static PointF c(String str) {
            String str2;
            String str3;
            Matcher matcher = f9010d.matcher(str);
            Matcher matcher2 = f9011e.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    Log.f("SsaStyle.Overrides", "Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='" + str + "'");
                }
                str2 = matcher.group(1);
                str3 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                str2 = matcher2.group(1);
                str3 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) Assertions.f(str2)).trim()), Float.parseFloat(((String) Assertions.f(str3)).trim()));
        }

        public static String d(String str) {
            return f9009c.matcher(str).replaceAll("");
        }
    }

    private SsaStyle(String str, int i2, Integer num, Integer num2, float f2, boolean z2, boolean z3, boolean z4, boolean z5, int i3) {
        this.f8988a = str;
        this.f8989b = i2;
        this.f8990c = num;
        this.f8991d = num2;
        this.f8992e = f2;
        this.f8993f = z2;
        this.f8994g = z3;
        this.f8995h = z4;
        this.f8996i = z5;
        this.f8997j = i3;
    }

    public static SsaStyle b(String str, Format format) {
        int i2;
        Integer num;
        Integer num2;
        float f2;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i3;
        String str2 = str;
        Format format2 = format;
        Assertions.a(str2.startsWith("Style:"));
        String[] split = TextUtils.split(str2.substring(6), ",");
        int length = split.length;
        int i4 = format2.f9008k;
        if (length != i4) {
            Log.h("SsaStyle", Util.G("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(i4), Integer.valueOf(split.length), str2));
            return null;
        }
        try {
            String trim = split[format2.f8998a].trim();
            int i5 = format2.f8999b;
            if (i5 != -1) {
                i2 = e(split[i5].trim());
            } else {
                i2 = -1;
            }
            int i6 = format2.f9000c;
            if (i6 != -1) {
                num = h(split[i6].trim());
            } else {
                num = null;
            }
            int i7 = format2.f9001d;
            if (i7 != -1) {
                num2 = h(split[i7].trim());
            } else {
                num2 = null;
            }
            int i8 = format2.f9002e;
            if (i8 != -1) {
                f2 = i(split[i8].trim());
            } else {
                f2 = -3.4028235E38f;
            }
            int i9 = format2.f9003f;
            if (i9 == -1 || !f(split[i9].trim())) {
                z2 = false;
            } else {
                z2 = true;
            }
            int i10 = format2.f9004g;
            if (i10 == -1 || !f(split[i10].trim())) {
                z3 = false;
            } else {
                z3 = true;
            }
            int i11 = format2.f9005h;
            if (i11 == -1 || !f(split[i11].trim())) {
                z4 = false;
            } else {
                z4 = true;
            }
            int i12 = format2.f9006i;
            if (i12 == -1 || !f(split[i12].trim())) {
                z5 = false;
            } else {
                z5 = true;
            }
            int i13 = format2.f9007j;
            if (i13 != -1) {
                i3 = g(split[i13].trim());
            } else {
                i3 = -1;
            }
            return new SsaStyle(trim, i2, num, num2, f2, z2, z3, z4, z5, i3);
        } catch (RuntimeException e2) {
            Log.i("SsaStyle", "Skipping malformed 'Style:' line: '" + str2 + "'", e2);
            return null;
        }
    }

    private static boolean c(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    private static boolean d(int i2) {
        return i2 == 1 || i2 == 3;
    }

    /* access modifiers changed from: private */
    public static int e(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (c(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        Log.h("SsaStyle", "Ignoring unknown alignment: " + str);
        return -1;
    }

    private static boolean f(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt == 1 || parseInt == -1) {
                return true;
            }
            return false;
        } catch (NumberFormatException e2) {
            Log.i("SsaStyle", "Failed to parse boolean value: '" + str + "'", e2);
            return false;
        }
    }

    private static int g(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (d(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        Log.h("SsaStyle", "Ignoring unknown BorderStyle: " + str);
        return -1;
    }

    public static Integer h(String str) {
        long j2;
        boolean z2;
        try {
            if (str.startsWith("&H")) {
                j2 = Long.parseLong(str.substring(2), 16);
            } else {
                j2 = Long.parseLong(str);
            }
            if (j2 <= 4294967295L) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.a(z2);
            int d2 = Ints.d(((j2 >> 24) & 255) ^ 255);
            int d3 = Ints.d((j2 >> 16) & 255);
            return Integer.valueOf(Color.argb(d2, Ints.d(j2 & 255), Ints.d((j2 >> 8) & 255), d3));
        } catch (IllegalArgumentException e2) {
            Log.i("SsaStyle", "Failed to parse color expression: '" + str + "'", e2);
            return null;
        }
    }

    private static float i(String str) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e2) {
            Log.i("SsaStyle", "Failed to parse font size: '" + str + "'", e2);
            return -3.4028235E38f;
        }
    }
}

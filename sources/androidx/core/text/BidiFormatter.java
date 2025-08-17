package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {

    /* renamed from: d  reason: collision with root package name */
    static final TextDirectionHeuristicCompat f2677d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f2678e = Character.toString(8206);

    /* renamed from: f  reason: collision with root package name */
    private static final String f2679f = Character.toString(8207);

    /* renamed from: g  reason: collision with root package name */
    static final BidiFormatter f2680g;

    /* renamed from: h  reason: collision with root package name */
    static final BidiFormatter f2681h;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f2682a;

    /* renamed from: b  reason: collision with root package name */
    private final int f2683b;

    /* renamed from: c  reason: collision with root package name */
    private final TextDirectionHeuristicCompat f2684c;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f2685a;

        /* renamed from: b  reason: collision with root package name */
        private int f2686b;

        /* renamed from: c  reason: collision with root package name */
        private TextDirectionHeuristicCompat f2687c;

        public Builder() {
            c(BidiFormatter.e(Locale.getDefault()));
        }

        private static BidiFormatter b(boolean z2) {
            return z2 ? BidiFormatter.f2681h : BidiFormatter.f2680g;
        }

        private void c(boolean z2) {
            this.f2685a = z2;
            this.f2687c = BidiFormatter.f2677d;
            this.f2686b = 2;
        }

        public BidiFormatter a() {
            if (this.f2686b == 2 && this.f2687c == BidiFormatter.f2677d) {
                return b(this.f2685a);
            }
            return new BidiFormatter(this.f2685a, this.f2686b, this.f2687c);
        }
    }

    private static class DirectionalityEstimator {

        /* renamed from: f  reason: collision with root package name */
        private static final byte[] f2688f = new byte[1792];

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f2689a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2690b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2691c;

        /* renamed from: d  reason: collision with root package name */
        private int f2692d;

        /* renamed from: e  reason: collision with root package name */
        private char f2693e;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                f2688f[i2] = Character.getDirectionality(i2);
            }
        }

        DirectionalityEstimator(CharSequence charSequence, boolean z2) {
            this.f2689a = charSequence;
            this.f2690b = z2;
            this.f2691c = charSequence.length();
        }

        private static byte c(char c2) {
            return c2 < 1792 ? f2688f[c2] : Character.getDirectionality(c2);
        }

        private byte f() {
            char charAt;
            int i2 = this.f2692d;
            do {
                int i3 = this.f2692d;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2689a;
                int i4 = i3 - 1;
                this.f2692d = i4;
                charAt = charSequence.charAt(i4);
                this.f2693e = charAt;
                if (charAt == '&') {
                    return 12;
                }
            } while (charAt != ';');
            this.f2692d = i2;
            this.f2693e = ';';
            return 13;
        }

        private byte g() {
            char charAt;
            do {
                int i2 = this.f2692d;
                if (i2 >= this.f2691c) {
                    return 12;
                }
                CharSequence charSequence = this.f2689a;
                this.f2692d = i2 + 1;
                charAt = charSequence.charAt(i2);
                this.f2693e = charAt;
            } while (charAt != ';');
            return 12;
        }

        private byte h() {
            char charAt;
            int i2 = this.f2692d;
            while (true) {
                int i3 = this.f2692d;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f2689a;
                int i4 = i3 - 1;
                this.f2692d = i4;
                char charAt2 = charSequence.charAt(i4);
                this.f2693e = charAt2;
                if (charAt2 == '<') {
                    return 12;
                }
                if (charAt2 == '>') {
                    break;
                } else if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i5 = this.f2692d;
                        if (i5 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f2689a;
                        int i6 = i5 - 1;
                        this.f2692d = i6;
                        charAt = charSequence2.charAt(i6);
                        this.f2693e = charAt;
                    } while (charAt != charAt2);
                }
            }
            this.f2692d = i2;
            this.f2693e = '>';
            return 13;
        }

        private byte i() {
            char charAt;
            int i2 = this.f2692d;
            while (true) {
                int i3 = this.f2692d;
                if (i3 < this.f2691c) {
                    CharSequence charSequence = this.f2689a;
                    this.f2692d = i3 + 1;
                    char charAt2 = charSequence.charAt(i3);
                    this.f2693e = charAt2;
                    if (charAt2 == '>') {
                        return 12;
                    }
                    if (charAt2 == '\"' || charAt2 == '\'') {
                        do {
                            int i4 = this.f2692d;
                            if (i4 >= this.f2691c) {
                                break;
                            }
                            CharSequence charSequence2 = this.f2689a;
                            this.f2692d = i4 + 1;
                            charAt = charSequence2.charAt(i4);
                            this.f2693e = charAt;
                        } while (charAt != charAt2);
                    }
                } else {
                    this.f2692d = i2;
                    this.f2693e = '<';
                    return 13;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public byte a() {
            char charAt = this.f2689a.charAt(this.f2692d - 1);
            this.f2693e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f2689a, this.f2692d);
                this.f2692d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f2692d--;
            byte c2 = c(this.f2693e);
            if (!this.f2690b) {
                return c2;
            }
            char c3 = this.f2693e;
            if (c3 == '>') {
                return h();
            }
            if (c3 == ';') {
                return f();
            }
            return c2;
        }

        /* access modifiers changed from: package-private */
        public byte b() {
            char charAt = this.f2689a.charAt(this.f2692d);
            this.f2693e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f2689a, this.f2692d);
                this.f2692d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f2692d++;
            byte c2 = c(this.f2693e);
            if (!this.f2690b) {
                return c2;
            }
            char c3 = this.f2693e;
            if (c3 == '<') {
                return i();
            }
            if (c3 == '&') {
                return g();
            }
            return c2;
        }

        /* access modifiers changed from: package-private */
        public int d() {
            this.f2692d = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f2692d < this.f2691c && i2 == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                continue;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                continue;
                            case 18:
                                i4--;
                                i3 = 0;
                                continue;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f2692d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                }
                i4--;
            }
            return 0;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
            r1 = r1 - 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int e() {
            /*
                r7 = this;
                int r0 = r7.f2691c
                r7.f2692d = r0
                r0 = 0
                r1 = 0
                r2 = 0
            L_0x0007:
                int r3 = r7.f2692d
                if (r3 <= 0) goto L_0x003b
                byte r3 = r7.a()
                r4 = -1
                if (r3 == 0) goto L_0x0034
                r5 = 1
                if (r3 == r5) goto L_0x002e
                r6 = 2
                if (r3 == r6) goto L_0x002e
                r6 = 9
                if (r3 == r6) goto L_0x0007
                switch(r3) {
                    case 14: goto L_0x0028;
                    case 15: goto L_0x0028;
                    case 16: goto L_0x0025;
                    case 17: goto L_0x0025;
                    case 18: goto L_0x0022;
                    default: goto L_0x001f;
                }
            L_0x001f:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0022:
                int r1 = r1 + 1
                goto L_0x0007
            L_0x0025:
                if (r2 != r1) goto L_0x002b
                return r5
            L_0x0028:
                if (r2 != r1) goto L_0x002b
                return r4
            L_0x002b:
                int r1 = r1 + -1
                goto L_0x0007
            L_0x002e:
                if (r1 != 0) goto L_0x0031
                return r5
            L_0x0031:
                if (r2 != 0) goto L_0x0007
                goto L_0x0039
            L_0x0034:
                if (r1 != 0) goto L_0x0037
                return r4
            L_0x0037:
                if (r2 != 0) goto L_0x0007
            L_0x0039:
                r2 = r1
                goto L_0x0007
            L_0x003b:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.BidiFormatter.DirectionalityEstimator.e():int");
        }
    }

    static {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.f2710c;
        f2677d = textDirectionHeuristicCompat;
        f2680g = new BidiFormatter(false, 2, textDirectionHeuristicCompat);
        f2681h = new BidiFormatter(true, 2, textDirectionHeuristicCompat);
    }

    BidiFormatter(boolean z2, int i2, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        this.f2682a = z2;
        this.f2683b = i2;
        this.f2684c = textDirectionHeuristicCompat;
    }

    private static int a(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new DirectionalityEstimator(charSequence, false).e();
    }

    public static BidiFormatter c() {
        return new Builder().a();
    }

    static boolean e(Locale locale) {
        return TextUtilsCompat.a(locale) == 1;
    }

    private String f(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.f2682a && (isRtl || b(charSequence) == 1)) {
            return f2678e;
        }
        if (!this.f2682a) {
            return "";
        }
        if (!isRtl || b(charSequence) == -1) {
            return f2679f;
        }
        return "";
    }

    private String g(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat) {
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        if (!this.f2682a && (isRtl || a(charSequence) == 1)) {
            return f2678e;
        }
        if (!this.f2682a) {
            return "";
        }
        if (!isRtl || a(charSequence) == -1) {
            return f2679f;
        }
        return "";
    }

    public boolean d() {
        return (this.f2683b & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f2684c, true);
    }

    public CharSequence i(CharSequence charSequence, TextDirectionHeuristicCompat textDirectionHeuristicCompat, boolean z2) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat2;
        char c2;
        TextDirectionHeuristicCompat textDirectionHeuristicCompat3;
        if (charSequence == null) {
            return null;
        }
        boolean isRtl = textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z2) {
            if (isRtl) {
                textDirectionHeuristicCompat3 = TextDirectionHeuristicsCompat.f2709b;
            } else {
                textDirectionHeuristicCompat3 = TextDirectionHeuristicsCompat.f2708a;
            }
            spannableStringBuilder.append(g(charSequence, textDirectionHeuristicCompat3));
        }
        if (isRtl != this.f2682a) {
            if (isRtl) {
                c2 = 8235;
            } else {
                c2 = 8234;
            }
            spannableStringBuilder.append(c2);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append(8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z2) {
            if (isRtl) {
                textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f2709b;
            } else {
                textDirectionHeuristicCompat2 = TextDirectionHeuristicsCompat.f2708a;
            }
            spannableStringBuilder.append(f(charSequence, textDirectionHeuristicCompat2));
        }
        return spannableStringBuilder;
    }
}

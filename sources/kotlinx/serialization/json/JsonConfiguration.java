package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class JsonConfiguration {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f41140a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f41141b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f41142c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f41143d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f41144e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f41145f;

    /* renamed from: g  reason: collision with root package name */
    private final String f41146g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f41147h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f41148i;

    /* renamed from: j  reason: collision with root package name */
    private final String f41149j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f41150k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f41151l;

    public JsonConfiguration() {
        this(false, false, false, false, false, false, (String) null, false, false, (String) null, false, false, 4095, (DefaultConstructorMarker) null);
    }

    public JsonConfiguration(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, boolean z8, boolean z9, String str2, boolean z10, boolean z11) {
        Intrinsics.f(str, "prettyPrintIndent");
        Intrinsics.f(str2, "classDiscriminator");
        this.f41140a = z2;
        this.f41141b = z3;
        this.f41142c = z4;
        this.f41143d = z5;
        this.f41144e = z6;
        this.f41145f = z7;
        this.f41146g = str;
        this.f41147h = z8;
        this.f41148i = z9;
        this.f41149j = str2;
        this.f41150k = z10;
        this.f41151l = z11;
    }

    public final boolean a() {
        return this.f41150k;
    }

    public final boolean b() {
        return this.f41143d;
    }

    public final String c() {
        return this.f41149j;
    }

    public final boolean d() {
        return this.f41147h;
    }

    public final boolean e() {
        return this.f41140a;
    }

    public final boolean f() {
        return this.f41145f;
    }

    public final boolean g() {
        return this.f41141b;
    }

    public final boolean h() {
        return this.f41144e;
    }

    public final String i() {
        return this.f41146g;
    }

    public final boolean j() {
        return this.f41151l;
    }

    public final boolean k() {
        return this.f41148i;
    }

    public final boolean l() {
        return this.f41142c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f41140a + ", ignoreUnknownKeys=" + this.f41141b + ", isLenient=" + this.f41142c + ", allowStructuredMapKeys=" + this.f41143d + ", prettyPrint=" + this.f41144e + ", explicitNulls=" + this.f41145f + ", prettyPrintIndent='" + this.f41146g + "', coerceInputValues=" + this.f41147h + ", useArrayPolymorphism=" + this.f41148i + ", classDiscriminator='" + this.f41149j + "', allowSpecialFloatingPointValues=" + this.f41150k + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ JsonConfiguration(boolean r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20, java.lang.String r21, boolean r22, boolean r23, java.lang.String r24, boolean r25, boolean r26, int r27, kotlin.jvm.internal.DefaultConstructorMarker r28) {
        /*
            r14 = this;
            r0 = r27
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000a
        L_0x0009:
            r1 = r15
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r16
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r17
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r18
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r19
        L_0x002a:
            r7 = r0 & 32
            r8 = 1
            if (r7 == 0) goto L_0x0031
            r7 = 1
            goto L_0x0033
        L_0x0031:
            r7 = r20
        L_0x0033:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x003a
            java.lang.String r9 = "    "
            goto L_0x003c
        L_0x003a:
            r9 = r21
        L_0x003c:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r22
        L_0x0044:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L_0x004a
            r11 = 0
            goto L_0x004c
        L_0x004a:
            r11 = r23
        L_0x004c:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0053
            java.lang.String r12 = "type"
            goto L_0x0055
        L_0x0053:
            r12 = r24
        L_0x0055:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x005a
            goto L_0x005c
        L_0x005a:
            r2 = r25
        L_0x005c:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0061
            goto L_0x0063
        L_0x0061:
            r8 = r26
        L_0x0063:
            r15 = r14
            r16 = r1
            r17 = r3
            r18 = r4
            r19 = r5
            r20 = r6
            r21 = r7
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r27 = r8
            r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.JsonConfiguration.<init>(boolean, boolean, boolean, boolean, boolean, boolean, java.lang.String, boolean, boolean, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

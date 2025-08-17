package com.chartboost.sdk.impl;

import com.facebook.react.uimanager.ViewProps;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class n7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f18239a;

    /* renamed from: b  reason: collision with root package name */
    public final String f18240b;

    /* renamed from: c  reason: collision with root package name */
    public final b f18241c;

    /* renamed from: d  reason: collision with root package name */
    public final a f18242d;

    /* renamed from: e  reason: collision with root package name */
    public final a f18243e;

    /* renamed from: f  reason: collision with root package name */
    public final a f18244f;

    public enum b {
        TOP_LEFT(0),
        TOP_RIGHT(1),
        BOTTOM_LEFT(2),
        BOTTOM_RIGHT(3);
        

        /* renamed from: c  reason: collision with root package name */
        public static final a f18247c = null;

        /* renamed from: b  reason: collision with root package name */
        public final int f18253b;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final b a(int i2) {
                b bVar;
                b[] values = b.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        bVar = null;
                        break;
                    }
                    bVar = values[i3];
                    if (bVar.b() == i2) {
                        break;
                    }
                    i3++;
                }
                if (bVar == null) {
                    return b.TOP_LEFT;
                }
                return bVar;
            }

            public a() {
            }
        }

        static {
            f18247c = new a((DefaultConstructorMarker) null);
        }

        /* access modifiers changed from: public */
        b(int i2) {
            this.f18253b = i2;
        }

        public final int b() {
            return this.f18253b;
        }
    }

    public n7(String str, String str2, b bVar, a aVar, a aVar2, a aVar3) {
        Intrinsics.f(str, "imageUrl");
        Intrinsics.f(str2, "clickthroughUrl");
        Intrinsics.f(bVar, ViewProps.POSITION);
        Intrinsics.f(aVar, ViewProps.MARGIN);
        Intrinsics.f(aVar2, ViewProps.PADDING);
        Intrinsics.f(aVar3, "size");
        this.f18239a = str;
        this.f18240b = str2;
        this.f18241c = bVar;
        this.f18242d = aVar;
        this.f18243e = aVar2;
        this.f18244f = aVar3;
    }

    public final String a() {
        return this.f18240b;
    }

    public final String b() {
        return this.f18239a;
    }

    public final a c() {
        return this.f18242d;
    }

    public final b d() {
        return this.f18241c;
    }

    public final a e() {
        return this.f18244f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n7)) {
            return false;
        }
        n7 n7Var = (n7) obj;
        return Intrinsics.a(this.f18239a, n7Var.f18239a) && Intrinsics.a(this.f18240b, n7Var.f18240b) && this.f18241c == n7Var.f18241c && Intrinsics.a(this.f18242d, n7Var.f18242d) && Intrinsics.a(this.f18243e, n7Var.f18243e) && Intrinsics.a(this.f18244f, n7Var.f18244f);
    }

    public int hashCode() {
        return (((((((((this.f18239a.hashCode() * 31) + this.f18240b.hashCode()) * 31) + this.f18241c.hashCode()) * 31) + this.f18242d.hashCode()) * 31) + this.f18243e.hashCode()) * 31) + this.f18244f.hashCode();
    }

    public String toString() {
        return "InfoIcon(imageUrl=" + this.f18239a + ", clickthroughUrl=" + this.f18240b + ", position=" + this.f18241c + ", margin=" + this.f18242d + ", padding=" + this.f18243e + ", size=" + this.f18244f + ')';
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final double f18245a;

        /* renamed from: b  reason: collision with root package name */
        public final double f18246b;

        public a(double d2, double d3) {
            this.f18245a = d2;
            this.f18246b = d3;
        }

        public final double a() {
            return this.f18246b;
        }

        public final double b() {
            return this.f18245a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Double.compare(this.f18245a, aVar.f18245a) == 0 && Double.compare(this.f18246b, aVar.f18246b) == 0;
        }

        public int hashCode() {
            return (Double.doubleToLongBits(this.f18245a) * 31) + Double.doubleToLongBits(this.f18246b);
        }

        public String toString() {
            return "DoubleSize(width=" + this.f18245a + ", height=" + this.f18246b + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(double d2, double d3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0.0d : d2, (i2 & 2) != 0 ? 0.0d : d3);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ n7(java.lang.String r13, java.lang.String r14, com.chartboost.sdk.impl.n7.b r15, com.chartboost.sdk.impl.n7.a r16, com.chartboost.sdk.impl.n7.a r17, com.chartboost.sdk.impl.n7.a r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r12 = this;
            r0 = r19 & 1
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0008
            r0 = r1
            goto L_0x0009
        L_0x0008:
            r0 = r13
        L_0x0009:
            r2 = r19 & 2
            if (r2 == 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = r14
        L_0x000f:
            r2 = r19 & 4
            if (r2 == 0) goto L_0x0016
            com.chartboost.sdk.impl.n7$b r2 = com.chartboost.sdk.impl.n7.b.TOP_LEFT
            goto L_0x0017
        L_0x0016:
            r2 = r15
        L_0x0017:
            r3 = r19 & 8
            if (r3 == 0) goto L_0x0028
            com.chartboost.sdk.impl.n7$a r3 = new com.chartboost.sdk.impl.n7$a
            r5 = 0
            r7 = 0
            r9 = 3
            r10 = 0
            r4 = r3
            r4.<init>(r5, r7, r9, r10)
            goto L_0x002a
        L_0x0028:
            r3 = r16
        L_0x002a:
            r4 = r19 & 16
            if (r4 == 0) goto L_0x003b
            com.chartboost.sdk.impl.n7$a r4 = new com.chartboost.sdk.impl.n7$a
            r6 = 0
            r8 = 0
            r10 = 3
            r11 = 0
            r5 = r4
            r5.<init>(r6, r8, r10, r11)
            goto L_0x003d
        L_0x003b:
            r4 = r17
        L_0x003d:
            r5 = r19 & 32
            if (r5 == 0) goto L_0x0055
            com.chartboost.sdk.impl.n7$a r5 = new com.chartboost.sdk.impl.n7$a
            r6 = 0
            r8 = 0
            r10 = 3
            r11 = 0
            r13 = r5
            r14 = r6
            r16 = r8
            r18 = r10
            r19 = r11
            r13.<init>(r14, r16, r18, r19)
            goto L_0x0057
        L_0x0055:
            r5 = r18
        L_0x0057:
            r13 = r12
            r14 = r0
            r15 = r1
            r16 = r2
            r17 = r3
            r18 = r4
            r19 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.n7.<init>(java.lang.String, java.lang.String, com.chartboost.sdk.impl.n7$b, com.chartboost.sdk.impl.n7$a, com.chartboost.sdk.impl.n7$a, com.chartboost.sdk.impl.n7$a, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}

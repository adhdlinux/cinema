package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class KTypeProjection {

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f40475c = new Companion((DefaultConstructorMarker) null);

    /* renamed from: d  reason: collision with root package name */
    public static final KTypeProjection f40476d = new KTypeProjection((KVariance) null, (KType) null);

    /* renamed from: a  reason: collision with root package name */
    private final KVariance f40477a;

    /* renamed from: b  reason: collision with root package name */
    private final KType f40478b;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KTypeProjection a(KType kType) {
            Intrinsics.f(kType, "type");
            return new KTypeProjection(KVariance.INVARIANT, kType);
        }
    }

    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40479a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                kotlin.reflect.KVariance[] r0 = kotlin.reflect.KVariance.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.INVARIANT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.IN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlin.reflect.KVariance r1 = kotlin.reflect.KVariance.OUT     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f40479a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.KTypeProjection.WhenMappings.<clinit>():void");
        }
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        boolean z2;
        boolean z3;
        String str;
        this.f40477a = kVariance;
        this.f40478b = kType;
        boolean z4 = true;
        if (kVariance == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (kType == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!(z2 != z3 ? false : z4)) {
            if (kVariance == null) {
                str = "Star projection must have no type specified.";
            } else {
                str = "The projection variance " + kVariance + " requires type to be specified.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public final KType a() {
        return this.f40478b;
    }

    public final KVariance b() {
        return this.f40477a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) obj;
        return this.f40477a == kTypeProjection.f40477a && Intrinsics.a(this.f40478b, kTypeProjection.f40478b);
    }

    public int hashCode() {
        KVariance kVariance = this.f40477a;
        int i2 = 0;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        KType kType = this.f40478b;
        if (kType != null) {
            i2 = kType.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        int i2;
        KVariance kVariance = this.f40477a;
        if (kVariance == null) {
            i2 = -1;
        } else {
            i2 = WhenMappings.f40479a[kVariance.ordinal()];
        }
        if (i2 == -1) {
            return "*";
        }
        if (i2 == 1) {
            return String.valueOf(this.f40478b);
        }
        if (i2 == 2) {
            return "in " + this.f40478b;
        } else if (i2 == 3) {
            return "out " + this.f40478b;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}

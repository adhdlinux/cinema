package kotlin.jvm.internal;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

public final class TypeReference implements KType {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f40435f = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final KClassifier f40436b;

    /* renamed from: c  reason: collision with root package name */
    private final List<KTypeProjection> f40437c;

    /* renamed from: d  reason: collision with root package name */
    private final KType f40438d;

    /* renamed from: e  reason: collision with root package name */
    private final int f40439e;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f40440a;

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
                f40440a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference.WhenMappings.<clinit>():void");
        }
    }

    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, KType kType, int i2) {
        Intrinsics.f(kClassifier, "classifier");
        Intrinsics.f(list, "arguments");
        this.f40436b = kClassifier;
        this.f40437c = list;
        this.f40438d = kType;
        this.f40439e = i2;
    }

    /* access modifiers changed from: private */
    public final String g(KTypeProjection kTypeProjection) {
        TypeReference typeReference;
        String str;
        if (kTypeProjection.b() == null) {
            return "*";
        }
        KType a2 = kTypeProjection.a();
        if (a2 instanceof TypeReference) {
            typeReference = (TypeReference) a2;
        } else {
            typeReference = null;
        }
        if (typeReference == null || (str = typeReference.h(true)) == null) {
            str = String.valueOf(kTypeProjection.a());
        }
        int i2 = WhenMappings.f40440a[kTypeProjection.b().ordinal()];
        if (i2 == 1) {
            return str;
        }
        if (i2 == 2) {
            return "in " + str;
        } else if (i2 == 3) {
            return "out " + str;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final String h(boolean z2) {
        KClass kClass;
        String str;
        String str2;
        KClassifier d2 = d();
        Class cls = null;
        if (d2 instanceof KClass) {
            kClass = (KClass) d2;
        } else {
            kClass = null;
        }
        if (kClass != null) {
            cls = JvmClassMappingKt.a(kClass);
        }
        if (cls == null) {
            str = d().toString();
        } else if ((this.f40439e & 4) != 0) {
            str = "kotlin.Nothing";
        } else if (cls.isArray()) {
            str = i(cls);
        } else if (!z2 || !cls.isPrimitive()) {
            str = cls.getName();
        } else {
            KClassifier d3 = d();
            Intrinsics.d(d3, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            str = JvmClassMappingKt.b((KClass) d3).getName();
        }
        String str3 = "";
        if (f().isEmpty()) {
            str2 = str3;
        } else {
            str2 = CollectionsKt___CollectionsKt.J(f(), ", ", "<", ">", 0, (CharSequence) null, new TypeReference$asString$args$1(this), 24, (Object) null);
        }
        if (b()) {
            str3 = "?";
        }
        String str4 = str + str2 + str3;
        KType kType = this.f40438d;
        if (!(kType instanceof TypeReference)) {
            return str4;
        }
        String h2 = ((TypeReference) kType).h(true);
        if (Intrinsics.a(h2, str4)) {
            return str4;
        }
        if (Intrinsics.a(h2, str4 + '?')) {
            return str4 + '!';
        }
        return '(' + str4 + ".." + h2 + ')';
    }

    private final String i(Class<?> cls) {
        if (Intrinsics.a(cls, boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (Intrinsics.a(cls, char[].class)) {
            return "kotlin.CharArray";
        }
        if (Intrinsics.a(cls, byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (Intrinsics.a(cls, short[].class)) {
            return "kotlin.ShortArray";
        }
        if (Intrinsics.a(cls, int[].class)) {
            return "kotlin.IntArray";
        }
        if (Intrinsics.a(cls, float[].class)) {
            return "kotlin.FloatArray";
        }
        if (Intrinsics.a(cls, long[].class)) {
            return "kotlin.LongArray";
        }
        if (Intrinsics.a(cls, double[].class)) {
            return "kotlin.DoubleArray";
        }
        return "kotlin.Array";
    }

    public boolean b() {
        return (this.f40439e & 1) != 0;
    }

    public KClassifier d() {
        return this.f40436b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (!Intrinsics.a(d(), typeReference.d()) || !Intrinsics.a(f(), typeReference.f()) || !Intrinsics.a(this.f40438d, typeReference.f40438d) || this.f40439e != typeReference.f40439e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public List<KTypeProjection> f() {
        return this.f40437c;
    }

    public int hashCode() {
        return (((d().hashCode() * 31) + f().hashCode()) * 31) + this.f40439e;
    }

    public final int j() {
        return this.f40439e;
    }

    public final KType k() {
        return this.f40438d;
    }

    public String toString() {
        return h(false) + " (Kotlin reflection is not available)";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, boolean z2) {
        this(kClassifier, list, (KType) null, z2 ? 1 : 0);
        Intrinsics.f(kClassifier, "classifier");
        Intrinsics.f(list, "arguments");
    }
}

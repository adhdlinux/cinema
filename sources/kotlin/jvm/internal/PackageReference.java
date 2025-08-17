package kotlin.jvm.internal;

public final class PackageReference implements ClassBasedDeclarationContainer {

    /* renamed from: b  reason: collision with root package name */
    private final Class<?> f40422b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40423c;

    public PackageReference(Class<?> cls, String str) {
        Intrinsics.f(cls, "jClass");
        Intrinsics.f(str, "moduleName");
        this.f40422b = cls;
        this.f40423c = str;
    }

    public Class<?> a() {
        return this.f40422b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PackageReference) && Intrinsics.a(a(), ((PackageReference) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}

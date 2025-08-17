package kotlinx.serialization.json;

import com.vungle.ads.internal.model.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.json.internal.StringOpsKt;

public final class JsonLiteral extends JsonPrimitive {

    /* renamed from: d  reason: collision with root package name */
    private final boolean f41162d;

    /* renamed from: e  reason: collision with root package name */
    private final String f41163e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonLiteral(Object obj, boolean z2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.f(obj, "body");
        this.f41162d = z2;
        this.f41163e = obj.toString();
    }

    public String a() {
        return this.f41163e;
    }

    public boolean b() {
        return this.f41162d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !Intrinsics.a(Reflection.b(JsonLiteral.class), Reflection.b(obj.getClass()))) {
            return false;
        }
        JsonLiteral jsonLiteral = (JsonLiteral) obj;
        if (b() == jsonLiteral.b() && Intrinsics.a(a(), jsonLiteral.a())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (a.a(b()) * 31) + a().hashCode();
    }

    public String toString() {
        if (!b()) {
            return a();
        }
        StringBuilder sb = new StringBuilder();
        StringOpsKt.c(sb, a());
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}

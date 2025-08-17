package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

class JsonTreeDecoder extends AbstractJsonTreeDecoder {

    /* renamed from: f  reason: collision with root package name */
    private final JsonObject f41225f;

    /* renamed from: g  reason: collision with root package name */
    private final String f41226g;

    /* renamed from: h  reason: collision with root package name */
    private final SerialDescriptor f41227h;

    /* renamed from: i  reason: collision with root package name */
    private int f41228i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f41229j;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : serialDescriptor);
    }

    private final boolean x0(SerialDescriptor serialDescriptor, int i2) {
        boolean z2;
        if (d().e().f() || serialDescriptor.j(i2) || !serialDescriptor.h(i2).b()) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f41229j = z2;
        return z2;
    }

    private final boolean y0(SerialDescriptor serialDescriptor, int i2, String str) {
        JsonPrimitive jsonPrimitive;
        Json d2 = d();
        SerialDescriptor h2 = serialDescriptor.h(i2);
        if (!h2.b() && (g0(str) instanceof JsonNull)) {
            return true;
        }
        if (Intrinsics.a(h2.d(), SerialKind.ENUM.f40938a)) {
            JsonElement g02 = g0(str);
            String str2 = null;
            if (g02 instanceof JsonPrimitive) {
                jsonPrimitive = (JsonPrimitive) g02;
            } else {
                jsonPrimitive = null;
            }
            if (jsonPrimitive != null) {
                str2 = JsonElementKt.f(jsonPrimitive);
            }
            if (str2 != null && JsonNamesMapKt.d(h2, d2, str2) == -3) {
                return true;
            }
        }
        return false;
    }

    public boolean D() {
        return !this.f41229j && super.D();
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (serialDescriptor == this.f41227h) {
            return this;
        }
        return super.b(serialDescriptor);
    }

    public void c(SerialDescriptor serialDescriptor) {
        Set<String> set;
        Set set2;
        Intrinsics.f(serialDescriptor, "descriptor");
        if (!this.f41190e.g() && !(serialDescriptor.d() instanceof PolymorphicKind)) {
            if (!this.f41190e.j()) {
                set = JsonInternalDependenciesKt.a(serialDescriptor);
            } else {
                Set<String> a2 = JsonInternalDependenciesKt.a(serialDescriptor);
                Map map = (Map) JsonSchemaCacheKt.a(d()).a(serialDescriptor, JsonNamesMapKt.c());
                if (map != null) {
                    set2 = map.keySet();
                } else {
                    set2 = null;
                }
                if (set2 == null) {
                    set2 = SetsKt__SetsKt.b();
                }
                set = SetsKt___SetsKt.e(a2, set2);
            }
            for (String next : v0().keySet()) {
                if (!set.contains(next) && !Intrinsics.a(next, this.f41226g)) {
                    throw JsonExceptionsKt.g(next, v0().toString());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public String c0(SerialDescriptor serialDescriptor, int i2) {
        Object obj;
        boolean z2;
        Intrinsics.f(serialDescriptor, "desc");
        String f2 = serialDescriptor.f(i2);
        if (!this.f41190e.j() || v0().keySet().contains(f2)) {
            return f2;
        }
        Map map = (Map) JsonSchemaCacheKt.a(d()).b(serialDescriptor, JsonNamesMapKt.c(), new JsonTreeDecoder$elementName$alternativeNamesMap$1(serialDescriptor));
        Iterator it2 = v0().keySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            Integer num = (Integer) map.get((String) obj);
            if (num != null && num.intValue() == i2) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        String str = (String) obj;
        if (str == null) {
            return f2;
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public JsonElement g0(String str) {
        Intrinsics.f(str, "tag");
        return (JsonElement) MapsKt__MapsKt.h(v0(), str);
    }

    public int o(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        while (this.f41228i < serialDescriptor.e()) {
            int i2 = this.f41228i;
            this.f41228i = i2 + 1;
            String d02 = X(serialDescriptor, i2);
            int i3 = this.f41228i - 1;
            this.f41229j = false;
            if ((v0().containsKey(d02) || x0(serialDescriptor, i3)) && (!this.f41190e.d() || !y0(serialDescriptor, i3, d02))) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: z0 */
    public JsonObject v0() {
        return this.f41225f;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor) {
        super(json, jsonObject, (DefaultConstructorMarker) null);
        Intrinsics.f(json, "json");
        Intrinsics.f(jsonObject, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f41225f = jsonObject;
        this.f41226g = str;
        this.f41227h = serialDescriptor;
    }
}

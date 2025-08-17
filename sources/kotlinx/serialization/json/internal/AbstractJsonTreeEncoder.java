package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.modules.SerializersModule;

abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {

    /* renamed from: b  reason: collision with root package name */
    private final Json f41191b;

    /* renamed from: c  reason: collision with root package name */
    private final Function1<JsonElement, Unit> f41192c;

    /* renamed from: d  reason: collision with root package name */
    protected final JsonConfiguration f41193d;

    /* renamed from: e  reason: collision with root package name */
    private String f41194e;

    private AbstractJsonTreeEncoder(Json json, Function1<? super JsonElement, Unit> function1) {
        this.f41191b = json;
        this.f41192c = function1;
        this.f41193d = json.e();
    }

    public /* synthetic */ AbstractJsonTreeEncoder(Json json, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, function1);
    }

    public static final /* synthetic */ String h0(AbstractJsonTreeEncoder abstractJsonTreeEncoder) {
        return (String) abstractJsonTreeEncoder.Y();
    }

    public void A(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "element");
        e(JsonElementSerializer.f41153a, jsonElement);
    }

    /* access modifiers changed from: protected */
    public void X(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        this.f41192c.invoke(v0());
    }

    public final SerializersModule a() {
        return this.f41191b.a();
    }

    public CompositeEncoder b(SerialDescriptor serialDescriptor) {
        Function1 function1;
        boolean z2;
        AbstractJsonTreeEncoder abstractJsonTreeEncoder;
        Intrinsics.f(serialDescriptor, "descriptor");
        if (Z() == null) {
            function1 = this.f41192c;
        } else {
            function1 = new AbstractJsonTreeEncoder$beginStructure$consumer$1(this);
        }
        SerialKind d2 = serialDescriptor.d();
        if (Intrinsics.a(d2, StructureKind.LIST.f40940a)) {
            z2 = true;
        } else {
            z2 = d2 instanceof PolymorphicKind;
        }
        if (z2) {
            abstractJsonTreeEncoder = new JsonTreeListEncoder(this.f41191b, function1);
        } else if (Intrinsics.a(d2, StructureKind.MAP.f40941a)) {
            Json json = this.f41191b;
            SerialDescriptor a2 = WriteModeKt.a(serialDescriptor.h(0), json.a());
            SerialKind d3 = a2.d();
            if ((d3 instanceof PrimitiveKind) || Intrinsics.a(d3, SerialKind.ENUM.f40938a)) {
                abstractJsonTreeEncoder = new JsonTreeMapEncoder(this.f41191b, function1);
            } else if (json.e().b()) {
                abstractJsonTreeEncoder = new JsonTreeListEncoder(this.f41191b, function1);
            } else {
                throw JsonExceptionsKt.d(a2);
            }
        } else {
            abstractJsonTreeEncoder = new JsonTreeEncoder(this.f41191b, function1);
        }
        String str = this.f41194e;
        if (str != null) {
            Intrinsics.c(str);
            abstractJsonTreeEncoder.w0(str, JsonElementKt.c(serialDescriptor.i()));
            this.f41194e = null;
        }
        return abstractJsonTreeEncoder;
    }

    public final Json d() {
        return this.f41191b;
    }

    /* access modifiers changed from: protected */
    public String d0(String str, String str2) {
        Intrinsics.f(str, "parentName");
        Intrinsics.f(str2, "childName");
        return str2;
    }

    public <T> void e(SerializationStrategy<? super T> serializationStrategy, T t2) {
        Intrinsics.f(serializationStrategy, "serializer");
        if (Z() == null && TreeJsonEncoderKt.b(WriteModeKt.a(serializationStrategy.getDescriptor(), a()))) {
            JsonPrimitiveEncoder jsonPrimitiveEncoder = new JsonPrimitiveEncoder(this.f41191b, this.f41192c);
            jsonPrimitiveEncoder.e(serializationStrategy, t2);
            jsonPrimitiveEncoder.X(serializationStrategy.getDescriptor());
        } else if (!(serializationStrategy instanceof AbstractPolymorphicSerializer) || d().e().k()) {
            serializationStrategy.serialize(this, t2);
        } else {
            AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializationStrategy;
            String c2 = PolymorphicKt.c(serializationStrategy.getDescriptor(), d());
            Intrinsics.d(t2, "null cannot be cast to non-null type kotlin.Any");
            SerializationStrategy b2 = PolymorphicSerializerKt.b(abstractPolymorphicSerializer, this, t2);
            PolymorphicKt.f(abstractPolymorphicSerializer, b2, c2);
            PolymorphicKt.b(b2.getDescriptor().d());
            this.f41194e = c2;
            b2.serialize(this, t2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: i0 */
    public void J(String str, boolean z2) {
        Intrinsics.f(str, "tag");
        w0(str, JsonElementKt.a(Boolean.valueOf(z2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: j0 */
    public void K(String str, byte b2) {
        Intrinsics.f(str, "tag");
        w0(str, JsonElementKt.b(Byte.valueOf(b2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: k0 */
    public void L(String str, char c2) {
        Intrinsics.f(str, "tag");
        w0(str, JsonElementKt.c(String.valueOf(c2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l0 */
    public void M(String str, double d2) {
        boolean z2;
        Intrinsics.f(str, "tag");
        w0(str, JsonElementKt.b(Double.valueOf(d2)));
        if (!this.f41193d.a()) {
            if (Double.isInfinite(d2) || Double.isNaN(d2)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                throw JsonExceptionsKt.c(Double.valueOf(d2), str, v0().toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m0 */
    public void N(String str, SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        w0(str, JsonElementKt.c(serialDescriptor.f(i2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: n0 */
    public void O(String str, float f2) {
        boolean z2;
        Intrinsics.f(str, "tag");
        w0(str, JsonElementKt.b(Float.valueOf(f2)));
        if (!this.f41193d.a()) {
            if (Float.isInfinite(f2) || Float.isNaN(f2)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                throw JsonExceptionsKt.c(Float.valueOf(f2), str, v0().toString());
            }
        }
    }

    public void o() {
        String str = (String) Z();
        if (str == null) {
            this.f41192c.invoke(JsonNull.f41166d);
        } else {
            T(str);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o0 */
    public Encoder P(String str, SerialDescriptor serialDescriptor) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.a(serialDescriptor)) {
            return new AbstractJsonTreeEncoder$encodeTaggedInline$1(this, str);
        }
        return super.P(str, serialDescriptor);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p0 */
    public void Q(String str, int i2) {
        Intrinsics.f(str, "tag");
        w0(str, JsonElementKt.b(Integer.valueOf(i2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: q0 */
    public void R(String str, long j2) {
        Intrinsics.f(str, "tag");
        w0(str, JsonElementKt.b(Long.valueOf(j2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: r0 */
    public void T(String str) {
        Intrinsics.f(str, "tag");
        w0(str, JsonNull.f41166d);
    }

    /* access modifiers changed from: protected */
    /* renamed from: s0 */
    public void U(String str, short s2) {
        Intrinsics.f(str, "tag");
        w0(str, JsonElementKt.b(Short.valueOf(s2)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: t0 */
    public void V(String str, String str2) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        w0(str, JsonElementKt.c(str2));
    }

    /* access modifiers changed from: protected */
    /* renamed from: u0 */
    public void W(String str, Object obj) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(obj, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        w0(str, JsonElementKt.c(obj.toString()));
    }

    public void v() {
    }

    public abstract JsonElement v0();

    public abstract void w0(String str, JsonElement jsonElement);

    public boolean z(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return this.f41193d.e();
    }
}

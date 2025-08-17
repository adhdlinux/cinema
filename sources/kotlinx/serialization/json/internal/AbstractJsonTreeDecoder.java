package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {

    /* renamed from: c  reason: collision with root package name */
    private final Json f41188c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonElement f41189d;

    /* renamed from: e  reason: collision with root package name */
    protected final JsonConfiguration f41190e;

    private AbstractJsonTreeDecoder(Json json, JsonElement jsonElement) {
        this.f41188c = json;
        this.f41189d = jsonElement;
        this.f41190e = d().e();
    }

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement);
    }

    private final JsonLiteral f0(JsonPrimitive jsonPrimitive, String str) {
        JsonLiteral jsonLiteral = jsonPrimitive instanceof JsonLiteral ? (JsonLiteral) jsonPrimitive : null;
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw JsonExceptionsKt.e(-1, "Unexpected 'null' when " + str + " was expected");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = g0(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.serialization.json.JsonElement h0() {
        /*
            r1 = this;
            java.lang.Object r0 = r1.W()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x000e
            kotlinx.serialization.json.JsonElement r0 = r1.g0(r0)
            if (r0 != 0) goto L_0x0012
        L_0x000e:
            kotlinx.serialization.json.JsonElement r0 = r1.v0()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonTreeDecoder.h0():kotlinx.serialization.json.JsonElement");
    }

    private final Void w0(String str) {
        throw JsonExceptionsKt.f(-1, "Failed to parse '" + str + '\'', h0().toString());
    }

    public boolean D() {
        return !(h0() instanceof JsonNull);
    }

    public <T> T G(DeserializationStrategy<T> deserializationStrategy) {
        Intrinsics.f(deserializationStrategy, "deserializer");
        return PolymorphicKt.d(this, deserializationStrategy);
    }

    public SerializersModule a() {
        return d().a();
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        boolean z2;
        Intrinsics.f(serialDescriptor, "descriptor");
        JsonElement h02 = h0();
        SerialKind d2 = serialDescriptor.d();
        if (Intrinsics.a(d2, StructureKind.LIST.f40940a)) {
            z2 = true;
        } else {
            z2 = d2 instanceof PolymorphicKind;
        }
        Class<JsonArray> cls = JsonArray.class;
        if (z2) {
            Json d3 = d();
            if (h02 instanceof JsonArray) {
                return new JsonTreeListDecoder(d3, (JsonArray) h02);
            }
            throw JsonExceptionsKt.e(-1, "Expected " + Reflection.b(cls) + " as the serialized body of " + serialDescriptor.i() + ", but had " + Reflection.b(h02.getClass()));
        }
        Class<JsonObject> cls2 = JsonObject.class;
        if (Intrinsics.a(d2, StructureKind.MAP.f40941a)) {
            Json d4 = d();
            SerialDescriptor a2 = WriteModeKt.a(serialDescriptor.h(0), d4.a());
            SerialKind d5 = a2.d();
            if ((d5 instanceof PrimitiveKind) || Intrinsics.a(d5, SerialKind.ENUM.f40938a)) {
                Json d6 = d();
                if (h02 instanceof JsonObject) {
                    return new JsonTreeMapDecoder(d6, (JsonObject) h02);
                }
                throw JsonExceptionsKt.e(-1, "Expected " + Reflection.b(cls2) + " as the serialized body of " + serialDescriptor.i() + ", but had " + Reflection.b(h02.getClass()));
            } else if (d4.e().b()) {
                Json d7 = d();
                if (h02 instanceof JsonArray) {
                    return new JsonTreeListDecoder(d7, (JsonArray) h02);
                }
                throw JsonExceptionsKt.e(-1, "Expected " + Reflection.b(cls) + " as the serialized body of " + serialDescriptor.i() + ", but had " + Reflection.b(h02.getClass()));
            } else {
                throw JsonExceptionsKt.d(a2);
            }
        } else {
            Json d8 = d();
            if (h02 instanceof JsonObject) {
                return new JsonTreeDecoder(d8, (JsonObject) h02, (String) null, (SerialDescriptor) null, 12, (DefaultConstructorMarker) null);
            }
            throw JsonExceptionsKt.e(-1, "Expected " + Reflection.b(cls2) + " as the serialized body of " + serialDescriptor.i() + ", but had " + Reflection.b(h02.getClass()));
        }
    }

    /* access modifiers changed from: protected */
    public String b0(String str, String str2) {
        Intrinsics.f(str, "parentName");
        Intrinsics.f(str2, "childName");
        return str2;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
    }

    public Json d() {
        return this.f41188c;
    }

    public JsonElement g() {
        return h0();
    }

    /* access modifiers changed from: protected */
    public abstract JsonElement g0(String str);

    /* access modifiers changed from: protected */
    /* renamed from: i0 */
    public boolean J(String str) {
        Intrinsics.f(str, "tag");
        JsonPrimitive u02 = u0(str);
        if (d().e().l() || !f0(u02, "boolean").b()) {
            try {
                Boolean e2 = JsonElementKt.e(u02);
                if (e2 != null) {
                    return e2.booleanValue();
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException unused) {
                w0("boolean");
                throw new KotlinNothingValueException();
            }
        } else {
            throw JsonExceptionsKt.f(-1, "Boolean literal for key '" + str + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", h0().toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: j0 */
    public byte K(String str) {
        Byte b2;
        Intrinsics.f(str, "tag");
        try {
            int j2 = JsonElementKt.j(u0(str));
            boolean z2 = false;
            if (-128 <= j2 && j2 <= 127) {
                z2 = true;
            }
            if (z2) {
                b2 = Byte.valueOf((byte) j2);
            } else {
                b2 = null;
            }
            if (b2 != null) {
                return b2.byteValue();
            }
            w0("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: k0 */
    public char L(String str) {
        Intrinsics.f(str, "tag");
        try {
            return StringsKt___StringsKt.U0(u0(str).a());
        } catch (IllegalArgumentException unused) {
            w0("char");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l0 */
    public double M(String str) {
        boolean z2;
        Intrinsics.f(str, "tag");
        try {
            double g2 = JsonElementKt.g(u0(str));
            if (!d().e().a()) {
                if (Double.isInfinite(g2) || Double.isNaN(g2)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    throw JsonExceptionsKt.a(Double.valueOf(g2), str, h0().toString());
                }
            }
            return g2;
        } catch (IllegalArgumentException unused) {
            w0("double");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m0 */
    public int N(String str, SerialDescriptor serialDescriptor) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        return JsonNamesMapKt.f(serialDescriptor, d(), u0(str).a(), (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: n0 */
    public float O(String str) {
        boolean z2;
        Intrinsics.f(str, "tag");
        try {
            float i2 = JsonElementKt.i(u0(str));
            if (!d().e().a()) {
                if (Float.isInfinite(i2) || Float.isNaN(i2)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    throw JsonExceptionsKt.a(Float.valueOf(i2), str, h0().toString());
                }
            }
            return i2;
        } catch (IllegalArgumentException unused) {
            w0("float");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o0 */
    public Decoder P(String str, SerialDescriptor serialDescriptor) {
        Intrinsics.f(str, "tag");
        Intrinsics.f(serialDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.a(serialDescriptor)) {
            return new JsonDecoderForUnsignedTypes(new StringJsonLexer(u0(str).a()), d());
        }
        return super.P(str, serialDescriptor);
    }

    /* access modifiers changed from: protected */
    /* renamed from: p0 */
    public int Q(String str) {
        Intrinsics.f(str, "tag");
        try {
            return JsonElementKt.j(u0(str));
        } catch (IllegalArgumentException unused) {
            w0("int");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: q0 */
    public long R(String str) {
        Intrinsics.f(str, "tag");
        try {
            return JsonElementKt.m(u0(str));
        } catch (IllegalArgumentException unused) {
            w0("long");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r0 */
    public boolean S(String str) {
        Intrinsics.f(str, "tag");
        if (g0(str) != JsonNull.f41166d) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s0 */
    public short T(String str) {
        Short sh;
        Intrinsics.f(str, "tag");
        try {
            int j2 = JsonElementKt.j(u0(str));
            boolean z2 = false;
            if (-32768 <= j2 && j2 <= 32767) {
                z2 = true;
            }
            if (z2) {
                sh = Short.valueOf((short) j2);
            } else {
                sh = null;
            }
            if (sh != null) {
                return sh.shortValue();
            }
            w0("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            w0("short");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: t0 */
    public String U(String str) {
        Intrinsics.f(str, "tag");
        JsonPrimitive u02 = u0(str);
        if (!d().e().l() && !f0(u02, "string").b()) {
            throw JsonExceptionsKt.f(-1, "String literal for key '" + str + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", h0().toString());
        } else if (!(u02 instanceof JsonNull)) {
            return u02.a();
        } else {
            throw JsonExceptionsKt.f(-1, "Unexpected 'null' value instead of string literal", h0().toString());
        }
    }

    /* access modifiers changed from: protected */
    public final JsonPrimitive u0(String str) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.f(str, "tag");
        JsonElement g02 = g0(str);
        if (g02 instanceof JsonPrimitive) {
            jsonPrimitive = (JsonPrimitive) g02;
        } else {
            jsonPrimitive = null;
        }
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw JsonExceptionsKt.f(-1, "Expected JsonPrimitive at " + str + ", found " + g02, h0().toString());
    }

    public JsonElement v0() {
        return this.f41189d;
    }
}

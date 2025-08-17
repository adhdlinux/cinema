package kotlinx.serialization.json.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final Json f41256a;

    /* renamed from: b  reason: collision with root package name */
    private final WriteMode f41257b;

    /* renamed from: c  reason: collision with root package name */
    public final AbstractJsonLexer f41258c;

    /* renamed from: d  reason: collision with root package name */
    private final SerializersModule f41259d;

    /* renamed from: e  reason: collision with root package name */
    private int f41260e = -1;

    /* renamed from: f  reason: collision with root package name */
    private DiscriminatorHolder f41261f;

    /* renamed from: g  reason: collision with root package name */
    private final JsonConfiguration f41262g;

    /* renamed from: h  reason: collision with root package name */
    private final JsonElementMarker f41263h;

    public static final class DiscriminatorHolder {

        /* renamed from: a  reason: collision with root package name */
        public String f41264a;

        public DiscriminatorHolder(String str) {
            this.f41264a = str;
        }
    }

    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41265a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                kotlinx.serialization.json.internal.WriteMode[] r0 = kotlinx.serialization.json.internal.WriteMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.LIST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.MAP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.POLY_OBJ     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                kotlinx.serialization.json.internal.WriteMode r1 = kotlinx.serialization.json.internal.WriteMode.OBJ     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f41265a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonDecoder.WhenMappings.<clinit>():void");
        }
    }

    public StreamingJsonDecoder(Json json, WriteMode writeMode, AbstractJsonLexer abstractJsonLexer, SerialDescriptor serialDescriptor, DiscriminatorHolder discriminatorHolder) {
        JsonElementMarker jsonElementMarker;
        Intrinsics.f(json, "json");
        Intrinsics.f(writeMode, "mode");
        Intrinsics.f(abstractJsonLexer, "lexer");
        Intrinsics.f(serialDescriptor, "descriptor");
        this.f41256a = json;
        this.f41257b = writeMode;
        this.f41258c = abstractJsonLexer;
        this.f41259d = json.a();
        this.f41261f = discriminatorHolder;
        JsonConfiguration e2 = json.e();
        this.f41262g = e2;
        if (e2.f()) {
            jsonElementMarker = null;
        } else {
            jsonElementMarker = new JsonElementMarker(serialDescriptor);
        }
        this.f41263h = jsonElementMarker;
    }

    private final void K() {
        if (this.f41258c.E() == 4) {
            AbstractJsonLexer.y(this.f41258c, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final boolean L(SerialDescriptor serialDescriptor, int i2) {
        String F;
        Json json = this.f41256a;
        SerialDescriptor h2 = serialDescriptor.h(i2);
        if (!h2.b() && (!this.f41258c.M())) {
            return true;
        }
        if (!Intrinsics.a(h2.d(), SerialKind.ENUM.f40938a) || (F = this.f41258c.F(this.f41262g.l())) == null || JsonNamesMapKt.d(h2, json, F) != -3) {
            return false;
        }
        this.f41258c.q();
        return true;
    }

    private final int M() {
        boolean L = this.f41258c.L();
        if (this.f41258c.f()) {
            int i2 = this.f41260e;
            if (i2 == -1 || L) {
                int i3 = i2 + 1;
                this.f41260e = i3;
                return i3;
            }
            AbstractJsonLexer.y(this.f41258c, "Expected end of the array or comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        } else if (!L) {
            return -1;
        } else {
            AbstractJsonLexer.y(this.f41258c, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final int N() {
        boolean z2;
        int i2 = this.f41260e;
        boolean z3 = false;
        if (i2 % 2 != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            this.f41258c.o(':');
        } else if (i2 != -1) {
            z3 = this.f41258c.L();
        }
        if (this.f41258c.f()) {
            if (z2) {
                if (this.f41260e == -1) {
                    AbstractJsonLexer abstractJsonLexer = this.f41258c;
                    boolean z4 = !z3;
                    int a2 = abstractJsonLexer.f41184a;
                    if (!z4) {
                        AbstractJsonLexer.y(abstractJsonLexer, "Unexpected trailing comma", a2, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    AbstractJsonLexer abstractJsonLexer2 = this.f41258c;
                    int a3 = abstractJsonLexer2.f41184a;
                    if (!z3) {
                        AbstractJsonLexer.y(abstractJsonLexer2, "Expected comma after the key-value pair", a3, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            int i3 = this.f41260e + 1;
            this.f41260e = i3;
            return i3;
        } else if (!z3) {
            return -1;
        } else {
            AbstractJsonLexer.y(this.f41258c, "Expected '}', but had ',' instead", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final int O(SerialDescriptor serialDescriptor) {
        boolean z2;
        boolean L = this.f41258c.L();
        while (this.f41258c.f()) {
            String P = P();
            this.f41258c.o(':');
            int d2 = JsonNamesMapKt.d(serialDescriptor, this.f41256a, P);
            boolean z3 = false;
            if (d2 == -3) {
                z2 = false;
                z3 = true;
            } else if (!this.f41262g.d() || !L(serialDescriptor, d2)) {
                JsonElementMarker jsonElementMarker = this.f41263h;
                if (jsonElementMarker != null) {
                    jsonElementMarker.c(d2);
                }
                return d2;
            } else {
                z2 = this.f41258c.L();
            }
            if (z3) {
                L = Q(P);
            } else {
                L = z2;
            }
        }
        if (!L) {
            JsonElementMarker jsonElementMarker2 = this.f41263h;
            if (jsonElementMarker2 != null) {
                return jsonElementMarker2.d();
            }
            return -1;
        }
        AbstractJsonLexer.y(this.f41258c, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final String P() {
        if (this.f41262g.l()) {
            return this.f41258c.t();
        }
        return this.f41258c.k();
    }

    private final boolean Q(String str) {
        if (this.f41262g.g() || S(this.f41261f, str)) {
            this.f41258c.H(this.f41262g.l());
        } else {
            this.f41258c.A(str);
        }
        return this.f41258c.L();
    }

    private final void R(SerialDescriptor serialDescriptor) {
        do {
        } while (o(serialDescriptor) != -1);
    }

    private final boolean S(DiscriminatorHolder discriminatorHolder, String str) {
        if (discriminatorHolder == null || !Intrinsics.a(discriminatorHolder.f41264a, str)) {
            return false;
        }
        discriminatorHolder.f41264a = null;
        return true;
    }

    public boolean D() {
        JsonElementMarker jsonElementMarker = this.f41263h;
        return !(jsonElementMarker != null ? jsonElementMarker.b() : false) && this.f41258c.M();
    }

    public <T> T G(DeserializationStrategy<T> deserializationStrategy) {
        DeserializationStrategy deserializationStrategy2;
        Intrinsics.f(deserializationStrategy, "deserializer");
        try {
            if (deserializationStrategy instanceof AbstractPolymorphicSerializer) {
                if (!this.f41256a.e().k()) {
                    String c2 = PolymorphicKt.c(deserializationStrategy.getDescriptor(), this.f41256a);
                    String l2 = this.f41258c.l(c2, this.f41262g.l());
                    if (l2 != null) {
                        deserializationStrategy2 = ((AbstractPolymorphicSerializer) deserializationStrategy).c(this, l2);
                    } else {
                        deserializationStrategy2 = null;
                    }
                    if (deserializationStrategy2 == null) {
                        return PolymorphicKt.d(this, deserializationStrategy);
                    }
                    this.f41261f = new DiscriminatorHolder(c2);
                    return deserializationStrategy2.deserialize(this);
                }
            }
            return deserializationStrategy.deserialize(this);
        } catch (MissingFieldException e2) {
            List<String> a2 = e2.a();
            throw new MissingFieldException(a2, e2.getMessage() + " at path: " + this.f41258c.f41185b.a(), e2);
        }
    }

    public byte H() {
        long p2 = this.f41258c.p();
        byte b2 = (byte) ((int) p2);
        if (p2 == ((long) b2)) {
            return b2;
        }
        AbstractJsonLexer abstractJsonLexer = this.f41258c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse byte for input '" + p2 + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public SerializersModule a() {
        return this.f41259d;
    }

    public CompositeDecoder b(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        WriteMode b2 = WriteModeKt.b(this.f41256a, serialDescriptor);
        this.f41258c.f41185b.c(serialDescriptor);
        this.f41258c.o(b2.f41285b);
        K();
        int i2 = WhenMappings.f41265a[b2.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return new StreamingJsonDecoder(this.f41256a, b2, this.f41258c, serialDescriptor, this.f41261f);
        } else if (this.f41257b == b2 && this.f41256a.e().f()) {
            return this;
        } else {
            return new StreamingJsonDecoder(this.f41256a, b2, this.f41258c, serialDescriptor, this.f41261f);
        }
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (this.f41256a.e().g() && serialDescriptor.e() == 0) {
            R(serialDescriptor);
        }
        this.f41258c.o(this.f41257b.f41286c);
        this.f41258c.f41185b.b();
    }

    public final Json d() {
        return this.f41256a;
    }

    public int e(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        Json json = this.f41256a;
        String z2 = z();
        return JsonNamesMapKt.e(serialDescriptor, json, z2, " at path " + this.f41258c.f41185b.a());
    }

    public JsonElement g() {
        return new JsonTreeReader(this.f41256a.e(), this.f41258c).e();
    }

    public int h() {
        long p2 = this.f41258c.p();
        int i2 = (int) p2;
        if (p2 == ((long) i2)) {
            return i2;
        }
        AbstractJsonLexer abstractJsonLexer = this.f41258c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse int for input '" + p2 + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public Void j() {
        return null;
    }

    public long l() {
        return this.f41258c.p();
    }

    public int o(SerialDescriptor serialDescriptor) {
        int i2;
        Intrinsics.f(serialDescriptor, "descriptor");
        int i3 = WhenMappings.f41265a[this.f41257b.ordinal()];
        if (i3 == 2) {
            i2 = N();
        } else if (i3 != 4) {
            i2 = M();
        } else {
            i2 = O(serialDescriptor);
        }
        if (this.f41257b != WriteMode.MAP) {
            this.f41258c.f41185b.g(i2);
        }
        return i2;
    }

    public Decoder q(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (StreamingJsonEncoderKt.a(serialDescriptor)) {
            return new JsonDecoderForUnsignedTypes(this.f41258c, this.f41256a);
        }
        return super.q(serialDescriptor);
    }

    public short s() {
        long p2 = this.f41258c.p();
        short s2 = (short) ((int) p2);
        if (p2 == ((long) s2)) {
            return s2;
        }
        AbstractJsonLexer abstractJsonLexer = this.f41258c;
        AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse short for input '" + p2 + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public float t() {
        boolean z2;
        AbstractJsonLexer abstractJsonLexer = this.f41258c;
        String s2 = abstractJsonLexer.s();
        try {
            float parseFloat = Float.parseFloat(s2);
            if (!this.f41256a.e().a()) {
                if (Float.isInfinite(parseFloat) || Float.isNaN(parseFloat)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    JsonExceptionsKt.j(this.f41258c, Float.valueOf(parseFloat));
                    throw new KotlinNothingValueException();
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "float" + "' for input '" + s2 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public double v() {
        boolean z2;
        AbstractJsonLexer abstractJsonLexer = this.f41258c;
        String s2 = abstractJsonLexer.s();
        try {
            double parseDouble = Double.parseDouble(s2);
            if (!this.f41256a.e().a()) {
                if (Double.isInfinite(parseDouble) || Double.isNaN(parseDouble)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    JsonExceptionsKt.j(this.f41258c, Double.valueOf(parseDouble));
                    throw new KotlinNothingValueException();
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "double" + "' for input '" + s2 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public boolean w() {
        if (this.f41262g.l()) {
            return this.f41258c.i();
        }
        return this.f41258c.g();
    }

    public char x() {
        String s2 = this.f41258c.s();
        if (s2.length() == 1) {
            return s2.charAt(0);
        }
        AbstractJsonLexer abstractJsonLexer = this.f41258c;
        AbstractJsonLexer.y(abstractJsonLexer, "Expected single char, but got '" + s2 + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public <T> T y(SerialDescriptor serialDescriptor, int i2, DeserializationStrategy<T> deserializationStrategy, T t2) {
        boolean z2;
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(deserializationStrategy, "deserializer");
        if (this.f41257b == WriteMode.MAP && (i2 & 1) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            this.f41258c.f41185b.d();
        }
        T y2 = super.y(serialDescriptor, i2, deserializationStrategy, t2);
        if (z2) {
            this.f41258c.f41185b.f(y2);
        }
        return y2;
    }

    public String z() {
        if (this.f41262g.l()) {
            return this.f41258c.t();
        }
        return this.f41258c.q();
    }
}

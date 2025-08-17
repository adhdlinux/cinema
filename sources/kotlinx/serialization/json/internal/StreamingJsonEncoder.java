package kotlinx.serialization.json.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.modules.SerializersModule;

public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final Composer f41266a;

    /* renamed from: b  reason: collision with root package name */
    private final Json f41267b;

    /* renamed from: c  reason: collision with root package name */
    private final WriteMode f41268c;

    /* renamed from: d  reason: collision with root package name */
    private final JsonEncoder[] f41269d;

    /* renamed from: e  reason: collision with root package name */
    private final SerializersModule f41270e;

    /* renamed from: f  reason: collision with root package name */
    private final JsonConfiguration f41271f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f41272g;

    /* renamed from: h  reason: collision with root package name */
    private String f41273h;

    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f41274a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
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
                f41274a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonEncoder.WhenMappings.<clinit>():void");
        }
    }

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode writeMode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.f(composer, "composer");
        Intrinsics.f(json, "json");
        Intrinsics.f(writeMode, "mode");
        this.f41266a = composer;
        this.f41267b = json;
        this.f41268c = writeMode;
        this.f41269d = jsonEncoderArr;
        this.f41270e = d().a();
        this.f41271f = d().e();
        int ordinal = writeMode.ordinal();
        if (jsonEncoderArr != null) {
            JsonEncoder jsonEncoder = jsonEncoderArr[ordinal];
            if (jsonEncoder != null || jsonEncoder != this) {
                jsonEncoderArr[ordinal] = this;
            }
        }
    }

    private final Composer K() {
        Composer composer = this.f41266a;
        if (composer instanceof ComposerForUnsignedNumbers) {
            return composer;
        }
        return new ComposerForUnsignedNumbers(composer.f41206a, this.f41272g);
    }

    private final void L(SerialDescriptor serialDescriptor) {
        this.f41266a.c();
        String str = this.f41273h;
        Intrinsics.c(str);
        G(str);
        this.f41266a.e(':');
        this.f41266a.o();
        G(serialDescriptor.i());
    }

    public void A(JsonElement jsonElement) {
        Intrinsics.f(jsonElement, "element");
        e(JsonElementSerializer.f41153a, jsonElement);
    }

    public void B(int i2) {
        if (this.f41272g) {
            G(String.valueOf(i2));
        } else {
            this.f41266a.h(i2);
        }
    }

    public void G(String str) {
        Intrinsics.f(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f41266a.m(str);
    }

    public boolean H(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        int i3 = WhenMappings.f41274a[this.f41268c.ordinal()];
        if (i3 != 1) {
            boolean z2 = false;
            if (i3 != 2) {
                if (i3 != 3) {
                    if (!this.f41266a.a()) {
                        this.f41266a.e(',');
                    }
                    this.f41266a.c();
                    G(serialDescriptor.f(i2));
                    this.f41266a.e(':');
                    this.f41266a.o();
                } else {
                    if (i2 == 0) {
                        this.f41272g = true;
                    }
                    if (i2 == 1) {
                        this.f41266a.e(',');
                        this.f41266a.o();
                        this.f41272g = false;
                    }
                }
            } else if (!this.f41266a.a()) {
                if (i2 % 2 == 0) {
                    this.f41266a.e(',');
                    this.f41266a.c();
                    z2 = true;
                } else {
                    this.f41266a.e(':');
                    this.f41266a.o();
                }
                this.f41272g = z2;
            } else {
                this.f41272g = true;
                this.f41266a.c();
            }
        } else {
            if (!this.f41266a.a()) {
                this.f41266a.e(',');
            }
            this.f41266a.c();
        }
        return true;
    }

    public SerializersModule a() {
        return this.f41270e;
    }

    public CompositeEncoder b(SerialDescriptor serialDescriptor) {
        JsonEncoder jsonEncoder;
        Intrinsics.f(serialDescriptor, "descriptor");
        WriteMode b2 = WriteModeKt.b(d(), serialDescriptor);
        char c2 = b2.f41285b;
        if (c2 != 0) {
            this.f41266a.e(c2);
            this.f41266a.b();
        }
        if (this.f41273h != null) {
            L(serialDescriptor);
            this.f41273h = null;
        }
        if (this.f41268c == b2) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.f41269d;
        if (jsonEncoderArr == null || (jsonEncoder = jsonEncoderArr[b2.ordinal()]) == null) {
            return new StreamingJsonEncoder(this.f41266a, d(), b2, this.f41269d);
        }
        return jsonEncoder;
    }

    public void c(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (this.f41268c.f41286c != 0) {
            this.f41266a.p();
            this.f41266a.c();
            this.f41266a.e(this.f41268c.f41286c);
        }
    }

    public Json d() {
        return this.f41267b;
    }

    public <T> void e(SerializationStrategy<? super T> serializationStrategy, T t2) {
        Intrinsics.f(serializationStrategy, "serializer");
        if (!(serializationStrategy instanceof AbstractPolymorphicSerializer) || d().e().k()) {
            serializationStrategy.serialize(this, t2);
            return;
        }
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) serializationStrategy;
        String c2 = PolymorphicKt.c(serializationStrategy.getDescriptor(), d());
        Intrinsics.d(t2, "null cannot be cast to non-null type kotlin.Any");
        SerializationStrategy b2 = PolymorphicSerializerKt.b(abstractPolymorphicSerializer, this, t2);
        PolymorphicKt.f(abstractPolymorphicSerializer, b2, c2);
        PolymorphicKt.b(b2.getDescriptor().d());
        this.f41273h = c2;
        b2.serialize(this, t2);
    }

    public void g(double d2) {
        boolean z2;
        if (this.f41272g) {
            G(String.valueOf(d2));
        } else {
            this.f41266a.f(d2);
        }
        if (!this.f41271f.a()) {
            if (Double.isInfinite(d2) || Double.isNaN(d2)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                throw JsonExceptionsKt.b(Double.valueOf(d2), this.f41266a.f41206a.toString());
            }
        }
    }

    public void h(byte b2) {
        if (this.f41272g) {
            G(String.valueOf(b2));
        } else {
            this.f41266a.d(b2);
        }
    }

    public <T> void i(SerialDescriptor serialDescriptor, int i2, SerializationStrategy<? super T> serializationStrategy, T t2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        Intrinsics.f(serializationStrategy, "serializer");
        if (t2 != null || this.f41271f.f()) {
            super.i(serialDescriptor, i2, serializationStrategy, t2);
        }
    }

    public void k(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "enumDescriptor");
        G(serialDescriptor.f(i2));
    }

    public Encoder l(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        if (StreamingJsonEncoderKt.a(serialDescriptor)) {
            return new StreamingJsonEncoder(K(), d(), this.f41268c, (JsonEncoder[]) null);
        }
        return super.l(serialDescriptor);
    }

    public void m(long j2) {
        if (this.f41272g) {
            G(String.valueOf(j2));
        } else {
            this.f41266a.i(j2);
        }
    }

    public void o() {
        this.f41266a.j("null");
    }

    public void q(short s2) {
        if (this.f41272g) {
            G(String.valueOf(s2));
        } else {
            this.f41266a.k(s2);
        }
    }

    public void r(boolean z2) {
        if (this.f41272g) {
            G(String.valueOf(z2));
        } else {
            this.f41266a.l(z2);
        }
    }

    public void t(float f2) {
        boolean z2;
        if (this.f41272g) {
            G(String.valueOf(f2));
        } else {
            this.f41266a.g(f2);
        }
        if (!this.f41271f.a()) {
            if (Float.isInfinite(f2) || Float.isNaN(f2)) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2) {
                throw JsonExceptionsKt.b(Float.valueOf(f2), this.f41266a.f41206a.toString());
            }
        }
    }

    public void u(char c2) {
        G(String.valueOf(c2));
    }

    public boolean z(SerialDescriptor serialDescriptor, int i2) {
        Intrinsics.f(serialDescriptor, "descriptor");
        return this.f41271f.e();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StreamingJsonEncoder(JsonWriter jsonWriter, Json json, WriteMode writeMode, JsonEncoder[] jsonEncoderArr) {
        this(ComposersKt.a(jsonWriter, json), json, writeMode, jsonEncoderArr);
        Intrinsics.f(jsonWriter, "output");
        Intrinsics.f(json, "json");
        Intrinsics.f(writeMode, "mode");
        Intrinsics.f(jsonEncoderArr, "modeReuseCache");
    }
}

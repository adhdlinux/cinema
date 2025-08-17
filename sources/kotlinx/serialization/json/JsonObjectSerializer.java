package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class JsonObjectSerializer implements KSerializer<JsonObject> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonObjectSerializer f41176a = new JsonObjectSerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41177b = JsonObjectDescriptor.f41178b;

    private static final class JsonObjectDescriptor implements SerialDescriptor {

        /* renamed from: b  reason: collision with root package name */
        public static final JsonObjectDescriptor f41178b = new JsonObjectDescriptor();

        /* renamed from: c  reason: collision with root package name */
        private static final String f41179c = "kotlinx.serialization.json.JsonObject";

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ SerialDescriptor f41180a = BuiltinSerializersKt.k(BuiltinSerializersKt.G(StringCompanionObject.f40434a), JsonElementSerializer.f41153a).getDescriptor();

        private JsonObjectDescriptor() {
        }

        public boolean b() {
            return this.f41180a.b();
        }

        public int c(String str) {
            Intrinsics.f(str, "name");
            return this.f41180a.c(str);
        }

        public SerialKind d() {
            return this.f41180a.d();
        }

        public int e() {
            return this.f41180a.e();
        }

        public String f(int i2) {
            return this.f41180a.f(i2);
        }

        public List<Annotation> g(int i2) {
            return this.f41180a.g(i2);
        }

        public List<Annotation> getAnnotations() {
            return this.f41180a.getAnnotations();
        }

        public SerialDescriptor h(int i2) {
            return this.f41180a.h(i2);
        }

        public String i() {
            return f41179c;
        }

        public boolean isInline() {
            return this.f41180a.isInline();
        }

        public boolean j(int i2) {
            return this.f41180a.j(i2);
        }
    }

    private JsonObjectSerializer() {
    }

    /* renamed from: a */
    public JsonObject deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElementSerializersKt.g(decoder);
        return new JsonObject(BuiltinSerializersKt.k(BuiltinSerializersKt.G(StringCompanionObject.f40434a), JsonElementSerializer.f41153a).deserialize(decoder));
    }

    /* renamed from: b */
    public void serialize(Encoder encoder, JsonObject jsonObject) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(jsonObject, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        JsonElementSerializersKt.h(encoder);
        BuiltinSerializersKt.k(BuiltinSerializersKt.G(StringCompanionObject.f40434a), JsonElementSerializer.f41153a).serialize(encoder, jsonObject);
    }

    public SerialDescriptor getDescriptor() {
        return f41177b;
    }
}

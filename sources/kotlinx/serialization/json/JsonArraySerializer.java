package kotlinx.serialization.json;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

public final class JsonArraySerializer implements KSerializer<JsonArray> {

    /* renamed from: a  reason: collision with root package name */
    public static final JsonArraySerializer f41122a = new JsonArraySerializer();

    /* renamed from: b  reason: collision with root package name */
    private static final SerialDescriptor f41123b = JsonArrayDescriptor.f41124b;

    private static final class JsonArrayDescriptor implements SerialDescriptor {

        /* renamed from: b  reason: collision with root package name */
        public static final JsonArrayDescriptor f41124b = new JsonArrayDescriptor();

        /* renamed from: c  reason: collision with root package name */
        private static final String f41125c = "kotlinx.serialization.json.JsonArray";

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ SerialDescriptor f41126a = BuiltinSerializersKt.h(JsonElementSerializer.f41153a).getDescriptor();

        private JsonArrayDescriptor() {
        }

        public boolean b() {
            return this.f41126a.b();
        }

        public int c(String str) {
            Intrinsics.f(str, "name");
            return this.f41126a.c(str);
        }

        public SerialKind d() {
            return this.f41126a.d();
        }

        public int e() {
            return this.f41126a.e();
        }

        public String f(int i2) {
            return this.f41126a.f(i2);
        }

        public List<Annotation> g(int i2) {
            return this.f41126a.g(i2);
        }

        public List<Annotation> getAnnotations() {
            return this.f41126a.getAnnotations();
        }

        public SerialDescriptor h(int i2) {
            return this.f41126a.h(i2);
        }

        public String i() {
            return f41125c;
        }

        public boolean isInline() {
            return this.f41126a.isInline();
        }

        public boolean j(int i2) {
            return this.f41126a.j(i2);
        }
    }

    private JsonArraySerializer() {
    }

    /* renamed from: a */
    public JsonArray deserialize(Decoder decoder) {
        Intrinsics.f(decoder, "decoder");
        JsonElementSerializersKt.g(decoder);
        return new JsonArray((List) BuiltinSerializersKt.h(JsonElementSerializer.f41153a).deserialize(decoder));
    }

    /* renamed from: b */
    public void serialize(Encoder encoder, JsonArray jsonArray) {
        Intrinsics.f(encoder, "encoder");
        Intrinsics.f(jsonArray, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        JsonElementSerializersKt.h(encoder);
        BuiltinSerializersKt.h(JsonElementSerializer.f41153a).serialize(encoder, jsonArray);
    }

    public SerialDescriptor getDescriptor() {
        return f41123b;
    }
}

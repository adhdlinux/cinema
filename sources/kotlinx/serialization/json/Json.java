package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.internal.JsonToStringWriter;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.TreeJsonDecoderKt;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

public abstract class Json implements StringFormat {

    /* renamed from: d  reason: collision with root package name */
    public static final Default f41116d = new Default((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final JsonConfiguration f41117a;

    /* renamed from: b  reason: collision with root package name */
    private final SerializersModule f41118b;

    /* renamed from: c  reason: collision with root package name */
    private final DescriptorSchemaCache f41119c;

    public static final class Default extends Json {
        private Default() {
            super(new JsonConfiguration(false, false, false, false, false, false, (String) null, false, false, (String) null, false, false, 4095, (DefaultConstructorMarker) null), SerializersModuleBuildersKt.a(), (DefaultConstructorMarker) null);
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule) {
        this.f41117a = jsonConfiguration;
        this.f41118b = serializersModule;
        this.f41119c = new DescriptorSchemaCache();
    }

    public /* synthetic */ Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonConfiguration, serializersModule);
    }

    public SerializersModule a() {
        return this.f41118b;
    }

    public final <T> T b(DeserializationStrategy<T> deserializationStrategy, String str) {
        Intrinsics.f(deserializationStrategy, "deserializer");
        Intrinsics.f(str, "string");
        StringJsonLexer stringJsonLexer = new StringJsonLexer(str);
        T G = new StreamingJsonDecoder(this, WriteMode.OBJ, stringJsonLexer, deserializationStrategy.getDescriptor(), (StreamingJsonDecoder.DiscriminatorHolder) null).G(deserializationStrategy);
        stringJsonLexer.w();
        return G;
    }

    public final <T> String c(SerializationStrategy<? super T> serializationStrategy, T t2) {
        Intrinsics.f(serializationStrategy, "serializer");
        JsonToStringWriter jsonToStringWriter = new JsonToStringWriter();
        try {
            JsonStreamsKt.a(this, jsonToStringWriter, serializationStrategy, t2);
            return jsonToStringWriter.toString();
        } finally {
            jsonToStringWriter.g();
        }
    }

    public final <T> T d(DeserializationStrategy<T> deserializationStrategy, JsonElement jsonElement) {
        Intrinsics.f(deserializationStrategy, "deserializer");
        Intrinsics.f(jsonElement, "element");
        return TreeJsonDecoderKt.a(this, jsonElement, deserializationStrategy);
    }

    public final JsonConfiguration e() {
        return this.f41117a;
    }

    public final DescriptorSchemaCache f() {
        return this.f41119c;
    }
}

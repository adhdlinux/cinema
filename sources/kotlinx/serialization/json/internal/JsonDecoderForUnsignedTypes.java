package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractJsonLexer f41212a;

    /* renamed from: b  reason: collision with root package name */
    private final SerializersModule f41213b;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer abstractJsonLexer, Json json) {
        Intrinsics.f(abstractJsonLexer, "lexer");
        Intrinsics.f(json, "json");
        this.f41212a = abstractJsonLexer;
        this.f41213b = json.a();
    }

    public byte H() {
        AbstractJsonLexer abstractJsonLexer = this.f41212a;
        String s2 = abstractJsonLexer.s();
        try {
            return UStringsKt.a(s2);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "UByte" + "' for input '" + s2 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public SerializersModule a() {
        return this.f41213b;
    }

    public int h() {
        AbstractJsonLexer abstractJsonLexer = this.f41212a;
        String s2 = abstractJsonLexer.s();
        try {
            return UStringsKt.d(s2);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "UInt" + "' for input '" + s2 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public long l() {
        AbstractJsonLexer abstractJsonLexer = this.f41212a;
        String s2 = abstractJsonLexer.s();
        try {
            return UStringsKt.g(s2);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "ULong" + "' for input '" + s2 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public int o(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "descriptor");
        throw new IllegalStateException("unsupported".toString());
    }

    public short s() {
        AbstractJsonLexer abstractJsonLexer = this.f41212a;
        String s2 = abstractJsonLexer.s();
        try {
            return UStringsKt.j(s2);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.y(abstractJsonLexer, "Failed to parse type '" + "UShort" + "' for input '" + s2 + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }
}

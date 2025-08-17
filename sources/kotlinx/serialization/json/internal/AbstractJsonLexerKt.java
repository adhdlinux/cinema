package kotlinx.serialization.json.internal;

public final class AbstractJsonLexerKt {
    public static final byte a(char c2) {
        if (c2 < '~') {
            return CharMappings.f41205c[c2];
        }
        return 0;
    }

    public static final char b(int i2) {
        if (i2 < 117) {
            return CharMappings.f41204b[i2];
        }
        return 0;
    }
}

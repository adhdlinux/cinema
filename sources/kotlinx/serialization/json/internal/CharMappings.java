package kotlinx.serialization.json.internal;

public final class CharMappings {

    /* renamed from: a  reason: collision with root package name */
    public static final CharMappings f41203a;

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f41204b = new char[117];

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f41205c = new byte[126];

    static {
        CharMappings charMappings = new CharMappings();
        f41203a = charMappings;
        charMappings.f();
        charMappings.e();
    }

    private CharMappings() {
    }

    private final void a(char c2, char c3) {
        b(c2, c3);
    }

    private final void b(int i2, char c2) {
        if (c2 != 'u') {
            f41204b[c2] = (char) i2;
        }
    }

    private final void c(char c2, byte b2) {
        d(c2, b2);
    }

    private final void d(int i2, byte b2) {
        f41205c[i2] = b2;
    }

    private final void e() {
        for (int i2 = 0; i2 < 33; i2++) {
            d(i2, Byte.MAX_VALUE);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c('\\', (byte) 2);
    }

    private final void f() {
        for (int i2 = 0; i2 < 32; i2++) {
            b(i2, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a('\\', '\\');
    }
}

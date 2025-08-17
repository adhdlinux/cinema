package androidx.sqlite.db;

public final class SimpleSQLiteQuery implements SupportSQLiteQuery {

    /* renamed from: b  reason: collision with root package name */
    private final String f11603b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f11604c;

    public SimpleSQLiteQuery(String str, Object[] objArr) {
        this.f11603b = str;
        this.f11604c = objArr;
    }

    private static void b(SupportSQLiteProgram supportSQLiteProgram, int i2, Object obj) {
        long j2;
        if (obj == null) {
            supportSQLiteProgram.d0(i2);
        } else if (obj instanceof byte[]) {
            supportSQLiteProgram.Y(i2, (byte[]) obj);
        } else if (obj instanceof Float) {
            supportSQLiteProgram.l(i2, (double) ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            supportSQLiteProgram.l(i2, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            supportSQLiteProgram.X(i2, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            supportSQLiteProgram.X(i2, (long) ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            supportSQLiteProgram.X(i2, (long) ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            supportSQLiteProgram.X(i2, (long) ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            supportSQLiteProgram.R(i2, (String) obj);
        } else if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            supportSQLiteProgram.X(i2, j2);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
        }
    }

    public static void c(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        if (objArr != null) {
            int length = objArr.length;
            int i2 = 0;
            while (i2 < length) {
                Object obj = objArr[i2];
                i2++;
                b(supportSQLiteProgram, i2, obj);
            }
        }
    }

    public String a() {
        return this.f11603b;
    }

    public void f(SupportSQLiteProgram supportSQLiteProgram) {
        c(supportSQLiteProgram, this.f11604c);
    }

    public SimpleSQLiteQuery(String str) {
        this(str, (Object[]) null);
    }
}

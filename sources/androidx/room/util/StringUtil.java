package androidx.room.util;

public class StringUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f11534a = new String[0];

    private StringUtil() {
    }

    public static void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("?");
            if (i3 < i2 - 1) {
                sb.append(",");
            }
        }
    }

    public static StringBuilder b() {
        return new StringBuilder();
    }
}

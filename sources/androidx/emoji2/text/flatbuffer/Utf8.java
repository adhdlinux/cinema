package androidx.emoji2.text.flatbuffer;

public abstract class Utf8 {

    /* renamed from: a  reason: collision with root package name */
    private static Utf8 f3147a;

    public static Utf8 a() {
        if (f3147a == null) {
            f3147a = new Utf8Safe();
        }
        return f3147a;
    }
}

package kotlinx.coroutines.internal;

final /* synthetic */ class SystemPropsKt__SystemPropsKt {

    /* renamed from: a  reason: collision with root package name */
    private static final int f40772a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f40772a;
    }

    public static final String b(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}

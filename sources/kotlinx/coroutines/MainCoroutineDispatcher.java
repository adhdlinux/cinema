package kotlinx.coroutines;

public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher r0();

    /* access modifiers changed from: protected */
    public final String s0() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        MainCoroutineDispatcher c2 = Dispatchers.c();
        if (this == c2) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher = c2.r0();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcher = null;
        }
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public String toString() {
        String s02 = s0();
        if (s02 != null) {
            return s02;
        }
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this);
    }
}

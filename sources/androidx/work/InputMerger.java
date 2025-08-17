package androidx.work;

import java.util.List;

public abstract class InputMerger {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12178a = Logger.f("InputMerger");

    public static InputMerger a(String str) {
        try {
            return (InputMerger) Class.forName(str).newInstance();
        } catch (Exception e2) {
            Logger c2 = Logger.c();
            String str2 = f12178a;
            c2.b(str2, "Trouble instantiating + " + str, e2);
            return null;
        }
    }

    public abstract Data b(List<Data> list);
}

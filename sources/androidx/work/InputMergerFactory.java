package androidx.work;

public abstract class InputMergerFactory {
    public static InputMergerFactory c() {
        return new InputMergerFactory() {
            public InputMerger a(String str) {
                return null;
            }
        };
    }

    public abstract InputMerger a(String str);

    public final InputMerger b(String str) {
        InputMerger a2 = a(str);
        if (a2 == null) {
            return InputMerger.a(str);
        }
        return a2;
    }
}

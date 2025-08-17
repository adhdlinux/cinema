package androidx.core.text;

import java.util.Locale;

public final class TextDirectionHeuristicsCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2708a = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, false);

    /* renamed from: b  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2709b = new TextDirectionHeuristicInternal((TextDirectionAlgorithm) null, true);

    /* renamed from: c  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2710c;

    /* renamed from: d  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2711d;

    /* renamed from: e  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2712e = new TextDirectionHeuristicInternal(AnyStrong.f2714b, false);

    /* renamed from: f  reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f2713f = TextDirectionHeuristicLocale.f2719b;

    private static class AnyStrong implements TextDirectionAlgorithm {

        /* renamed from: b  reason: collision with root package name */
        static final AnyStrong f2714b = new AnyStrong(true);

        /* renamed from: a  reason: collision with root package name */
        private final boolean f2715a;

        private AnyStrong(boolean z2) {
            this.f2715a = z2;
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            boolean z2 = false;
            while (i2 < i4) {
                int a2 = TextDirectionHeuristicsCompat.a(Character.getDirectionality(charSequence.charAt(i2)));
                if (a2 != 0) {
                    if (a2 != 1) {
                        continue;
                        i2++;
                    } else if (!this.f2715a) {
                        return 1;
                    }
                } else if (this.f2715a) {
                    return 0;
                }
                z2 = true;
                i2++;
            }
            if (z2) {
                return this.f2715a ? 1 : 0;
            }
            return 2;
        }
    }

    private static class FirstStrong implements TextDirectionAlgorithm {

        /* renamed from: a  reason: collision with root package name */
        static final FirstStrong f2716a = new FirstStrong();

        private FirstStrong() {
        }

        public int a(CharSequence charSequence, int i2, int i3) {
            int i4 = i3 + i2;
            int i5 = 2;
            while (i2 < i4 && i5 == 2) {
                i5 = TextDirectionHeuristicsCompat.b(Character.getDirectionality(charSequence.charAt(i2)));
                i2++;
            }
            return i5;
        }
    }

    private interface TextDirectionAlgorithm {
        int a(CharSequence charSequence, int i2, int i3);
    }

    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {

        /* renamed from: a  reason: collision with root package name */
        private final TextDirectionAlgorithm f2717a;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f2717a = textDirectionAlgorithm;
        }

        private boolean b(CharSequence charSequence, int i2, int i3) {
            int a2 = this.f2717a.a(charSequence, i2, i3);
            if (a2 == 0) {
                return true;
            }
            if (a2 != 1) {
                return a();
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public abstract boolean a();

        public boolean isRtl(CharSequence charSequence, int i2, int i3) {
            if (charSequence == null || i2 < 0 || i3 < 0 || charSequence.length() - i3 < i2) {
                throw new IllegalArgumentException();
            } else if (this.f2717a == null) {
                return a();
            } else {
                return b(charSequence, i2, i3);
            }
        }
    }

    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f2718b;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z2) {
            super(textDirectionAlgorithm);
            this.f2718b = z2;
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return this.f2718b;
        }
    }

    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {

        /* renamed from: b  reason: collision with root package name */
        static final TextDirectionHeuristicLocale f2719b = new TextDirectionHeuristicLocale();

        TextDirectionHeuristicLocale() {
            super((TextDirectionAlgorithm) null);
        }

        /* access modifiers changed from: protected */
        public boolean a() {
            return TextUtilsCompat.a(Locale.getDefault()) == 1;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.f2716a;
        f2710c = new TextDirectionHeuristicInternal(firstStrong, false);
        f2711d = new TextDirectionHeuristicInternal(firstStrong, true);
    }

    private TextDirectionHeuristicsCompat() {
    }

    static int a(int i2) {
        if (i2 != 0) {
            return (i2 == 1 || i2 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i2) {
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2) {
                return 0;
            }
            switch (i2) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}

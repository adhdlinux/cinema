package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Splitter {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharMatcher f30404a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final boolean f30405b;

    /* renamed from: c  reason: collision with root package name */
    private final Strategy f30406c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final int f30407d;

    private static abstract class SplittingIterator extends AbstractIterator<String> {

        /* renamed from: d  reason: collision with root package name */
        final CharSequence f30410d;

        /* renamed from: e  reason: collision with root package name */
        final CharMatcher f30411e;

        /* renamed from: f  reason: collision with root package name */
        final boolean f30412f;

        /* renamed from: g  reason: collision with root package name */
        int f30413g = 0;

        /* renamed from: h  reason: collision with root package name */
        int f30414h;

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.f30411e = splitter.f30404a;
            this.f30412f = splitter.f30405b;
            this.f30414h = splitter.f30407d;
            this.f30410d = charSequence;
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public String a() {
            int i2;
            int i3 = this.f30413g;
            while (true) {
                int i4 = this.f30413g;
                if (i4 == -1) {
                    return (String) b();
                }
                int f2 = f(i4);
                if (f2 == -1) {
                    f2 = this.f30410d.length();
                    this.f30413g = -1;
                } else {
                    this.f30413g = e(f2);
                }
                int i5 = this.f30413g;
                if (i5 == i3) {
                    int i6 = i5 + 1;
                    this.f30413g = i6;
                    if (i6 > this.f30410d.length()) {
                        this.f30413g = -1;
                    }
                } else {
                    while (i3 < f2 && this.f30411e.e(this.f30410d.charAt(i3))) {
                        i3++;
                    }
                    while (i2 > i3 && this.f30411e.e(this.f30410d.charAt(i2 - 1))) {
                        f2 = i2 - 1;
                    }
                    if (!this.f30412f || i3 != i2) {
                        int i7 = this.f30414h;
                    } else {
                        i3 = this.f30413g;
                    }
                }
            }
            int i72 = this.f30414h;
            if (i72 == 1) {
                i2 = this.f30410d.length();
                this.f30413g = -1;
                while (i2 > i3 && this.f30411e.e(this.f30410d.charAt(i2 - 1))) {
                    i2--;
                }
            } else {
                this.f30414h = i72 - 1;
            }
            return this.f30410d.subSequence(i3, i2).toString();
        }

        /* access modifiers changed from: package-private */
        public abstract int e(int i2);

        /* access modifiers changed from: package-private */
        public abstract int f(int i2);
    }

    private interface Strategy {
        Iterator<String> a(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.f(), Integer.MAX_VALUE);
    }

    public static Splitter d(char c2) {
        return e(CharMatcher.d(c2));
    }

    public static Splitter e(final CharMatcher charMatcher) {
        Preconditions.l(charMatcher);
        return new Splitter(new Strategy() {
            /* renamed from: b */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) {
                    /* access modifiers changed from: package-private */
                    public int e(int i2) {
                        return i2 + 1;
                    }

                    /* access modifiers changed from: package-private */
                    public int f(int i2) {
                        return CharMatcher.this.c(this.f30410d, i2);
                    }
                };
            }
        });
    }

    private Iterator<String> g(CharSequence charSequence) {
        return this.f30406c.a(this, charSequence);
    }

    public List<String> f(CharSequence charSequence) {
        Preconditions.l(charSequence);
        Iterator<String> g2 = g(charSequence);
        ArrayList arrayList = new ArrayList();
        while (g2.hasNext()) {
            arrayList.add(g2.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    private Splitter(Strategy strategy, boolean z2, CharMatcher charMatcher, int i2) {
        this.f30406c = strategy;
        this.f30405b = z2;
        this.f30404a = charMatcher;
        this.f30407d = i2;
    }
}

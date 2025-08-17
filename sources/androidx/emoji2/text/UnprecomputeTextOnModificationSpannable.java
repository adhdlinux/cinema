package androidx.emoji2.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

class UnprecomputeTextOnModificationSpannable implements Spannable {

    /* renamed from: b  reason: collision with root package name */
    private boolean f3134b = false;

    /* renamed from: c  reason: collision with root package name */
    private Spannable f3135c;

    private static class CharSequenceHelper_API24 {
        private CharSequenceHelper_API24() {
        }

        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        /* access modifiers changed from: package-private */
        public boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof PrecomputedTextCompat);
        }
    }

    UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.f3135c = spannable;
    }

    private void a() {
        Spannable spannable = this.f3135c;
        if (!this.f3134b && c().a(spannable)) {
            this.f3135c = new SpannableString(spannable);
        }
        this.f3134b = true;
    }

    static PrecomputedTextDetector c() {
        if (Build.VERSION.SDK_INT < 28) {
            return new PrecomputedTextDetector();
        }
        return new PrecomputedTextDetector_28();
    }

    /* access modifiers changed from: package-private */
    public Spannable b() {
        return this.f3135c;
    }

    public char charAt(int i2) {
        return this.f3135c.charAt(i2);
    }

    public IntStream chars() {
        return CharSequenceHelper_API24.a(this.f3135c);
    }

    public IntStream codePoints() {
        return CharSequenceHelper_API24.b(this.f3135c);
    }

    public int getSpanEnd(Object obj) {
        return this.f3135c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f3135c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f3135c.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return this.f3135c.getSpans(i2, i3, cls);
    }

    public int length() {
        return this.f3135c.length();
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f3135c.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(Object obj) {
        a();
        this.f3135c.removeSpan(obj);
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        a();
        this.f3135c.setSpan(obj, i2, i3, i4);
    }

    public CharSequence subSequence(int i2, int i3) {
        return this.f3135c.subSequence(i2, i3);
    }

    public String toString() {
        return this.f3135c.toString();
    }

    UnprecomputeTextOnModificationSpannable(CharSequence charSequence) {
        this.f3135c = new SpannableString(charSequence);
    }
}

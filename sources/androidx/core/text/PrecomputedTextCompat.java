package androidx.core.text;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.util.ObjectsCompat;

public class PrecomputedTextCompat implements Spannable {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f2695e = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final Spannable f2696b;

    /* renamed from: c  reason: collision with root package name */
    private final Params f2697c;

    /* renamed from: d  reason: collision with root package name */
    private final PrecomputedText f2698d;

    public Params a() {
        return this.f2697c;
    }

    public PrecomputedText b() {
        Spannable spannable = this.f2696b;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public char charAt(int i2) {
        return this.f2696b.charAt(i2);
    }

    public int getSpanEnd(Object obj) {
        return this.f2696b.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f2696b.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f2696b.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f2698d.getSpans(i2, i3, cls);
        }
        return this.f2696b.getSpans(i2, i3, cls);
    }

    public int length() {
        return this.f2696b.length();
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f2696b.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2698d.removeSpan(obj);
        } else {
            this.f2696b.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2698d.setSpan(obj, i2, i3, i4);
        } else {
            this.f2696b.setSpan(obj, i2, i3, i4);
        }
    }

    public CharSequence subSequence(int i2, int i3) {
        return this.f2696b.subSequence(i2, i3);
    }

    public String toString() {
        return this.f2696b.toString();
    }

    public static final class Params {

        /* renamed from: a  reason: collision with root package name */
        private final TextPaint f2699a;

        /* renamed from: b  reason: collision with root package name */
        private final TextDirectionHeuristic f2700b;

        /* renamed from: c  reason: collision with root package name */
        private final int f2701c;

        /* renamed from: d  reason: collision with root package name */
        private final int f2702d;

        /* renamed from: e  reason: collision with root package name */
        final PrecomputedText.Params f2703e;

        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f2704a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f2705b;

            /* renamed from: c  reason: collision with root package name */
            private int f2706c;

            /* renamed from: d  reason: collision with root package name */
            private int f2707d;

            public Builder(TextPaint textPaint) {
                this.f2704a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f2706c = 1;
                    this.f2707d = 1;
                } else {
                    this.f2707d = 0;
                    this.f2706c = 0;
                }
                this.f2705b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public Params a() {
                return new Params(this.f2704a, this.f2705b, this.f2706c, this.f2707d);
            }

            public Builder b(int i2) {
                this.f2706c = i2;
                return this;
            }

            public Builder c(int i2) {
                this.f2707d = i2;
                return this;
            }

            public Builder d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2705b = textDirectionHeuristic;
                return this;
            }
        }

        Params(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f2703e = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build();
            } else {
                this.f2703e = null;
            }
            this.f2699a = textPaint;
            this.f2700b = textDirectionHeuristic;
            this.f2701c = i2;
            this.f2702d = i3;
        }

        public boolean a(Params params) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 23 && (this.f2701c != params.b() || this.f2702d != params.c())) || this.f2699a.getTextSize() != params.e().getTextSize() || this.f2699a.getTextScaleX() != params.e().getTextScaleX() || this.f2699a.getTextSkewX() != params.e().getTextSkewX() || this.f2699a.getLetterSpacing() != params.e().getLetterSpacing() || !TextUtils.equals(this.f2699a.getFontFeatureSettings(), params.e().getFontFeatureSettings()) || this.f2699a.getFlags() != params.e().getFlags()) {
                return false;
            }
            if (i2 >= 24) {
                if (!this.f2699a.getTextLocales().equals(params.e().getTextLocales())) {
                    return false;
                }
            } else if (!this.f2699a.getTextLocale().equals(params.e().getTextLocale())) {
                return false;
            }
            if (this.f2699a.getTypeface() == null) {
                if (params.e().getTypeface() != null) {
                    return false;
                }
                return true;
            } else if (!this.f2699a.getTypeface().equals(params.e().getTypeface())) {
                return false;
            } else {
                return true;
            }
        }

        public int b() {
            return this.f2701c;
        }

        public int c() {
            return this.f2702d;
        }

        public TextDirectionHeuristic d() {
            return this.f2700b;
        }

        public TextPaint e() {
            return this.f2699a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            if (a(params) && this.f2700b == params.d()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return ObjectsCompat.b(Float.valueOf(this.f2699a.getTextSize()), Float.valueOf(this.f2699a.getTextScaleX()), Float.valueOf(this.f2699a.getTextSkewX()), Float.valueOf(this.f2699a.getLetterSpacing()), Integer.valueOf(this.f2699a.getFlags()), this.f2699a.getTextLocales(), this.f2699a.getTypeface(), Boolean.valueOf(this.f2699a.isElegantTextHeight()), this.f2700b, Integer.valueOf(this.f2701c), Integer.valueOf(this.f2702d));
            }
            return ObjectsCompat.b(Float.valueOf(this.f2699a.getTextSize()), Float.valueOf(this.f2699a.getTextScaleX()), Float.valueOf(this.f2699a.getTextSkewX()), Float.valueOf(this.f2699a.getLetterSpacing()), Integer.valueOf(this.f2699a.getFlags()), this.f2699a.getTextLocale(), this.f2699a.getTypeface(), Boolean.valueOf(this.f2699a.isElegantTextHeight()), this.f2700b, Integer.valueOf(this.f2701c), Integer.valueOf(this.f2702d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f2699a.getTextSize());
            sb.append(", textScaleX=" + this.f2699a.getTextScaleX());
            sb.append(", textSkewX=" + this.f2699a.getTextSkewX());
            int i2 = Build.VERSION.SDK_INT;
            sb.append(", letterSpacing=" + this.f2699a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f2699a.isElegantTextHeight());
            if (i2 >= 24) {
                sb.append(", textLocale=" + this.f2699a.getTextLocales());
            } else {
                sb.append(", textLocale=" + this.f2699a.getTextLocale());
            }
            sb.append(", typeface=" + this.f2699a.getTypeface());
            if (i2 >= 26) {
                sb.append(", variationSettings=" + this.f2699a.getFontVariationSettings());
            }
            sb.append(", textDir=" + this.f2700b);
            sb.append(", breakStrategy=" + this.f2701c);
            sb.append(", hyphenationFrequency=" + this.f2702d);
            sb.append("}");
            return sb.toString();
        }

        public Params(PrecomputedText.Params params) {
            this.f2699a = params.getTextPaint();
            this.f2700b = params.getTextDirection();
            this.f2701c = params.getBreakStrategy();
            this.f2702d = params.getHyphenationFrequency();
            this.f2703e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}

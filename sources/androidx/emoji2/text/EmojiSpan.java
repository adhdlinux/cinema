package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

public abstract class EmojiSpan extends ReplacementSpan {

    /* renamed from: b  reason: collision with root package name */
    private final Paint.FontMetricsInt f3102b = new Paint.FontMetricsInt();

    /* renamed from: c  reason: collision with root package name */
    private final EmojiMetadata f3103c;

    /* renamed from: d  reason: collision with root package name */
    private short f3104d = -1;

    /* renamed from: e  reason: collision with root package name */
    private short f3105e = -1;

    /* renamed from: f  reason: collision with root package name */
    private float f3106f = 1.0f;

    EmojiSpan(EmojiMetadata emojiMetadata) {
        Preconditions.h(emojiMetadata, "metadata cannot be null");
        this.f3103c = emojiMetadata;
    }

    public final EmojiMetadata a() {
        return this.f3103c;
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.f3104d;
    }

    public int getSize(Paint paint, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f3102b);
        Paint.FontMetricsInt fontMetricsInt2 = this.f3102b;
        this.f3106f = (((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f) / ((float) this.f3103c.e());
        this.f3105e = (short) ((int) (((float) this.f3103c.e()) * this.f3106f));
        short i4 = (short) ((int) (((float) this.f3103c.i()) * this.f3106f));
        this.f3104d = i4;
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt3 = this.f3102b;
            fontMetricsInt.ascent = fontMetricsInt3.ascent;
            fontMetricsInt.descent = fontMetricsInt3.descent;
            fontMetricsInt.top = fontMetricsInt3.top;
            fontMetricsInt.bottom = fontMetricsInt3.bottom;
        }
        return i4;
    }
}

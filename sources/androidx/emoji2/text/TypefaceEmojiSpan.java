package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

public final class TypefaceEmojiSpan extends EmojiSpan {

    /* renamed from: g  reason: collision with root package name */
    private static Paint f3133g;

    public TypefaceEmojiSpan(EmojiMetadata emojiMetadata) {
        super(emojiMetadata);
    }

    private static Paint c() {
        if (f3133g == null) {
            TextPaint textPaint = new TextPaint();
            f3133g = textPaint;
            textPaint.setColor(EmojiCompat.b().c());
            f3133g.setStyle(Paint.Style.FILL);
        }
        return f3133g;
    }

    public void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        if (EmojiCompat.b().i()) {
            canvas.drawRect(f2, (float) i4, f2 + ((float) b()), (float) i6, c());
        }
        a().a(canvas, f2, (float) i5, paint);
    }
}

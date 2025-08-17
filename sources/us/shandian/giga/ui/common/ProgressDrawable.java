package us.shandian.giga.ui.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

public class ProgressDrawable extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private float f42275a;

    /* renamed from: b  reason: collision with root package name */
    private int f42276b;

    /* renamed from: c  reason: collision with root package name */
    private int f42277c;

    public ProgressDrawable(Context context, int i2, int i3) {
        this(ContextCompat.getColor(context, i2), ContextCompat.getColor(context, i3));
    }

    public void a(float f2) {
        this.f42275a = f2;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Paint paint = new Paint();
        paint.setColor(this.f42276b);
        float f2 = (float) width;
        float f3 = (float) height;
        Paint paint2 = paint;
        canvas.drawRect(0.0f, 0.0f, f2, f3, paint2);
        paint.setColor(this.f42277c);
        canvas.drawRect(0.0f, 0.0f, (float) ((int) (this.f42275a * f2)), f3, paint2);
    }

    public int getOpacity() {
        return -1;
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public ProgressDrawable(int i2, int i3) {
        this.f42276b = i2;
        this.f42277c = i3;
    }
}

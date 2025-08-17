package com.flask.colorpicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import com.flask.colorpicker.builder.PaintBuilder;

public class ColorCircleDrawable extends ColorDrawable {

    /* renamed from: a  reason: collision with root package name */
    private float f21915a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f21916b = PaintBuilder.c().e(Paint.Style.STROKE).d(this.f21915a).b(-6381922).a();

    /* renamed from: c  reason: collision with root package name */
    private Paint f21917c = PaintBuilder.c().e(Paint.Style.FILL).b(0).a();

    /* renamed from: d  reason: collision with root package name */
    private Paint f21918d = PaintBuilder.c().c(PaintBuilder.b(26)).a();

    public ColorCircleDrawable(int i2) {
        super(i2);
    }

    public void draw(Canvas canvas) {
        canvas.drawColor(0);
        float width = ((float) canvas.getWidth()) / 2.0f;
        float f2 = width / 8.0f;
        this.f21915a = f2;
        this.f21916b.setStrokeWidth(f2);
        this.f21917c.setColor(getColor());
        canvas.drawCircle(width, width, width - this.f21915a, this.f21918d);
        canvas.drawCircle(width, width, width - this.f21915a, this.f21917c);
        canvas.drawCircle(width, width, width - this.f21915a, this.f21916b);
    }

    public void setColor(int i2) {
        super.setColor(i2);
        invalidateSelf();
    }
}

package com.flask.colorpicker.renderer;

import android.graphics.Color;
import android.graphics.Paint;
import com.flask.colorpicker.ColorCircle;
import com.flask.colorpicker.builder.PaintBuilder;

public class FlowerColorWheelRenderer extends AbsColorWheelRenderer {

    /* renamed from: c  reason: collision with root package name */
    private Paint f22022c = PaintBuilder.c().a();

    /* renamed from: d  reason: collision with root package name */
    private float[] f22023d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    private float f22024e = 1.2f;

    public void a() {
        float f2;
        int size = this.f22014b.size();
        float f3 = 2.0f;
        float width = ((float) this.f22013a.f22021g.getWidth()) / 2.0f;
        ColorWheelRenderOption colorWheelRenderOption = this.f22013a;
        int i2 = colorWheelRenderOption.f22015a;
        float f4 = colorWheelRenderOption.f22018d;
        float f5 = colorWheelRenderOption.f22016b;
        float f6 = colorWheelRenderOption.f22017c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            float f7 = (float) i3;
            float f8 = f7 / ((float) (i2 - 1));
            float f9 = (float) i2;
            float f10 = (f7 - (f9 / f3)) / f9;
            float f11 = f8 * f5;
            float f12 = 1.5f + f4;
            if (i3 == 0) {
                f2 = 0.0f;
            } else {
                f2 = f10 * this.f22024e * f6;
            }
            float max = Math.max(f12, f2 + f6);
            int min = Math.min(e(f11, max), i2 * 2);
            int i5 = 0;
            while (i5 < min) {
                float f13 = f6;
                int i6 = i3;
                double d2 = (double) min;
                int i7 = min;
                int i8 = i5;
                double d3 = ((((double) i5) * 6.283185307179586d) / d2) + ((3.141592653589793d / d2) * ((double) ((i6 + 1) % 2)));
                double d4 = (double) f11;
                float cos = ((float) (Math.cos(d3) * d4)) + width;
                float sin = ((float) (d4 * Math.sin(d3))) + width;
                float[] fArr = this.f22023d;
                fArr[0] = (float) ((d3 * 180.0d) / 3.141592653589793d);
                fArr[1] = f11 / f5;
                fArr[2] = this.f22013a.f22020f;
                this.f22022c.setColor(Color.HSVToColor(fArr));
                this.f22022c.setAlpha(f());
                this.f22013a.f22021g.drawCircle(cos, sin, max - f4, this.f22022c);
                if (i4 >= size) {
                    this.f22014b.add(new ColorCircle(cos, sin, this.f22023d));
                } else {
                    this.f22014b.get(i4).f(cos, sin, this.f22023d);
                }
                i4++;
                i5 = i8 + 1;
                i3 = i6;
                f6 = f13;
                min = i7;
            }
            i3++;
            f6 = f6;
            f3 = 2.0f;
        }
    }
}

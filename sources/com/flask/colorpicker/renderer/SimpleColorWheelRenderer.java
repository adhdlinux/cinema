package com.flask.colorpicker.renderer;

import android.graphics.Color;
import android.graphics.Paint;
import com.flask.colorpicker.ColorCircle;
import com.flask.colorpicker.builder.PaintBuilder;

public class SimpleColorWheelRenderer extends AbsColorWheelRenderer {

    /* renamed from: c  reason: collision with root package name */
    private Paint f22025c = PaintBuilder.c().a();

    /* renamed from: d  reason: collision with root package name */
    private float[] f22026d = new float[3];

    public void a() {
        int size = this.f22014b.size();
        float width = ((float) this.f22013a.f22021g.getWidth()) / 2.0f;
        ColorWheelRenderOption colorWheelRenderOption = this.f22013a;
        int i2 = colorWheelRenderOption.f22015a;
        float f2 = colorWheelRenderOption.f22016b;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            float f3 = (((float) i4) / ((float) (i2 - 1))) * f2;
            float f4 = this.f22013a.f22017c;
            int e2 = e(f3, f4);
            int i5 = 0;
            while (i5 < e2) {
                double d2 = (double) e2;
                int i6 = i2;
                double d3 = ((((double) i5) * 6.283185307179586d) / d2) + ((3.141592653589793d / d2) * ((double) ((i4 + 1) % 2)));
                double d4 = (double) f3;
                float cos = ((float) (Math.cos(d3) * d4)) + width;
                float sin = ((float) (d4 * Math.sin(d3))) + width;
                float[] fArr = this.f22026d;
                fArr[0] = (float) ((d3 * 180.0d) / 3.141592653589793d);
                fArr[1] = f3 / f2;
                fArr[2] = this.f22013a.f22020f;
                this.f22025c.setColor(Color.HSVToColor(fArr));
                this.f22025c.setAlpha(f());
                ColorWheelRenderOption colorWheelRenderOption2 = this.f22013a;
                colorWheelRenderOption2.f22021g.drawCircle(cos, sin, f4 - colorWheelRenderOption2.f22018d, this.f22025c);
                if (i3 >= size) {
                    this.f22014b.add(new ColorCircle(cos, sin, this.f22026d));
                } else {
                    this.f22014b.get(i3).f(cos, sin, this.f22026d);
                }
                i3++;
                i5++;
                i2 = i6;
            }
            int i7 = i2;
        }
    }
}

package com.flask.colorpicker.slider;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.Utils;
import com.flask.colorpicker.builder.PaintBuilder;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

public class LightnessSlider extends AbsCustomSlider {

    /* renamed from: l  reason: collision with root package name */
    private int f22046l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f22047m = PaintBuilder.c().a();

    /* renamed from: n  reason: collision with root package name */
    private Paint f22048n = PaintBuilder.c().a();

    /* renamed from: o  reason: collision with root package name */
    private Paint f22049o = PaintBuilder.c().b(-1).f(PorterDuff.Mode.CLEAR).a();

    /* renamed from: p  reason: collision with root package name */
    private ColorPickerView f22050p;

    public LightnessSlider(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        float[] fArr = new float[3];
        Color.colorToHSV(this.f22046l, fArr);
        int max = Math.max(2, width / UserVerificationMethods.USER_VERIFY_HANDPRINT);
        int i2 = 0;
        while (i2 <= width) {
            float f2 = (float) i2;
            fArr[2] = f2 / ((float) (width - 1));
            this.f22047m.setColor(Color.HSVToColor(fArr));
            i2 += max;
            canvas.drawRect(f2, 0.0f, (float) i2, (float) height, this.f22047m);
        }
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas, float f2, float f3) {
        this.f22048n.setColor(Utils.c(this.f22046l, this.f22034i));
        if (this.f22035j) {
            canvas.drawCircle(f2, f3, (float) this.f22032g, this.f22049o);
        }
        canvas.drawCircle(f2, f3, ((float) this.f22032g) * 0.75f, this.f22048n);
    }

    /* access modifiers changed from: protected */
    public void f(float f2) {
        ColorPickerView colorPickerView = this.f22050p;
        if (colorPickerView != null) {
            colorPickerView.setLightness(f2);
        }
    }

    public void setColor(int i2) {
        this.f22046l = i2;
        this.f22034i = Utils.f(i2);
        if (this.f22029d != null) {
            g();
            invalidate();
        }
    }

    public void setColorPicker(ColorPickerView colorPickerView) {
        this.f22050p = colorPickerView;
    }

    public LightnessSlider(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

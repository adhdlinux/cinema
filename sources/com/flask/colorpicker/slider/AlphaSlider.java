package com.flask.colorpicker.slider;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.Utils;
import com.flask.colorpicker.builder.PaintBuilder;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

public class AlphaSlider extends AbsCustomSlider {

    /* renamed from: l  reason: collision with root package name */
    public int f22037l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f22038m = PaintBuilder.c().a();

    /* renamed from: n  reason: collision with root package name */
    private Paint f22039n = PaintBuilder.c().a();

    /* renamed from: o  reason: collision with root package name */
    private Paint f22040o = PaintBuilder.c().a();

    /* renamed from: p  reason: collision with root package name */
    private Paint f22041p = PaintBuilder.c().b(-1).f(PorterDuff.Mode.CLEAR).a();

    /* renamed from: q  reason: collision with root package name */
    private Paint f22042q = PaintBuilder.c().a();

    /* renamed from: r  reason: collision with root package name */
    private Bitmap f22043r;

    /* renamed from: s  reason: collision with root package name */
    private Canvas f22044s;

    /* renamed from: t  reason: collision with root package name */
    private ColorPickerView f22045t;

    public AlphaSlider(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        this.f22038m.setShader(PaintBuilder.b(this.f22033h * 2));
        this.f22043r = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.f22044s = new Canvas(this.f22043r);
    }

    /* access modifiers changed from: protected */
    public void b(Canvas canvas) {
        int width = canvas.getWidth();
        float height = (float) canvas.getHeight();
        canvas.drawRect(0.0f, 0.0f, (float) width, height, this.f22038m);
        int max = Math.max(2, width / UserVerificationMethods.USER_VERIFY_HANDPRINT);
        int i2 = 0;
        while (i2 <= width) {
            float f2 = (float) i2;
            this.f22039n.setColor(this.f22037l);
            this.f22039n.setAlpha(Math.round((f2 / ((float) (width - 1))) * 255.0f));
            i2 += max;
            canvas.drawRect(f2, 0.0f, (float) i2, height, this.f22039n);
        }
    }

    /* access modifiers changed from: protected */
    public void c(Canvas canvas, float f2, float f3) {
        this.f22040o.setColor(this.f22037l);
        this.f22040o.setAlpha(Math.round(this.f22034i * 255.0f));
        if (this.f22035j) {
            canvas.drawCircle(f2, f3, (float) this.f22032g, this.f22041p);
        }
        if (this.f22034i < 1.0f) {
            this.f22044s.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f22044s.drawCircle(f2, f3, (((float) this.f22032g) * 0.75f) + 4.0f, this.f22038m);
            this.f22044s.drawCircle(f2, f3, (((float) this.f22032g) * 0.75f) + 4.0f, this.f22040o);
            Paint a2 = PaintBuilder.c().b(-1).e(Paint.Style.STROKE).d(6.0f).f(PorterDuff.Mode.CLEAR).a();
            this.f22042q = a2;
            this.f22044s.drawCircle(f2, f3, (((float) this.f22032g) * 0.75f) + (a2.getStrokeWidth() / 2.0f), this.f22042q);
            canvas.drawBitmap(this.f22043r, 0.0f, 0.0f, (Paint) null);
            return;
        }
        canvas.drawCircle(f2, f3, ((float) this.f22032g) * 0.75f, this.f22040o);
    }

    /* access modifiers changed from: protected */
    public void f(float f2) {
        ColorPickerView colorPickerView = this.f22045t;
        if (colorPickerView != null) {
            colorPickerView.setAlphaValue(f2);
        }
    }

    public void setColor(int i2) {
        this.f22037l = i2;
        this.f22034i = Utils.d(i2);
        if (this.f22029d != null) {
            g();
            invalidate();
        }
    }

    public void setColorPicker(ColorPickerView colorPickerView) {
        this.f22045t = colorPickerView;
    }

    public AlphaSlider(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

package com.flask.colorpicker.renderer;

import com.flask.colorpicker.ColorCircle;
import java.util.ArrayList;
import java.util.List;

public abstract class AbsColorWheelRenderer implements ColorWheelRenderer {

    /* renamed from: a  reason: collision with root package name */
    protected ColorWheelRenderOption f22013a;

    /* renamed from: b  reason: collision with root package name */
    protected List<ColorCircle> f22014b = new ArrayList();

    public ColorWheelRenderOption b() {
        if (this.f22013a == null) {
            this.f22013a = new ColorWheelRenderOption();
        }
        return this.f22013a;
    }

    public void c(ColorWheelRenderOption colorWheelRenderOption) {
        this.f22013a = colorWheelRenderOption;
        this.f22014b.clear();
    }

    public List<ColorCircle> d() {
        return this.f22014b;
    }

    /* access modifiers changed from: protected */
    public int e(float f2, float f3) {
        return Math.max(1, (int) ((3.063052912151454d / Math.asin((double) (f3 / f2))) + 0.5d));
    }

    /* access modifiers changed from: protected */
    public int f() {
        return Math.round(this.f22013a.f22019e * 255.0f);
    }
}

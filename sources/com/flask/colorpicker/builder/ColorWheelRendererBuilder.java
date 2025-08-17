package com.flask.colorpicker.builder;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.renderer.ColorWheelRenderer;
import com.flask.colorpicker.renderer.FlowerColorWheelRenderer;
import com.flask.colorpicker.renderer.SimpleColorWheelRenderer;

public class ColorWheelRendererBuilder {

    /* renamed from: com.flask.colorpicker.builder.ColorWheelRendererBuilder$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22011a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.flask.colorpicker.ColorPickerView$WHEEL_TYPE[] r0 = com.flask.colorpicker.ColorPickerView.WHEEL_TYPE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22011a = r0
                com.flask.colorpicker.ColorPickerView$WHEEL_TYPE r1 = com.flask.colorpicker.ColorPickerView.WHEEL_TYPE.CIRCLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22011a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.flask.colorpicker.ColorPickerView$WHEEL_TYPE r1 = com.flask.colorpicker.ColorPickerView.WHEEL_TYPE.FLOWER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.flask.colorpicker.builder.ColorWheelRendererBuilder.AnonymousClass1.<clinit>():void");
        }
    }

    public static ColorWheelRenderer a(ColorPickerView.WHEEL_TYPE wheel_type) {
        int i2 = AnonymousClass1.f22011a[wheel_type.ordinal()];
        if (i2 == 1) {
            return new SimpleColorWheelRenderer();
        }
        if (i2 == 2) {
            return new FlowerColorWheelRenderer();
        }
        throw new IllegalArgumentException("wrong WHEEL_TYPE");
    }
}

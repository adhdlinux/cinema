package com.flask.colorpicker.builder;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;

public class PaintBuilder {

    public static class PaintHolder {

        /* renamed from: a  reason: collision with root package name */
        private Paint f22012a;

        public Paint a() {
            return this.f22012a;
        }

        public PaintHolder b(int i2) {
            this.f22012a.setColor(i2);
            return this;
        }

        public PaintHolder c(Shader shader) {
            this.f22012a.setShader(shader);
            return this;
        }

        public PaintHolder d(float f2) {
            this.f22012a.setStrokeWidth(f2);
            return this;
        }

        public PaintHolder e(Paint.Style style) {
            this.f22012a.setStyle(style);
            return this;
        }

        public PaintHolder f(PorterDuff.Mode mode) {
            this.f22012a.setXfermode(new PorterDuffXfermode(mode));
            return this;
        }

        private PaintHolder() {
            this.f22012a = new Paint(1);
        }
    }

    private static Bitmap a(int i2) {
        Paint a2 = c().a();
        Bitmap createBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int round = Math.round(((float) i2) / 2.0f);
        for (int i3 = 0; i3 < 2; i3++) {
            int i4 = 0;
            while (i4 < 2) {
                if ((i3 + i4) % 2 == 0) {
                    a2.setColor(-1);
                } else {
                    a2.setColor(-3092272);
                }
                int i5 = i4 + 1;
                Canvas canvas2 = canvas;
                canvas2.drawRect((float) (i3 * round), (float) (i4 * round), (float) ((i3 + 1) * round), (float) (i5 * round), a2);
                i4 = i5;
            }
        }
        return createBitmap;
    }

    public static Shader b(int i2) {
        Bitmap a2 = a(Math.max(8, (i2 / 2) * 2));
        Shader.TileMode tileMode = Shader.TileMode.REPEAT;
        return new BitmapShader(a2, tileMode, tileMode);
    }

    public static PaintHolder c() {
        return new PaintHolder();
    }
}

package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.gif.GifFrameLoader;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.List;

public class GifDrawable extends Drawable implements GifFrameLoader.FrameCallback, Animatable {

    /* renamed from: b  reason: collision with root package name */
    private final GifState f16916b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f16917c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16918d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16919e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16920f;

    /* renamed from: g  reason: collision with root package name */
    private int f16921g;

    /* renamed from: h  reason: collision with root package name */
    private int f16922h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f16923i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f16924j;

    /* renamed from: k  reason: collision with root package name */
    private Rect f16925k;

    /* renamed from: l  reason: collision with root package name */
    private List<Animatable2Compat$AnimationCallback> f16926l;

    static final class GifState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        final GifFrameLoader f16927a;

        GifState(GifFrameLoader gifFrameLoader) {
            this.f16927a = gifFrameLoader;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        public Drawable newDrawable() {
            return new GifDrawable(this);
        }
    }

    public GifDrawable(Context context, GifDecoder gifDecoder, Transformation<Bitmap> transformation, int i2, int i3, Bitmap bitmap) {
        this(new GifState(new GifFrameLoader(Glide.c(context), gifDecoder, i2, i3, transformation, bitmap)));
    }

    private Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    private Rect d() {
        if (this.f16925k == null) {
            this.f16925k = new Rect();
        }
        return this.f16925k;
    }

    private Paint h() {
        if (this.f16924j == null) {
            this.f16924j = new Paint(2);
        }
        return this.f16924j;
    }

    private void j() {
        List<Animatable2Compat$AnimationCallback> list = this.f16926l;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f16926l.get(i2).a(this);
            }
        }
    }

    private void l() {
        this.f16921g = 0;
    }

    private void n() {
        Preconditions.a(!this.f16919e, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f16916b.f16927a.f() == 1) {
            invalidateSelf();
        } else if (!this.f16917c) {
            this.f16917c = true;
            this.f16916b.f16927a.r(this);
            invalidateSelf();
        }
    }

    private void o() {
        this.f16917c = false;
        this.f16916b.f16927a.s(this);
    }

    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f16921g++;
        }
        int i2 = this.f16922h;
        if (i2 != -1 && this.f16921g >= i2) {
            j();
            stop();
        }
    }

    public ByteBuffer c() {
        return this.f16916b.f16927a.b();
    }

    public void draw(Canvas canvas) {
        if (!this.f16919e) {
            if (this.f16923i) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
                this.f16923i = false;
            }
            canvas.drawBitmap(this.f16916b.f16927a.c(), (Rect) null, d(), h());
        }
    }

    public Bitmap e() {
        return this.f16916b.f16927a.e();
    }

    public int f() {
        return this.f16916b.f16927a.f();
    }

    public int g() {
        return this.f16916b.f16927a.d();
    }

    public Drawable.ConstantState getConstantState() {
        return this.f16916b;
    }

    public int getIntrinsicHeight() {
        return this.f16916b.f16927a.h();
    }

    public int getIntrinsicWidth() {
        return this.f16916b.f16927a.k();
    }

    public int getOpacity() {
        return -2;
    }

    public int i() {
        return this.f16916b.f16927a.j();
    }

    public boolean isRunning() {
        return this.f16917c;
    }

    public void k() {
        this.f16919e = true;
        this.f16916b.f16927a.a();
    }

    public void m(Transformation<Bitmap> transformation, Bitmap bitmap) {
        this.f16916b.f16927a.o(transformation, bitmap);
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f16923i = true;
    }

    public void setAlpha(int i2) {
        h().setAlpha(i2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z2, boolean z3) {
        Preconditions.a(!this.f16919e, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f16920f = z2;
        if (!z2) {
            o();
        } else if (this.f16918d) {
            n();
        }
        return super.setVisible(z2, z3);
    }

    public void start() {
        this.f16918d = true;
        l();
        if (this.f16920f) {
            n();
        }
    }

    public void stop() {
        this.f16918d = false;
        o();
    }

    GifDrawable(GifState gifState) {
        this.f16920f = true;
        this.f16922h = -1;
        this.f16916b = (GifState) Preconditions.d(gifState);
    }
}

package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;

class CircleImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    private Animation.AnimationListener f11641b;

    /* renamed from: c  reason: collision with root package name */
    int f11642c;

    private class OvalShadow extends OvalShape {

        /* renamed from: b  reason: collision with root package name */
        private RadialGradient f11643b;

        /* renamed from: c  reason: collision with root package name */
        private Paint f11644c = new Paint();

        OvalShadow(int i2) {
            CircleImageView.this.f11642c = i2;
            a((int) rect().width());
        }

        private void a(int i2) {
            float f2 = (float) (i2 / 2);
            RadialGradient radialGradient = new RadialGradient(f2, f2, (float) CircleImageView.this.f11642c, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f11643b = radialGradient;
            this.f11644c.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = CircleImageView.this.getWidth() / 2;
            float f2 = (float) width;
            float height = (float) (CircleImageView.this.getHeight() / 2);
            canvas.drawCircle(f2, height, f2, this.f11644c);
            canvas.drawCircle(f2, height, (float) (width - CircleImageView.this.f11642c), paint);
        }

        /* access modifiers changed from: protected */
        public void onResize(float f2, float f3) {
            super.onResize(f2, f3);
            a((int) f2);
        }
    }

    CircleImageView(Context context, int i2) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f11642c = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.z0(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this.f11642c));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f11642c, (float) i4, (float) i3, 503316480);
            int i5 = this.f11642c;
            setPadding(i5, i5, i5, i5);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        ViewCompat.v0(this, shapeDrawable);
    }

    private boolean a() {
        return true;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f11641b = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f11641b;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f11641b;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f11642c * 2), getMeasuredHeight() + (this.f11642c * 2));
        }
    }

    public void setBackgroundColor(int i2) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }
}

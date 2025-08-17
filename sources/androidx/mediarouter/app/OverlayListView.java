package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class OverlayListView extends ListView {

    /* renamed from: b  reason: collision with root package name */
    private final List<OverlayObject> f10456b = new ArrayList();

    public static class OverlayObject {

        /* renamed from: a  reason: collision with root package name */
        private BitmapDrawable f10457a;

        /* renamed from: b  reason: collision with root package name */
        private float f10458b = 1.0f;

        /* renamed from: c  reason: collision with root package name */
        private Rect f10459c;

        /* renamed from: d  reason: collision with root package name */
        private Interpolator f10460d;

        /* renamed from: e  reason: collision with root package name */
        private long f10461e;

        /* renamed from: f  reason: collision with root package name */
        private Rect f10462f;

        /* renamed from: g  reason: collision with root package name */
        private int f10463g;

        /* renamed from: h  reason: collision with root package name */
        private float f10464h = 1.0f;

        /* renamed from: i  reason: collision with root package name */
        private float f10465i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        private long f10466j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f10467k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f10468l;

        /* renamed from: m  reason: collision with root package name */
        private OnAnimationEndListener f10469m;

        public interface OnAnimationEndListener {
            void onAnimationEnd();
        }

        OverlayObject(BitmapDrawable bitmapDrawable, Rect rect) {
            this.f10457a = bitmapDrawable;
            this.f10462f = rect;
            this.f10459c = new Rect(rect);
            BitmapDrawable bitmapDrawable2 = this.f10457a;
            if (bitmapDrawable2 != null) {
                bitmapDrawable2.setAlpha((int) (this.f10458b * 255.0f));
                this.f10457a.setBounds(this.f10459c);
            }
        }

        public BitmapDrawable a() {
            return this.f10457a;
        }

        public boolean b() {
            return this.f10467k;
        }

        public OverlayObject c(float f2, float f3) {
            this.f10464h = f2;
            this.f10465i = f3;
            return this;
        }

        public OverlayObject d(OnAnimationEndListener onAnimationEndListener) {
            this.f10469m = onAnimationEndListener;
            return this;
        }

        public OverlayObject e(long j2) {
            this.f10461e = j2;
            return this;
        }

        public OverlayObject f(Interpolator interpolator) {
            this.f10460d = interpolator;
            return this;
        }

        public OverlayObject g(int i2) {
            this.f10463g = i2;
            return this;
        }

        public void h(long j2) {
            this.f10466j = j2;
            this.f10467k = true;
        }

        public void i() {
            this.f10467k = true;
            this.f10468l = true;
            OnAnimationEndListener onAnimationEndListener = this.f10469m;
            if (onAnimationEndListener != null) {
                onAnimationEndListener.onAnimationEnd();
            }
        }

        public boolean j(long j2) {
            float f2;
            if (this.f10468l) {
                return false;
            }
            float f3 = 0.0f;
            float max = Math.max(0.0f, Math.min(1.0f, ((float) (j2 - this.f10466j)) / ((float) this.f10461e)));
            if (this.f10467k) {
                f3 = max;
            }
            Interpolator interpolator = this.f10460d;
            if (interpolator == null) {
                f2 = f3;
            } else {
                f2 = interpolator.getInterpolation(f3);
            }
            int i2 = (int) (((float) this.f10463g) * f2);
            Rect rect = this.f10459c;
            Rect rect2 = this.f10462f;
            rect.top = rect2.top + i2;
            rect.bottom = rect2.bottom + i2;
            float f4 = this.f10464h;
            float f5 = f4 + ((this.f10465i - f4) * f2);
            this.f10458b = f5;
            BitmapDrawable bitmapDrawable = this.f10457a;
            if (!(bitmapDrawable == null || rect == null)) {
                bitmapDrawable.setAlpha((int) (f5 * 255.0f));
                this.f10457a.setBounds(this.f10459c);
            }
            if (this.f10467k && f3 >= 1.0f) {
                this.f10468l = true;
                OnAnimationEndListener onAnimationEndListener = this.f10469m;
                if (onAnimationEndListener != null) {
                    onAnimationEndListener.onAnimationEnd();
                }
            }
            return !this.f10468l;
        }
    }

    public OverlayListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(OverlayObject overlayObject) {
        this.f10456b.add(overlayObject);
    }

    public void b() {
        for (OverlayObject next : this.f10456b) {
            if (!next.b()) {
                next.h(getDrawingTime());
            }
        }
    }

    public void c() {
        for (OverlayObject i2 : this.f10456b) {
            i2.i();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f10456b.size() > 0) {
            Iterator<OverlayObject> it2 = this.f10456b.iterator();
            while (it2.hasNext()) {
                OverlayObject next = it2.next();
                BitmapDrawable a2 = next.a();
                if (a2 != null) {
                    a2.draw(canvas);
                }
                if (!next.j(getDrawingTime())) {
                    it2.remove();
                }
            }
        }
    }

    public OverlayListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}

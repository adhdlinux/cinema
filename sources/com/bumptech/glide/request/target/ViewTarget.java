package com.bumptech.glide.request.target;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.R$id;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public abstract class ViewTarget<T extends View, Z> extends BaseTarget<Z> {

    /* renamed from: h  reason: collision with root package name */
    private static boolean f17106h;

    /* renamed from: i  reason: collision with root package name */
    private static int f17107i = R$id.glide_custom_view_target_tag;

    /* renamed from: c  reason: collision with root package name */
    protected final T f17108c;

    /* renamed from: d  reason: collision with root package name */
    private final SizeDeterminer f17109d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnAttachStateChangeListener f17110e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17111f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f17112g;

    static final class SizeDeterminer {

        /* renamed from: e  reason: collision with root package name */
        static Integer f17113e;

        /* renamed from: a  reason: collision with root package name */
        private final View f17114a;

        /* renamed from: b  reason: collision with root package name */
        private final List<SizeReadyCallback> f17115b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f17116c;

        /* renamed from: d  reason: collision with root package name */
        private SizeDeterminerLayoutListener f17117d;

        private static final class SizeDeterminerLayoutListener implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: b  reason: collision with root package name */
            private final WeakReference<SizeDeterminer> f17118b;

            SizeDeterminerLayoutListener(SizeDeterminer sizeDeterminer) {
                this.f17118b = new WeakReference<>(sizeDeterminer);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                SizeDeterminer sizeDeterminer = this.f17118b.get();
                if (sizeDeterminer == null) {
                    return true;
                }
                sizeDeterminer.a();
                return true;
            }
        }

        SizeDeterminer(View view) {
            this.f17114a = view;
        }

        private static int c(Context context) {
            if (f17113e == null) {
                Display defaultDisplay = ((WindowManager) Preconditions.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f17113e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f17113e.intValue();
        }

        private int e(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f17116c && this.f17114a.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f17114a.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f17114a.getContext());
        }

        private int f() {
            int i2;
            int paddingTop = this.f17114a.getPaddingTop() + this.f17114a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f17114a.getLayoutParams();
            if (layoutParams != null) {
                i2 = layoutParams.height;
            } else {
                i2 = 0;
            }
            return e(this.f17114a.getHeight(), i2, paddingTop);
        }

        private int g() {
            int i2;
            int paddingLeft = this.f17114a.getPaddingLeft() + this.f17114a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f17114a.getLayoutParams();
            if (layoutParams != null) {
                i2 = layoutParams.width;
            } else {
                i2 = 0;
            }
            return e(this.f17114a.getWidth(), i2, paddingLeft);
        }

        private boolean h(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private boolean i(int i2, int i3) {
            return h(i2) && h(i3);
        }

        private void j(int i2, int i3) {
            Iterator it2 = new ArrayList(this.f17115b).iterator();
            while (it2.hasNext()) {
                ((SizeReadyCallback) it2.next()).onSizeReady(i2, i3);
            }
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f17115b.isEmpty()) {
                int g2 = g();
                int f2 = f();
                if (i(g2, f2)) {
                    j(g2, f2);
                    b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f17114a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f17117d);
            }
            this.f17117d = null;
            this.f17115b.clear();
        }

        /* access modifiers changed from: package-private */
        public void d(SizeReadyCallback sizeReadyCallback) {
            int g2 = g();
            int f2 = f();
            if (i(g2, f2)) {
                sizeReadyCallback.onSizeReady(g2, f2);
                return;
            }
            if (!this.f17115b.contains(sizeReadyCallback)) {
                this.f17115b.add(sizeReadyCallback);
            }
            if (this.f17117d == null) {
                ViewTreeObserver viewTreeObserver = this.f17114a.getViewTreeObserver();
                SizeDeterminerLayoutListener sizeDeterminerLayoutListener = new SizeDeterminerLayoutListener(this);
                this.f17117d = sizeDeterminerLayoutListener;
                viewTreeObserver.addOnPreDrawListener(sizeDeterminerLayoutListener);
            }
        }

        /* access modifiers changed from: package-private */
        public void k(SizeReadyCallback sizeReadyCallback) {
            this.f17115b.remove(sizeReadyCallback);
        }
    }

    public ViewTarget(T t2) {
        this.f17108c = (View) Preconditions.d(t2);
        this.f17109d = new SizeDeterminer(t2);
    }

    private Object a() {
        return this.f17108c.getTag(f17107i);
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f17110e;
        if (onAttachStateChangeListener != null && !this.f17112g) {
            this.f17108c.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f17112g = true;
        }
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f17110e;
        if (onAttachStateChangeListener != null && this.f17112g) {
            this.f17108c.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f17112g = false;
        }
    }

    private void d(Object obj) {
        f17106h = true;
        this.f17108c.setTag(f17107i, obj);
    }

    public Request getRequest() {
        Object a2 = a();
        if (a2 == null) {
            return null;
        }
        if (a2 instanceof Request) {
            return (Request) a2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        this.f17109d.d(sizeReadyCallback);
    }

    public T getView() {
        return this.f17108c;
    }

    public void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
        this.f17109d.b();
        if (!this.f17111f) {
            c();
        }
    }

    public void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        b();
    }

    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        this.f17109d.k(sizeReadyCallback);
    }

    public void setRequest(Request request) {
        d(request);
    }

    public String toString() {
        return "Target for: " + this.f17108c;
    }
}

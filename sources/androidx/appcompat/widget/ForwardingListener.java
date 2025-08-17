package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ShowableListMenu;

public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private final float f1275b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1276c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1277d;

    /* renamed from: e  reason: collision with root package name */
    final View f1278e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f1279f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f1280g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1281h;

    /* renamed from: i  reason: collision with root package name */
    private int f1282i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f1283j = new int[2];

    private class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        public void run() {
            ViewParent parent = ForwardingListener.this.f1278e.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        public void run() {
            ForwardingListener.this.e();
        }
    }

    public ForwardingListener(View view) {
        this.f1278e = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1275b = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1276c = tapTimeout;
        this.f1277d = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1280g;
        if (runnable != null) {
            this.f1278e.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1279f;
        if (runnable2 != null) {
            this.f1278e.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        DropDownListView dropDownListView;
        boolean z2;
        View view = this.f1278e;
        ShowableListMenu b2 = b();
        if (b2 == null || !b2.isShowing() || (dropDownListView = (DropDownListView) b2.n()) == null || !dropDownListView.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(dropDownListView, obtainNoHistory);
        boolean e2 = dropDownListView.e(obtainNoHistory, this.f1282i);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 || actionMasked == 3) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!e2 || !z2) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        if (r1 != 3) goto L_0x006d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean g(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f1278e
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto L_0x000a
            return r2
        L_0x000a:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L_0x0041
            r3 = 1
            if (r1 == r3) goto L_0x003d
            r4 = 2
            if (r1 == r4) goto L_0x001a
            r6 = 3
            if (r1 == r6) goto L_0x003d
            goto L_0x006d
        L_0x001a:
            int r1 = r5.f1282i
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L_0x006d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f1275b
            boolean r6 = h(r0, r4, r6, r1)
            if (r6 != 0) goto L_0x006d
            r5.a()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L_0x003d:
            r5.a()
            goto L_0x006d
        L_0x0041:
            int r6 = r6.getPointerId(r2)
            r5.f1282i = r6
            java.lang.Runnable r6 = r5.f1279f
            if (r6 != 0) goto L_0x0052
            androidx.appcompat.widget.ForwardingListener$DisallowIntercept r6 = new androidx.appcompat.widget.ForwardingListener$DisallowIntercept
            r6.<init>()
            r5.f1279f = r6
        L_0x0052:
            java.lang.Runnable r6 = r5.f1279f
            int r1 = r5.f1276c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f1280g
            if (r6 != 0) goto L_0x0065
            androidx.appcompat.widget.ForwardingListener$TriggerLongPress r6 = new androidx.appcompat.widget.ForwardingListener$TriggerLongPress
            r6.<init>()
            r5.f1280g = r6
        L_0x0065:
            java.lang.Runnable r6 = r5.f1280g
            int r1 = r5.f1277d
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L_0x006d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ForwardingListener.g(android.view.MotionEvent):boolean");
    }

    private static boolean h(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        if (f2 < f5 || f3 < f5 || f2 >= ((float) (view.getRight() - view.getLeft())) + f4 || f3 >= ((float) (view.getBottom() - view.getTop())) + f4) {
            return false;
        }
        return true;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1283j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1283j;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
        return true;
    }

    public abstract ShowableListMenu b();

    /* access modifiers changed from: protected */
    public abstract boolean c();

    /* access modifiers changed from: protected */
    public boolean d() {
        ShowableListMenu b2 = b();
        if (b2 == null || !b2.isShowing()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        a();
        View view = this.f1278e;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1281h = true;
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        boolean z3 = this.f1281h;
        if (!z3) {
            if (!g(motionEvent) || !c()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1278e.onTouchEvent(obtain);
                obtain.recycle();
            }
        } else if (f(motionEvent) || !d()) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f1281h = z2;
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.f1281h = false;
        this.f1282i = -1;
        Runnable runnable = this.f1279f;
        if (runnable != null) {
            this.f1278e.removeCallbacks(runnable);
        }
    }
}

package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R$attr;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.os.BuildCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class DropDownListView extends ListView {

    /* renamed from: b  reason: collision with root package name */
    private final Rect f1253b = new Rect();

    /* renamed from: c  reason: collision with root package name */
    private int f1254c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1255d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1256e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1257f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f1258g;

    /* renamed from: h  reason: collision with root package name */
    private GateKeeperDrawable f1259h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1260i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1261j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1262k;

    /* renamed from: l  reason: collision with root package name */
    private ViewPropertyAnimatorCompat f1263l;

    /* renamed from: m  reason: collision with root package name */
    private ListViewAutoScrollHelper f1264m;

    /* renamed from: n  reason: collision with root package name */
    ResolveHoverRunnable f1265n;

    static class Api21Impl {
        private Api21Impl() {
        }

        static void a(View view, float f2, float f3) {
            view.drawableHotspotChanged(f2, f3);
        }
    }

    static class Api30Impl {

        /* renamed from: a  reason: collision with root package name */
        private static Method f1266a;

        /* renamed from: b  reason: collision with root package name */
        private static Method f1267b;

        /* renamed from: c  reason: collision with root package name */
        private static Method f1268c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f1269d = true;

        static {
            Class<AdapterView> cls = AdapterView.class;
            Class<AbsListView> cls2 = AbsListView.class;
            try {
                Class cls3 = Integer.TYPE;
                Class cls4 = Float.TYPE;
                Method declaredMethod = cls2.getDeclaredMethod("positionSelector", new Class[]{cls3, View.class, Boolean.TYPE, cls4, cls4});
                f1266a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = cls.getDeclaredMethod("setSelectedPositionInt", new Class[]{cls3});
                f1267b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = cls.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{cls3});
                f1268c = declaredMethod3;
                declaredMethod3.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
        }

        private Api30Impl() {
        }

        static boolean a() {
            return f1269d;
        }

        @SuppressLint({"BanUncheckedReflection"})
        static void b(DropDownListView dropDownListView, int i2, View view) {
            try {
                f1266a.invoke(dropDownListView, new Object[]{Integer.valueOf(i2), view, Boolean.FALSE, -1, -1});
                f1267b.invoke(dropDownListView, new Object[]{Integer.valueOf(i2)});
                f1268c.invoke(dropDownListView, new Object[]{Integer.valueOf(i2)});
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InvocationTargetException e3) {
                e3.printStackTrace();
            }
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z2) {
            absListView.setSelectedChildViewEnabled(z2);
        }
    }

    private static class GateKeeperDrawable extends DrawableWrapperCompat {

        /* renamed from: c  reason: collision with root package name */
        private boolean f1270c = true;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z2) {
            this.f1270c = z2;
        }

        public void draw(Canvas canvas) {
            if (this.f1270c) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f2, float f3) {
            if (this.f1270c) {
                super.setHotspot(f2, f3);
            }
        }

        public void setHotspotBounds(int i2, int i3, int i4, int i5) {
            if (this.f1270c) {
                super.setHotspotBounds(i2, i3, i4, i5);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f1270c) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z2, boolean z3) {
            if (this.f1270c) {
                return super.setVisible(z2, z3);
            }
            return false;
        }
    }

    static class PreApi33Impl {

        /* renamed from: a  reason: collision with root package name */
        private static final Field f1271a;

        static {
            Field field = null;
            try {
                field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                field.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                e2.printStackTrace();
            }
            f1271a = field;
        }

        private PreApi33Impl() {
        }

        static boolean a(AbsListView absListView) {
            Field field = f1271a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z2) {
            Field field = f1271a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z2));
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        public void a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1265n = null;
            dropDownListView.removeCallbacks(this);
        }

        public void b() {
            DropDownListView.this.post(this);
        }

        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1265n = null;
            dropDownListView.drawableStateChanged();
        }
    }

    DropDownListView(Context context, boolean z2) {
        super(context, (AttributeSet) null, R$attr.D);
        this.f1261j = z2;
        setCacheColorHint(0);
    }

    private void a() {
        this.f1262k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1258g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1263l;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
            this.f1263l = null;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.f1253b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1253b);
            selector.draw(canvas);
        }
    }

    private void f(int i2, View view) {
        Rect rect = this.f1253b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1254c;
        rect.top -= this.f1255d;
        rect.right += this.f1256e;
        rect.bottom += this.f1257f;
        boolean j2 = j();
        if (view.isEnabled() != j2) {
            k(!j2);
            if (i2 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i2, View view) {
        boolean z2;
        Drawable selector = getSelector();
        boolean z3 = true;
        if (selector == null || i2 == -1) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            selector.setVisible(false, false);
        }
        f(i2, view);
        if (z2) {
            Rect rect = this.f1253b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z3 = false;
            }
            selector.setVisible(z3, false);
            DrawableCompat.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i2, View view, float f2, float f3) {
        g(i2, view);
        Drawable selector = getSelector();
        if (selector != null && i2 != -1) {
            DrawableCompat.k(selector, f2, f3);
        }
    }

    private void i(View view, int i2, float f2, float f3) {
        View childAt;
        this.f1262k = true;
        Api21Impl.a(this, f2, f3);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i3 = this.f1258g;
        if (!(i3 == -1 || (childAt = getChildAt(i3 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1258g = i2;
        Api21Impl.a(view, f2 - ((float) view.getLeft()), f3 - ((float) view.getTop()));
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i2, view, f2, f3);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        if (BuildCompat.d()) {
            return Api33Impl.a(this);
        }
        return PreApi33Impl.a(this);
    }

    private void k(boolean z2) {
        if (BuildCompat.d()) {
            Api33Impl.b(this, z2);
        } else {
            PreApi33Impl.b(this, z2);
        }
    }

    private boolean l() {
        return this.f1262k;
    }

    private void m() {
        Drawable selector = getSelector();
        if (selector != null && l() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z2) {
        GateKeeperDrawable gateKeeperDrawable = this.f1259h;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.b(z2);
        }
    }

    public int d(int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i8 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        View view = null;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i12 = layoutParams.height;
            if (i12 > 0) {
                i7 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else {
                i7 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i2, i7);
            view.forceLayout();
            if (i9 > 0) {
                i8 += dividerHeight;
            }
            i8 += view.getMeasuredHeight();
            if (i8 < i5) {
                if (i6 >= 0 && i9 >= i6) {
                    i11 = i8;
                }
                i9++;
            } else if (i6 < 0 || i9 <= i6 || i11 <= 0 || i8 == i5) {
                return i5;
            } else {
                return i11;
            }
        }
        return i8;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f1265n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x0014
            r9 = 3
            if (r0 == r9) goto L_0x0011
        L_0x000e:
            r9 = 0
            r3 = 1
            goto L_0x0046
        L_0x0011:
            r9 = 0
            r3 = 0
            goto L_0x0046
        L_0x0014:
            r3 = 1
            goto L_0x0017
        L_0x0016:
            r3 = 0
        L_0x0017:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x001e
            goto L_0x0011
        L_0x001e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x0031
            r9 = 1
            goto L_0x0046
        L_0x0031:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto L_0x000e
            r7.b(r3, r5)
            goto L_0x000e
        L_0x0046:
            if (r3 == 0) goto L_0x004a
            if (r9 == 0) goto L_0x004d
        L_0x004a:
            r7.a()
        L_0x004d:
            if (r3 == 0) goto L_0x0065
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1264m
            if (r9 != 0) goto L_0x005a
            androidx.core.widget.ListViewAutoScrollHelper r9 = new androidx.core.widget.ListViewAutoScrollHelper
            r9.<init>(r7)
            r7.f1264m = r9
        L_0x005a:
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1264m
            r9.m(r1)
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1264m
            r9.onTouch(r7, r8)
            goto L_0x006c
        L_0x0065:
            androidx.core.widget.ListViewAutoScrollHelper r8 = r7.f1264m
            if (r8 == 0) goto L_0x006c
            r8.m(r2)
        L_0x006c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.e(android.view.MotionEvent, int):boolean");
    }

    public boolean hasFocus() {
        return this.f1261j || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f1261j || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f1261j || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f1261j && this.f1260i) || super.isInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f1265n = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1265n == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.f1265n = resolveHoverRunnable;
            resolveHoverRunnable.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i2 < 30 || !Api30Impl.a()) {
                        setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                    } else {
                        Api30Impl.b(this, pointToPosition, childAt);
                    }
                }
                m();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1258g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.f1265n;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z2) {
        this.f1260i = z2;
    }

    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable;
        if (drawable != null) {
            gateKeeperDrawable = new GateKeeperDrawable(drawable);
        } else {
            gateKeeperDrawable = null;
        }
        this.f1259h = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1254c = rect.left;
        this.f1255d = rect.top;
        this.f1256e = rect.right;
        this.f1257f = rect.bottom;
    }
}

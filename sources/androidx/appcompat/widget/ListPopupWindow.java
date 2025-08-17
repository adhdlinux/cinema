package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ViewCompat;
import androidx.core.widget.PopupWindowCompat;
import java.lang.reflect.Method;

public class ListPopupWindow implements ShowableListMenu {
    private static Method H;
    private static Method I;
    private static Method J;
    private final ListSelectorHider A;
    private Runnable B;
    final Handler C;
    private final Rect D;
    private Rect E;
    private boolean F;
    PopupWindow G;

    /* renamed from: b  reason: collision with root package name */
    private Context f1301b;

    /* renamed from: c  reason: collision with root package name */
    private ListAdapter f1302c;

    /* renamed from: d  reason: collision with root package name */
    DropDownListView f1303d;

    /* renamed from: e  reason: collision with root package name */
    private int f1304e;

    /* renamed from: f  reason: collision with root package name */
    private int f1305f;

    /* renamed from: g  reason: collision with root package name */
    private int f1306g;

    /* renamed from: h  reason: collision with root package name */
    private int f1307h;

    /* renamed from: i  reason: collision with root package name */
    private int f1308i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1309j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1310k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1311l;

    /* renamed from: m  reason: collision with root package name */
    private int f1312m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1313n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1314o;

    /* renamed from: p  reason: collision with root package name */
    int f1315p;

    /* renamed from: q  reason: collision with root package name */
    private View f1316q;

    /* renamed from: r  reason: collision with root package name */
    private int f1317r;

    /* renamed from: s  reason: collision with root package name */
    private DataSetObserver f1318s;

    /* renamed from: t  reason: collision with root package name */
    private View f1319t;

    /* renamed from: u  reason: collision with root package name */
    private Drawable f1320u;

    /* renamed from: v  reason: collision with root package name */
    private AdapterView.OnItemClickListener f1321v;

    /* renamed from: w  reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f1322w;

    /* renamed from: x  reason: collision with root package name */
    final ResizePopupRunnable f1323x;

    /* renamed from: y  reason: collision with root package name */
    private final PopupTouchInterceptor f1324y;

    /* renamed from: z  reason: collision with root package name */
    private final PopupScrollListener f1325z;

    static class Api24Impl {
        private Api24Impl() {
        }

        static int a(PopupWindow popupWindow, View view, int i2, boolean z2) {
            return popupWindow.getMaxAvailableHeight(view, i2, z2);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z2) {
            popupWindow.setIsClippedToScreen(z2);
        }
    }

    private class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.p();
        }
    }

    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    private class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (i2 == 1 && !ListPopupWindow.this.u() && ListPopupWindow.this.G.getContentView() != null) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.C.removeCallbacks(listPopupWindow.f1323x);
                ListPopupWindow.this.f1323x.run();
            }
        }
    }

    private class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.G) != null && popupWindow.isShowing() && x2 >= 0 && x2 < ListPopupWindow.this.G.getWidth() && y2 >= 0 && y2 < ListPopupWindow.this.G.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.C.postDelayed(listPopupWindow.f1323x, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.C.removeCallbacks(listPopupWindow2.f1323x);
                return false;
            }
        }
    }

    private class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f1303d;
            if (dropDownListView != null && ViewCompat.U(dropDownListView) && ListPopupWindow.this.f1303d.getCount() > ListPopupWindow.this.f1303d.getChildCount()) {
                int childCount = ListPopupWindow.this.f1303d.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f1315p) {
                    listPopupWindow.G.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        Class<PopupWindow> cls = PopupWindow.class;
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                J = cls.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                I = cls.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, (AttributeSet) null, R$attr.J);
    }

    private void H(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = H;
            if (method != null) {
                try {
                    method.invoke(this.G, new Object[]{Boolean.valueOf(z2)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.b(this.G, z2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v29, resolved type: androidx.appcompat.widget.DropDownListView} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int o() {
        /*
            r12 = this;
            androidx.appcompat.widget.DropDownListView r0 = r12.f1303d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00bf
            android.content.Context r0 = r12.f1301b
            androidx.appcompat.widget.ListPopupWindow$2 r5 = new androidx.appcompat.widget.ListPopupWindow$2
            r5.<init>()
            r12.B = r5
            boolean r5 = r12.F
            r5 = r5 ^ r3
            androidx.appcompat.widget.DropDownListView r5 = r12.q(r0, r5)
            r12.f1303d = r5
            android.graphics.drawable.Drawable r6 = r12.f1320u
            if (r6 == 0) goto L_0x0022
            r5.setSelector(r6)
        L_0x0022:
            androidx.appcompat.widget.DropDownListView r5 = r12.f1303d
            android.widget.ListAdapter r6 = r12.f1302c
            r5.setAdapter(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f1303d
            android.widget.AdapterView$OnItemClickListener r6 = r12.f1321v
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f1303d
            r5.setFocusable(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.f1303d
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.DropDownListView r5 = r12.f1303d
            androidx.appcompat.widget.ListPopupWindow$3 r6 = new androidx.appcompat.widget.ListPopupWindow$3
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.DropDownListView r5 = r12.f1303d
            androidx.appcompat.widget.ListPopupWindow$PopupScrollListener r6 = r12.f1325z
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.f1322w
            if (r5 == 0) goto L_0x0054
            androidx.appcompat.widget.DropDownListView r6 = r12.f1303d
            r6.setOnItemSelectedListener(r5)
        L_0x0054:
            androidx.appcompat.widget.DropDownListView r5 = r12.f1303d
            android.view.View r6 = r12.f1316q
            if (r6 == 0) goto L_0x00b8
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f1317r
            if (r8 == 0) goto L_0x008f
            if (r8 == r3) goto L_0x0088
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r5 = "Invalid hint position "
            r0.append(r5)
            int r5 = r12.f1317r
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            java.lang.String r5 = "ListPopupWindow"
            android.util.Log.e(r5, r0)
            goto L_0x0095
        L_0x0088:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0095
        L_0x008f:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0095:
            int r0 = r12.f1305f
            if (r0 < 0) goto L_0x009c
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x009e
        L_0x009c:
            r0 = 0
            r5 = 0
        L_0x009e:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00b9
        L_0x00b8:
            r0 = 0
        L_0x00b9:
            android.widget.PopupWindow r6 = r12.G
            r6.setContentView(r5)
            goto L_0x00dd
        L_0x00bf:
            android.widget.PopupWindow r0 = r12.G
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f1316q
            if (r0 == 0) goto L_0x00dc
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00dd
        L_0x00dc:
            r0 = 0
        L_0x00dd:
            android.widget.PopupWindow r5 = r12.G
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x00f9
            android.graphics.Rect r6 = r12.D
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.D
            int r6 = r5.top
            int r5 = r5.bottom
            int r5 = r5 + r6
            boolean r7 = r12.f1309j
            if (r7 != 0) goto L_0x00ff
            int r6 = -r6
            r12.f1307h = r6
            goto L_0x00ff
        L_0x00f9:
            android.graphics.Rect r5 = r12.D
            r5.setEmpty()
            r5 = 0
        L_0x00ff:
            android.widget.PopupWindow r6 = r12.G
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0109
            goto L_0x010a
        L_0x0109:
            r3 = 0
        L_0x010a:
            android.view.View r4 = r12.r()
            int r6 = r12.f1307h
            int r3 = r12.s(r4, r6, r3)
            boolean r4 = r12.f1313n
            if (r4 != 0) goto L_0x017b
            int r4 = r12.f1304e
            if (r4 != r2) goto L_0x011d
            goto L_0x017b
        L_0x011d:
            int r4 = r12.f1305f
            r6 = -2
            if (r4 == r6) goto L_0x0144
            r1 = 1073741824(0x40000000, float:2.0)
            if (r4 == r2) goto L_0x012b
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r4, r1)
            goto L_0x015c
        L_0x012b:
            android.content.Context r2 = r12.f1301b
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.D
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x015c
        L_0x0144:
            android.content.Context r2 = r12.f1301b
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.D
            int r6 = r4.left
            int r4 = r4.right
            int r6 = r6 + r4
            int r2 = r2 - r6
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
        L_0x015c:
            r7 = r1
            androidx.appcompat.widget.DropDownListView r6 = r12.f1303d
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.d(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0179
            androidx.appcompat.widget.DropDownListView r2 = r12.f1303d
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.DropDownListView r3 = r12.f1303d
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0179:
            int r1 = r1 + r0
            return r1
        L_0x017b:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ListPopupWindow.o():int");
    }

    private int s(View view, int i2, boolean z2) {
        if (Build.VERSION.SDK_INT > 23) {
            return Api24Impl.a(this.G, view, i2, z2);
        }
        Method method = I;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.G, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z2)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.G.getMaxAvailableHeight(view, i2);
    }

    private void w() {
        View view = this.f1316q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1316q);
            }
        }
    }

    public void A(int i2) {
        this.f1312m = i2;
    }

    public void B(Rect rect) {
        this.E = rect != null ? new Rect(rect) : null;
    }

    public void C(int i2) {
        this.G.setInputMethodMode(i2);
    }

    public void D(boolean z2) {
        this.F = z2;
        this.G.setFocusable(z2);
    }

    public void E(PopupWindow.OnDismissListener onDismissListener) {
        this.G.setOnDismissListener(onDismissListener);
    }

    public void F(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1321v = onItemClickListener;
    }

    public void G(boolean z2) {
        this.f1311l = true;
        this.f1310k = z2;
    }

    public void I(int i2) {
        this.f1317r = i2;
    }

    public void J(int i2) {
        DropDownListView dropDownListView = this.f1303d;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.setListSelectionHidden(false);
            dropDownListView.setSelection(i2);
            if (dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i2, true);
            }
        }
    }

    public void K(int i2) {
        this.f1305f = i2;
    }

    public void b(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    public int c() {
        return this.f1306g;
    }

    public void d(int i2) {
        this.f1306g = i2;
    }

    public void dismiss() {
        this.G.dismiss();
        w();
        this.G.setContentView((View) null);
        this.f1303d = null;
        this.C.removeCallbacks(this.f1323x);
    }

    public Drawable f() {
        return this.G.getBackground();
    }

    public void h(int i2) {
        this.f1307h = i2;
        this.f1309j = true;
    }

    public boolean isShowing() {
        return this.G.isShowing();
    }

    public int k() {
        if (!this.f1309j) {
            return 0;
        }
        return this.f1307h;
    }

    public void l(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1318s;
        if (dataSetObserver == null) {
            this.f1318s = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.f1302c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1302c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1318s);
        }
        DropDownListView dropDownListView = this.f1303d;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f1302c);
        }
    }

    public ListView n() {
        return this.f1303d;
    }

    public void p() {
        DropDownListView dropDownListView = this.f1303d;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public DropDownListView q(Context context, boolean z2) {
        return new DropDownListView(context, z2);
    }

    public View r() {
        return this.f1319t;
    }

    public void show() {
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int o2 = o();
        boolean u2 = u();
        PopupWindowCompat.b(this.G, this.f1308i);
        boolean z3 = true;
        if (!this.G.isShowing()) {
            int i6 = this.f1305f;
            if (i6 == -1) {
                i6 = -1;
            } else if (i6 == -2) {
                i6 = r().getWidth();
            }
            int i7 = this.f1304e;
            if (i7 == -1) {
                o2 = -1;
            } else if (i7 != -2) {
                o2 = i7;
            }
            this.G.setWidth(i6);
            this.G.setHeight(o2);
            H(true);
            PopupWindow popupWindow = this.G;
            if (this.f1314o || this.f1313n) {
                z2 = false;
            } else {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            this.G.setTouchInterceptor(this.f1324y);
            if (this.f1311l) {
                PopupWindowCompat.a(this.G, this.f1310k);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = J;
                if (method != null) {
                    try {
                        method.invoke(this.G, new Object[]{this.E});
                    } catch (Exception e2) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                    }
                }
            } else {
                Api29Impl.a(this.G, this.E);
            }
            PopupWindowCompat.c(this.G, r(), this.f1306g, this.f1307h, this.f1312m);
            this.f1303d.setSelection(-1);
            if (!this.F || this.f1303d.isInTouchMode()) {
                p();
            }
            if (!this.F) {
                this.C.post(this.A);
            }
        } else if (ViewCompat.U(r())) {
            int i8 = this.f1305f;
            if (i8 == -1) {
                i8 = -1;
            } else if (i8 == -2) {
                i8 = r().getWidth();
            }
            int i9 = this.f1304e;
            if (i9 == -1) {
                if (!u2) {
                    o2 = -1;
                }
                if (u2) {
                    PopupWindow popupWindow2 = this.G;
                    if (this.f1305f == -1) {
                        i5 = -1;
                    } else {
                        i5 = 0;
                    }
                    popupWindow2.setWidth(i5);
                    this.G.setHeight(0);
                } else {
                    PopupWindow popupWindow3 = this.G;
                    if (this.f1305f == -1) {
                        i4 = -1;
                    } else {
                        i4 = 0;
                    }
                    popupWindow3.setWidth(i4);
                    this.G.setHeight(-1);
                }
            } else if (i9 != -2) {
                o2 = i9;
            }
            PopupWindow popupWindow4 = this.G;
            if (this.f1314o || this.f1313n) {
                z3 = false;
            }
            popupWindow4.setOutsideTouchable(z3);
            PopupWindow popupWindow5 = this.G;
            View r2 = r();
            int i10 = this.f1306g;
            int i11 = this.f1307h;
            if (i8 < 0) {
                i2 = -1;
            } else {
                i2 = i8;
            }
            if (o2 < 0) {
                i3 = -1;
            } else {
                i3 = o2;
            }
            popupWindow5.update(r2, i10, i11, i2, i3);
        }
    }

    public int t() {
        return this.f1305f;
    }

    public boolean u() {
        return this.G.getInputMethodMode() == 2;
    }

    public boolean v() {
        return this.F;
    }

    public void x(View view) {
        this.f1319t = view;
    }

    public void y(int i2) {
        this.G.setAnimationStyle(i2);
    }

    public void z(int i2) {
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            this.f1305f = rect.left + rect.right + i2;
            return;
        }
        K(i2);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f1304e = -2;
        this.f1305f = -2;
        this.f1308i = 1002;
        this.f1312m = 0;
        this.f1313n = false;
        this.f1314o = false;
        this.f1315p = Integer.MAX_VALUE;
        this.f1317r = 0;
        this.f1323x = new ResizePopupRunnable();
        this.f1324y = new PopupTouchInterceptor();
        this.f1325z = new PopupScrollListener();
        this.A = new ListSelectorHider();
        this.D = new Rect();
        this.f1301b = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.v1, i2, i3);
        this.f1306g = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.w1, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.x1, 0);
        this.f1307h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f1309j = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i2, i3);
        this.G = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}

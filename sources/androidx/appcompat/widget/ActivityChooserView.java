package androidx.appcompat.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.view.ActionProvider;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

public class ActivityChooserView extends ViewGroup {

    /* renamed from: b  reason: collision with root package name */
    final ActivityChooserViewAdapter f1059b;

    /* renamed from: c  reason: collision with root package name */
    private final Callbacks f1060c;

    /* renamed from: d  reason: collision with root package name */
    private final View f1061d;

    /* renamed from: e  reason: collision with root package name */
    private final Drawable f1062e;

    /* renamed from: f  reason: collision with root package name */
    final FrameLayout f1063f;

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f1064g;

    /* renamed from: h  reason: collision with root package name */
    final FrameLayout f1065h;

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f1066i;

    /* renamed from: j  reason: collision with root package name */
    private final int f1067j;

    /* renamed from: k  reason: collision with root package name */
    ActionProvider f1068k;

    /* renamed from: l  reason: collision with root package name */
    final DataSetObserver f1069l = new DataSetObserver() {
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f1059b.notifyDataSetChanged();
        }

        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f1059b.notifyDataSetInvalidated();
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f1070m = new ViewTreeObserver.OnGlobalLayoutListener() {
        public void onGlobalLayout() {
            if (!ActivityChooserView.this.b()) {
                return;
            }
            if (!ActivityChooserView.this.isShown()) {
                ActivityChooserView.this.getListPopupWindow().dismiss();
                return;
            }
            ActivityChooserView.this.getListPopupWindow().show();
            ActionProvider actionProvider = ActivityChooserView.this.f1068k;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(true);
            }
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private ListPopupWindow f1071n;

    /* renamed from: o  reason: collision with root package name */
    PopupWindow.OnDismissListener f1072o;

    /* renamed from: p  reason: collision with root package name */
    boolean f1073p;

    /* renamed from: q  reason: collision with root package name */
    int f1074q = 4;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1075r;

    /* renamed from: s  reason: collision with root package name */
    private int f1076s;

    private class ActivityChooserViewAdapter extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f1082b = 4;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1083c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1084d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1085e;

        ActivityChooserViewAdapter() {
        }

        public int a() {
            throw null;
        }

        public ActivityChooserModel b() {
            return null;
        }

        public ResolveInfo c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public boolean e() {
            return this.f1083c;
        }

        public void f(ActivityChooserModel activityChooserModel) {
            ActivityChooserView.this.f1059b.b();
            notifyDataSetChanged();
        }

        public int getCount() {
            throw null;
        }

        public Object getItem(int i2) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            } else if (!this.f1083c) {
                throw null;
            } else {
                throw null;
            }
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public int getItemViewType(int i2) {
            return (!this.f1085e || i2 != getCount() - 1) ? 0 : 1;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                if (view == null || view.getId() != R$id.f189x) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.f197f, viewGroup, false);
                }
                PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
                ResolveInfo resolveInfo = (ResolveInfo) getItem(i2);
                ((ImageView) view.findViewById(R$id.f187v)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                ((TextView) view.findViewById(R$id.S)).setText(resolveInfo.loadLabel(packageManager));
                if (!this.f1083c || i2 != 0 || !this.f1084d) {
                    view.setActivated(false);
                } else {
                    view.setActivated(true);
                }
                return view;
            } else if (itemViewType != 1) {
                throw new IllegalArgumentException();
            } else if (view != null && view.getId() == 1) {
                return view;
            } else {
                View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(R$layout.f197f, viewGroup, false);
                inflate.setId(1);
                ((TextView) inflate.findViewById(R$id.S)).setText(ActivityChooserView.this.getContext().getString(R$string.f215b));
                return inflate;
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    private class Callbacks implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        Callbacks() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f1072o;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f1065h) {
                activityChooserView.a();
                ActivityChooserView.this.f1059b.c();
                ActivityChooserView.this.f1059b.b();
                throw null;
            } else if (view == activityChooserView.f1063f) {
                activityChooserView.f1073p = false;
                activityChooserView.d(activityChooserView.f1074q);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            a();
            ActionProvider actionProvider = ActivityChooserView.this.f1068k;
            if (actionProvider != null) {
                actionProvider.subUiVisibilityChanged(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            int itemViewType = ((ActivityChooserViewAdapter) adapterView.getAdapter()).getItemViewType(i2);
            if (itemViewType == 0) {
                ActivityChooserView.this.a();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                if (!activityChooserView.f1073p) {
                    activityChooserView.f1059b.e();
                    ActivityChooserView.this.f1059b.b();
                    throw null;
                } else if (i2 > 0) {
                    activityChooserView.f1059b.b();
                    throw null;
                }
            } else if (itemViewType == 1) {
                ActivityChooserView.this.d(Integer.MAX_VALUE);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f1065h) {
                if (activityChooserView.f1059b.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.f1073p = true;
                    activityChooserView2.d(activityChooserView2.f1074q);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public static class InnerLayout extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private static final int[] f1088b = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TintTypedArray u2 = TintTypedArray.u(context, attributeSet, f1088b);
            setBackgroundDrawable(u2.g(0));
            u2.w();
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int[] iArr = R$styleable.E;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        ViewCompat.p0(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        this.f1074q = obtainStyledAttributes.getInt(R$styleable.G, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(R$styleable.F);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(R$layout.f196e, this, true);
        Callbacks callbacks = new Callbacks();
        this.f1060c = callbacks;
        View findViewById = findViewById(R$id.f175j);
        this.f1061d = findViewById;
        this.f1062e = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.f183r);
        this.f1065h = frameLayout;
        frameLayout.setOnClickListener(callbacks);
        frameLayout.setOnLongClickListener(callbacks);
        int i3 = R$id.f188w;
        this.f1066i = (ImageView) frameLayout.findViewById(i3);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R$id.f185t);
        frameLayout2.setOnClickListener(callbacks);
        frameLayout2.setAccessibilityDelegate(new View.AccessibilityDelegate() {
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                AccessibilityNodeInfoCompat.J0(accessibilityNodeInfo).Z(true);
            }
        });
        frameLayout2.setOnTouchListener(new ForwardingListener(frameLayout2) {
            public ShowableListMenu b() {
                return ActivityChooserView.this.getListPopupWindow();
            }

            /* access modifiers changed from: protected */
            public boolean c() {
                ActivityChooserView.this.c();
                return true;
            }

            /* access modifiers changed from: protected */
            public boolean d() {
                ActivityChooserView.this.a();
                return true;
            }
        });
        this.f1063f = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i3);
        this.f1064g = imageView;
        imageView.setImageDrawable(drawable);
        ActivityChooserViewAdapter activityChooserViewAdapter = new ActivityChooserViewAdapter();
        this.f1059b = activityChooserViewAdapter;
        activityChooserViewAdapter.registerDataSetObserver(new DataSetObserver() {
            public void onChanged() {
                super.onChanged();
                ActivityChooserView.this.e();
            }
        });
        Resources resources = context.getResources();
        this.f1067j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.f128d));
    }

    public boolean a() {
        if (!b()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1070m);
        return true;
    }

    public boolean b() {
        return getListPopupWindow().isShowing();
    }

    public boolean c() {
        if (b() || !this.f1075r) {
            return false;
        }
        this.f1073p = false;
        d(this.f1074q);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        this.f1059b.b();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (this.f1059b.getCount() > 0) {
            this.f1063f.setEnabled(true);
        } else {
            this.f1063f.setEnabled(false);
        }
        int a2 = this.f1059b.a();
        int d2 = this.f1059b.d();
        if (a2 == 1 || (a2 > 1 && d2 > 0)) {
            this.f1065h.setVisibility(0);
            ResolveInfo c2 = this.f1059b.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f1066i.setImageDrawable(c2.loadIcon(packageManager));
            if (this.f1076s != 0) {
                CharSequence loadLabel = c2.loadLabel(packageManager);
                this.f1065h.setContentDescription(getContext().getString(this.f1076s, new Object[]{loadLabel}));
            }
        } else {
            this.f1065h.setVisibility(8);
        }
        if (this.f1065h.getVisibility() == 0) {
            this.f1061d.setBackgroundDrawable(this.f1062e);
        } else {
            this.f1061d.setBackgroundDrawable((Drawable) null);
        }
    }

    public ActivityChooserModel getDataModel() {
        this.f1059b.b();
        return null;
    }

    /* access modifiers changed from: package-private */
    public ListPopupWindow getListPopupWindow() {
        if (this.f1071n == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext());
            this.f1071n = listPopupWindow;
            listPopupWindow.l(this.f1059b);
            this.f1071n.x(this);
            this.f1071n.D(true);
            this.f1071n.F(this.f1060c);
            this.f1071n.E(this.f1060c);
        }
        return this.f1071n;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1059b.b();
        this.f1075r = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f1059b.b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1070m);
        }
        if (b()) {
            a();
        }
        this.f1075r = false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f1061d.layout(0, 0, i4 - i2, i5 - i3);
        if (!b()) {
            a();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View view = this.f1061d;
        if (this.f1065h.getVisibility() != 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824);
        }
        measureChild(view, i2, i3);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(ActivityChooserModel activityChooserModel) {
        this.f1059b.f(activityChooserModel);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i2) {
        this.f1076s = i2;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i2) {
        this.f1064g.setContentDescription(getContext().getString(i2));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1064g.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i2) {
        this.f1074q = i2;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1072o = onDismissListener;
    }

    public void setProvider(ActionProvider actionProvider) {
        this.f1068k = actionProvider;
    }
}

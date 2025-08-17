package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;

public class AppCompatSpinner extends Spinner {
    @SuppressLint({"ResourceType"})

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f1167j = {16843505};

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatBackgroundHelper f1168b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f1169c;

    /* renamed from: d  reason: collision with root package name */
    private ForwardingListener f1170d;

    /* renamed from: e  reason: collision with root package name */
    private SpinnerAdapter f1171e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1172f;

    /* renamed from: g  reason: collision with root package name */
    private SpinnerPopup f1173g;

    /* renamed from: h  reason: collision with root package name */
    int f1174h;

    /* renamed from: i  reason: collision with root package name */
    final Rect f1175i;

    private static final class Api16Impl {
        private Api16Impl() {
        }

        static void a(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    private static final class Api17Impl {
        private Api17Impl() {
        }

        static int a(View view) {
            return view.getTextAlignment();
        }

        static int b(View view) {
            return view.getTextDirection();
        }

        static void c(View view, int i2) {
            view.setTextAlignment(i2);
        }

        static void d(View view, int i2) {
            view.setTextDirection(i2);
        }
    }

    private static final class Api23Impl {
        private Api23Impl() {
        }

        static void a(ThemedSpinnerAdapter themedSpinnerAdapter, Resources.Theme theme) {
            if (!ObjectsCompat.a(themedSpinnerAdapter.getDropDownViewTheme(), theme)) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    class DialogPopup implements SpinnerPopup, DialogInterface.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        AlertDialog f1179b;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f1180c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f1181d;

        DialogPopup() {
        }

        public void b(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        public int c() {
            return 0;
        }

        public void d(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        public void dismiss() {
            AlertDialog alertDialog = this.f1179b;
            if (alertDialog != null) {
                alertDialog.dismiss();
                this.f1179b = null;
            }
        }

        public CharSequence e() {
            return this.f1181d;
        }

        public Drawable f() {
            return null;
        }

        public void g(CharSequence charSequence) {
            this.f1181d = charSequence;
        }

        public void h(int i2) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        public void i(int i2) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        public boolean isShowing() {
            AlertDialog alertDialog = this.f1179b;
            if (alertDialog != null) {
                return alertDialog.isShowing();
            }
            return false;
        }

        public void j(int i2, int i3) {
            if (this.f1180c != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppCompatSpinner.this.getPopupContext());
                CharSequence charSequence = this.f1181d;
                if (charSequence != null) {
                    builder.setTitle(charSequence);
                }
                AlertDialog create = builder.m(this.f1180c, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
                this.f1179b = create;
                ListView b2 = create.b();
                Api17Impl.d(b2, i2);
                Api17Impl.c(b2, i3);
                this.f1179b.show();
            }
        }

        public int k() {
            return 0;
        }

        public void l(ListAdapter listAdapter) {
            this.f1180c = listAdapter;
        }

        public void onClick(DialogInterface dialogInterface, int i2) {
            AppCompatSpinner.this.setSelection(i2);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick((View) null, i2, this.f1180c.getItemId(i2));
            }
            dismiss();
        }
    }

    private static class DropDownAdapter implements ListAdapter, SpinnerAdapter {

        /* renamed from: b  reason: collision with root package name */
        private SpinnerAdapter f1183b;

        /* renamed from: c  reason: collision with root package name */
        private ListAdapter f1184c;

        public DropDownAdapter(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1183b = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1184c = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                Api23Impl.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            } else if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() == null) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1184c;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1183b;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1183b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i2, view, viewGroup);
        }

        public Object getItem(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1183b;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i2);
        }

        public long getItemId(int i2) {
            SpinnerAdapter spinnerAdapter = this.f1183b;
            if (spinnerAdapter == null) {
                return -1;
            }
            return spinnerAdapter.getItemId(i2);
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            return getDropDownView(i2, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1183b;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i2) {
            ListAdapter listAdapter = this.f1184c;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i2);
            }
            return true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1183b;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1183b;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    class DropdownPopup extends ListPopupWindow implements SpinnerPopup {
        private CharSequence K;
        ListAdapter L;
        private final Rect M = new Rect();
        private int N;

        public DropdownPopup(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
            x(AppCompatSpinner.this);
            D(true);
            I(0);
            F(new AdapterView.OnItemClickListener(AppCompatSpinner.this) {
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        DropdownPopup dropdownPopup = DropdownPopup.this;
                        AppCompatSpinner.this.performItemClick(view, i2, dropdownPopup.L.getItemId(i2));
                    }
                    DropdownPopup.this.dismiss();
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void M() {
            int i2;
            int i3;
            Drawable f2 = f();
            if (f2 != null) {
                f2.getPadding(AppCompatSpinner.this.f1175i);
                if (ViewUtils.b(AppCompatSpinner.this)) {
                    i2 = AppCompatSpinner.this.f1175i.right;
                } else {
                    i2 = -AppCompatSpinner.this.f1175i.left;
                }
            } else {
                Rect rect = AppCompatSpinner.this.f1175i;
                rect.right = 0;
                rect.left = 0;
                i2 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i4 = appCompatSpinner.f1174h;
            if (i4 == -2) {
                int a2 = appCompatSpinner.a((SpinnerAdapter) this.L, f());
                int i5 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f1175i;
                int i6 = (i5 - rect2.left) - rect2.right;
                if (a2 > i6) {
                    a2 = i6;
                }
                z(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i4 == -1) {
                z((width - paddingLeft) - paddingRight);
            } else {
                z(i4);
            }
            if (ViewUtils.b(AppCompatSpinner.this)) {
                i3 = i2 + (((width - paddingRight) - t()) - N());
            } else {
                i3 = i2 + paddingLeft + N();
            }
            d(i3);
        }

        public int N() {
            return this.N;
        }

        /* access modifiers changed from: package-private */
        public boolean O(View view) {
            return ViewCompat.U(view) && view.getGlobalVisibleRect(this.M);
        }

        public CharSequence e() {
            return this.K;
        }

        public void g(CharSequence charSequence) {
            this.K = charSequence;
        }

        public void i(int i2) {
            this.N = i2;
        }

        public void j(int i2, int i3) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            M();
            C(2);
            super.show();
            ListView n2 = n();
            n2.setChoiceMode(1);
            Api17Impl.d(n2, i2);
            Api17Impl.c(n2, i3);
            J(AppCompatSpinner.this.getSelectedItemPosition());
            if (!isShowing && (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) != null) {
                final AnonymousClass2 r5 = new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        DropdownPopup dropdownPopup = DropdownPopup.this;
                        if (!dropdownPopup.O(AppCompatSpinner.this)) {
                            DropdownPopup.this.dismiss();
                            return;
                        }
                        DropdownPopup.this.M();
                        DropdownPopup.super.show();
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(r5);
                E(new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                        if (viewTreeObserver != null) {
                            viewTreeObserver.removeGlobalOnLayoutListener(r5);
                        }
                    }
                });
            }
        }

        public void l(ListAdapter listAdapter) {
            super.l(listAdapter);
            this.L = listAdapter;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: b  reason: collision with root package name */
        boolean f1190b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f1190b ? (byte) 1 : 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1190b = parcel.readByte() != 0;
        }
    }

    interface SpinnerPopup {
        void b(Drawable drawable);

        int c();

        void d(int i2);

        void dismiss();

        CharSequence e();

        Drawable f();

        void g(CharSequence charSequence);

        void h(int i2);

        void i(int i2);

        boolean isShowing();

        void j(int i2, int i3);

        int k();

        void l(ListAdapter listAdapter);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.Q);
    }

    /* access modifiers changed from: package-private */
    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i2 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i3 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i3;
        }
        drawable.getPadding(this.f1175i);
        Rect rect = this.f1175i;
        return i3 + rect.left + rect.right;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f1173g.j(Api17Impl.b(this), Api17Impl.a(this));
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1168b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
    }

    public int getDropDownHorizontalOffset() {
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup != null) {
            return spinnerPopup.c();
        }
        return super.getDropDownHorizontalOffset();
    }

    public int getDropDownVerticalOffset() {
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup != null) {
            return spinnerPopup.k();
        }
        return super.getDropDownVerticalOffset();
    }

    public int getDropDownWidth() {
        if (this.f1173g != null) {
            return this.f1174h;
        }
        return super.getDropDownWidth();
    }

    /* access modifiers changed from: package-private */
    public final SpinnerPopup getInternalPopup() {
        return this.f1173g;
    }

    public Drawable getPopupBackground() {
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup != null) {
            return spinnerPopup.f();
        }
        return super.getPopupBackground();
    }

    public Context getPopupContext() {
        return this.f1169c;
    }

    public CharSequence getPrompt() {
        SpinnerPopup spinnerPopup = this.f1173g;
        return spinnerPopup != null ? spinnerPopup.e() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1168b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1168b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup != null && spinnerPopup.isShowing()) {
            this.f1173g.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f1173g != null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i2)), getMeasuredHeight());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.f1190b && (viewTreeObserver = getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (!AppCompatSpinner.this.getInternalPopup().isShowing()) {
                        AppCompatSpinner.this.b();
                    }
                    ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver != null) {
                        Api16Impl.a(viewTreeObserver, this);
                    }
                }
            });
        }
    }

    public Parcelable onSaveInstanceState() {
        boolean z2;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup == null || !spinnerPopup.isShowing()) {
            z2 = false;
        } else {
            z2 = true;
        }
        savedState.f1190b = z2;
        return savedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener = this.f1170d;
        if (forwardingListener == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean performClick() {
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup == null) {
            return super.performClick();
        }
        if (spinnerPopup.isShowing()) {
            return true;
        }
        b();
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1168b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1168b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setDropDownHorizontalOffset(int i2) {
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup != null) {
            spinnerPopup.i(i2);
            this.f1173g.d(i2);
            return;
        }
        super.setDropDownHorizontalOffset(i2);
    }

    public void setDropDownVerticalOffset(int i2) {
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup != null) {
            spinnerPopup.h(i2);
        } else {
            super.setDropDownVerticalOffset(i2);
        }
    }

    public void setDropDownWidth(int i2) {
        if (this.f1173g != null) {
            this.f1174h = i2;
        } else {
            super.setDropDownWidth(i2);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup != null) {
            spinnerPopup.b(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i2) {
        setPopupBackgroundDrawable(AppCompatResources.b(getPopupContext(), i2));
    }

    public void setPrompt(CharSequence charSequence) {
        SpinnerPopup spinnerPopup = this.f1173g;
        if (spinnerPopup != null) {
            spinnerPopup.g(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1168b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1168b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, -1);
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1172f) {
            this.f1171e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1173g != null) {
            Context context = this.f1169c;
            if (context == null) {
                context = getContext();
            }
            this.f1173g.l(new DropDownAdapter(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(context, attributeSet, i2, i3, (Resources.Theme) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (r11 != null) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppCompatSpinner(android.content.Context r7, android.util.AttributeSet r8, int r9, int r10, android.content.res.Resources.Theme r11) {
        /*
            r6 = this;
            r6.<init>(r7, r8, r9)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r6.f1175i = r0
            android.content.Context r0 = r6.getContext()
            androidx.appcompat.widget.ThemeUtils.a(r6, r0)
            int[] r0 = androidx.appcompat.R$styleable.H2
            r1 = 0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.v(r7, r8, r0, r9, r1)
            androidx.appcompat.widget.AppCompatBackgroundHelper r2 = new androidx.appcompat.widget.AppCompatBackgroundHelper
            r2.<init>(r6)
            r6.f1168b = r2
            if (r11 == 0) goto L_0x0029
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (android.content.res.Resources.Theme) r11)
            r6.f1169c = r2
            goto L_0x003b
        L_0x0029:
            int r11 = androidx.appcompat.R$styleable.M2
            int r11 = r0.n(r11, r1)
            if (r11 == 0) goto L_0x0039
            androidx.appcompat.view.ContextThemeWrapper r2 = new androidx.appcompat.view.ContextThemeWrapper
            r2.<init>((android.content.Context) r7, (int) r11)
            r6.f1169c = r2
            goto L_0x003b
        L_0x0039:
            r6.f1169c = r7
        L_0x003b:
            r11 = -1
            r2 = 0
            if (r10 != r11) goto L_0x006b
            int[] r11 = f1167j     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            android.content.res.TypedArray r11 = r7.obtainStyledAttributes(r8, r11, r9, r1)     // Catch:{ Exception -> 0x0057, all -> 0x0055 }
            boolean r3 = r11.hasValue(r1)     // Catch:{ Exception -> 0x0053 }
            if (r3 == 0) goto L_0x004f
            int r10 = r11.getInt(r1, r1)     // Catch:{ Exception -> 0x0053 }
        L_0x004f:
            r11.recycle()
            goto L_0x006b
        L_0x0053:
            r3 = move-exception
            goto L_0x0059
        L_0x0055:
            r7 = move-exception
            goto L_0x0065
        L_0x0057:
            r3 = move-exception
            r11 = r2
        L_0x0059:
            java.lang.String r4 = "AppCompatSpinner"
            java.lang.String r5 = "Could not read android:spinnerMode"
            android.util.Log.i(r4, r5, r3)     // Catch:{ all -> 0x0063 }
            if (r11 == 0) goto L_0x006b
            goto L_0x004f
        L_0x0063:
            r7 = move-exception
            r2 = r11
        L_0x0065:
            if (r2 == 0) goto L_0x006a
            r2.recycle()
        L_0x006a:
            throw r7
        L_0x006b:
            r11 = 1
            if (r10 == 0) goto L_0x00a8
            if (r10 == r11) goto L_0x0071
            goto L_0x00b8
        L_0x0071:
            androidx.appcompat.widget.AppCompatSpinner$DropdownPopup r10 = new androidx.appcompat.widget.AppCompatSpinner$DropdownPopup
            android.content.Context r3 = r6.f1169c
            r10.<init>(r3, r8, r9)
            android.content.Context r3 = r6.f1169c
            int[] r4 = androidx.appcompat.R$styleable.H2
            androidx.appcompat.widget.TintTypedArray r1 = androidx.appcompat.widget.TintTypedArray.v(r3, r8, r4, r9, r1)
            int r3 = androidx.appcompat.R$styleable.L2
            r4 = -2
            int r3 = r1.m(r3, r4)
            r6.f1174h = r3
            int r3 = androidx.appcompat.R$styleable.J2
            android.graphics.drawable.Drawable r3 = r1.g(r3)
            r10.b(r3)
            int r3 = androidx.appcompat.R$styleable.K2
            java.lang.String r3 = r0.o(r3)
            r10.g(r3)
            r1.w()
            r6.f1173g = r10
            androidx.appcompat.widget.AppCompatSpinner$1 r1 = new androidx.appcompat.widget.AppCompatSpinner$1
            r1.<init>(r6, r10)
            r6.f1170d = r1
            goto L_0x00b8
        L_0x00a8:
            androidx.appcompat.widget.AppCompatSpinner$DialogPopup r10 = new androidx.appcompat.widget.AppCompatSpinner$DialogPopup
            r10.<init>()
            r6.f1173g = r10
            int r1 = androidx.appcompat.R$styleable.K2
            java.lang.String r1 = r0.o(r1)
            r10.g(r1)
        L_0x00b8:
            int r10 = androidx.appcompat.R$styleable.I2
            java.lang.CharSequence[] r10 = r0.q(r10)
            if (r10 == 0) goto L_0x00d0
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r7, r3, r10)
            int r7 = androidx.appcompat.R$layout.f213v
            r1.setDropDownViewResource(r7)
            r6.setAdapter((android.widget.SpinnerAdapter) r1)
        L_0x00d0:
            r0.w()
            r6.f1172f = r11
            android.widget.SpinnerAdapter r7 = r6.f1171e
            if (r7 == 0) goto L_0x00de
            r6.setAdapter((android.widget.SpinnerAdapter) r7)
            r6.f1171e = r2
        L_0x00de:
            androidx.appcompat.widget.AppCompatBackgroundHelper r7 = r6.f1168b
            r7.e(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}

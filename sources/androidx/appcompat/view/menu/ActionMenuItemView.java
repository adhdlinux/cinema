package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;

public class ActionMenuItemView extends AppCompatTextView implements MenuView.ItemView, View.OnClickListener, ActionMenuView.ActionMenuChildView {

    /* renamed from: b  reason: collision with root package name */
    MenuItemImpl f749b;

    /* renamed from: c  reason: collision with root package name */
    private CharSequence f750c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f751d;

    /* renamed from: e  reason: collision with root package name */
    MenuBuilder.ItemInvoker f752e;

    /* renamed from: f  reason: collision with root package name */
    private ForwardingListener f753f;

    /* renamed from: g  reason: collision with root package name */
    PopupCallback f754g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f755h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f756i;

    /* renamed from: j  reason: collision with root package name */
    private int f757j;

    /* renamed from: k  reason: collision with root package name */
    private int f758k;

    /* renamed from: l  reason: collision with root package name */
    private int f759l;

    private class ActionMenuItemForwardingListener extends ForwardingListener {
        public ActionMenuItemForwardingListener() {
            super(ActionMenuItemView.this);
        }

        public ShowableListMenu b() {
            PopupCallback popupCallback = ActionMenuItemView.this.f754g;
            if (popupCallback != null) {
                return popupCallback.a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public boolean c() {
            ShowableListMenu b2;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            MenuBuilder.ItemInvoker itemInvoker = actionMenuItemView.f752e;
            if (itemInvoker == null || !itemInvoker.b(actionMenuItemView.f749b) || (b2 = b()) == null || !b2.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class PopupCallback {
        public abstract ShowableListMenu a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean f() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (i2 >= 480 || ((i2 >= 640 && i3 >= 480) || configuration.orientation == 2)) {
            return true;
        }
        return false;
    }

    private void g() {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean z2 = true;
        boolean z3 = !TextUtils.isEmpty(this.f750c);
        if (this.f751d != null && (!this.f749b.B() || (!this.f755h && !this.f756i))) {
            z2 = false;
        }
        boolean z4 = z3 & z2;
        CharSequence charSequence3 = null;
        if (z4) {
            charSequence = this.f750c;
        } else {
            charSequence = null;
        }
        setText(charSequence);
        CharSequence contentDescription = this.f749b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            if (z4) {
                charSequence2 = null;
            } else {
                charSequence2 = this.f749b.getTitle();
            }
            setContentDescription(charSequence2);
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f749b.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z4) {
                charSequence3 = this.f749b.getTitle();
            }
            TooltipCompat.a(this, charSequence3);
            return;
        }
        TooltipCompat.a(this, tooltipText);
    }

    public boolean a() {
        return e();
    }

    public boolean b() {
        return e() && this.f749b.getIcon() == null;
    }

    public void c(MenuItemImpl menuItemImpl, int i2) {
        int i3;
        this.f749b = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.i(this));
        setId(menuItemImpl.getItemId());
        if (menuItemImpl.isVisible()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f753f == null) {
            this.f753f = new ActionMenuItemForwardingListener();
        }
    }

    public boolean d() {
        return true;
    }

    public boolean e() {
        return !TextUtils.isEmpty(getText());
    }

    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public MenuItemImpl getItemData() {
        return this.f749b;
    }

    public void onClick(View view) {
        MenuBuilder.ItemInvoker itemInvoker = this.f752e;
        if (itemInvoker != null) {
            itemInvoker.b(this.f749b);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f755h = f();
        g();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        boolean e2 = e();
        if (e2 && (i5 = this.f758k) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i4 = Math.min(size, this.f757j);
        } else {
            i4 = this.f757j;
        }
        if (mode != 1073741824 && this.f757j > 0 && measuredWidth < i4) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), i3);
        }
        if (!e2 && this.f751d != null) {
            super.setPadding((getMeasuredWidth() - this.f751d.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (!this.f749b.hasSubMenu() || (forwardingListener = this.f753f) == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }

    public void setExpandedFormat(boolean z2) {
        if (this.f756i != z2) {
            this.f756i = z2;
            MenuItemImpl menuItemImpl = this.f749b;
            if (menuItemImpl != null) {
                menuItemImpl.c();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f751d = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.f759l;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i2) / ((float) intrinsicHeight)));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        g();
    }

    public void setItemInvoker(MenuBuilder.ItemInvoker itemInvoker) {
        this.f752e = itemInvoker;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.f758k = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(PopupCallback popupCallback) {
        this.f754g = popupCallback;
    }

    public void setTitle(CharSequence charSequence) {
        this.f750c = charSequence;
        g();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources = context.getResources();
        this.f755h = f();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f296v, i2, 0);
        this.f757j = obtainStyledAttributes.getDimensionPixelSize(R$styleable.f298w, 0);
        obtainStyledAttributes.recycle();
        this.f759l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f758k = -1;
        setSaveEnabled(false);
    }
}

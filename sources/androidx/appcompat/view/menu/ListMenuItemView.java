package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;

public class ListMenuItemView extends LinearLayout implements MenuView.ItemView, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: b  reason: collision with root package name */
    private MenuItemImpl f811b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f812c;

    /* renamed from: d  reason: collision with root package name */
    private RadioButton f813d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f814e;

    /* renamed from: f  reason: collision with root package name */
    private CheckBox f815f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f816g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f817h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f818i;

    /* renamed from: j  reason: collision with root package name */
    private LinearLayout f819j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f820k;

    /* renamed from: l  reason: collision with root package name */
    private int f821l;

    /* renamed from: m  reason: collision with root package name */
    private Context f822m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f823n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f824o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f825p;

    /* renamed from: q  reason: collision with root package name */
    private LayoutInflater f826q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f827r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.I);
    }

    private void a(View view) {
        b(view, -1);
    }

    private void b(View view, int i2) {
        LinearLayout linearLayout = this.f819j;
        if (linearLayout != null) {
            linearLayout.addView(view, i2);
        } else {
            addView(view, i2);
        }
    }

    private void e() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.f201j, this, false);
        this.f815f = checkBox;
        a(checkBox);
    }

    private void f() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.f202k, this, false);
        this.f812c = imageView;
        b(imageView, 0);
    }

    private void g() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.f204m, this, false);
        this.f813d = radioButton;
        a(radioButton);
    }

    private LayoutInflater getInflater() {
        if (this.f826q == null) {
            this.f826q = LayoutInflater.from(getContext());
        }
        return this.f826q;
    }

    private void setSubMenuArrowVisible(boolean z2) {
        int i2;
        ImageView imageView = this.f817h;
        if (imageView != null) {
            if (z2) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f818i;
        if (imageView != null && imageView.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f818i.getLayoutParams();
            rect.top += this.f818i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
    }

    public void c(MenuItemImpl menuItemImpl, int i2) {
        int i3;
        this.f811b = menuItemImpl;
        if (menuItemImpl.isVisible()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        setVisibility(i3);
        setTitle(menuItemImpl.i(this));
        setCheckable(menuItemImpl.isCheckable());
        h(menuItemImpl.A(), menuItemImpl.g());
        setIcon(menuItemImpl.getIcon());
        setEnabled(menuItemImpl.isEnabled());
        setSubMenuArrowVisible(menuItemImpl.hasSubMenu());
        setContentDescription(menuItemImpl.getContentDescription());
    }

    public boolean d() {
        return false;
    }

    public MenuItemImpl getItemData() {
        return this.f811b;
    }

    public void h(boolean z2, char c2) {
        int i2;
        if (!z2 || !this.f811b.A()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        if (i2 == 0) {
            this.f816g.setText(this.f811b.h());
        }
        if (this.f816g.getVisibility() != i2) {
            this.f816g.setVisibility(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        ViewCompat.v0(this, this.f820k);
        TextView textView = (TextView) findViewById(R$id.S);
        this.f814e = textView;
        int i2 = this.f821l;
        if (i2 != -1) {
            textView.setTextAppearance(this.f822m, i2);
        }
        this.f816g = (TextView) findViewById(R$id.L);
        ImageView imageView = (ImageView) findViewById(R$id.O);
        this.f817h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f824o);
        }
        this.f818i = (ImageView) findViewById(R$id.f186u);
        this.f819j = (LinearLayout) findViewById(R$id.f178m);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f812c != null && this.f823n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f812c.getLayoutParams();
            int i4 = layoutParams.height;
            if (i4 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i4;
            }
        }
        super.onMeasure(i2, i3);
    }

    public void setCheckable(boolean z2) {
        View view;
        CompoundButton compoundButton;
        if (z2 || this.f813d != null || this.f815f != null) {
            if (this.f811b.m()) {
                if (this.f813d == null) {
                    g();
                }
                compoundButton = this.f813d;
                view = this.f815f;
            } else {
                if (this.f815f == null) {
                    e();
                }
                compoundButton = this.f815f;
                view = this.f813d;
            }
            if (z2) {
                compoundButton.setChecked(this.f811b.isChecked());
                if (compoundButton.getVisibility() != 0) {
                    compoundButton.setVisibility(0);
                }
                if (view != null && view.getVisibility() != 8) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            CheckBox checkBox = this.f815f;
            if (checkBox != null) {
                checkBox.setVisibility(8);
            }
            RadioButton radioButton = this.f813d;
            if (radioButton != null) {
                radioButton.setVisibility(8);
            }
        }
    }

    public void setChecked(boolean z2) {
        CompoundButton compoundButton;
        if (this.f811b.m()) {
            if (this.f813d == null) {
                g();
            }
            compoundButton = this.f813d;
        } else {
            if (this.f815f == null) {
                e();
            }
            compoundButton = this.f815f;
        }
        compoundButton.setChecked(z2);
    }

    public void setForceShowIcon(boolean z2) {
        this.f827r = z2;
        this.f823n = z2;
    }

    public void setGroupDividerEnabled(boolean z2) {
        int i2;
        ImageView imageView = this.f818i;
        if (imageView != null) {
            if (this.f825p || !z2) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView.setVisibility(i2);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z2;
        if (this.f811b.z() || this.f827r) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 || this.f823n) {
            ImageView imageView = this.f812c;
            if (imageView != null || drawable != null || this.f823n) {
                if (imageView == null) {
                    f();
                }
                if (drawable != null || this.f823n) {
                    ImageView imageView2 = this.f812c;
                    if (!z2) {
                        drawable = null;
                    }
                    imageView2.setImageDrawable(drawable);
                    if (this.f812c.getVisibility() != 0) {
                        this.f812c.setVisibility(0);
                        return;
                    }
                    return;
                }
                this.f812c.setVisibility(8);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f814e.setText(charSequence);
            if (this.f814e.getVisibility() != 0) {
                this.f814e.setVisibility(0);
            }
        } else if (this.f814e.getVisibility() != 8) {
            this.f814e.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        TintTypedArray v2 = TintTypedArray.v(getContext(), attributeSet, R$styleable.d2, i2, 0);
        this.f820k = v2.g(R$styleable.f2);
        this.f821l = v2.n(R$styleable.e2, -1);
        this.f823n = v2.a(R$styleable.g2, false);
        this.f822m = context;
        this.f824o = v2.g(R$styleable.h2);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes((AttributeSet) null, new int[]{16843049}, R$attr.D, 0);
        this.f825p = obtainStyledAttributes.hasValue(0);
        v2.w();
        obtainStyledAttributes.recycle();
    }
}

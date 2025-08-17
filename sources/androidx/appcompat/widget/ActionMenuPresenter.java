package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {
    ActionButtonSubmenu A;
    OpenOverflowRunnable B;
    private ActionMenuPopupCallback C;
    final PopupPresenterCallback D = new PopupPresenterCallback();
    int E;

    /* renamed from: l  reason: collision with root package name */
    OverflowMenuButton f1017l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f1018m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1019n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1020o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1021p;

    /* renamed from: q  reason: collision with root package name */
    private int f1022q;

    /* renamed from: r  reason: collision with root package name */
    private int f1023r;

    /* renamed from: s  reason: collision with root package name */
    private int f1024s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1025t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f1026u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f1027v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f1028w;

    /* renamed from: x  reason: collision with root package name */
    private int f1029x;

    /* renamed from: y  reason: collision with root package name */
    private final SparseBooleanArray f1030y = new SparseBooleanArray();

    /* renamed from: z  reason: collision with root package name */
    OverflowPopup f1031z;

    private class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(context, subMenuBuilder, view, false, R$attr.f101l);
            if (!((MenuItemImpl) subMenuBuilder.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f1017l;
                f(view2 == null ? (View) ActionMenuPresenter.this.f769j : view2);
            }
            j(ActionMenuPresenter.this.D);
        }

        /* access modifiers changed from: protected */
        public void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.A = null;
            actionMenuPresenter.E = 0;
            super.e();
        }
    }

    private class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        ActionMenuPopupCallback() {
        }

        public ShowableListMenu a() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.A;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.c();
            }
            return null;
        }
    }

    private class OpenOverflowRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private OverflowPopup f1034b;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.f1034b = overflowPopup;
        }

        public void run() {
            if (ActionMenuPresenter.this.f763d != null) {
                ActionMenuPresenter.this.f763d.d();
            }
            View view = (View) ActionMenuPresenter.this.f769j;
            if (!(view == null || view.getWindowToken() == null || !this.f1034b.m())) {
                ActionMenuPresenter.this.f1031z = this.f1034b;
            }
            ActionMenuPresenter.this.B = null;
        }
    }

    private class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, (AttributeSet) null, R$attr.f100k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this, ActionMenuPresenter.this) {
                public ShowableListMenu b() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.f1031z;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.c();
                }

                public boolean c() {
                    ActionMenuPresenter.this.N();
                    return true;
                }

                public boolean d() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.B != null) {
                        return false;
                    }
                    actionMenuPresenter.E();
                    return true;
                }
            });
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.N();
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                DrawableCompat.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    private class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view, boolean z2) {
            super(context, menuBuilder, view, z2, R$attr.f101l);
            h(8388613);
            j(ActionMenuPresenter.this.D);
        }

        /* access modifiers changed from: protected */
        public void e() {
            if (ActionMenuPresenter.this.f763d != null) {
                ActionMenuPresenter.this.f763d.close();
            }
            ActionMenuPresenter.this.f1031z = null;
            super.e();
        }
    }

    private class PopupPresenterCallback implements MenuPresenter.Callback {
        PopupPresenterCallback() {
        }

        public void a(MenuBuilder menuBuilder, boolean z2) {
            if (menuBuilder instanceof SubMenuBuilder) {
                menuBuilder.F().e(false);
            }
            MenuPresenter.Callback p2 = ActionMenuPresenter.this.p();
            if (p2 != null) {
                p2.a(menuBuilder, z2);
            }
        }

        public boolean b(MenuBuilder menuBuilder) {
            if (menuBuilder == ActionMenuPresenter.this.f763d) {
                return false;
            }
            ActionMenuPresenter.this.E = ((SubMenuBuilder) menuBuilder).getItem().getItemId();
            MenuPresenter.Callback p2 = ActionMenuPresenter.this.p();
            if (p2 != null) {
                return p2.b(menuBuilder);
            }
            return false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    private static class SavedState implements Parcelable {
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
        public int f1041b;

        SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1041b);
        }

        SavedState(Parcel parcel) {
            this.f1041b = parcel.readInt();
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R$layout.f194c, R$layout.f193b);
    }

    private View C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f769j;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean B() {
        return E() | F();
    }

    public Drawable D() {
        OverflowMenuButton overflowMenuButton = this.f1017l;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.f1019n) {
            return this.f1018m;
        }
        return null;
    }

    public boolean E() {
        MenuView menuView;
        OpenOverflowRunnable openOverflowRunnable = this.B;
        if (openOverflowRunnable == null || (menuView = this.f769j) == null) {
            OverflowPopup overflowPopup = this.f1031z;
            if (overflowPopup == null) {
                return false;
            }
            overflowPopup.b();
            return true;
        }
        ((View) menuView).removeCallbacks(openOverflowRunnable);
        this.B = null;
        return true;
    }

    public boolean F() {
        ActionButtonSubmenu actionButtonSubmenu = this.A;
        if (actionButtonSubmenu == null) {
            return false;
        }
        actionButtonSubmenu.b();
        return true;
    }

    public boolean G() {
        return this.B != null || H();
    }

    public boolean H() {
        OverflowPopup overflowPopup = this.f1031z;
        return overflowPopup != null && overflowPopup.d();
    }

    public void I(Configuration configuration) {
        if (!this.f1025t) {
            this.f1024s = ActionBarPolicy.b(this.f762c).d();
        }
        MenuBuilder menuBuilder = this.f763d;
        if (menuBuilder != null) {
            menuBuilder.M(true);
        }
    }

    public void J(boolean z2) {
        this.f1028w = z2;
    }

    public void K(ActionMenuView actionMenuView) {
        this.f769j = actionMenuView;
        actionMenuView.a(this.f763d);
    }

    public void L(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.f1017l;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
            return;
        }
        this.f1019n = true;
        this.f1018m = drawable;
    }

    public void M(boolean z2) {
        this.f1020o = z2;
        this.f1021p = true;
    }

    public boolean N() {
        MenuBuilder menuBuilder;
        if (!this.f1020o || H() || (menuBuilder = this.f763d) == null || this.f769j == null || this.B != null || menuBuilder.B().isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.f762c, this.f763d, this.f1017l, true));
        this.B = openOverflowRunnable;
        ((View) this.f769j).post(openOverflowRunnable);
        return true;
    }

    public void a(MenuBuilder menuBuilder, boolean z2) {
        B();
        super.a(menuBuilder, z2);
    }

    public void d(Parcelable parcelable) {
        int i2;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i2 = ((SavedState) parcelable).f1041b) > 0 && (findItem = this.f763d.findItem(i2)) != null) {
            e((SubMenuBuilder) findItem.getSubMenu());
        }
    }

    public boolean e(SubMenuBuilder subMenuBuilder) {
        boolean z2 = false;
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.i0() != this.f763d) {
            subMenuBuilder2 = (SubMenuBuilder) subMenuBuilder2.i0();
        }
        View C2 = C(subMenuBuilder2.getItem());
        if (C2 == null) {
            return false;
        }
        this.E = subMenuBuilder.getItem().getItemId();
        int size = subMenuBuilder.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = subMenuBuilder.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i2++;
        }
        ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.f762c, subMenuBuilder, C2);
        this.A = actionButtonSubmenu;
        actionButtonSubmenu.g(z2);
        this.A.k();
        super.e(subMenuBuilder);
        return true;
    }

    public void f(boolean z2) {
        if (z2) {
            super.e((SubMenuBuilder) null);
            return;
        }
        MenuBuilder menuBuilder = this.f763d;
        if (menuBuilder != null) {
            menuBuilder.e(false);
        }
    }

    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f1041b = this.E;
        return savedState;
    }

    public void h(boolean z2) {
        ArrayList<MenuItemImpl> arrayList;
        MenuView menuView;
        super.h(z2);
        ((View) this.f769j).requestLayout();
        MenuBuilder menuBuilder = this.f763d;
        boolean z3 = false;
        if (menuBuilder != null) {
            ArrayList<MenuItemImpl> u2 = menuBuilder.u();
            int size = u2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ActionProvider a2 = u2.get(i2).a();
                if (a2 != null) {
                    a2.setSubUiVisibilityListener(this);
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f763d;
        if (menuBuilder2 != null) {
            arrayList = menuBuilder2.B();
        } else {
            arrayList = null;
        }
        if (this.f1020o && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z3 = !arrayList.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f1017l == null) {
                this.f1017l = new OverflowMenuButton(this.f761b);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1017l.getParent();
            if (viewGroup != this.f769j) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1017l);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f769j;
                actionMenuView.addView(this.f1017l, actionMenuView.D());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.f1017l;
            if (overflowMenuButton != null && overflowMenuButton.getParent() == (menuView = this.f769j)) {
                ((ViewGroup) menuView).removeView(this.f1017l);
            }
        }
        ((ActionMenuView) this.f769j).setOverflowReserved(this.f1020o);
    }

    public boolean i() {
        int i2;
        ArrayList<MenuItemImpl> arrayList;
        int i3;
        int i4;
        int i5;
        boolean z2;
        boolean z3;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f763d;
        View view = null;
        int i6 = 0;
        if (menuBuilder != null) {
            arrayList = menuBuilder.G();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = actionMenuPresenter.f1024s;
        int i8 = actionMenuPresenter.f1023r;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f769j;
        boolean z4 = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            MenuItemImpl menuItemImpl = arrayList.get(i11);
            if (menuItemImpl.o()) {
                i9++;
            } else if (menuItemImpl.n()) {
                i10++;
            } else {
                z4 = true;
            }
            if (actionMenuPresenter.f1028w && menuItemImpl.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (actionMenuPresenter.f1020o && (z4 || i10 + i9 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f1030y;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f1026u) {
            int i13 = actionMenuPresenter.f1029x;
            i3 = i8 / i13;
            i4 = i13 + ((i8 % i13) / i3);
        } else {
            i4 = 0;
            i3 = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < i2) {
            MenuItemImpl menuItemImpl2 = arrayList.get(i14);
            if (menuItemImpl2.o()) {
                View q2 = actionMenuPresenter.q(menuItemImpl2, view, viewGroup);
                if (actionMenuPresenter.f1026u) {
                    i3 -= ActionMenuView.J(q2, i4, i3, makeMeasureSpec, i6);
                } else {
                    q2.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = q2.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                int groupId = menuItemImpl2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                menuItemImpl2.u(true);
                i5 = i2;
            } else if (menuItemImpl2.n()) {
                int groupId2 = menuItemImpl2.getGroupId();
                boolean z5 = sparseBooleanArray.get(groupId2);
                if ((i12 > 0 || z5) && i8 > 0 && (!actionMenuPresenter.f1026u || i3 > 0)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                boolean z6 = z2;
                i5 = i2;
                if (z2) {
                    View q3 = actionMenuPresenter.q(menuItemImpl2, (View) null, viewGroup);
                    if (actionMenuPresenter.f1026u) {
                        int J = ActionMenuView.J(q3, i4, i3, makeMeasureSpec, 0);
                        i3 -= J;
                        if (J == 0) {
                            z6 = false;
                        }
                    } else {
                        q3.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z7 = z6;
                    int measuredWidth2 = q3.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    if (!actionMenuPresenter.f1026u ? i8 + i15 <= 0 : i8 < 0) {
                        z3 = false;
                    } else {
                        z3 = true;
                    }
                    z2 = z7 & z3;
                }
                if (z2 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z5) {
                    sparseBooleanArray.put(groupId2, false);
                    int i16 = 0;
                    while (i16 < i14) {
                        MenuItemImpl menuItemImpl3 = arrayList.get(i16);
                        if (menuItemImpl3.getGroupId() == groupId2) {
                            if (menuItemImpl3.l()) {
                                i12++;
                            }
                            menuItemImpl3.u(false);
                        }
                        i16++;
                    }
                }
                if (z2) {
                    i12--;
                }
                menuItemImpl2.u(z2);
            } else {
                i5 = i2;
                menuItemImpl2.u(false);
                i14++;
                view = null;
                actionMenuPresenter = this;
                i2 = i5;
                i6 = 0;
            }
            i14++;
            view = null;
            actionMenuPresenter = this;
            i2 = i5;
            i6 = 0;
        }
        return true;
    }

    public void k(Context context, MenuBuilder menuBuilder) {
        super.k(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy b2 = ActionBarPolicy.b(context);
        if (!this.f1021p) {
            this.f1020o = b2.h();
        }
        if (!this.f1027v) {
            this.f1022q = b2.c();
        }
        if (!this.f1025t) {
            this.f1024s = b2.d();
        }
        int i2 = this.f1022q;
        if (this.f1020o) {
            if (this.f1017l == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f761b);
                this.f1017l = overflowMenuButton;
                if (this.f1019n) {
                    overflowMenuButton.setImageDrawable(this.f1018m);
                    this.f1018m = null;
                    this.f1019n = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1017l.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.f1017l.getMeasuredWidth();
        } else {
            this.f1017l = null;
        }
        this.f1023r = i2;
        this.f1029x = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    public void m(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.c(menuItemImpl, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f769j);
        if (this.C == null) {
            this.C = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.C);
    }

    public boolean o(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f1017l) {
            return false;
        }
        return super.o(viewGroup, i2);
    }

    public View q(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        int i2;
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.j()) {
            actionView = super.q(menuItemImpl, view, viewGroup);
        }
        if (menuItemImpl.isActionViewExpanded()) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        actionView.setVisibility(i2);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m(layoutParams));
        }
        return actionView;
    }

    public MenuView r(ViewGroup viewGroup) {
        MenuView menuView = this.f769j;
        MenuView r2 = super.r(viewGroup);
        if (menuView != r2) {
            ((ActionMenuView) r2).setPresenter(this);
        }
        return r2;
    }

    public boolean t(int i2, MenuItemImpl menuItemImpl) {
        return menuItemImpl.l();
    }
}

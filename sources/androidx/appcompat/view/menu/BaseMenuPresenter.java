package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: b  reason: collision with root package name */
    protected Context f761b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f762c;

    /* renamed from: d  reason: collision with root package name */
    protected MenuBuilder f763d;

    /* renamed from: e  reason: collision with root package name */
    protected LayoutInflater f764e;

    /* renamed from: f  reason: collision with root package name */
    protected LayoutInflater f765f;

    /* renamed from: g  reason: collision with root package name */
    private MenuPresenter.Callback f766g;

    /* renamed from: h  reason: collision with root package name */
    private int f767h;

    /* renamed from: i  reason: collision with root package name */
    private int f768i;

    /* renamed from: j  reason: collision with root package name */
    protected MenuView f769j;

    /* renamed from: k  reason: collision with root package name */
    private int f770k;

    public BaseMenuPresenter(Context context, int i2, int i3) {
        this.f761b = context;
        this.f764e = LayoutInflater.from(context);
        this.f767h = i2;
        this.f768i = i3;
    }

    public void a(MenuBuilder menuBuilder, boolean z2) {
        MenuPresenter.Callback callback = this.f766g;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void c(MenuPresenter.Callback callback) {
        this.f766g = callback;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(androidx.appcompat.view.menu.SubMenuBuilder r2) {
        /*
            r1 = this;
            androidx.appcompat.view.menu.MenuPresenter$Callback r0 = r1.f766g
            if (r0 == 0) goto L_0x000e
            if (r2 == 0) goto L_0x0007
            goto L_0x0009
        L_0x0007:
            androidx.appcompat.view.menu.MenuBuilder r2 = r1.f763d
        L_0x0009:
            boolean r2 = r0.b(r2)
            return r2
        L_0x000e:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.BaseMenuPresenter.e(androidx.appcompat.view.menu.SubMenuBuilder):boolean");
    }

    public int getId() {
        return this.f770k;
    }

    public void h(boolean z2) {
        MenuItemImpl menuItemImpl;
        ViewGroup viewGroup = (ViewGroup) this.f769j;
        if (viewGroup != null) {
            MenuBuilder menuBuilder = this.f763d;
            int i2 = 0;
            if (menuBuilder != null) {
                menuBuilder.t();
                ArrayList<MenuItemImpl> G = this.f763d.G();
                int size = G.size();
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    MenuItemImpl menuItemImpl2 = G.get(i4);
                    if (t(i3, menuItemImpl2)) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (childAt instanceof MenuView.ItemView) {
                            menuItemImpl = ((MenuView.ItemView) childAt).getItemData();
                        } else {
                            menuItemImpl = null;
                        }
                        View q2 = q(menuItemImpl2, childAt, viewGroup);
                        if (menuItemImpl2 != menuItemImpl) {
                            q2.setPressed(false);
                            q2.jumpDrawablesToCurrentState();
                        }
                        if (q2 != childAt) {
                            l(q2, i3);
                        }
                        i3++;
                    }
                }
                i2 = i3;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (!o(viewGroup, i2)) {
                    i2++;
                }
            }
        }
    }

    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void k(Context context, MenuBuilder menuBuilder) {
        this.f762c = context;
        this.f765f = LayoutInflater.from(context);
        this.f763d = menuBuilder;
    }

    /* access modifiers changed from: protected */
    public void l(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f769j).addView(view, i2);
    }

    public abstract void m(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public MenuView.ItemView n(ViewGroup viewGroup) {
        return (MenuView.ItemView) this.f764e.inflate(this.f768i, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public boolean o(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public MenuPresenter.Callback p() {
        return this.f766g;
    }

    public View q(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemView;
        if (view instanceof MenuView.ItemView) {
            itemView = (MenuView.ItemView) view;
        } else {
            itemView = n(viewGroup);
        }
        m(menuItemImpl, itemView);
        return (View) itemView;
    }

    public MenuView r(ViewGroup viewGroup) {
        if (this.f769j == null) {
            MenuView menuView = (MenuView) this.f764e.inflate(this.f767h, viewGroup, false);
            this.f769j = menuView;
            menuView.a(this.f763d);
            h(true);
        }
        return this.f769j;
    }

    public void s(int i2) {
        this.f770k = i2;
    }

    public abstract boolean t(int i2, MenuItemImpl menuItemImpl);
}

package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import java.util.ArrayList;

public class NavigationMenuPresenter implements MenuPresenter {

    /* renamed from: b  reason: collision with root package name */
    private NavigationMenuView f29873b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f29874c;

    /* renamed from: d  reason: collision with root package name */
    private MenuPresenter.Callback f29875d;

    /* renamed from: e  reason: collision with root package name */
    MenuBuilder f29876e;

    /* renamed from: f  reason: collision with root package name */
    private int f29877f;

    /* renamed from: g  reason: collision with root package name */
    NavigationMenuAdapter f29878g;

    /* renamed from: h  reason: collision with root package name */
    LayoutInflater f29879h;

    /* renamed from: i  reason: collision with root package name */
    int f29880i;

    /* renamed from: j  reason: collision with root package name */
    boolean f29881j;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f29882k;

    /* renamed from: l  reason: collision with root package name */
    ColorStateList f29883l;

    /* renamed from: m  reason: collision with root package name */
    Drawable f29884m;

    /* renamed from: n  reason: collision with root package name */
    int f29885n;

    /* renamed from: o  reason: collision with root package name */
    int f29886o;

    /* renamed from: p  reason: collision with root package name */
    private int f29887p;

    /* renamed from: q  reason: collision with root package name */
    int f29888q;

    /* renamed from: r  reason: collision with root package name */
    final View.OnClickListener f29889r = new View.OnClickListener() {
        public void onClick(View view) {
            NavigationMenuPresenter.this.E(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean O = navigationMenuPresenter.f29876e.O(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && O) {
                NavigationMenuPresenter.this.f29878g.k(itemData);
            }
            NavigationMenuPresenter.this.E(false);
            NavigationMenuPresenter.this.h(false);
        }
    };

    private static class HeaderViewHolder extends ViewHolder {
        public HeaderViewHolder(View view) {
            super(view);
        }
    }

    private class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        private final ArrayList<NavigationMenuItem> f29891n = new ArrayList<>();

        /* renamed from: o  reason: collision with root package name */
        private MenuItemImpl f29892o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f29893p;

        NavigationMenuAdapter() {
            i();
        }

        private void c(int i2, int i3) {
            while (i2 < i3) {
                ((NavigationMenuTextItem) this.f29891n.get(i2)).f29898b = true;
                i2++;
            }
        }

        private void i() {
            if (!this.f29893p) {
                this.f29893p = true;
                this.f29891n.clear();
                this.f29891n.add(new NavigationMenuHeaderItem());
                int size = NavigationMenuPresenter.this.f29876e.G().size();
                int i2 = -1;
                boolean z2 = false;
                int i3 = 0;
                for (int i4 = 0; i4 < size; i4++) {
                    MenuItemImpl menuItemImpl = NavigationMenuPresenter.this.f29876e.G().get(i4);
                    if (menuItemImpl.isChecked()) {
                        k(menuItemImpl);
                    }
                    if (menuItemImpl.isCheckable()) {
                        menuItemImpl.t(false);
                    }
                    if (menuItemImpl.hasSubMenu()) {
                        SubMenu subMenu = menuItemImpl.getSubMenu();
                        if (subMenu.hasVisibleItems()) {
                            if (i4 != 0) {
                                this.f29891n.add(new NavigationMenuSeparatorItem(NavigationMenuPresenter.this.f29888q, 0));
                            }
                            this.f29891n.add(new NavigationMenuTextItem(menuItemImpl));
                            int size2 = this.f29891n.size();
                            int size3 = subMenu.size();
                            boolean z3 = false;
                            for (int i5 = 0; i5 < size3; i5++) {
                                MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenu.getItem(i5);
                                if (menuItemImpl2.isVisible()) {
                                    if (!z3 && menuItemImpl2.getIcon() != null) {
                                        z3 = true;
                                    }
                                    if (menuItemImpl2.isCheckable()) {
                                        menuItemImpl2.t(false);
                                    }
                                    if (menuItemImpl.isChecked()) {
                                        k(menuItemImpl);
                                    }
                                    this.f29891n.add(new NavigationMenuTextItem(menuItemImpl2));
                                }
                            }
                            if (z3) {
                                c(size2, this.f29891n.size());
                            }
                        }
                    } else {
                        int groupId = menuItemImpl.getGroupId();
                        if (groupId != i2) {
                            i3 = this.f29891n.size();
                            if (menuItemImpl.getIcon() != null) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (i4 != 0) {
                                i3++;
                                ArrayList<NavigationMenuItem> arrayList = this.f29891n;
                                int i6 = NavigationMenuPresenter.this.f29888q;
                                arrayList.add(new NavigationMenuSeparatorItem(i6, i6));
                            }
                        } else if (!z2 && menuItemImpl.getIcon() != null) {
                            c(i3, this.f29891n.size());
                            z2 = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                        navigationMenuTextItem.f29898b = z2;
                        this.f29891n.add(navigationMenuTextItem);
                        i2 = groupId;
                    }
                }
                this.f29893p = false;
            }
        }

        public Bundle d() {
            View view;
            Bundle bundle = new Bundle();
            MenuItemImpl menuItemImpl = this.f29892o;
            if (menuItemImpl != null) {
                bundle.putInt("android:menu:checked", menuItemImpl.getItemId());
            }
            SparseArray sparseArray = new SparseArray();
            int size = this.f29891n.size();
            for (int i2 = 0; i2 < size; i2++) {
                NavigationMenuItem navigationMenuItem = this.f29891n.get(i2);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl a2 = ((NavigationMenuTextItem) navigationMenuItem).a();
                    if (a2 != null) {
                        view = a2.getActionView();
                    } else {
                        view = null;
                    }
                    if (view != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        view.saveHierarchyState(parcelableSparseArray);
                        sparseArray.put(a2.getItemId(), parcelableSparseArray);
                    }
                }
            }
            bundle.putSparseParcelableArray("android:menu:action_views", sparseArray);
            return bundle;
        }

        public MenuItemImpl e() {
            return this.f29892o;
        }

        /* renamed from: f */
        public void onBindViewHolder(ViewHolder viewHolder, int i2) {
            Drawable drawable;
            int itemViewType = getItemViewType(i2);
            if (itemViewType == 0) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder.itemView;
                navigationMenuItemView.setIconTintList(NavigationMenuPresenter.this.f29883l);
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                if (navigationMenuPresenter.f29881j) {
                    navigationMenuItemView.setTextAppearance(navigationMenuPresenter.f29880i);
                }
                ColorStateList colorStateList = NavigationMenuPresenter.this.f29882k;
                if (colorStateList != null) {
                    navigationMenuItemView.setTextColor(colorStateList);
                }
                Drawable drawable2 = NavigationMenuPresenter.this.f29884m;
                if (drawable2 != null) {
                    drawable = drawable2.getConstantState().newDrawable();
                } else {
                    drawable = null;
                }
                ViewCompat.v0(navigationMenuItemView, drawable);
                NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) this.f29891n.get(i2);
                navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.f29898b);
                navigationMenuItemView.setHorizontalPadding(NavigationMenuPresenter.this.f29885n);
                navigationMenuItemView.setIconPadding(NavigationMenuPresenter.this.f29886o);
                navigationMenuItemView.c(navigationMenuTextItem.a(), 0);
            } else if (itemViewType == 1) {
                ((TextView) viewHolder.itemView).setText(((NavigationMenuTextItem) this.f29891n.get(i2)).a().getTitle());
            } else if (itemViewType == 2) {
                NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) this.f29891n.get(i2);
                viewHolder.itemView.setPadding(0, navigationMenuSeparatorItem.b(), 0, navigationMenuSeparatorItem.a());
            }
        }

        /* renamed from: g */
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            if (i2 == 0) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                return new NormalViewHolder(navigationMenuPresenter.f29879h, viewGroup, navigationMenuPresenter.f29889r);
            } else if (i2 == 1) {
                return new SubheaderViewHolder(NavigationMenuPresenter.this.f29879h, viewGroup);
            } else {
                if (i2 == 2) {
                    return new SeparatorViewHolder(NavigationMenuPresenter.this.f29879h, viewGroup);
                }
                if (i2 != 3) {
                    return null;
                }
                return new HeaderViewHolder(NavigationMenuPresenter.this.f29874c);
            }
        }

        public int getItemCount() {
            return this.f29891n.size();
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public int getItemViewType(int i2) {
            NavigationMenuItem navigationMenuItem = this.f29891n.get(i2);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (!(navigationMenuItem instanceof NavigationMenuTextItem)) {
                throw new RuntimeException("Unknown item type.");
            } else if (((NavigationMenuTextItem) navigationMenuItem).a().hasSubMenu()) {
                return 1;
            } else {
                return 0;
            }
        }

        /* renamed from: h */
        public void onViewRecycled(ViewHolder viewHolder) {
            if (viewHolder instanceof NormalViewHolder) {
                ((NavigationMenuItemView) viewHolder.itemView).B();
            }
        }

        public void j(Bundle bundle) {
            MenuItemImpl a2;
            View actionView;
            ParcelableSparseArray parcelableSparseArray;
            MenuItemImpl a3;
            int i2 = bundle.getInt("android:menu:checked", 0);
            if (i2 != 0) {
                this.f29893p = true;
                int size = this.f29891n.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    }
                    NavigationMenuItem navigationMenuItem = this.f29891n.get(i3);
                    if ((navigationMenuItem instanceof NavigationMenuTextItem) && (a3 = ((NavigationMenuTextItem) navigationMenuItem).a()) != null && a3.getItemId() == i2) {
                        k(a3);
                        break;
                    }
                    i3++;
                }
                this.f29893p = false;
                i();
            }
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:action_views");
            if (sparseParcelableArray != null) {
                int size2 = this.f29891n.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    NavigationMenuItem navigationMenuItem2 = this.f29891n.get(i4);
                    if (!(!(navigationMenuItem2 instanceof NavigationMenuTextItem) || (a2 = ((NavigationMenuTextItem) navigationMenuItem2).a()) == null || (actionView = a2.getActionView()) == null || (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray.get(a2.getItemId())) == null)) {
                        actionView.restoreHierarchyState(parcelableSparseArray);
                    }
                }
            }
        }

        public void k(MenuItemImpl menuItemImpl) {
            if (this.f29892o != menuItemImpl && menuItemImpl.isCheckable()) {
                MenuItemImpl menuItemImpl2 = this.f29892o;
                if (menuItemImpl2 != null) {
                    menuItemImpl2.setChecked(false);
                }
                this.f29892o = menuItemImpl;
                menuItemImpl.setChecked(true);
            }
        }

        public void l(boolean z2) {
            this.f29893p = z2;
        }

        public void m() {
            i();
            notifyDataSetChanged();
        }
    }

    private static class NavigationMenuHeaderItem implements NavigationMenuItem {
        NavigationMenuHeaderItem() {
        }
    }

    private interface NavigationMenuItem {
    }

    private static class NavigationMenuSeparatorItem implements NavigationMenuItem {

        /* renamed from: a  reason: collision with root package name */
        private final int f29895a;

        /* renamed from: b  reason: collision with root package name */
        private final int f29896b;

        public NavigationMenuSeparatorItem(int i2, int i3) {
            this.f29895a = i2;
            this.f29896b = i3;
        }

        public int a() {
            return this.f29896b;
        }

        public int b() {
            return this.f29895a;
        }
    }

    private static class NavigationMenuTextItem implements NavigationMenuItem {

        /* renamed from: a  reason: collision with root package name */
        private final MenuItemImpl f29897a;

        /* renamed from: b  reason: collision with root package name */
        boolean f29898b;

        NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.f29897a = menuItemImpl;
        }

        public MenuItemImpl a() {
            return this.f29897a;
        }
    }

    private static class NormalViewHolder extends ViewHolder {
        public NormalViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, View.OnClickListener onClickListener) {
            super(layoutInflater.inflate(R$layout.design_navigation_item, viewGroup, false));
            this.itemView.setOnClickListener(onClickListener);
        }
    }

    private static class SeparatorViewHolder extends ViewHolder {
        public SeparatorViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_separator, viewGroup, false));
        }
    }

    private static class SubheaderViewHolder extends ViewHolder {
        public SubheaderViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup) {
            super(layoutInflater.inflate(R$layout.design_navigation_item_subheader, viewGroup, false));
        }
    }

    private static abstract class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }
    }

    public void A(int i2) {
        this.f29886o = i2;
        h(false);
    }

    public void B(ColorStateList colorStateList) {
        this.f29883l = colorStateList;
        h(false);
    }

    public void C(int i2) {
        this.f29880i = i2;
        this.f29881j = true;
        h(false);
    }

    public void D(ColorStateList colorStateList) {
        this.f29882k = colorStateList;
        h(false);
    }

    public void E(boolean z2) {
        NavigationMenuAdapter navigationMenuAdapter = this.f29878g;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.l(z2);
        }
    }

    public void a(MenuBuilder menuBuilder, boolean z2) {
        MenuPresenter.Callback callback = this.f29875d;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void d(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f29873b.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                this.f29878g.j(bundle2);
            }
            SparseArray sparseParcelableArray2 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray2 != null) {
                this.f29874c.restoreHierarchyState(sparseParcelableArray2);
            }
        }
    }

    public boolean e(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void f(View view) {
        this.f29874c.addView(view);
        NavigationMenuView navigationMenuView = this.f29873b;
        navigationMenuView.setPadding(0, 0, 0, navigationMenuView.getPaddingBottom());
    }

    public Parcelable g() {
        Bundle bundle = new Bundle();
        if (this.f29873b != null) {
            SparseArray sparseArray = new SparseArray();
            this.f29873b.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.f29878g;
        if (navigationMenuAdapter != null) {
            bundle.putBundle("android:menu:adapter", navigationMenuAdapter.d());
        }
        if (this.f29874c != null) {
            SparseArray sparseArray2 = new SparseArray();
            this.f29874c.saveHierarchyState(sparseArray2);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray2);
        }
        return bundle;
    }

    public int getId() {
        return this.f29877f;
    }

    public void h(boolean z2) {
        NavigationMenuAdapter navigationMenuAdapter = this.f29878g;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.m();
        }
    }

    public boolean i() {
        return false;
    }

    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void k(Context context, MenuBuilder menuBuilder) {
        this.f29879h = LayoutInflater.from(context);
        this.f29876e = menuBuilder;
        this.f29888q = context.getResources().getDimensionPixelOffset(R$dimen.design_navigation_separator_vertical_padding);
    }

    public void l(WindowInsetsCompat windowInsetsCompat) {
        int k2 = windowInsetsCompat.k();
        if (this.f29887p != k2) {
            this.f29887p = k2;
            if (this.f29874c.getChildCount() == 0) {
                NavigationMenuView navigationMenuView = this.f29873b;
                navigationMenuView.setPadding(0, this.f29887p, 0, navigationMenuView.getPaddingBottom());
            }
        }
        ViewCompat.i(this.f29874c, windowInsetsCompat);
    }

    public MenuItemImpl m() {
        return this.f29878g.e();
    }

    public int n() {
        return this.f29874c.getChildCount();
    }

    public View o(int i2) {
        return this.f29874c.getChildAt(i2);
    }

    public Drawable p() {
        return this.f29884m;
    }

    public int q() {
        return this.f29885n;
    }

    public int r() {
        return this.f29886o;
    }

    public ColorStateList s() {
        return this.f29882k;
    }

    public ColorStateList t() {
        return this.f29883l;
    }

    public MenuView u(ViewGroup viewGroup) {
        if (this.f29873b == null) {
            this.f29873b = (NavigationMenuView) this.f29879h.inflate(R$layout.design_navigation_menu, viewGroup, false);
            if (this.f29878g == null) {
                this.f29878g = new NavigationMenuAdapter();
            }
            this.f29874c = (LinearLayout) this.f29879h.inflate(R$layout.design_navigation_item_header, this.f29873b, false);
            this.f29873b.setAdapter(this.f29878g);
        }
        return this.f29873b;
    }

    public View v(int i2) {
        View inflate = this.f29879h.inflate(i2, this.f29874c, false);
        f(inflate);
        return inflate;
    }

    public void w(MenuItemImpl menuItemImpl) {
        this.f29878g.k(menuItemImpl);
    }

    public void x(int i2) {
        this.f29877f = i2;
    }

    public void y(Drawable drawable) {
        this.f29884m = drawable;
        h(false);
    }

    public void z(int i2) {
        this.f29885n = i2;
        h(false);
    }
}

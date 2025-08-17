package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    Context f828b;

    /* renamed from: c  reason: collision with root package name */
    LayoutInflater f829c;

    /* renamed from: d  reason: collision with root package name */
    MenuBuilder f830d;

    /* renamed from: e  reason: collision with root package name */
    ExpandedMenuView f831e;

    /* renamed from: f  reason: collision with root package name */
    int f832f;

    /* renamed from: g  reason: collision with root package name */
    int f833g;

    /* renamed from: h  reason: collision with root package name */
    int f834h;

    /* renamed from: i  reason: collision with root package name */
    private MenuPresenter.Callback f835i;

    /* renamed from: j  reason: collision with root package name */
    MenuAdapter f836j;

    /* renamed from: k  reason: collision with root package name */
    private int f837k;

    private class MenuAdapter extends BaseAdapter {

        /* renamed from: b  reason: collision with root package name */
        private int f838b = -1;

        public MenuAdapter() {
            a();
        }

        /* access modifiers changed from: package-private */
        public void a() {
            MenuItemImpl x2 = ListMenuPresenter.this.f830d.x();
            if (x2 != null) {
                ArrayList<MenuItemImpl> B = ListMenuPresenter.this.f830d.B();
                int size = B.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (B.get(i2) == x2) {
                        this.f838b = i2;
                        return;
                    }
                }
            }
            this.f838b = -1;
        }

        /* renamed from: b */
        public MenuItemImpl getItem(int i2) {
            ArrayList<MenuItemImpl> B = ListMenuPresenter.this.f830d.B();
            int i3 = i2 + ListMenuPresenter.this.f832f;
            int i4 = this.f838b;
            if (i4 >= 0 && i3 >= i4) {
                i3++;
            }
            return B.get(i3);
        }

        public int getCount() {
            int size = ListMenuPresenter.this.f830d.B().size() - ListMenuPresenter.this.f832f;
            if (this.f838b < 0) {
                return size;
            }
            return size - 1;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f829c.inflate(listMenuPresenter.f834h, viewGroup, false);
            }
            ((MenuView.ItemView) view).c(getItem(i2), 0);
            return view;
        }

        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i2) {
        this(i2, 0);
        this.f828b = context;
        this.f829c = LayoutInflater.from(context);
    }

    public void a(MenuBuilder menuBuilder, boolean z2) {
        MenuPresenter.Callback callback = this.f835i;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void c(MenuPresenter.Callback callback) {
        this.f835i = callback;
    }

    public void d(Parcelable parcelable) {
        m((Bundle) parcelable);
    }

    public boolean e(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        new MenuDialogHelper(subMenuBuilder).d((IBinder) null);
        MenuPresenter.Callback callback = this.f835i;
        if (callback == null) {
            return true;
        }
        callback.b(subMenuBuilder);
        return true;
    }

    public ListAdapter f() {
        if (this.f836j == null) {
            this.f836j = new MenuAdapter();
        }
        return this.f836j;
    }

    public Parcelable g() {
        if (this.f831e == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    public int getId() {
        return this.f837k;
    }

    public void h(boolean z2) {
        MenuAdapter menuAdapter = this.f836j;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public boolean i() {
        return false;
    }

    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void k(Context context, MenuBuilder menuBuilder) {
        if (this.f833g != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f833g);
            this.f828b = contextThemeWrapper;
            this.f829c = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f828b != null) {
            this.f828b = context;
            if (this.f829c == null) {
                this.f829c = LayoutInflater.from(context);
            }
        }
        this.f830d = menuBuilder;
        MenuAdapter menuAdapter = this.f836j;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    public MenuView l(ViewGroup viewGroup) {
        if (this.f831e == null) {
            this.f831e = (ExpandedMenuView) this.f829c.inflate(R$layout.f200i, viewGroup, false);
            if (this.f836j == null) {
                this.f836j = new MenuAdapter();
            }
            this.f831e.setAdapter(this.f836j);
            this.f831e.setOnItemClickListener(this);
        }
        return this.f831e;
    }

    public void m(Bundle bundle) {
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f831e.restoreHierarchyState(sparseParcelableArray);
        }
    }

    public void n(Bundle bundle) {
        SparseArray sparseArray = new SparseArray();
        ExpandedMenuView expandedMenuView = this.f831e;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        this.f830d.O(this.f836j.getItem(i2), this, 0);
    }

    public ListMenuPresenter(int i2, int i3) {
        this.f834h = i2;
        this.f833g = i3;
    }
}

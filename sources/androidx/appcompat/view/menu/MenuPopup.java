package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

abstract class MenuPopup implements ShowableListMenu, MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    private Rect f914b;

    MenuPopup() {
    }

    protected static int o(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        View view = null;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < count; i5++) {
            int itemViewType = listAdapter.getItemViewType(i5);
            if (itemViewType != i4) {
                view = null;
                i4 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i5, view, viewGroup);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i2) {
                return i2;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    protected static boolean x(MenuBuilder menuBuilder) {
        int size = menuBuilder.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = menuBuilder.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    protected static MenuAdapter y(ListAdapter listAdapter) {
        if (listAdapter instanceof HeaderViewListAdapter) {
            return (MenuAdapter) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        }
        return (MenuAdapter) listAdapter;
    }

    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public abstract void f(MenuBuilder menuBuilder);

    public int getId() {
        return 0;
    }

    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void k(Context context, MenuBuilder menuBuilder) {
    }

    /* access modifiers changed from: protected */
    public boolean l() {
        return true;
    }

    public Rect m() {
        return this.f914b;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        int i3;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        MenuBuilder menuBuilder = y(listAdapter).f840b;
        MenuItem menuItem = (MenuItem) listAdapter.getItem(i2);
        if (l()) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        menuBuilder.O(menuItem, this, i3);
    }

    public abstract void p(View view);

    public void q(Rect rect) {
        this.f914b = rect;
    }

    public abstract void r(boolean z2);

    public abstract void s(int i2);

    public abstract void t(int i2);

    public abstract void u(PopupWindow.OnDismissListener onDismissListener);

    public abstract void v(boolean z2);

    public abstract void w(int i2);
}

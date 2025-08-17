package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {

    /* renamed from: b  reason: collision with root package name */
    MenuBuilder f840b;

    /* renamed from: c  reason: collision with root package name */
    private int f841c = -1;

    /* renamed from: d  reason: collision with root package name */
    private boolean f842d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f843e;

    /* renamed from: f  reason: collision with root package name */
    private final LayoutInflater f844f;

    /* renamed from: g  reason: collision with root package name */
    private final int f845g;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z2, int i2) {
        this.f843e = z2;
        this.f844f = layoutInflater;
        this.f840b = menuBuilder;
        this.f845g = i2;
        a();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        MenuItemImpl x2 = this.f840b.x();
        if (x2 != null) {
            ArrayList<MenuItemImpl> B = this.f840b.B();
            int size = B.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (B.get(i2) == x2) {
                    this.f841c = i2;
                    return;
                }
            }
        }
        this.f841c = -1;
    }

    public MenuBuilder b() {
        return this.f840b;
    }

    /* renamed from: c */
    public MenuItemImpl getItem(int i2) {
        ArrayList<MenuItemImpl> arrayList;
        if (this.f843e) {
            arrayList = this.f840b.B();
        } else {
            arrayList = this.f840b.G();
        }
        int i3 = this.f841c;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return arrayList.get(i2);
    }

    public void d(boolean z2) {
        this.f842d = z2;
    }

    public int getCount() {
        ArrayList<MenuItemImpl> arrayList;
        if (this.f843e) {
            arrayList = this.f840b.B();
        } else {
            arrayList = this.f840b.G();
        }
        if (this.f841c < 0) {
            return arrayList.size();
        }
        return arrayList.size() - 1;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        int i3;
        boolean z2;
        if (view == null) {
            view = this.f844f.inflate(this.f845g, viewGroup, false);
        }
        int groupId = getItem(i2).getGroupId();
        int i4 = i2 - 1;
        if (i4 >= 0) {
            i3 = getItem(i4).getGroupId();
        } else {
            i3 = groupId;
        }
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (!this.f840b.H() || groupId == i3) {
            z2 = false;
        } else {
            z2 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z2);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.f842d) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.c(getItem(i2), 0);
        return view;
    }

    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}

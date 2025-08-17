package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;

public class BottomNavigationPresenter implements MenuPresenter {

    /* renamed from: b  reason: collision with root package name */
    private MenuBuilder f29583b;

    /* renamed from: c  reason: collision with root package name */
    private BottomNavigationMenuView f29584c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29585d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f29586e;

    static class SavedState implements Parcelable {
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
        int f29587b;

        SavedState() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f29587b);
        }

        SavedState(Parcel parcel) {
            this.f29587b = parcel.readInt();
        }
    }

    public void a(MenuBuilder menuBuilder, boolean z2) {
    }

    public boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void d(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f29584c.h(((SavedState) parcelable).f29587b);
        }
    }

    public boolean e(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void f(BottomNavigationMenuView bottomNavigationMenuView) {
        this.f29584c = bottomNavigationMenuView;
    }

    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f29587b = this.f29584c.getSelectedItemId();
        return savedState;
    }

    public int getId() {
        return this.f29586e;
    }

    public void h(boolean z2) {
        if (!this.f29585d) {
            if (z2) {
                this.f29584c.d();
            } else {
                this.f29584c.i();
            }
        }
    }

    public boolean i() {
        return false;
    }

    public boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void k(Context context, MenuBuilder menuBuilder) {
        this.f29583b = menuBuilder;
        this.f29584c.a(menuBuilder);
    }

    public void l(int i2) {
        this.f29586e = i2;
    }

    public void m(boolean z2) {
        this.f29585d = z2;
    }
}

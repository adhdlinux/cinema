package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Parcelable;

public interface MenuPresenter {

    public interface Callback {
        void a(MenuBuilder menuBuilder, boolean z2);

        boolean b(MenuBuilder menuBuilder);
    }

    void a(MenuBuilder menuBuilder, boolean z2);

    boolean b(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void c(Callback callback);

    void d(Parcelable parcelable);

    boolean e(SubMenuBuilder subMenuBuilder);

    Parcelable g();

    int getId();

    void h(boolean z2);

    boolean i();

    boolean j(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl);

    void k(Context context, MenuBuilder menuBuilder);
}

package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import java.lang.reflect.Method;

public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static Method L;
    private MenuItemHoverListener K;

    static class Api23Impl {
        private Api23Impl() {
        }

        static void a(PopupWindow popupWindow, Transition transition) {
            popupWindow.setEnterTransition(transition);
        }

        static void b(PopupWindow popupWindow, Transition transition) {
            popupWindow.setExitTransition(transition);
        }
    }

    static class Api29Impl {
        private Api29Impl() {
        }

        static void a(PopupWindow popupWindow, boolean z2) {
            popupWindow.setTouchModal(z2);
        }
    }

    public static class MenuDropDownListView extends DropDownListView {

        /* renamed from: o  reason: collision with root package name */
        final int f1333o;

        /* renamed from: p  reason: collision with root package name */
        final int f1334p;

        /* renamed from: q  reason: collision with root package name */
        private MenuItemHoverListener f1335q;

        /* renamed from: r  reason: collision with root package name */
        private MenuItem f1336r;

        static class Api17Impl {
            private Api17Impl() {
            }

            static int a(Configuration configuration) {
                return configuration.getLayoutDirection();
            }
        }

        public MenuDropDownListView(Context context, boolean z2) {
            super(context, z2);
            if (1 == Api17Impl.a(context.getResources().getConfiguration())) {
                this.f1333o = 21;
                this.f1334p = 22;
                return;
            }
            this.f1333o = 22;
            this.f1334p = 21;
        }

        public /* bridge */ /* synthetic */ int d(int i2, int i3, int i4, int i5, int i6) {
            return super.d(i2, i3, i4, i5, i6);
        }

        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i2) {
            return super.e(motionEvent, i2);
        }

        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i2;
            MenuAdapter menuAdapter;
            MenuItemImpl menuItemImpl;
            int pointToPosition;
            int i3;
            if (this.f1335q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i2 = headerViewListAdapter.getHeadersCount();
                    menuAdapter = (MenuAdapter) headerViewListAdapter.getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                    i2 = 0;
                }
                if (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i3 = pointToPosition - i2) < 0 || i3 >= menuAdapter.getCount()) {
                    menuItemImpl = null;
                } else {
                    menuItemImpl = menuAdapter.getItem(i3);
                }
                MenuItem menuItem = this.f1336r;
                if (menuItem != menuItemImpl) {
                    MenuBuilder b2 = menuAdapter.b();
                    if (menuItem != null) {
                        this.f1335q.m(b2, menuItem);
                    }
                    this.f1336r = menuItemImpl;
                    if (menuItemImpl != null) {
                        this.f1335q.a(b2, menuItemImpl);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        public boolean onKeyDown(int i2, KeyEvent keyEvent) {
            MenuAdapter menuAdapter;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i2 == this.f1333o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView == null || i2 != this.f1334p) {
                return super.onKeyDown(i2, keyEvent);
            } else {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    menuAdapter = (MenuAdapter) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    menuAdapter = (MenuAdapter) adapter;
                }
                menuAdapter.b().e(false);
                return true;
            }
        }

        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(MenuItemHoverListener menuItemHoverListener) {
            this.f1335q = menuItemHoverListener;
        }

        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                L = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void L(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.a(this.G, (Transition) obj);
        }
    }

    public void M(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            Api23Impl.b(this.G, (Transition) obj);
        }
    }

    public void N(MenuItemHoverListener menuItemHoverListener) {
        this.K = menuItemHoverListener;
    }

    public void O(boolean z2) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = L;
            if (method != null) {
                try {
                    method.invoke(this.G, new Object[]{Boolean.valueOf(z2)});
                } catch (Exception unused) {
                    Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                }
            }
        } else {
            Api29Impl.a(this.G, z2);
        }
    }

    public void a(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.K;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.a(menuBuilder, menuItem);
        }
    }

    public void m(MenuBuilder menuBuilder, MenuItem menuItem) {
        MenuItemHoverListener menuItemHoverListener = this.K;
        if (menuItemHoverListener != null) {
            menuItemHoverListener.m(menuBuilder, menuItem);
        }
    }

    /* access modifiers changed from: package-private */
    public DropDownListView q(Context context, boolean z2) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z2);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}

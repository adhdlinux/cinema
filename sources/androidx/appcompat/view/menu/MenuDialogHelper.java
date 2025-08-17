package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;

class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {

    /* renamed from: b  reason: collision with root package name */
    private MenuBuilder f872b;

    /* renamed from: c  reason: collision with root package name */
    private AlertDialog f873c;

    /* renamed from: d  reason: collision with root package name */
    ListMenuPresenter f874d;

    /* renamed from: e  reason: collision with root package name */
    private MenuPresenter.Callback f875e;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.f872b = menuBuilder;
    }

    public void a(MenuBuilder menuBuilder, boolean z2) {
        if (z2 || menuBuilder == this.f872b) {
            c();
        }
        MenuPresenter.Callback callback = this.f875e;
        if (callback != null) {
            callback.a(menuBuilder, z2);
        }
    }

    public boolean b(MenuBuilder menuBuilder) {
        MenuPresenter.Callback callback = this.f875e;
        if (callback != null) {
            return callback.b(menuBuilder);
        }
        return false;
    }

    public void c() {
        AlertDialog alertDialog = this.f873c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void d(IBinder iBinder) {
        MenuBuilder menuBuilder = this.f872b;
        AlertDialog.Builder builder = new AlertDialog.Builder(menuBuilder.w());
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.getContext(), R$layout.f203l);
        this.f874d = listMenuPresenter;
        listMenuPresenter.c(this);
        this.f872b.b(this.f874d);
        builder.a(this.f874d.f(), this);
        View A = menuBuilder.A();
        if (A != null) {
            builder.c(A);
        } else {
            builder.e(menuBuilder.y()).setTitle(menuBuilder.z());
        }
        builder.k(this);
        AlertDialog create = builder.create();
        this.f873c = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f873c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f873c.show();
    }

    public void onClick(DialogInterface dialogInterface, int i2) {
        this.f872b.N((MenuItemImpl) this.f874d.f().getItem(i2), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f874d.a(this.f872b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i2 == 82 || i2 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f873c.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f873c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f872b.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f872b.performShortcut(i2, keyEvent, 0);
    }
}

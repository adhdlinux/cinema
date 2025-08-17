package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;

public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    private static int getThemeResId(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.B, typedValue, true);
        return typedValue.resourceId;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().e(view, layoutParams);
    }

    public void dismiss() {
        super.dismiss();
        getDelegate().z();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return KeyEventDispatcher.e(this.mKeyDispatcher, getWindow().getDecorView(), this, keyEvent);
    }

    public <T extends View> T findViewById(int i2) {
        return getDelegate().j(i2);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.i(this, this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().s();
    }

    public void invalidateOptionsMenu() {
        getDelegate().u();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        getDelegate().t();
        super.onCreate(bundle);
        getDelegate().y(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        getDelegate().E();
    }

    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void setContentView(int i2) {
        getDelegate().I(i2);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().O(charSequence);
    }

    /* access modifiers changed from: package-private */
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().H(i2);
    }

    public AppCompatDialog(Context context, int i2) {
        super(context, getThemeResId(context, i2));
        this.mKeyDispatcher = new k(this);
        AppCompatDelegate delegate = getDelegate();
        delegate.N(getThemeResId(context, i2));
        delegate.y((Bundle) null);
    }

    public void setContentView(View view) {
        getDelegate().J(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().K(view, layoutParams);
    }

    public void setTitle(int i2) {
        super.setTitle(i2);
        getDelegate().O(getContext().getString(i2));
    }

    protected AppCompatDialog(Context context, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        super(context);
        this.mKeyDispatcher = new k(this);
        setCancelable(z2);
        setOnCancelListener(onCancelListener);
    }
}

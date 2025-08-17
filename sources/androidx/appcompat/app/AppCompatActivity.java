package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.ViewTreeOnBackPressedDispatcherOwner;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.LocaleListCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;

public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public AppCompatActivity() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().h(DELEGATE_TAG, new SavedStateRegistry.SavedStateProvider() {
            public Bundle b() {
                Bundle bundle = new Bundle();
                AppCompatActivity.this.getDelegate().C(bundle);
                return bundle;
            }
        });
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void a(Context context) {
                AppCompatDelegate delegate = AppCompatActivity.this.getDelegate();
                delegate.t();
                delegate.y(AppCompatActivity.this.getSavedStateRegistry().b(AppCompatActivity.DELEGATE_TAG));
            }
        });
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.a(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.a(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.a(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.a(getWindow().getDecorView(), this);
    }

    private boolean performMenuItemShortcut(KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().e(view, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(getDelegate().g(context));
    }

    public void closeOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.f()) {
            super.closeOptionsMenu();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        ActionBar supportActionBar = getSupportActionBar();
        if (keyCode != 82 || supportActionBar == null || !supportActionBar.o(keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public <T extends View> T findViewById(int i2) {
        return getDelegate().j(i2);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.h(this, this);
        }
        return this.mDelegate;
    }

    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return getDelegate().n();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().q();
    }

    public Resources getResources() {
        if (this.mResources == null && VectorEnabledTintResources.c()) {
            this.mResources = new VectorEnabledTintResources(this, super.getResources());
        }
        Resources resources = this.mResources;
        if (resources == null) {
            return super.getResources();
        }
        return resources;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().s();
    }

    public Intent getSupportParentActivityIntent() {
        return NavUtils.a(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().u();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().x(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.c(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        getDelegate().z();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (performMenuItemShortcut(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onLocalesChanged(LocaleListCompat localeListCompat) {
    }

    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.i() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i2, Menu menu) {
        return super.onMenuOpened(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onNightModeChanged(int i2) {
    }

    public void onPanelClosed(int i2, Menu menu) {
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().A(bundle);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        getDelegate().B();
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder taskStackBuilder) {
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        getDelegate().D();
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

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            TaskStackBuilder e2 = TaskStackBuilder.e(this);
            onCreateSupportNavigateUpTaskStack(e2);
            onPrepareSupportNavigateUpTaskStack(e2);
            e2.i();
            try {
                ActivityCompat.b(this);
                return true;
            } catch (IllegalStateException unused) {
                finish();
                return true;
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onTitleChanged(CharSequence charSequence, int i2) {
        super.onTitleChanged(charSequence, i2);
        getDelegate().O(charSequence);
    }

    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    public void openOptionsMenu() {
        ActionBar supportActionBar = getSupportActionBar();
        if (!getWindow().hasFeature(0)) {
            return;
        }
        if (supportActionBar == null || !supportActionBar.p()) {
            super.openOptionsMenu();
        }
    }

    public void setContentView(int i2) {
        initViewTreeOwners();
        getDelegate().I(i2);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().M(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z2) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z2) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z2) {
    }

    public void setTheme(int i2) {
        super.setTheme(i2);
        getDelegate().N(i2);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback callback) {
        return getDelegate().P(callback);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().u();
    }

    public void supportNavigateUpTo(Intent intent) {
        NavUtils.f(this, intent);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().H(i2);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return NavUtils.g(this, intent);
    }

    public AppCompatActivity(int i2) {
        super(i2);
        initDelegate();
    }

    public void setContentView(View view) {
        initViewTreeOwners();
        getDelegate().J(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        getDelegate().K(view, layoutParams);
    }
}

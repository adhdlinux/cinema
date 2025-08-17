package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.core.app.ActivityCompat;
import androidx.core.app.SharedElementCallback;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends ComponentActivity implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompat.RequestPermissionsRequestCodeValidator {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry = new LifecycleRegistry(this);
    final FragmentController mFragments = FragmentController.b(new HostCallbacks());
    boolean mResumed;
    boolean mStopped = true;

    class HostCallbacks extends FragmentHostCallback<FragmentActivity> implements ViewModelStoreOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, FragmentOnAttachListener {
        public HostCallbacks() {
            super(FragmentActivity.this);
        }

        public void a(FragmentManager fragmentManager, Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        public View c(int i2) {
            return FragmentActivity.this.findViewById(i2);
        }

        public boolean d() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null || window.peekDecorView() == null) {
                return false;
            }
            return true;
        }

        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        public Lifecycle getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        public ViewModelStore getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        public void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        public LayoutInflater j() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        public boolean l(Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        public boolean m(String str) {
            return ActivityCompat.j(FragmentActivity.this, str);
        }

        public void p() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        /* renamed from: q */
        public FragmentActivity i() {
            return FragmentActivity.this;
        }
    }

    public FragmentActivity() {
        init();
    }

    private void init() {
        getSavedStateRegistry().h(FRAGMENTS_TAG, new SavedStateRegistry.SavedStateProvider() {
            public Bundle b() {
                Bundle bundle = new Bundle();
                FragmentActivity.this.markFragmentsCreated();
                FragmentActivity.this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_STOP);
                Parcelable x2 = FragmentActivity.this.mFragments.x();
                if (x2 != null) {
                    bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, x2);
                }
                return bundle;
            }
        });
        addOnContextAvailableListener(new OnContextAvailableListener() {
            public void a(Context context) {
                FragmentActivity.this.mFragments.a((Fragment) null);
                Bundle b2 = FragmentActivity.this.getSavedStateRegistry().b(FragmentActivity.FRAGMENTS_TAG);
                if (b2 != null) {
                    FragmentActivity.this.mFragments.w(b2.getParcelable(FragmentActivity.FRAGMENTS_TAG));
                }
            }
        });
    }

    private static boolean markState(FragmentManager fragmentManager, Lifecycle.State state) {
        boolean z2 = false;
        for (Fragment next : fragmentManager.t0()) {
            if (next != null) {
                if (next.getHost() != null) {
                    z2 |= markState(next.getChildFragmentManager(), state);
                }
                FragmentViewLifecycleOwner fragmentViewLifecycleOwner = next.mViewLifecycleOwner;
                if (fragmentViewLifecycleOwner != null && fragmentViewLifecycleOwner.getLifecycle().b().a(Lifecycle.State.STARTED)) {
                    next.mViewLifecycleOwner.f(state);
                    z2 = true;
                }
                if (next.mLifecycleRegistry.b().a(Lifecycle.State.STARTED)) {
                    next.mLifecycleRegistry.o(state);
                    z2 = true;
                }
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.v(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            LoaderManager.c(this).b(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.t().X(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.t();
    }

    @Deprecated
    public LoaderManager getSupportLoaderManager() {
        return LoaderManager.c(this);
    }

    /* access modifiers changed from: package-private */
    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), Lifecycle.State.CREATED));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.u();
        super.onActivityResult(i2, i3, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.u();
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_CREATE);
        this.mFragments.f();
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 == 0) {
            return super.onCreatePanelMenu(i2, menu) | this.mFragments.g(menu, getMenuInflater());
        }
        return super.onCreatePanelMenu(i2, menu);
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.i();
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.mFragments.k(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z2) {
        this.mFragments.j(z2);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.u();
        super.onNewIntent(intent);
    }

    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.mFragments.l(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.m();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z2) {
        this.mFragments.n(z2);
    }

    /* access modifiers changed from: protected */
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.o(menu);
        }
        return super.onPreparePanel(i2, view, menu);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.u();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.mFragments.u();
        super.onResume();
        this.mResumed = true;
        this.mFragments.s();
    }

    /* access modifiers changed from: protected */
    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_RESUME);
        this.mFragments.p();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        this.mFragments.u();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.s();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_START);
        this.mFragments.q();
    }

    public void onStateNotSaved() {
        this.mFragments.u();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.r();
        this.mFragmentLifecycleRegistry.h(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.h(this, sharedElementCallback);
    }

    public void setExitSharedElementCallback(SharedElementCallback sharedElementCallback) {
        ActivityCompat.i(this, sharedElementCallback);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 == -1) {
            ActivityCompat.l(this, intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        ActivityCompat.c(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        ActivityCompat.e(this);
    }

    public void supportStartPostponedEnterTransition() {
        ActivityCompat.m(this);
    }

    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i2) {
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 == -1) {
            ActivityCompat.k(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i2, bundle);
        }
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView((View) null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public FragmentActivity(int i2) {
        super(i2);
        init();
    }
}

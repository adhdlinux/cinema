package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity extends androidx.core.app.ComponentActivity implements ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, OnBackPressedDispatcherOwner, ActivityResultRegistryOwner {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;
    private int mContentLayoutId;
    final ContextAwareHelper mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private boolean mDispatchingOnMultiWindowModeChanged;
    private boolean mDispatchingOnPictureInPictureModeChanged;
    private final LifecycleRegistry mLifecycleRegistry;
    private final MenuHostHelper mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<Consumer<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> mOnTrimMemoryListeners;
    final SavedStateRegistryController mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    static class Api19Impl {
        private Api19Impl() {
        }

        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    static final class NonConfigurationInstances {

        /* renamed from: a  reason: collision with root package name */
        Object f23a;

        /* renamed from: b  reason: collision with root package name */
        ViewModelStore f24b;

        NonConfigurationInstances() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new ContextAwareHelper();
        this.mMenuHostHelper = new MenuHostHelper(new a(this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        SavedStateRegistryController a2 = SavedStateRegistryController.a(this);
        this.mSavedStateRegistryController = a2;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new Runnable() {
            public void run() {
                try {
                    ComponentActivity.super.onBackPressed();
                } catch (IllegalStateException e2) {
                    if (!TextUtils.equals(e2.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                        throw e2;
                    }
                }
            }
        });
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new ActivityResultRegistry() {
            public <I, O> void f(final int i2, ActivityResultContract<I, O> activityResultContract, I i3, ActivityOptionsCompat activityOptionsCompat) {
                Bundle bundle;
                Bundle bundle2;
                ComponentActivity componentActivity = ComponentActivity.this;
                final ActivityResultContract.SynchronousResult<O> b2 = activityResultContract.b(componentActivity, i3);
                if (b2 != null) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public void run() {
                            AnonymousClass2.this.c(i2, b2.a());
                        }
                    });
                    return;
                }
                Intent a2 = activityResultContract.a(componentActivity, i3);
                if (a2.getExtras() != null && a2.getExtras().getClassLoader() == null) {
                    a2.setExtrasClassLoader(componentActivity.getClassLoader());
                }
                if (a2.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                    Bundle bundleExtra = a2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    a2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    bundle = bundleExtra;
                } else {
                    if (activityOptionsCompat != null) {
                        bundle2 = activityOptionsCompat.a();
                    } else {
                        bundle2 = null;
                    }
                    bundle = bundle2;
                }
                if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a2.getAction())) {
                    String[] stringArrayExtra = a2.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    if (stringArrayExtra == null) {
                        stringArrayExtra = new String[0];
                    }
                    ActivityCompat.g(componentActivity, stringArrayExtra, i2);
                } else if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a2.getAction())) {
                    IntentSenderRequest intentSenderRequest = (IntentSenderRequest) a2.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                    try {
                        ActivityCompat.l(componentActivity, intentSenderRequest.e(), i2, intentSenderRequest.b(), intentSenderRequest.c(), intentSenderRequest.d(), 0, bundle);
                    } catch (IntentSender.SendIntentException e2) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            public void run() {
                                AnonymousClass2.this.b(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", e2));
                            }
                        });
                    }
                } else {
                    ActivityCompat.k(componentActivity, a2, i2, bundle);
                }
            }
        };
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mDispatchingOnMultiWindowModeChanged = false;
        this.mDispatchingOnPictureInPictureModeChanged = false;
        if (getLifecycle() != null) {
            int i2 = Build.VERSION.SDK_INT;
            getLifecycle().a(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    View view;
                    if (event == Lifecycle.Event.ON_STOP) {
                        Window window = ComponentActivity.this.getWindow();
                        if (window != null) {
                            view = window.peekDecorView();
                        } else {
                            view = null;
                        }
                        if (view != null) {
                            Api19Impl.a(view);
                        }
                    }
                }
            });
            getLifecycle().a(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        ComponentActivity.this.mContextAwareHelper.b();
                        if (!ComponentActivity.this.isChangingConfigurations()) {
                            ComponentActivity.this.getViewModelStore().a();
                        }
                    }
                }
            });
            getLifecycle().a(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ComponentActivity.this.ensureViewModelStore();
                    ComponentActivity.this.getLifecycle().c(this);
                }
            });
            a2.c();
            SavedStateHandleSupport.c(this);
            if (i2 <= 23) {
                getLifecycle().a(new ImmLeaksCleaner(this));
            }
            getSavedStateRegistry().h(ACTIVITY_RESULT_TAG, new b(this));
            addOnContextAvailableListener(new c(this));
            return;
        }
        throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.a(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.a(getWindow().getDecorView(), this);
        ViewTreeSavedStateRegistryOwner.a(getWindow().getDecorView(), this);
        ViewTreeOnBackPressedDispatcherOwner.a(getWindow().getDecorView(), this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bundle lambda$new$0() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1(Context context) {
        Bundle b2 = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (b2 != null) {
            this.mActivityResultRegistry.g(b2);
        }
    }

    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    public void addMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.c(menuProvider);
    }

    public final void addOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.add(consumer);
    }

    public final void addOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.a(onContextAvailableListener);
    }

    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.add(consumer);
    }

    public final void addOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.add(consumer);
    }

    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.add(consumer);
    }

    public final void addOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.add(consumer);
    }

    /* access modifiers changed from: package-private */
    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
            if (nonConfigurationInstances != null) {
                this.mViewModelStore = nonConfigurationInstances.f24b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (getApplication() != null) {
            mutableCreationExtras.c(ViewModelProvider.AndroidViewModelFactory.f3763g, getApplication());
        }
        mutableCreationExtras.c(SavedStateHandleSupport.f3731a, this);
        mutableCreationExtras.c(SavedStateHandleSupport.f3732b, this);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            mutableCreationExtras.c(SavedStateHandleSupport.f3733c, getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Bundle bundle;
        if (this.mDefaultFactory == null) {
            Application application = getApplication();
            if (getIntent() != null) {
                bundle = getIntent().getExtras();
            } else {
                bundle = null;
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, bundle);
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance();
        if (nonConfigurationInstances != null) {
            return nonConfigurationInstances.f23a;
        }
        return null;
    }

    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    public ViewModelStore getViewModelStore() {
        if (getApplication() != null) {
            ensureViewModelStore();
            return this.mViewModelStore;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!this.mActivityResultRegistry.b(i2, i3, intent)) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public void onBackPressed() {
        this.mOnBackPressedDispatcher.f();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<Consumer<Configuration>> it2 = this.mOnConfigurationChangedListeners.iterator();
        while (it2.hasNext()) {
            it2.next().accept(configuration);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        ReportFragment.g(this);
        if (BuildCompat.d()) {
            this.mOnBackPressedDispatcher.g(Api33Impl.a(this));
        }
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    public void onMultiWindowModeChanged(boolean z2) {
        if (!this.mDispatchingOnMultiWindowModeChanged) {
            Iterator<Consumer<MultiWindowModeChangedInfo>> it2 = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new MultiWindowModeChangedInfo(z2));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<Consumer<Intent>> it2 = this.mOnNewIntentListeners.iterator();
        while (it2.hasNext()) {
            it2.next().accept(intent);
        }
    }

    public void onPanelClosed(int i2, Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i2, menu);
    }

    public void onPictureInPictureModeChanged(boolean z2) {
        if (!this.mDispatchingOnPictureInPictureModeChanged) {
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it2 = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new PictureInPictureModeChangedInfo(z2));
            }
        }
    }

    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0) {
            return true;
        }
        super.onPreparePanel(i2, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (!this.mActivityResultRegistry.b(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) && Build.VERSION.SDK_INT >= 23) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        NonConfigurationInstances nonConfigurationInstances;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (nonConfigurationInstances = (NonConfigurationInstances) getLastNonConfigurationInstance()) != null) {
            viewModelStore = nonConfigurationInstances.f24b;
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        NonConfigurationInstances nonConfigurationInstances2 = new NonConfigurationInstances();
        nonConfigurationInstances2.f23a = onRetainCustomNonConfigurationInstance;
        nonConfigurationInstances2.f24b = viewModelStore;
        return nonConfigurationInstances2;
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).o(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator<Consumer<Integer>> it2 = this.mOnTrimMemoryListeners.iterator();
        while (it2.hasNext()) {
            it2.next().accept(Integer.valueOf(i2));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultRegistry activityResultRegistry, ActivityResultCallback<O> activityResultCallback) {
        return activityResultRegistry.j("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, activityResultContract, activityResultCallback);
    }

    public void removeMenuProvider(MenuProvider menuProvider) {
        this.mMenuHostHelper.l(menuProvider);
    }

    public final void removeOnConfigurationChangedListener(Consumer<Configuration> consumer) {
        this.mOnConfigurationChangedListeners.remove(consumer);
    }

    public final void removeOnContextAvailableListener(OnContextAvailableListener onContextAvailableListener) {
        this.mContextAwareHelper.e(onContextAvailableListener);
    }

    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> consumer) {
        this.mOnMultiWindowModeChangedListeners.remove(consumer);
    }

    public final void removeOnNewIntentListener(Consumer<Intent> consumer) {
        this.mOnNewIntentListeners.remove(consumer);
    }

    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> consumer) {
        this.mOnPictureInPictureModeChangedListeners.remove(consumer);
    }

    public final void removeOnTrimMemoryListener(Consumer<Integer> consumer) {
        this.mOnTrimMemoryListeners.remove(consumer);
    }

    public void reportFullyDrawn() {
        try {
            if (Trace.d()) {
                Trace.a("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
        } finally {
            Trace.b();
        }
    }

    public void setContentView(int i2) {
        initViewTreeOwners();
        super.setContentView(i2);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.d(menuProvider, lifecycleOwner);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(MenuProvider menuProvider, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.e(menuProvider, lifecycleOwner, state);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        initViewTreeOwners();
        super.setContentView(view);
    }

    /* JADX INFO: finally extract failed */
    public void onMultiWindowModeChanged(boolean z2, Configuration configuration) {
        this.mDispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z2, configuration);
            this.mDispatchingOnMultiWindowModeChanged = false;
            Iterator<Consumer<MultiWindowModeChangedInfo>> it2 = this.mOnMultiWindowModeChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new MultiWindowModeChangedInfo(z2, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        this.mDispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z2, configuration);
            this.mDispatchingOnPictureInPictureModeChanged = false;
            Iterator<Consumer<PictureInPictureModeChangedInfo>> it2 = this.mOnPictureInPictureModeChangedListeners.iterator();
            while (it2.hasNext()) {
                it2.next().accept(new PictureInPictureModeChangedInfo(z2, configuration));
            }
        } catch (Throwable th) {
            this.mDispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return registerForActivityResult(activityResultContract, this.mActivityResultRegistry, activityResultCallback);
    }

    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }

    public ComponentActivity(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}

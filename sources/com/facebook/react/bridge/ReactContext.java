package com.facebook.react.bridge;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.ReactConstants;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class ReactContext extends ContextWrapper {
    private static final String EARLY_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module before the React instance was fully set up. Calls to ReactContext#getJSModule should only happen once initialize() has been called on your native module.";
    private static final String EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE = "Trying to call native module before CatalystInstance has been set!";
    private static final String LATE_JS_ACCESS_EXCEPTION_MESSAGE = "Tried to access a JS module after the React instance was destroyed.";
    private static final String LATE_NATIVE_MODULE_EXCEPTION_MESSAGE = "Trying to call native module after CatalystInstance has been destroyed!";
    private static final String TAG = "ReactContext";
    private final CopyOnWriteArraySet<ActivityEventListener> mActivityEventListeners = new CopyOnWriteArraySet<>();
    private CatalystInstance mCatalystInstance;
    private WeakReference<Activity> mCurrentActivity;
    private volatile boolean mDestroyed = false;
    private NativeModuleCallExceptionHandler mExceptionHandlerWrapper;
    private LayoutInflater mInflater;
    private boolean mIsInitialized = false;
    private MessageQueueThread mJSMessageQueueThread;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<LifecycleEventListener> mLifecycleEventListeners = new CopyOnWriteArraySet<>();
    private LifecycleState mLifecycleState = LifecycleState.BEFORE_CREATE;
    private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
    private MessageQueueThread mNativeModulesMessageQueueThread;
    private MessageQueueThread mUiMessageQueueThread;
    private final CopyOnWriteArraySet<WindowFocusChangeListener> mWindowFocusEventListeners = new CopyOnWriteArraySet<>();

    /* renamed from: com.facebook.react.bridge.ReactContext$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$common$LifecycleState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.react.common.LifecycleState[] r0 = com.facebook.react.common.LifecycleState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$common$LifecycleState = r0
                com.facebook.react.common.LifecycleState r1 = com.facebook.react.common.LifecycleState.BEFORE_CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$common$LifecycleState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.common.LifecycleState r1 = com.facebook.react.common.LifecycleState.BEFORE_RESUME     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$common$LifecycleState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.common.LifecycleState r1 = com.facebook.react.common.LifecycleState.RESUMED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.bridge.ReactContext.AnonymousClass2.<clinit>():void");
        }
    }

    public class ExceptionHandlerWrapper implements NativeModuleCallExceptionHandler {
        public ExceptionHandlerWrapper() {
        }

        public void handleException(Exception exc) {
            ReactContext.this.handleException(exc);
        }
    }

    public ReactContext(Context context) {
        super(context);
    }

    private void raiseCatalystInstanceMissingException() {
        String str;
        if (this.mDestroyed) {
            str = LATE_NATIVE_MODULE_EXCEPTION_MESSAGE;
        } else {
            str = EARLY_NATIVE_MODULE_EXCEPTION_MESSAGE;
        }
        throw new IllegalStateException(str);
    }

    public void addActivityEventListener(ActivityEventListener activityEventListener) {
        this.mActivityEventListeners.add(activityEventListener);
    }

    public void addLifecycleEventListener(final LifecycleEventListener lifecycleEventListener) {
        int i2;
        this.mLifecycleEventListeners.add(lifecycleEventListener);
        if ((hasActiveReactInstance() || isBridgeless()) && (i2 = AnonymousClass2.$SwitchMap$com$facebook$react$common$LifecycleState[this.mLifecycleState.ordinal()]) != 1 && i2 != 2) {
            if (i2 == 3) {
                runOnUiQueueThread(new Runnable() {
                    public void run() {
                        if (ReactContext.this.mLifecycleEventListeners.contains(lifecycleEventListener)) {
                            try {
                                lifecycleEventListener.onHostResume();
                            } catch (RuntimeException e2) {
                                ReactContext.this.handleException(e2);
                            }
                        }
                    }
                });
                return;
            }
            throw new IllegalStateException("Unhandled lifecycle state.");
        }
    }

    public void addWindowFocusChangeListener(WindowFocusChangeListener windowFocusChangeListener) {
        this.mWindowFocusEventListeners.add(windowFocusChangeListener);
    }

    public void assertOnJSQueueThread() {
        ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).assertIsOnThread();
    }

    public void assertOnNativeModulesQueueThread() {
        if (this.mIsInitialized) {
            ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread();
            return;
        }
        throw new IllegalStateException("Tried to call assertOnNativeModulesQueueThread() on an uninitialized ReactContext");
    }

    public void assertOnUiQueueThread() {
        ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).assertIsOnThread();
    }

    @ThreadConfined("UI")
    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        this.mDestroyed = true;
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            catalystInstance.destroy();
        }
    }

    public CatalystInstance getCatalystInstance() {
        return (CatalystInstance) Assertions.assertNotNull(this.mCatalystInstance);
    }

    public Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = this.mCurrentActivity;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public NativeModuleCallExceptionHandler getExceptionHandler() {
        if (this.mExceptionHandlerWrapper == null) {
            this.mExceptionHandlerWrapper = new ExceptionHandlerWrapper();
        }
        return this.mExceptionHandlerWrapper;
    }

    public JSIModule getJSIModule(JSIModuleType jSIModuleType) {
        if (hasActiveReactInstance()) {
            return this.mCatalystInstance.getJSIModule(jSIModuleType);
        }
        throw new IllegalStateException("Unable to retrieve a JSIModule if CatalystInstance is not active.");
    }

    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        if (catalystInstance != null) {
            return catalystInstance.getJSModule(cls);
        }
        if (this.mDestroyed) {
            throw new IllegalStateException(LATE_JS_ACCESS_EXCEPTION_MESSAGE);
        }
        throw new IllegalStateException(EARLY_JS_ACCESS_EXCEPTION_MESSAGE);
    }

    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mCatalystInstance.getJavaScriptContextHolder();
    }

    public LifecycleState getLifecycleState() {
        return this.mLifecycleState;
    }

    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.getNativeModule(cls);
    }

    public Collection<NativeModule> getNativeModules() {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.getNativeModules();
    }

    public String getSourceURL() {
        return this.mCatalystInstance.getSourceURL();
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.mInflater;
    }

    public void handleException(Exception exc) {
        boolean z2;
        boolean z3;
        CatalystInstance catalystInstance = this.mCatalystInstance;
        boolean z4 = false;
        if (catalystInstance != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || catalystInstance.isDestroyed()) {
            z3 = false;
        } else {
            z3 = true;
        }
        NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler = this.mNativeModuleCallExceptionHandler;
        if (nativeModuleCallExceptionHandler != null) {
            z4 = true;
        }
        if (!z3 || !z4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to handle Exception - catalystInstanceVariableExists: ");
            sb.append(z2);
            sb.append(" - isCatalystInstanceAlive: ");
            sb.append(!z3);
            sb.append(" - hasExceptionHandler: ");
            sb.append(z4);
            FLog.e(ReactConstants.TAG, sb.toString(), (Throwable) exc);
            throw new IllegalStateException(exc);
        }
        nativeModuleCallExceptionHandler.handleException(exc);
    }

    @Deprecated
    public boolean hasActiveCatalystInstance() {
        return hasActiveReactInstance();
    }

    public boolean hasActiveReactInstance() {
        CatalystInstance catalystInstance = this.mCatalystInstance;
        return catalystInstance != null && !catalystInstance.isDestroyed();
    }

    public boolean hasCatalystInstance() {
        return this.mCatalystInstance != null;
    }

    public boolean hasCurrentActivity() {
        WeakReference<Activity> weakReference = this.mCurrentActivity;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        if (this.mCatalystInstance == null) {
            raiseCatalystInstanceMissingException();
        }
        return this.mCatalystInstance.hasNativeModule(cls);
    }

    public synchronized void initializeMessageQueueThreads(ReactQueueConfiguration reactQueueConfiguration) {
        FLog.w(TAG, "initializeMessageQueueThreads() is called.");
        if (this.mUiMessageQueueThread == null && this.mNativeModulesMessageQueueThread == null && this.mJSMessageQueueThread == null) {
            this.mUiMessageQueueThread = reactQueueConfiguration.getUIQueueThread();
            this.mNativeModulesMessageQueueThread = reactQueueConfiguration.getNativeModulesQueueThread();
            MessageQueueThread jSQueueThread = reactQueueConfiguration.getJSQueueThread();
            this.mJSMessageQueueThread = jSQueueThread;
            if (this.mUiMessageQueueThread == null) {
                throw new IllegalStateException("UI thread is null");
            } else if (this.mNativeModulesMessageQueueThread == null) {
                throw new IllegalStateException("NativeModules thread is null");
            } else if (jSQueueThread != null) {
                this.mIsInitialized = true;
            } else {
                throw new IllegalStateException("JavaScript thread is null");
            }
        } else {
            throw new IllegalStateException("Message queue threads already initialized");
        }
    }

    public void initializeWithInstance(CatalystInstance catalystInstance) {
        if (catalystInstance == null) {
            throw new IllegalArgumentException("CatalystInstance cannot be null.");
        } else if (this.mCatalystInstance == null) {
            if (this.mDestroyed) {
                ReactSoftExceptionLogger.logSoftException(TAG, new IllegalStateException("Cannot initialize ReactContext after it has been destroyed."));
            }
            this.mCatalystInstance = catalystInstance;
            initializeMessageQueueThreads(catalystInstance.getReactQueueConfiguration());
        } else {
            throw new IllegalStateException("ReactContext has been already initialized");
        }
    }

    public boolean isBridgeless() {
        return false;
    }

    public boolean isOnJSQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).isOnThread();
    }

    public boolean isOnNativeModulesQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).isOnThread();
    }

    public boolean isOnUiQueueThread() {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).isOnThread();
    }

    public void onActivityResult(Activity activity, int i2, int i3, Intent intent) {
        Iterator<ActivityEventListener> it2 = this.mActivityEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onActivityResult(activity, i2, i3, intent);
            } catch (RuntimeException e2) {
                handleException(e2);
            }
        }
    }

    @ThreadConfined("UI")
    public void onHostDestroy() {
        UiThreadUtil.assertOnUiThread();
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
        Iterator<LifecycleEventListener> it2 = this.mLifecycleEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onHostDestroy();
            } catch (RuntimeException e2) {
                handleException(e2);
            }
        }
        this.mCurrentActivity = null;
    }

    @ThreadConfined("UI")
    public void onHostPause() {
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_START);
        Iterator<LifecycleEventListener> it2 = this.mLifecycleEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onHostPause();
            } catch (RuntimeException e2) {
                handleException(e2);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_PAUSE_END);
    }

    @ThreadConfined("UI")
    public void onHostResume(Activity activity) {
        this.mLifecycleState = LifecycleState.RESUMED;
        this.mCurrentActivity = new WeakReference<>(activity);
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_START);
        Iterator<LifecycleEventListener> it2 = this.mLifecycleEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onHostResume();
            } catch (RuntimeException e2) {
                handleException(e2);
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.ON_HOST_RESUME_END);
    }

    @ThreadConfined("UI")
    public void onNewIntent(Activity activity, Intent intent) {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = new WeakReference<>(activity);
        Iterator<ActivityEventListener> it2 = this.mActivityEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onNewIntent(intent);
            } catch (RuntimeException e2) {
                handleException(e2);
            }
        }
    }

    @ThreadConfined("UI")
    public void onWindowFocusChange(boolean z2) {
        UiThreadUtil.assertOnUiThread();
        Iterator<WindowFocusChangeListener> it2 = this.mWindowFocusEventListeners.iterator();
        while (it2.hasNext()) {
            try {
                it2.next().onWindowFocusChange(z2);
            } catch (RuntimeException e2) {
                handleException(e2);
            }
        }
    }

    public void registerSegment(int i2, String str, Callback callback) {
        ((CatalystInstance) Assertions.assertNotNull(this.mCatalystInstance)).registerSegment(i2, str);
        ((Callback) Assertions.assertNotNull(callback)).invoke(new Object[0]);
    }

    public void removeActivityEventListener(ActivityEventListener activityEventListener) {
        this.mActivityEventListeners.remove(activityEventListener);
    }

    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mLifecycleEventListeners.remove(lifecycleEventListener);
    }

    public void removeWindowFocusChangeListener(WindowFocusChangeListener windowFocusChangeListener) {
        this.mWindowFocusEventListeners.remove(windowFocusChangeListener);
    }

    public void resetPerfStats() {
        MessageQueueThread messageQueueThread = this.mNativeModulesMessageQueueThread;
        if (messageQueueThread != null) {
            messageQueueThread.resetPerfStats();
        }
        MessageQueueThread messageQueueThread2 = this.mJSMessageQueueThread;
        if (messageQueueThread2 != null) {
            messageQueueThread2.resetPerfStats();
        }
    }

    public boolean runOnJSQueueThread(Runnable runnable) {
        return ((MessageQueueThread) Assertions.assertNotNull(this.mJSMessageQueueThread)).runOnQueue(runnable);
    }

    public void runOnNativeModulesQueueThread(Runnable runnable) {
        ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).runOnQueue(runnable);
    }

    public void runOnUiQueueThread(Runnable runnable) {
        ((MessageQueueThread) Assertions.assertNotNull(this.mUiMessageQueueThread)).runOnQueue(runnable);
    }

    public void setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler) {
        this.mNativeModuleCallExceptionHandler = nativeModuleCallExceptionHandler;
    }

    public boolean startActivityForResult(Intent intent, int i2, Bundle bundle) {
        Activity currentActivity = getCurrentActivity();
        Assertions.assertNotNull(currentActivity);
        currentActivity.startActivityForResult(intent, i2, bundle);
        return true;
    }

    public void assertOnNativeModulesQueueThread(String str) {
        if (this.mIsInitialized) {
            ((MessageQueueThread) Assertions.assertNotNull(this.mNativeModulesMessageQueueThread)).assertIsOnThread(str);
            return;
        }
        throw new IllegalStateException("Tried to call assertOnNativeModulesQueueThread(message) on an uninitialized ReactContext");
    }
}

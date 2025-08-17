package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.fresco.middleware.MiddlewareUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ForwardingControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.ReturnsOwnership;
import java.util.Map;
import java.util.concurrent.Executor;

public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener {
    private static final Map<String, Object> COMPONENT_EXTRAS = ImmutableMap.of("component_tag", "drawee");
    private static final Map<String, Object> SHORTCUT_EXTRAS = ImmutableMap.of("origin", "memory_bitmap", ProducerContext.ExtraKeys.ORIGIN_SUBCATEGORY, "shortcut");
    private static final Class<?> TAG = AbstractDraweeController.class;
    private Object mCallerContext;
    private String mContentDescription;
    protected ControllerListener<INFO> mControllerListener;
    protected ForwardingControllerListener2<INFO> mControllerListener2 = new ForwardingControllerListener2<>();
    private Drawable mControllerOverlay;
    private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
    private DataSource<T> mDataSource;
    private final DeferredReleaser mDeferredReleaser;
    protected Drawable mDrawable;
    private final DraweeEventTracker mEventTracker = DraweeEventTracker.newInstance();
    private T mFetchedImage;
    private GestureDetector mGestureDetector;
    private boolean mHasFetchFailed;
    /* access modifiers changed from: private */
    public String mId;
    private boolean mIsAttached;
    private boolean mIsRequestSubmitted;
    private boolean mIsVisibleInViewportHint;
    private boolean mJustConstructed = true;
    protected LoggingListener mLoggingListener;
    private boolean mRetainImageOnFailure;
    private RetryManager mRetryManager;
    private SettableDraweeHierarchy mSettableDraweeHierarchy;
    private final Executor mUiThreadImmediateExecutor;

    private static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
        private InternalForwardingListener() {
        }

        public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#createInternal");
            }
            InternalForwardingListener<INFO> internalForwardingListener = new InternalForwardingListener<>();
            internalForwardingListener.addListener(controllerListener);
            internalForwardingListener.addListener(controllerListener2);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return internalForwardingListener;
        }
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.mDeferredReleaser = deferredReleaser;
        this.mUiThreadImmediateExecutor = executor;
        init(str, obj);
    }

    private Rect getDimensions() {
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy == null) {
            return null;
        }
        return settableDraweeHierarchy.getBounds();
    }

    private synchronized void init(String str, Object obj) {
        DeferredReleaser deferredReleaser;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#init");
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mJustConstructed && (deferredReleaser = this.mDeferredReleaser) != null) {
            deferredReleaser.cancelDeferredRelease(this);
        }
        this.mIsAttached = false;
        this.mIsVisibleInViewportHint = false;
        releaseFetch();
        this.mRetainImageOnFailure = false;
        RetryManager retryManager = this.mRetryManager;
        if (retryManager != null) {
            retryManager.init();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.init();
            this.mGestureDetector.setClickListener(this);
        }
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        if (controllerListener instanceof InternalForwardingListener) {
            ((InternalForwardingListener) controllerListener).clearListeners();
        } else {
            this.mControllerListener = null;
        }
        this.mControllerViewportVisibilityListener = null;
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
            this.mSettableDraweeHierarchy.setControllerOverlay((Drawable) null);
            this.mSettableDraweeHierarchy = null;
        }
        this.mControllerOverlay = null;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s -> %s: initialize", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId, (Object) str);
        }
        this.mId = str;
        this.mCallerContext = obj;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        if (this.mLoggingListener != null) {
            setUpLoggingListener();
        }
    }

    private boolean isExpectedDataSource(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.mDataSource == null) {
            return true;
        }
        if (!str.equals(this.mId) || dataSource != this.mDataSource || !this.mIsRequestSubmitted) {
            return false;
        }
        return true;
    }

    private void logMessageAndFailure(String str, Throwable th) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: %s: failure: %s", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId, (Object) str, (Object) th);
        }
    }

    private void logMessageAndImage(String str, T t2) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, getImageClass(t2), Integer.valueOf(getImageHash(t2)));
        }
    }

    private ControllerListener2.Extras obtainExtras(Map<String, Object> map, Map<String, Object> map2, Uri uri) {
        PointF pointF;
        String str;
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
            str = String.valueOf(((GenericDraweeHierarchy) settableDraweeHierarchy).getActualImageScaleType());
            pointF = ((GenericDraweeHierarchy) this.mSettableDraweeHierarchy).getActualImageFocusPoint();
        } else {
            str = null;
            pointF = null;
        }
        return MiddlewareUtils.obtainExtras(COMPONENT_EXTRAS, SHORTCUT_EXTRAS, map, getDimensions(), str, pointF, map2, getCallerContext(), uri);
    }

    /* access modifiers changed from: private */
    public void onFailureInternal(String str, DataSource<T> dataSource, Throwable th, boolean z2) {
        DraweeEventTracker.Event event;
        Drawable drawable;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onFailureInternal");
        }
        if (!isExpectedDataSource(str, dataSource)) {
            logMessageAndFailure("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        DraweeEventTracker draweeEventTracker = this.mEventTracker;
        if (z2) {
            event = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE;
        } else {
            event = DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT;
        }
        draweeEventTracker.recordEvent(event);
        if (z2) {
            logMessageAndFailure("final_failed @ onFailure", th);
            this.mDataSource = null;
            this.mHasFetchFailed = true;
            if (this.mRetainImageOnFailure && (drawable = this.mDrawable) != null) {
                this.mSettableDraweeHierarchy.setImage(drawable, 1.0f, true);
            } else if (shouldRetryOnTap()) {
                this.mSettableDraweeHierarchy.setRetry(th);
            } else {
                this.mSettableDraweeHierarchy.setFailure(th);
            }
            reportFailure(th, dataSource);
        } else {
            logMessageAndFailure("intermediate_failed @ onFailure", th);
            reportIntermediateFailure(th);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    /* access modifiers changed from: private */
    public void onNewResultInternal(String str, DataSource<T> dataSource, T t2, float f2, boolean z2, boolean z3, boolean z4) {
        DraweeEventTracker.Event event;
        Drawable createDrawable;
        T t3;
        Drawable drawable;
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#onNewResultInternal");
            }
            if (!isExpectedDataSource(str, dataSource)) {
                logMessageAndImage("ignore_old_datasource @ onNewResult", t2);
                releaseImage(t2);
                dataSource.close();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            DraweeEventTracker draweeEventTracker = this.mEventTracker;
            if (z2) {
                event = DraweeEventTracker.Event.ON_DATASOURCE_RESULT;
            } else {
                event = DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT;
            }
            draweeEventTracker.recordEvent(event);
            try {
                createDrawable = createDrawable(t2);
                t3 = this.mFetchedImage;
                drawable = this.mDrawable;
                this.mFetchedImage = t2;
                this.mDrawable = createDrawable;
                if (z2) {
                    logMessageAndImage("set_final_result @ onNewResult", t2);
                    this.mDataSource = null;
                    this.mSettableDraweeHierarchy.setImage(createDrawable, 1.0f, z3);
                    reportSuccess(str, t2, dataSource);
                } else if (z4) {
                    logMessageAndImage("set_temporary_result @ onNewResult", t2);
                    this.mSettableDraweeHierarchy.setImage(createDrawable, 1.0f, z3);
                    reportSuccess(str, t2, dataSource);
                } else {
                    logMessageAndImage("set_intermediate_result @ onNewResult", t2);
                    this.mSettableDraweeHierarchy.setImage(createDrawable, f2, z3);
                    reportIntermediateSet(str, t2);
                }
                if (!(drawable == null || drawable == createDrawable)) {
                    releaseDrawable(drawable);
                }
                if (!(t3 == null || t3 == t2)) {
                    logMessageAndImage("release_previous_result @ onNewResult", t3);
                    releaseImage(t3);
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            } catch (Exception e2) {
                logMessageAndImage("drawable_failed @ onNewResult", t2);
                releaseImage(t2);
                onFailureInternal(str, dataSource, e2, z2);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } catch (Throwable th) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void onProgressUpdateInternal(String str, DataSource<T> dataSource, float f2, boolean z2) {
        if (!isExpectedDataSource(str, dataSource)) {
            logMessageAndFailure("ignore_old_datasource @ onProgress", (Throwable) null);
            dataSource.close();
        } else if (!z2) {
            this.mSettableDraweeHierarchy.setProgress(f2, false);
        }
    }

    private void releaseFetch() {
        Map<String, Object> map;
        boolean z2 = this.mIsRequestSubmitted;
        this.mIsRequestSubmitted = false;
        this.mHasFetchFailed = false;
        DataSource<T> dataSource = this.mDataSource;
        Map<String, Object> map2 = null;
        if (dataSource != null) {
            map = dataSource.getExtras();
            this.mDataSource.close();
            this.mDataSource = null;
        } else {
            map = null;
        }
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            releaseDrawable(drawable);
        }
        if (this.mContentDescription != null) {
            this.mContentDescription = null;
        }
        this.mDrawable = null;
        T t2 = this.mFetchedImage;
        if (t2 != null) {
            Map<String, Object> obtainExtrasFromImage = obtainExtrasFromImage(getImageInfo(t2));
            logMessageAndImage("release", this.mFetchedImage);
            releaseImage(this.mFetchedImage);
            this.mFetchedImage = null;
            map2 = obtainExtrasFromImage;
        }
        if (z2) {
            reportRelease(map, map2);
        }
    }

    private void reportFailure(Throwable th, DataSource<T> dataSource) {
        ControllerListener2.Extras obtainExtras = obtainExtras(dataSource, (Object) null, (Uri) null);
        getControllerListener().onFailure(this.mId, th);
        getControllerListener2().onFailure(this.mId, th, obtainExtras);
    }

    private void reportIntermediateFailure(Throwable th) {
        getControllerListener().onIntermediateImageFailed(this.mId, th);
        getControllerListener2().onIntermediateImageFailed(this.mId);
    }

    private void reportIntermediateSet(String str, T t2) {
        Object imageInfo = getImageInfo(t2);
        getControllerListener().onIntermediateImageSet(str, imageInfo);
        getControllerListener2().onIntermediateImageSet(str, imageInfo);
    }

    private void reportRelease(Map<String, Object> map, Map<String, Object> map2) {
        getControllerListener().onRelease(this.mId);
        getControllerListener2().onRelease(this.mId, obtainExtras(map, map2, (Uri) null));
    }

    private void reportSuccess(String str, T t2, DataSource<T> dataSource) {
        Object imageInfo = getImageInfo(t2);
        getControllerListener().onFinalImageSet(str, imageInfo, getAnimatable());
        getControllerListener2().onFinalImageSet(str, imageInfo, obtainExtras(dataSource, imageInfo, (Uri) null));
    }

    private void setUpLoggingListener() {
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
            ((GenericDraweeHierarchy) settableDraweeHierarchy).setOnFadeListener(new FadeDrawable.OnFadeListener() {
                public void onFadeFinished() {
                    AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
                    LoggingListener loggingListener = abstractDraweeController.mLoggingListener;
                    if (loggingListener != null) {
                        loggingListener.onFadeFinished(abstractDraweeController.mId);
                    }
                }

                public void onFadeStarted() {
                    AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
                    LoggingListener loggingListener = abstractDraweeController.mLoggingListener;
                    if (loggingListener != null) {
                        loggingListener.onFadeStarted(abstractDraweeController.mId);
                    }
                }

                public void onShownImmediately() {
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mRetryManager;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean shouldRetryOnTap() {
        /*
            r1 = this;
            boolean r0 = r1.mHasFetchFailed
            if (r0 == 0) goto L_0x0010
            com.facebook.drawee.components.RetryManager r0 = r1.mRetryManager
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.shouldRetryOnTap()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.drawee.controller.AbstractDraweeController.shouldRetryOnTap():boolean");
    }

    public void addControllerListener(ControllerListener<? super INFO> controllerListener) {
        Preconditions.checkNotNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 instanceof InternalForwardingListener) {
            ((InternalForwardingListener) controllerListener2).addListener(controllerListener);
        } else if (controllerListener2 != null) {
            this.mControllerListener = InternalForwardingListener.createInternal(controllerListener2, controllerListener);
        } else {
            this.mControllerListener = controllerListener;
        }
    }

    public void addControllerListener2(ControllerListener2<INFO> controllerListener2) {
        this.mControllerListener2.addListener(controllerListener2);
    }

    /* access modifiers changed from: protected */
    public abstract Drawable createDrawable(T t2);

    public Animatable getAnimatable() {
        Drawable drawable = this.mDrawable;
        if (drawable instanceof Animatable) {
            return (Animatable) drawable;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public T getCachedImage() {
        return null;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public String getContentDescription() {
        return this.mContentDescription;
    }

    /* access modifiers changed from: protected */
    public ControllerListener<INFO> getControllerListener() {
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        if (controllerListener == null) {
            return BaseControllerListener.getNoOpListener();
        }
        return controllerListener;
    }

    /* access modifiers changed from: protected */
    public ControllerListener2<INFO> getControllerListener2() {
        return this.mControllerListener2;
    }

    /* access modifiers changed from: protected */
    public Drawable getControllerOverlay() {
        return this.mControllerOverlay;
    }

    /* access modifiers changed from: protected */
    public abstract DataSource<T> getDataSource();

    /* access modifiers changed from: protected */
    public GestureDetector getGestureDetector() {
        return this.mGestureDetector;
    }

    public DraweeHierarchy getHierarchy() {
        return this.mSettableDraweeHierarchy;
    }

    public String getId() {
        return this.mId;
    }

    /* access modifiers changed from: protected */
    public String getImageClass(T t2) {
        return t2 != null ? t2.getClass().getSimpleName() : "<null>";
    }

    /* access modifiers changed from: protected */
    public int getImageHash(T t2) {
        return System.identityHashCode(t2);
    }

    /* access modifiers changed from: protected */
    public abstract INFO getImageInfo(T t2);

    /* access modifiers changed from: protected */
    public LoggingListener getLoggingListener() {
        return this.mLoggingListener;
    }

    /* access modifiers changed from: protected */
    public Uri getMainUri() {
        return null;
    }

    /* access modifiers changed from: protected */
    @ReturnsOwnership
    public RetryManager getRetryManager() {
        if (this.mRetryManager == null) {
            this.mRetryManager = new RetryManager();
        }
        return this.mRetryManager;
    }

    /* access modifiers changed from: protected */
    public void initialize(String str, Object obj) {
        init(str, obj);
        this.mJustConstructed = false;
    }

    public abstract Map<String, Object> obtainExtrasFromImage(INFO info);

    public void onAttach() {
        String str;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onAttach");
        }
        if (FLog.isLoggable(2)) {
            Class<?> cls = TAG;
            Integer valueOf = Integer.valueOf(System.identityHashCode(this));
            String str2 = this.mId;
            if (this.mIsRequestSubmitted) {
                str = "request already submitted";
            } else {
                str = "request needs submit";
            }
            FLog.v(cls, "controller %x %s: onAttach: %s", (Object) valueOf, (Object) str2, (Object) str);
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
        this.mDeferredReleaser.cancelDeferredRelease(this);
        this.mIsAttached = true;
        if (!this.mIsRequestSubmitted) {
            submitRequest();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public boolean onClick() {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: onClick", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId);
        }
        if (!shouldRetryOnTap()) {
            return false;
        }
        this.mRetryManager.notifyTapToRetry();
        this.mSettableDraweeHierarchy.reset();
        submitRequest();
        return true;
    }

    public void onDetach() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onDetach");
        }
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: onDetach", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId);
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mDeferredReleaser.scheduleDeferredRelease(this);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    /* access modifiers changed from: protected */
    public void onImageLoadedFromCacheImmediately(String str, T t2) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: onTouchEvent %s", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId, (Object) motionEvent);
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector == null) {
            return false;
        }
        if (!gestureDetector.isCapturingGesture() && !shouldHandleGesture()) {
            return false;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    public void onViewportVisibilityHint(boolean z2) {
        ControllerViewportVisibilityListener controllerViewportVisibilityListener = this.mControllerViewportVisibilityListener;
        if (controllerViewportVisibilityListener != null) {
            if (z2 && !this.mIsVisibleInViewportHint) {
                controllerViewportVisibilityListener.onDraweeViewportEntry(this.mId);
            } else if (!z2 && this.mIsVisibleInViewportHint) {
                controllerViewportVisibilityListener.onDraweeViewportExit(this.mId);
            }
        }
        this.mIsVisibleInViewportHint = z2;
    }

    public void release() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        RetryManager retryManager = this.mRetryManager;
        if (retryManager != null) {
            retryManager.reset();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.reset();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        releaseFetch();
    }

    /* access modifiers changed from: protected */
    public abstract void releaseDrawable(Drawable drawable);

    /* access modifiers changed from: protected */
    public abstract void releaseImage(T t2);

    public void removeControllerListener(ControllerListener<? super INFO> controllerListener) {
        Preconditions.checkNotNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 instanceof InternalForwardingListener) {
            ((InternalForwardingListener) controllerListener2).removeListener(controllerListener);
        } else if (controllerListener2 == controllerListener) {
            this.mControllerListener = null;
        }
    }

    public void removeControllerListener2(ControllerListener2<INFO> controllerListener2) {
        this.mControllerListener2.removeListener(controllerListener2);
    }

    /* access modifiers changed from: protected */
    public void reportSubmit(DataSource<T> dataSource, INFO info) {
        getControllerListener().onSubmit(this.mId, this.mCallerContext);
        getControllerListener2().onSubmit(this.mId, this.mCallerContext, obtainExtras(dataSource, info, getMainUri()));
    }

    public void setContentDescription(String str) {
        this.mContentDescription = str;
    }

    /* access modifiers changed from: protected */
    public void setControllerOverlay(Drawable drawable) {
        this.mControllerOverlay = drawable;
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(drawable);
        }
    }

    public void setControllerViewportVisibilityListener(ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
    }

    /* access modifiers changed from: protected */
    public void setGestureDetector(GestureDetector gestureDetector) {
        this.mGestureDetector = gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.setClickListener(this);
        }
    }

    public void setHierarchy(DraweeHierarchy draweeHierarchy) {
        DraweeEventTracker.Event event;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: setHierarchy: %s", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId, (Object) draweeHierarchy);
        }
        DraweeEventTracker draweeEventTracker = this.mEventTracker;
        if (draweeHierarchy != null) {
            event = DraweeEventTracker.Event.ON_SET_HIERARCHY;
        } else {
            event = DraweeEventTracker.Event.ON_CLEAR_HIERARCHY;
        }
        draweeEventTracker.recordEvent(event);
        if (this.mIsRequestSubmitted) {
            this.mDeferredReleaser.cancelDeferredRelease(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay((Drawable) null);
            this.mSettableDraweeHierarchy = null;
        }
        if (draweeHierarchy != null) {
            Preconditions.checkArgument(Boolean.valueOf(draweeHierarchy instanceof SettableDraweeHierarchy));
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.mSettableDraweeHierarchy = settableDraweeHierarchy2;
            settableDraweeHierarchy2.setControllerOverlay(this.mControllerOverlay);
        }
        if (this.mLoggingListener != null) {
            setUpLoggingListener();
        }
    }

    public void setLoggingListener(LoggingListener loggingListener) {
        this.mLoggingListener = loggingListener;
    }

    /* access modifiers changed from: protected */
    public void setRetainImageOnFailure(boolean z2) {
        this.mRetainImageOnFailure = z2;
    }

    /* access modifiers changed from: protected */
    public boolean shouldHandleGesture() {
        return shouldRetryOnTap();
    }

    /* access modifiers changed from: protected */
    public void submitRequest() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#submitRequest");
        }
        Object cachedImage = getCachedImage();
        if (cachedImage != null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#submitRequest->cache");
            }
            this.mDataSource = null;
            this.mIsRequestSubmitted = true;
            this.mHasFetchFailed = false;
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            reportSubmit(this.mDataSource, getImageInfo(cachedImage));
            onImageLoadedFromCacheImmediately(this.mId, cachedImage);
            onNewResultInternal(this.mId, this.mDataSource, cachedImage, 1.0f, true, true, true);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        this.mSettableDraweeHierarchy.setProgress(0.0f, true);
        this.mIsRequestSubmitted = true;
        this.mHasFetchFailed = false;
        DataSource<T> dataSource = getDataSource();
        this.mDataSource = dataSource;
        reportSubmit(dataSource, (Object) null);
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", (Object) Integer.valueOf(System.identityHashCode(this)), (Object) this.mId, (Object) Integer.valueOf(System.identityHashCode(this.mDataSource)));
        }
        final String str = this.mId;
        final boolean hasResult = this.mDataSource.hasResult();
        this.mDataSource.subscribe(new BaseDataSubscriber<T>() {
            public void onFailureImpl(DataSource<T> dataSource) {
                AbstractDraweeController.this.onFailureInternal(str, dataSource, dataSource.getFailureCause(), true);
            }

            public void onNewResultImpl(DataSource<T> dataSource) {
                boolean isFinished = dataSource.isFinished();
                boolean hasMultipleResults = dataSource.hasMultipleResults();
                float progress = dataSource.getProgress();
                T result = dataSource.getResult();
                if (result != null) {
                    AbstractDraweeController.this.onNewResultInternal(str, dataSource, result, progress, isFinished, hasResult, hasMultipleResults);
                } else if (isFinished) {
                    AbstractDraweeController.this.onFailureInternal(str, dataSource, new NullPointerException(), true);
                }
            }

            public void onProgressUpdate(DataSource<T> dataSource) {
                boolean isFinished = dataSource.isFinished();
                AbstractDraweeController.this.onProgressUpdateInternal(str, dataSource, dataSource.getProgress(), isFinished);
            }
        }, this.mUiThreadImmediateExecutor);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    public String toString() {
        return Objects.toStringHelper((Object) this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add("events", (Object) this.mEventTracker.toString()).toString();
    }

    private ControllerListener2.Extras obtainExtras(DataSource<T> dataSource, INFO info, Uri uri) {
        return obtainExtras(dataSource == null ? null : dataSource.getExtras(), obtainExtrasFromImage(info), uri);
    }
}

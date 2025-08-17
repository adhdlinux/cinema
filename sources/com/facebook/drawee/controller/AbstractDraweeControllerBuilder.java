package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.FirstAvailableDataSourceSupplier;
import com.facebook.datasource.IncreasingQualityDataSourceSupplier;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.SimpleDraweeControllerBuilder;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.ReturnsOwnership;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Nullsafe(Nullsafe.Mode.LOCAL)
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> implements SimpleDraweeControllerBuilder {
    private static final NullPointerException NO_REQUEST_EXCEPTION = new NullPointerException("No image request was specified!");
    private static final ControllerListener<Object> sAutoPlayAnimationsListener = new BaseControllerListener<Object>() {
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    };
    private static final AtomicLong sIdCounter = new AtomicLong();
    private boolean mAutoPlayAnimations;
    private final Set<ControllerListener> mBoundControllerListeners;
    private final Set<ControllerListener2> mBoundControllerListeners2;
    private Object mCallerContext;
    private String mContentDescription;
    private final Context mContext;
    private ControllerListener<? super INFO> mControllerListener;
    private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;
    private Supplier<DataSource<IMAGE>> mDataSourceSupplier;
    private REQUEST mImageRequest;
    private LoggingListener mLoggingListener;
    private REQUEST mLowResImageRequest;
    private REQUEST[] mMultiImageRequests;
    private DraweeController mOldController;
    private boolean mRetainImageOnFailure;
    private boolean mTapToRetryEnabled;
    private boolean mTryCacheOnlyFirst;

    public enum CacheLevel {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    protected AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set, Set<ControllerListener2> set2) {
        this.mContext = context;
        this.mBoundControllerListeners = set;
        this.mBoundControllerListeners2 = set2;
        init();
    }

    protected static String generateUniqueControllerId() {
        return String.valueOf(sIdCounter.getAndIncrement());
    }

    private void init() {
        this.mCallerContext = null;
        this.mImageRequest = null;
        this.mLowResImageRequest = null;
        this.mMultiImageRequests = null;
        this.mTryCacheOnlyFirst = true;
        this.mControllerListener = null;
        this.mLoggingListener = null;
        this.mControllerViewportVisibilityListener = null;
        this.mTapToRetryEnabled = false;
        this.mAutoPlayAnimations = false;
        this.mOldController = null;
        this.mContentDescription = null;
    }

    /* access modifiers changed from: protected */
    public AbstractDraweeController buildController() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeControllerBuilder#buildController");
        }
        AbstractDraweeController obtainController = obtainController();
        obtainController.setRetainImageOnFailure(getRetainImageOnFailure());
        obtainController.setContentDescription(getContentDescription());
        obtainController.setControllerViewportVisibilityListener(getControllerViewportVisibilityListener());
        maybeBuildAndSetRetryManager(obtainController);
        maybeAttachListeners(obtainController);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return obtainController;
    }

    public boolean getAutoPlayAnimations() {
        return this.mAutoPlayAnimations;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public String getContentDescription() {
        return this.mContentDescription;
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.mContext;
    }

    public ControllerListener<? super INFO> getControllerListener() {
        return this.mControllerListener;
    }

    public ControllerViewportVisibilityListener getControllerViewportVisibilityListener() {
        return this.mControllerViewportVisibilityListener;
    }

    /* access modifiers changed from: protected */
    public abstract DataSource<IMAGE> getDataSourceForRequest(DraweeController draweeController, String str, REQUEST request, Object obj, CacheLevel cacheLevel);

    public Supplier<DataSource<IMAGE>> getDataSourceSupplier() {
        return this.mDataSourceSupplier;
    }

    /* access modifiers changed from: protected */
    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request) {
        return getDataSourceSupplierForRequest(draweeController, str, request, CacheLevel.FULL_FETCH);
    }

    /* access modifiers changed from: protected */
    public Supplier<DataSource<IMAGE>> getFirstAvailableDataSourceSupplier(DraweeController draweeController, String str, REQUEST[] requestArr, boolean z2) {
        ArrayList arrayList = new ArrayList(requestArr.length * 2);
        if (z2) {
            for (REQUEST dataSourceSupplierForRequest : requestArr) {
                arrayList.add(getDataSourceSupplierForRequest(draweeController, str, dataSourceSupplierForRequest, CacheLevel.BITMAP_MEMORY_CACHE));
            }
        }
        for (REQUEST dataSourceSupplierForRequest2 : requestArr) {
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, dataSourceSupplierForRequest2));
        }
        return FirstAvailableDataSourceSupplier.create(arrayList);
    }

    public REQUEST[] getFirstAvailableImageRequests() {
        return this.mMultiImageRequests;
    }

    public REQUEST getImageRequest() {
        return this.mImageRequest;
    }

    public LoggingListener getLoggingListener() {
        return this.mLoggingListener;
    }

    public REQUEST getLowResImageRequest() {
        return this.mLowResImageRequest;
    }

    public DraweeController getOldController() {
        return this.mOldController;
    }

    public boolean getRetainImageOnFailure() {
        return this.mRetainImageOnFailure;
    }

    public boolean getTapToRetryEnabled() {
        return this.mTapToRetryEnabled;
    }

    /* access modifiers changed from: protected */
    public final BUILDER getThis() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void maybeAttachListeners(AbstractDraweeController abstractDraweeController) {
        Set<ControllerListener> set = this.mBoundControllerListeners;
        if (set != null) {
            for (ControllerListener addControllerListener : set) {
                abstractDraweeController.addControllerListener(addControllerListener);
            }
        }
        Set<ControllerListener2> set2 = this.mBoundControllerListeners2;
        if (set2 != null) {
            for (ControllerListener2 addControllerListener2 : set2) {
                abstractDraweeController.addControllerListener2(addControllerListener2);
            }
        }
        ControllerListener<? super INFO> controllerListener = this.mControllerListener;
        if (controllerListener != null) {
            abstractDraweeController.addControllerListener(controllerListener);
        }
        if (this.mAutoPlayAnimations) {
            abstractDraweeController.addControllerListener(sAutoPlayAnimationsListener);
        }
    }

    /* access modifiers changed from: protected */
    public void maybeBuildAndSetGestureDetector(AbstractDraweeController abstractDraweeController) {
        if (abstractDraweeController.getGestureDetector() == null) {
            abstractDraweeController.setGestureDetector(GestureDetector.newInstance(this.mContext));
        }
    }

    /* access modifiers changed from: protected */
    public void maybeBuildAndSetRetryManager(AbstractDraweeController abstractDraweeController) {
        if (this.mTapToRetryEnabled) {
            abstractDraweeController.getRetryManager().setTapToRetryEnabled(this.mTapToRetryEnabled);
            maybeBuildAndSetGestureDetector(abstractDraweeController);
        }
    }

    /* access modifiers changed from: protected */
    @ReturnsOwnership
    public abstract AbstractDraweeController obtainController();

    /* access modifiers changed from: protected */
    public Supplier<DataSource<IMAGE>> obtainDataSourceSupplier(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> supplier;
        Supplier<DataSource<IMAGE>> supplier2 = this.mDataSourceSupplier;
        if (supplier2 != null) {
            return supplier2;
        }
        REQUEST request = this.mImageRequest;
        if (request != null) {
            supplier = getDataSourceSupplierForRequest(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.mMultiImageRequests;
            if (requestArr != null) {
                supplier = getFirstAvailableDataSourceSupplier(draweeController, str, requestArr, this.mTryCacheOnlyFirst);
            } else {
                supplier = null;
            }
        }
        if (!(supplier == null || this.mLowResImageRequest == null)) {
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(supplier);
            arrayList.add(getDataSourceSupplierForRequest(draweeController, str, this.mLowResImageRequest));
            supplier = IncreasingQualityDataSourceSupplier.create(arrayList, false);
        }
        if (supplier == null) {
            return DataSources.getFailedDataSourceSupplier(NO_REQUEST_EXCEPTION);
        }
        return supplier;
    }

    public BUILDER reset() {
        init();
        return getThis();
    }

    public BUILDER setAutoPlayAnimations(boolean z2) {
        this.mAutoPlayAnimations = z2;
        return getThis();
    }

    public BUILDER setContentDescription(String str) {
        this.mContentDescription = str;
        return getThis();
    }

    public BUILDER setControllerListener(ControllerListener<? super INFO> controllerListener) {
        this.mControllerListener = controllerListener;
        return getThis();
    }

    public BUILDER setControllerViewportVisibilityListener(ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
        return getThis();
    }

    public BUILDER setDataSourceSupplier(Supplier<DataSource<IMAGE>> supplier) {
        this.mDataSourceSupplier = supplier;
        return getThis();
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr) {
        return setFirstAvailableImageRequests(requestArr, true);
    }

    public BUILDER setImageRequest(REQUEST request) {
        this.mImageRequest = request;
        return getThis();
    }

    public BUILDER setLoggingListener(LoggingListener loggingListener) {
        this.mLoggingListener = loggingListener;
        return getThis();
    }

    public BUILDER setLowResImageRequest(REQUEST request) {
        this.mLowResImageRequest = request;
        return getThis();
    }

    public BUILDER setRetainImageOnFailure(boolean z2) {
        this.mRetainImageOnFailure = z2;
        return getThis();
    }

    public BUILDER setTapToRetryEnabled(boolean z2) {
        this.mTapToRetryEnabled = z2;
        return getThis();
    }

    /* access modifiers changed from: protected */
    public void validate() {
        boolean z2;
        boolean z3 = false;
        if (this.mMultiImageRequests == null || this.mImageRequest == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.checkState(z2, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        if (this.mDataSourceSupplier == null || (this.mMultiImageRequests == null && this.mImageRequest == null && this.mLowResImageRequest == null)) {
            z3 = true;
        }
        Preconditions.checkState(z3, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
    }

    public AbstractDraweeController build() {
        REQUEST request;
        validate();
        if (this.mImageRequest == null && this.mMultiImageRequests == null && (request = this.mLowResImageRequest) != null) {
            this.mImageRequest = request;
            this.mLowResImageRequest = null;
        }
        return buildController();
    }

    /* access modifiers changed from: protected */
    public Supplier<DataSource<IMAGE>> getDataSourceSupplierForRequest(DraweeController draweeController, String str, REQUEST request, CacheLevel cacheLevel) {
        final Object callerContext = getCallerContext();
        final DraweeController draweeController2 = draweeController;
        final String str2 = str;
        final REQUEST request2 = request;
        final CacheLevel cacheLevel2 = cacheLevel;
        return new Supplier<DataSource<IMAGE>>() {
            public String toString() {
                return Objects.toStringHelper((Object) this).add(AdActivity.REQUEST_KEY_EXTRA, (Object) request2.toString()).toString();
            }

            public DataSource<IMAGE> get() {
                return AbstractDraweeControllerBuilder.this.getDataSourceForRequest(draweeController2, str2, request2, callerContext, cacheLevel2);
            }
        };
    }

    public BUILDER setCallerContext(Object obj) {
        this.mCallerContext = obj;
        return getThis();
    }

    public BUILDER setFirstAvailableImageRequests(REQUEST[] requestArr, boolean z2) {
        Preconditions.checkArgument(requestArr == null || requestArr.length > 0, "No requests specified!");
        this.mMultiImageRequests = requestArr;
        this.mTryCacheOnlyFirst = z2;
        return getThis();
    }

    public BUILDER setOldController(DraweeController draweeController) {
        this.mOldController = draweeController;
        return getThis();
    }
}

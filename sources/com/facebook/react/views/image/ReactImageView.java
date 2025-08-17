package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.facebook.common.internal.Objects;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.controller.ForwardingControllerListener;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.RoundedColorDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.postprocessors.IterativeBoxBlurPostProcessor;
import com.facebook.imagepipeline.request.BasePostprocessor;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.fresco.ReactNetworkImageRequest;
import com.facebook.react.uimanager.FloatUtil;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.imagehelper.ImageSource;
import com.facebook.react.views.imagehelper.MultiSourceHelper;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.yoga.YogaConstants;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReactImageView extends GenericDraweeView {
    public static final int REMOTE_IMAGE_FADE_DURATION_MS = 300;
    public static final String REMOTE_TRANSPARENT_BITMAP_URI = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII=";
    private static float[] sComputedCornerRadii = new float[4];
    /* access modifiers changed from: private */
    public static final Matrix sTileMatrix = new Matrix();
    private int mBackgroundColor = 0;
    private RoundedColorDrawable mBackgroundImageDrawable;
    private int mBorderColor;
    private float[] mBorderCornerRadii;
    private float mBorderRadius = Float.NaN;
    private float mBorderWidth;
    private ImageSource mCachedImageSource;
    private Object mCallerContext;
    private ControllerListener mControllerForTesting;
    private Drawable mDefaultImageDrawable;
    private ReactImageDownloadListener mDownloadListener;
    private final AbstractDraweeControllerBuilder mDraweeControllerBuilder;
    private int mFadeDurationMs = -1;
    private GlobalImageLoadListener mGlobalImageLoadListener;
    private ReadableMap mHeaders;
    /* access modifiers changed from: private */
    public ImageSource mImageSource;
    private boolean mIsDirty;
    private IterativeBoxBlurPostProcessor mIterativeBoxBlurPostProcessor;
    private Drawable mLoadingImageDrawable;
    private int mOverlayColor;
    private boolean mProgressiveRenderingEnabled;
    private ImageResizeMethod mResizeMethod = ImageResizeMethod.AUTO;
    /* access modifiers changed from: private */
    public ScalingUtils.ScaleType mScaleType = ImageResizeMode.defaultValue();
    private final List<ImageSource> mSources = new LinkedList();
    /* access modifiers changed from: private */
    public Shader.TileMode mTileMode = ImageResizeMode.defaultTileMode();
    private TilePostprocessor mTilePostprocessor;

    private class TilePostprocessor extends BasePostprocessor {
        private TilePostprocessor() {
        }

        public CloseableReference<Bitmap> process(Bitmap bitmap, PlatformBitmapFactory platformBitmapFactory) {
            Rect rect = new Rect(0, 0, ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            ReactImageView.this.mScaleType.getTransform(ReactImageView.sTileMatrix, rect, bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            BitmapShader bitmapShader = new BitmapShader(bitmap, ReactImageView.this.mTileMode, ReactImageView.this.mTileMode);
            bitmapShader.setLocalMatrix(ReactImageView.sTileMatrix);
            paint.setShader(bitmapShader);
            CloseableReference<Bitmap> createBitmap = platformBitmapFactory.createBitmap(ReactImageView.this.getWidth(), ReactImageView.this.getHeight());
            try {
                new Canvas(createBitmap.get()).drawRect(rect, paint);
                return createBitmap.clone();
            } finally {
                CloseableReference.closeSafely((CloseableReference<?>) createBitmap);
            }
        }
    }

    public ReactImageView(Context context, AbstractDraweeControllerBuilder abstractDraweeControllerBuilder, GlobalImageLoadListener globalImageLoadListener, Object obj) {
        super(context, buildHierarchy(context));
        this.mDraweeControllerBuilder = abstractDraweeControllerBuilder;
        this.mGlobalImageLoadListener = globalImageLoadListener;
        this.mCallerContext = obj;
    }

    private static GenericDraweeHierarchy buildHierarchy(Context context) {
        RoundingParams fromCornersRadius = RoundingParams.fromCornersRadius(0.0f);
        fromCornersRadius.setPaintFilterBitmap(true);
        return new GenericDraweeHierarchyBuilder(context.getResources()).setRoundingParams(fromCornersRadius).build();
    }

    private void getCornerRadii(float[] fArr) {
        float f2;
        float f3;
        float f4;
        float f5;
        if (!YogaConstants.isUndefined(this.mBorderRadius)) {
            f2 = this.mBorderRadius;
        } else {
            f2 = 0.0f;
        }
        float[] fArr2 = this.mBorderCornerRadii;
        if (fArr2 == null || YogaConstants.isUndefined(fArr2[0])) {
            f3 = f2;
        } else {
            f3 = this.mBorderCornerRadii[0];
        }
        fArr[0] = f3;
        float[] fArr3 = this.mBorderCornerRadii;
        if (fArr3 == null || YogaConstants.isUndefined(fArr3[1])) {
            f4 = f2;
        } else {
            f4 = this.mBorderCornerRadii[1];
        }
        fArr[1] = f4;
        float[] fArr4 = this.mBorderCornerRadii;
        if (fArr4 == null || YogaConstants.isUndefined(fArr4[2])) {
            f5 = f2;
        } else {
            f5 = this.mBorderCornerRadii[2];
        }
        fArr[2] = f5;
        float[] fArr5 = this.mBorderCornerRadii;
        if (fArr5 != null && !YogaConstants.isUndefined(fArr5[3])) {
            f2 = this.mBorderCornerRadii[3];
        }
        fArr[3] = f2;
    }

    private boolean hasMultipleSources() {
        return this.mSources.size() > 1;
    }

    private boolean isTiled() {
        return this.mTileMode != Shader.TileMode.CLAMP;
    }

    private void setSourceImage() {
        this.mImageSource = null;
        if (this.mSources.isEmpty()) {
            this.mSources.add(new ImageSource(getContext(), REMOTE_TRANSPARENT_BITMAP_URI));
        } else if (hasMultipleSources()) {
            MultiSourceHelper.MultiSourceResult bestSourceForSize = MultiSourceHelper.getBestSourceForSize(getWidth(), getHeight(), this.mSources);
            this.mImageSource = bestSourceForSize.getBestResult();
            this.mCachedImageSource = bestSourceForSize.getBestResultInCache();
            return;
        }
        this.mImageSource = this.mSources.get(0);
    }

    private boolean shouldResize(ImageSource imageSource) {
        ImageResizeMethod imageResizeMethod = this.mResizeMethod;
        if (imageResizeMethod == ImageResizeMethod.AUTO) {
            if (UriUtil.isLocalContentUri(imageSource.getUri()) || UriUtil.isLocalFileUri(imageSource.getUri())) {
                return true;
            }
            return false;
        } else if (imageResizeMethod == ImageResizeMethod.RESIZE) {
            return true;
        } else {
            return false;
        }
    }

    private void warnImageSource(String str) {
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    public void maybeUpdateView() {
        ResizeOptions resizeOptions;
        if (this.mIsDirty) {
            if (!hasMultipleSources() || (getWidth() > 0 && getHeight() > 0)) {
                setSourceImage();
                ImageSource imageSource = this.mImageSource;
                if (imageSource != null) {
                    boolean shouldResize = shouldResize(imageSource);
                    if (shouldResize && (getWidth() <= 0 || getHeight() <= 0)) {
                        return;
                    }
                    if (!isTiled() || (getWidth() > 0 && getHeight() > 0)) {
                        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getHierarchy();
                        genericDraweeHierarchy.setActualImageScaleType(this.mScaleType);
                        Drawable drawable = this.mDefaultImageDrawable;
                        if (drawable != null) {
                            genericDraweeHierarchy.setPlaceholderImage(drawable, this.mScaleType);
                        }
                        Drawable drawable2 = this.mLoadingImageDrawable;
                        if (drawable2 != null) {
                            genericDraweeHierarchy.setPlaceholderImage(drawable2, ScalingUtils.ScaleType.CENTER);
                        }
                        getCornerRadii(sComputedCornerRadii);
                        RoundingParams roundingParams = genericDraweeHierarchy.getRoundingParams();
                        float[] fArr = sComputedCornerRadii;
                        roundingParams.setCornersRadii(fArr[0], fArr[1], fArr[2], fArr[3]);
                        RoundedColorDrawable roundedColorDrawable = this.mBackgroundImageDrawable;
                        if (roundedColorDrawable != null) {
                            roundedColorDrawable.setBorder(this.mBorderColor, this.mBorderWidth);
                            this.mBackgroundImageDrawable.setRadii(roundingParams.getCornersRadii());
                            genericDraweeHierarchy.setBackgroundImage(this.mBackgroundImageDrawable);
                        }
                        roundingParams.setBorder(this.mBorderColor, this.mBorderWidth);
                        int i2 = this.mOverlayColor;
                        if (i2 != 0) {
                            roundingParams.setOverlayColor(i2);
                        } else {
                            roundingParams.setRoundingMethod(RoundingParams.RoundingMethod.BITMAP_ONLY);
                        }
                        genericDraweeHierarchy.setRoundingParams(roundingParams);
                        int i3 = this.mFadeDurationMs;
                        if (i3 < 0) {
                            if (this.mImageSource.isResource()) {
                                i3 = 0;
                            } else {
                                i3 = 300;
                            }
                        }
                        genericDraweeHierarchy.setFadeDuration(i3);
                        LinkedList linkedList = new LinkedList();
                        IterativeBoxBlurPostProcessor iterativeBoxBlurPostProcessor = this.mIterativeBoxBlurPostProcessor;
                        if (iterativeBoxBlurPostProcessor != null) {
                            linkedList.add(iterativeBoxBlurPostProcessor);
                        }
                        TilePostprocessor tilePostprocessor = this.mTilePostprocessor;
                        if (tilePostprocessor != null) {
                            linkedList.add(tilePostprocessor);
                        }
                        Postprocessor from = MultiPostprocessor.from(linkedList);
                        if (shouldResize) {
                            resizeOptions = new ResizeOptions(getWidth(), getHeight());
                        } else {
                            resizeOptions = null;
                        }
                        ReactNetworkImageRequest fromBuilderWithHeaders = ReactNetworkImageRequest.fromBuilderWithHeaders(ImageRequestBuilder.newBuilderWithSource(this.mImageSource.getUri()).setPostprocessor(from).setResizeOptions(resizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled), this.mHeaders);
                        GlobalImageLoadListener globalImageLoadListener = this.mGlobalImageLoadListener;
                        if (globalImageLoadListener != null) {
                            globalImageLoadListener.onLoadAttempt(this.mImageSource.getUri());
                        }
                        this.mDraweeControllerBuilder.reset();
                        this.mDraweeControllerBuilder.setAutoPlayAnimations(true).setCallerContext(this.mCallerContext).setOldController(getController()).setImageRequest(fromBuilderWithHeaders);
                        ImageSource imageSource2 = this.mCachedImageSource;
                        if (imageSource2 != null) {
                            this.mDraweeControllerBuilder.setLowResImageRequest(ImageRequestBuilder.newBuilderWithSource(imageSource2.getUri()).setPostprocessor(from).setResizeOptions(resizeOptions).setAutoRotateEnabled(true).setProgressiveRenderingEnabled(this.mProgressiveRenderingEnabled).build());
                        }
                        ReactImageDownloadListener reactImageDownloadListener = this.mDownloadListener;
                        if (reactImageDownloadListener == null || this.mControllerForTesting == null) {
                            ControllerListener controllerListener = this.mControllerForTesting;
                            if (controllerListener != null) {
                                this.mDraweeControllerBuilder.setControllerListener(controllerListener);
                            } else if (reactImageDownloadListener != null) {
                                this.mDraweeControllerBuilder.setControllerListener(reactImageDownloadListener);
                            }
                        } else {
                            ForwardingControllerListener forwardingControllerListener = new ForwardingControllerListener();
                            forwardingControllerListener.addListener(this.mDownloadListener);
                            forwardingControllerListener.addListener(this.mControllerForTesting);
                            this.mDraweeControllerBuilder.setControllerListener(forwardingControllerListener);
                        }
                        ReactImageDownloadListener reactImageDownloadListener2 = this.mDownloadListener;
                        if (reactImageDownloadListener2 != null) {
                            genericDraweeHierarchy.setProgressBarImage((Drawable) reactImageDownloadListener2);
                        }
                        setController(this.mDraweeControllerBuilder.build());
                        this.mIsDirty = false;
                        this.mDraweeControllerBuilder.reset();
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        boolean z2;
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 > 0 && i3 > 0) {
            if (this.mIsDirty || hasMultipleSources() || isTiled()) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.mIsDirty = z2;
            maybeUpdateView();
        }
    }

    public void setBackgroundColor(int i2) {
        if (this.mBackgroundColor != i2) {
            this.mBackgroundColor = i2;
            this.mBackgroundImageDrawable = new RoundedColorDrawable(i2);
            this.mIsDirty = true;
        }
    }

    public void setBlurRadius(float f2) {
        int pixelFromDIP = ((int) PixelUtil.toPixelFromDIP(f2)) / 2;
        if (pixelFromDIP == 0) {
            this.mIterativeBoxBlurPostProcessor = null;
        } else {
            this.mIterativeBoxBlurPostProcessor = new IterativeBoxBlurPostProcessor(2, pixelFromDIP);
        }
        this.mIsDirty = true;
    }

    public void setBorderColor(int i2) {
        if (this.mBorderColor != i2) {
            this.mBorderColor = i2;
            this.mIsDirty = true;
        }
    }

    public void setBorderRadius(float f2) {
        if (!FloatUtil.floatsEqual(this.mBorderRadius, f2)) {
            this.mBorderRadius = f2;
            this.mIsDirty = true;
        }
    }

    public void setBorderWidth(float f2) {
        float pixelFromDIP = PixelUtil.toPixelFromDIP(f2);
        if (!FloatUtil.floatsEqual(this.mBorderWidth, pixelFromDIP)) {
            this.mBorderWidth = pixelFromDIP;
            this.mIsDirty = true;
        }
    }

    public void setControllerListener(ControllerListener controllerListener) {
        this.mControllerForTesting = controllerListener;
        this.mIsDirty = true;
        maybeUpdateView();
    }

    public void setDefaultSource(String str) {
        Drawable resourceDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), str);
        if (!Objects.equal(this.mDefaultImageDrawable, resourceDrawable)) {
            this.mDefaultImageDrawable = resourceDrawable;
            this.mIsDirty = true;
        }
    }

    public void setFadeDuration(int i2) {
        this.mFadeDurationMs = i2;
    }

    public void setHeaders(ReadableMap readableMap) {
        this.mHeaders = readableMap;
    }

    public void setLoadingIndicatorSource(String str) {
        AutoRotateDrawable autoRotateDrawable;
        Drawable resourceDrawable = ResourceDrawableIdHelper.getInstance().getResourceDrawable(getContext(), str);
        if (resourceDrawable != null) {
            autoRotateDrawable = new AutoRotateDrawable(resourceDrawable, 1000);
        } else {
            autoRotateDrawable = null;
        }
        if (!Objects.equal(this.mLoadingImageDrawable, autoRotateDrawable)) {
            this.mLoadingImageDrawable = autoRotateDrawable;
            this.mIsDirty = true;
        }
    }

    public void setOverlayColor(int i2) {
        if (this.mOverlayColor != i2) {
            this.mOverlayColor = i2;
            this.mIsDirty = true;
        }
    }

    public void setProgressiveRenderingEnabled(boolean z2) {
        this.mProgressiveRenderingEnabled = z2;
    }

    public void setResizeMethod(ImageResizeMethod imageResizeMethod) {
        if (this.mResizeMethod != imageResizeMethod) {
            this.mResizeMethod = imageResizeMethod;
            this.mIsDirty = true;
        }
    }

    public void setScaleType(ScalingUtils.ScaleType scaleType) {
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            this.mIsDirty = true;
        }
    }

    public void setShouldNotifyLoadEvents(boolean z2) {
        boolean z3;
        if (this.mDownloadListener != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 != z3) {
            if (!z2) {
                this.mDownloadListener = null;
            } else {
                final EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ReactContext) getContext(), getId());
                this.mDownloadListener = new ReactImageDownloadListener<ImageInfo>() {
                    public void onFailure(String str, Throwable th) {
                        eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createErrorEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId(), th));
                    }

                    public void onProgressChange(int i2, int i3) {
                        eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createProgressEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId(), ReactImageView.this.mImageSource.getSource(), i2, i3));
                    }

                    public void onSubmit(String str, Object obj) {
                        eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createLoadStartEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId()));
                    }

                    public void onFinalImageSet(String str, ImageInfo imageInfo, Animatable animatable) {
                        if (imageInfo != null) {
                            eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createLoadEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId(), ReactImageView.this.mImageSource.getSource(), imageInfo.getWidth(), imageInfo.getHeight()));
                            eventDispatcherForReactTag.dispatchEvent(ImageLoadEvent.createLoadEndEvent(UIManagerHelper.getSurfaceId((View) ReactImageView.this), ReactImageView.this.getId()));
                        }
                    }
                };
            }
            this.mIsDirty = true;
        }
    }

    public void setSource(ReadableArray readableArray) {
        LinkedList<ImageSource> linkedList = new LinkedList<>();
        if (readableArray == null || readableArray.size() == 0) {
            linkedList.add(new ImageSource(getContext(), REMOTE_TRANSPARENT_BITMAP_URI));
        } else {
            if (readableArray.size() == 1) {
                String string = readableArray.getMap(0).getString("uri");
                ImageSource imageSource = new ImageSource(getContext(), string);
                linkedList.add(imageSource);
                if (Uri.EMPTY.equals(imageSource.getUri())) {
                    warnImageSource(string);
                }
            } else {
                for (int i2 = 0; i2 < readableArray.size(); i2++) {
                    ReadableMap map = readableArray.getMap(i2);
                    String string2 = map.getString("uri");
                    ImageSource imageSource2 = new ImageSource(getContext(), string2, map.getDouble("width"), map.getDouble("height"));
                    linkedList.add(imageSource2);
                    if (Uri.EMPTY.equals(imageSource2.getUri())) {
                        warnImageSource(string2);
                    }
                }
            }
        }
        if (!this.mSources.equals(linkedList)) {
            this.mSources.clear();
            for (ImageSource add : linkedList) {
                this.mSources.add(add);
            }
            this.mIsDirty = true;
        }
    }

    public void setTileMode(Shader.TileMode tileMode) {
        if (this.mTileMode != tileMode) {
            this.mTileMode = tileMode;
            if (isTiled()) {
                this.mTilePostprocessor = new TilePostprocessor();
            } else {
                this.mTilePostprocessor = null;
            }
            this.mIsDirty = true;
        }
    }

    public void updateCallerContext(Object obj) {
        if (!Objects.equal(this.mCallerContext, obj)) {
            this.mCallerContext = obj;
            this.mIsDirty = true;
        }
    }

    public void setBorderRadius(float f2, int i2) {
        if (this.mBorderCornerRadii == null) {
            float[] fArr = new float[4];
            this.mBorderCornerRadii = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (!FloatUtil.floatsEqual(this.mBorderCornerRadii[i2], f2)) {
            this.mBorderCornerRadii[i2] = f2;
            this.mIsDirty = true;
        }
    }
}

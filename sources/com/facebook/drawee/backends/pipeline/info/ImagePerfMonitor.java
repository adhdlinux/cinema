package com.facebook.drawee.backends.pipeline.info;

import android.graphics.Rect;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfControllerListener2;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.internal.ImagePerfRequestListener;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImagePerfMonitor implements ImagePerfNotifier {
    private final Supplier<Boolean> mAsyncLogging;
    private boolean mEnabled;
    private ForwardingRequestListener mForwardingRequestListener;
    private ImageOriginListener mImageOriginListener;
    private ImageOriginRequestListener mImageOriginRequestListener;
    private ImagePerfControllerListener2 mImagePerfControllerListener2;
    private List<ImagePerfDataListener> mImagePerfDataListeners;
    private ImagePerfRequestListener mImagePerfRequestListener;
    private final ImagePerfState mImagePerfState = new ImagePerfState();
    private final MonotonicClock mMonotonicClock;
    private final PipelineDraweeController mPipelineDraweeController;

    public ImagePerfMonitor(MonotonicClock monotonicClock, PipelineDraweeController pipelineDraweeController, Supplier<Boolean> supplier) {
        this.mMonotonicClock = monotonicClock;
        this.mPipelineDraweeController = pipelineDraweeController;
        this.mAsyncLogging = supplier;
    }

    private void setupListeners() {
        if (this.mImagePerfControllerListener2 == null) {
            this.mImagePerfControllerListener2 = new ImagePerfControllerListener2(this.mMonotonicClock, this.mImagePerfState, this, this.mAsyncLogging, Suppliers.BOOLEAN_FALSE);
        }
        if (this.mImagePerfRequestListener == null) {
            this.mImagePerfRequestListener = new ImagePerfRequestListener(this.mMonotonicClock, this.mImagePerfState);
        }
        if (this.mImageOriginListener == null) {
            this.mImageOriginListener = new ImagePerfImageOriginListener(this.mImagePerfState, this);
        }
        ImageOriginRequestListener imageOriginRequestListener = this.mImageOriginRequestListener;
        if (imageOriginRequestListener == null) {
            this.mImageOriginRequestListener = new ImageOriginRequestListener(this.mPipelineDraweeController.getId(), this.mImageOriginListener);
        } else {
            imageOriginRequestListener.init(this.mPipelineDraweeController.getId());
        }
        if (this.mForwardingRequestListener == null) {
            this.mForwardingRequestListener = new ForwardingRequestListener(this.mImagePerfRequestListener, this.mImageOriginRequestListener);
        }
    }

    public void addImagePerfDataListener(ImagePerfDataListener imagePerfDataListener) {
        if (imagePerfDataListener != null) {
            if (this.mImagePerfDataListeners == null) {
                this.mImagePerfDataListeners = new CopyOnWriteArrayList();
            }
            this.mImagePerfDataListeners.add(imagePerfDataListener);
        }
    }

    public void addViewportData() {
        DraweeHierarchy hierarchy = this.mPipelineDraweeController.getHierarchy();
        if (hierarchy != null && hierarchy.getTopLevelDrawable() != null) {
            Rect bounds = hierarchy.getTopLevelDrawable().getBounds();
            this.mImagePerfState.setOnScreenWidth(bounds.width());
            this.mImagePerfState.setOnScreenHeight(bounds.height());
        }
    }

    public void clearImagePerfDataListeners() {
        List<ImagePerfDataListener> list = this.mImagePerfDataListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void notifyListenersOfVisibilityStateUpdate(ImagePerfState imagePerfState, int i2) {
        List<ImagePerfDataListener> list;
        if (this.mEnabled && (list = this.mImagePerfDataListeners) != null && !list.isEmpty()) {
            ImagePerfData snapshot = imagePerfState.snapshot();
            for (ImagePerfDataListener onImageVisibilityUpdated : this.mImagePerfDataListeners) {
                onImageVisibilityUpdated.onImageVisibilityUpdated(snapshot, i2);
            }
        }
    }

    public void notifyStatusUpdated(ImagePerfState imagePerfState, int i2) {
        List<ImagePerfDataListener> list;
        imagePerfState.setImageLoadStatus(i2);
        if (this.mEnabled && (list = this.mImagePerfDataListeners) != null && !list.isEmpty()) {
            if (i2 == 3) {
                addViewportData();
            }
            ImagePerfData snapshot = imagePerfState.snapshot();
            for (ImagePerfDataListener onImageLoadStatusUpdated : this.mImagePerfDataListeners) {
                onImageLoadStatusUpdated.onImageLoadStatusUpdated(snapshot, i2);
            }
        }
    }

    public void removeImagePerfDataListener(ImagePerfDataListener imagePerfDataListener) {
        List<ImagePerfDataListener> list = this.mImagePerfDataListeners;
        if (list != null) {
            list.remove(imagePerfDataListener);
        }
    }

    public void reset() {
        clearImagePerfDataListeners();
        setEnabled(false);
        this.mImagePerfState.reset();
    }

    public void setEnabled(boolean z2) {
        this.mEnabled = z2;
        if (z2) {
            setupListeners();
            ImageOriginListener imageOriginListener = this.mImageOriginListener;
            if (imageOriginListener != null) {
                this.mPipelineDraweeController.addImageOriginListener(imageOriginListener);
            }
            ImagePerfControllerListener2 imagePerfControllerListener2 = this.mImagePerfControllerListener2;
            if (imagePerfControllerListener2 != null) {
                this.mPipelineDraweeController.addControllerListener2(imagePerfControllerListener2);
            }
            ForwardingRequestListener forwardingRequestListener = this.mForwardingRequestListener;
            if (forwardingRequestListener != null) {
                this.mPipelineDraweeController.addRequestListener(forwardingRequestListener);
                return;
            }
            return;
        }
        ImageOriginListener imageOriginListener2 = this.mImageOriginListener;
        if (imageOriginListener2 != null) {
            this.mPipelineDraweeController.removeImageOriginListener(imageOriginListener2);
        }
        ImagePerfControllerListener2 imagePerfControllerListener22 = this.mImagePerfControllerListener2;
        if (imagePerfControllerListener22 != null) {
            this.mPipelineDraweeController.removeControllerListener2(imagePerfControllerListener22);
        }
        ForwardingRequestListener forwardingRequestListener2 = this.mForwardingRequestListener;
        if (forwardingRequestListener2 != null) {
            this.mPipelineDraweeController.removeRequestListener(forwardingRequestListener2);
        }
    }

    public void updateImageRequestData(AbstractDraweeControllerBuilder<PipelineDraweeControllerBuilder, ImageRequest, CloseableReference<CloseableImage>, ImageInfo> abstractDraweeControllerBuilder) {
        this.mImagePerfState.setControllerImageRequests(abstractDraweeControllerBuilder.getImageRequest(), abstractDraweeControllerBuilder.getLowResImageRequest(), (ImageRequest[]) abstractDraweeControllerBuilder.getFirstAvailableImageRequests());
    }
}

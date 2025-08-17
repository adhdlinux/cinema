package com.facebook.drawee.backends.pipeline.info.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawee.backends.pipeline.info.ImagePerfNotifier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;
import com.facebook.fresco.ui.common.BaseControllerListener2;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.DimensionsInfo;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class ImagePerfControllerListener2 extends BaseControllerListener2<ImageInfo> implements OnDrawControllerListener<ImageInfo>, Closeable {
    private static final int WHAT_STATUS = 1;
    private static final int WHAT_VISIBILITY = 2;
    private final Supplier<Boolean> mAsyncLogging;
    private final MonotonicClock mClock;
    private Handler mHandler;
    private final ImagePerfNotifier mImagePerfNotifier;
    private final ImagePerfState mImagePerfState;
    private final Supplier<Boolean> mUseNewState;

    static class LogHandler extends Handler {
        private final ImagePerfNotifier mNotifier;

        public LogHandler(Looper looper, ImagePerfNotifier imagePerfNotifier) {
            super(looper);
            this.mNotifier = imagePerfNotifier;
        }

        public void handleMessage(Message message) {
            ImagePerfState imagePerfState = (ImagePerfState) Preconditions.checkNotNull(message.obj);
            int i2 = message.what;
            if (i2 == 1) {
                this.mNotifier.notifyStatusUpdated(imagePerfState, message.arg1);
            } else if (i2 == 2) {
                this.mNotifier.notifyListenersOfVisibilityStateUpdate(imagePerfState, message.arg1);
            }
        }
    }

    public ImagePerfControllerListener2(MonotonicClock monotonicClock, ImagePerfState imagePerfState, ImagePerfNotifier imagePerfNotifier, Supplier<Boolean> supplier, Supplier<Boolean> supplier2) {
        this.mClock = monotonicClock;
        this.mImagePerfState = imagePerfState;
        this.mImagePerfNotifier = imagePerfNotifier;
        this.mAsyncLogging = supplier;
        this.mUseNewState = supplier2;
    }

    private synchronized void initHandler() {
        if (this.mHandler == null) {
            HandlerThread handlerThread = new HandlerThread("ImagePerfControllerListener2Thread");
            handlerThread.start();
            this.mHandler = new LogHandler((Looper) Preconditions.checkNotNull(handlerThread.getLooper()), this.mImagePerfNotifier);
        }
    }

    private ImagePerfState obtainState() {
        return this.mUseNewState.get().booleanValue() ? new ImagePerfState() : this.mImagePerfState;
    }

    private void reportViewInvisible(ImagePerfState imagePerfState, long j2) {
        imagePerfState.setVisible(false);
        imagePerfState.setInvisibilityEventTimeMs(j2);
        updateVisibility(imagePerfState, 2);
    }

    private boolean shouldDispatchAsync() {
        boolean booleanValue = this.mAsyncLogging.get().booleanValue();
        if (booleanValue && this.mHandler == null) {
            initHandler();
        }
        return booleanValue;
    }

    private void updateStatus(ImagePerfState imagePerfState, int i2) {
        if (shouldDispatchAsync()) {
            Message obtainMessage = ((Handler) Preconditions.checkNotNull(this.mHandler)).obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.arg1 = i2;
            obtainMessage.obj = imagePerfState;
            this.mHandler.sendMessage(obtainMessage);
            return;
        }
        this.mImagePerfNotifier.notifyStatusUpdated(imagePerfState, i2);
    }

    private void updateVisibility(ImagePerfState imagePerfState, int i2) {
        if (shouldDispatchAsync()) {
            Message obtainMessage = ((Handler) Preconditions.checkNotNull(this.mHandler)).obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = i2;
            obtainMessage.obj = imagePerfState;
            this.mHandler.sendMessage(obtainMessage);
            return;
        }
        this.mImagePerfNotifier.notifyListenersOfVisibilityStateUpdate(imagePerfState, i2);
    }

    public void close() {
        resetState();
    }

    public void onFailure(String str, Throwable th, ControllerListener2.Extras extras) {
        long now = this.mClock.now();
        ImagePerfState obtainState = obtainState();
        obtainState.setExtraData(extras);
        obtainState.setControllerFailureTimeMs(now);
        obtainState.setControllerId(str);
        obtainState.setErrorThrowable(th);
        updateStatus(obtainState, 5);
        reportViewInvisible(obtainState, now);
    }

    public void onRelease(String str, ControllerListener2.Extras extras) {
        long now = this.mClock.now();
        ImagePerfState obtainState = obtainState();
        obtainState.setExtraData(extras);
        obtainState.setControllerId(str);
        int imageLoadStatus = obtainState.getImageLoadStatus();
        if (!(imageLoadStatus == 3 || imageLoadStatus == 5 || imageLoadStatus == 6)) {
            obtainState.setControllerCancelTimeMs(now);
            updateStatus(obtainState, 4);
        }
        reportViewInvisible(obtainState, now);
    }

    public void onSubmit(String str, Object obj, ControllerListener2.Extras extras) {
        long now = this.mClock.now();
        ImagePerfState obtainState = obtainState();
        obtainState.resetPointsTimestamps();
        obtainState.setControllerSubmitTimeMs(now);
        obtainState.setControllerId(str);
        obtainState.setCallerContext(obj);
        obtainState.setExtraData(extras);
        updateStatus(obtainState, 0);
        reportViewVisible(obtainState, now);
    }

    public void reportViewVisible(ImagePerfState imagePerfState, long j2) {
        imagePerfState.setVisible(true);
        imagePerfState.setVisibilityEventTimeMs(j2);
        updateVisibility(imagePerfState, 1);
    }

    public void resetState() {
        obtainState().reset();
    }

    public void onFinalImageSet(String str, ImageInfo imageInfo, ControllerListener2.Extras extras) {
        long now = this.mClock.now();
        ImagePerfState obtainState = obtainState();
        obtainState.setExtraData(extras);
        obtainState.setControllerFinalImageSetTimeMs(now);
        obtainState.setImageRequestEndTimeMs(now);
        obtainState.setControllerId(str);
        obtainState.setImageInfo(imageInfo);
        updateStatus(obtainState, 3);
    }

    public void onImageDrawn(String str, ImageInfo imageInfo, DimensionsInfo dimensionsInfo) {
        ImagePerfState obtainState = obtainState();
        obtainState.setControllerId(str);
        obtainState.setImageDrawTimeMs(this.mClock.now());
        obtainState.setDimensionsInfo(dimensionsInfo);
        updateStatus(obtainState, 6);
    }

    public void onIntermediateImageSet(String str, ImageInfo imageInfo) {
        long now = this.mClock.now();
        ImagePerfState obtainState = obtainState();
        obtainState.setControllerIntermediateImageSetTimeMs(now);
        obtainState.setControllerId(str);
        obtainState.setImageInfo(imageInfo);
        updateStatus(obtainState, 2);
    }
}

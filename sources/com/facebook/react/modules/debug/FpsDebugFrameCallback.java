package com.facebook.react.modules.debug;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.ChoreographerCompat;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import java.util.Map;
import java.util.TreeMap;

public class FpsDebugFrameCallback extends ChoreographerCompat.FrameCallback {
    private static final double EXPECTED_FRAME_TIME = 16.9d;
    private int m4PlusFrameStutters = 0;
    /* access modifiers changed from: private */
    public ChoreographerCompat mChoreographer;
    private final DidJSUpdateUiDuringFrameDetector mDidJSUpdateUiDuringFrameDetector;
    private int mExpectedNumFramesPrev = 0;
    private long mFirstFrameTime = -1;
    private boolean mIsRecordingFpsInfoAtEachFrame = false;
    private long mLastFrameTime = -1;
    private int mNumFrameCallbacks = 0;
    private int mNumFrameCallbacksWithBatchDispatches = 0;
    private final ReactContext mReactContext;
    private boolean mShouldStop = false;
    private TreeMap<Long, FpsInfo> mTimeToFps;
    private final UIManagerModule mUIManagerModule;

    public static class FpsInfo {
        public final double fps;
        public final double jsFps;
        public final int total4PlusFrameStutters;
        public final int totalExpectedFrames;
        public final int totalFrames;
        public final int totalJsFrames;
        public final int totalTimeMs;

        public FpsInfo(int i2, int i3, int i4, int i5, double d2, double d3, int i6) {
            this.totalFrames = i2;
            this.totalJsFrames = i3;
            this.totalExpectedFrames = i4;
            this.total4PlusFrameStutters = i5;
            this.fps = d2;
            this.jsFps = d3;
            this.totalTimeMs = i6;
        }
    }

    public FpsDebugFrameCallback(ReactContext reactContext) {
        this.mReactContext = reactContext;
        this.mUIManagerModule = (UIManagerModule) Assertions.assertNotNull((UIManagerModule) reactContext.getNativeModule(UIManagerModule.class));
        this.mDidJSUpdateUiDuringFrameDetector = new DidJSUpdateUiDuringFrameDetector();
    }

    public void doFrame(long j2) {
        if (!this.mShouldStop) {
            if (this.mFirstFrameTime == -1) {
                this.mFirstFrameTime = j2;
            }
            long j3 = this.mLastFrameTime;
            this.mLastFrameTime = j2;
            if (this.mDidJSUpdateUiDuringFrameDetector.getDidJSHitFrameAndCleanup(j3, j2)) {
                this.mNumFrameCallbacksWithBatchDispatches++;
            }
            this.mNumFrameCallbacks++;
            int expectedNumFrames = getExpectedNumFrames();
            if ((expectedNumFrames - this.mExpectedNumFramesPrev) - 1 >= 4) {
                this.m4PlusFrameStutters++;
            }
            if (this.mIsRecordingFpsInfoAtEachFrame) {
                Assertions.assertNotNull(this.mTimeToFps);
                this.mTimeToFps.put(Long.valueOf(System.currentTimeMillis()), new FpsInfo(getNumFrames(), getNumJSFrames(), expectedNumFrames, this.m4PlusFrameStutters, getFPS(), getJSFPS(), getTotalTimeMS()));
            }
            this.mExpectedNumFramesPrev = expectedNumFrames;
            ChoreographerCompat choreographerCompat = this.mChoreographer;
            if (choreographerCompat != null) {
                choreographerCompat.postFrameCallback(this);
            }
        }
    }

    public int get4PlusFrameStutters() {
        return this.m4PlusFrameStutters;
    }

    public int getExpectedNumFrames() {
        return (int) ((((double) getTotalTimeMS()) / EXPECTED_FRAME_TIME) + 1.0d);
    }

    public double getFPS() {
        if (this.mLastFrameTime == this.mFirstFrameTime) {
            return 0.0d;
        }
        return (((double) getNumFrames()) * 1.0E9d) / ((double) (this.mLastFrameTime - this.mFirstFrameTime));
    }

    public FpsInfo getFpsInfo(long j2) {
        Assertions.assertNotNull(this.mTimeToFps, "FPS was not recorded at each frame!");
        Map.Entry<Long, FpsInfo> floorEntry = this.mTimeToFps.floorEntry(Long.valueOf(j2));
        if (floorEntry == null) {
            return null;
        }
        return floorEntry.getValue();
    }

    public double getJSFPS() {
        if (this.mLastFrameTime == this.mFirstFrameTime) {
            return 0.0d;
        }
        return (((double) getNumJSFrames()) * 1.0E9d) / ((double) (this.mLastFrameTime - this.mFirstFrameTime));
    }

    public int getNumFrames() {
        return this.mNumFrameCallbacks - 1;
    }

    public int getNumJSFrames() {
        return this.mNumFrameCallbacksWithBatchDispatches - 1;
    }

    public int getTotalTimeMS() {
        return ((int) (((double) this.mLastFrameTime) - ((double) this.mFirstFrameTime))) / 1000000;
    }

    public void reset() {
        this.mFirstFrameTime = -1;
        this.mLastFrameTime = -1;
        this.mNumFrameCallbacks = 0;
        this.m4PlusFrameStutters = 0;
        this.mNumFrameCallbacksWithBatchDispatches = 0;
        this.mIsRecordingFpsInfoAtEachFrame = false;
        this.mTimeToFps = null;
    }

    public void start() {
        this.mShouldStop = false;
        this.mReactContext.getCatalystInstance().addBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
        this.mUIManagerModule.setViewHierarchyUpdateDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                ChoreographerCompat unused = FpsDebugFrameCallback.this.mChoreographer = ChoreographerCompat.getInstance();
                FpsDebugFrameCallback.this.mChoreographer.postFrameCallback(this);
            }
        });
    }

    public void startAndRecordFpsAtEachFrame() {
        this.mTimeToFps = new TreeMap<>();
        this.mIsRecordingFpsInfoAtEachFrame = true;
        start();
    }

    public void stop() {
        this.mShouldStop = true;
        this.mReactContext.getCatalystInstance().removeBridgeIdleDebugListener(this.mDidJSUpdateUiDuringFrameDetector);
        this.mUIManagerModule.setViewHierarchyUpdateDebugListener((NotThreadSafeViewHierarchyUpdateDebugListener) null);
    }
}

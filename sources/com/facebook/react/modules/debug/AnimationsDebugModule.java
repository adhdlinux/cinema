package com.facebook.react.modules.debug;

import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeAnimationsDebugModuleSpec;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.debug.FpsDebugFrameCallback;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import java.util.Locale;

@ReactModule(name = "AnimationsDebugModule")
public class AnimationsDebugModule extends NativeAnimationsDebugModuleSpec {
    protected static final String NAME = "AnimationsDebugModule";
    private final DeveloperSettings mCatalystSettings;
    private FpsDebugFrameCallback mFrameCallback;

    public AnimationsDebugModule(ReactApplicationContext reactApplicationContext, DeveloperSettings developerSettings) {
        super(reactApplicationContext);
        this.mCatalystSettings = developerSettings;
    }

    public String getName() {
        return NAME;
    }

    public void invalidate() {
        FpsDebugFrameCallback fpsDebugFrameCallback = this.mFrameCallback;
        if (fpsDebugFrameCallback != null) {
            fpsDebugFrameCallback.stop();
            this.mFrameCallback = null;
        }
    }

    public void startRecordingFps() {
        DeveloperSettings developerSettings = this.mCatalystSettings;
        if (developerSettings != null && developerSettings.isAnimationFpsDebugEnabled()) {
            if (this.mFrameCallback == null) {
                FpsDebugFrameCallback fpsDebugFrameCallback = new FpsDebugFrameCallback(getReactApplicationContext());
                this.mFrameCallback = fpsDebugFrameCallback;
                fpsDebugFrameCallback.startAndRecordFpsAtEachFrame();
                return;
            }
            throw new JSApplicationCausedNativeException("Already recording FPS!");
        }
    }

    public void stopRecordingFps(double d2) {
        FpsDebugFrameCallback fpsDebugFrameCallback = this.mFrameCallback;
        if (fpsDebugFrameCallback != null) {
            fpsDebugFrameCallback.stop();
            FpsDebugFrameCallback.FpsInfo fpsInfo = this.mFrameCallback.getFpsInfo((long) d2);
            if (fpsInfo == null) {
                Toast.makeText(getReactApplicationContext(), "Unable to get FPS info", 1);
            } else {
                Locale locale = Locale.US;
                String str = String.format(locale, "FPS: %.2f, %d frames (%d expected)", new Object[]{Double.valueOf(fpsInfo.fps), Integer.valueOf(fpsInfo.totalFrames), Integer.valueOf(fpsInfo.totalExpectedFrames)}) + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE + String.format(locale, "JS FPS: %.2f, %d frames (%d expected)", new Object[]{Double.valueOf(fpsInfo.jsFps), Integer.valueOf(fpsInfo.totalJsFrames), Integer.valueOf(fpsInfo.totalExpectedFrames)}) + "\nTotal Time MS: " + String.format(locale, "%d", new Object[]{Integer.valueOf(fpsInfo.totalTimeMs)});
                FLog.d(ReactConstants.TAG, str);
                Toast.makeText(getReactApplicationContext(), str, 1).show();
            }
            this.mFrameCallback = null;
        }
    }
}

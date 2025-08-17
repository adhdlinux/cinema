package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import java.util.Map;

@ReactModule(name = "StatusBarManager")
public class StatusBarModule extends NativeStatusBarManagerAndroidSpec {
    private static final String DEFAULT_BACKGROUND_COLOR_KEY = "DEFAULT_BACKGROUND_COLOR";
    private static final String HEIGHT_KEY = "HEIGHT";
    public static final String NAME = "StatusBarManager";

    public StatusBarModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return NAME;
    }

    public Map<String, Object> getTypedExportedConstants() {
        float f2;
        String str;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Activity currentActivity = getCurrentActivity();
        int identifier = reactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            f2 = PixelUtil.toDIPFromPixel((float) reactApplicationContext.getResources().getDimensionPixelSize(identifier));
        } else {
            f2 = 0.0f;
        }
        if (currentActivity != null) {
            str = String.format("#%06X", new Object[]{Integer.valueOf(currentActivity.getWindow().getStatusBarColor() & 16777215)});
        } else {
            str = "black";
        }
        return MapBuilder.of(HEIGHT_KEY, Float.valueOf(f2), DEFAULT_BACKGROUND_COLOR_KEY, str);
    }

    public void setColor(double d2, boolean z2) {
        final int i2 = (int) d2;
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
            return;
        }
        final boolean z3 = z2;
        UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {
            @TargetApi(21)
            public void runGuarded() {
                currentActivity.getWindow().addFlags(Integer.MIN_VALUE);
                if (z3) {
                    int statusBarColor = currentActivity.getWindow().getStatusBarColor();
                    ValueAnimator ofObject = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(statusBarColor), Integer.valueOf(i2)});
                    ofObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            currentActivity.getWindow().setStatusBarColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                        }
                    });
                    ofObject.setDuration(300).setStartDelay(0);
                    ofObject.start();
                    return;
                }
                currentActivity.getWindow().setStatusBarColor(i2);
            }
        });
    }

    public void setHidden(final boolean z2) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    if (z2) {
                        currentActivity.getWindow().addFlags(1024);
                        currentActivity.getWindow().clearFlags(2048);
                        return;
                    }
                    currentActivity.getWindow().addFlags(2048);
                    currentActivity.getWindow().clearFlags(1024);
                }
            });
        }
    }

    public void setStyle(final String str) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                @TargetApi(30)
                public void run() {
                    int i2;
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 > 30) {
                        WindowInsetsController a2 = currentActivity.getWindow().getInsetsController();
                        if ("dark-content".equals(str)) {
                            a2.setSystemBarsAppearance(8, 8);
                        } else {
                            a2.setSystemBarsAppearance(0, 8);
                        }
                    } else if (i3 >= 23) {
                        View decorView = currentActivity.getWindow().getDecorView();
                        int systemUiVisibility = decorView.getSystemUiVisibility();
                        if ("dark-content".equals(str)) {
                            i2 = systemUiVisibility | 8192;
                        } else {
                            i2 = systemUiVisibility & -8193;
                        }
                        decorView.setSystemUiVisibility(i2);
                    }
                }
            });
        }
    }

    public void setTranslucent(final boolean z2) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.w(ReactConstants.TAG, "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) {
                @TargetApi(21)
                public void runGuarded() {
                    View decorView = currentActivity.getWindow().getDecorView();
                    if (z2) {
                        decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                                WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
                                return onApplyWindowInsets.replaceSystemWindowInsets(onApplyWindowInsets.getSystemWindowInsetLeft(), 0, onApplyWindowInsets.getSystemWindowInsetRight(), onApplyWindowInsets.getSystemWindowInsetBottom());
                            }
                        });
                    } else {
                        decorView.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) null);
                    }
                    ViewCompat.o0(decorView);
                }
            });
        }
    }
}

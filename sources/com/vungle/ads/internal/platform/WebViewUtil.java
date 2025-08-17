package com.vungle.ads.internal.platform;

import android.content.Context;
import android.util.AndroidRuntimeException;
import android.webkit.WebSettings;
import androidx.core.util.Consumer;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class WebViewUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = WebViewUtil.class.getSimpleName();
    private final Context context;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WebViewUtil(Context context2) {
        Intrinsics.f(context2, "context");
        this.context = context2;
    }

    public final void getUserAgent(Consumer<String> consumer) {
        Intrinsics.f(consumer, "consumer");
        try {
            consumer.accept(WebSettings.getDefaultUserAgent(this.context));
        } catch (Exception e2) {
            if (e2 instanceof AndroidRuntimeException) {
                Logger.Companion companion = Logger.Companion;
                String str = TAG;
                Intrinsics.e(str, "TAG");
                companion.e(str, "WebView could be missing here");
            }
            consumer.accept(null);
        }
    }
}

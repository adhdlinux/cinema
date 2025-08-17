package androidx.webkit;

import androidx.webkit.internal.WebViewFeatureInternal;

public class WebViewFeature {
    private WebViewFeature() {
    }

    public static boolean a(String str) {
        return WebViewFeatureInternal.b(str);
    }
}

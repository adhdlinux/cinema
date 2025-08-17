package com.unity3d.services.core.webview;

import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WebViewUrlBuilder {
    private final SDKMetricsSender _sdkMetricsSender;
    private final String _urlWithQueryString;

    public WebViewUrlBuilder(String str, Configuration configuration) {
        SDKMetricsSender sDKMetricsSender = (SDKMetricsSender) Utilities.getService(SDKMetricsSender.class);
        this._sdkMetricsSender = sDKMetricsSender;
        this._urlWithQueryString = str + ((("?platform=android" + buildQueryParam("origin", configuration.getWebViewUrl())) + buildQueryParam(MediationMetaData.KEY_VERSION, configuration.getWebViewVersion())) + buildQueryParam("isNativeCollectingMetrics", String.valueOf(sDKMetricsSender.areMetricsEnabledForCurrentSession())));
    }

    private String buildQueryParam(String str, String str2) {
        if (str2 == null) {
            return "";
        }
        try {
            return "" + "&" + str + "=" + URLEncoder.encode(str2, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            DeviceLog.exception(String.format("Unsupported charset when encoding %s", new Object[]{str}), e2);
            return "";
        }
    }

    public String getUrlWithQueryString() {
        return this._urlWithQueryString;
    }
}

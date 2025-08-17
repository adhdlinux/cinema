package com.unity3d.services.core.configuration;

import java.util.Map;
import org.json.JSONObject;

public interface IExperiments {
    JSONObject getCurrentSessionExperiments();

    Map<String, String> getExperimentTags();

    JSONObject getExperimentsAsJson();

    JSONObject getNextSessionExperiments();

    String getScarBiddingManager();

    boolean isJetpackLifecycle();

    boolean isNativeWebViewCacheEnabled();

    boolean isOkHttpEnabled();

    boolean isScarInitEnabled();

    boolean isWebAssetAdCaching();

    boolean isWebGestureNotRequired();

    boolean isWebMessageEnabled();

    boolean isWebViewAsyncDownloadEnabled();

    boolean shouldNativeTokenAwaitPrivacy();
}

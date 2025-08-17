package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.STRICT)
public class BaseRequestListener implements RequestListener {
    public void onProducerEvent(String str, String str2, String str3) {
    }

    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
    }

    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
    }

    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
    }

    public void onProducerStart(String str, String str2) {
    }

    public void onRequestCancellation(String str) {
    }

    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z2) {
    }

    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z2) {
    }

    public void onUltimateProducerReached(String str, String str2, boolean z2) {
    }

    public boolean requiresExtraMap(String str) {
        return false;
    }
}

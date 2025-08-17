package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

public interface RequestListener extends ProducerListener {
    void onRequestCancellation(String str);

    void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z2);

    void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z2);

    void onRequestSuccess(ImageRequest imageRequest, String str, boolean z2);
}

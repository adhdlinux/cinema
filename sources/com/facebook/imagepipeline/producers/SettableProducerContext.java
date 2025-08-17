package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfigInterface;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class SettableProducerContext extends BaseProducerContext {
    public SettableProducerContext(ProducerContext producerContext) {
        this(producerContext.getImageRequest(), producerContext.getId(), producerContext.getUiComponentId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), producerContext.isPrefetch(), producerContext.isIntermediateResultExpected(), producerContext.getPriority(), producerContext.getImagePipelineConfig());
    }

    public void setIsIntermediateResultExpected(boolean z2) {
        BaseProducerContext.callOnIsIntermediateResultExpectedChanged(setIsIntermediateResultExpectedNoCallbacks(z2));
    }

    public void setIsPrefetch(boolean z2) {
        BaseProducerContext.callOnIsPrefetchChanged(setIsPrefetchNoCallbacks(z2));
    }

    public void setPriority(Priority priority) {
        BaseProducerContext.callOnPriorityChanged(setPriorityNoCallbacks(priority));
    }

    public SettableProducerContext(ImageRequest imageRequest, ProducerContext producerContext) {
        this(imageRequest, producerContext.getId(), producerContext.getUiComponentId(), producerContext.getProducerListener(), producerContext.getCallerContext(), producerContext.getLowestPermittedRequestLevel(), producerContext.isPrefetch(), producerContext.isIntermediateResultExpected(), producerContext.getPriority(), producerContext.getImagePipelineConfig());
    }

    public SettableProducerContext(ImageRequest imageRequest, String str, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z2, boolean z3, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        super(imageRequest, str, producerListener2, obj, requestLevel, z2, z3, priority, imagePipelineConfigInterface);
    }

    public SettableProducerContext(ImageRequest imageRequest, String str, String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z2, boolean z3, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        super(imageRequest, str, str2, producerListener2, obj, requestLevel, z2, z3, priority, imagePipelineConfigInterface);
    }
}

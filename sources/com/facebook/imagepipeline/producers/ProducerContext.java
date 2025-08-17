package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfigInterface;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.STRICT)
public interface ProducerContext {

    public @interface ExtraKeys {
        public static final String ENCODED_HEIGHT = "encoded_height";
        public static final String ENCODED_SIZE = "encoded_size";
        public static final String ENCODED_WIDTH = "encoded_width";
        public static final String IMAGE_FORMAT = "image_format";
        public static final String MULTIPLEX_BITMAP_COUNT = "multiplex_bmp_cnt";
        public static final String MULTIPLEX_ENCODED_COUNT = "multiplex_enc_cnt";
        public static final String NORMALIZED_URI = "uri_norm";
        public static final String ORIGIN = "origin";
        public static final String ORIGIN_SUBCATEGORY = "origin_sub";
        public static final String SOURCE_URI = "uri_source";
    }

    void addCallbacks(ProducerContextCallbacks producerContextCallbacks);

    Object getCallerContext();

    EncodedImageOrigin getEncodedImageOrigin();

    <E> E getExtra(String str);

    <E> E getExtra(String str, E e2);

    Map<String, Object> getExtras();

    String getId();

    ImagePipelineConfigInterface getImagePipelineConfig();

    ImageRequest getImageRequest();

    ImageRequest.RequestLevel getLowestPermittedRequestLevel();

    Priority getPriority();

    ProducerListener2 getProducerListener();

    String getUiComponentId();

    boolean isIntermediateResultExpected();

    boolean isPrefetch();

    void putExtras(Map<String, ?> map);

    void putOriginExtra(String str);

    void putOriginExtra(String str, String str2);

    void setEncodedImageOrigin(EncodedImageOrigin encodedImageOrigin);

    <E> void setExtra(String str, E e2);
}

package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
    private CloseableProducerToDataSourceAdapter(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        super(producer, settableProducerContext, requestListener2);
    }

    public static <T> DataSource<CloseableReference<T>> create(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener2 requestListener2) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("CloseableProducerToDataSourceAdapter#create");
        }
        CloseableProducerToDataSourceAdapter closeableProducerToDataSourceAdapter = new CloseableProducerToDataSourceAdapter(producer, settableProducerContext, requestListener2);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        return closeableProducerToDataSourceAdapter;
    }

    /* access modifiers changed from: protected */
    public void closeResult(CloseableReference<T> closeableReference) {
        CloseableReference.closeSafely((CloseableReference<?>) closeableReference);
    }

    public CloseableReference<T> getResult() {
        return CloseableReference.cloneOrNull((CloseableReference) super.getResult());
    }

    /* access modifiers changed from: protected */
    public void onNewResultImpl(CloseableReference<T> closeableReference, int i2, ProducerContext producerContext) {
        super.onNewResultImpl(CloseableReference.cloneOrNull(closeableReference), i2, producerContext);
    }
}

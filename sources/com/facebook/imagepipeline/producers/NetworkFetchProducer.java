package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.EncodedImageOrigin;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class NetworkFetchProducer implements Producer<EncodedImage> {
    public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
    public static final String PRODUCER_NAME = "NetworkFetchProducer";
    private static final int READ_SIZE = 16384;
    static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100;
    private final ByteArrayPool mByteArrayPool;
    private final NetworkFetcher mNetworkFetcher;
    protected final PooledByteBufferFactory mPooledByteBufferFactory;

    public NetworkFetchProducer(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        this.mPooledByteBufferFactory = pooledByteBufferFactory;
        this.mByteArrayPool = byteArrayPool;
        this.mNetworkFetcher = networkFetcher;
    }

    protected static float calculateProgress(int i2, int i3) {
        return i3 > 0 ? ((float) i2) / ((float) i3) : 1.0f - ((float) Math.exp(((double) (-i2)) / 50000.0d));
    }

    private Map<String, String> getExtraMap(FetchState fetchState, int i2) {
        if (!fetchState.getListener().requiresExtraMap(fetchState.getContext(), PRODUCER_NAME)) {
            return null;
        }
        return this.mNetworkFetcher.getExtraMap(fetchState, i2);
    }

    protected static void notifyConsumer(PooledByteBufferOutputStream pooledByteBufferOutputStream, int i2, BytesRange bytesRange, Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        CloseableReference of = CloseableReference.of(pooledByteBufferOutputStream.toByteBuffer());
        EncodedImage encodedImage = null;
        try {
            EncodedImage encodedImage2 = new EncodedImage((CloseableReference<PooledByteBuffer>) of);
            try {
                encodedImage2.setBytesRange(bytesRange);
                encodedImage2.parseMetaData();
                producerContext.setEncodedImageOrigin(EncodedImageOrigin.NETWORK);
                consumer.onNewResult(encodedImage2, i2);
                EncodedImage.closeSafely(encodedImage2);
                CloseableReference.closeSafely((CloseableReference<?>) of);
            } catch (Throwable th) {
                th = th;
                encodedImage = encodedImage2;
                EncodedImage.closeSafely(encodedImage);
                CloseableReference.closeSafely((CloseableReference<?>) of);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            EncodedImage.closeSafely(encodedImage);
            CloseableReference.closeSafely((CloseableReference<?>) of);
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public void onCancellation(FetchState fetchState) {
        fetchState.getListener().onProducerFinishWithCancellation(fetchState.getContext(), PRODUCER_NAME, (Map<String, String>) null);
        fetchState.getConsumer().onCancellation();
    }

    /* access modifiers changed from: private */
    public void onFailure(FetchState fetchState, Throwable th) {
        fetchState.getListener().onProducerFinishWithFailure(fetchState.getContext(), PRODUCER_NAME, th, (Map<String, String>) null);
        fetchState.getListener().onUltimateProducerReached(fetchState.getContext(), PRODUCER_NAME, false);
        fetchState.getContext().putOriginExtra("network");
        fetchState.getConsumer().onFailure(th);
    }

    private boolean shouldPropagateIntermediateResults(FetchState fetchState) {
        if (!fetchState.getContext().isIntermediateResultExpected()) {
            return false;
        }
        return this.mNetworkFetcher.shouldPropagate(fetchState);
    }

    /* access modifiers changed from: protected */
    public long getSystemUptime() {
        return SystemClock.uptimeMillis();
    }

    /* access modifiers changed from: protected */
    public void handleFinalResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        Map<String, String> extraMap = getExtraMap(fetchState, pooledByteBufferOutputStream.size());
        ProducerListener2 listener = fetchState.getListener();
        listener.onProducerFinishWithSuccess(fetchState.getContext(), PRODUCER_NAME, extraMap);
        listener.onUltimateProducerReached(fetchState.getContext(), PRODUCER_NAME, true);
        fetchState.getContext().putOriginExtra("network");
        notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags() | 1, fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
    }

    /* access modifiers changed from: protected */
    public void maybeHandleIntermediateResult(PooledByteBufferOutputStream pooledByteBufferOutputStream, FetchState fetchState) {
        long systemUptime = getSystemUptime();
        if (shouldPropagateIntermediateResults(fetchState) && systemUptime - fetchState.getLastIntermediateResultTimeMs() >= TIME_BETWEEN_PARTIAL_RESULTS_MS) {
            fetchState.setLastIntermediateResultTimeMs(systemUptime);
            fetchState.getListener().onProducerEvent(fetchState.getContext(), PRODUCER_NAME, INTERMEDIATE_RESULT_PRODUCER_EVENT);
            notifyConsumer(pooledByteBufferOutputStream, fetchState.getOnNewResultStatusFlags(), fetchState.getResponseBytesRange(), fetchState.getConsumer(), fetchState.getContext());
        }
    }

    /* access modifiers changed from: protected */
    public void onResponse(FetchState fetchState, InputStream inputStream, int i2) throws IOException {
        PooledByteBufferOutputStream pooledByteBufferOutputStream;
        if (i2 > 0) {
            pooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream(i2);
        } else {
            pooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream();
        }
        byte[] bArr = (byte[]) this.mByteArrayPool.get(16384);
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    this.mNetworkFetcher.onFetchCompletion(fetchState, pooledByteBufferOutputStream.size());
                    handleFinalResult(pooledByteBufferOutputStream, fetchState);
                    return;
                } else if (read > 0) {
                    pooledByteBufferOutputStream.write(bArr, 0, read);
                    maybeHandleIntermediateResult(pooledByteBufferOutputStream, fetchState);
                    fetchState.getConsumer().onProgressUpdate(calculateProgress(pooledByteBufferOutputStream.size(), i2));
                }
            } finally {
                this.mByteArrayPool.release(bArr);
                pooledByteBufferOutputStream.close();
            }
        }
    }

    public void produceResults(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        producerContext.getProducerListener().onProducerStart(producerContext, PRODUCER_NAME);
        final FetchState createFetchState = this.mNetworkFetcher.createFetchState(consumer, producerContext);
        this.mNetworkFetcher.fetch(createFetchState, new NetworkFetcher.Callback() {
            public void onCancellation() {
                NetworkFetchProducer.this.onCancellation(createFetchState);
            }

            public void onFailure(Throwable th) {
                NetworkFetchProducer.this.onFailure(createFetchState, th);
            }

            public void onResponse(InputStream inputStream, int i2) throws IOException {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("NetworkFetcher->onResponse");
                }
                NetworkFetchProducer.this.onResponse(createFetchState, inputStream, i2);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        });
    }
}

package com.facebook.imagepipeline.backends.okhttp3;

import android.os.Looper;
import android.os.SystemClock;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {
    private static final String FETCH_TIME = "fetch_time";
    private static final String IMAGE_SIZE = "image_size";
    private static final String QUEUE_TIME = "queue_time";
    private static final String TOTAL_TIME = "total_time";
    private final CacheControl mCacheControl;
    private final Call.Factory mCallFactory;
    /* access modifiers changed from: private */
    public Executor mCancellationExecutor;

    public static class OkHttpNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public OkHttpNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public OkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
    }

    /* access modifiers changed from: private */
    public void handleException(Call call, Exception exc, NetworkFetcher.Callback callback) {
        if (call.isCanceled()) {
            callback.onCancellation();
        } else {
            callback.onFailure(exc);
        }
    }

    /* access modifiers changed from: protected */
    public void fetchWithRequest(final OkHttpNetworkFetchState okHttpNetworkFetchState, final NetworkFetcher.Callback callback, Request request) {
        final Call newCall = this.mCallFactory.newCall(request);
        okHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {
            public void onCancellationRequested() {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    newCall.cancel();
                } else {
                    OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new Runnable() {
                        public void run() {
                            newCall.cancel();
                        }
                    });
                }
            }
        });
        newCall.enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
                OkHttpNetworkFetcher.this.handleException(call, iOException, callback);
            }

            public void onResponse(Call call, Response response) throws IOException {
                okHttpNetworkFetchState.responseTime = SystemClock.elapsedRealtime();
                ResponseBody body = response.body();
                if (body == null) {
                    OkHttpNetworkFetcher.this.handleException(call, new IOException("Response body null: " + response), callback);
                    return;
                }
                try {
                    if (!response.isSuccessful()) {
                        OkHttpNetworkFetcher.this.handleException(call, new IOException("Unexpected HTTP code " + response), callback);
                        body.close();
                        return;
                    }
                    BytesRange fromContentRangeHeader = BytesRange.fromContentRangeHeader(response.header("Content-Range"));
                    if (!(fromContentRangeHeader == null || (fromContentRangeHeader.from == 0 && fromContentRangeHeader.to == Integer.MAX_VALUE))) {
                        okHttpNetworkFetchState.setResponseBytesRange(fromContentRangeHeader);
                        okHttpNetworkFetchState.setOnNewResultStatusFlags(8);
                    }
                    long contentLength = body.contentLength();
                    if (contentLength < 0) {
                        contentLength = 0;
                    }
                    callback.onResponse(body.byteStream(), (int) contentLength);
                    body.close();
                } catch (Exception e2) {
                    OkHttpNetworkFetcher.this.handleException(call, e2, callback);
                } catch (Throwable th) {
                    body.close();
                    throw th;
                }
            }
        });
    }

    public OkHttpNetworkFetcher(Call.Factory factory, Executor executor) {
        this(factory, executor, true);
    }

    public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new OkHttpNetworkFetchState(consumer, producerContext);
    }

    public void fetch(OkHttpNetworkFetchState okHttpNetworkFetchState, NetworkFetcher.Callback callback) {
        okHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
        try {
            Request.Builder builder = new Request.Builder().url(okHttpNetworkFetchState.getUri().toString()).get();
            CacheControl cacheControl = this.mCacheControl;
            if (cacheControl != null) {
                builder.cacheControl(cacheControl);
            }
            BytesRange bytesRange = okHttpNetworkFetchState.getContext().getImageRequest().getBytesRange();
            if (bytesRange != null) {
                builder.addHeader("Range", bytesRange.toHttpRangeHeaderValue());
            }
            fetchWithRequest(okHttpNetworkFetchState, callback, builder.build());
        } catch (Exception e2) {
            callback.onFailure(e2);
        }
    }

    public Map<String, String> getExtraMap(OkHttpNetworkFetchState okHttpNetworkFetchState, int i2) {
        HashMap hashMap = new HashMap(4);
        hashMap.put(QUEUE_TIME, Long.toString(okHttpNetworkFetchState.responseTime - okHttpNetworkFetchState.submitTime));
        hashMap.put(FETCH_TIME, Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.responseTime));
        hashMap.put(TOTAL_TIME, Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.submitTime));
        hashMap.put(IMAGE_SIZE, Integer.toString(i2));
        return hashMap;
    }

    public void onFetchCompletion(OkHttpNetworkFetchState okHttpNetworkFetchState, int i2) {
        okHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
    }

    public OkHttpNetworkFetcher(Call.Factory factory, Executor executor, boolean z2) {
        this.mCallFactory = factory;
        this.mCancellationExecutor = executor;
        this.mCacheControl = z2 ? new CacheControl.Builder().noStore().build() : null;
    }
}

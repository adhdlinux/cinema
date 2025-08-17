package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ForwardingRequestListener implements RequestListener {
    private static final String TAG = "ForwardingRequestListener";
    private final List<RequestListener> mRequestListeners;

    public ForwardingRequestListener(Set<RequestListener> set) {
        this.mRequestListeners = new ArrayList(set.size());
        for (RequestListener next : set) {
            if (next != null) {
                this.mRequestListeners.add(next);
            }
        }
    }

    private void onException(String str, Throwable th) {
        FLog.e(TAG, str, th);
    }

    public void addRequestListener(RequestListener requestListener) {
        this.mRequestListeners.add(requestListener);
    }

    public void onProducerEvent(String str, String str2, String str3) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onProducerEvent(str, str2, str3);
            } catch (Exception e2) {
                onException("InternalListener exception in onIntermediateChunkStart", e2);
            }
        }
    }

    public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onProducerFinishWithCancellation(str, str2, map);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerFinishWithCancellation", e2);
            }
        }
    }

    public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onProducerFinishWithFailure(str, str2, th, map);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerFinishWithFailure", e2);
            }
        }
    }

    public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onProducerFinishWithSuccess(str, str2, map);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    public void onProducerStart(String str, String str2) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onProducerStart(str, str2);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerStart", e2);
            }
        }
    }

    public void onRequestCancellation(String str) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onRequestCancellation(str);
            } catch (Exception e2) {
                onException("InternalListener exception in onRequestCancellation", e2);
            }
        }
    }

    public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onRequestFailure(imageRequest, str, th, z2);
            } catch (Exception e2) {
                onException("InternalListener exception in onRequestFailure", e2);
            }
        }
    }

    public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onRequestStart(imageRequest, obj, str, z2);
            } catch (Exception e2) {
                onException("InternalListener exception in onRequestStart", e2);
            }
        }
    }

    public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z2) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onRequestSuccess(imageRequest, str, z2);
            } catch (Exception e2) {
                onException("InternalListener exception in onRequestSuccess", e2);
            }
        }
    }

    public void onUltimateProducerReached(String str, String str2, boolean z2) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                this.mRequestListeners.get(i2).onUltimateProducerReached(str, str2, z2);
            } catch (Exception e2) {
                onException("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    public boolean requiresExtraMap(String str) {
        int size = this.mRequestListeners.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mRequestListeners.get(i2).requiresExtraMap(str)) {
                return true;
            }
        }
        return false;
    }

    public ForwardingRequestListener(RequestListener... requestListenerArr) {
        this.mRequestListeners = new ArrayList(requestListenerArr.length);
        for (RequestListener requestListener : requestListenerArr) {
            if (requestListener != null) {
                this.mRequestListeners.add(requestListener);
            }
        }
    }
}

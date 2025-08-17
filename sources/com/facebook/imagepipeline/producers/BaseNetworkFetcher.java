package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;

@Nullsafe(Nullsafe.Mode.STRICT)
public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<FETCH_STATE> {
    public Map<String, String> getExtraMap(FETCH_STATE fetch_state, int i2) {
        return null;
    }

    public void onFetchCompletion(FETCH_STATE fetch_state, int i2) {
    }

    public boolean shouldPropagate(FETCH_STATE fetch_state) {
        return true;
    }
}

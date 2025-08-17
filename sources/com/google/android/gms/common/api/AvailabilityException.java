package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public class AvailabilityException extends Exception {
    private final ArrayMap zaa;

    public AvailabilityException(ArrayMap arrayMap) {
        this.zaa = arrayMap;
    }

    public ConnectionResult getConnectionResult(GoogleApi<? extends Api.ApiOptions> googleApi) {
        ApiKey<? extends Api.ApiOptions> apiKey = googleApi.getApiKey();
        boolean z2 = this.zaa.get(apiKey) != null;
        String zaa2 = apiKey.zaa();
        Preconditions.checkArgument(z2, "The given API (" + zaa2 + ") was not part of the availability request.");
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (ApiKey apiKey : this.zaa.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
            z2 &= !connectionResult.isSuccess();
            String zaa2 = apiKey.zaa();
            String valueOf = String.valueOf(connectionResult);
            arrayList.add(zaa2 + ": " + valueOf);
        }
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append("None of the queried APIs are available. ");
        } else {
            sb.append("Some of the queried APIs are unavailable. ");
        }
        sb.append(TextUtils.join("; ", arrayList));
        return sb.toString();
    }

    public ConnectionResult getConnectionResult(HasApiKey<? extends Api.ApiOptions> hasApiKey) {
        ApiKey<? extends Api.ApiOptions> apiKey = hasApiKey.getApiKey();
        boolean z2 = this.zaa.get(apiKey) != null;
        String zaa2 = apiKey.zaa();
        Preconditions.checkArgument(z2, "The given API (" + zaa2 + ") was not part of the availability request.");
        return (ConnectionResult) Preconditions.checkNotNull((ConnectionResult) this.zaa.get(apiKey));
    }
}

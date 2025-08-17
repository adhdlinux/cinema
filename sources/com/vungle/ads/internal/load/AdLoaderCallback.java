package com.vungle.ads.internal.load;

import com.vungle.ads.VungleError;
import com.vungle.ads.internal.model.AdPayload;

public interface AdLoaderCallback {
    void onFailure(VungleError vungleError);

    void onSuccess(AdPayload adPayload);
}

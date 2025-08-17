package com.startapp.sdk.ads.banner;

import android.content.Context;
import android.view.View;

public interface BannerCreator {
    View create(Context context, BannerListener bannerListener);
}

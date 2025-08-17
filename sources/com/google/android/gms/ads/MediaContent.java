package com.google.android.gms.ads;

import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.ads.zzbfl;

public interface MediaContent {
    float getAspectRatio();

    float getCurrentTime();

    float getDuration();

    Drawable getMainImage();

    VideoController getVideoController();

    boolean hasVideoContent();

    void setMainImage(Drawable drawable);

    zzbfl zza();

    boolean zzb();
}

package com.facebook.drawee.backends.pipeline.info;

import com.facebook.infer.annotation.Nullsafe;
import com.vungle.ads.internal.presenter.MRAIDPresenter;

@Nullsafe(Nullsafe.Mode.STRICT)
public class ImagePerfUtils {
    private ImagePerfUtils() {
    }

    public static String toString(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "unknown" : MRAIDPresenter.ERROR : "canceled" : "success" : "intermediate_available" : "origin_available" : "requested";
    }
}

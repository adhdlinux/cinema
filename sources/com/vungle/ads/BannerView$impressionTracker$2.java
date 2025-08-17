package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.ImpressionTracker;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class BannerView$impressionTracker$2 extends Lambda implements Function0<ImpressionTracker> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BannerView$impressionTracker$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final ImpressionTracker invoke() {
        return new ImpressionTracker(this.$context);
    }
}

package com.vungle.ads;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class AdNotLoadedCantPlay extends VungleError {
    public AdNotLoadedCantPlay() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdNotLoadedCantPlay(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdNotLoadedCantPlay(java.lang.String r4) {
        /*
            r3 = this;
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.AD_NOT_LOADED
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to retrieve the ad object: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r1 = 0
            r3.<init>(r0, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.AdNotLoadedCantPlay.<init>(java.lang.String):void");
    }
}

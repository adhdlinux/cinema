package com.vungle.ads;

import kotlin.jvm.internal.DefaultConstructorMarker;

public final class AssetFailedStatusCodeError extends VungleError {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AssetFailedStatusCodeError(String str, Integer num, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : str2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AssetFailedStatusCodeError(java.lang.String r4, java.lang.Integer r5, java.lang.String r6) {
        /*
            r3 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.f(r4, r0)
            com.vungle.ads.internal.protos.Sdk$SDKError$Reason r0 = com.vungle.ads.internal.protos.Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Asset fail to download: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = ", Error code:"
            r1.append(r4)
            r1.append(r5)
            java.lang.String r4 = ", Error message: "
            r1.append(r4)
            r1.append(r6)
            java.lang.String r4 = r1.toString()
            r5 = 0
            r3.<init>(r0, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.AssetFailedStatusCodeError.<init>(java.lang.String, java.lang.Integer, java.lang.String):void");
    }
}

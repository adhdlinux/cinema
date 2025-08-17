package com.startapp.sdk.ads.banner.banner3d;

import com.startapp.r3;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public enum Banner3DSize$Size {
    XXSMALL(new r3(280, 50)),
    XSMALL(new r3(300, 50)),
    SMALL(new r3(Sdk$SDKError.Reason.WEBVIEW_ERROR_VALUE, 50)),
    MEDIUM(new r3(468, 60)),
    LARGE(new r3(728, 90)),
    XLARGE(new r3(1024, 90));
    
    private r3 size;

    private Banner3DSize$Size(r3 r3Var) {
        this.size = r3Var;
    }

    public r3 getSize() {
        return this.size;
    }
}

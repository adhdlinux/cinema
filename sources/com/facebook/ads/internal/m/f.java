package com.facebook.ads.internal.m;

import com.unity3d.services.core.device.MimeTypes;
import com.vungle.ads.internal.presenter.MRAIDPresenter;

public enum f {
    TEST("test"),
    BROWSER_SESSION("browser_session"),
    CLOSE(MRAIDPresenter.CLOSE),
    IMPRESSION("impression"),
    INVALIDATION("invalidation"),
    STORE("store"),
    OFF_TARGET_CLICK("off_target_click"),
    OPEN_LINK("open_link"),
    NATIVE_VIEW("native_view"),
    VIDEO(MimeTypes.BASE_TYPE_VIDEO),
    USER_RETURN("user_return");
    

    /* renamed from: l  reason: collision with root package name */
    private String f20303l;

    private f(String str) {
        this.f20303l = str;
    }

    public static f a(String str) {
        for (f fVar : values()) {
            if (fVar.f20303l.equalsIgnoreCase(str)) {
                return fVar;
            }
        }
        return null;
    }

    public String toString() {
        return this.f20303l;
    }
}

package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinUserService;

public class UserServiceImpl implements AppLovinUserService {

    /* renamed from: a  reason: collision with root package name */
    private final m f14989a;

    UserServiceImpl(m mVar) {
        this.f14989a = mVar;
    }

    public void preloadConsentDialog() {
        this.f14989a.W().c();
    }

    public void showConsentDialog(Activity activity, AppLovinUserService.OnConsentDialogDismissListener onConsentDialogDismissListener) {
        this.f14989a.W().a(activity, onConsentDialogDismissListener);
    }

    public String toString() {
        return "UserService{}";
    }
}

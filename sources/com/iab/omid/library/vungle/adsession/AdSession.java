package com.iab.omid.library.vungle.adsession;

import android.view.View;
import com.iab.omid.library.vungle.utils.g;

public abstract class AdSession {
    public static AdSession a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        g.a();
        g.c(adSessionConfiguration, "AdSessionConfiguration is null");
        g.c(adSessionContext, "AdSessionContext is null");
        return new a(adSessionConfiguration, adSessionContext);
    }

    public abstract void b();

    public abstract void c(View view);

    public abstract void d();
}

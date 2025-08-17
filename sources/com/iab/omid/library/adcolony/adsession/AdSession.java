package com.iab.omid.library.adcolony.adsession;

import android.view.View;
import com.iab.omid.library.adcolony.d.e;

public abstract class AdSession {
    public static AdSession b(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        e.a();
        e.d(adSessionConfiguration, "AdSessionConfiguration is null");
        e.d(adSessionContext, "AdSessionContext is null");
        return new a(adSessionConfiguration, adSessionContext);
    }

    public abstract void a(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str);

    public abstract void c(ErrorType errorType, String str);

    public abstract void d();

    public abstract String e();

    public abstract void f(View view);

    public abstract void g();
}

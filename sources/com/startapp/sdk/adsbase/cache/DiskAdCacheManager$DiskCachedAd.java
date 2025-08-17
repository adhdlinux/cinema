package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.v6;
import java.io.Serializable;

public class DiskAdCacheManager$DiskCachedAd implements Serializable {
    private static final long serialVersionUID = 1;
    private v6 ad;
    private String html;

    public DiskAdCacheManager$DiskCachedAd(v6 v6Var) {
        a(v6Var);
        c();
    }

    public v6 a() {
        return this.ad;
    }

    public String b() {
        return this.html;
    }

    public final void c() {
        v6 v6Var = this.ad;
        if (v6Var != null && (v6Var instanceof HtmlAd)) {
            this.html = ((HtmlAd) v6Var).j();
        }
    }

    public final void a(v6 v6Var) {
        this.ad = v6Var;
    }
}

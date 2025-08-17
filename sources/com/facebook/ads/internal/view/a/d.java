package com.facebook.ads.internal.view.a;

import android.text.TextUtils;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final f f20854a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f20855b = true;

    public d(f fVar) {
        this.f20854a = fVar;
    }

    private static long a(String str, String str2) {
        String substring = str.substring(str2.length());
        if (TextUtils.isEmpty(substring)) {
            return -1;
        }
        try {
            Long valueOf = Long.valueOf(Long.parseLong(substring));
            if (valueOf.longValue() < 0) {
                return -1;
            }
            return valueOf.longValue();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public void a() {
        if (this.f20855b) {
            if (this.f20854a.canGoBack() || this.f20854a.canGoForward()) {
                this.f20855b = false;
            } else {
                this.f20854a.a("void((function() {try {  if (!window.performance || !window.performance.timing || !document ||       !document.body || document.body.scrollHeight <= 0 ||       !document.body.children || document.body.children.length < 1) {    return;  }  var nvtiming__an_t = window.performance.timing;  if (nvtiming__an_t.responseEnd > 0) {    console.log('ANNavResponseEnd:'+nvtiming__an_t.responseEnd);  }  if (nvtiming__an_t.domContentLoadedEventStart > 0) {    console.log('ANNavDomContentLoaded:' + nvtiming__an_t.domContentLoadedEventStart);  }  if (nvtiming__an_t.loadEventEnd > 0) {    console.log('ANNavLoadEventEnd:' + nvtiming__an_t.loadEventEnd);  }} catch(err) {  console.log('an_navigation_timing_error:' + err.message);}})());");
            }
        }
    }

    public void a(String str) {
        if (this.f20855b) {
            if (str.startsWith("ANNavResponseEnd:")) {
                this.f20854a.a(a(str, "ANNavResponseEnd:"));
            } else if (str.startsWith("ANNavDomContentLoaded:")) {
                this.f20854a.b(a(str, "ANNavDomContentLoaded:"));
            } else if (str.startsWith("ANNavLoadEventEnd:")) {
                this.f20854a.c(a(str, "ANNavLoadEventEnd:"));
            }
        }
    }

    public void a(boolean z2) {
        this.f20855b = z2;
    }
}

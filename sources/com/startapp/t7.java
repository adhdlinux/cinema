package com.startapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.triggeredlinks.AppEventsMetadata;
import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;
import java.util.Map;

public class t7 extends oa {

    /* renamed from: a  reason: collision with root package name */
    public final u7 f36571a;

    /* renamed from: b  reason: collision with root package name */
    public int f36572b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36573c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f36574d;

    public t7(u7 u7Var) {
        this.f36571a = u7Var;
    }

    public void onActivityStarted(Activity activity) {
        AppEventsMetadata appEventsMetadata;
        AppEventsMetadata appEventsMetadata2;
        Map<String, String> map;
        if (activity != null) {
            int i2 = this.f36572b + 1;
            this.f36572b = i2;
            if (i2 == 1 && !this.f36573c) {
                Map<String, String> map2 = null;
                if (!this.f36574d) {
                    this.f36574d = true;
                    StartAppSDKInternal startAppSDKInternal = (StartAppSDKInternal) this.f36571a;
                    StartAppSDKInternal.f(startAppSDKInternal.f36228k);
                    bf bfVar = startAppSDKInternal.D;
                    if (bfVar != null) {
                        TriggeredLinksMetadata a2 = bfVar.a();
                        if (a2 != null) {
                            appEventsMetadata2 = a2.a();
                        } else {
                            appEventsMetadata2 = null;
                        }
                        if (appEventsMetadata2 != null) {
                            map = appEventsMetadata2.c();
                        } else {
                            map = null;
                        }
                        if (map != null) {
                            bfVar.a(a2, map, "Launch");
                        }
                    }
                }
                StartAppSDKInternal startAppSDKInternal2 = (StartAppSDKInternal) this.f36571a;
                Application application = startAppSDKInternal2.f36228k;
                if (application != null) {
                    rd t2 = ComponentLocator.a((Context) application).t();
                    t2.f35796b.execute(new pd(t2));
                }
                StartAppSDKInternal.f(startAppSDKInternal2.f36228k);
                bf bfVar2 = startAppSDKInternal2.D;
                if (bfVar2 != null) {
                    TriggeredLinksMetadata a3 = bfVar2.a();
                    if (a3 != null) {
                        appEventsMetadata = a3.a();
                    } else {
                        appEventsMetadata = null;
                    }
                    if (appEventsMetadata != null) {
                        map2 = appEventsMetadata.a();
                    }
                    if (map2 != null) {
                        bfVar2.a(a3, map2, "Active");
                    }
                }
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        AppEventsMetadata appEventsMetadata;
        if (activity != null) {
            this.f36572b--;
            boolean isChangingConfigurations = activity.isChangingConfigurations();
            this.f36573c = isChangingConfigurations;
            if (this.f36572b == 0 && !isChangingConfigurations) {
                StartAppSDKInternal startAppSDKInternal = (StartAppSDKInternal) this.f36571a;
                Application application = startAppSDKInternal.f36228k;
                if (application != null) {
                    rd t2 = ComponentLocator.a((Context) application).t();
                    t2.f35796b.execute(new qd(t2));
                }
                StartAppSDKInternal.f(startAppSDKInternal.f36228k);
                bf bfVar = startAppSDKInternal.D;
                if (bfVar != null) {
                    TriggeredLinksMetadata a2 = bfVar.a();
                    Map<String, String> map = null;
                    if (a2 != null) {
                        appEventsMetadata = a2.a();
                    } else {
                        appEventsMetadata = null;
                    }
                    if (appEventsMetadata != null) {
                        map = appEventsMetadata.b();
                    }
                    if (map != null) {
                        bfVar.a(a2, map, "Inactive");
                    }
                }
                Application application2 = startAppSDKInternal.f36228k;
                if (application2 != null) {
                    je n2 = ComponentLocator.a((Context) application2).n();
                    n2.getClass();
                    try {
                        n2.c();
                    } catch (Throwable th) {
                        y8.a(n2.f34776b, th);
                    }
                }
            }
        }
    }
}

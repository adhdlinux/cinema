package com.chartboost.sdk.impl;

import android.os.Handler;
import android.os.Looper;
import b0.g;
import b0.h;
import b0.i;
import b0.j;
import b0.k;
import b0.l;
import b0.m;
import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.callbacks.DismissibleAdCallback;
import com.chartboost.sdk.callbacks.RewardedCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.CacheEvent;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ClickEvent;
import com.chartboost.sdk.events.DismissEvent;
import com.chartboost.sdk.events.ImpressionEvent;
import com.chartboost.sdk.events.RewardEvent;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.events.ShowEvent;
import com.chartboost.sdk.impl.u;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f17396a;

    public d(Handler handler) {
        this.f17396a = handler;
    }

    public final void a(String str, ShowError showError, Ad ad, AdCallback adCallback) {
        a().post(new g(ad, adCallback, str, showError, this));
    }

    public final void b(String str, Ad ad, AdCallback adCallback) {
        a().post(new j(ad, adCallback, str, this));
    }

    public final void c(String str, Ad ad, AdCallback adCallback) {
        a().post(new h(ad, adCallback, str, this));
    }

    public static final void a(Ad ad, AdCallback adCallback, String str, ShowError showError, d dVar) {
        Intrinsics.f(dVar, "this$0");
        Unit unit = null;
        if (ad != null) {
            if (adCallback != null) {
                adCallback.onAdShown(new ShowEvent(str, ad), showError);
                unit = Unit.f40298a;
            }
            if (unit == null) {
                w7.c("AdApi", "Callback missing for " + dVar.a(ad) + " on onAdShown");
            }
            unit = Unit.f40298a;
        }
        if (unit == null) {
            w7.c("AdApi", "Ad is missing on onAdShown");
        }
    }

    public static final void b(Ad ad, AdCallback adCallback, String str, d dVar) {
        Intrinsics.f(dVar, "this$0");
        Unit unit = null;
        if (ad != null) {
            if (adCallback != null) {
                adCallback.onAdRequestedToShow(new ShowEvent(str, ad));
                unit = Unit.f40298a;
            }
            if (unit == null) {
                w7.c("AdApi", "Callback missing for " + dVar.a(ad) + " on onAdRequestedToShow");
            }
            unit = Unit.f40298a;
        }
        if (unit == null) {
            w7.c("AdApi", "Ad is missing on onAdRequestedToShow");
        }
    }

    public final void a(String str, Ad ad, AdCallback adCallback, int i2) {
        a().post(new i(adCallback, ad, str, i2));
    }

    public static final void a(AdCallback adCallback, Ad ad, String str, int i2) {
        Unit unit = null;
        if (adCallback != null) {
            if (adCallback instanceof RewardedCallback) {
                if (ad != null) {
                    ((RewardedCallback) adCallback).onRewardEarned(new RewardEvent(str, ad, i2));
                    unit = Unit.f40298a;
                }
                if (unit == null) {
                    w7.c("AdApi", "Ad is missing on didEarnReward");
                }
            } else {
                w7.c("AdApi", "Invalid ad type to send a reward");
            }
            unit = Unit.f40298a;
        }
        if (unit == null) {
            w7.c("AdApi", "Missing callback on sendRewardCallbackOnMainThread");
        }
    }

    public final void a(String str, Ad ad, AdCallback adCallback) {
        a().post(new m(adCallback, ad, str));
    }

    public static final void a(AdCallback adCallback, Ad ad, String str) {
        Unit unit = null;
        if (adCallback != null) {
            if (adCallback instanceof DismissibleAdCallback) {
                if (ad != null) {
                    ((DismissibleAdCallback) adCallback).onAdDismiss(new DismissEvent(str, ad));
                    unit = Unit.f40298a;
                }
                if (unit == null) {
                    w7.c("AdApi", "Ad is missing on onAdDismiss");
                }
            } else {
                w7.c("AdApi", "Invalid ad type to send onAdDismiss");
            }
            unit = Unit.f40298a;
        }
        if (unit == null) {
            w7.c("AdApi", "Missing callback on sendDismissCallbackOnMainThread");
        }
    }

    public static final void a(Ad ad, AdCallback adCallback, String str, d dVar) {
        Intrinsics.f(dVar, "this$0");
        Unit unit = null;
        if (ad != null) {
            if (adCallback != null) {
                adCallback.onImpressionRecorded(new ImpressionEvent(str, ad));
                unit = Unit.f40298a;
            }
            if (unit == null) {
                w7.c("AdApi", "Callback missing for " + dVar.a(ad) + " on onImpressionRecorded");
            }
            unit = Unit.f40298a;
        }
        if (unit == null) {
            w7.c("AdApi", "Ad is missing on onImpressionRecorded");
        }
    }

    public final void a(String str, CacheError cacheError, Ad ad, AdCallback adCallback) {
        a().post(new l(ad, adCallback, str, cacheError, this));
    }

    public static final void a(Ad ad, AdCallback adCallback, String str, CacheError cacheError, d dVar) {
        Intrinsics.f(dVar, "this$0");
        Unit unit = null;
        if (ad != null) {
            if (adCallback != null) {
                adCallback.onAdLoaded(new CacheEvent(str, ad), cacheError);
                unit = Unit.f40298a;
            }
            if (unit == null) {
                w7.c("AdApi", "Callback missing for " + dVar.a(ad) + " on onAdLoaded");
            }
            unit = Unit.f40298a;
        }
        if (unit == null) {
            w7.c("AdApi", "Ad is missing on onAdLoaded");
        }
    }

    public final void a(String str, ClickError clickError, Ad ad, AdCallback adCallback) {
        a().post(new k(ad, adCallback, str, clickError, this));
    }

    public static final void a(Ad ad, AdCallback adCallback, String str, ClickError clickError, d dVar) {
        Intrinsics.f(dVar, "this$0");
        Unit unit = null;
        if (ad != null) {
            if (adCallback != null) {
                adCallback.onAdClicked(new ClickEvent(str, ad), clickError);
                unit = Unit.f40298a;
            }
            if (unit == null) {
                w7.c("AdApi", "Callback missing for " + dVar.a(ad) + " on onAdClicked");
            }
            unit = Unit.f40298a;
        }
        if (unit == null) {
            w7.c("AdApi", "Ad is missing on onAdClicked");
        }
    }

    public final String a(Ad ad) {
        if (ad instanceof Interstitial) {
            return u.b.f18736g.b();
        }
        if (ad instanceof Rewarded) {
            return u.c.f18737g.b();
        }
        if (ad instanceof Banner) {
            return u.a.f18735g.b();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Handler a() {
        Handler handler = this.f17396a;
        if (handler != null) {
            return handler;
        }
        w7.c("AdApi", "Missing handler on AdApiCallbackSender. Create new handler.");
        return new Handler(Looper.getMainLooper());
    }
}

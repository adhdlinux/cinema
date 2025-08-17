package com.facebook.ads;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.a;
import com.facebook.ads.internal.adapters.ab;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.e;
import com.facebook.ads.internal.protocol.f;

public class RewardedVideoAd implements Ad {
    public static final int UNSET_VIDEO_DURATION = -1;

    /* renamed from: a  reason: collision with root package name */
    private static final String f19554a = "RewardedVideoAd";

    /* renamed from: b  reason: collision with root package name */
    private final Context f19555b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19556c;

    /* renamed from: d  reason: collision with root package name */
    private DisplayAdController f19557d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f19558e = false;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public RewardedVideoAdListener f19559f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public RewardData f19560g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f19561h = -1;

    public RewardedVideoAd(Context context, String str) {
        this.f19555b = context;
        this.f19556c = str;
    }

    private void a(String str, boolean z2) {
        try {
            b(str, z2);
        } catch (Exception e2) {
            Log.e(f19554a, "Error loading rewarded video ad", e2);
            if (this.f19559f != null) {
                this.f19559f.onError(this, AdError.INTERNAL_ERROR);
            }
        }
    }

    private final void a(boolean z2) {
        DisplayAdController displayAdController = this.f19557d;
        if (displayAdController != null) {
            displayAdController.b(z2);
            this.f19557d = null;
        }
    }

    private void b(String str, boolean z2) {
        a(false);
        this.f19558e = false;
        DisplayAdController displayAdController = new DisplayAdController(this.f19555b, this.f19556c, f.REWARDED_VIDEO, AdPlacementType.REWARDED_VIDEO, e.INTERSTITIAL, d.ADS, 1, true);
        this.f19557d = displayAdController;
        displayAdController.a(z2);
        this.f19557d.a((a) new a() {
            public void a() {
                if (RewardedVideoAd.this.f19559f != null) {
                    RewardedVideoAd.this.f19559f.onAdClicked(RewardedVideoAd.this);
                }
            }

            public void a(AdAdapter adAdapter) {
                ab abVar = (ab) adAdapter;
                if (RewardedVideoAd.this.f19560g != null) {
                    abVar.a(RewardedVideoAd.this.f19560g);
                }
                int unused = RewardedVideoAd.this.f19561h = abVar.a();
                boolean unused2 = RewardedVideoAd.this.f19558e = true;
                if (RewardedVideoAd.this.f19559f != null) {
                    RewardedVideoAd.this.f19559f.onAdLoaded(RewardedVideoAd.this);
                }
            }

            public void a(com.facebook.ads.internal.protocol.a aVar) {
                if (RewardedVideoAd.this.f19559f != null) {
                    RewardedVideoAd.this.f19559f.onError(RewardedVideoAd.this, AdError.getAdErrorFromWrapper(aVar));
                }
            }

            public void b() {
                if (RewardedVideoAd.this.f19559f != null) {
                    RewardedVideoAd.this.f19559f.onLoggingImpression(RewardedVideoAd.this);
                }
            }

            public void g() {
                RewardedVideoAd.this.f19559f.onRewardedVideoCompleted();
            }

            public void h() {
                if (RewardedVideoAd.this.f19559f != null) {
                    RewardedVideoAd.this.f19559f.onRewardedVideoClosed();
                }
            }

            public void i() {
                if (RewardedVideoAd.this.f19559f instanceof S2SRewardedVideoAdListener) {
                    ((S2SRewardedVideoAdListener) RewardedVideoAd.this.f19559f).onRewardServerFailed();
                }
            }

            public void j() {
                if (RewardedVideoAd.this.f19559f instanceof S2SRewardedVideoAdListener) {
                    ((S2SRewardedVideoAdListener) RewardedVideoAd.this.f19559f).onRewardServerSuccess();
                }
            }

            public void k() {
                if (RewardedVideoAd.this.f19559f instanceof RewardedVideoAdExtendedListener) {
                    ((RewardedVideoAdExtendedListener) RewardedVideoAd.this.f19559f).onRewardedVideoActivityDestroyed();
                }
            }
        });
        this.f19557d.a(str);
    }

    public void destroy() {
        a(true);
    }

    public String getPlacementId() {
        return this.f19556c;
    }

    public int getVideoDuration() {
        return this.f19561h;
    }

    public boolean isAdInvalidated() {
        DisplayAdController displayAdController = this.f19557d;
        return displayAdController == null || displayAdController.d();
    }

    public boolean isAdLoaded() {
        return this.f19558e;
    }

    public void loadAd() {
        a((String) null, false);
    }

    public void loadAd(boolean z2) {
        a((String) null, z2);
    }

    public void loadAdFromBid(String str) {
        a(str, false);
    }

    public void loadAdFromBid(String str, boolean z2) {
        a(str, z2);
    }

    public void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.f19559f = rewardedVideoAdListener;
    }

    public void setRewardData(RewardData rewardData) {
        this.f19560g = rewardData;
        if (this.f19558e) {
            this.f19557d.a(rewardData);
        }
    }

    public boolean show() {
        return show(-1);
    }

    public boolean show(int i2) {
        if (!this.f19558e) {
            RewardedVideoAdListener rewardedVideoAdListener = this.f19559f;
            if (rewardedVideoAdListener != null) {
                rewardedVideoAdListener.onError(this, AdError.INTERNAL_ERROR);
            }
            return false;
        }
        this.f19557d.a(i2);
        this.f19557d.b();
        this.f19558e = false;
        return true;
    }
}

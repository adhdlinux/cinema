package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Map;

public abstract class ab implements AdAdapter {

    /* renamed from: a  reason: collision with root package name */
    RewardData f19752a;

    /* renamed from: b  reason: collision with root package name */
    int f19753b;

    public abstract int a();

    public void a(int i2) {
        this.f19753b = i2;
    }

    public abstract void a(Context context, ac acVar, Map<String, Object> map, boolean z2);

    public void a(RewardData rewardData) {
        this.f19752a = rewardData;
    }

    public abstract boolean b();

    public AdPlacementType getPlacementType() {
        return AdPlacementType.REWARDED_VIDEO;
    }
}

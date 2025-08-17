package com.applovin.impl.mediation;

import com.applovin.mediation.MaxReward;

public class MaxRewardImpl implements MaxReward {

    /* renamed from: a  reason: collision with root package name */
    private final String f14184a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14185b;

    private MaxRewardImpl(int i2, String str) {
        if (i2 >= 0) {
            this.f14184a = str;
            this.f14185b = i2;
            return;
        }
        throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
    }

    public static MaxReward create(int i2, String str) {
        return new MaxRewardImpl(i2, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    public final int getAmount() {
        return this.f14185b;
    }

    public final String getLabel() {
        return this.f14184a;
    }

    public String toString() {
        return "MaxReward{amount=" + this.f14185b + ", label=" + this.f14184a + "}";
    }
}

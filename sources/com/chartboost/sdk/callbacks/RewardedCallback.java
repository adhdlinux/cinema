package com.chartboost.sdk.callbacks;

import com.chartboost.sdk.events.RewardEvent;

public interface RewardedCallback extends DismissibleAdCallback {
    void onRewardEarned(RewardEvent rewardEvent);
}

package com.applovin.mediation.adapter;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;

public interface MaxInterstitialAdViewAdapter {
    void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener);
}

package com.applovin.mediation.adapters;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.adview.AppLovinRewardedInterstitialAd;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxRewardedInterstitialAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.vungle.ads.internal.model.AdPayload;
import java.util.ArrayList;
import java.util.Map;

public class AppLovinMediationAdapter extends MediationAdapterBase implements MaxAdViewAdapter, MaxInterstitialAdapter, MaxRewardedAdapter, MaxRewardedInterstitialAdapter, MaxSignalProvider {
    /* access modifiers changed from: private */
    public AppLovinAdView mLoadedAdView;
    /* access modifiers changed from: private */
    public AppLovinAd mLoadedInterstitialAd;
    /* access modifiers changed from: private */
    public AppLovinAd mLoadedRewardedAd;
    /* access modifiers changed from: private */
    public AppLovinAd mLoadedRewardedInterstitialAd;
    /* access modifiers changed from: private */
    public AppLovinNativeAd mNativeAd;

    private class InterstitialListenerWrapper implements g, AppLovinAdClickListener {
        final MaxInterstitialAdapterListener listener;

        InterstitialListenerWrapper(MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
            this.listener = maxInterstitialAdapterListener;
        }

        public void adClicked(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Interstitial ad clicked");
            }
            this.listener.onInterstitialAdClicked(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Interstitial ad shown");
            }
            this.listener.onInterstitialAdDisplayed();
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Interstitial ad hidden");
            }
            this.listener.onInterstitialAdHidden(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
        }

        public void onAdDisplayFailed(String str) {
            if (v.a()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Interstitial ad failed to display with error: " + str);
            }
            this.listener.onInterstitialAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
        }
    }

    private class MaxAppLovinNativeAd extends MaxNativeAd {
        public MaxAppLovinNativeAd(MaxNativeAd.Builder builder) {
            super(builder);
        }

        public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
            AppLovinNativeAdImpl appLovinNativeAdImpl = (AppLovinNativeAdImpl) AppLovinMediationAdapter.this.mNativeAd;
            if (appLovinNativeAdImpl != null) {
                ArrayList arrayList = new ArrayList(4);
                if (StringUtils.isValidString(getTitle()) && maxNativeAdView.getTitleTextView() != null) {
                    arrayList.add(maxNativeAdView.getTitleTextView());
                }
                if (StringUtils.isValidString(getBody()) && maxNativeAdView.getBodyTextView() != null) {
                    arrayList.add(maxNativeAdView.getBodyTextView());
                }
                if (StringUtils.isValidString(getCallToAction()) && maxNativeAdView.getCallToActionButton() != null) {
                    arrayList.add(maxNativeAdView.getCallToActionButton());
                }
                if (!(getIcon() == null || maxNativeAdView.getIconImageView() == null)) {
                    arrayList.add(maxNativeAdView.getIconImageView());
                }
                appLovinNativeAdImpl.registerViewsForInteraction(arrayList, maxNativeAdView);
            } else if (v.a()) {
                AppLovinMediationAdapter.this.e("Failed to register native ad view for interaction. Native ad is null");
            }
        }
    }

    private abstract class RewardListenerWrapper implements AppLovinAdRewardListener {
        protected boolean hasGrantedReward;

        private RewardListenerWrapper() {
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
            if (v.a()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("User is over quota: " + map);
            }
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
            if (v.a()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Reward rejected: " + map);
            }
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Reward verified");
            }
        }

        public void validationRequestFailed(AppLovinAd appLovinAd, int i2) {
            if (v.a()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Reward validation request failed with code: " + i2);
            }
        }
    }

    private class RewardedAdListenerWrapper extends RewardListenerWrapper implements g, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        private final MaxRewardedAdapterListener listener;

        private RewardedAdListenerWrapper(MaxRewardedAdapterListener maxRewardedAdapterListener) {
            super();
            this.listener = maxRewardedAdapterListener;
        }

        public void adClicked(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Rewarded ad clicked");
            }
            this.listener.onRewardedAdClicked(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Rewarded ad shown");
            }
            this.listener.onRewardedAdDisplayed();
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (this.hasGrantedReward || AppLovinMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = AppLovinMediationAdapter.this.getReward();
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.log("Rewarded user with reward: " + reward);
                }
                this.listener.onUserRewarded(reward);
            }
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Rewarded ad hidden");
            }
            this.listener.onRewardedAdHidden(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
        }

        public void onAdDisplayFailed(String str) {
            if (v.a()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Rewarded ad failed to display with error: " + str);
            }
            this.listener.onRewardedAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Rewarded ad video started");
            }
            this.listener.onRewardedAdVideoStarted();
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d2, boolean z2) {
            if (v.a()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Rewarded ad video ended at " + d2 + "% and is fully watched: " + z2);
            }
            this.hasGrantedReward = z2;
            this.listener.onRewardedAdVideoCompleted();
        }
    }

    private class RewardedInterstitialAdListenerWrapper extends RewardListenerWrapper implements g, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
        private final MaxRewardedInterstitialAdapterListener listener;

        private RewardedInterstitialAdListenerWrapper(MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
            super();
            this.listener = maxRewardedInterstitialAdapterListener;
        }

        public void adClicked(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Rewarded interstitial ad clicked");
            }
            this.listener.onRewardedInterstitialAdClicked(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
        }

        public void adDisplayed(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Rewarded interstitial ad shown");
            }
            this.listener.onRewardedInterstitialAdDisplayed();
        }

        public void adHidden(AppLovinAd appLovinAd) {
            if (this.hasGrantedReward || AppLovinMediationAdapter.this.shouldAlwaysRewardUser()) {
                MaxReward reward = AppLovinMediationAdapter.this.getReward();
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.log("Rewarded interstitial rewarded user with reward: " + reward);
                }
                this.listener.onUserRewarded(reward);
            }
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Rewarded interstitial ad hidden");
            }
            this.listener.onRewardedInterstitialAdHidden(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
        }

        public void onAdDisplayFailed(String str) {
            if (v.a()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Rewarded interstitial ad failed to display with error: " + str);
            }
            this.listener.onRewardedInterstitialAdDisplayFailed(new MaxAdapterError((int) MaxAdapterError.ERROR_CODE_UNSPECIFIED, str));
        }

        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            if (v.a()) {
                AppLovinMediationAdapter.this.log("Rewarded interstitial ad video started");
            }
            this.listener.onRewardedInterstitialAdVideoStarted();
        }

        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d2, boolean z2) {
            if (v.a()) {
                AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                appLovinMediationAdapter.log("Rewarded interstitial ad video ended at " + d2 + "% and is fully watched: " + z2);
            }
            this.hasGrantedReward = z2;
            this.listener.onRewardedInterstitialAdVideoCompleted();
        }
    }

    public AppLovinMediationAdapter(AppLovinSdk appLovinSdk) {
        super(appLovinSdk);
    }

    /* access modifiers changed from: private */
    public static Bundle getExtraInfo(AppLovinAd appLovinAd) {
        Bundle bundle = new Bundle(1);
        bundle.putBundle(Utils.KEY_AD_VALUES, ((AppLovinAdImpl) appLovinAd).getMAXAdValues());
        return bundle;
    }

    private void loadFullscreenAd(String str, MaxAdapterResponseParameters maxAdapterResponseParameters, final MaxAdFormat maxAdFormat, final MaxAdapterListener maxAdapterListener) {
        StringBuilder sb;
        AnonymousClass2 r02 = new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd appLovinAd) {
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad loaded");
                }
                MaxAdFormat maxAdFormat = maxAdFormat;
                if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
                    AppLovinAd unused = AppLovinMediationAdapter.this.mLoadedInterstitialAd = appLovinAd;
                    ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdLoaded();
                } else if (maxAdFormat == MaxAdFormat.REWARDED) {
                    AppLovinAd unused2 = AppLovinMediationAdapter.this.mLoadedRewardedAd = appLovinAd;
                    ((MaxRewardedAdapterListener) maxAdapterListener).onRewardedAdLoaded();
                } else if (maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL) {
                    AppLovinAd unused3 = AppLovinMediationAdapter.this.mLoadedRewardedInterstitialAd = appLovinAd;
                    ((MaxRewardedInterstitialAdapterListener) maxAdapterListener).onRewardedInterstitialAdLoaded();
                } else {
                    throw new IllegalStateException("Non-fullscreen ad loaded for fullscreen ad adapter");
                }
            }

            public void failedToReceiveAd(int i2) {
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad failed to load with error code: " + i2);
                }
                MaxAdFormat maxAdFormat = maxAdFormat;
                if (maxAdFormat == MaxAdFormat.INTERSTITIAL) {
                    ((MaxInterstitialAdapterListener) maxAdapterListener).onInterstitialAdLoadFailed(AppLovinMediationAdapter.toMaxError(i2));
                } else if (maxAdFormat == MaxAdFormat.REWARDED) {
                    ((MaxRewardedAdapterListener) maxAdapterListener).onRewardedAdLoadFailed(AppLovinMediationAdapter.toMaxError(i2));
                } else if (maxAdFormat == MaxAdFormat.REWARDED_INTERSTITIAL) {
                    ((MaxRewardedInterstitialAdapterListener) maxAdapterListener).onRewardedInterstitialAdLoadFailed(AppLovinMediationAdapter.toMaxError(i2));
                } else {
                    throw new IllegalStateException("Non-fullscreen ad failed to load for fullscreen ad adapter");
                }
            }
        };
        if (StringUtils.isValidString(maxAdapterResponseParameters.getBidResponse())) {
            if (v.a()) {
                log("Loading bidding " + maxAdFormat.getLabel() + " ad...");
            }
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), r02);
            return;
        }
        if (StringUtils.isValidString(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            str = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            if (v.a()) {
                sb = new StringBuilder();
                sb.append("Loading mediated ");
                sb.append(maxAdFormat.getLabel());
                sb.append(" ad: ");
                sb.append(str);
                sb.append("...");
            }
            getWrappingSdk().getAdService().loadNextAdForZoneId(str, r02);
        }
        if (v.a()) {
            sb = new StringBuilder();
            sb.append("Loading mediated ");
            sb.append(maxAdFormat.getLabel());
            sb.append(" ad...");
        }
        getWrappingSdk().getAdService().loadNextAdForZoneId(str, r02);
        log(sb.toString());
        getWrappingSdk().getAdService().loadNextAdForZoneId(str, r02);
    }

    /* access modifiers changed from: private */
    public static MaxAdapterError toMaxError(int i2) {
        MaxAdapterError maxAdapterError = i2 == -1009 ? MaxAdapterError.NO_CONNECTION : i2 == 204 ? MaxAdapterError.NO_FILL : i2 == -1 ? MaxAdapterError.INTERNAL_ERROR : i2 >= 500 ? MaxAdapterError.SERVER_ERROR : MaxAdapterError.UNSPECIFIED;
        return new MaxAdapterError(maxAdapterError.getCode(), maxAdapterError.getErrorMessage(), i2, "");
    }

    public void collectSignal(MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, MaxSignalCollectionListener maxSignalCollectionListener) {
        if (v.a()) {
            log("Collecting signal...");
        }
        maxSignalCollectionListener.onSignalCollected(getWrappingSdk().getAdService().getBidToken());
    }

    public String getAdapterVersion() {
        return getSdkVersion();
    }

    public String getSdkVersion() {
        return AppLovinSdk.VERSION;
    }

    public void initialize(MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity, MaxAdapter.OnCompletionListener onCompletionListener) {
        onCompletionListener.onCompletion(MaxAdapter.InitializationStatus.DOES_NOT_APPLY, (String) null);
    }

    public void loadAdViewAd(MaxAdapterResponseParameters maxAdapterResponseParameters, final MaxAdFormat maxAdFormat, Activity activity, final MaxAdViewAdapterListener maxAdViewAdapterListener) {
        AnonymousClass1 r6 = new AppLovinAdLoadListener() {
            public void adReceived(final AppLovinAd appLovinAd) {
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad loaded");
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        AppLovinAdView unused = AppLovinMediationAdapter.this.mLoadedAdView = new AppLovinAdView(AppLovinMediationAdapter.this.getWrappingSdk(), appLovinAd.getSize(), AppLovinMediationAdapter.this.getApplicationContext());
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdDisplayListener(new AppLovinAdDisplayListener() {
                            public void adDisplayed(AppLovinAd appLovinAd) {
                                if (v.a()) {
                                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad shown");
                                }
                                maxAdViewAdapterListener.onAdViewAdDisplayed();
                            }

                            public void adHidden(AppLovinAd appLovinAd) {
                                if (v.a()) {
                                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad hidden");
                                }
                                maxAdViewAdapterListener.onAdViewAdHidden(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
                            }
                        });
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdClickListener(new AppLovinAdClickListener() {
                            public void adClicked(AppLovinAd appLovinAd) {
                                if (v.a()) {
                                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad clicked");
                                }
                                maxAdViewAdapterListener.onAdViewAdClicked(AppLovinMediationAdapter.getExtraInfo(appLovinAd));
                            }
                        });
                        AppLovinMediationAdapter.this.mLoadedAdView.setAdViewEventListener(new AppLovinAdViewEventListener() {
                            public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                                if (v.a()) {
                                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad collapsed");
                                }
                                maxAdViewAdapterListener.onAdViewAdCollapsed();
                            }

                            public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
                                maxAdViewAdapterListener.onAdViewAdDisplayFailed(MaxAdapterError.UNSPECIFIED);
                            }

                            public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                            }

                            public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
                                if (v.a()) {
                                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad expanded");
                                }
                                maxAdViewAdapterListener.onAdViewAdExpanded();
                            }
                        });
                        AnonymousClass1 r02 = AnonymousClass1.this;
                        maxAdViewAdapterListener.onAdViewAdLoaded(AppLovinMediationAdapter.this.mLoadedAdView);
                        AppLovinMediationAdapter.this.mLoadedAdView.renderAd(appLovinAd);
                    }
                });
            }

            public void failedToReceiveAd(int i2) {
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.log(maxAdFormat.getLabel() + " ad failed to load with error code: " + i2);
                }
                maxAdViewAdapterListener.onAdViewAdLoadFailed(AppLovinMediationAdapter.toMaxError(i2));
            }
        };
        if (StringUtils.isValidString(maxAdapterResponseParameters.getBidResponse())) {
            if (v.a()) {
                log("Loading bidding " + maxAdFormat.getLabel() + " ad...");
            }
            getWrappingSdk().getAdService().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), r6);
        } else if (StringUtils.isValidString(maxAdapterResponseParameters.getThirdPartyAdPlacementId())) {
            String thirdPartyAdPlacementId = maxAdapterResponseParameters.getThirdPartyAdPlacementId();
            if (v.a()) {
                log("Loading mediated " + maxAdFormat.getLabel() + " ad: " + thirdPartyAdPlacementId + "...");
            }
            getWrappingSdk().getAdService().loadNextAdForZoneId(thirdPartyAdPlacementId, r6);
        } else {
            AppLovinAdSize appLovinAdSize = maxAdFormat == MaxAdFormat.BANNER ? AppLovinAdSize.BANNER : maxAdFormat == MaxAdFormat.MREC ? AppLovinAdSize.MREC : maxAdFormat == MaxAdFormat.LEADER ? AppLovinAdSize.LEADER : null;
            if (appLovinAdSize != null) {
                if (v.a()) {
                    log("Loading mediated " + maxAdFormat.getLabel() + " ad...");
                }
                getWrappingSdk().getAdService().loadNextAd(appLovinAdSize, r6);
                return;
            }
            if (v.a()) {
                log("Failed to load ad for format: " + maxAdFormat);
            }
            maxAdViewAdapterListener.onAdViewAdLoadFailed(MaxAdapterError.INTERNAL_ERROR);
        }
    }

    public void loadInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        loadFullscreenAd("inter_regular", maxAdapterResponseParameters, MaxAdFormat.INTERSTITIAL, maxInterstitialAdapterListener);
    }

    public void loadNativeAd(final MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, final MaxNativeAdAdapterListener maxNativeAdAdapterListener) {
        if (TextUtils.isEmpty(maxAdapterResponseParameters.getBidResponse())) {
            maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.INVALID_CONFIGURATION);
            return;
        }
        if (v.a()) {
            d("Loading bidding native ad...");
        }
        getWrappingSdk().coreSdk.v().loadNextAdForAdToken(maxAdapterResponseParameters.getBidResponse(), new AppLovinNativeAdLoadListener() {
            public void onNativeAdLoadFailed(int i2) {
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.d("Native ad failed to load with error code: " + i2);
                }
                maxNativeAdAdapterListener.onNativeAdLoadFailed(AppLovinMediationAdapter.toMaxError(i2));
            }

            public void onNativeAdLoaded(AppLovinNativeAd appLovinNativeAd) {
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter.d("Native ad loaded: " + appLovinNativeAd);
                }
                if (!StringUtils.isValidString(BundleUtils.getString(AdPayload.KEY_TEMPLATE, "", maxAdapterResponseParameters.getServerParameters())) || !TextUtils.isEmpty(appLovinNativeAd.getTitle())) {
                    ((AppLovinNativeAdImpl) appLovinNativeAd).setEventListener(new AppLovinNativeAdEventListener() {
                        public void onNativeAdClicked(AppLovinNativeAd appLovinNativeAd) {
                            if (v.a()) {
                                AppLovinMediationAdapter.this.d("Native ad clicked");
                            }
                            maxNativeAdAdapterListener.onNativeAdClicked();
                        }
                    });
                    AppLovinNativeAd unused = AppLovinMediationAdapter.this.mNativeAd = appLovinNativeAd;
                    maxNativeAdAdapterListener.onNativeAdLoaded(new MaxAppLovinNativeAd(new MaxNativeAd.Builder().setAdFormat(MaxAdFormat.NATIVE).setTitle(appLovinNativeAd.getTitle()).setBody(appLovinNativeAd.getBody()).setAdvertiser(appLovinNativeAd.getAdvertiser()).setCallToAction(appLovinNativeAd.getCallToAction()).setIcon(new MaxNativeAd.MaxNativeAdImage(appLovinNativeAd.getIconUri())).setMainImage(new MaxNativeAd.MaxNativeAdImage(((AppLovinNativeAdImpl) appLovinNativeAd).getMainImageUri())).setMediaView(appLovinNativeAd.getMediaView()).setMediaContentAspectRatio(appLovinNativeAd.getMediaView().getAspectRatio()).setOptionsView(appLovinNativeAd.getOptionsView())), (Bundle) null);
                    return;
                }
                if (v.a()) {
                    AppLovinMediationAdapter appLovinMediationAdapter2 = AppLovinMediationAdapter.this;
                    appLovinMediationAdapter2.e("Native ad does not have required assets: " + appLovinNativeAd);
                }
                maxNativeAdAdapterListener.onNativeAdLoadFailed(MaxAdapterError.MISSING_REQUIRED_NATIVE_AD_ASSETS);
            }
        });
    }

    public void loadRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        loadFullscreenAd("inter_videoa", maxAdapterResponseParameters, MaxAdFormat.REWARDED, maxRewardedAdapterListener);
    }

    public void loadRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        loadFullscreenAd("inter_autorew", maxAdapterResponseParameters, MaxAdFormat.REWARDED_INTERSTITIAL, maxRewardedInterstitialAdapterListener);
    }

    public void onDestroy() {
        this.mLoadedInterstitialAd = null;
        this.mLoadedRewardedAd = null;
        this.mLoadedRewardedInterstitialAd = null;
        AppLovinAdView appLovinAdView = this.mLoadedAdView;
        if (appLovinAdView != null) {
            appLovinAdView.destroy();
            this.mLoadedAdView = null;
        }
        AppLovinNativeAd appLovinNativeAd = this.mNativeAd;
        if (appLovinNativeAd instanceof AppLovinNativeAdImpl) {
            ((AppLovinNativeAdImpl) appLovinNativeAd).destroy();
            this.mNativeAd = null;
        }
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        if (v.a()) {
            log("Showing interstitial: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        }
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        InterstitialListenerWrapper interstitialListenerWrapper = new InterstitialListenerWrapper(maxInterstitialAdapterListener);
        create.setAdDisplayListener(interstitialListenerWrapper);
        create.setAdClickListener(interstitialListenerWrapper);
        create.showAndRender(this.mLoadedInterstitialAd);
    }

    public void showInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxInterstitialAdapterListener maxInterstitialAdapterListener) {
        if (v.a()) {
            log("Showing interstitial ad view: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        }
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        InterstitialListenerWrapper interstitialListenerWrapper = new InterstitialListenerWrapper(maxInterstitialAdapterListener);
        create.setAdDisplayListener(interstitialListenerWrapper);
        create.setAdClickListener(interstitialListenerWrapper);
        create.showAndRender(this.mLoadedInterstitialAd, viewGroup, lifecycle);
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        if (v.a()) {
            log("Showing rewarded ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        }
        configureReward(maxAdapterResponseParameters);
        AppLovinIncentivizedInterstitial create = AppLovinIncentivizedInterstitial.create(getWrappingSdk());
        RewardedAdListenerWrapper rewardedAdListenerWrapper = new RewardedAdListenerWrapper(maxRewardedAdapterListener);
        create.show(this.mLoadedRewardedAd, activity, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper);
    }

    public void showRewardedAd(MaxAdapterResponseParameters maxAdapterResponseParameters, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity, MaxRewardedAdapterListener maxRewardedAdapterListener) {
        if (v.a()) {
            log("Showing rewarded ad view: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        }
        configureReward(maxAdapterResponseParameters);
        AppLovinIncentivizedInterstitial create = AppLovinIncentivizedInterstitial.create(getWrappingSdk());
        RewardedAdListenerWrapper rewardedAdListenerWrapper = new RewardedAdListenerWrapper(maxRewardedAdapterListener);
        create.show(this.mLoadedRewardedAd, viewGroup, lifecycle, activity, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper, rewardedAdListenerWrapper);
    }

    public void showRewardedInterstitialAd(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity, MaxRewardedInterstitialAdapterListener maxRewardedInterstitialAdapterListener) {
        if (v.a()) {
            log("Showing rewarded interstitial ad: " + maxAdapterResponseParameters.getThirdPartyAdPlacementId() + "...");
        }
        RewardedInterstitialAdListenerWrapper rewardedInterstitialAdListenerWrapper = new RewardedInterstitialAdListenerWrapper(maxRewardedInterstitialAdapterListener);
        if (this.mLoadedRewardedInterstitialAd.getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
            configureReward(maxAdapterResponseParameters);
            AppLovinRewardedInterstitialAd appLovinRewardedInterstitialAd = new AppLovinRewardedInterstitialAd(getWrappingSdk());
            appLovinRewardedInterstitialAd.setAdDisplayListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.setAdClickListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.setAdVideoPlaybackListener(rewardedInterstitialAdListenerWrapper);
            appLovinRewardedInterstitialAd.show(this.mLoadedRewardedInterstitialAd, activity, rewardedInterstitialAdListenerWrapper);
            return;
        }
        if (v.a()) {
            log("Rewarded interstitial is regular interstitial");
        }
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(getWrappingSdk(), activity);
        create.setAdDisplayListener(rewardedInterstitialAdListenerWrapper);
        create.setAdClickListener(rewardedInterstitialAdListenerWrapper);
        create.setAdVideoPlaybackListener(rewardedInterstitialAdListenerWrapper);
        create.showAndRender(this.mLoadedRewardedInterstitialAd);
    }
}

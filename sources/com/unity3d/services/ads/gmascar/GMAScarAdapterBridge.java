package com.unity3d.services.ads.gmascar;

import com.unity3d.scar.adapter.common.GMAAdsError;
import com.unity3d.scar.adapter.common.GMAEvent;
import com.unity3d.scar.adapter.common.IScarAdapter;
import com.unity3d.scar.adapter.common.WebViewAdsError;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.services.ads.gmascar.adapters.ScarAdapterFactory;
import com.unity3d.services.ads.gmascar.bridges.AdapterStatusBridge;
import com.unity3d.services.ads.gmascar.bridges.InitializationStatusBridge;
import com.unity3d.services.ads.gmascar.bridges.InitializeListenerBridge;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.ads.gmascar.finder.GMAInitializer;
import com.unity3d.services.ads.gmascar.finder.PresenceDetector;
import com.unity3d.services.ads.gmascar.finder.ScarVersionFinder;
import com.unity3d.services.ads.gmascar.handlers.BiddingSignalsHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarInterstitialAdHandler;
import com.unity3d.services.ads.gmascar.handlers.ScarRewardedAdHandler;
import com.unity3d.services.ads.gmascar.handlers.SignalsHandler;
import com.unity3d.services.ads.gmascar.handlers.WebViewErrorHandler;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.timer.DefaultIntervalTimerFactory;
import java.util.ArrayDeque;
import java.util.Arrays;

public class GMAScarAdapterBridge {
    private final AdapterStatusBridge _adapterStatusBridge;
    private final GMAEventSender _gmaEventSender;
    private final GMAInitializer _gmaInitializer;
    private final InitializeListenerBridge _initializationListenerBridge;
    private final InitializationStatusBridge _initializationStatusBridge;
    private final MobileAdsBridgeBase _mobileAdsBridge;
    private final PresenceDetector _presenceDetector;
    private IScarAdapter _scarAdapter;
    private final ScarAdapterFactory _scarAdapterFactory;
    private final ScarVersionFinder _scarVersionFinder;
    private final WebViewErrorHandler _webViewErrorHandler;

    public GMAScarAdapterBridge(MobileAdsBridgeBase mobileAdsBridgeBase, InitializeListenerBridge initializeListenerBridge, InitializationStatusBridge initializationStatusBridge, AdapterStatusBridge adapterStatusBridge, WebViewErrorHandler webViewErrorHandler, ScarAdapterFactory scarAdapterFactory, GMAEventSender gMAEventSender) {
        this._initializationStatusBridge = initializationStatusBridge;
        this._initializationListenerBridge = initializeListenerBridge;
        this._adapterStatusBridge = adapterStatusBridge;
        this._webViewErrorHandler = webViewErrorHandler;
        this._scarAdapterFactory = scarAdapterFactory;
        this._mobileAdsBridge = mobileAdsBridgeBase;
        this._gmaEventSender = gMAEventSender;
        PresenceDetector presenceDetector = new PresenceDetector(mobileAdsBridgeBase, initializeListenerBridge, initializationStatusBridge, adapterStatusBridge);
        this._presenceDetector = presenceDetector;
        GMAInitializer gMAInitializer = new GMAInitializer(mobileAdsBridgeBase, initializeListenerBridge, initializationStatusBridge, adapterStatusBridge, gMAEventSender);
        this._gmaInitializer = gMAInitializer;
        this._scarVersionFinder = new ScarVersionFinder(mobileAdsBridgeBase, presenceDetector, gMAInitializer, gMAEventSender);
    }

    private IScarAdapter getScarAdapterObject() {
        MobileAdsBridgeBase mobileAdsBridgeBase;
        if (this._scarAdapter == null && (mobileAdsBridgeBase = this._mobileAdsBridge) != null) {
            this._scarAdapter = this._scarAdapterFactory.createScarAdapter(mobileAdsBridgeBase.getAdapterVersion(this._scarVersionFinder.getVersionCode()), this._webViewErrorHandler);
        }
        return this._scarAdapter;
    }

    private EventSubject getScarEventSubject(Integer num) {
        return new EventSubject(new ArrayDeque(Arrays.asList(new GMAEvent[]{GMAEvent.FIRST_QUARTILE, GMAEvent.MIDPOINT, GMAEvent.THIRD_QUARTILE, GMAEvent.LAST_QUARTILE})), num, new DefaultIntervalTimerFactory());
    }

    private void loadInterstitialAd(ScarAdMetadata scarAdMetadata) {
        this._scarAdapter.e(ClientProperties.getApplicationContext(), scarAdMetadata, new ScarInterstitialAdHandler(scarAdMetadata, getScarEventSubject(scarAdMetadata.e()), this._gmaEventSender));
    }

    private void loadRewardedAd(ScarAdMetadata scarAdMetadata) {
        this._scarAdapter.d(ClientProperties.getApplicationContext(), scarAdMetadata, new ScarRewardedAdHandler(scarAdMetadata, getScarEventSubject(scarAdMetadata.e()), this._gmaEventSender));
    }

    public void getSCARBiddingSignals(BiddingSignalsHandler biddingSignalsHandler) {
        MobileAdsBridgeBase mobileAdsBridgeBase = this._mobileAdsBridge;
        if (mobileAdsBridgeBase == null || !mobileAdsBridgeBase.hasSCARBiddingSupport()) {
            biddingSignalsHandler.onSignalsCollectionFailed("SCAR bidding unsupported.");
            return;
        }
        IScarAdapter scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject != null) {
            scarAdapterObject.b(ClientProperties.getApplicationContext(), biddingSignalsHandler);
        } else {
            biddingSignalsHandler.onSignalsCollectionFailed("Could not create SCAR adapter object.");
        }
    }

    public void getSCARSignals(String[] strArr, String[] strArr2) {
        this._scarAdapter = getScarAdapterObject();
        SignalsHandler signalsHandler = new SignalsHandler(this._gmaEventSender);
        IScarAdapter iScarAdapter = this._scarAdapter;
        if (iScarAdapter != null) {
            iScarAdapter.a(ClientProperties.getApplicationContext(), strArr, strArr2, signalsHandler);
        } else {
            this._webViewErrorHandler.handleError((WebViewAdsError) GMAAdsError.e("Could not create SCAR adapter object"));
        }
    }

    public void getVersion() {
        this._scarVersionFinder.getVersion();
    }

    public boolean hasSCARBiddingSupport() {
        MobileAdsBridgeBase mobileAdsBridgeBase = this._mobileAdsBridge;
        if (mobileAdsBridgeBase == null || !mobileAdsBridgeBase.hasSCARBiddingSupport()) {
            return false;
        }
        IScarAdapter scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject != null) {
            return true;
        }
        return false;
    }

    public void initializeScar() {
        if (this._presenceDetector.areGMAClassesPresent()) {
            this._gmaEventSender.send(GMAEvent.SCAR_PRESENT, new Object[0]);
            this._gmaInitializer.initializeGMA();
            return;
        }
        this._webViewErrorHandler.handleError((WebViewAdsError) new GMAAdsError(GMAEvent.SCAR_NOT_PRESENT, new Object[0]));
    }

    public boolean isInitialized() {
        return this._gmaInitializer.isInitialized();
    }

    public void load(boolean z2, String str, String str2, String str3, String str4, int i2) {
        ScarAdMetadata scarAdMetadata = new ScarAdMetadata(str, str2, str4, str3, Integer.valueOf(i2));
        IScarAdapter scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject == null) {
            this._webViewErrorHandler.handleError((WebViewAdsError) GMAAdsError.c(scarAdMetadata, "Scar Adapter object is null"));
        } else if (z2) {
            loadInterstitialAd(scarAdMetadata);
        } else {
            loadRewardedAd(scarAdMetadata);
        }
    }

    public void show(String str, String str2, boolean z2) {
        ScarAdMetadata scarAdMetadata = new ScarAdMetadata(str, str2);
        IScarAdapter scarAdapterObject = getScarAdapterObject();
        this._scarAdapter = scarAdapterObject;
        if (scarAdapterObject != null) {
            scarAdapterObject.c(ClientProperties.getActivity(), str2, str);
        } else {
            this._webViewErrorHandler.handleError((WebViewAdsError) GMAAdsError.d(scarAdMetadata, "Scar Adapter object is null"));
        }
    }
}

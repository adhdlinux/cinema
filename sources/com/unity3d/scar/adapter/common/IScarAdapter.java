package com.unity3d.scar.adapter.common;

import android.app.Activity;
import android.content.Context;
import com.unity3d.scar.adapter.common.scarads.ScarAdMetadata;
import com.unity3d.scar.adapter.common.signals.ISignalCollectionListener;

public interface IScarAdapter {
    void a(Context context, String[] strArr, String[] strArr2, ISignalCollectionListener iSignalCollectionListener);

    void b(Context context, ISignalCollectionListener iSignalCollectionListener);

    void c(Activity activity, String str, String str2);

    void d(Context context, ScarAdMetadata scarAdMetadata, IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper);

    void e(Context context, ScarAdMetadata scarAdMetadata, IScarInterstitialAdListenerWrapper iScarInterstitialAdListenerWrapper);
}

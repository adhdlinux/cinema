package com.unity3d.scar.adapter.common.signals;

import android.content.Context;
import com.unity3d.scar.adapter.common.DispatchGroup;

public interface ISignalsCollector {
    void a(Context context, String[] strArr, String[] strArr2, ISignalCollectionListener iSignalCollectionListener);

    void b(Context context, ISignalCollectionListener iSignalCollectionListener);

    void c(Context context, boolean z2, DispatchGroup dispatchGroup, SignalsResult signalsResult);

    void d(Context context, String str, boolean z2, DispatchGroup dispatchGroup, SignalsResult signalsResult);
}

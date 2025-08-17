package w;

import com.ads.videoreward.ChartboostAds;
import com.chartboost.sdk.callbacks.StartCallback;
import com.chartboost.sdk.events.StartError;

public final /* synthetic */ class a implements StartCallback {
    public final void onStartCompleted(StartError startError) {
        ChartboostAds.s(startError);
    }
}

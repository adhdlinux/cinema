package com.vungle.ads.internal.presenter;

import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Callback;
import com.vungle.ads.internal.network.Response;
import com.vungle.ads.internal.util.Logger;

public final class MRAIDPresenter$processCommand$7$1 implements Callback<Void> {
    final /* synthetic */ MRAIDPresenter this$0;

    MRAIDPresenter$processCommand$7$1(MRAIDPresenter mRAIDPresenter) {
        this.this$0 = mRAIDPresenter;
    }

    public void onFailure(Call<Void> call, Throwable th) {
        String str;
        Logger.Companion.d("MRAIDPresenter", "send RI Failure");
        StringBuilder sb = new StringBuilder();
        sb.append("Error RI API calls: ");
        if (th != null) {
            str = th.getLocalizedMessage();
        } else {
            str = null;
        }
        sb.append(str);
        new NetworkUnreachable(sb.toString()).setLogEntry$vungle_ads_release(this.this$0.getLogEntry()).logErrorNoReturnValue$vungle_ads_release();
    }

    public void onResponse(Call<Void> call, Response<Void> response) {
        Logger.Companion.d("MRAIDPresenter", "send RI success");
    }
}

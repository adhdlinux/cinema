package com.vungle.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.Intrinsics;

public final class RingerModeReceiver extends BroadcastReceiver {
    private VungleWebClient webClient;

    public final VungleWebClient getWebClient() {
        return this.webClient;
    }

    public void onReceive(Context context, Intent intent) {
        String str;
        if (intent != null) {
            try {
                str = intent.getAction();
            } catch (Exception e2) {
                String localizedMessage = e2.getLocalizedMessage();
                if (localizedMessage != null) {
                    Logger.Companion.e("RingerModeReceiver", localizedMessage);
                    return;
                }
                return;
            }
        } else {
            str = null;
        }
        if (Intrinsics.a(str, "android.media.RINGER_MODE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
            Logger.Companion companion = Logger.Companion;
            companion.d("RingerModeReceiver", "receive ringermode: " + intExtra);
            if (intExtra == 0) {
                VungleWebClient vungleWebClient = this.webClient;
                if (vungleWebClient != null) {
                    vungleWebClient.notifySilentModeChange(true);
                }
            } else if (intExtra == 1) {
                VungleWebClient vungleWebClient2 = this.webClient;
                if (vungleWebClient2 != null) {
                    vungleWebClient2.notifySilentModeChange(true);
                }
            } else if (intExtra == 2) {
                VungleWebClient vungleWebClient3 = this.webClient;
                if (vungleWebClient3 != null) {
                    vungleWebClient3.notifySilentModeChange(false);
                }
            }
        }
    }

    public final void setWebClient(VungleWebClient vungleWebClient) {
        this.webClient = vungleWebClient;
    }
}

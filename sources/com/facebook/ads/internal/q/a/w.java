package com.facebook.ads.internal.q.a;

import android.content.Context;
import android.media.AudioManager;
import com.facebook.ads.AudienceNetworkActivity;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Map;

public class w {
    public static float a(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return 0.0f;
        }
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        if (streamMaxVolume > 0) {
            return (((float) streamVolume) * 1.0f) / ((float) streamMaxVolume);
        }
        return 0.0f;
    }

    public static void a(Map<String, String> map, boolean z2, boolean z3) {
        String str = "1";
        map.put(AudienceNetworkActivity.AUTOPLAY, z2 ? str : "0");
        if (!z3) {
            str = "0";
        }
        map.put("inline", str);
    }
}

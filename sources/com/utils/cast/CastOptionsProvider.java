package com.utils.cast;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.movie.FreeMoviesApp;
import com.utils.ExpandedControlsActivity;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.LocaleUtils;

public class CastOptionsProvider implements OptionsProvider {
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }

    public CastOptions getCastOptions(Context context) {
        Locale locale;
        ArrayList arrayList = new ArrayList();
        arrayList.add(MediaIntentReceiver.ACTION_REWIND);
        arrayList.add(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK);
        arrayList.add(MediaIntentReceiver.ACTION_FORWARD);
        arrayList.add(MediaIntentReceiver.ACTION_STOP_CASTING);
        String trim = FreeMoviesApp.p().getString("pref_app_lang", "").trim();
        if (trim.isEmpty()) {
            locale = Resources.getSystem().getConfiguration().locale;
        } else {
            locale = LocaleUtils.e(trim);
        }
        Class<ExpandedControlsActivity> cls = ExpandedControlsActivity.class;
        return new CastOptions.Builder().setReceiverApplicationId(context.getString(R.string.google_cast_app_id)).setCastMediaOptions(new CastMediaOptions.Builder().setNotificationOptions(new NotificationOptions.Builder().setTargetActivityClassName(cls.getName()).setActions(arrayList, new int[]{1, 3}).build()).setExpandedControllerActivityClassName(cls.getName()).build()).setLaunchOptions(new LaunchOptions.Builder().setLocale(locale).build()).setEnableReconnectionService(true).setResumeSavedSession(true).setVolumeDeltaBeforeIceCreamSandwich(0.1d).setStopReceiverApplicationWhenEndingSession(true).build();
    }
}

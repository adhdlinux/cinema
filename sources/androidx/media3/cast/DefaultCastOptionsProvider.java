package androidx.media3.cast;

import android.content.Context;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;
import java.util.Collections;
import java.util.List;

public final class DefaultCastOptionsProvider implements OptionsProvider {
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return Collections.emptyList();
    }

    public CastOptions getCastOptions(Context context) {
        return new CastOptions.Builder().setResumeSavedSession(false).setEnableReconnectionService(false).setReceiverApplicationId("A12D4273").setStopReceiverApplicationWhenEndingSession(true).build();
    }
}

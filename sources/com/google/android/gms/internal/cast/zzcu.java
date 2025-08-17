package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.UIController;
import com.google.android.gms.cast.framework.media.uicontroller.zza;

public final class zzcu extends UIController implements RemoteMediaClient.ProgressListener {
    private final TextView zza;
    private final ImageView zzb;
    private final zza zzc;

    public zzcu(View view, zza zza2) {
        TextView textView = (TextView) view.findViewById(R.id.live_indicator_text);
        this.zza = textView;
        ImageView imageView = (ImageView) view.findViewById(R.id.live_indicator_dot);
        this.zzb = imageView;
        this.zzc = zza2;
        TypedArray obtainStyledAttributes = imageView.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castLiveIndicatorColor, 0);
        obtainStyledAttributes.recycle();
        imageView.getDrawable().setColorFilter(imageView.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
        textView.setVisibility(8);
        imageView.setVisibility(8);
    }

    public final void onMediaStatusUpdated() {
        zza();
    }

    public final void onProgressUpdated(long j2, long j3) {
        zza();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.addProgressListener(this, 1000);
        }
        zza();
    }

    public final void onSessionEnded() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null) {
            remoteMediaClient.removeProgressListener(this);
        }
        super.onSessionEnded();
        zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        boolean z2;
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        int i2 = 8;
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || !remoteMediaClient.isLiveStream()) {
            this.zza.setVisibility(8);
            this.zzb.setVisibility(8);
            return;
        }
        if (!remoteMediaClient.zzv()) {
            z2 = remoteMediaClient.isPlaying();
        } else {
            z2 = this.zzc.zzm();
        }
        this.zza.setVisibility(0);
        ImageView imageView = this.zzb;
        if (true == z2) {
            i2 = 0;
        }
        imageView.setVisibility(i2);
        zzr.zzd(zzln.CAF_EXPANDED_CONTROLLER_WITH_LIVE_CONTENT);
    }
}

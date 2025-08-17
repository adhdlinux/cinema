package com.google.android.gms.cast.framework.media.uicontroller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.TracksChooserDialogFragment;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzbs;
import com.google.android.gms.internal.cast.zzbt;
import com.google.android.gms.internal.cast.zzbu;
import com.google.android.gms.internal.cast.zzbw;
import com.google.android.gms.internal.cast.zzby;
import com.google.android.gms.internal.cast.zzbz;
import com.google.android.gms.internal.cast.zzca;
import com.google.android.gms.internal.cast.zzcb;
import com.google.android.gms.internal.cast.zzcc;
import com.google.android.gms.internal.cast.zzcd;
import com.google.android.gms.internal.cast.zzcf;
import com.google.android.gms.internal.cast.zzcg;
import com.google.android.gms.internal.cast.zzch;
import com.google.android.gms.internal.cast.zzci;
import com.google.android.gms.internal.cast.zzck;
import com.google.android.gms.internal.cast.zzcl;
import com.google.android.gms.internal.cast.zzcm;
import com.google.android.gms.internal.cast.zzcn;
import com.google.android.gms.internal.cast.zzco;
import com.google.android.gms.internal.cast.zzcp;
import com.google.android.gms.internal.cast.zzcq;
import com.google.android.gms.internal.cast.zzcr;
import com.google.android.gms.internal.cast.zzcs;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.json.JSONObject;

public class UIMediaController implements RemoteMediaClient.Listener, SessionManagerListener<CastSession> {
    private static final Logger zzb = new Logger("UIMediaController");
    final zza zza = zza.zzf();
    private final Activity zzc;
    private final SessionManager zzd;
    private final Map zze = new HashMap();
    private final Set zzf = new HashSet();
    private RemoteMediaClient.Listener zzg;
    private RemoteMediaClient zzh;

    public UIMediaController(Activity activity) {
        SessionManager sessionManager;
        this.zzc = activity;
        CastContext zza2 = CastContext.zza(activity);
        zzr.zzd(zzln.UI_MEDIA_CONTROLLER);
        if (zza2 != null) {
            sessionManager = zza2.getSessionManager();
        } else {
            sessionManager = null;
        }
        this.zzd = sessionManager;
        if (sessionManager != null) {
            sessionManager.addSessionManagerListener(this, CastSession.class);
            zzh(sessionManager.getCurrentCastSession());
        }
    }

    private final void zzg() {
        if (isActive()) {
            this.zza.zza = null;
            for (List<UIController> it2 : this.zze.values()) {
                for (UIController onSessionEnded : it2) {
                    onSessionEnded.onSessionEnded();
                }
            }
            Preconditions.checkNotNull(this.zzh);
            this.zzh.removeListener(this);
            this.zzh = null;
        }
    }

    private final void zzh(Session session) {
        if (!isActive() && session != null && session.isConnected()) {
            CastSession castSession = (CastSession) session;
            RemoteMediaClient remoteMediaClient = castSession.getRemoteMediaClient();
            this.zzh = remoteMediaClient;
            if (remoteMediaClient != null) {
                remoteMediaClient.addListener(this);
                Preconditions.checkNotNull(this.zza);
                this.zza.zza = castSession.getRemoteMediaClient();
                for (List<UIController> it2 : this.zze.values()) {
                    for (UIController onSessionConnected : it2) {
                        onSessionConnected.onSessionConnected(castSession);
                    }
                }
                zzm();
            }
        }
    }

    private final void zzi(int i2, boolean z2) {
        if (z2) {
            for (zzcq zzb2 : this.zzf) {
                zzb2.zzb(((long) i2) + this.zza.zze());
            }
        }
    }

    private final void zzj() {
        for (zzcq zza2 : this.zzf) {
            zza2.zza(false);
        }
    }

    private final void zzk(int i2) {
        boolean z2;
        Iterator it2 = this.zzf.iterator();
        while (true) {
            z2 = true;
            if (!it2.hasNext()) {
                break;
            }
            ((zzcq) it2.next()).zza(true);
        }
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            long zze2 = ((long) i2) + this.zza.zze();
            MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
            builder.setPosition(zze2);
            if (!remoteMediaClient.isLiveStream() || !this.zza.zzn(zze2)) {
                z2 = false;
            }
            builder.setIsSeekToInfinite(z2);
            remoteMediaClient.seek(builder.build());
        }
    }

    private final void zzl(View view, UIController uIController) {
        if (this.zzd != null) {
            List list = (List) this.zze.get(view);
            if (list == null) {
                list = new ArrayList();
                this.zze.put(view, list);
            }
            list.add(uIController);
            if (isActive()) {
                uIController.onSessionConnected((CastSession) Preconditions.checkNotNull(this.zzd.getCurrentCastSession()));
                zzm();
            }
        }
    }

    private final void zzm() {
        for (List<UIController> it2 : this.zze.values()) {
            for (UIController onMediaStatusUpdated : it2) {
                onMediaStatusUpdated.onMediaStatusUpdated();
            }
        }
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(ImageView imageView, int i2, int i3) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(imageView, new zzbz(imageView, this.zzc, new ImageHints(i2, 0, 0), i3, (View) null, (zzby) null));
    }

    @Deprecated
    public void bindImageViewToImageOfPreloadedItem(ImageView imageView, int i2, int i3) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(imageView, new zzbw(imageView, this.zzc, new ImageHints(i2, 0, 0), i3));
    }

    public void bindImageViewToMuteToggle(ImageView imageView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        imageView.setOnClickListener(new zzb(this));
        zzl(imageView, new zzcf(imageView, this.zzc));
    }

    public void bindImageViewToPlayPauseToggle(ImageView imageView, Drawable drawable, Drawable drawable2, Drawable drawable3, View view, boolean z2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr.zzd(zzln.PAUSE_CONTROLLER);
        imageView.setOnClickListener(new zzc(this));
        zzl(imageView, new zzcg(imageView, this.zzc, drawable, drawable2, drawable3, view, z2));
    }

    public void bindProgressBar(ProgressBar progressBar) {
        bindProgressBar(progressBar, 1000);
    }

    public void bindSeekBar(SeekBar seekBar) {
        bindSeekBar(seekBar, 1000);
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView, String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        bindTextViewToMetadataOfCurrentItem(textView, (List<String>) Collections.singletonList(str));
    }

    public void bindTextViewToMetadataOfPreloadedItem(TextView textView, String str) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        bindTextViewToMetadataOfPreloadedItem(textView, (List<String>) Collections.singletonList(str));
    }

    public void bindTextViewToSmartSubtitle(TextView textView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(textView, new zzcn(textView));
    }

    public void bindTextViewToStreamDuration(TextView textView) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(textView, new zzco(textView, this.zzc.getString(R.string.cast_invalid_stream_duration_text), (View) null));
    }

    public void bindTextViewToStreamPosition(TextView textView, boolean z2) {
        bindTextViewToStreamPosition(textView, z2, 1000);
    }

    public void bindViewToClosedCaption(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzk(this));
        zzl(view, new zzbt(view, this.zzc));
    }

    public void bindViewToForward(View view, long j2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzf(this, j2));
        zzl(view, new zzbu(view, this.zza));
    }

    public void bindViewToLaunchExpandedController(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzj(this));
        zzl(view, new zzca(view));
    }

    public void bindViewToLoadingIndicator(View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(view, new zzcb(view));
    }

    public void bindViewToRewind(View view, long j2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzg(this, j2));
        zzl(view, new zzci(view, this.zza));
    }

    public void bindViewToSkipNext(View view, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zzd(this));
        zzl(view, new zzcl(view, i2));
    }

    public void bindViewToSkipPrev(View view, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        view.setOnClickListener(new zze(this));
        zzl(view, new zzcm(view, i2));
    }

    public void bindViewToUIController(View view, UIController uIController) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(view, uIController);
    }

    public void bindViewVisibilityToMediaSession(View view, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(view, new zzcs(view, i2));
    }

    public void bindViewVisibilityToPreloadingEvent(View view, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(view, new zzcr(view, i2));
    }

    public void dispose() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzg();
        this.zze.clear();
        SessionManager sessionManager = this.zzd;
        if (sessionManager != null) {
            sessionManager.removeSessionManagerListener(this, CastSession.class);
        }
        this.zzg = null;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzh;
    }

    @EnsuresNonNullIf(expression = {"remoteMediaClient"}, result = true)
    public boolean isActive() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zzh != null) {
            return true;
        }
        return false;
    }

    public void onAdBreakStatusUpdated() {
        zzm();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onAdBreakStatusUpdated();
        }
    }

    /* access modifiers changed from: protected */
    public void onClosedCaptionClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession() && (this.zzc instanceof FragmentActivity)) {
            TracksChooserDialogFragment newInstance = TracksChooserDialogFragment.newInstance();
            FragmentActivity fragmentActivity = (FragmentActivity) this.zzc;
            FragmentTransaction n2 = fragmentActivity.getSupportFragmentManager().n();
            Fragment i02 = fragmentActivity.getSupportFragmentManager().i0("TRACKS_CHOOSER_DIALOG_TAG");
            if (i02 != null) {
                n2.o(i02);
            }
            newInstance.show(n2, "TRACKS_CHOOSER_DIALOG_TAG");
        }
    }

    /* access modifiers changed from: protected */
    public void onForwardClicked(View view, long j2) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            if (remoteMediaClient.zzv()) {
                long approximateStreamPosition = remoteMediaClient.getApproximateStreamPosition() + j2;
                zza zza2 = this.zza;
                remoteMediaClient.seek(Math.min(approximateStreamPosition, ((long) zza2.zzc()) + zza2.zze()));
                return;
            }
            remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() + j2);
        }
    }

    /* access modifiers changed from: protected */
    public void onLaunchExpandedControllerClicked(View view) {
        CastMediaOptions castMediaOptions = CastContext.getSharedInstance(this.zzc).getCastOptions().getCastMediaOptions();
        if (castMediaOptions != null && !TextUtils.isEmpty(castMediaOptions.getExpandedControllerActivityClassName())) {
            ComponentName componentName = new ComponentName(this.zzc.getApplicationContext(), castMediaOptions.getExpandedControllerActivityClassName());
            Intent intent = new Intent();
            intent.setComponent(componentName);
            this.zzc.startActivity(intent);
        }
    }

    public void onMetadataUpdated() {
        zzm();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onMetadataUpdated();
        }
    }

    /* access modifiers changed from: protected */
    public void onMuteToggleClicked(ImageView imageView) {
        CastSession currentCastSession = CastContext.getSharedInstance(this.zzc.getApplicationContext()).getSessionManager().getCurrentCastSession();
        if (currentCastSession != null && currentCastSession.isConnected()) {
            try {
                currentCastSession.setMute(!currentCastSession.isMute());
            } catch (IOException | IllegalArgumentException e2) {
                zzb.e("Unable to call CastSession.setMute(boolean).", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPlayPauseToggleClicked(ImageView imageView) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            remoteMediaClient.togglePlayback();
        }
    }

    public void onPreloadStatusUpdated() {
        zzm();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onPreloadStatusUpdated();
        }
    }

    public void onQueueStatusUpdated() {
        zzm();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onQueueStatusUpdated();
        }
    }

    /* access modifiers changed from: protected */
    public void onRewindClicked(View view, long j2) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            if (remoteMediaClient.zzv()) {
                long approximateStreamPosition = remoteMediaClient.getApproximateStreamPosition() - j2;
                zza zza2 = this.zza;
                remoteMediaClient.seek(Math.max(approximateStreamPosition, ((long) zza2.zzd()) + zza2.zze()));
                return;
            }
            remoteMediaClient.seek(remoteMediaClient.getApproximateStreamPosition() - j2);
        }
    }

    /* access modifiers changed from: protected */
    public void onSeekBarProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        zzi(i2, z2);
    }

    /* access modifiers changed from: protected */
    public void onSeekBarStartTrackingTouch(SeekBar seekBar) {
        if (this.zze.containsKey(seekBar)) {
            for (UIController uIController : (List) this.zze.get(seekBar)) {
                if (uIController instanceof zzck) {
                    ((zzck) uIController).zza(false);
                }
            }
        }
        zzj();
    }

    /* access modifiers changed from: protected */
    public void onSeekBarStopTrackingTouch(SeekBar seekBar) {
        if (this.zze.containsKey(seekBar)) {
            for (UIController uIController : (List) this.zze.get(seekBar)) {
                if (uIController instanceof zzck) {
                    ((zzck) uIController).zza(true);
                }
            }
        }
        zzk(seekBar.getProgress());
    }

    public void onSendingRemoteMediaRequest() {
        for (List<UIController> it2 : this.zze.values()) {
            for (UIController onSendingRemoteMediaRequest : it2) {
                onSendingRemoteMediaRequest.onSendingRemoteMediaRequest();
            }
        }
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onSendingRemoteMediaRequest();
        }
    }

    public void onSessionEnded(CastSession castSession, int i2) {
        zzg();
    }

    public void onSessionEnding(CastSession castSession) {
    }

    public void onSessionResumeFailed(CastSession castSession, int i2) {
        zzg();
    }

    public void onSessionResumed(CastSession castSession, boolean z2) {
        zzh(castSession);
    }

    public void onSessionResuming(CastSession castSession, String str) {
    }

    public void onSessionStartFailed(CastSession castSession, int i2) {
        zzg();
    }

    public void onSessionStarted(CastSession castSession, String str) {
        zzh(castSession);
    }

    public void onSessionStarting(CastSession castSession) {
    }

    public void onSessionSuspended(CastSession castSession, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onSkipNextClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            remoteMediaClient.queueNext((JSONObject) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onSkipPrevClicked(View view) {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient != null && remoteMediaClient.hasMediaSession()) {
            remoteMediaClient.queuePrev((JSONObject) null);
        }
    }

    public void onStatusUpdated() {
        zzm();
        RemoteMediaClient.Listener listener = this.zzg;
        if (listener != null) {
            listener.onStatusUpdated();
        }
    }

    public void setPostRemoteMediaClientListener(RemoteMediaClient.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzg = listener;
    }

    public final zza zza() {
        return this.zza;
    }

    public final void zzb(ImageView imageView, ImageHints imageHints, View view, zzby zzby) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(imageView, new zzbz(imageView, this.zzc, imageHints, 0, view, zzby));
    }

    /* access modifiers changed from: protected */
    public final void zzc(CastSeekBar castSeekBar, int i2, boolean z2) {
        zzi(i2, z2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(CastSeekBar castSeekBar) {
        zzj();
    }

    /* access modifiers changed from: protected */
    public final void zze(CastSeekBar castSeekBar) {
        zzk(castSeekBar.getProgress());
    }

    public final void zzf(zzcq zzcq) {
        this.zzf.add(zzcq);
    }

    public void bindProgressBar(ProgressBar progressBar, long j2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(progressBar, new zzch(progressBar, j2));
    }

    public void bindSeekBar(SeekBar seekBar, long j2) {
        zzr.zzd(zzln.SEEK_CONTROLLER);
        Preconditions.checkMainThread("Must be called from the main thread.");
        seekBar.setOnSeekBarChangeListener(new zzi(this, seekBar));
        zzl(seekBar, new zzck(seekBar, j2, this.zza));
    }

    public void bindTextViewToStreamPosition(TextView textView, boolean z2, long j2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzcp zzcp = new zzcp(textView, j2, this.zzc.getString(R.string.cast_invalid_stream_position_text));
        if (z2) {
            this.zzf.add(zzcp);
        }
        zzl(textView, zzcp);
    }

    public void bindImageViewToImageOfPreloadedItem(ImageView imageView, ImageHints imageHints, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(imageView, new zzbw(imageView, this.zzc, imageHints, i2));
    }

    public void bindTextViewToMetadataOfCurrentItem(TextView textView, List<String> list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(textView, new zzcd(textView, list));
    }

    public void bindTextViewToMetadataOfPreloadedItem(TextView textView, List<String> list) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(textView, new zzcc(textView, list));
    }

    @Deprecated
    public void bindImageViewToImageOfCurrentItem(ImageView imageView, int i2, View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(imageView, new zzbz(imageView, this.zzc, new ImageHints(i2, 0, 0), 0, view, (zzby) null));
    }

    public void bindTextViewToStreamDuration(TextView textView, View view) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(textView, new zzco(textView, this.zzc.getString(R.string.cast_invalid_stream_duration_text), view));
    }

    public void bindSeekBar(CastSeekBar castSeekBar) {
        bindSeekBar(castSeekBar, 1000);
    }

    public void bindSeekBar(CastSeekBar castSeekBar, long j2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr.zzd(zzln.SEEK_CONTROLLER);
        castSeekBar.zzd = new zzh(this);
        zzl(castSeekBar, new zzbs(castSeekBar, j2, this.zza));
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView, ImageHints imageHints, int i2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzl(imageView, new zzbz(imageView, this.zzc, imageHints, i2, (View) null, (zzby) null));
    }

    public void bindImageViewToImageOfCurrentItem(ImageView imageView, ImageHints imageHints, View view) {
        zzb(imageView, imageHints, view, (zzby) null);
    }
}

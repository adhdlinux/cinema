package com.google.android.gms.cast.framework.media.widget;

import android.annotation.TargetApi;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.cast.AdBreakClipInfo;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.ImageHints;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzb;
import com.google.android.gms.cast.framework.media.internal.zzw;
import com.google.android.gms.cast.framework.media.uicontroller.UIMediaController;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.cast.zzct;
import com.google.android.gms.internal.cast.zzcu;
import com.google.android.gms.internal.cast.zzcv;
import com.google.android.gms.internal.cast.zzcw;
import com.google.android.gms.internal.cast.zzln;
import com.google.android.gms.internal.cast.zzr;
import com.google.protobuf.CodedOutputStream;
import java.util.Timer;

public abstract class ExpandedControllerActivity extends AppCompatActivity implements ControlButtonsContainer {
    private ImageView zzA;
    private int[] zzB;
    private final ImageView[] zzC = new ImageView[4];
    private View zzD;
    private View zzE;
    /* access modifiers changed from: private */
    public ImageView zzF;
    /* access modifiers changed from: private */
    public TextView zzG;
    private TextView zzH;
    /* access modifiers changed from: private */
    public TextView zzI;
    private TextView zzJ;
    private UIMediaController zzK;
    private SessionManager zzL;
    private Cast.Listener zzM;
    private boolean zzN;
    private Timer zzO;
    private String zzP;
    @VisibleForTesting
    final SessionManagerListener zza = new zzr(this, (zzq) null);
    @VisibleForTesting
    final RemoteMediaClient.Listener zzb = new zzp(this, (zzo) null);
    @VisibleForTesting
    zzb zzc;
    @VisibleForTesting
    boolean zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    /* access modifiers changed from: private */
    public TextView zzw;
    private SeekBar zzx;
    private CastSeekBar zzy;
    private ImageView zzz;

    /* access modifiers changed from: private */
    public final RemoteMediaClient zzj() {
        CastSession currentCastSession = this.zzL.getCurrentCastSession();
        if (currentCastSession == null || !currentCastSession.isConnected()) {
            return null;
        }
        return currentCastSession.getRemoteMediaClient();
    }

    private final void zzk(String str) {
        this.zzc.zzd(Uri.parse(str));
        this.zzE.setVisibility(8);
    }

    private final void zzl(View view, int i2, int i3, UIMediaController uIMediaController) {
        ImageView imageView = (ImageView) view.findViewById(i2);
        if (i3 == R.id.cast_button_type_empty) {
            imageView.setVisibility(4);
        } else if (i3 == R.id.cast_button_type_play_pause_toggle) {
            imageView.setBackgroundResource(this.zze);
            Drawable zzb2 = zzs.zzb(this, this.zzs, this.zzg);
            Drawable zzb3 = zzs.zzb(this, this.zzs, this.zzf);
            Drawable zzb4 = zzs.zzb(this, this.zzs, this.zzh);
            imageView.setImageDrawable(zzb3);
            uIMediaController.bindImageViewToPlayPauseToggle(imageView, zzb3, zzb2, zzb4, (View) null, false);
        } else if (i3 == R.id.cast_button_type_skip_previous) {
            imageView.setBackgroundResource(this.zze);
            imageView.setImageDrawable(zzs.zzb(this, this.zzs, this.zzi));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_prev));
            uIMediaController.bindViewToSkipPrev(imageView, 0);
        } else if (i3 == R.id.cast_button_type_skip_next) {
            imageView.setBackgroundResource(this.zze);
            imageView.setImageDrawable(zzs.zzb(this, this.zzs, this.zzj));
            imageView.setContentDescription(getResources().getString(R.string.cast_skip_next));
            uIMediaController.bindViewToSkipNext(imageView, 0);
        } else if (i3 == R.id.cast_button_type_rewind_30_seconds) {
            imageView.setBackgroundResource(this.zze);
            imageView.setImageDrawable(zzs.zzb(this, this.zzs, this.zzk));
            imageView.setContentDescription(getResources().getString(R.string.cast_rewind_30));
            uIMediaController.bindViewToRewind(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
        } else if (i3 == R.id.cast_button_type_forward_30_seconds) {
            imageView.setBackgroundResource(this.zze);
            imageView.setImageDrawable(zzs.zzb(this, this.zzs, this.zzl));
            imageView.setContentDescription(getResources().getString(R.string.cast_forward_30));
            uIMediaController.bindViewToForward(imageView, NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS);
        } else if (i3 == R.id.cast_button_type_mute_toggle) {
            imageView.setBackgroundResource(this.zze);
            imageView.setImageDrawable(zzs.zzb(this, this.zzs, this.zzm));
            uIMediaController.bindImageViewToMuteToggle(imageView);
        } else if (i3 == R.id.cast_button_type_closed_caption) {
            imageView.setBackgroundResource(this.zze);
            imageView.setImageDrawable(zzs.zzb(this, this.zzs, this.zzn));
            uIMediaController.bindViewToClosedCaption(imageView);
        }
    }

    /* access modifiers changed from: private */
    public final void zzm(RemoteMediaClient remoteMediaClient) {
        MediaStatus mediaStatus;
        if (!this.zzd && (mediaStatus = remoteMediaClient.getMediaStatus()) != null && !remoteMediaClient.isBuffering()) {
            this.zzI.setVisibility(8);
            this.zzJ.setVisibility(8);
            AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
            if (currentAdBreakClip != null && currentAdBreakClip.getWhenSkippableInMs() != -1) {
                if (!this.zzN) {
                    zzk zzk2 = new zzk(this, remoteMediaClient);
                    Timer timer = new Timer();
                    this.zzO = timer;
                    timer.scheduleAtFixedRate(zzk2, 0, 500);
                    this.zzN = true;
                }
                float whenSkippableInMs = (float) (currentAdBreakClip.getWhenSkippableInMs() - remoteMediaClient.getApproximateAdBreakClipPositionMs());
                if (whenSkippableInMs <= 0.0f) {
                    if (this.zzN) {
                        this.zzO.cancel();
                        this.zzN = false;
                    }
                    this.zzI.setVisibility(0);
                    this.zzI.setClickable(true);
                    return;
                }
                this.zzJ.setVisibility(0);
                this.zzJ.setText(getResources().getString(R.string.cast_expanded_controller_skip_ad_text, new Object[]{Integer.valueOf((int) Math.ceil((double) (whenSkippableInMs / 1000.0f)))}));
                this.zzI.setClickable(false);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzn() {
        CastDevice castDevice;
        CastSession currentCastSession = this.zzL.getCurrentCastSession();
        if (!(currentCastSession == null || (castDevice = currentCastSession.getCastDevice()) == null)) {
            String friendlyName = castDevice.getFriendlyName();
            if (!TextUtils.isEmpty(friendlyName)) {
                this.zzw.setText(getResources().getString(R.string.cast_casting_to_device, new Object[]{friendlyName}));
                return;
            }
        }
        this.zzw.setText("");
    }

    /* access modifiers changed from: private */
    public final void zzo() {
        MediaInfo mediaInfo;
        MediaMetadata metadata;
        ActionBar supportActionBar;
        RemoteMediaClient zzj2 = zzj();
        if (zzj2 != null && zzj2.hasMediaSession() && (mediaInfo = zzj2.getMediaInfo()) != null && (metadata = mediaInfo.getMetadata()) != null && (supportActionBar = getSupportActionBar()) != null) {
            supportActionBar.B(metadata.getString(MediaMetadata.KEY_TITLE));
            String zze2 = zzw.zze(metadata);
            if (zze2 != null) {
                supportActionBar.A(zze2);
            }
        }
    }

    /* access modifiers changed from: private */
    @TargetApi(23)
    public final void zzp() {
        MediaStatus mediaStatus;
        String str;
        Drawable drawable;
        Bitmap bitmap;
        Bitmap zza2;
        RemoteMediaClient zzj2 = zzj();
        if (zzj2 != null && (mediaStatus = zzj2.getMediaStatus()) != null) {
            String str2 = null;
            if (mediaStatus.isPlayingAd()) {
                if (!(this.zzA.getVisibility() != 8 || (drawable = this.zzz.getDrawable()) == null || !(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || (zza2 = zzs.zza(this, bitmap, 0.25f, 7.5f)) == null)) {
                    this.zzA.setImageBitmap(zza2);
                    this.zzA.setVisibility(0);
                }
                AdBreakClipInfo currentAdBreakClip = mediaStatus.getCurrentAdBreakClip();
                if (currentAdBreakClip != null) {
                    String title = currentAdBreakClip.getTitle();
                    str2 = currentAdBreakClip.getImageUrl();
                    str = title;
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    zzk(str2);
                } else if (!TextUtils.isEmpty(this.zzP)) {
                    zzk(this.zzP);
                } else {
                    this.zzG.setVisibility(0);
                    this.zzE.setVisibility(0);
                    this.zzF.setVisibility(8);
                }
                TextView textView = this.zzH;
                if (TextUtils.isEmpty(str)) {
                    str = getResources().getString(R.string.cast_ad_label);
                }
                textView.setText(str);
                if (PlatformVersion.isAtLeastM()) {
                    this.zzH.setTextAppearance(this.zzt);
                } else {
                    this.zzH.setTextAppearance(this, this.zzt);
                }
                this.zzD.setVisibility(0);
                zzm(zzj2);
                return;
            }
            this.zzJ.setVisibility(8);
            this.zzI.setVisibility(8);
            this.zzD.setVisibility(8);
            this.zzA.setVisibility(8);
            this.zzA.setImageBitmap((Bitmap) null);
        }
    }

    public final ImageView getButtonImageViewAt(int i2) throws IndexOutOfBoundsException {
        return this.zzC[i2];
    }

    public final int getButtonSlotCount() {
        return 4;
    }

    public final int getButtonTypeAt(int i2) throws IndexOutOfBoundsException {
        return this.zzB[i2];
    }

    @Deprecated
    public SeekBar getSeekBar() {
        return this.zzx;
    }

    public TextView getStatusTextView() {
        return this.zzw;
    }

    public UIMediaController getUIMediaController() {
        return this.zzK;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        boolean z2;
        super.onCreate(bundle);
        SessionManager sessionManager = CastContext.getSharedInstance(this).getSessionManager();
        this.zzL = sessionManager;
        if (sessionManager.getCurrentCastSession() == null) {
            finish();
        }
        UIMediaController uIMediaController = new UIMediaController(this);
        this.zzK = uIMediaController;
        uIMediaController.setPostRemoteMediaClientListener(this.zzb);
        setContentView(R.layout.cast_expanded_controller_activity);
        TypedArray obtainStyledAttributes = obtainStyledAttributes(new int[]{R$attr.P});
        this.zze = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = obtainStyledAttributes((AttributeSet) null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        this.zzs = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castButtonColor, 0);
        this.zzf = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castPlayButtonDrawable, 0);
        this.zzg = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castPauseButtonDrawable, 0);
        this.zzh = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castStopButtonDrawable, 0);
        this.zzi = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castSkipPreviousButtonDrawable, 0);
        this.zzj = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castSkipNextButtonDrawable, 0);
        this.zzk = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castRewind30ButtonDrawable, 0);
        this.zzl = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castForward30ButtonDrawable, 0);
        this.zzm = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castMuteToggleButtonDrawable, 0);
        this.zzn = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castClosedCaptionsButtonDrawable, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castControlButtons, 0);
        if (resourceId != 0) {
            TypedArray obtainTypedArray = getResources().obtainTypedArray(resourceId);
            if (obtainTypedArray.length() == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            Preconditions.checkArgument(z2);
            this.zzB = new int[obtainTypedArray.length()];
            for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                this.zzB[i2] = obtainTypedArray.getResourceId(i2, 0);
            }
            obtainTypedArray.recycle();
        } else {
            int i3 = R.id.cast_button_type_empty;
            this.zzB = new int[]{i3, i3, i3, i3};
        }
        this.zzr = obtainStyledAttributes2.getColor(R.styleable.CastExpandedController_castExpandedControllerLoadingIndicatorColor, 0);
        this.zzo = getResources().getColor(obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelColor, 0));
        this.zzp = getResources().getColor(obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressTextColor, 0));
        this.zzq = getResources().getColor(obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelTextColor, 0));
        this.zzt = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdLabelTextAppearance, 0);
        this.zzu = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressLabelTextAppearance, 0);
        this.zzv = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castAdInProgressText, 0);
        int resourceId2 = obtainStyledAttributes2.getResourceId(R.styleable.CastExpandedController_castDefaultAdPosterUrl, 0);
        if (resourceId2 != 0) {
            this.zzP = getApplicationContext().getResources().getString(resourceId2);
        }
        obtainStyledAttributes2.recycle();
        View findViewById = findViewById(R.id.expanded_controller_layout);
        UIMediaController uIMediaController2 = this.zzK;
        this.zzz = (ImageView) findViewById.findViewById(R.id.background_image_view);
        this.zzA = (ImageView) findViewById.findViewById(R.id.blurred_background_image_view);
        View findViewById2 = findViewById.findViewById(R.id.background_place_holder_image_view);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        uIMediaController2.zzb(this.zzz, new ImageHints(4, displayMetrics.widthPixels, displayMetrics.heightPixels), findViewById2, new zzn(this, (zzm) null));
        this.zzw = (TextView) findViewById.findViewById(R.id.status_text);
        ProgressBar progressBar = (ProgressBar) findViewById.findViewById(R.id.loading_indicator);
        Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
        int i4 = this.zzr;
        if (i4 != 0) {
            indeterminateDrawable.setColorFilter(i4, PorterDuff.Mode.SRC_IN);
        }
        uIMediaController2.bindViewToLoadingIndicator(progressBar);
        TextView textView = (TextView) findViewById.findViewById(R.id.start_text);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.end_text);
        this.zzx = (SeekBar) findViewById.findViewById(R.id.seek_bar);
        CastSeekBar castSeekBar = (CastSeekBar) findViewById.findViewById(R.id.cast_seek_bar);
        this.zzy = castSeekBar;
        uIMediaController2.bindSeekBar(castSeekBar, 1000);
        uIMediaController2.bindViewToUIController(textView, new zzcv(textView, uIMediaController2.zza()));
        uIMediaController2.bindViewToUIController(textView2, new zzct(textView2, uIMediaController2.zza()));
        View findViewById3 = findViewById.findViewById(R.id.live_indicators);
        uIMediaController2.bindViewToUIController(findViewById3, new zzcu(findViewById3, uIMediaController2.zza()));
        RelativeLayout relativeLayout = (RelativeLayout) findViewById.findViewById(R.id.tooltip_container);
        zzcw zzcw = new zzcw(relativeLayout, this.zzy, uIMediaController2.zza());
        uIMediaController2.bindViewToUIController(relativeLayout, zzcw);
        uIMediaController2.zzf(zzcw);
        ImageView[] imageViewArr = this.zzC;
        int i5 = R.id.button_0;
        imageViewArr[0] = (ImageView) findViewById.findViewById(i5);
        ImageView[] imageViewArr2 = this.zzC;
        int i6 = R.id.button_1;
        imageViewArr2[1] = (ImageView) findViewById.findViewById(i6);
        ImageView[] imageViewArr3 = this.zzC;
        int i7 = R.id.button_2;
        imageViewArr3[2] = (ImageView) findViewById.findViewById(i7);
        ImageView[] imageViewArr4 = this.zzC;
        int i8 = R.id.button_3;
        imageViewArr4[3] = (ImageView) findViewById.findViewById(i8);
        zzl(findViewById, i5, this.zzB[0], uIMediaController2);
        zzl(findViewById, i6, this.zzB[1], uIMediaController2);
        zzl(findViewById, R.id.button_play_pause_toggle, R.id.cast_button_type_play_pause_toggle, uIMediaController2);
        zzl(findViewById, i7, this.zzB[2], uIMediaController2);
        zzl(findViewById, i8, this.zzB[3], uIMediaController2);
        View findViewById4 = findViewById(R.id.ad_container);
        this.zzD = findViewById4;
        this.zzF = (ImageView) findViewById4.findViewById(R.id.ad_image_view);
        this.zzE = this.zzD.findViewById(R.id.ad_background_image_view);
        TextView textView3 = (TextView) this.zzD.findViewById(R.id.ad_label);
        this.zzH = textView3;
        textView3.setTextColor(this.zzq);
        this.zzH.setBackgroundColor(this.zzo);
        this.zzG = (TextView) this.zzD.findViewById(R.id.ad_in_progress_label);
        this.zzJ = (TextView) findViewById(R.id.ad_skip_text);
        TextView textView4 = (TextView) findViewById(R.id.ad_skip_button);
        this.zzI = textView4;
        textView4.setOnClickListener(new zzi(this));
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.w(R.drawable.quantum_ic_keyboard_arrow_down_white_36);
        }
        zzn();
        zzo();
        if (!(this.zzG == null || this.zzv == 0)) {
            if (PlatformVersion.isAtLeastM()) {
                this.zzG.setTextAppearance(this.zzu);
            } else {
                this.zzG.setTextAppearance(getApplicationContext(), this.zzu);
            }
            this.zzG.setTextColor(this.zzp);
            this.zzG.setText(this.zzv);
        }
        zzb zzb2 = new zzb(getApplicationContext(), new ImageHints(-1, this.zzF.getWidth(), this.zzF.getHeight()));
        this.zzc = zzb2;
        zzb2.zzc(new zzh(this));
        zzr.zzd(zzln.CAF_EXPANDED_CONTROLLER);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.zzc.zza();
        UIMediaController uIMediaController = this.zzK;
        if (uIMediaController != null) {
            uIMediaController.setPostRemoteMediaClientListener((RemoteMediaClient.Listener) null);
            this.zzK.dispose();
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return true;
        }
        finish();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        SessionManager sessionManager = this.zzL;
        if (sessionManager != null) {
            CastSession currentCastSession = sessionManager.getCurrentCastSession();
            Cast.Listener listener = this.zzM;
            if (!(listener == null || currentCastSession == null)) {
                currentCastSession.removeCastListener(listener);
                this.zzM = null;
            }
            this.zzL.removeSessionManagerListener(this.zza, CastSession.class);
            super.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        SessionManager sessionManager = this.zzL;
        if (sessionManager != null) {
            sessionManager.addSessionManagerListener(this.zza, CastSession.class);
            CastSession currentCastSession = this.zzL.getCurrentCastSession();
            if (currentCastSession == null || (!currentCastSession.isConnected() && !currentCastSession.isConnecting())) {
                finish();
            } else {
                zzl zzl2 = new zzl(this);
                this.zzM = zzl2;
                currentCastSession.addCastListener(zzl2);
            }
            RemoteMediaClient zzj2 = zzj();
            boolean z2 = true;
            if (zzj2 != null && zzj2.hasMediaSession()) {
                z2 = false;
            }
            this.zzd = z2;
            zzn();
            zzp();
            super.onResume();
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility() ^ 2;
            if (PlatformVersion.isAtLeastJellyBean()) {
                systemUiVisibility ^= 4;
            }
            if (PlatformVersion.isAtLeastKitKat()) {
                systemUiVisibility ^= CodedOutputStream.DEFAULT_BUFFER_SIZE;
            }
            getWindow().getDecorView().setSystemUiVisibility(systemUiVisibility);
            setImmersive(true);
        }
    }
}

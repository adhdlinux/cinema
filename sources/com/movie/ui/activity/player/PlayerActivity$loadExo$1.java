package com.movie.ui.activity.player;

import android.annotation.SuppressLint;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.e;
import androidx.media3.common.text.CueGroup;
import androidx.media3.exoplayer.ExoPlayer;
import com.movie.ui.activity.player.event.ErrorEvent;
import com.movie.ui.activity.player.event.Loading;
import com.movie.ui.activity.player.event.PlayerEventSource;
import com.movie.ui.activity.player.event.RequestAudioFocusEvent;
import com.movie.ui.activity.player.event.ResizedEvent;
import com.movie.ui.activity.player.event.StatusEvent;
import com.movie.ui.activity.player.event.VideoEndedEvent;
import com.original.tase.helper.http.cloudflare.WebViewResolverKt;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.yoku.marumovie.databinding.CustomPlayerControllViewBinding;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class PlayerActivity$loadExo$1 implements Player.Listener {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ PlayerActivity f32403b;

    PlayerActivity$loadExo$1(PlayerActivity playerActivity) {
        this.f32403b = playerActivity;
    }

    public /* synthetic */ void A(CueGroup cueGroup) {
        e.b(this, cueGroup);
    }

    public /* synthetic */ void B(Metadata metadata) {
        e.l(this, metadata);
    }

    public /* synthetic */ void F(MediaMetadata mediaMetadata) {
        e.k(this, mediaMetadata);
    }

    public /* synthetic */ void G(TrackSelectionParameters trackSelectionParameters) {
        e.B(this, trackSelectionParameters);
    }

    public /* synthetic */ void H(MediaItem mediaItem, int i2) {
        e.j(this, mediaItem, i2);
    }

    public void I(PlaybackException playbackException) {
        Intrinsics.f(playbackException, MRAIDPresenter.ERROR);
        if (playbackException.f4300b == 2001) {
            ExoPlayer n02 = this.f32403b.f32364e;
            boolean z2 = false;
            if (n02 != null && n02.getDuration() == -9223372036854775807L) {
                z2 = true;
            }
            if (!z2) {
                ExoPlayer n03 = this.f32403b.f32364e;
                if (n03 != null) {
                    n03.prepare();
                }
                e.q(this, playbackException);
            }
        }
        if (playbackException.f4300b == 1002) {
            ExoPlayer n04 = this.f32403b.f32364e;
            if (n04 != null) {
                n04.h();
            }
            ExoPlayer n05 = this.f32403b.f32364e;
            if (n05 != null) {
                n05.prepare();
            }
        } else {
            this.f32403b.V0(new ErrorEvent(playbackException, (PlayerEventSource) null, 2, (DefaultConstructorMarker) null));
        }
        e.q(this, playbackException);
    }

    public /* synthetic */ void L(Player.Commands commands) {
        e.a(this, commands);
    }

    public /* synthetic */ void P(Player player, Player.Events events) {
        e.f(this, player, events);
    }

    public /* synthetic */ void U(Timeline timeline, int i2) {
        e.A(this, timeline, i2);
    }

    public void V(Tracks tracks) {
        Intrinsics.f(tracks, "tracks");
        WebViewResolverKt.f(new PlayerActivity$loadExo$1$onTracksChanged$1(tracks, this.f32403b));
    }

    public /* synthetic */ void W(DeviceInfo deviceInfo) {
        e.d(this, deviceInfo);
    }

    public /* synthetic */ void X(PlaybackException playbackException) {
        e.r(this, playbackException);
    }

    public /* synthetic */ void a0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        e.u(this, positionInfo, positionInfo2, i2);
    }

    public void n(VideoSize videoSize) {
        Intrinsics.f(videoSize, "videoSize");
        e.D(this, videoSize);
        this.f32403b.V0(new ResizedEvent(videoSize.f4489b, videoSize.f4488a, (PlayerEventSource) null, 4, (DefaultConstructorMarker) null));
    }

    public /* synthetic */ void onCues(List list) {
        e.c(this, list);
    }

    public /* synthetic */ void onDeviceVolumeChanged(int i2, boolean z2) {
        e.e(this, i2, z2);
    }

    public /* synthetic */ void onIsLoadingChanged(boolean z2) {
        e.g(this, z2);
    }

    public void onIsPlayingChanged(boolean z2) {
        e.h(this, z2);
        if (z2) {
            this.f32403b.V0(new RequestAudioFocusEvent((PlayerEventSource) null, 1, (DefaultConstructorMarker) null));
        }
    }

    public /* synthetic */ void onLoadingChanged(boolean z2) {
        e.i(this, z2);
    }

    public /* synthetic */ void onPlayWhenReadyChanged(boolean z2, int i2) {
        e.m(this, z2, i2);
    }

    public void onPlaybackStateChanged(int i2) {
        e.o(this, i2);
        if (i2 == 3) {
            this.f32403b.i1();
        }
    }

    public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
        e.p(this, i2);
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    public void onPlayerStateChanged(boolean z2, int i2) {
        boolean z3;
        Loading loading;
        Loading loading2;
        ExoPlayer n02 = this.f32403b.f32364e;
        if (n02 != null) {
            PlayerActivity playerActivity = this.f32403b;
            ExoPlayer n03 = playerActivity.f32364e;
            if (n03 == null || !n03.isPlaying()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                loading = Loading.IsPlaying;
            } else {
                loading = Loading.IsPaused;
            }
            Loading loading3 = loading;
            if (i2 == 2) {
                loading2 = Loading.IsBuffering;
            } else if (n02.isPlaying()) {
                loading2 = Loading.IsPlaying;
            } else {
                loading2 = Loading.IsPaused;
            }
            playerActivity.V0(new StatusEvent(loading3, loading2, (PlayerEventSource) null, 4, (DefaultConstructorMarker) null));
        }
        if (!z2) {
            return;
        }
        if (i2 == 1) {
            CustomPlayerControllViewBinding P0 = this.f32403b.P0();
            if (P0 != null) {
                FrameLayout frameLayout = P0.F;
                Intrinsics.e(frameLayout, "playerPausePlayHolderHolder");
                frameLayout.setVisibility(0);
                ProgressBar progressBar = P0.f38130s;
                Intrinsics.e(progressBar, "playerBuffering");
                progressBar.setVisibility(8);
            }
        } else if (i2 == 2) {
            CustomPlayerControllViewBinding P02 = this.f32403b.P0();
            if (P02 != null) {
                FrameLayout frameLayout2 = P02.F;
                Intrinsics.e(frameLayout2, "playerPausePlayHolderHolder");
                frameLayout2.setVisibility(8);
                ProgressBar progressBar2 = P02.f38130s;
                Intrinsics.e(progressBar2, "playerBuffering");
                progressBar2.setVisibility(0);
            }
        } else if (i2 == 3) {
            CustomPlayerControllViewBinding P03 = this.f32403b.P0();
            if (P03 != null) {
                FrameLayout frameLayout3 = P03.F;
                Intrinsics.e(frameLayout3, "playerPausePlayHolderHolder");
                frameLayout3.setVisibility(0);
                ProgressBar progressBar3 = P03.f38130s;
                Intrinsics.e(progressBar3, "playerBuffering");
                progressBar3.setVisibility(8);
            }
            this.f32403b.v0();
        } else if (i2 == 4) {
            this.f32403b.V0(new VideoEndedEvent((PlayerEventSource) null, 1, (DefaultConstructorMarker) null));
        }
    }

    public /* synthetic */ void onPositionDiscontinuity(int i2) {
        e.t(this, i2);
    }

    public void onRenderedFirstFrame() {
        e.v(this);
    }

    public /* synthetic */ void onRepeatModeChanged(int i2) {
        e.w(this, i2);
    }

    public /* synthetic */ void onShuffleModeEnabledChanged(boolean z2) {
        e.x(this, z2);
    }

    public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z2) {
        e.y(this, z2);
    }

    public /* synthetic */ void onSurfaceSizeChanged(int i2, int i3) {
        e.z(this, i2, i3);
    }

    public /* synthetic */ void r(PlaybackParameters playbackParameters) {
        e.n(this, playbackParameters);
    }
}

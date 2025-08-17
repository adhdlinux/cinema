package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.x1;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import t0.e;
import t0.f;
import t0.g;

public class StyledPlayerControlView extends FrameLayout {
    private static final float[] F0 = {0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    /* access modifiers changed from: private */
    public final View A;
    /* access modifiers changed from: private */
    public final View B;
    /* access modifiers changed from: private */
    public final View C;
    private final TextView D;
    /* access modifiers changed from: private */
    public final TextView E;
    private final TimeBar F;
    /* access modifiers changed from: private */
    public final StringBuilder G;
    /* access modifiers changed from: private */
    public final Formatter H;
    private final Timeline.Period I;
    private final Timeline.Window J;
    private final Runnable K;
    private final Drawable L;
    private final Drawable M;
    private final Drawable N;
    private final String O;
    private final String P;
    private final String Q;
    private final Drawable R;
    private final Drawable S;
    private final float T;
    private final float U;
    private final String V;
    private final String W;
    /* access modifiers changed from: private */

    /* renamed from: a0  reason: collision with root package name */
    public final Drawable f28088a0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final StyledPlayerControlViewLayoutManager f28089b;
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public final Drawable f28090b0;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f28091c;
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public final String f28092c0;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentListener f28093d;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public final String f28094d0;

    /* renamed from: e  reason: collision with root package name */
    private final CopyOnWriteArrayList<VisibilityListener> f28095e;

    /* renamed from: e0  reason: collision with root package name */
    private final Drawable f28096e0;

    /* renamed from: f  reason: collision with root package name */
    private final RecyclerView f28097f;

    /* renamed from: f0  reason: collision with root package name */
    private final Drawable f28098f0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final SettingsAdapter f28099g;

    /* renamed from: g0  reason: collision with root package name */
    private final String f28100g0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final PlaybackSpeedAdapter f28101h;

    /* renamed from: h0  reason: collision with root package name */
    private final String f28102h0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final TextTrackSelectionAdapter f28103i;
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public Player f28104i0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final AudioTrackSelectionAdapter f28105j;

    /* renamed from: j0  reason: collision with root package name */
    private OnFullScreenModeChangedListener f28106j0;

    /* renamed from: k  reason: collision with root package name */
    private final TrackNameProvider f28107k;

    /* renamed from: k0  reason: collision with root package name */
    private boolean f28108k0;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final PopupWindow f28109l;

    /* renamed from: l0  reason: collision with root package name */
    private boolean f28110l0;

    /* renamed from: m  reason: collision with root package name */
    private final int f28111m;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f28112m0;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final View f28113n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f28114n0;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final View f28115o;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public boolean f28116o0;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final View f28117p;

    /* renamed from: p0  reason: collision with root package name */
    private int f28118p0;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final View f28119q;

    /* renamed from: q0  reason: collision with root package name */
    private int f28120q0;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final View f28121r;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public int f28122r0;

    /* renamed from: s  reason: collision with root package name */
    private final TextView f28123s;

    /* renamed from: s0  reason: collision with root package name */
    private long[] f28124s0;

    /* renamed from: t  reason: collision with root package name */
    private final TextView f28125t;

    /* renamed from: t0  reason: collision with root package name */
    private boolean[] f28126t0;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final ImageView f28127u;

    /* renamed from: u0  reason: collision with root package name */
    private long[] f28128u0;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public final ImageView f28129v;

    /* renamed from: v0  reason: collision with root package name */
    private boolean[] f28130v0;

    /* renamed from: w  reason: collision with root package name */
    private final View f28131w;

    /* renamed from: w0  reason: collision with root package name */
    private long f28132w0;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final ImageView f28133x;
    /* access modifiers changed from: private */

    /* renamed from: x0  reason: collision with root package name */
    public boolean f28134x0;

    /* renamed from: y  reason: collision with root package name */
    private final ImageView f28135y;

    /* renamed from: z  reason: collision with root package name */
    private final ImageView f28136z;

    private final class AudioTrackSelectionAdapter extends TrackSelectionAdapter {
        private AudioTrackSelectionAdapter() {
            super();
        }

        private boolean k(TrackSelectionParameters trackSelectionParameters) {
            for (int i2 = 0; i2 < this.f28157n.size(); i2++) {
                if (trackSelectionParameters.f27791z.containsKey(this.f28157n.get(i2).f28154a.b())) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            if (StyledPlayerControlView.this.f28104i0 != null && StyledPlayerControlView.this.f28104i0.q(29)) {
                ((Player) Util.j(StyledPlayerControlView.this.f28104i0)).a0(StyledPlayerControlView.this.f28104i0.v().A().B(1).J(1, false).A());
                StyledPlayerControlView.this.f28099g.f(1, StyledPlayerControlView.this.getResources().getString(R$string.f28023w));
                StyledPlayerControlView.this.f28109l.dismiss();
            }
        }

        public void g(SubSettingViewHolder subSettingViewHolder) {
            int i2;
            subSettingViewHolder.f28151j.setText(R$string.f28023w);
            boolean k2 = k(((Player) Assertions.e(StyledPlayerControlView.this.f28104i0)).v());
            View view = subSettingViewHolder.f28152k;
            if (k2) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            view.setVisibility(i2);
            subSettingViewHolder.itemView.setOnClickListener(new c(this));
        }

        public void i(String str) {
            StyledPlayerControlView.this.f28099g.f(1, str);
        }

        public void l(List<TrackInformation> list) {
            this.f28157n = list;
            TrackSelectionParameters v2 = ((Player) Assertions.e(StyledPlayerControlView.this.f28104i0)).v();
            if (list.isEmpty()) {
                StyledPlayerControlView.this.f28099g.f(1, StyledPlayerControlView.this.getResources().getString(R$string.f28024x));
            } else if (!k(v2)) {
                StyledPlayerControlView.this.f28099g.f(1, StyledPlayerControlView.this.getResources().getString(R$string.f28023w));
            } else {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    TrackInformation trackInformation = list.get(i2);
                    if (trackInformation.a()) {
                        StyledPlayerControlView.this.f28099g.f(1, trackInformation.f28156c);
                        return;
                    }
                }
            }
        }
    }

    private final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {
        private ComponentListener() {
        }

        public /* synthetic */ void onAvailableCommandsChanged(Player.Commands commands) {
            x1.c(this, commands);
        }

        public void onClick(View view) {
            Player j2 = StyledPlayerControlView.this.f28104i0;
            if (j2 != null) {
                StyledPlayerControlView.this.f28089b.W();
                if (StyledPlayerControlView.this.f28115o == view) {
                    if (j2.q(9)) {
                        j2.w();
                    }
                } else if (StyledPlayerControlView.this.f28113n == view) {
                    if (j2.q(7)) {
                        j2.j();
                    }
                } else if (StyledPlayerControlView.this.f28119q == view) {
                    if (j2.getPlaybackState() != 4 && j2.q(12)) {
                        j2.Q();
                    }
                } else if (StyledPlayerControlView.this.f28121r == view) {
                    if (j2.q(11)) {
                        j2.R();
                    }
                } else if (StyledPlayerControlView.this.f28117p == view) {
                    StyledPlayerControlView.this.X(j2);
                } else if (StyledPlayerControlView.this.f28127u == view) {
                    if (j2.q(15)) {
                        j2.setRepeatMode(RepeatModeUtil.a(j2.getRepeatMode(), StyledPlayerControlView.this.f28122r0));
                    }
                } else if (StyledPlayerControlView.this.f28129v == view) {
                    if (j2.q(14)) {
                        j2.B(!j2.O());
                    }
                } else if (StyledPlayerControlView.this.A == view) {
                    StyledPlayerControlView.this.f28089b.V();
                    StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                    styledPlayerControlView.Y(styledPlayerControlView.f28099g, StyledPlayerControlView.this.A);
                } else if (StyledPlayerControlView.this.B == view) {
                    StyledPlayerControlView.this.f28089b.V();
                    StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                    styledPlayerControlView2.Y(styledPlayerControlView2.f28101h, StyledPlayerControlView.this.B);
                } else if (StyledPlayerControlView.this.C == view) {
                    StyledPlayerControlView.this.f28089b.V();
                    StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                    styledPlayerControlView3.Y(styledPlayerControlView3.f28105j, StyledPlayerControlView.this.C);
                } else if (StyledPlayerControlView.this.f28133x == view) {
                    StyledPlayerControlView.this.f28089b.V();
                    StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                    styledPlayerControlView4.Y(styledPlayerControlView4.f28103i, StyledPlayerControlView.this.f28133x);
                }
            }
        }

        public /* synthetic */ void onCues(CueGroup cueGroup) {
            x1.d(this, cueGroup);
        }

        public /* synthetic */ void onCues(List list) {
            x1.e(this, list);
        }

        public /* synthetic */ void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            x1.f(this, deviceInfo);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i2, boolean z2) {
            x1.g(this, i2, z2);
        }

        public void onDismiss() {
            if (StyledPlayerControlView.this.f28134x0) {
                StyledPlayerControlView.this.f28089b.W();
            }
        }

        public void onEvents(Player player, Player.Events events) {
            if (events.b(4, 5, 13)) {
                StyledPlayerControlView.this.y0();
            }
            if (events.b(4, 5, 7, 13)) {
                StyledPlayerControlView.this.A0();
            }
            if (events.b(8, 13)) {
                StyledPlayerControlView.this.B0();
            }
            if (events.b(9, 13)) {
                StyledPlayerControlView.this.F0();
            }
            if (events.b(8, 9, 11, 0, 16, 17, 13)) {
                StyledPlayerControlView.this.x0();
            }
            if (events.b(11, 0, 13)) {
                StyledPlayerControlView.this.G0();
            }
            if (events.b(12, 13)) {
                StyledPlayerControlView.this.z0();
            }
            if (events.b(2, 13)) {
                StyledPlayerControlView.this.H0();
            }
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z2) {
            x1.i(this, z2);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z2) {
            x1.j(this, z2);
        }

        public /* synthetic */ void onLoadingChanged(boolean z2) {
            x1.k(this, z2);
        }

        public /* synthetic */ void onMediaItemTransition(MediaItem mediaItem, int i2) {
            x1.m(this, mediaItem, i2);
        }

        public /* synthetic */ void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            x1.n(this, mediaMetadata);
        }

        public /* synthetic */ void onMetadata(Metadata metadata) {
            x1.o(this, metadata);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z2, int i2) {
            x1.p(this, z2, i2);
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            x1.q(this, playbackParameters);
        }

        public /* synthetic */ void onPlaybackStateChanged(int i2) {
            x1.r(this, i2);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
            x1.s(this, i2);
        }

        public /* synthetic */ void onPlayerError(PlaybackException playbackException) {
            x1.t(this, playbackException);
        }

        public /* synthetic */ void onPlayerErrorChanged(PlaybackException playbackException) {
            x1.u(this, playbackException);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z2, int i2) {
            x1.v(this, z2, i2);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i2) {
            x1.x(this, i2);
        }

        public /* synthetic */ void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
            x1.y(this, positionInfo, positionInfo2, i2);
        }

        public /* synthetic */ void onRenderedFirstFrame() {
            x1.z(this);
        }

        public /* synthetic */ void onRepeatModeChanged(int i2) {
            x1.A(this, i2);
        }

        public /* synthetic */ void onSeekProcessed() {
            x1.D(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z2) {
            x1.E(this, z2);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(boolean z2) {
            x1.F(this, z2);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i2, int i3) {
            x1.G(this, i2, i3);
        }

        public /* synthetic */ void onTimelineChanged(Timeline timeline, int i2) {
            x1.H(this, timeline, i2);
        }

        public /* synthetic */ void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            x1.I(this, trackSelectionParameters);
        }

        public /* synthetic */ void onTracksChanged(Tracks tracks) {
            x1.J(this, tracks);
        }

        public /* synthetic */ void onVideoSizeChanged(VideoSize videoSize) {
            x1.K(this, videoSize);
        }

        public /* synthetic */ void onVolumeChanged(float f2) {
            x1.L(this, f2);
        }

        public void p(TimeBar timeBar, long j2) {
            if (StyledPlayerControlView.this.E != null) {
                StyledPlayerControlView.this.E.setText(Util.i0(StyledPlayerControlView.this.G, StyledPlayerControlView.this.H, j2));
            }
        }

        public void r(TimeBar timeBar, long j2, boolean z2) {
            boolean unused = StyledPlayerControlView.this.f28116o0 = false;
            if (!z2 && StyledPlayerControlView.this.f28104i0 != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.o0(styledPlayerControlView.f28104i0, j2);
            }
            StyledPlayerControlView.this.f28089b.W();
        }

        public void u(TimeBar timeBar, long j2) {
            boolean unused = StyledPlayerControlView.this.f28116o0 = true;
            if (StyledPlayerControlView.this.E != null) {
                StyledPlayerControlView.this.E.setText(Util.i0(StyledPlayerControlView.this.G, StyledPlayerControlView.this.H, j2));
            }
            StyledPlayerControlView.this.f28089b.V();
        }
    }

    @Deprecated
    public interface OnFullScreenModeChangedListener {
        void p(boolean z2);
    }

    private final class PlaybackSpeedAdapter extends RecyclerView.Adapter<SubSettingViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        private final String[] f28139n;

        /* renamed from: o  reason: collision with root package name */
        private final float[] f28140o;

        /* renamed from: p  reason: collision with root package name */
        private int f28141p;

        public PlaybackSpeedAdapter(String[] strArr, float[] fArr) {
            this.f28139n = strArr;
            this.f28140o = fArr;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(int i2, View view) {
            if (i2 != this.f28141p) {
                StyledPlayerControlView.this.setPlaybackSpeed(this.f28140o[i2]);
            }
            StyledPlayerControlView.this.f28109l.dismiss();
        }

        public String d() {
            return this.f28139n[this.f28141p];
        }

        /* renamed from: f */
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i2) {
            String[] strArr = this.f28139n;
            if (i2 < strArr.length) {
                subSettingViewHolder.f28151j.setText(strArr[i2]);
            }
            if (i2 == this.f28141p) {
                subSettingViewHolder.itemView.setSelected(true);
                subSettingViewHolder.f28152k.setVisibility(0);
            } else {
                subSettingViewHolder.itemView.setSelected(false);
                subSettingViewHolder.f28152k.setVisibility(4);
            }
            subSettingViewHolder.itemView.setOnClickListener(new d(this, i2));
        }

        /* renamed from: g */
        public SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new SubSettingViewHolder(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.f27998h, viewGroup, false));
        }

        public int getItemCount() {
            return this.f28139n.length;
        }

        public void h(float f2) {
            int i2 = 0;
            int i3 = 0;
            float f3 = Float.MAX_VALUE;
            while (true) {
                float[] fArr = this.f28140o;
                if (i2 < fArr.length) {
                    float abs = Math.abs(f2 - fArr[i2]);
                    if (abs < f3) {
                        i3 = i2;
                        f3 = abs;
                    }
                    i2++;
                } else {
                    this.f28141p = i3;
                    return;
                }
            }
        }
    }

    public interface ProgressUpdateListener {
    }

    private final class SettingViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public final TextView f28143j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public final TextView f28144k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public final ImageView f28145l;

        public SettingViewHolder(View view) {
            super(view);
            if (Util.f28808a < 26) {
                view.setFocusable(true);
            }
            this.f28143j = (TextView) view.findViewById(R$id.f27983u);
            this.f28144k = (TextView) view.findViewById(R$id.P);
            this.f28145l = (ImageView) view.findViewById(R$id.f27982t);
            view.setOnClickListener(new e(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            StyledPlayerControlView.this.l0(getAdapterPosition());
        }
    }

    private class SettingsAdapter extends RecyclerView.Adapter<SettingViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        private final String[] f28147n;

        /* renamed from: o  reason: collision with root package name */
        private final String[] f28148o;

        /* renamed from: p  reason: collision with root package name */
        private final Drawable[] f28149p;

        public SettingsAdapter(String[] strArr, Drawable[] drawableArr) {
            this.f28147n = strArr;
            this.f28148o = new String[strArr.length];
            this.f28149p = drawableArr;
        }

        private boolean g(int i2) {
            if (StyledPlayerControlView.this.f28104i0 == null) {
                return false;
            }
            if (i2 == 0) {
                return StyledPlayerControlView.this.f28104i0.q(13);
            }
            if (i2 != 1) {
                return true;
            }
            if (!StyledPlayerControlView.this.f28104i0.q(30) || !StyledPlayerControlView.this.f28104i0.q(29)) {
                return false;
            }
            return true;
        }

        public boolean c() {
            if (g(1) || g(0)) {
                return true;
            }
            return false;
        }

        /* renamed from: d */
        public void onBindViewHolder(SettingViewHolder settingViewHolder, int i2) {
            if (g(i2)) {
                settingViewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            } else {
                settingViewHolder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
            settingViewHolder.f28143j.setText(this.f28147n[i2]);
            if (this.f28148o[i2] == null) {
                settingViewHolder.f28144k.setVisibility(8);
            } else {
                settingViewHolder.f28144k.setText(this.f28148o[i2]);
            }
            if (this.f28149p[i2] == null) {
                settingViewHolder.f28145l.setVisibility(8);
            } else {
                settingViewHolder.f28145l.setImageDrawable(this.f28149p[i2]);
            }
        }

        /* renamed from: e */
        public SettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new SettingViewHolder(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.f27997g, viewGroup, false));
        }

        public void f(int i2, String str) {
            this.f28148o[i2] = str;
        }

        public int getItemCount() {
            return this.f28147n.length;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }
    }

    private static class SubSettingViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        public final TextView f28151j;

        /* renamed from: k  reason: collision with root package name */
        public final View f28152k;

        public SubSettingViewHolder(View view) {
            super(view);
            if (Util.f28808a < 26) {
                view.setFocusable(true);
            }
            this.f28151j = (TextView) view.findViewById(R$id.S);
            this.f28152k = view.findViewById(R$id.f27970h);
        }
    }

    private final class TextTrackSelectionAdapter extends TrackSelectionAdapter {
        private TextTrackSelectionAdapter() {
            super();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(View view) {
            if (StyledPlayerControlView.this.f28104i0 != null && StyledPlayerControlView.this.f28104i0.q(29)) {
                StyledPlayerControlView.this.f28104i0.a0(StyledPlayerControlView.this.f28104i0.v().A().B(3).F(-3).A());
                StyledPlayerControlView.this.f28109l.dismiss();
            }
        }

        /* renamed from: f */
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i2) {
            int i3;
            super.onBindViewHolder(subSettingViewHolder, i2);
            if (i2 > 0) {
                View view = subSettingViewHolder.f28152k;
                if (this.f28157n.get(i2 - 1).a()) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                view.setVisibility(i3);
            }
        }

        public void g(SubSettingViewHolder subSettingViewHolder) {
            boolean z2;
            subSettingViewHolder.f28151j.setText(R$string.f28024x);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f28157n.size()) {
                    z2 = true;
                    break;
                } else if (this.f28157n.get(i3).a()) {
                    z2 = false;
                    break;
                } else {
                    i3++;
                }
            }
            View view = subSettingViewHolder.f28152k;
            if (!z2) {
                i2 = 4;
            }
            view.setVisibility(i2);
            subSettingViewHolder.itemView.setOnClickListener(new f(this));
        }

        public void i(String str) {
        }

        public void k(List<TrackInformation> list) {
            Drawable drawable;
            String str;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (list.get(i2).a()) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (StyledPlayerControlView.this.f28133x != null) {
                ImageView D = StyledPlayerControlView.this.f28133x;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                if (z2) {
                    drawable = styledPlayerControlView.f28088a0;
                } else {
                    drawable = styledPlayerControlView.f28090b0;
                }
                D.setImageDrawable(drawable);
                ImageView D2 = StyledPlayerControlView.this.f28133x;
                if (z2) {
                    str = StyledPlayerControlView.this.f28092c0;
                } else {
                    str = StyledPlayerControlView.this.f28094d0;
                }
                D2.setContentDescription(str);
            }
            this.f28157n = list;
        }
    }

    private static final class TrackInformation {

        /* renamed from: a  reason: collision with root package name */
        public final Tracks.Group f28154a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28155b;

        /* renamed from: c  reason: collision with root package name */
        public final String f28156c;

        public TrackInformation(Tracks tracks, int i2, int i3, String str) {
            this.f28154a = tracks.b().get(i2);
            this.f28155b = i3;
            this.f28156c = str;
        }

        public boolean a() {
            return this.f28154a.g(this.f28155b);
        }
    }

    private abstract class TrackSelectionAdapter extends RecyclerView.Adapter<SubSettingViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        protected List<TrackInformation> f28157n = new ArrayList();

        protected TrackSelectionAdapter() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(Player player, TrackGroup trackGroup, TrackInformation trackInformation, View view) {
            if (player.q(29)) {
                player.a0(player.v().A().G(new TrackSelectionOverride(trackGroup, ImmutableList.s(Integer.valueOf(trackInformation.f28155b)))).J(trackInformation.f28154a.d(), false).A());
                i(trackInformation.f28156c);
                StyledPlayerControlView.this.f28109l.dismiss();
            }
        }

        /* access modifiers changed from: protected */
        public void d() {
            this.f28157n = Collections.emptyList();
        }

        /* renamed from: f */
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i2) {
            Player j2 = StyledPlayerControlView.this.f28104i0;
            if (j2 != null) {
                if (i2 == 0) {
                    g(subSettingViewHolder);
                    return;
                }
                boolean z2 = true;
                TrackInformation trackInformation = this.f28157n.get(i2 - 1);
                TrackGroup b2 = trackInformation.f28154a.b();
                int i3 = 0;
                if (j2.v().f27791z.get(b2) == null || !trackInformation.a()) {
                    z2 = false;
                }
                subSettingViewHolder.f28151j.setText(trackInformation.f28156c);
                View view = subSettingViewHolder.f28152k;
                if (!z2) {
                    i3 = 4;
                }
                view.setVisibility(i3);
                subSettingViewHolder.itemView.setOnClickListener(new g(this, j2, b2, trackInformation));
            }
        }

        /* access modifiers changed from: protected */
        public abstract void g(SubSettingViewHolder subSettingViewHolder);

        public int getItemCount() {
            if (this.f28157n.isEmpty()) {
                return 0;
            }
            return this.f28157n.size() + 1;
        }

        /* renamed from: h */
        public SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new SubSettingViewHolder(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(R$layout.f27998h, viewGroup, false));
        }

        /* access modifiers changed from: protected */
        public abstract void i(String str);
    }

    @Deprecated
    public interface VisibilityListener {
        void onVisibilityChange(int i2);
    }

    static {
        ExoPlayerLibraryInfo.a("goog.exo.ui");
    }

    public StyledPlayerControlView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* access modifiers changed from: private */
    public void A0() {
        long j2;
        long j3;
        int i2;
        long j4;
        if (h0() && this.f28110l0) {
            Player player = this.f28104i0;
            if (player == null || !player.q(16)) {
                j3 = 0;
                j2 = 0;
            } else {
                j3 = this.f28132w0 + player.K();
                j2 = this.f28132w0 + player.P();
            }
            TextView textView = this.E;
            if (textView != null && !this.f28116o0) {
                textView.setText(Util.i0(this.G, this.H, j3));
            }
            TimeBar timeBar = this.F;
            if (timeBar != null) {
                timeBar.setPosition(j3);
                this.F.setBufferedPosition(j2);
            }
            removeCallbacks(this.K);
            if (player == null) {
                i2 = 1;
            } else {
                i2 = player.getPlaybackState();
            }
            long j5 = 1000;
            if (player != null && player.isPlaying()) {
                TimeBar timeBar2 = this.F;
                if (timeBar2 != null) {
                    j4 = timeBar2.getPreferredUpdateDelay();
                } else {
                    j4 = 1000;
                }
                long min = Math.min(j4, 1000 - (j3 % 1000));
                float f2 = player.b().f23399b;
                if (f2 > 0.0f) {
                    j5 = (long) (((float) min) / f2);
                }
                postDelayed(this.K, Util.r(j5, (long) this.f28120q0, 1000));
            } else if (i2 != 4 && i2 != 1) {
                postDelayed(this.K, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void B0() {
        ImageView imageView;
        if (h0() && this.f28110l0 && (imageView = this.f28127u) != null) {
            if (this.f28122r0 == 0) {
                t0(false, imageView);
                return;
            }
            Player player = this.f28104i0;
            if (player == null || !player.q(15)) {
                t0(false, this.f28127u);
                this.f28127u.setImageDrawable(this.L);
                this.f28127u.setContentDescription(this.O);
                return;
            }
            t0(true, this.f28127u);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.f28127u.setImageDrawable(this.L);
                this.f28127u.setContentDescription(this.O);
            } else if (repeatMode == 1) {
                this.f28127u.setImageDrawable(this.M);
                this.f28127u.setContentDescription(this.P);
            } else if (repeatMode == 2) {
                this.f28127u.setImageDrawable(this.N);
                this.f28127u.setContentDescription(this.Q);
            }
        }
    }

    private void C0() {
        long j2;
        Player player = this.f28104i0;
        if (player != null) {
            j2 = player.T();
        } else {
            j2 = 5000;
        }
        int i2 = (int) (j2 / 1000);
        TextView textView = this.f28125t;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
        View view = this.f28121r;
        if (view != null) {
            view.setContentDescription(this.f28091c.getQuantityString(R$plurals.f28000b, i2, new Object[]{Integer.valueOf(i2)}));
        }
    }

    private void D0() {
        t0(this.f28099g.c(), this.A);
    }

    private void E0() {
        this.f28097f.measure(0, 0);
        this.f28109l.setWidth(Math.min(this.f28097f.getMeasuredWidth(), getWidth() - (this.f28111m * 2)));
        this.f28109l.setHeight(Math.min(getHeight() - (this.f28111m * 2), this.f28097f.getMeasuredHeight()));
    }

    /* access modifiers changed from: private */
    public void F0() {
        ImageView imageView;
        Drawable drawable;
        String str;
        if (h0() && this.f28110l0 && (imageView = this.f28129v) != null) {
            Player player = this.f28104i0;
            if (!this.f28089b.A(imageView)) {
                t0(false, this.f28129v);
            } else if (player == null || !player.q(14)) {
                t0(false, this.f28129v);
                this.f28129v.setImageDrawable(this.S);
                this.f28129v.setContentDescription(this.W);
            } else {
                t0(true, this.f28129v);
                ImageView imageView2 = this.f28129v;
                if (player.O()) {
                    drawable = this.R;
                } else {
                    drawable = this.S;
                }
                imageView2.setImageDrawable(drawable);
                ImageView imageView3 = this.f28129v;
                if (player.O()) {
                    str = this.V;
                } else {
                    str = this.W;
                }
                imageView3.setContentDescription(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void G0() {
        boolean z2;
        Timeline timeline;
        int i2;
        long j2;
        int i3;
        int i4;
        Timeline.Window window;
        int i5;
        Player player = this.f28104i0;
        if (player != null) {
            boolean z3 = true;
            if (!this.f28112m0 || !T(player, this.J)) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f28114n0 = z2;
            this.f28132w0 = 0;
            if (player.q(17)) {
                timeline = player.t();
            } else {
                timeline = Timeline.f23481b;
            }
            if (!timeline.u()) {
                int M2 = player.M();
                boolean z4 = this.f28114n0;
                if (z4) {
                    i3 = 0;
                } else {
                    i3 = M2;
                }
                if (z4) {
                    i4 = timeline.t() - 1;
                } else {
                    i4 = M2;
                }
                long j3 = 0;
                i2 = 0;
                while (true) {
                    if (i3 > i4) {
                        break;
                    }
                    if (i3 == M2) {
                        this.f28132w0 = Util.i1(j3);
                    }
                    timeline.r(i3, this.J);
                    Timeline.Window window2 = this.J;
                    if (window2.f23524o == -9223372036854775807L) {
                        Assertions.g(this.f28114n0 ^ z3);
                        break;
                    }
                    int i6 = window2.f23525p;
                    while (true) {
                        window = this.J;
                        if (i6 > window.f23526q) {
                            break;
                        }
                        timeline.j(i6, this.I);
                        int f2 = this.I.f();
                        for (int r2 = this.I.r(); r2 < f2; r2++) {
                            long i7 = this.I.i(r2);
                            if (i7 == Long.MIN_VALUE) {
                                long j4 = this.I.f23495e;
                                if (j4 == -9223372036854775807L) {
                                } else {
                                    i7 = j4;
                                }
                            }
                            long q2 = i7 + this.I.q();
                            if (q2 >= 0) {
                                long[] jArr = this.f28124s0;
                                if (i2 == jArr.length) {
                                    if (jArr.length == 0) {
                                        i5 = 1;
                                    } else {
                                        i5 = jArr.length * 2;
                                    }
                                    this.f28124s0 = Arrays.copyOf(jArr, i5);
                                    this.f28126t0 = Arrays.copyOf(this.f28126t0, i5);
                                }
                                this.f28124s0[i2] = Util.i1(j3 + q2);
                                this.f28126t0[i2] = this.I.s(r2);
                                i2++;
                            }
                        }
                        i6++;
                    }
                    j3 += window.f23524o;
                    i3++;
                    z3 = true;
                }
                j2 = j3;
            } else {
                if (player.q(16)) {
                    long D2 = player.D();
                    if (D2 != -9223372036854775807L) {
                        j2 = Util.F0(D2);
                        i2 = 0;
                    }
                }
                j2 = 0;
                i2 = 0;
            }
            long i12 = Util.i1(j2);
            TextView textView = this.D;
            if (textView != null) {
                textView.setText(Util.i0(this.G, this.H, i12));
            }
            TimeBar timeBar = this.F;
            if (timeBar != null) {
                timeBar.setDuration(i12);
                int length = this.f28128u0.length;
                int i8 = i2 + length;
                long[] jArr2 = this.f28124s0;
                if (i8 > jArr2.length) {
                    this.f28124s0 = Arrays.copyOf(jArr2, i8);
                    this.f28126t0 = Arrays.copyOf(this.f28126t0, i8);
                }
                System.arraycopy(this.f28128u0, 0, this.f28124s0, i2, length);
                System.arraycopy(this.f28130v0, 0, this.f28126t0, i2, length);
                this.F.a(this.f28124s0, this.f28126t0, i8);
            }
            A0();
        }
    }

    /* access modifiers changed from: private */
    public void H0() {
        boolean z2;
        d0();
        if (this.f28103i.getItemCount() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        t0(z2, this.f28133x);
        D0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r9 = r9.t();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean T(com.google.android.exoplayer2.Player r9, com.google.android.exoplayer2.Timeline.Window r10) {
        /*
            r0 = 17
            boolean r0 = r9.q(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            com.google.android.exoplayer2.Timeline r9 = r9.t()
            int r0 = r9.t()
            r2 = 1
            if (r0 <= r2) goto L_0x0031
            r3 = 100
            if (r0 <= r3) goto L_0x001a
            goto L_0x0031
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 >= r0) goto L_0x0030
            com.google.android.exoplayer2.Timeline$Window r4 = r9.r(r3, r10)
            long r4 = r4.f23524o
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x002d
            return r1
        L_0x002d:
            int r3 = r3 + 1
            goto L_0x001b
        L_0x0030:
            return r2
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.StyledPlayerControlView.T(com.google.android.exoplayer2.Player, com.google.android.exoplayer2.Timeline$Window):boolean");
    }

    private void V(Player player) {
        if (player.q(1)) {
            player.pause();
        }
    }

    private void W(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 && player.q(2)) {
            player.prepare();
        } else if (playbackState == 4 && player.q(4)) {
            player.h();
        }
        if (player.q(1)) {
            player.play();
        }
    }

    /* access modifiers changed from: private */
    public void X(Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !player.A()) {
            W(player);
        } else {
            V(player);
        }
    }

    /* access modifiers changed from: private */
    public void Y(RecyclerView.Adapter<?> adapter, View view) {
        this.f28097f.setAdapter(adapter);
        E0();
        this.f28134x0 = false;
        this.f28109l.dismiss();
        this.f28134x0 = true;
        this.f28109l.showAsDropDown(view, (getWidth() - this.f28109l.getWidth()) - this.f28111m, (-this.f28109l.getHeight()) - this.f28111m);
    }

    private ImmutableList<TrackInformation> Z(Tracks tracks, int i2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList<Tracks.Group> b2 = tracks.b();
        for (int i3 = 0; i3 < b2.size(); i3++) {
            Tracks.Group group = b2.get(i3);
            if (group.d() == i2) {
                for (int i4 = 0; i4 < group.f23537b; i4++) {
                    if (group.h(i4)) {
                        Format c2 = group.c(i4);
                        if ((c2.f23063e & 2) == 0) {
                            builder.d(new TrackInformation(tracks, i3, i4, this.f28107k.a(c2)));
                        }
                    }
                }
            }
        }
        return builder.k();
    }

    private static int a0(TypedArray typedArray, int i2) {
        return typedArray.getInt(R$styleable.Z, i2);
    }

    private void d0() {
        this.f28103i.d();
        this.f28105j.d();
        Player player = this.f28104i0;
        if (player != null && player.q(30) && this.f28104i0.q(29)) {
            Tracks m2 = this.f28104i0.m();
            this.f28105j.l(Z(m2, 1));
            if (this.f28089b.A(this.f28133x)) {
                this.f28103i.k(Z(m2, 3));
            } else {
                this.f28103i.k(ImmutableList.r());
            }
        }
    }

    private static void e0(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setVisibility(8);
            view.setOnClickListener(onClickListener);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static boolean g0(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    /* access modifiers changed from: private */
    public void j0(View view) {
        if (this.f28106j0 != null) {
            boolean z2 = !this.f28108k0;
            this.f28108k0 = z2;
            v0(this.f28135y, z2);
            v0(this.f28136z, this.f28108k0);
            OnFullScreenModeChangedListener onFullScreenModeChangedListener = this.f28106j0;
            if (onFullScreenModeChangedListener != null) {
                onFullScreenModeChangedListener.p(this.f28108k0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void k0(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i3;
        int i11 = i9 - i7;
        if (!(i4 - i2 == i8 - i6 && i10 == i11) && this.f28109l.isShowing()) {
            E0();
            this.f28109l.update(view, (getWidth() - this.f28109l.getWidth()) - this.f28111m, (-this.f28109l.getHeight()) - this.f28111m, -1, -1);
        }
    }

    /* access modifiers changed from: private */
    public void l0(int i2) {
        if (i2 == 0) {
            Y(this.f28101h, (View) Assertions.e(this.A));
        } else if (i2 == 1) {
            Y(this.f28105j, (View) Assertions.e(this.A));
        } else {
            this.f28109l.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void o0(Player player, long j2) {
        if (this.f28114n0) {
            if (player.q(17) && player.q(10)) {
                Timeline t2 = player.t();
                int t3 = t2.t();
                int i2 = 0;
                while (true) {
                    long f2 = t2.r(i2, this.J).f();
                    if (j2 < f2) {
                        break;
                    } else if (i2 == t3 - 1) {
                        j2 = f2;
                        break;
                    } else {
                        j2 -= f2;
                        i2++;
                    }
                }
                player.y(i2, j2);
            }
        } else if (player.q(5)) {
            player.seekTo(j2);
        }
        A0();
    }

    private boolean p0() {
        Player player = this.f28104i0;
        if (player == null || !player.q(1) || (this.f28104i0.q(17) && this.f28104i0.t().u())) {
            return false;
        }
        return true;
    }

    private boolean q0() {
        Player player = this.f28104i0;
        if (player == null || player.getPlaybackState() == 4 || this.f28104i0.getPlaybackState() == 1 || !this.f28104i0.A()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        Player player = this.f28104i0;
        if (player != null && player.q(13)) {
            Player player2 = this.f28104i0;
            player2.e(player2.b().d(f2));
        }
    }

    private void t0(boolean z2, View view) {
        float f2;
        if (view != null) {
            view.setEnabled(z2);
            if (z2) {
                f2 = this.T;
            } else {
                f2 = this.U;
            }
            view.setAlpha(f2);
        }
    }

    private void u0() {
        long j2;
        Player player = this.f28104i0;
        if (player != null) {
            j2 = player.J();
        } else {
            j2 = 15000;
        }
        int i2 = (int) (j2 / 1000);
        TextView textView = this.f28123s;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
        View view = this.f28119q;
        if (view != null) {
            view.setContentDescription(this.f28091c.getQuantityString(R$plurals.f27999a, i2, new Object[]{Integer.valueOf(i2)}));
        }
    }

    private void v0(ImageView imageView, boolean z2) {
        if (imageView != null) {
            if (z2) {
                imageView.setImageDrawable(this.f28096e0);
                imageView.setContentDescription(this.f28100g0);
                return;
            }
            imageView.setImageDrawable(this.f28098f0);
            imageView.setContentDescription(this.f28102h0);
        }
    }

    private static void w0(View view, boolean z2) {
        if (view != null) {
            if (z2) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void x0() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (h0() && this.f28110l0) {
            Player player = this.f28104i0;
            if (player != null) {
                if (!this.f28112m0 || !T(player, this.J)) {
                    z5 = player.q(5);
                } else {
                    z5 = player.q(10);
                }
                z4 = player.q(7);
                z3 = player.q(11);
                z2 = player.q(12);
                z6 = player.q(9);
            } else {
                z5 = false;
                z6 = false;
                z4 = false;
                z3 = false;
                z2 = false;
            }
            if (z3) {
                C0();
            }
            if (z2) {
                u0();
            }
            t0(z4, this.f28113n);
            t0(z3, this.f28121r);
            t0(z2, this.f28119q);
            t0(z6, this.f28115o);
            TimeBar timeBar = this.F;
            if (timeBar != null) {
                timeBar.setEnabled(z5);
            }
        }
    }

    /* access modifiers changed from: private */
    public void y0() {
        int i2;
        int i3;
        if (h0() && this.f28110l0 && this.f28117p != null) {
            boolean q02 = q0();
            if (q02) {
                i2 = R$drawable.f27952j;
            } else {
                i2 = R$drawable.f27953k;
            }
            if (q02) {
                i3 = R$string.f28006f;
            } else {
                i3 = R$string.f28007g;
            }
            ((ImageView) this.f28117p).setImageDrawable(Util.V(getContext(), this.f28091c, i2));
            this.f28117p.setContentDescription(this.f28091c.getString(i3));
            t0(p0(), this.f28117p);
        }
    }

    /* access modifiers changed from: private */
    public void z0() {
        Player player = this.f28104i0;
        if (player != null) {
            this.f28101h.h(player.b().f23399b);
            this.f28099g.f(0, this.f28101h.d());
            D0();
        }
    }

    @Deprecated
    public void S(VisibilityListener visibilityListener) {
        Assertions.e(visibilityListener);
        this.f28095e.add(visibilityListener);
    }

    public boolean U(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.f28104i0;
        if (player == null || !g0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4 || !player.q(12)) {
                return true;
            }
            player.Q();
            return true;
        } else if (keyCode == 89 && player.q(11)) {
            player.R();
            return true;
        } else if (keyEvent.getRepeatCount() != 0) {
            return true;
        } else {
            if (keyCode == 79 || keyCode == 85) {
                X(player);
                return true;
            } else if (keyCode != 87) {
                if (keyCode != 88) {
                    if (keyCode == 126) {
                        W(player);
                        return true;
                    } else if (keyCode != 127) {
                        return true;
                    } else {
                        V(player);
                        return true;
                    }
                } else if (!player.q(7)) {
                    return true;
                } else {
                    player.j();
                    return true;
                }
            } else if (!player.q(9)) {
                return true;
            } else {
                player.w();
                return true;
            }
        }
    }

    public void b0() {
        this.f28089b.C();
    }

    public void c0() {
        this.f28089b.F();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return U(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean f0() {
        return this.f28089b.I();
    }

    public Player getPlayer() {
        return this.f28104i0;
    }

    public int getRepeatToggleModes() {
        return this.f28122r0;
    }

    public boolean getShowShuffleButton() {
        return this.f28089b.A(this.f28129v);
    }

    public boolean getShowSubtitleButton() {
        return this.f28089b.A(this.f28133x);
    }

    public int getShowTimeoutMs() {
        return this.f28118p0;
    }

    public boolean getShowVrButton() {
        return this.f28089b.A(this.f28131w);
    }

    public boolean h0() {
        return getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void i0() {
        Iterator<VisibilityListener> it2 = this.f28095e.iterator();
        while (it2.hasNext()) {
            it2.next().onVisibilityChange(getVisibility());
        }
    }

    @Deprecated
    public void m0(VisibilityListener visibilityListener) {
        this.f28095e.remove(visibilityListener);
    }

    /* access modifiers changed from: package-private */
    public void n0() {
        View view = this.f28117p;
        if (view != null) {
            view.requestFocus();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f28089b.O();
        this.f28110l0 = true;
        if (f0()) {
            this.f28089b.W();
        }
        s0();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f28089b.P();
        this.f28110l0 = false;
        removeCallbacks(this.K);
        this.f28089b.V();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f28089b.Q(z2, i2, i3, i4, i5);
    }

    public void r0() {
        this.f28089b.b0();
    }

    /* access modifiers changed from: package-private */
    public void s0() {
        y0();
        x0();
        B0();
        F0();
        H0();
        z0();
        G0();
    }

    public void setAnimationEnabled(boolean z2) {
        this.f28089b.X(z2);
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        boolean z2;
        this.f28106j0 = onFullScreenModeChangedListener;
        ImageView imageView = this.f28135y;
        boolean z3 = true;
        if (onFullScreenModeChangedListener != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        w0(imageView, z2);
        ImageView imageView2 = this.f28136z;
        if (onFullScreenModeChangedListener == null) {
            z3 = false;
        }
        w0(imageView2, z3);
    }

    public void setPlayer(Player player) {
        boolean z2;
        boolean z3 = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.g(z2);
        if (!(player == null || player.u() == Looper.getMainLooper())) {
            z3 = false;
        }
        Assertions.a(z3);
        Player player2 = this.f28104i0;
        if (player2 != player) {
            if (player2 != null) {
                player2.V(this.f28093d);
            }
            this.f28104i0 = player;
            if (player != null) {
                player.X(this.f28093d);
            }
            s0();
        }
    }

    public void setProgressUpdateListener(ProgressUpdateListener progressUpdateListener) {
    }

    public void setRepeatToggleModes(int i2) {
        this.f28122r0 = i2;
        Player player = this.f28104i0;
        boolean z2 = false;
        if (player != null && player.q(15)) {
            int repeatMode = this.f28104i0.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.f28104i0.setRepeatMode(0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.f28104i0.setRepeatMode(1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.f28104i0.setRepeatMode(2);
            }
        }
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.f28089b;
        ImageView imageView = this.f28127u;
        if (i2 != 0) {
            z2 = true;
        }
        styledPlayerControlViewLayoutManager.Y(imageView, z2);
        B0();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.f28089b.Y(this.f28119q, z2);
        x0();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.f28112m0 = z2;
        G0();
    }

    public void setShowNextButton(boolean z2) {
        this.f28089b.Y(this.f28115o, z2);
        x0();
    }

    public void setShowPreviousButton(boolean z2) {
        this.f28089b.Y(this.f28113n, z2);
        x0();
    }

    public void setShowRewindButton(boolean z2) {
        this.f28089b.Y(this.f28121r, z2);
        x0();
    }

    public void setShowShuffleButton(boolean z2) {
        this.f28089b.Y(this.f28129v, z2);
        F0();
    }

    public void setShowSubtitleButton(boolean z2) {
        this.f28089b.Y(this.f28133x, z2);
    }

    public void setShowTimeoutMs(int i2) {
        this.f28118p0 = i2;
        if (f0()) {
            this.f28089b.W();
        }
    }

    public void setShowVrButton(boolean z2) {
        this.f28089b.Y(this.f28131w, z2);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.f28120q0 = Util.q(i2, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        boolean z2;
        View view = this.f28131w;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            if (onClickListener != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            t0(z2, this.f28131w);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r8v1, types: [com.google.android.exoplayer2.ui.StyledPlayerControlView$1, android.view.ViewGroup] */
    /* JADX WARNING: type inference failed for: r8v5 */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: type inference failed for: r8v7 */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StyledPlayerControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        ComponentListener componentListener;
        ? r8;
        Context context2 = context;
        AttributeSet attributeSet3 = attributeSet2;
        int i3 = R$layout.f27994d;
        this.f28118p0 = 5000;
        this.f28122r0 = 0;
        this.f28120q0 = 200;
        if (attributeSet3 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, R$styleable.W, i2, 0);
            try {
                i3 = obtainStyledAttributes.getResourceId(R$styleable.Y, i3);
                this.f28118p0 = obtainStyledAttributes.getInt(R$styleable.f28041g0, this.f28118p0);
                this.f28122r0 = a0(obtainStyledAttributes, this.f28122r0);
                boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.f28035d0, true);
                boolean z13 = obtainStyledAttributes.getBoolean(R$styleable.f28029a0, true);
                boolean z14 = obtainStyledAttributes.getBoolean(R$styleable.f28033c0, true);
                boolean z15 = obtainStyledAttributes.getBoolean(R$styleable.f28031b0, true);
                boolean z16 = obtainStyledAttributes.getBoolean(R$styleable.f28037e0, false);
                boolean z17 = obtainStyledAttributes.getBoolean(R$styleable.f28039f0, false);
                boolean z18 = obtainStyledAttributes.getBoolean(R$styleable.f28043h0, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.f28045i0, this.f28120q0));
                boolean z19 = obtainStyledAttributes.getBoolean(R$styleable.X, true);
                obtainStyledAttributes.recycle();
                z2 = z17;
                z5 = z14;
                z8 = z18;
                z4 = z15;
                z7 = z12;
                boolean z20 = z16;
                z6 = z13;
                z9 = z19;
                z3 = z20;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z9 = true;
            z8 = false;
            z7 = true;
            z6 = true;
            z5 = true;
            z4 = true;
            z3 = false;
            z2 = false;
        }
        LayoutInflater.from(context).inflate(i3, this);
        setDescendantFocusability(262144);
        ComponentListener componentListener2 = new ComponentListener();
        this.f28093d = componentListener2;
        this.f28095e = new CopyOnWriteArrayList<>();
        this.I = new Timeline.Period();
        this.J = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        this.G = sb;
        this.H = new Formatter(sb, Locale.getDefault());
        this.f28124s0 = new long[0];
        this.f28126t0 = new boolean[0];
        this.f28128u0 = new long[0];
        this.f28130v0 = new boolean[0];
        this.K = new e(this);
        this.D = (TextView) findViewById(R$id.f27975m);
        this.E = (TextView) findViewById(R$id.F);
        ImageView imageView = (ImageView) findViewById(R$id.Q);
        this.f28133x = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener2);
        }
        ImageView imageView2 = (ImageView) findViewById(R$id.f27981s);
        this.f28135y = imageView2;
        e0(imageView2, new f(this));
        ImageView imageView3 = (ImageView) findViewById(R$id.f27985w);
        this.f28136z = imageView3;
        e0(imageView3, new f(this));
        View findViewById = findViewById(R$id.M);
        this.A = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(componentListener2);
        }
        View findViewById2 = findViewById(R$id.E);
        this.B = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(componentListener2);
        }
        View findViewById3 = findViewById(R$id.f27965c);
        this.C = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(componentListener2);
        }
        int i4 = R$id.H;
        TimeBar timeBar = (TimeBar) findViewById(i4);
        View findViewById4 = findViewById(R$id.I);
        if (timeBar != null) {
            this.F = timeBar;
            componentListener = componentListener2;
            z11 = z9;
            z10 = z8;
            r8 = 0;
        } else if (findViewById4 != null) {
            DefaultTimeBar defaultTimeBar = r2;
            View view = findViewById4;
            r8 = 0;
            componentListener = componentListener2;
            z11 = z9;
            z10 = z8;
            DefaultTimeBar defaultTimeBar2 = new DefaultTimeBar(context, (AttributeSet) null, 0, attributeSet2, R$style.f28027a);
            defaultTimeBar2.setId(i4);
            defaultTimeBar2.setLayoutParams(view.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            View view2 = view;
            int indexOfChild = viewGroup.indexOfChild(view2);
            viewGroup.removeView(view2);
            viewGroup.addView(defaultTimeBar2, indexOfChild);
            this.F = defaultTimeBar2;
        } else {
            componentListener = componentListener2;
            z11 = z9;
            z10 = z8;
            r8 = 0;
            this.F = null;
        }
        TimeBar timeBar2 = this.F;
        ComponentListener componentListener3 = componentListener;
        if (timeBar2 != null) {
            timeBar2.b(componentListener3);
        }
        View findViewById5 = findViewById(R$id.D);
        this.f28117p = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(componentListener3);
        }
        View findViewById6 = findViewById(R$id.G);
        this.f28113n = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(componentListener3);
        }
        View findViewById7 = findViewById(R$id.f27986x);
        this.f28115o = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(componentListener3);
        }
        Typeface g2 = ResourcesCompat.g(context2, R$font.f27962a);
        View findViewById8 = findViewById(R$id.K);
        TextView textView = findViewById8 == null ? (TextView) findViewById(R$id.L) : r8;
        this.f28125t = textView;
        if (textView != null) {
            textView.setTypeface(g2);
        }
        findViewById8 = findViewById8 == null ? textView : findViewById8;
        this.f28121r = findViewById8;
        if (findViewById8 != null) {
            findViewById8.setOnClickListener(componentListener3);
        }
        View findViewById9 = findViewById(R$id.f27979q);
        TextView textView2 = findViewById9 == null ? (TextView) findViewById(R$id.f27980r) : r8;
        this.f28123s = textView2;
        if (textView2 != null) {
            textView2.setTypeface(g2);
        }
        findViewById9 = findViewById9 == null ? textView2 : findViewById9;
        this.f28119q = findViewById9;
        if (findViewById9 != null) {
            findViewById9.setOnClickListener(componentListener3);
        }
        ImageView imageView4 = (ImageView) findViewById(R$id.J);
        this.f28127u = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(componentListener3);
        }
        ImageView imageView5 = (ImageView) findViewById(R$id.N);
        this.f28129v = imageView5;
        if (imageView5 != null) {
            imageView5.setOnClickListener(componentListener3);
        }
        Resources resources = context.getResources();
        this.f28091c = resources;
        this.T = ((float) resources.getInteger(R$integer.f27990b)) / 100.0f;
        this.U = ((float) resources.getInteger(R$integer.f27989a)) / 100.0f;
        View findViewById10 = findViewById(R$id.U);
        this.f28131w = findViewById10;
        if (findViewById10 != null) {
            t0(false, findViewById10);
        }
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = new StyledPlayerControlViewLayoutManager(this);
        this.f28089b = styledPlayerControlViewLayoutManager;
        styledPlayerControlViewLayoutManager.X(z11);
        SettingsAdapter settingsAdapter = new SettingsAdapter(new String[]{resources.getString(R$string.f28008h), resources.getString(R$string.f28025y)}, new Drawable[]{Util.V(context2, resources, R$drawable.f27959q), Util.V(context2, resources, R$drawable.f27949g)});
        this.f28099g = settingsAdapter;
        this.f28111m = resources.getDimensionPixelSize(R$dimen.f27939a);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.f27996f, r8);
        this.f28097f = recyclerView;
        recyclerView.setAdapter(settingsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow(recyclerView, -2, -2, true);
        this.f28109l = popupWindow;
        if (Util.f28808a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(componentListener3);
        this.f28134x0 = true;
        this.f28107k = new DefaultTrackNameProvider(getResources());
        this.f28088a0 = Util.V(context2, resources, R$drawable.f27961s);
        this.f28090b0 = Util.V(context2, resources, R$drawable.f27960r);
        this.f28092c0 = resources.getString(R$string.f28002b);
        this.f28094d0 = resources.getString(R$string.f28001a);
        this.f28103i = new TextTrackSelectionAdapter();
        this.f28105j = new AudioTrackSelectionAdapter();
        this.f28101h = new PlaybackSpeedAdapter(resources.getStringArray(R$array.f27937a), F0);
        this.f28096e0 = Util.V(context2, resources, R$drawable.f27951i);
        this.f28098f0 = Util.V(context2, resources, R$drawable.f27950h);
        this.L = Util.V(context2, resources, R$drawable.f27955m);
        this.M = Util.V(context2, resources, R$drawable.f27956n);
        this.N = Util.V(context2, resources, R$drawable.f27954l);
        this.R = Util.V(context2, resources, R$drawable.f27958p);
        this.S = Util.V(context2, resources, R$drawable.f27957o);
        this.f28100g0 = resources.getString(R$string.f28004d);
        this.f28102h0 = resources.getString(R$string.f28003c);
        this.O = this.f28091c.getString(R$string.f28010j);
        this.P = this.f28091c.getString(R$string.f28011k);
        this.Q = this.f28091c.getString(R$string.f28009i);
        this.V = this.f28091c.getString(R$string.f28014n);
        this.W = this.f28091c.getString(R$string.f28013m);
        this.f28089b.Y((ViewGroup) findViewById(R$id.f27967e), true);
        this.f28089b.Y(this.f28119q, z6);
        this.f28089b.Y(this.f28121r, z7);
        this.f28089b.Y(this.f28113n, z5);
        this.f28089b.Y(this.f28115o, z4);
        this.f28089b.Y(this.f28129v, z3);
        this.f28089b.Y(this.f28133x, z2);
        this.f28089b.Y(this.f28131w, z10);
        this.f28089b.Y(this.f28127u, this.f28122r0 != 0);
        addOnLayoutChangeListener(new g(this));
    }
}

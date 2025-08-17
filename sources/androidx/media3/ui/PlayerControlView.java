package androidx.media3.ui;

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
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.e;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.Util;
import androidx.media3.ui.TimeBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import p.f;
import p.g;

public class PlayerControlView extends FrameLayout {
    private static final float[] I0 = {0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
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
    private boolean[] F0;
    /* access modifiers changed from: private */
    public final StringBuilder G;
    private long G0;
    /* access modifiers changed from: private */
    public final Formatter H;
    /* access modifiers changed from: private */
    public boolean H0;
    private final Timeline.Period I;
    private final Timeline.Window J;
    private final Runnable K;
    private final Drawable L;
    private final Drawable M;
    private final Drawable N;
    private final Drawable O;
    private final Drawable P;
    private final String Q;
    private final String R;
    private final String S;
    private final Drawable T;
    private final Drawable U;
    private final float V;
    private final float W;

    /* renamed from: a0  reason: collision with root package name */
    private final String f9831a0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final PlayerControlViewLayoutManager f9832b;

    /* renamed from: b0  reason: collision with root package name */
    private final String f9833b0;

    /* renamed from: c  reason: collision with root package name */
    private final Resources f9834c;
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public final Drawable f9835c0;

    /* renamed from: d  reason: collision with root package name */
    private final ComponentListener f9836d;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public final Drawable f9837d0;

    /* renamed from: e  reason: collision with root package name */
    private final CopyOnWriteArrayList<VisibilityListener> f9838e;
    /* access modifiers changed from: private */

    /* renamed from: e0  reason: collision with root package name */
    public final String f9839e0;

    /* renamed from: f  reason: collision with root package name */
    private final RecyclerView f9840f;
    /* access modifiers changed from: private */

    /* renamed from: f0  reason: collision with root package name */
    public final String f9841f0;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final SettingsAdapter f9842g;

    /* renamed from: g0  reason: collision with root package name */
    private final Drawable f9843g0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final PlaybackSpeedAdapter f9844h;

    /* renamed from: h0  reason: collision with root package name */
    private final Drawable f9845h0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final TextTrackSelectionAdapter f9846i;

    /* renamed from: i0  reason: collision with root package name */
    private final String f9847i0;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public final AudioTrackSelectionAdapter f9848j;

    /* renamed from: j0  reason: collision with root package name */
    private final String f9849j0;

    /* renamed from: k  reason: collision with root package name */
    private final TrackNameProvider f9850k;
    /* access modifiers changed from: private */

    /* renamed from: k0  reason: collision with root package name */
    public Player f9851k0;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final PopupWindow f9852l;

    /* renamed from: l0  reason: collision with root package name */
    private OnFullScreenModeChangedListener f9853l0;

    /* renamed from: m  reason: collision with root package name */
    private final int f9854m;

    /* renamed from: m0  reason: collision with root package name */
    private boolean f9855m0;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final ImageView f9856n;

    /* renamed from: n0  reason: collision with root package name */
    private boolean f9857n0;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final ImageView f9858o;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f9859o0;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final ImageView f9860p;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public boolean f9861p0;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final View f9862q;

    /* renamed from: q0  reason: collision with root package name */
    private boolean f9863q0;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final View f9864r;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public boolean f9865r0;

    /* renamed from: s  reason: collision with root package name */
    private final TextView f9866s;

    /* renamed from: s0  reason: collision with root package name */
    private int f9867s0;

    /* renamed from: t  reason: collision with root package name */
    private final TextView f9868t;

    /* renamed from: t0  reason: collision with root package name */
    private int f9869t0;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public final ImageView f9870u;
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public int f9871u0;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public final ImageView f9872v;

    /* renamed from: v0  reason: collision with root package name */
    private long[] f9873v0;

    /* renamed from: w  reason: collision with root package name */
    private final ImageView f9874w;

    /* renamed from: w0  reason: collision with root package name */
    private boolean[] f9875w0;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public final ImageView f9876x;

    /* renamed from: x0  reason: collision with root package name */
    private long[] f9877x0;

    /* renamed from: y  reason: collision with root package name */
    private final ImageView f9878y;

    /* renamed from: z  reason: collision with root package name */
    private final ImageView f9879z;

    private final class AudioTrackSelectionAdapter extends TrackSelectionAdapter {
        private AudioTrackSelectionAdapter() {
            super();
        }

        private boolean k(TrackSelectionParameters trackSelectionParameters) {
            for (int i2 = 0; i2 < this.f9900n.size(); i2++) {
                if (trackSelectionParameters.A.containsKey(this.f9900n.get(i2).f9897a.a())) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(View view) {
            if (PlayerControlView.this.f9851k0 != null && PlayerControlView.this.f9851k0.q(29)) {
                ((Player) Util.i(PlayerControlView.this.f9851k0)).a0(PlayerControlView.this.f9851k0.v().a().D(1).N(1, false).C());
                PlayerControlView.this.f9842g.f(1, PlayerControlView.this.getResources().getString(R$string.f10050w));
                PlayerControlView.this.f9852l.dismiss();
            }
        }

        public void g(SubSettingViewHolder subSettingViewHolder) {
            int i2;
            subSettingViewHolder.f9894j.setText(R$string.f10050w);
            boolean k2 = k(((Player) Assertions.f(PlayerControlView.this.f9851k0)).v());
            View view = subSettingViewHolder.f9895k;
            if (k2) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            view.setVisibility(i2);
            subSettingViewHolder.itemView.setOnClickListener(new a(this));
        }

        public void i(String str) {
            PlayerControlView.this.f9842g.f(1, str);
        }

        public void l(List<TrackInformation> list) {
            this.f9900n = list;
            TrackSelectionParameters v2 = ((Player) Assertions.f(PlayerControlView.this.f9851k0)).v();
            if (list.isEmpty()) {
                PlayerControlView.this.f9842g.f(1, PlayerControlView.this.getResources().getString(R$string.f10051x));
            } else if (!k(v2)) {
                PlayerControlView.this.f9842g.f(1, PlayerControlView.this.getResources().getString(R$string.f10050w));
            } else {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    TrackInformation trackInformation = list.get(i2);
                    if (trackInformation.a()) {
                        PlayerControlView.this.f9842g.f(1, trackInformation.f9899c);
                        return;
                    }
                }
            }
        }
    }

    private final class ComponentListener implements Player.Listener, TimeBar.OnScrubListener, View.OnClickListener, PopupWindow.OnDismissListener {
        private ComponentListener() {
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

        public /* synthetic */ void I(PlaybackException playbackException) {
            e.q(this, playbackException);
        }

        public /* synthetic */ void L(Player.Commands commands) {
            e.a(this, commands);
        }

        public void P(Player player, Player.Events events) {
            if (events.b(4, 5, 13)) {
                PlayerControlView.this.u0();
            }
            if (events.b(4, 5, 7, 13)) {
                PlayerControlView.this.w0();
            }
            if (events.b(8, 13)) {
                PlayerControlView.this.x0();
            }
            if (events.b(9, 13)) {
                PlayerControlView.this.B0();
            }
            if (events.b(8, 9, 11, 0, 16, 17, 13)) {
                PlayerControlView.this.t0();
            }
            if (events.b(11, 0, 13)) {
                PlayerControlView.this.C0();
            }
            if (events.b(12, 13)) {
                PlayerControlView.this.v0();
            }
            if (events.b(2, 13)) {
                PlayerControlView.this.D0();
            }
        }

        public /* synthetic */ void U(Timeline timeline, int i2) {
            e.A(this, timeline, i2);
        }

        public /* synthetic */ void V(Tracks tracks) {
            e.C(this, tracks);
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

        public /* synthetic */ void n(VideoSize videoSize) {
            e.D(this, videoSize);
        }

        public void onClick(View view) {
            Player j2 = PlayerControlView.this.f9851k0;
            if (j2 != null) {
                PlayerControlView.this.f9832b.W();
                if (PlayerControlView.this.f9858o == view) {
                    if (j2.q(9)) {
                        j2.w();
                    }
                } else if (PlayerControlView.this.f9856n == view) {
                    if (j2.q(7)) {
                        j2.j();
                    }
                } else if (PlayerControlView.this.f9862q == view) {
                    if (j2.getPlaybackState() != 4 && j2.q(12)) {
                        j2.Q();
                    }
                } else if (PlayerControlView.this.f9864r == view) {
                    if (j2.q(11)) {
                        j2.R();
                    }
                } else if (PlayerControlView.this.f9860p == view) {
                    Util.w0(j2, PlayerControlView.this.f9861p0);
                } else if (PlayerControlView.this.f9870u == view) {
                    if (j2.q(15)) {
                        j2.setRepeatMode(RepeatModeUtil.a(j2.getRepeatMode(), PlayerControlView.this.f9871u0));
                    }
                } else if (PlayerControlView.this.f9872v == view) {
                    if (j2.q(14)) {
                        j2.B(!j2.O());
                    }
                } else if (PlayerControlView.this.A == view) {
                    PlayerControlView.this.f9832b.V();
                    PlayerControlView playerControlView = PlayerControlView.this;
                    playerControlView.V(playerControlView.f9842g, PlayerControlView.this.A);
                } else if (PlayerControlView.this.B == view) {
                    PlayerControlView.this.f9832b.V();
                    PlayerControlView playerControlView2 = PlayerControlView.this;
                    playerControlView2.V(playerControlView2.f9844h, PlayerControlView.this.B);
                } else if (PlayerControlView.this.C == view) {
                    PlayerControlView.this.f9832b.V();
                    PlayerControlView playerControlView3 = PlayerControlView.this;
                    playerControlView3.V(playerControlView3.f9848j, PlayerControlView.this.C);
                } else if (PlayerControlView.this.f9876x == view) {
                    PlayerControlView.this.f9832b.V();
                    PlayerControlView playerControlView4 = PlayerControlView.this;
                    playerControlView4.V(playerControlView4.f9846i, PlayerControlView.this.f9876x);
                }
            }
        }

        public /* synthetic */ void onCues(List list) {
            e.c(this, list);
        }

        public /* synthetic */ void onDeviceVolumeChanged(int i2, boolean z2) {
            e.e(this, i2, z2);
        }

        public void onDismiss() {
            if (PlayerControlView.this.H0) {
                PlayerControlView.this.f9832b.W();
            }
        }

        public /* synthetic */ void onIsLoadingChanged(boolean z2) {
            e.g(this, z2);
        }

        public /* synthetic */ void onIsPlayingChanged(boolean z2) {
            e.h(this, z2);
        }

        public /* synthetic */ void onLoadingChanged(boolean z2) {
            e.i(this, z2);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(boolean z2, int i2) {
            e.m(this, z2, i2);
        }

        public /* synthetic */ void onPlaybackStateChanged(int i2) {
            e.o(this, i2);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i2) {
            e.p(this, i2);
        }

        public /* synthetic */ void onPlayerStateChanged(boolean z2, int i2) {
            e.s(this, z2, i2);
        }

        public /* synthetic */ void onPositionDiscontinuity(int i2) {
            e.t(this, i2);
        }

        public /* synthetic */ void onRenderedFirstFrame() {
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

        public void p(TimeBar timeBar, long j2) {
            boolean unused = PlayerControlView.this.f9865r0 = true;
            if (PlayerControlView.this.E != null) {
                PlayerControlView.this.E.setText(Util.n0(PlayerControlView.this.G, PlayerControlView.this.H, j2));
            }
            PlayerControlView.this.f9832b.V();
        }

        public /* synthetic */ void r(PlaybackParameters playbackParameters) {
            e.n(this, playbackParameters);
        }

        public void u(TimeBar timeBar, long j2) {
            if (PlayerControlView.this.E != null) {
                PlayerControlView.this.E.setText(Util.n0(PlayerControlView.this.G, PlayerControlView.this.H, j2));
            }
        }

        public void v(TimeBar timeBar, long j2, boolean z2) {
            boolean unused = PlayerControlView.this.f9865r0 = false;
            if (!z2 && PlayerControlView.this.f9851k0 != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.l0(playerControlView.f9851k0, j2);
            }
            PlayerControlView.this.f9832b.W();
        }
    }

    @Deprecated
    public interface OnFullScreenModeChangedListener {
        void p(boolean z2);
    }

    private final class PlaybackSpeedAdapter extends RecyclerView.Adapter<SubSettingViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        private final String[] f9882n;

        /* renamed from: o  reason: collision with root package name */
        private final float[] f9883o;

        /* renamed from: p  reason: collision with root package name */
        private int f9884p;

        public PlaybackSpeedAdapter(String[] strArr, float[] fArr) {
            this.f9882n = strArr;
            this.f9883o = fArr;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(int i2, View view) {
            if (i2 != this.f9884p) {
                PlayerControlView.this.setPlaybackSpeed(this.f9883o[i2]);
            }
            PlayerControlView.this.f9852l.dismiss();
        }

        public String d() {
            return this.f9882n[this.f9884p];
        }

        /* renamed from: f */
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i2) {
            String[] strArr = this.f9882n;
            if (i2 < strArr.length) {
                subSettingViewHolder.f9894j.setText(strArr[i2]);
            }
            if (i2 == this.f9884p) {
                subSettingViewHolder.itemView.setSelected(true);
                subSettingViewHolder.f9895k.setVisibility(0);
            } else {
                subSettingViewHolder.itemView.setSelected(false);
                subSettingViewHolder.f9895k.setVisibility(4);
            }
            subSettingViewHolder.itemView.setOnClickListener(new b(this, i2));
        }

        /* renamed from: g */
        public SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.f10025g, viewGroup, false));
        }

        public int getItemCount() {
            return this.f9882n.length;
        }

        public void h(float f2) {
            int i2 = 0;
            int i3 = 0;
            float f3 = Float.MAX_VALUE;
            while (true) {
                float[] fArr = this.f9883o;
                if (i2 < fArr.length) {
                    float abs = Math.abs(f2 - fArr[i2]);
                    if (abs < f3) {
                        i3 = i2;
                        f3 = abs;
                    }
                    i2++;
                } else {
                    this.f9884p = i3;
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
        public final TextView f9886j;
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public final TextView f9887k;
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public final ImageView f9888l;

        public SettingViewHolder(View view) {
            super(view);
            if (Util.f4714a < 26) {
                view.setFocusable(true);
            }
            this.f9886j = (TextView) view.findViewById(R$id.f10013v);
            this.f9887k = (TextView) view.findViewById(R$id.Q);
            this.f9888l = (ImageView) view.findViewById(R$id.f10012t);
            view.setOnClickListener(new c(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            PlayerControlView.this.i0(getBindingAdapterPosition());
        }
    }

    private class SettingsAdapter extends RecyclerView.Adapter<SettingViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        private final String[] f9890n;

        /* renamed from: o  reason: collision with root package name */
        private final String[] f9891o;

        /* renamed from: p  reason: collision with root package name */
        private final Drawable[] f9892p;

        public SettingsAdapter(String[] strArr, Drawable[] drawableArr) {
            this.f9890n = strArr;
            this.f9891o = new String[strArr.length];
            this.f9892p = drawableArr;
        }

        private boolean g(int i2) {
            if (PlayerControlView.this.f9851k0 == null) {
                return false;
            }
            if (i2 == 0) {
                return PlayerControlView.this.f9851k0.q(13);
            }
            if (i2 != 1) {
                return true;
            }
            if (!PlayerControlView.this.f9851k0.q(30) || !PlayerControlView.this.f9851k0.q(29)) {
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
            settingViewHolder.f9886j.setText(this.f9890n[i2]);
            if (this.f9891o[i2] == null) {
                settingViewHolder.f9887k.setVisibility(8);
            } else {
                settingViewHolder.f9887k.setText(this.f9891o[i2]);
            }
            if (this.f9892p[i2] == null) {
                settingViewHolder.f9888l.setVisibility(8);
            } else {
                settingViewHolder.f9888l.setImageDrawable(this.f9892p[i2]);
            }
        }

        /* renamed from: e */
        public SettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new SettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.f10024f, viewGroup, false));
        }

        public void f(int i2, String str) {
            this.f9891o[i2] = str;
        }

        public int getItemCount() {
            return this.f9890n.length;
        }

        public long getItemId(int i2) {
            return (long) i2;
        }
    }

    private static class SubSettingViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: j  reason: collision with root package name */
        public final TextView f9894j;

        /* renamed from: k  reason: collision with root package name */
        public final View f9895k;

        public SubSettingViewHolder(View view) {
            super(view);
            if (Util.f4714a < 26) {
                view.setFocusable(true);
            }
            this.f9894j = (TextView) view.findViewById(R$id.T);
            this.f9895k = view.findViewById(R$id.f10000h);
        }
    }

    private final class TextTrackSelectionAdapter extends TrackSelectionAdapter {
        private TextTrackSelectionAdapter() {
            super();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(View view) {
            if (PlayerControlView.this.f9851k0 != null && PlayerControlView.this.f9851k0.q(29)) {
                PlayerControlView.this.f9851k0.a0(PlayerControlView.this.f9851k0.v().a().D(3).H(-3).C());
                PlayerControlView.this.f9852l.dismiss();
            }
        }

        /* renamed from: f */
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i2) {
            int i3;
            super.onBindViewHolder(subSettingViewHolder, i2);
            if (i2 > 0) {
                View view = subSettingViewHolder.f9895k;
                if (this.f9900n.get(i2 - 1).a()) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                view.setVisibility(i3);
            }
        }

        public void g(SubSettingViewHolder subSettingViewHolder) {
            boolean z2;
            subSettingViewHolder.f9894j.setText(R$string.f10051x);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= this.f9900n.size()) {
                    z2 = true;
                    break;
                } else if (this.f9900n.get(i3).a()) {
                    z2 = false;
                    break;
                } else {
                    i3++;
                }
            }
            View view = subSettingViewHolder.f9895k;
            if (!z2) {
                i2 = 4;
            }
            view.setVisibility(i2);
            subSettingViewHolder.itemView.setOnClickListener(new d(this));
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
            if (PlayerControlView.this.f9876x != null) {
                ImageView D = PlayerControlView.this.f9876x;
                PlayerControlView playerControlView = PlayerControlView.this;
                if (z2) {
                    drawable = playerControlView.f9835c0;
                } else {
                    drawable = playerControlView.f9837d0;
                }
                D.setImageDrawable(drawable);
                ImageView D2 = PlayerControlView.this.f9876x;
                if (z2) {
                    str = PlayerControlView.this.f9839e0;
                } else {
                    str = PlayerControlView.this.f9841f0;
                }
                D2.setContentDescription(str);
            }
            this.f9900n = list;
        }
    }

    private static final class TrackInformation {

        /* renamed from: a  reason: collision with root package name */
        public final Tracks.Group f9897a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9898b;

        /* renamed from: c  reason: collision with root package name */
        public final String f9899c;

        public TrackInformation(Tracks tracks, int i2, int i3, String str) {
            this.f9897a = tracks.a().get(i2);
            this.f9898b = i3;
            this.f9899c = str;
        }

        public boolean a() {
            return this.f9897a.h(this.f9898b);
        }
    }

    private abstract class TrackSelectionAdapter extends RecyclerView.Adapter<SubSettingViewHolder> {

        /* renamed from: n  reason: collision with root package name */
        protected List<TrackInformation> f9900n = new ArrayList();

        protected TrackSelectionAdapter() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(Player player, TrackGroup trackGroup, TrackInformation trackInformation, View view) {
            if (player.q(29)) {
                player.a0(player.v().a().J(new TrackSelectionOverride(trackGroup, (List<Integer>) ImmutableList.s(Integer.valueOf(trackInformation.f9898b)))).N(trackInformation.f9897a.c(), false).C());
                i(trackInformation.f9899c);
                PlayerControlView.this.f9852l.dismiss();
            }
        }

        /* access modifiers changed from: protected */
        public void d() {
            this.f9900n = Collections.emptyList();
        }

        /* renamed from: f */
        public void onBindViewHolder(SubSettingViewHolder subSettingViewHolder, int i2) {
            Player j2 = PlayerControlView.this.f9851k0;
            if (j2 != null) {
                if (i2 == 0) {
                    g(subSettingViewHolder);
                    return;
                }
                boolean z2 = true;
                TrackInformation trackInformation = this.f9900n.get(i2 - 1);
                TrackGroup a2 = trackInformation.f9897a.a();
                int i3 = 0;
                if (j2.v().A.get(a2) == null || !trackInformation.a()) {
                    z2 = false;
                }
                subSettingViewHolder.f9894j.setText(trackInformation.f9899c);
                View view = subSettingViewHolder.f9895k;
                if (!z2) {
                    i3 = 4;
                }
                view.setVisibility(i3);
                subSettingViewHolder.itemView.setOnClickListener(new e(this, j2, a2, trackInformation));
            }
        }

        /* access modifiers changed from: protected */
        public abstract void g(SubSettingViewHolder subSettingViewHolder);

        public int getItemCount() {
            if (this.f9900n.isEmpty()) {
                return 0;
            }
            return this.f9900n.size() + 1;
        }

        /* renamed from: h */
        public SubSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return new SubSettingViewHolder(LayoutInflater.from(PlayerControlView.this.getContext()).inflate(R$layout.f10025g, viewGroup, false));
        }

        /* access modifiers changed from: protected */
        public abstract void i(String str);
    }

    @Deprecated
    public interface VisibilityListener {
        void onVisibilityChange(int i2);
    }

    static {
        MediaLibraryInfo.a("media3.ui");
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    private void A0() {
        this.f9840f.measure(0, 0);
        this.f9852l.setWidth(Math.min(this.f9840f.getMeasuredWidth(), getWidth() - (this.f9854m * 2)));
        this.f9852l.setHeight(Math.min(getHeight() - (this.f9854m * 2), this.f9840f.getMeasuredHeight()));
    }

    /* access modifiers changed from: private */
    public void B0() {
        ImageView imageView;
        Drawable drawable;
        String str;
        if (e0() && this.f9857n0 && (imageView = this.f9872v) != null) {
            Player player = this.f9851k0;
            if (!this.f9832b.A(imageView)) {
                p0(false, this.f9872v);
            } else if (player == null || !player.q(14)) {
                p0(false, this.f9872v);
                this.f9872v.setImageDrawable(this.U);
                this.f9872v.setContentDescription(this.f9833b0);
            } else {
                p0(true, this.f9872v);
                ImageView imageView2 = this.f9872v;
                if (player.O()) {
                    drawable = this.T;
                } else {
                    drawable = this.U;
                }
                imageView2.setImageDrawable(drawable);
                ImageView imageView3 = this.f9872v;
                if (player.O()) {
                    str = this.f9831a0;
                } else {
                    str = this.f9833b0;
                }
                imageView3.setContentDescription(str);
            }
        }
    }

    /* access modifiers changed from: private */
    public void C0() {
        boolean z2;
        Timeline timeline;
        int i2;
        long j2;
        int i3;
        int i4;
        Timeline.Window window;
        int i5;
        Player player = this.f9851k0;
        if (player != null) {
            boolean z3 = true;
            if (!this.f9859o0 || !T(player, this.J)) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.f9863q0 = z2;
            this.G0 = 0;
            if (player.q(17)) {
                timeline = player.t();
            } else {
                timeline = Timeline.f4346a;
            }
            if (!timeline.q()) {
                int M2 = player.M();
                boolean z4 = this.f9863q0;
                if (z4) {
                    i3 = 0;
                } else {
                    i3 = M2;
                }
                if (z4) {
                    i4 = timeline.p() - 1;
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
                        this.G0 = Util.t1(j3);
                    }
                    timeline.n(i3, this.J);
                    Timeline.Window window2 = this.J;
                    if (window2.f4384m == -9223372036854775807L) {
                        Assertions.h(this.f9863q0 ^ z3);
                        break;
                    }
                    int i6 = window2.f4385n;
                    while (true) {
                        window = this.J;
                        if (i6 > window.f4386o) {
                            break;
                        }
                        timeline.f(i6, this.I);
                        int c2 = this.I.c();
                        for (int o2 = this.I.o(); o2 < c2; o2++) {
                            long f2 = this.I.f(o2);
                            if (f2 == Long.MIN_VALUE) {
                                long j4 = this.I.f4358d;
                                if (j4 == -9223372036854775807L) {
                                } else {
                                    f2 = j4;
                                }
                            }
                            long n2 = f2 + this.I.n();
                            if (n2 >= 0) {
                                long[] jArr = this.f9873v0;
                                if (i2 == jArr.length) {
                                    if (jArr.length == 0) {
                                        i5 = 1;
                                    } else {
                                        i5 = jArr.length * 2;
                                    }
                                    this.f9873v0 = Arrays.copyOf(jArr, i5);
                                    this.f9875w0 = Arrays.copyOf(this.f9875w0, i5);
                                }
                                this.f9873v0[i2] = Util.t1(j3 + n2);
                                this.f9875w0[i2] = this.I.p(o2);
                                i2++;
                            }
                        }
                        i6++;
                    }
                    j3 += window.f4384m;
                    i3++;
                    z3 = true;
                }
                j2 = j3;
            } else {
                if (player.q(16)) {
                    long D2 = player.D();
                    if (D2 != -9223372036854775807L) {
                        j2 = Util.P0(D2);
                        i2 = 0;
                    }
                }
                j2 = 0;
                i2 = 0;
            }
            long t1 = Util.t1(j2);
            TextView textView = this.D;
            if (textView != null) {
                textView.setText(Util.n0(this.G, this.H, t1));
            }
            TimeBar timeBar = this.F;
            if (timeBar != null) {
                timeBar.setDuration(t1);
                int length = this.f9877x0.length;
                int i7 = i2 + length;
                long[] jArr2 = this.f9873v0;
                if (i7 > jArr2.length) {
                    this.f9873v0 = Arrays.copyOf(jArr2, i7);
                    this.f9875w0 = Arrays.copyOf(this.f9875w0, i7);
                }
                System.arraycopy(this.f9877x0, 0, this.f9873v0, i2, length);
                System.arraycopy(this.F0, 0, this.f9875w0, i2, length);
                this.F.a(this.f9873v0, this.f9875w0, i7);
            }
            w0();
        }
    }

    /* access modifiers changed from: private */
    public void D0() {
        boolean z2;
        a0();
        if (this.f9846i.getItemCount() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        p0(z2, this.f9876x);
        z0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000a, code lost:
        r9 = r9.t();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean T(androidx.media3.common.Player r9, androidx.media3.common.Timeline.Window r10) {
        /*
            r0 = 17
            boolean r0 = r9.q(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            androidx.media3.common.Timeline r9 = r9.t()
            int r0 = r9.p()
            r2 = 1
            if (r0 <= r2) goto L_0x0031
            r3 = 100
            if (r0 <= r3) goto L_0x001a
            goto L_0x0031
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 >= r0) goto L_0x0030
            androidx.media3.common.Timeline$Window r4 = r9.n(r3, r10)
            long r4 = r4.f4384m
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerControlView.T(androidx.media3.common.Player, androidx.media3.common.Timeline$Window):boolean");
    }

    /* access modifiers changed from: private */
    public void V(RecyclerView.Adapter<?> adapter, View view) {
        this.f9840f.setAdapter(adapter);
        A0();
        this.H0 = false;
        this.f9852l.dismiss();
        this.H0 = true;
        this.f9852l.showAsDropDown(view, (getWidth() - this.f9852l.getWidth()) - this.f9854m, (-this.f9852l.getHeight()) - this.f9854m);
    }

    private ImmutableList<TrackInformation> W(Tracks tracks, int i2) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList<Tracks.Group> a2 = tracks.a();
        for (int i3 = 0; i3 < a2.size(); i3++) {
            Tracks.Group group = a2.get(i3);
            if (group.c() == i2) {
                for (int i4 = 0; i4 < group.f4477a; i4++) {
                    if (group.i(i4)) {
                        Format b2 = group.b(i4);
                        if ((b2.f4006e & 2) == 0) {
                            builder.d(new TrackInformation(tracks, i3, i4, this.f9850k.a(b2)));
                        }
                    }
                }
            }
        }
        return builder.k();
    }

    private static int X(TypedArray typedArray, int i2) {
        return typedArray.getInt(R$styleable.U, i2);
    }

    private void a0() {
        this.f9846i.d();
        this.f9848j.d();
        Player player = this.f9851k0;
        if (player != null && player.q(30) && this.f9851k0.q(29)) {
            Tracks m2 = this.f9851k0.m();
            this.f9848j.l(W(m2, 1));
            if (this.f9832b.A(this.f9876x)) {
                this.f9846i.k(W(m2, 3));
            } else {
                this.f9846i.k(ImmutableList.r());
            }
        }
    }

    private static void b0(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setVisibility(8);
            view.setOnClickListener(onClickListener);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static boolean d0(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    /* access modifiers changed from: private */
    public void g0(View view) {
        if (this.f9853l0 != null) {
            boolean z2 = !this.f9855m0;
            this.f9855m0 = z2;
            r0(this.f9878y, z2);
            r0(this.f9879z, this.f9855m0);
            OnFullScreenModeChangedListener onFullScreenModeChangedListener = this.f9853l0;
            if (onFullScreenModeChangedListener != null) {
                onFullScreenModeChangedListener.p(this.f9855m0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h0(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i3;
        int i11 = i9 - i7;
        if (!(i4 - i2 == i8 - i6 && i10 == i11) && this.f9852l.isShowing()) {
            A0();
            this.f9852l.update(view, (getWidth() - this.f9852l.getWidth()) - this.f9854m, (-this.f9852l.getHeight()) - this.f9854m, -1, -1);
        }
    }

    /* access modifiers changed from: private */
    public void i0(int i2) {
        if (i2 == 0) {
            V(this.f9844h, (View) Assertions.f(this.A));
        } else if (i2 == 1) {
            V(this.f9848j, (View) Assertions.f(this.A));
        } else {
            this.f9852l.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public void l0(Player player, long j2) {
        if (this.f9863q0) {
            if (player.q(17) && player.q(10)) {
                Timeline t2 = player.t();
                int p2 = t2.p();
                int i2 = 0;
                while (true) {
                    long d2 = t2.n(i2, this.J).d();
                    if (j2 < d2) {
                        break;
                    } else if (i2 == p2 - 1) {
                        j2 = d2;
                        break;
                    } else {
                        j2 -= d2;
                        i2++;
                    }
                }
                player.y(i2, j2);
            }
        } else if (player.q(5)) {
            player.seekTo(j2);
        }
        w0();
    }

    private boolean m0() {
        Player player = this.f9851k0;
        if (player == null || !player.q(1) || (this.f9851k0.q(17) && this.f9851k0.t().q())) {
            return false;
        }
        return true;
    }

    private void p0(boolean z2, View view) {
        float f2;
        if (view != null) {
            view.setEnabled(z2);
            if (z2) {
                f2 = this.V;
            } else {
                f2 = this.W;
            }
            view.setAlpha(f2);
        }
    }

    private void q0() {
        long j2;
        Player player = this.f9851k0;
        if (player != null) {
            j2 = player.J();
        } else {
            j2 = 15000;
        }
        int i2 = (int) (j2 / 1000);
        TextView textView = this.f9866s;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
        View view = this.f9862q;
        if (view != null) {
            view.setContentDescription(this.f9834c.getQuantityString(R$plurals.f10026a, i2, new Object[]{Integer.valueOf(i2)}));
        }
    }

    private void r0(ImageView imageView, boolean z2) {
        if (imageView != null) {
            if (z2) {
                imageView.setImageDrawable(this.f9843g0);
                imageView.setContentDescription(this.f9847i0);
                return;
            }
            imageView.setImageDrawable(this.f9845h0);
            imageView.setContentDescription(this.f9849j0);
        }
    }

    private static void s0(View view, boolean z2) {
        if (view != null) {
            if (z2) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        Player player = this.f9851k0;
        if (player != null && player.q(13)) {
            Player player2 = this.f9851k0;
            player2.e(player2.b().b(f2));
        }
    }

    /* access modifiers changed from: private */
    public void t0() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        if (e0() && this.f9857n0) {
            Player player = this.f9851k0;
            if (player != null) {
                if (!this.f9859o0 || !T(player, this.J)) {
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
                y0();
            }
            if (z2) {
                q0();
            }
            p0(z4, this.f9856n);
            p0(z3, this.f9864r);
            p0(z2, this.f9862q);
            p0(z6, this.f9858o);
            TimeBar timeBar = this.F;
            if (timeBar != null) {
                timeBar.setEnabled(z5);
            }
        }
    }

    /* access modifiers changed from: private */
    public void u0() {
        Drawable drawable;
        int i2;
        if (e0() && this.f9857n0 && this.f9860p != null) {
            boolean h12 = Util.h1(this.f9851k0, this.f9861p0);
            if (h12) {
                drawable = this.L;
            } else {
                drawable = this.M;
            }
            if (h12) {
                i2 = R$string.f10034g;
            } else {
                i2 = R$string.f10033f;
            }
            this.f9860p.setImageDrawable(drawable);
            this.f9860p.setContentDescription(this.f9834c.getString(i2));
            p0(m0(), this.f9860p);
        }
    }

    /* access modifiers changed from: private */
    public void v0() {
        Player player = this.f9851k0;
        if (player != null) {
            this.f9844h.h(player.b().f4306a);
            this.f9842g.f(0, this.f9844h.d());
            z0();
        }
    }

    /* access modifiers changed from: private */
    public void w0() {
        long j2;
        long j3;
        int i2;
        long j4;
        if (e0() && this.f9857n0) {
            Player player = this.f9851k0;
            if (player == null || !player.q(16)) {
                j3 = 0;
                j2 = 0;
            } else {
                j3 = this.G0 + player.K();
                j2 = this.G0 + player.P();
            }
            TextView textView = this.E;
            if (textView != null && !this.f9865r0) {
                textView.setText(Util.n0(this.G, this.H, j3));
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
                float f2 = player.b().f4306a;
                if (f2 > 0.0f) {
                    j5 = (long) (((float) min) / f2);
                }
                postDelayed(this.K, Util.q(j5, (long) this.f9869t0, 1000));
            } else if (i2 != 4 && i2 != 1) {
                postDelayed(this.K, 1000);
            }
        }
    }

    /* access modifiers changed from: private */
    public void x0() {
        ImageView imageView;
        if (e0() && this.f9857n0 && (imageView = this.f9870u) != null) {
            if (this.f9871u0 == 0) {
                p0(false, imageView);
                return;
            }
            Player player = this.f9851k0;
            if (player == null || !player.q(15)) {
                p0(false, this.f9870u);
                this.f9870u.setImageDrawable(this.N);
                this.f9870u.setContentDescription(this.Q);
                return;
            }
            p0(true, this.f9870u);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.f9870u.setImageDrawable(this.N);
                this.f9870u.setContentDescription(this.Q);
            } else if (repeatMode == 1) {
                this.f9870u.setImageDrawable(this.O);
                this.f9870u.setContentDescription(this.R);
            } else if (repeatMode == 2) {
                this.f9870u.setImageDrawable(this.P);
                this.f9870u.setContentDescription(this.S);
            }
        }
    }

    private void y0() {
        long j2;
        Player player = this.f9851k0;
        if (player != null) {
            j2 = player.T();
        } else {
            j2 = 5000;
        }
        int i2 = (int) (j2 / 1000);
        TextView textView = this.f9868t;
        if (textView != null) {
            textView.setText(String.valueOf(i2));
        }
        View view = this.f9864r;
        if (view != null) {
            view.setContentDescription(this.f9834c.getQuantityString(R$plurals.f10027b, i2, new Object[]{Integer.valueOf(i2)}));
        }
    }

    private void z0() {
        p0(this.f9842g.c(), this.A);
    }

    @Deprecated
    public void S(VisibilityListener visibilityListener) {
        Assertions.f(visibilityListener);
        this.f9838e.add(visibilityListener);
    }

    public boolean U(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player player = this.f9851k0;
        if (player == null || !d0(keyCode)) {
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
                Util.w0(player, this.f9861p0);
                return true;
            } else if (keyCode != 87) {
                if (keyCode != 88) {
                    if (keyCode == 126) {
                        Util.v0(player);
                        return true;
                    } else if (keyCode != 127) {
                        return true;
                    } else {
                        Util.u0(player);
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

    public void Y() {
        this.f9832b.C();
    }

    public void Z() {
        this.f9832b.F();
    }

    public boolean c0() {
        return this.f9832b.I();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return U(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean e0() {
        return getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void f0() {
        Iterator<VisibilityListener> it2 = this.f9838e.iterator();
        while (it2.hasNext()) {
            it2.next().onVisibilityChange(getVisibility());
        }
    }

    public Player getPlayer() {
        return this.f9851k0;
    }

    public int getRepeatToggleModes() {
        return this.f9871u0;
    }

    public boolean getShowShuffleButton() {
        return this.f9832b.A(this.f9872v);
    }

    public boolean getShowSubtitleButton() {
        return this.f9832b.A(this.f9876x);
    }

    public int getShowTimeoutMs() {
        return this.f9867s0;
    }

    public boolean getShowVrButton() {
        return this.f9832b.A(this.f9874w);
    }

    @Deprecated
    public void j0(VisibilityListener visibilityListener) {
        this.f9838e.remove(visibilityListener);
    }

    /* access modifiers changed from: package-private */
    public void k0() {
        ImageView imageView = this.f9860p;
        if (imageView != null) {
            imageView.requestFocus();
        }
    }

    public void n0() {
        this.f9832b.b0();
    }

    /* access modifiers changed from: package-private */
    public void o0() {
        u0();
        t0();
        x0();
        B0();
        D0();
        v0();
        C0();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9832b.O();
        this.f9857n0 = true;
        if (c0()) {
            this.f9832b.W();
        }
        o0();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f9832b.P();
        this.f9857n0 = false;
        removeCallbacks(this.K);
        this.f9832b.V();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f9832b.Q(z2, i2, i3, i4, i5);
    }

    public void setAnimationEnabled(boolean z2) {
        this.f9832b.X(z2);
    }

    @Deprecated
    public void setOnFullScreenModeChangedListener(OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        boolean z2;
        this.f9853l0 = onFullScreenModeChangedListener;
        ImageView imageView = this.f9878y;
        boolean z3 = true;
        if (onFullScreenModeChangedListener != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        s0(imageView, z2);
        ImageView imageView2 = this.f9879z;
        if (onFullScreenModeChangedListener == null) {
            z3 = false;
        }
        s0(imageView2, z3);
    }

    public void setPlayer(Player player) {
        boolean z2;
        boolean z3 = true;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        if (!(player == null || player.u() == Looper.getMainLooper())) {
            z3 = false;
        }
        Assertions.a(z3);
        Player player2 = this.f9851k0;
        if (player2 != player) {
            if (player2 != null) {
                player2.W(this.f9836d);
            }
            this.f9851k0 = player;
            if (player != null) {
                player.Y(this.f9836d);
            }
            o0();
        }
    }

    public void setProgressUpdateListener(ProgressUpdateListener progressUpdateListener) {
    }

    public void setRepeatToggleModes(int i2) {
        this.f9871u0 = i2;
        Player player = this.f9851k0;
        boolean z2 = false;
        if (player != null && player.q(15)) {
            int repeatMode = this.f9851k0.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.f9851k0.setRepeatMode(0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.f9851k0.setRepeatMode(1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.f9851k0.setRepeatMode(2);
            }
        }
        PlayerControlViewLayoutManager playerControlViewLayoutManager = this.f9832b;
        ImageView imageView = this.f9870u;
        if (i2 != 0) {
            z2 = true;
        }
        playerControlViewLayoutManager.Y(imageView, z2);
        x0();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.f9832b.Y(this.f9862q, z2);
        t0();
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z2) {
        this.f9859o0 = z2;
        C0();
    }

    public void setShowNextButton(boolean z2) {
        this.f9832b.Y(this.f9858o, z2);
        t0();
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z2) {
        this.f9861p0 = z2;
        u0();
    }

    public void setShowPreviousButton(boolean z2) {
        this.f9832b.Y(this.f9856n, z2);
        t0();
    }

    public void setShowRewindButton(boolean z2) {
        this.f9832b.Y(this.f9864r, z2);
        t0();
    }

    public void setShowShuffleButton(boolean z2) {
        this.f9832b.Y(this.f9872v, z2);
        B0();
    }

    public void setShowSubtitleButton(boolean z2) {
        this.f9832b.Y(this.f9876x, z2);
    }

    public void setShowTimeoutMs(int i2) {
        this.f9867s0 = i2;
        if (c0()) {
            this.f9832b.W();
        }
    }

    public void setShowVrButton(boolean z2) {
        this.f9832b.Y(this.f9874w, z2);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.f9869t0 = Util.p(i2, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        boolean z2;
        ImageView imageView = this.f9874w;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
            if (onClickListener != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            p0(z2, this.f9874w);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2);
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        boolean z4;
        boolean z5;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        int i13;
        int i14;
        int i15;
        PlayerControlView playerControlView;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        ComponentListener componentListener;
        boolean z10;
        boolean z11;
        int i21;
        int i22;
        PlayerControlView playerControlView2;
        Context context2 = context;
        AttributeSet attributeSet3 = attributeSet2;
        int i23 = R$layout.f10021c;
        int i24 = R$drawable.f9981l;
        int i25 = R$drawable.f9980k;
        int i26 = R$drawable.f9979j;
        int i27 = R$drawable.exo_styled_controls_simple_fastforward;
        int i28 = R$drawable.f9982m;
        int i29 = R$drawable.exo_styled_controls_simple_rewind;
        int i30 = R$drawable.f9978i;
        int i31 = R$drawable.f9977h;
        int i32 = R$drawable.f9984o;
        int i33 = R$drawable.f9985p;
        int i34 = R$drawable.f9983n;
        int i35 = R$drawable.f9987r;
        int i36 = R$drawable.f9986q;
        int i37 = R$drawable.f9990w;
        int i38 = R$drawable.f9989v;
        int i39 = R$drawable.f9991x;
        this.f9861p0 = true;
        this.f9867s0 = 5000;
        this.f9871u0 = 0;
        this.f9869t0 = 200;
        if (attributeSet3 != null) {
            int i40 = i34;
            int i41 = i35;
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet3, R$styleable.H, i2, 0);
            try {
                int resourceId = obtainStyledAttributes.getResourceId(R$styleable.J, i23);
                int resourceId2 = obtainStyledAttributes.getResourceId(R$styleable.P, i24);
                int resourceId3 = obtainStyledAttributes.getResourceId(R$styleable.O, i25);
                int resourceId4 = obtainStyledAttributes.getResourceId(R$styleable.N, i26);
                int resourceId5 = obtainStyledAttributes.getResourceId(R$styleable.K, i27);
                int resourceId6 = obtainStyledAttributes.getResourceId(R$styleable.Q, i28);
                int resourceId7 = obtainStyledAttributes.getResourceId(R$styleable.V, i29);
                int resourceId8 = obtainStyledAttributes.getResourceId(R$styleable.M, i30);
                int resourceId9 = obtainStyledAttributes.getResourceId(R$styleable.L, i31);
                int resourceId10 = obtainStyledAttributes.getResourceId(R$styleable.S, i32);
                int resourceId11 = obtainStyledAttributes.getResourceId(R$styleable.T, i33);
                int resourceId12 = obtainStyledAttributes.getResourceId(R$styleable.R, i40);
                int resourceId13 = obtainStyledAttributes.getResourceId(R$styleable.f10066f0, i41);
                int i42 = resourceId;
                int resourceId14 = obtainStyledAttributes.getResourceId(R$styleable.f10064e0, i36);
                int resourceId15 = obtainStyledAttributes.getResourceId(R$styleable.f10070h0, i37);
                int resourceId16 = obtainStyledAttributes.getResourceId(R$styleable.f10068g0, i38);
                int resourceId17 = obtainStyledAttributes.getResourceId(R$styleable.f10074j0, i39);
                int i43 = resourceId4;
                playerControlView = this;
                try {
                    playerControlView.f9867s0 = obtainStyledAttributes.getInt(R$styleable.f10060c0, playerControlView.f9867s0);
                    playerControlView.f9871u0 = X(obtainStyledAttributes, playerControlView.f9871u0);
                    boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.Z, true);
                    boolean z13 = obtainStyledAttributes.getBoolean(R$styleable.W, true);
                    boolean z14 = obtainStyledAttributes.getBoolean(R$styleable.Y, true);
                    boolean z15 = obtainStyledAttributes.getBoolean(R$styleable.X, true);
                    boolean z16 = obtainStyledAttributes.getBoolean(R$styleable.f10056a0, false);
                    boolean z17 = obtainStyledAttributes.getBoolean(R$styleable.f10058b0, false);
                    boolean z18 = obtainStyledAttributes.getBoolean(R$styleable.f10062d0, false);
                    playerControlView.setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(R$styleable.f10072i0, playerControlView.f9869t0));
                    boolean z19 = obtainStyledAttributes.getBoolean(R$styleable.I, true);
                    obtainStyledAttributes.recycle();
                    i18 = resourceId14;
                    i17 = i42;
                    z2 = z19;
                    i3 = resourceId6;
                    i10 = resourceId7;
                    i9 = resourceId8;
                    i8 = resourceId9;
                    i7 = resourceId10;
                    i6 = resourceId11;
                    i5 = resourceId12;
                    i4 = resourceId13;
                    i14 = resourceId15;
                    i13 = resourceId16;
                    i19 = resourceId17;
                    z9 = z12;
                    z8 = z13;
                    z7 = z14;
                    z6 = z15;
                    z5 = z16;
                    z4 = z17;
                    z3 = z18;
                    i12 = resourceId2;
                    i11 = resourceId3;
                    i16 = resourceId5;
                    i15 = i43;
                } catch (Throwable th) {
                    th = th;
                    obtainStyledAttributes.recycle();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i19 = i39;
            int i44 = i38;
            int i45 = i37;
            int i46 = i26;
            playerControlView = this;
            int i47 = i23;
            int i48 = i36;
            i3 = i28;
            i10 = i29;
            i9 = i30;
            i8 = i31;
            i7 = i32;
            i6 = i33;
            i5 = i34;
            i4 = i35;
            i14 = i45;
            i13 = i44;
            z9 = true;
            z8 = true;
            z7 = true;
            z6 = true;
            z5 = false;
            z4 = false;
            z3 = false;
            z2 = true;
            i12 = i24;
            i11 = i25;
            i16 = i27;
            i15 = i46;
            int i49 = i48;
            i17 = i47;
            i18 = i49;
        }
        LayoutInflater.from(context).inflate(i17, playerControlView);
        playerControlView.setDescendantFocusability(262144);
        ComponentListener componentListener2 = new ComponentListener();
        playerControlView.f9836d = componentListener2;
        playerControlView.f9838e = new CopyOnWriteArrayList<>();
        playerControlView.I = new Timeline.Period();
        playerControlView.J = new Timeline.Window();
        StringBuilder sb = new StringBuilder();
        playerControlView.G = sb;
        int i50 = i16;
        playerControlView.H = new Formatter(sb, Locale.getDefault());
        playerControlView.f9873v0 = new long[0];
        playerControlView.f9875w0 = new boolean[0];
        playerControlView.f9877x0 = new long[0];
        playerControlView.F0 = new boolean[0];
        playerControlView.K = new p.e(playerControlView);
        playerControlView.D = (TextView) playerControlView.findViewById(R$id.f10005m);
        playerControlView.E = (TextView) playerControlView.findViewById(R$id.G);
        ImageView imageView = (ImageView) playerControlView.findViewById(R$id.R);
        playerControlView.f9876x = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener2);
        }
        ImageView imageView2 = (ImageView) playerControlView.findViewById(R$id.f10011s);
        playerControlView.f9878y = imageView2;
        b0(imageView2, new f(playerControlView));
        ImageView imageView3 = (ImageView) playerControlView.findViewById(R$id.f10015x);
        playerControlView.f9879z = imageView3;
        b0(imageView3, new f(playerControlView));
        View findViewById = playerControlView.findViewById(R$id.N);
        playerControlView.A = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(componentListener2);
        }
        View findViewById2 = playerControlView.findViewById(R$id.F);
        playerControlView.B = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(componentListener2);
        }
        View findViewById3 = playerControlView.findViewById(R$id.f9995c);
        playerControlView.C = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(componentListener2);
        }
        int i51 = R$id.I;
        TimeBar timeBar = (TimeBar) playerControlView.findViewById(i51);
        View findViewById4 = playerControlView.findViewById(R$id.J);
        if (timeBar != null) {
            playerControlView.F = timeBar;
            i20 = i3;
            componentListener = componentListener2;
            playerControlView2 = playerControlView;
            z10 = z6;
            i21 = i50;
            z11 = z7;
            i22 = i15;
        } else if (findViewById4 != null) {
            DefaultTimeBar defaultTimeBar = r2;
            i20 = i3;
            componentListener = componentListener2;
            View view = findViewById4;
            z10 = z6;
            i21 = i50;
            z11 = z7;
            i22 = i15;
            DefaultTimeBar defaultTimeBar2 = new DefaultTimeBar(context, (AttributeSet) null, 0, attributeSet2, R$style.f10054a);
            DefaultTimeBar defaultTimeBar3 = defaultTimeBar;
            defaultTimeBar3.setId(i51);
            defaultTimeBar3.setLayoutParams(view.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            View view2 = view;
            int indexOfChild = viewGroup.indexOfChild(view2);
            viewGroup.removeView(view2);
            viewGroup.addView(defaultTimeBar3, indexOfChild);
            playerControlView2 = this;
            playerControlView2.F = defaultTimeBar3;
        } else {
            i20 = i3;
            componentListener = componentListener2;
            playerControlView2 = playerControlView;
            z10 = z6;
            i21 = i50;
            z11 = z7;
            i22 = i15;
            playerControlView2.F = null;
        }
        TimeBar timeBar2 = playerControlView2.F;
        ComponentListener componentListener3 = componentListener;
        if (timeBar2 != null) {
            timeBar2.b(componentListener3);
        }
        Resources resources = context.getResources();
        playerControlView2.f9834c = resources;
        ImageView imageView4 = (ImageView) playerControlView2.findViewById(R$id.E);
        playerControlView2.f9860p = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(componentListener3);
        }
        ImageView imageView5 = (ImageView) playerControlView2.findViewById(R$id.H);
        playerControlView2.f9856n = imageView5;
        Context context3 = context;
        if (imageView5 != null) {
            imageView5.setImageDrawable(Util.X(context3, resources, i20));
            imageView5.setOnClickListener(componentListener3);
        }
        ImageView imageView6 = (ImageView) playerControlView2.findViewById(R$id.f10016y);
        playerControlView2.f9858o = imageView6;
        if (imageView6 != null) {
            imageView6.setImageDrawable(Util.X(context3, resources, i22));
            imageView6.setOnClickListener(componentListener3);
        }
        Typeface g2 = ResourcesCompat.g(context3, R$font.f9992a);
        ImageView imageView7 = (ImageView) playerControlView2.findViewById(R$id.L);
        TextView textView = (TextView) playerControlView2.findViewById(R$id.M);
        if (imageView7 != null) {
            imageView7.setImageDrawable(Util.X(context3, resources, i10));
            playerControlView2.f9864r = imageView7;
            playerControlView2.f9868t = null;
        } else if (textView != null) {
            textView.setTypeface(g2);
            playerControlView2.f9868t = textView;
            playerControlView2.f9864r = textView;
        } else {
            playerControlView2.f9868t = null;
            playerControlView2.f9864r = null;
        }
        View view3 = playerControlView2.f9864r;
        if (view3 != null) {
            view3.setOnClickListener(playerControlView2.f9836d);
        }
        ImageView imageView8 = (ImageView) playerControlView2.findViewById(R$id.f10009q);
        TextView textView2 = (TextView) playerControlView2.findViewById(R$id.f10010r);
        if (imageView8 != null) {
            imageView8.setImageDrawable(Util.X(context3, resources, i21));
            playerControlView2.f9862q = imageView8;
            playerControlView2.f9866s = null;
        } else if (textView2 != null) {
            textView2.setTypeface(g2);
            playerControlView2.f9866s = textView2;
            playerControlView2.f9862q = textView2;
        } else {
            playerControlView2.f9866s = null;
            playerControlView2.f9862q = null;
        }
        View view4 = playerControlView2.f9862q;
        if (view4 != null) {
            view4.setOnClickListener(playerControlView2.f9836d);
        }
        ImageView imageView9 = (ImageView) playerControlView2.findViewById(R$id.K);
        playerControlView2.f9870u = imageView9;
        if (imageView9 != null) {
            imageView9.setOnClickListener(playerControlView2.f9836d);
        }
        ImageView imageView10 = (ImageView) playerControlView2.findViewById(R$id.O);
        playerControlView2.f9872v = imageView10;
        if (imageView10 != null) {
            imageView10.setOnClickListener(playerControlView2.f9836d);
        }
        playerControlView2.V = ((float) resources.getInteger(R$integer.f10019b)) / 100.0f;
        playerControlView2.W = ((float) resources.getInteger(R$integer.f10018a)) / 100.0f;
        ImageView imageView11 = (ImageView) playerControlView2.findViewById(R$id.V);
        playerControlView2.f9874w = imageView11;
        if (imageView11 != null) {
            imageView11.setImageDrawable(Util.X(context3, resources, i19));
            playerControlView2.p0(false, imageView11);
        }
        PlayerControlViewLayoutManager playerControlViewLayoutManager = new PlayerControlViewLayoutManager(playerControlView2);
        playerControlView2.f9832b = playerControlViewLayoutManager;
        playerControlViewLayoutManager.X(z2);
        SettingsAdapter settingsAdapter = new SettingsAdapter(new String[]{resources.getString(R$string.f10035h), playerControlView2.f9834c.getString(R$string.f10052y)}, new Drawable[]{Util.X(context3, playerControlView2.f9834c, R$drawable.f9988u), Util.X(context3, playerControlView2.f9834c, R$drawable.f9976g)});
        playerControlView2.f9842g = settingsAdapter;
        playerControlView2.f9854m = playerControlView2.f9834c.getDimensionPixelSize(R$dimen.f9971a);
        RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context).inflate(R$layout.f10023e, (ViewGroup) null);
        playerControlView2.f9840f = recyclerView;
        recyclerView.setAdapter(settingsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        PopupWindow popupWindow = new PopupWindow(recyclerView, -2, -2, true);
        playerControlView2.f9852l = popupWindow;
        if (Util.f4714a < 23) {
            popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        }
        popupWindow.setOnDismissListener(playerControlView2.f9836d);
        playerControlView2.H0 = true;
        playerControlView2.f9850k = new DefaultTrackNameProvider(getResources());
        playerControlView2.f9835c0 = Util.X(context3, playerControlView2.f9834c, i14);
        playerControlView2.f9837d0 = Util.X(context3, playerControlView2.f9834c, i13);
        playerControlView2.f9839e0 = playerControlView2.f9834c.getString(R$string.f10029b);
        playerControlView2.f9841f0 = playerControlView2.f9834c.getString(R$string.f10028a);
        playerControlView2.f9846i = new TextTrackSelectionAdapter();
        playerControlView2.f9848j = new AudioTrackSelectionAdapter();
        playerControlView2.f9844h = new PlaybackSpeedAdapter(playerControlView2.f9834c.getStringArray(R$array.f9969a), I0);
        playerControlView2.L = Util.X(context3, playerControlView2.f9834c, i12);
        playerControlView2.M = Util.X(context3, playerControlView2.f9834c, i11);
        playerControlView2.f9843g0 = Util.X(context3, playerControlView2.f9834c, i9);
        playerControlView2.f9845h0 = Util.X(context3, playerControlView2.f9834c, i8);
        playerControlView2.N = Util.X(context3, playerControlView2.f9834c, i7);
        playerControlView2.O = Util.X(context3, playerControlView2.f9834c, i6);
        playerControlView2.P = Util.X(context3, playerControlView2.f9834c, i5);
        playerControlView2.T = Util.X(context3, playerControlView2.f9834c, i4);
        playerControlView2.U = Util.X(context3, playerControlView2.f9834c, i18);
        playerControlView2.f9847i0 = playerControlView2.f9834c.getString(R$string.f10031d);
        playerControlView2.f9849j0 = playerControlView2.f9834c.getString(R$string.f10030c);
        playerControlView2.Q = playerControlView2.f9834c.getString(R$string.f10037j);
        playerControlView2.R = playerControlView2.f9834c.getString(R$string.f10038k);
        playerControlView2.S = playerControlView2.f9834c.getString(R$string.f10036i);
        playerControlView2.f9831a0 = playerControlView2.f9834c.getString(R$string.f10041n);
        playerControlView2.f9833b0 = playerControlView2.f9834c.getString(R$string.f10040m);
        boolean z20 = true;
        playerControlView2.f9832b.Y((ViewGroup) playerControlView2.findViewById(R$id.f9997e), true);
        playerControlView2.f9832b.Y(playerControlView2.f9862q, z8);
        playerControlView2.f9832b.Y(playerControlView2.f9864r, z9);
        playerControlView2.f9832b.Y(playerControlView2.f9856n, z11);
        playerControlView2.f9832b.Y(playerControlView2.f9858o, z10);
        playerControlView2.f9832b.Y(playerControlView2.f9872v, z5);
        playerControlView2.f9832b.Y(playerControlView2.f9876x, z4);
        playerControlView2.f9832b.Y(playerControlView2.f9874w, z3);
        playerControlView2.f9832b.Y(playerControlView2.f9870u, playerControlView2.f9871u0 == 0 ? false : z20);
        playerControlView2.addOnLayoutChangeListener(new g(playerControlView2));
    }
}

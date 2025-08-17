package com.movie.ui.activity.player;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.database.StandaloneDatabaseProvider;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.datasource.HttpDataSource$Factory;
import androidx.media3.datasource.cache.CacheDataSource;
import androidx.media3.datasource.cache.LeastRecentlyUsedCacheEvictor;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.ClippingMediaSource;
import androidx.media3.exoplayer.source.ConcatenatingMediaSource;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MergingMediaSource;
import androidx.media3.exoplayer.source.SingleSampleMediaSource;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.SubtitleView;
import b1.a;
import b1.a0;
import b1.b;
import b1.b0;
import b1.c;
import b1.c0;
import b1.d;
import b1.d0;
import b1.e;
import b1.e0;
import b1.f;
import b1.f0;
import b1.g;
import b1.g0;
import b1.h;
import b1.h0;
import b1.i;
import b1.i0;
import b1.j;
import b1.j0;
import b1.k;
import b1.k0;
import b1.l;
import b1.l0;
import b1.m;
import b1.m0;
import b1.n;
import b1.o;
import b1.p;
import b1.q;
import b1.r;
import b1.s;
import b1.t;
import b1.u;
import b1.v;
import b1.w;
import b1.x;
import b1.y;
import b1.z;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.facebook.imageutils.JfifUtil;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.CodedOutputStream;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.model.SaveCaptionStyle;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.DaggerBaseActivityComponent;
import com.movie.ui.activity.player.event.InvalidFileException;
import com.movie.ui.activity.player.event.PlayerEventSource;
import com.movie.ui.activity.player.event.PlayerEventType;
import com.movie.ui.activity.player.event.ResizedEvent;
import com.movie.ui.activity.player.text.CustomSubtitleDecoderFactory;
import com.movie.ui.activity.player.utils.SSLTrustManager;
import com.movie.ui.activity.player.utils.SubtitleData;
import com.movie.ui.activity.player.utils.SubtitleHelper;
import com.movie.ui.activity.player.utils.UiExtKt;
import com.movie.ui.activity.player.utils.Vector2;
import com.original.tase.model.media.MediaSource;
import com.unity3d.services.core.device.MimeTypes;
import com.utils.Utils;
import com.yoku.marumovie.R;
import com.yoku.marumovie.databinding.CustomPlayerControllViewBinding;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.inject.Inject;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public final class PlayerActivity extends BaseActivity {

    /* renamed from: i0  reason: collision with root package name */
    public static final Companion f32356i0 = new Companion((DefaultConstructorMarker) null);
    private CustomPlayerControllViewBinding A;
    /* access modifiers changed from: private */
    public final SubtitleHelper B;
    private FrameLayout C;
    private int D;
    /* access modifiers changed from: private */
    public List<Pair<String, Boolean>> E;
    private final List<Integer> F;
    private final List<Integer> G;
    private int H;
    private SaveCaptionStyle I;
    private SubtitleView J;
    private boolean K;
    private boolean L;
    private boolean M;
    private long N;
    private long O;
    private long P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private float V;
    private Vector2 W;
    private Vector2 X;
    private TouchAction Y;
    private TouchAction Z;

    /* renamed from: a0  reason: collision with root package name */
    private Long f32357a0;

    /* renamed from: b  reason: collision with root package name */
    private final String f32358b = "pre_resize_mode";

    /* renamed from: b0  reason: collision with root package name */
    private Long f32359b0;

    /* renamed from: c  reason: collision with root package name */
    private SimpleCache f32360c;

    /* renamed from: c0  reason: collision with root package name */
    private long f32361c0;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f32362d = true;

    /* renamed from: d0  reason: collision with root package name */
    private int f32363d0;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ExoPlayer f32364e;

    /* renamed from: e0  reason: collision with root package name */
    private float f32365e0;

    /* renamed from: f  reason: collision with root package name */
    private int f32366f;

    /* renamed from: f0  reason: collision with root package name */
    private float f32367f0;

    /* renamed from: g  reason: collision with root package name */
    private long f32368g;

    /* renamed from: g0  reason: collision with root package name */
    private boolean f32369g0;

    /* renamed from: h  reason: collision with root package name */
    private SubtitleData f32370h;

    /* renamed from: h0  reason: collision with root package name */
    private int f32371h0;

    /* renamed from: i  reason: collision with root package name */
    private MediaSource f32372i;

    /* renamed from: j  reason: collision with root package name */
    private final DisplayMetrics f32373j;

    /* renamed from: k  reason: collision with root package name */
    private TextRenderer f32374k;

    /* renamed from: l  reason: collision with root package name */
    private long f32375l;

    /* renamed from: m  reason: collision with root package name */
    private long f32376m;

    /* renamed from: n  reason: collision with root package name */
    private long f32377n;

    /* renamed from: o  reason: collision with root package name */
    private float f32378o;

    /* renamed from: p  reason: collision with root package name */
    private float f32379p;

    /* renamed from: q  reason: collision with root package name */
    private long f32380q;

    /* renamed from: r  reason: collision with root package name */
    private PlayerView f32381r;

    /* renamed from: s  reason: collision with root package name */
    private final List<MediaSource> f32382s;

    /* renamed from: t  reason: collision with root package name */
    private int f32383t;

    /* renamed from: u  reason: collision with root package name */
    private final List<SubtitleData> f32384u;

    /* renamed from: v  reason: collision with root package name */
    private int f32385v;

    /* renamed from: w  reason: collision with root package name */
    private int f32386w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f32387x;

    /* renamed from: y  reason: collision with root package name */
    private int f32388y;
    @Inject

    /* renamed from: z  reason: collision with root package name */
    public OkHttpClient f32389z;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final String b(long j2) {
            String str;
            long j3 = j2 % 60;
            long ceil = (long) ((int) Math.ceil(((double) (j2 - j3)) / 60.0d));
            long j4 = ceil % 60;
            long ceil2 = (long) Math.ceil(((double) (ceil - j4)) / 60.0d);
            StringBuilder sb = new StringBuilder();
            String str2 = "";
            int i2 = (ceil2 > 0 ? 1 : (ceil2 == 0 ? 0 : -1));
            if (i2 > 0) {
                str = d(this, ceil2, 0, 2, (Object) null) + ':';
            } else {
                str = str2;
            }
            sb.append(str);
            if (j4 >= 0 || i2 >= 0) {
                str2 = d(this, j4, 0, 2, (Object) null) + ':';
            }
            sb.append(str2);
            sb.append(d(this, j3, 0, 2, (Object) null));
            return sb.toString();
        }

        private final String c(long j2, int i2) {
            int length = i2 - String.valueOf(j2).length();
            if (length <= 0) {
                return String.valueOf(j2);
            }
            return StringsKt__StringsJVMKt.y("0", length) + j2;
        }

        static /* synthetic */ String d(Companion companion, long j2, int i2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                i2 = 2;
            }
            return companion.c(j2, i2);
        }
    }

    public static final class DrmMetadata {
    }

    public enum TouchAction {
        Brightness,
        Volume,
        Time;

        static {
            TouchAction[] a2;
            f32396f = EnumEntriesKt.a(a2);
        }
    }

    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32397a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f32398b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f32399c;

        /* renamed from: d  reason: collision with root package name */
        public static final /* synthetic */ int[] f32400d;

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ int[] f32401e;

        /* JADX WARNING: Can't wrap try/catch for region: R(50:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21|22|23|24|(2:25|26)|27|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|(2:59|60)|61|63) */
        /* JADX WARNING: Can't wrap try/catch for region: R(54:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|(2:59|60)|61|63) */
        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|63) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|21|22|23|24|25|26|27|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|63) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x007d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00a6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00c1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00ca */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00d4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00de */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00e8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00f2 */
        static {
            /*
                com.movie.ui.activity.player.utils.SubtitleStatus[] r0 = com.movie.ui.activity.player.utils.SubtitleStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.movie.ui.activity.player.utils.SubtitleStatus r2 = com.movie.ui.activity.player.utils.SubtitleStatus.REQUIRES_RELOAD     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.movie.ui.activity.player.utils.SubtitleStatus r3 = com.movie.ui.activity.player.utils.SubtitleStatus.IS_ACTIVE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.movie.ui.activity.player.utils.SubtitleStatus r4 = com.movie.ui.activity.player.utils.SubtitleStatus.NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f32397a = r0
                com.movie.ui.activity.player.PlayerResize[] r0 = com.movie.ui.activity.player.PlayerResize.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.movie.ui.activity.player.PlayerResize r4 = com.movie.ui.activity.player.PlayerResize.Fill     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.movie.ui.activity.player.PlayerResize r4 = com.movie.ui.activity.player.PlayerResize.Fit     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.movie.ui.activity.player.PlayerResize r4 = com.movie.ui.activity.player.PlayerResize.Zoom     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                f32398b = r0
                com.movie.ui.activity.player.utils.SubtitleOrigin[] r0 = com.movie.ui.activity.player.utils.SubtitleOrigin.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.movie.ui.activity.player.utils.SubtitleOrigin r4 = com.movie.ui.activity.player.utils.SubtitleOrigin.EMBEDDED_IN_VIDEO     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.movie.ui.activity.player.utils.SubtitleOrigin r4 = com.movie.ui.activity.player.utils.SubtitleOrigin.DOWNLOADED_FILE     // Catch:{ NoSuchFieldError -> 0x005c }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                com.movie.ui.activity.player.utils.SubtitleOrigin r4 = com.movie.ui.activity.player.utils.SubtitleOrigin.URL     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                f32399c = r0
                com.movie.ui.activity.player.PlayerActivity$TouchAction[] r0 = com.movie.ui.activity.player.PlayerActivity.TouchAction.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.movie.ui.activity.player.PlayerActivity$TouchAction r4 = com.movie.ui.activity.player.PlayerActivity.TouchAction.Time     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                com.movie.ui.activity.player.PlayerActivity$TouchAction r4 = com.movie.ui.activity.player.PlayerActivity.TouchAction.Brightness     // Catch:{ NoSuchFieldError -> 0x007d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                com.movie.ui.activity.player.PlayerActivity$TouchAction r4 = com.movie.ui.activity.player.PlayerActivity.TouchAction.Volume     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                f32400d = r0
                com.movie.ui.activity.player.event.PlayerEventType[] r0 = com.movie.ui.activity.player.event.PlayerEventType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.movie.ui.activity.player.event.PlayerEventType r4 = com.movie.ui.activity.player.event.PlayerEventType.Lock     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.Pause     // Catch:{ NoSuchFieldError -> 0x009e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.PlayPauseToggle     // Catch:{ NoSuchFieldError -> 0x00a6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a6 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00a6 }
            L_0x00a6:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.Play     // Catch:{ NoSuchFieldError -> 0x00af }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.Resize     // Catch:{ NoSuchFieldError -> 0x00b8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b8 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b8 }
            L_0x00b8:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.SeekForward     // Catch:{ NoSuchFieldError -> 0x00c1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c1 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c1 }
            L_0x00c1:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.ShowSpeed     // Catch:{ NoSuchFieldError -> 0x00ca }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ca }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00ca }
            L_0x00ca:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.SeekBack     // Catch:{ NoSuchFieldError -> 0x00d4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d4 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d4 }
            L_0x00d4:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.ToggleMute     // Catch:{ NoSuchFieldError -> 0x00de }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00de }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00de }
            L_0x00de:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.ToggleHide     // Catch:{ NoSuchFieldError -> 0x00e8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e8 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e8 }
            L_0x00e8:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.ShowSources     // Catch:{ NoSuchFieldError -> 0x00f2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f2 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f2 }
            L_0x00f2:
                com.movie.ui.activity.player.event.PlayerEventType r1 = com.movie.ui.activity.player.event.PlayerEventType.SearchSubtitlesOnline     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                f32401e = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.PlayerActivity.WhenMappings.<clinit>():void");
        }
    }

    public PlayerActivity() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        Intrinsics.e(displayMetrics, "getDisplayMetrics(...)");
        this.f32373j = displayMetrics;
        this.f32378o = 1.0f;
        this.f32379p = 1.0f;
        this.f32382s = new ArrayList();
        this.f32384u = new ArrayList();
        this.f32385v = -1;
        this.f32386w = -1;
        this.f32388y = R.layout.activity_player;
        this.B = new SubtitleHelper();
        this.E = CollectionsKt__CollectionsKt.f();
        this.F = CollectionsKt__CollectionsKt.i(Integer.valueOf(R.drawable.sun_1), Integer.valueOf(R.drawable.sun_2), Integer.valueOf(R.drawable.sun_3), Integer.valueOf(R.drawable.sun_4), Integer.valueOf(R.drawable.sun_5), Integer.valueOf(R.drawable.sun_6));
        this.G = CollectionsKt__CollectionsKt.i(Integer.valueOf(R.drawable.ic_baseline_volume_mute_24), Integer.valueOf(R.drawable.ic_baseline_volume_down_24), Integer.valueOf(R.drawable.ic_baseline_volume_up_24));
        this.H = FreeMoviesApp.p().getInt("pre_resize_mode", 0);
        this.K = true;
        this.M = true;
        this.N = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        this.O = NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS;
        this.P = NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS;
        this.S = true;
        this.U = true;
        this.V = 1.0f;
        this.f32367f0 = 1.0f;
        this.f32369g0 = true;
    }

    private final Long A0(Long l2, Vector2 vector2, Vector2 vector22) {
        int i2;
        if (!(vector2 == null || vector22 == null || l2 == null)) {
            float c2 = ((vector22.c() - vector2.c()) * 2.0f) / ((float) R0());
            ExoPlayer exoPlayer = this.f32364e;
            if (exoPlayer != null) {
                long duration = exoPlayer.getDuration();
                long longValue = l2.longValue();
                float f2 = ((float) duration) * c2 * c2;
                if (c2 < 0.0f) {
                    i2 = -1;
                } else {
                    i2 = 1;
                }
                return Long.valueOf(Math.max(Math.min(longValue + ((long) (f2 * ((float) i2))), duration), 0));
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void A1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.g2();
    }

    private final DataSource.Factory B0(Context context) {
        return new DefaultDataSource.Factory(context);
    }

    /* access modifiers changed from: private */
    public static final void B1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.P1();
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    private final HttpDataSource$Factory C0(MediaSource mediaSource) {
        OkHttpDataSource.Factory e2 = new OkHttpDataSource.Factory(new OkHttpClient()).e("User-Agent");
        Intrinsics.e(e2, "setUserAgent(...)");
        Map j2 = MapsKt__MapsKt.j(TuplesKt.a("accept", "*/*"), TuplesKt.a("sec-ch-ua", "\"Chromium\";v=\"91\", \" Not;A Brand\";v=\"99\""), TuplesKt.a("sec-ch-ua-mobile", "?0"), TuplesKt.a("sec-fetch-user", "?1"), TuplesKt.a("sec-fetch-mode", "navigate"), TuplesKt.a("sec-fetch-dest", MimeTypes.BASE_TYPE_VIDEO));
        Map playHeader = mediaSource.getPlayHeader();
        if (playHeader == null) {
            playHeader = MapsKt__MapsKt.g();
        }
        e2.b(MapsKt__MapsKt.o(j2, playHeader));
        return e2;
    }

    /* access modifiers changed from: private */
    public static final void C1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.v0();
        ExoPlayer exoPlayer = playerActivity.f32364e;
        if (exoPlayer != null) {
            exoPlayer.seekTo(exoPlayer.getCurrentPosition() - 15000);
        }
    }

    private final void D0() {
        try {
            if (this.A != null) {
                int i2 = getResources().getDisplayMetrics().widthPixels;
                int i3 = getResources().getDisplayMetrics().heightPixels;
            }
            ExoPlayer exoPlayer = this.f32364e;
            if (exoPlayer != null) {
                exoPlayer.seekTo(exoPlayer.getCurrentPosition() + this.N);
            }
        } catch (Exception e2) {
            Timber.f42178a.c(e2);
        }
    }

    /* access modifiers changed from: private */
    public static final void D1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.v0();
        ExoPlayer exoPlayer = playerActivity.f32364e;
        if (exoPlayer != null) {
            exoPlayer.seekTo(exoPlayer.getCurrentPosition() + 15000);
        }
    }

    private final void E0() {
        try {
            if (this.A != null) {
                int i2 = getResources().getDisplayMetrics().widthPixels;
            }
            ExoPlayer exoPlayer = this.f32364e;
            if (exoPlayer != null) {
                exoPlayer.seekTo(exoPlayer.getCurrentPosition() - this.N);
            }
        } catch (Exception e2) {
            Timber.f42178a.c(e2);
        }
    }

    /* access modifiers changed from: private */
    public static final void E1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.r1();
        playerActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void F1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.W1();
    }

    /* access modifiers changed from: private */
    public static final boolean G1(PlayerActivity playerActivity, View view, MotionEvent motionEvent) {
        Intrinsics.f(playerActivity, "this$0");
        return playerActivity.Z0(view, motionEvent);
    }

    private final Float H0() {
        WindowManager.LayoutParams attributes;
        if (this.f32369g0) {
            try {
                return Float.valueOf(((float) Settings.System.getInt(getContentResolver(), "screen_brightness")) / 255.0f);
            } catch (Exception unused) {
                this.f32369g0 = false;
                return H0();
            }
        } else {
            try {
                Window window = getWindow();
                if (window == null || (attributes = window.getAttributes()) == null) {
                    return null;
                }
                return Float.valueOf(attributes.screenBrightness);
            } catch (Exception e2) {
                Timber.f42178a.c(e2);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final boolean H1(PlayerActivity playerActivity, View view, MotionEvent motionEvent) {
        Intrinsics.f(playerActivity, "this$0");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    playerActivity.D++;
                    return false;
                } else if (!(action == 3 || action == 12)) {
                    return false;
                }
            }
            playerActivity.v0();
            return false;
        }
        playerActivity.D++;
        return false;
    }

    private final SimpleCache I0(Context context, long j2) {
        try {
            StandaloneDatabaseProvider standaloneDatabaseProvider = new StandaloneDatabaseProvider(context);
            File file = new File(context.getCacheDir(), "media3");
            Utils.c(file.getPath());
            return new SimpleCache(file, new LeastRecentlyUsedCacheEvictor(j2), standaloneDatabaseProvider);
        } catch (Exception e2) {
            Timber.f42178a.c(e2);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static final void I1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.v0();
        ExoPlayer exoPlayer = playerActivity.f32364e;
        if (exoPlayer == null) {
            return;
        }
        if (exoPlayer.isPlaying()) {
            exoPlayer.pause();
        } else {
            exoPlayer.play();
        }
    }

    /* access modifiers changed from: private */
    public static final void J1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.x1(true);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"UnsafeOptInUsageError"})
    public final List<Pair<Format, Integer>> K0(Tracks.Group group) {
        Pair pair;
        IntRange j2 = RangesKt___RangesKt.j(0, group.a().f4390a);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = j2.iterator();
        while (it2.hasNext()) {
            int nextInt = ((IntIterator) it2).nextInt();
            if (group.f()) {
                pair = TuplesKt.a(group.a().a(nextInt), Integer.valueOf(nextInt));
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final void K1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.x1(false);
    }

    /* access modifiers changed from: private */
    public final List<Pair<Format, Integer>> L0(List<Tracks.Group> list) {
        Iterable<Tracks.Group> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
        for (Tracks.Group K0 : iterable) {
            arrayList.add(K0(K0));
        }
        return CollectionsKt__IterablesKt.r(arrayList);
    }

    /* access modifiers changed from: private */
    public static final void L1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.v0();
        playerActivity.s2();
    }

    /* access modifiers changed from: private */
    public static final void M1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.v0();
        playerActivity.g1();
        playerActivity.w1();
    }

    private final MediaItem N0(String str, String str2) {
        MediaItem a2 = O0(str).h(str2).a();
        Intrinsics.e(a2, "build(...)");
        return a2;
    }

    /* access modifiers changed from: private */
    public static final void N1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.v0();
        playerActivity.b2();
    }

    private final MediaItem.Builder O0(String str) {
        MediaItem.Builder d2 = new MediaItem.Builder().d(str);
        Intrinsics.e(d2, "setMimeType(...)");
        return d2;
    }

    /* access modifiers changed from: private */
    public static final void O1(PlayerActivity playerActivity, View view) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.v0();
        playerActivity.p2();
    }

    /* access modifiers changed from: private */
    public static final void Q1(Ref$IntRef ref$IntRef, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(ref$IntRef, "$selectedSourceIndex");
        ref$IntRef.f40427b = i2;
    }

    /* access modifiers changed from: private */
    public static final void R1(PlayerActivity playerActivity, Ref$IntRef ref$IntRef, DialogInterface dialogInterface, int i2) {
        String str;
        Intrinsics.f(playerActivity, "this$0");
        Intrinsics.f(ref$IntRef, "$selectedSourceIndex");
        playerActivity.f32386w = ref$IntRef.f40427b;
        AudioTrack audioTrack = (AudioTrack) CollectionsKt___CollectionsKt.E(playerActivity.J0().a(), playerActivity.f32386w);
        String str2 = null;
        if (audioTrack != null) {
            str = audioTrack.b();
        } else {
            str = null;
        }
        if (audioTrack != null) {
            str2 = audioTrack.a();
        }
        playerActivity.t1(str, str2);
        dialogInterface.dismiss();
        playerActivity.v0();
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    private final Pair<List<SingleSampleMediaSource>, List<SubtitleData>> S0(HttpDataSource$Factory httpDataSource$Factory, DataSource.Factory factory, SubtitleHelper subtitleHelper) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (SubtitleData subtitleData : subtitleHelper.d()) {
            MediaItem.SubtitleConfiguration i2 = new MediaItem.SubtitleConfiguration.Builder(Uri.parse(subtitleData.g())).n(subtitleData.d()).m(subtitleData.c()).l(subtitleData.e()).k(subtitleData.b()).o(0).i();
            Intrinsics.e(i2, "build(...)");
            int i3 = WhenMappings.f32399c[subtitleData.f().ordinal()];
            SingleSampleMediaSource singleSampleMediaSource = null;
            if (i3 == 1 || i3 == 2) {
                if (factory != null) {
                    arrayList.add(subtitleData);
                    singleSampleMediaSource = new SingleSampleMediaSource.Factory(factory).a(i2, -9223372036854775807L);
                }
            } else if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            } else if (httpDataSource$Factory != null) {
                arrayList.add(subtitleData);
                if (!subtitleData.a().isEmpty()) {
                    httpDataSource$Factory.b(subtitleData.a());
                }
                singleSampleMediaSource = new SingleSampleMediaSource.Factory(httpDataSource$Factory).a(i2, -9223372036854775807L);
            }
            if (singleSampleMediaSource != null) {
                arrayList2.add(singleSampleMediaSource);
            }
        }
        return new Pair<>(arrayList2, arrayList);
    }

    /* access modifiers changed from: private */
    public static final void S1(PlayerActivity playerActivity, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(playerActivity, "this$0");
        dialogInterface.dismiss();
        playerActivity.v0();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079 A[EDGE_INSN: B:31:0x0079->B:20:0x0079 ?: BREAK  , SYNTHETIC] */
    @android.annotation.SuppressLint({"UnsafeOptInUsageError"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.Pair<androidx.media3.common.TrackGroup, java.lang.Integer> T0(java.util.List<androidx.media3.common.Tracks.Group> r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r9 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r8 = r8.iterator()
        L_0x000a:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L_0x008e
            java.lang.Object r1 = r8.next()
            androidx.media3.common.Tracks$Group r1 = (androidx.media3.common.Tracks.Group) r1
            androidx.media3.common.TrackGroup r2 = r1.a()
            int r2 = r2.f4390a
            r3 = 0
            kotlin.ranges.IntRange r2 = kotlin.ranges.RangesKt___RangesKt.j(r3, r2)
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.p(r2, r5)
            r4.<init>(r5)
            java.util.Iterator r2 = r2.iterator()
        L_0x0030:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L_0x004d
            r5 = r2
            kotlin.collections.IntIterator r5 = (kotlin.collections.IntIterator) r5
            int r5 = r5.nextInt()
            androidx.media3.common.Format r6 = r1.b(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            kotlin.Pair r5 = kotlin.TuplesKt.a(r6, r5)
            r4.add(r5)
            goto L_0x0030
        L_0x004d:
            java.util.Iterator r2 = r4.iterator()
        L_0x0051:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0078
            java.lang.Object r4 = r2.next()
            r5 = r4
            kotlin.Pair r5 = (kotlin.Pair) r5
            java.lang.Object r5 = r5.c()
            androidx.media3.common.Format r5 = (androidx.media3.common.Format) r5
            java.lang.String r5 = r5.f4002a
            if (r5 == 0) goto L_0x0074
            kotlin.jvm.internal.Intrinsics.c(r5)
            r6 = 2
            boolean r5 = kotlin.text.StringsKt__StringsKt.L(r5, r9, r3, r6, r0)
            r6 = 1
            if (r5 != r6) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r6 = 0
        L_0x0075:
            if (r6 == 0) goto L_0x0051
            goto L_0x0079
        L_0x0078:
            r4 = r0
        L_0x0079:
            kotlin.Pair r4 = (kotlin.Pair) r4
            if (r4 == 0) goto L_0x008a
            androidx.media3.common.TrackGroup r1 = r1.a()
            java.lang.Object r2 = r4.d()
            kotlin.Pair r1 = kotlin.TuplesKt.a(r1, r2)
            goto L_0x008b
        L_0x008a:
            r1 = r0
        L_0x008b:
            if (r1 == 0) goto L_0x000a
            r0 = r1
        L_0x008e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.PlayerActivity.T0(java.util.List, java.lang.String):kotlin.Pair");
    }

    /* access modifiers changed from: private */
    public static final void T1(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Window window = alertDialog.getWindow();
        if (window != null) {
            WindowInsetsControllerCompat a2 = WindowCompat.a(window, window.getDecorView());
            Intrinsics.e(a2, "getInsetsController(...)");
            a2.a(WindowInsetsCompat.Type.b());
            a2.b(2);
        }
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    private final TrackSelector U0(Context context, Integer num) {
        int i2;
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context);
        DefaultTrackSelector.Parameters.Builder F2 = defaultTrackSelector.F();
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = Integer.MAX_VALUE;
        }
        defaultTrackSelector.m(F2.n0(Integer.MAX_VALUE, i2).K((String) null).C());
        return defaultTrackSelector;
    }

    /* access modifiers changed from: private */
    public static final void V1(Function0 function0, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(function0, "$onExitConfirmed");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static final void X1(Ref$IntRef ref$IntRef, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(ref$IntRef, "$selectedLinkIndex");
        ref$IntRef.f40427b = i2;
    }

    private final boolean Y0(KeyEvent keyEvent, boolean z2) {
        ExoPlayer exoPlayer;
        if (z2) {
            v0();
        } else {
            int keyCode = keyEvent.getKeyCode();
            if (keyEvent.getAction() == 0) {
                switch (keyCode) {
                    case 19:
                    case 20:
                        if (!this.M) {
                            h1();
                            return true;
                        }
                        break;
                    case 21:
                        if (!this.M && !this.L) {
                            ExoPlayer exoPlayer2 = this.f32364e;
                            if (exoPlayer2 != null) {
                                exoPlayer2.seekTo(exoPlayer2.getCurrentPosition() - this.O);
                            }
                            return true;
                        }
                    case 22:
                        if (!this.M && !this.L) {
                            ExoPlayer exoPlayer3 = this.f32364e;
                            if (exoPlayer3 != null) {
                                exoPlayer3.seekTo(exoPlayer3.getCurrentPosition() + this.O);
                            }
                            return true;
                        }
                    case 23:
                        if (!this.M) {
                            if (!this.L && (exoPlayer = this.f32364e) != null) {
                                if (exoPlayer.isPlaying()) {
                                    exoPlayer.pause();
                                } else {
                                    exoPlayer.play();
                                }
                            }
                            h1();
                            return true;
                        }
                        break;
                }
            }
            if (keyCode != 4) {
                if (!(keyCode == 19 || keyCode == 20)) {
                    switch (keyCode) {
                        case 268:
                        case 269:
                        case RotationOptions.ROTATE_270:
                        case 271:
                            break;
                    }
                }
                if (!this.M) {
                    return true;
                }
                v0();
            } else if (!this.M) {
                return false;
            } else {
                h1();
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final void Y1(PlayerActivity playerActivity, Ref$IntRef ref$IntRef, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(playerActivity, "this$0");
        Intrinsics.f(ref$IntRef, "$selectedLinkIndex");
        int i3 = ref$IntRef.f40427b;
        playerActivity.f32383t = i3;
        playerActivity.b1(playerActivity, (MediaSource) CollectionsKt___CollectionsKt.E(playerActivity.f32382s, i3), Long.valueOf(playerActivity.f32368g));
        dialogInterface.dismiss();
        playerActivity.v0();
    }

    @SuppressLint({"SetTextI18n"})
    private final boolean Z0(View view, MotionEvent motionEvent) {
        Long l2;
        AudioManager audioManager;
        Long l3;
        Long l4;
        Long A0;
        ExoPlayer exoPlayer;
        int i2;
        Long l5;
        Long A02;
        String str;
        boolean z2;
        AudioManager audioManager2;
        int i3;
        TouchAction touchAction;
        if (motionEvent == null || view == null) {
            return false;
        }
        Vector2 vector2 = new Vector2(motionEvent.getX(), motionEvent.getY());
        Vector2 vector22 = this.W;
        CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
        if (customPlayerControllViewBinding != null) {
            FrameLayout frameLayout = customPlayerControllViewBinding.f38137z;
            Intrinsics.e(frameLayout, "playerIntroPlay");
            frameLayout.setVisibility(8);
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f32359b0 = Long.valueOf(System.currentTimeMillis());
                this.W = vector2;
                this.X = vector2;
                ExoPlayer exoPlayer2 = this.f32364e;
                if (exoPlayer2 != null) {
                    l2 = Long.valueOf(exoPlayer2.getCurrentPosition());
                } else {
                    l2 = null;
                }
                this.f32357a0 = l2;
                Float H0 = H0();
                if (H0 != null) {
                    this.f32367f0 = H0.floatValue();
                }
                Object systemService = getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                if (systemService instanceof AudioManager) {
                    audioManager = (AudioManager) systemService;
                } else {
                    audioManager = null;
                }
                if (audioManager != null) {
                    this.f32365e0 = ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
                }
            } else if (action == 1) {
                if (!this.L && this.Q && this.Y == TouchAction.Time && (l4 = this.f32357a0) != null && (A0 = A0(l4, vector22, vector2)) != null) {
                    long longValue = A0.longValue();
                    if (Math.abs(longValue - l4.longValue()) > 7000 && (exoPlayer = this.f32364e) != null) {
                        exoPlayer.seekTo(exoPlayer.getCurrentPosition() + longValue);
                    }
                }
                Long l6 = this.f32359b0;
                if (l6 != null) {
                    l3 = Long.valueOf(l6.longValue() - System.currentTimeMillis());
                } else {
                    l3 = null;
                }
                if (this.Y != null || this.Z != null || l3 == null || l3.longValue() >= 200) {
                    this.f32363d0 = 0;
                } else if (this.L || System.currentTimeMillis() - this.f32361c0 >= 200) {
                    this.f32363d0 = 0;
                    t2();
                } else {
                    int i4 = this.f32363d0 + 1;
                    this.f32363d0 = i4;
                    if (i4 >= 1) {
                        this.f32371h0++;
                        if (this.U) {
                            if (((double) vector2.c()) < ((double) (R0() / 2)) - (((double) R0()) * 0.15d)) {
                                if (this.T) {
                                    E0();
                                }
                            } else if (((double) vector2.c()) <= ((double) (R0() / 2)) + (((double) R0()) * 0.15d)) {
                                ExoPlayer exoPlayer3 = this.f32364e;
                                if (exoPlayer3 != null) {
                                    if (exoPlayer3.isPlaying()) {
                                        exoPlayer3.pause();
                                    } else {
                                        exoPlayer3.play();
                                    }
                                }
                            } else if (this.T) {
                                D0();
                            }
                        } else if (this.T) {
                            if (vector2.c() < ((float) (R0() / 2))) {
                                E0();
                            } else {
                                D0();
                            }
                        }
                    }
                }
                v0();
                this.W = null;
                this.Z = this.Y;
                this.Y = null;
                this.f32357a0 = null;
                this.X = null;
                this.f32359b0 = null;
                TextView textView = customPlayerControllViewBinding.S;
                Intrinsics.e(textView, "playerTimeText");
                textView.setVisibility(8);
                RelativeLayout relativeLayout = customPlayerControllViewBinding.H;
                Intrinsics.e(relativeLayout, "playerProgressbarLeftHolder");
                relativeLayout.setVisibility(8);
                RelativeLayout relativeLayout2 = customPlayerControllViewBinding.K;
                Intrinsics.e(relativeLayout2, "playerProgressbarRightHolder");
                relativeLayout2.setVisibility(8);
                this.f32361c0 = System.currentTimeMillis();
            } else if (action == 2 && vector22 != null && !this.L) {
                if (this.Y == null) {
                    Vector2 e2 = vector22.e(vector2);
                    if (this.R && Math.abs((e2.d() * ((float) 100)) / ((float) Q0())) > 2.0f) {
                        if (vector22.c() < ((float) (R0() / 2))) {
                            if (this.M) {
                                this.M = false;
                                t0();
                            }
                            touchAction = TouchAction.Brightness;
                        } else {
                            touchAction = TouchAction.Volume;
                        }
                        this.Y = touchAction;
                    }
                    if (this.Q && Math.abs((e2.c() * ((float) 100)) / ((float) Q0())) > 2.0f) {
                        this.Y = TouchAction.Time;
                    }
                }
                Vector2 vector23 = this.X;
                if (vector23 != null) {
                    float d2 = (vector23.e(vector2).d() * 2.0f) / ((float) Q0());
                    TextView textView2 = customPlayerControllViewBinding.S;
                    Intrinsics.e(textView2, "playerTimeText");
                    textView2.setVisibility(8);
                    RelativeLayout relativeLayout3 = customPlayerControllViewBinding.H;
                    Intrinsics.e(relativeLayout3, "playerProgressbarLeftHolder");
                    relativeLayout3.setVisibility(8);
                    RelativeLayout relativeLayout4 = customPlayerControllViewBinding.K;
                    Intrinsics.e(relativeLayout4, "playerProgressbarRightHolder");
                    relativeLayout4.setVisibility(8);
                    TouchAction touchAction2 = this.Y;
                    int i5 = -1;
                    if (touchAction2 == null) {
                        i2 = -1;
                    } else {
                        i2 = WhenMappings.f32400d[touchAction2.ordinal()];
                    }
                    if (i2 == 1) {
                        Long l7 = this.f32357a0;
                        if (l7 != null) {
                            l5 = Long.valueOf((l7.longValue() / 1000) * 1000);
                        } else {
                            l5 = null;
                        }
                        if (!(l5 == null || (A02 = A0(l5, vector22, vector2)) == null)) {
                            long longValue2 = A02.longValue();
                            long longValue3 = longValue2 - l5.longValue();
                            TextView textView3 = customPlayerControllViewBinding.S;
                            StringBuilder sb = new StringBuilder();
                            Companion companion = f32356i0;
                            long j2 = (long) 1000;
                            sb.append(companion.b(longValue2 / j2));
                            sb.append(" [");
                            if (Math.abs(longValue3) < j2) {
                                str = "";
                            } else if (longValue3 > 0) {
                                str = "+";
                            } else {
                                str = "-";
                            }
                            sb.append(str);
                            sb.append(companion.b(Math.abs(longValue3 / j2)));
                            sb.append(']');
                            textView3.setText(sb.toString());
                            Intrinsics.c(textView3);
                            textView3.setVisibility(0);
                        }
                    } else if (i2 == 2) {
                        RelativeLayout relativeLayout5 = customPlayerControllViewBinding.K;
                        Intrinsics.e(relativeLayout5, "playerProgressbarRightHolder");
                        relativeLayout5.setVisibility(0);
                        float f2 = this.f32367f0;
                        float min = Math.min(1.0f, Math.max(d2 + f2, 0.0f));
                        this.f32367f0 = min;
                        if (f2 == min) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (!z2) {
                            s1(min);
                        }
                        customPlayerControllViewBinding.J.setMax(100000);
                        customPlayerControllViewBinding.J.setProgress(Math.max(2000, (int) (this.f32367f0 * 100000.0f)));
                        ImageView imageView = customPlayerControllViewBinding.L;
                        List<Integer> list = this.F;
                        imageView.setImageResource(list.get(Math.min(list.size() - 1, Math.max(0, (int) ((float) Math.rint((double) (this.f32367f0 * ((float) (this.F.size() - 1)))))))).intValue());
                    } else if (i2 == 3) {
                        Object systemService2 = getSystemService(MimeTypes.BASE_TYPE_AUDIO);
                        if (systemService2 instanceof AudioManager) {
                            audioManager2 = (AudioManager) systemService2;
                        } else {
                            audioManager2 = null;
                        }
                        if (audioManager2 != null) {
                            RelativeLayout relativeLayout6 = customPlayerControllViewBinding.H;
                            Intrinsics.e(relativeLayout6, "playerProgressbarLeftHolder");
                            relativeLayout6.setVisibility(0);
                            int streamMaxVolume = audioManager2.getStreamMaxVolume(3);
                            int streamVolume = audioManager2.getStreamVolume(3);
                            this.f32365e0 = Math.min(1.0f, Math.max(this.f32365e0 + d2, 0.0f));
                            customPlayerControllViewBinding.G.setMax(100000);
                            customPlayerControllViewBinding.G.setProgress(Math.max(2000, (int) (this.f32365e0 * 100000.0f)));
                            ImageView imageView2 = customPlayerControllViewBinding.I;
                            List<Integer> list2 = this.G;
                            imageView2.setImageResource(list2.get(Math.min(list2.size() - 1, Math.max(0, (int) ((float) Math.rint((double) (this.f32365e0 * ((float) (this.G.size() - 1)))))))).intValue());
                            int rint = (int) ((float) Math.rint((double) (this.f32365e0 * ((float) streamMaxVolume))));
                            if (rint != streamVolume) {
                                if (rint < streamVolume) {
                                    i3 = 3;
                                } else {
                                    i3 = 3;
                                    i5 = 1;
                                }
                                audioManager2.adjustStreamVolume(i3, i5, 0);
                            }
                        }
                    }
                }
            }
        }
        this.X = vector2;
        return true;
    }

    /* access modifiers changed from: private */
    public static final void Z1(PlayerActivity playerActivity, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(playerActivity, "this$0");
        dialogInterface.dismiss();
        playerActivity.v0();
    }

    /* access modifiers changed from: private */
    public static final void a2(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Window window = alertDialog.getWindow();
        if (window != null) {
            WindowInsetsControllerCompat a2 = WindowCompat.a(window, window.getDecorView());
            Intrinsics.e(a2, "getInsetsController(...)");
            a2.a(WindowInsetsCompat.Type.b());
            a2.b(2);
        }
    }

    private final void b2() {
        List i2 = CollectionsKt__CollectionsKt.i("0.5x", "0.75x", "0.85x", "1x", "1.15x", "1.25x", "1.4x", "1.5x", "1.75x", "2x");
        List i3 = CollectionsKt__CollectionsKt.i(Float.valueOf(0.5f), Float.valueOf(0.75f), Float.valueOf(0.85f), Float.valueOf(1.0f), Float.valueOf(1.15f), Float.valueOf(1.25f), Float.valueOf(1.4f), Float.valueOf(1.5f), Float.valueOf(1.75f), Float.valueOf(2.0f));
        int indexOf = i3.indexOf(Float.valueOf(this.V));
        Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.f40426b = 1.0f;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Playback Speed");
        builder.setSingleChoiceItems((CharSequence[]) i2.toArray(new String[0]), indexOf, new a(ref$FloatRef, i3));
        builder.setPositiveButton("OK", new l(this, ref$FloatRef));
        builder.setNegativeButton("Cancel", new w(this));
        AlertDialog create = builder.create();
        create.setOnShowListener(new g0(create));
        create.show();
    }

    /* access modifiers changed from: private */
    public static final void c2(Ref$FloatRef ref$FloatRef, List list, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(ref$FloatRef, "$selectedSpeed");
        Intrinsics.f(list, "$speedsNumbers");
        ref$FloatRef.f40426b = ((Number) list.get(i2)).floatValue();
    }

    private final void d1(Context context, List<MediaItemSlice> list, List<SingleSampleMediaSource> list2, CacheDataSource.Factory factory) {
        ExoPlayer y02;
        try {
            int i2 = this.f32366f;
            long j2 = this.f32368g;
            float f2 = this.f32378o;
            long j3 = this.f32375l;
            long j4 = this.f32377n;
            try {
                y02 = y0(this, context, list, list2, i2, j2, f2, this.f32380q, j3, j4, true, factory, (TrackSelector) null, (Integer) null, 2048, (Object) null);
            } catch (Throwable th) {
                th = th;
                Timber.f42178a.c(th);
            }
            try {
                this.f32364e = y02;
                PlayerView playerView = this.f32381r;
                if (playerView != null) {
                    playerView.setPlayer(y02);
                }
                ExoPlayer exoPlayer = this.f32364e;
                if (exoPlayer != null) {
                    exoPlayer.prepare();
                }
                ExoPlayer exoPlayer2 = this.f32364e;
                if (exoPlayer2 != null) {
                    exoPlayer2.Y(new PlayerActivity$loadExo$1(this));
                }
            } catch (Throwable th2) {
                th = th2;
                Timber.f42178a.c(th);
            }
        } catch (Throwable th3) {
            th = th3;
            Timber.f42178a.c(th);
        }
    }

    /* access modifiers changed from: private */
    public static final void d2(PlayerActivity playerActivity, Ref$FloatRef ref$FloatRef, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(playerActivity, "this$0");
        Intrinsics.f(ref$FloatRef, "$selectedSpeed");
        float f2 = ref$FloatRef.f40426b;
        playerActivity.V = f2;
        ExoPlayer exoPlayer = playerActivity.f32364e;
        if (exoPlayer != null) {
            exoPlayer.setPlaybackSpeed(f2);
        }
        dialogInterface.dismiss();
        playerActivity.v0();
    }

    private final void e1(Context context, MediaSource mediaSource) {
        String str;
        try {
            this.f32372i = mediaSource;
            if (this.f32362d) {
                SSLContext instance = SSLContext.getInstance("TLS");
                Intrinsics.e(instance, "getInstance(...)");
                instance.init((KeyManager[]) null, (TrustManager[]) new SSLTrustManager[]{new SSLTrustManager()}, new SecureRandom());
                instance.createSSLEngine();
                HttpsURLConnection.setDefaultHostnameVerifier(new t());
                HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
            }
            if (mediaSource.isHLS()) {
                str = "application/x-mpegURL";
            } else {
                str = "application/mp4";
            }
            String streamLink = mediaSource.getStreamLink();
            Intrinsics.e(streamLink, "getStreamLink(...)");
            List b2 = CollectionsKt__CollectionsJVMKt.b(new MediaItemSlice(N0(str, streamLink), Long.MIN_VALUE, (DrmMetadata) null, 4, (DefaultConstructorMarker) null));
            HttpDataSource$Factory C0 = C0(mediaSource);
            DataSource.Factory B0 = B0(context);
            if (this.f32360c == null) {
                this.f32360c = I0(context, this.f32376m);
            }
            CacheDataSource.Factory factory = new CacheDataSource.Factory();
            SimpleCache simpleCache = this.f32360c;
            if (simpleCache != null) {
                factory.e(simpleCache);
            }
            factory.f(C0);
            Pair<List<SingleSampleMediaSource>, List<SubtitleData>> S0 = S0(C0, B0, this.B);
            this.B.l(CollectionsKt___CollectionsKt.d0(S0.b()));
            d1(context, b2, S0.a(), factory);
        } catch (Throwable th) {
            Timber.f42178a.c(th);
        }
    }

    /* access modifiers changed from: private */
    public static final void e2(PlayerActivity playerActivity, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(playerActivity, "this$0");
        dialogInterface.dismiss();
        playerActivity.v0();
    }

    /* access modifiers changed from: private */
    public static final boolean f1(String str, SSLSession sSLSession) {
        Intrinsics.f(str, "<anonymous parameter 0>");
        Intrinsics.f(sSLSession, "<anonymous parameter 1>");
        return true;
    }

    /* access modifiers changed from: private */
    public static final void f2(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Window window = alertDialog.getWindow();
        if (window != null) {
            WindowInsetsControllerCompat a2 = WindowCompat.a(window, window.getDecorView());
            Intrinsics.e(a2, "getInsetsController(...)");
            a2.a(WindowInsetsCompat.Type.b());
            a2.b(2);
        }
    }

    private final void h1() {
        ImageButton imageButton;
        FrameLayout frameLayout;
        boolean z2 = !this.M;
        this.M = z2;
        if (z2) {
            CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
            if (customPlayerControllViewBinding != null) {
                frameLayout = customPlayerControllViewBinding.f38137z;
            } else {
                frameLayout = null;
            }
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
            v0();
        }
        a1(this);
        t0();
        CustomPlayerControllViewBinding customPlayerControllViewBinding2 = this.A;
        if (customPlayerControllViewBinding2 != null && (imageButton = customPlayerControllViewBinding2.f38120i) != null) {
            imageButton.requestFocus();
        }
    }

    /* access modifiers changed from: private */
    public static final void h2(Ref$IntRef ref$IntRef, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(ref$IntRef, "$selectedSourceIndex");
        ref$IntRef.f40427b = i2;
    }

    /* access modifiers changed from: private */
    public final void i1() {
        Format format;
        Integer num;
        ExoPlayer exoPlayer = this.f32364e;
        Integer num2 = null;
        if (exoPlayer != null) {
            format = exoPlayer.a();
        } else {
            format = null;
        }
        if (format != null) {
            num = Integer.valueOf(format.f4021t);
        } else {
            num = null;
        }
        if (format != null) {
            num2 = Integer.valueOf(format.f4022u);
        }
        if (num2 != null && num != null) {
            V0(new ResizedEvent(num2.intValue(), num.intValue(), (PlayerEventSource) null, 4, (DefaultConstructorMarker) null));
            x2();
        }
    }

    /* access modifiers changed from: private */
    public static final void i2(Ref$IntRef ref$IntRef, PlayerActivity playerActivity, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(ref$IntRef, "$selectedSourceIndex");
        Intrinsics.f(playerActivity, "this$0");
        int i3 = ref$IntRef.f40427b;
        if (i3 - 1 >= 0) {
            playerActivity.f32385v = i3 - 1;
            SubtitleData subtitleData = (SubtitleData) CollectionsKt___CollectionsKt.E(CollectionsKt___CollectionsKt.a0(playerActivity.B.c()), playerActivity.f32385v);
            if (subtitleData != null) {
                playerActivity.y1(subtitleData);
            }
        } else {
            playerActivity.y1((SubtitleData) null);
        }
        dialogInterface.dismiss();
        playerActivity.v0();
    }

    private final void j1(int i2, int i3) {
    }

    /* access modifiers changed from: private */
    public static final void j2(PlayerActivity playerActivity, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(playerActivity, "this$0");
        dialogInterface.dismiss();
        playerActivity.v0();
    }

    /* access modifiers changed from: private */
    public static final void k2(AlertDialog alertDialog, DialogInterface dialogInterface) {
        Window window = alertDialog.getWindow();
        if (window != null) {
            WindowInsetsControllerCompat a2 = WindowCompat.a(window, window.getDecorView());
            Intrinsics.e(a2, "getInsetsController(...)");
            a2.a(WindowInsetsCompat.Type.b());
            a2.b(2);
        }
    }

    private final void l1(Throwable th) {
        r1();
        if (th instanceof PlaybackException) {
            String message = th.getMessage();
            if (message == null) {
                message = "";
            }
            PlaybackException playbackException = (PlaybackException) th;
            String a2 = playbackException.a();
            Intrinsics.e(a2, "getErrorCodeName(...)");
            int i2 = playbackException.f4300b;
            if (!(i2 == 17 || i2 == 19)) {
                if (!(i2 == 1001 || i2 == 1003)) {
                    if (!(i2 == 3003 || i2 == 2000)) {
                        if (i2 != 2001) {
                            if (!(i2 == 5001 || i2 == 5002)) {
                                switch (i2) {
                                    case 2003:
                                    case 2004:
                                        break;
                                    case 2005:
                                    case 2006:
                                        break;
                                    default:
                                        switch (i2) {
                                            case 4001:
                                            case 4002:
                                            case 4003:
                                                break;
                                            default:
                                                m1(this, a2 + " (" + i2 + ")\n" + message, false);
                                                return;
                                        }
                                }
                            }
                        }
                    }
                    m1(this, a2 + " (" + i2 + ")\n" + message, true);
                    return;
                }
                m1(this, a2 + " (" + i2 + ")\n" + message, true);
                return;
            }
            m1(this, a2 + " (" + i2 + ")\n" + message, true);
        } else if (th instanceof InvalidFileException) {
            m1(this, String.valueOf(th.getMessage()), true);
        } else {
            String message2 = th.getMessage();
            if (message2 != null) {
                m1(this, message2, false);
            }
        }
    }

    private static final void m1(PlayerActivity playerActivity, String str, boolean z2) {
        playerActivity.l2(str, 1);
        if (z2 && playerActivity.f32382s.size() == 1) {
            playerActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void m2(PlayerActivity playerActivity, String str, Integer num) {
        int i2;
        Intrinsics.f(playerActivity, "this$0");
        if (num != null) {
            i2 = num.intValue();
        } else {
            i2 = 0;
        }
        Toast.makeText(playerActivity, str, i2).show();
    }

    private final void n1(boolean z2) {
        ExoPlayer exoPlayer = this.f32364e;
        if (exoPlayer != null) {
            exoPlayer.l(true);
            exoPlayer.stop();
            exoPlayer.release();
        }
        this.f32374k = null;
        this.f32364e = null;
    }

    private final AudioTrack n2(Format format) {
        return new AudioTrack(format.f4002a, format.f4003b, format.f4005d);
    }

    static /* synthetic */ void o1(PlayerActivity playerActivity, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = true;
        }
        playerActivity.n1(z2);
    }

    private final VideoTrack o2(Format format) {
        return new VideoTrack(format.f4002a, format.f4003b, format.f4005d, Integer.valueOf(format.f4021t), Integer.valueOf(format.f4022u));
    }

    private final void p2() {
        float f2;
        CustomPlayerControllViewBinding customPlayerControllViewBinding;
        FrameLayout frameLayout;
        if (this.L && this.M && (customPlayerControllViewBinding = this.A) != null && (frameLayout = customPlayerControllViewBinding.f38136y) != null) {
            frameLayout.postDelayed(new l0(this), 200);
        }
        if (this.L) {
            f2 = 0.0f;
        } else {
            f2 = 1.0f;
        }
        CustomPlayerControllViewBinding customPlayerControllViewBinding2 = this.A;
        if (customPlayerControllViewBinding2 != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(customPlayerControllViewBinding2.T.getAlpha(), f2);
            alphaAnimation.setDuration(100);
            alphaAnimation.setFillAfter(true);
            w2();
            customPlayerControllViewBinding2.f38120i.startAnimation(alphaAnimation);
            customPlayerControllViewBinding2.f38132u.startAnimation(alphaAnimation);
            customPlayerControllViewBinding2.N.startAnimation(alphaAnimation);
            customPlayerControllViewBinding2.C.startAnimation(alphaAnimation);
            customPlayerControllViewBinding2.T.startAnimation(alphaAnimation);
            customPlayerControllViewBinding2.U.startAnimation(alphaAnimation);
            customPlayerControllViewBinding2.B.startAnimation(alphaAnimation);
            View view = customPlayerControllViewBinding2.Y;
            Intrinsics.e(view, "shadowOverlay");
            view.setVisibility(0);
            customPlayerControllViewBinding2.Y.startAnimation(alphaAnimation);
        }
        v2();
    }

    /* access modifiers changed from: private */
    public static final void q2(PlayerActivity playerActivity) {
        Intrinsics.f(playerActivity, "this$0");
        if (playerActivity.L && playerActivity.M) {
            playerActivity.h1();
        }
    }

    private final void r2() {
        int i2;
        int i3 = getResources().getConfiguration().orientation;
        if (i3 == 1) {
            i2 = 6;
        } else if (i3 != 2) {
            i2 = 0;
        } else {
            i2 = 7;
        }
        setRequestedOrientation(i2);
    }

    private final void s1(float f2) {
        WindowManager.LayoutParams layoutParams;
        if (this.f32369g0) {
            try {
                Settings.System.putInt(getContentResolver(), "screen_brightness_mode", 0);
                Settings.System.putInt(getContentResolver(), "screen_brightness", (int) (((float) JfifUtil.MARKER_FIRST_BYTE) * f2));
            } catch (Exception unused) {
                this.f32369g0 = false;
                s1(f2);
            }
        } else {
            try {
                Window window = getWindow();
                if (window != null) {
                    layoutParams = window.getAttributes();
                } else {
                    layoutParams = null;
                }
                if (layoutParams != null) {
                    layoutParams.screenBrightness = f2;
                }
                Window window2 = getWindow();
                if (window2 != null) {
                    window2.setAttributes(layoutParams);
                }
            } catch (Exception e2) {
                Timber.f42178a.c(e2);
            }
        }
    }

    @SuppressLint({"SourceLockedOrientationActivity"})
    private final void s2() {
        r2();
    }

    private final void t2() {
        FrameLayout frameLayout;
        if (this.T || this.U) {
            int i2 = this.f32371h0;
            CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
            if (customPlayerControllViewBinding != null && (frameLayout = customPlayerControllViewBinding.f38136y) != null) {
                frameLayout.postDelayed(new x(i2, this), 200);
                return;
            }
            return;
        }
        h1();
    }

    /* access modifiers changed from: private */
    public static final void u0(PlayerActivity playerActivity) {
        Intrinsics.f(playerActivity, "this$0");
        playerActivity.w2();
    }

    /* access modifiers changed from: private */
    public static final void u2(int i2, PlayerActivity playerActivity) {
        Intrinsics.f(playerActivity, "this$0");
        if (i2 == playerActivity.f32371h0) {
            playerActivity.h1();
        }
    }

    private static final Pair<TrackGroup, Integer> v1(PlayerActivity playerActivity, String str) {
        Tracks m2;
        ImmutableList<Tracks.Group> a2;
        boolean z2;
        ExoPlayer exoPlayer = playerActivity.f32364e;
        if (exoPlayer == null || (m2 = exoPlayer.m()) == null || (a2 = m2.a()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : a2) {
            if (((Tracks.Group) next).c() == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        return playerActivity.T0(arrayList, str);
    }

    private final void v2() {
    }

    /* access modifiers changed from: private */
    public static final void w0(PlayerActivity playerActivity, int i2) {
        Intrinsics.f(playerActivity, "this$0");
        if (playerActivity.M && i2 == playerActivity.D) {
            ExoPlayer exoPlayer = playerActivity.f32364e;
            boolean z2 = false;
            if (exoPlayer != null && exoPlayer.isPlaying()) {
                z2 = true;
            }
            if (z2) {
                playerActivity.h1();
            }
        }
    }

    private final void w1() {
        Integer num;
        CustomPlayerControllViewBinding customPlayerControllViewBinding;
        ImageButton imageButton;
        ImageButton imageButton2;
        ImageButton imageButton3;
        PlayerView playerView = this.f32381r;
        if (playerView != null) {
            num = Integer.valueOf(playerView.getResizeMode());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            CustomPlayerControllViewBinding customPlayerControllViewBinding2 = this.A;
            if (customPlayerControllViewBinding2 != null && (imageButton3 = customPlayerControllViewBinding2.M) != null) {
                imageButton3.setImageResource(R.drawable.ic_baseline_resize_fit_24);
            }
        } else if (num != null && num.intValue() == 3) {
            CustomPlayerControllViewBinding customPlayerControllViewBinding3 = this.A;
            if (customPlayerControllViewBinding3 != null && (imageButton2 = customPlayerControllViewBinding3.M) != null) {
                imageButton2.setImageResource(R.drawable.ic_baseline_resize_stretch_24);
            }
        } else if (num != null && num.intValue() == 4 && (customPlayerControllViewBinding = this.A) != null && (imageButton = customPlayerControllViewBinding.M) != null) {
            imageButton.setImageResource(R.drawable.ic_baseline_resize_zoom_24);
        }
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    private final ExoPlayer x0(Context context, List<MediaItemSlice> list, List<SingleSampleMediaSource> list2, int i2, long j2, float f2, long j3, long j4, long j5, boolean z2, CacheDataSource.Factory factory, TrackSelector trackSelector, Integer num) {
        DefaultMediaSourceFactory defaultMediaSourceFactory;
        androidx.media3.exoplayer.source.MediaSource mediaSource;
        Context context2 = context;
        long j6 = j2;
        long j7 = j4;
        long j8 = j5;
        CacheDataSource.Factory factory2 = factory;
        ExoPlayer.Builder p2 = new ExoPlayer.Builder(context2).q(new v(context2, this)).s(trackSelector == null ? U0(context2, num) : trackSelector).r(new SeekParameters(300000, 300000)).p(new DefaultLoadControl.Builder().d(j7 <= 0 ? -1 : j7 > 2147483647L ? Integer.MAX_VALUE : (int) j7).b(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT, true).c(50000, j8 <= 0 ? 50000 : (int) j8, 2500, 5000).a());
        Intrinsics.e(p2, "setLoadControl(...)");
        if (factory2 == null) {
            defaultMediaSourceFactory = new DefaultMediaSourceFactory(context2);
        } else {
            defaultMediaSourceFactory = new DefaultMediaSourceFactory((DataSource.Factory) factory2);
        }
        if (list.size() == 1) {
            MediaItemSlice mediaItemSlice = (MediaItemSlice) CollectionsKt___CollectionsKt.C(list);
            mediaItemSlice.a();
            mediaSource = defaultMediaSourceFactory.c(mediaItemSlice.c());
        } else {
            ConcatenatingMediaSource concatenatingMediaSource = new ConcatenatingMediaSource(new androidx.media3.exoplayer.source.MediaSource[0]);
            Iterable<MediaItemSlice> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
            for (MediaItemSlice mediaItemSlice2 : iterable) {
                concatenatingMediaSource.P(new ClippingMediaSource(defaultMediaSourceFactory.c(mediaItemSlice2.c()), mediaItemSlice2.b()));
                arrayList.add(Unit.f40298a);
            }
            mediaSource = concatenatingMediaSource;
        }
        Intrinsics.c(mediaSource);
        ExoPlayer h2 = p2.h();
        Intrinsics.e(h2, "build(...)");
        h2.l(z2);
        h2.y(i2, j6);
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.a(mediaSource);
        spreadBuilder.b(list2.toArray(new SingleSampleMediaSource[0]));
        h2.d(new MergingMediaSource((androidx.media3.exoplayer.source.MediaSource[]) spreadBuilder.d(new androidx.media3.exoplayer.source.MediaSource[spreadBuilder.c()])), j6);
        h2.X(true);
        h2.setPlaybackSpeed(f2);
        return h2;
    }

    private final void x1(boolean z2) {
        TextView textView;
        int i2;
        CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
        TextView textView2 = null;
        if (customPlayerControllViewBinding != null) {
            textView = customPlayerControllViewBinding.f38114c;
        } else {
            textView = null;
        }
        int i3 = 0;
        if (textView != null) {
            if (z2) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            textView.setVisibility(i2);
        }
        CustomPlayerControllViewBinding customPlayerControllViewBinding2 = this.A;
        if (customPlayerControllViewBinding2 != null) {
            textView2 = customPlayerControllViewBinding2.f38112a0;
        }
        if (textView2 != null) {
            if (!z2) {
                i3 = 8;
            }
            textView2.setVisibility(i3);
        }
    }

    private final void x2() {
    }

    static /* synthetic */ ExoPlayer y0(PlayerActivity playerActivity, Context context, List list, List list2, int i2, long j2, float f2, long j3, long j4, long j5, boolean z2, CacheDataSource.Factory factory, TrackSelector trackSelector, Integer num, int i3, Object obj) {
        int i4 = i3;
        return playerActivity.x0(context, list, list2, i2, j2, f2, j3, j4, j5, (i4 & 512) != 0 ? true : z2, (i4 & 1024) != 0 ? null : factory, (i4 & 2048) != 0 ? null : trackSelector, (i4 & CodedOutputStream.DEFAULT_BUFFER_SIZE) != 0 ? null : num);
    }

    private final boolean y1(SubtitleData subtitleData) {
        Object obj;
        if (!(Intrinsics.a(subtitleData, this.f32370h) || subtitleData == null || subtitleData.c() == null)) {
            String obj2 = StringsKt__StringsKt.N0(new Regex("\\d").h(subtitleData.c(), "")).toString();
            Iterator it2 = this.B.g().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                SubtitleHelper.Language639 language639 = (SubtitleHelper.Language639) obj;
                boolean z2 = true;
                if (!StringsKt__StringsJVMKt.t(language639.b(), obj2, true) && !Intrinsics.a(language639.a(), subtitleData.c())) {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            SubtitleHelper.Language639 language6392 = (SubtitleHelper.Language639) obj;
            if (language6392 != null) {
                language6392.a();
            }
        }
        return u1(subtitleData);
    }

    /* access modifiers changed from: private */
    public static final Renderer[] z0(Context context, PlayerActivity playerActivity, Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        TextRenderer textRenderer;
        Intrinsics.f(context, "$context");
        Intrinsics.f(playerActivity, "this$0");
        Intrinsics.f(handler, "eventHandler");
        Intrinsics.f(videoRendererEventListener, "videoRendererEventListener");
        Intrinsics.f(audioRendererEventListener, "audioRendererEventListener");
        Intrinsics.f(textOutput, "textRendererOutput");
        Intrinsics.f(metadataOutput, "metadataRendererOutput");
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(context);
        defaultRenderersFactory.k(true);
        defaultRenderersFactory.l(1);
        Renderer[] a2 = defaultRenderersFactory.a(handler, videoRendererEventListener, audioRendererEventListener, textOutput, metadataOutput);
        Intrinsics.e(a2, "createRenderers(...)");
        ArrayList arrayList = new ArrayList(a2.length);
        for (Renderer renderer : a2) {
            if (renderer instanceof TextRenderer) {
                TextRenderer textRenderer2 = new TextRenderer(textOutput, handler.getLooper(), new CustomSubtitleDecoderFactory(new PlayerActivity$buildExoPlayer$exoPlayerBuilder$1$2$currentTextRenderer$1(playerActivity)));
                playerActivity.f32374k = textRenderer2;
                textRenderer2.e0(true);
                textRenderer = textRenderer2;
            } else {
                textRenderer = renderer;
            }
            arrayList.add(textRenderer);
        }
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void z1() {
        CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
        if (customPlayerControllViewBinding != null) {
            customPlayerControllViewBinding.f38120i.setOnClickListener(new b(this));
            customPlayerControllViewBinding.f38114c.setOnClickListener(new h(this));
            customPlayerControllViewBinding.f38112a0.setOnClickListener(new i(this));
            customPlayerControllViewBinding.O.setOnClickListener(new j(this));
            customPlayerControllViewBinding.M.setOnClickListener(new k(this));
            customPlayerControllViewBinding.Q.setOnClickListener(new m(this));
            customPlayerControllViewBinding.A.setOnClickListener(new n(this));
            customPlayerControllViewBinding.R.setOnClickListener(new o(this));
            customPlayerControllViewBinding.f38129r.setOnClickListener(new p(this));
            customPlayerControllViewBinding.f38125n.setImageResource(R.drawable.forward);
            customPlayerControllViewBinding.f38125n.setScaleX(-1.0f);
            long j2 = (long) 1000;
            customPlayerControllViewBinding.f38126o.setText(String.valueOf(this.N / j2));
            customPlayerControllViewBinding.f38125n.setOnClickListener(new q(this));
            customPlayerControllViewBinding.f38115d.setImageResource(R.drawable.forward);
            customPlayerControllViewBinding.f38115d.setScaleX(1.0f);
            customPlayerControllViewBinding.f38116e.setText(String.valueOf(this.N / j2));
            customPlayerControllViewBinding.f38115d.setOnClickListener(new c(this));
            customPlayerControllViewBinding.f38134w.setOnClickListener(new d(this));
            customPlayerControllViewBinding.P.setOnClickListener(new e(this));
            customPlayerControllViewBinding.f38136y.setOnTouchListener(new f(this));
            customPlayerControllViewBinding.f38123l.setOnTouchListener(new g(this));
        }
        w2();
    }

    /* access modifiers changed from: protected */
    public final void F0() {
        WindowManager.LayoutParams layoutParams;
        a1(this);
        if (Build.VERSION.SDK_INT >= 28) {
            Window window = getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.layoutInDisplayCutoutMode = 1;
            }
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(layoutParams);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void G0() {
        WindowManager.LayoutParams layoutParams;
        setRequestedOrientation(2);
        Window window = getWindow();
        if (window != null) {
            layoutParams = window.getAttributes();
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            layoutParams.screenBrightness = -1.0f;
        }
        if (Build.VERSION.SDK_INT >= 28 && layoutParams != null) {
            layoutParams.layoutInDisplayCutoutMode = 0;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setAttributes(layoutParams);
        }
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    public final CurrentTracks J0() {
        List list;
        VideoTrack videoTrack;
        Format Z2;
        Format a2;
        boolean z2;
        Tracks m2;
        ExoPlayer exoPlayer = this.f32364e;
        AudioTrack audioTrack = null;
        if (exoPlayer == null || (m2 = exoPlayer.m()) == null) {
            list = null;
        } else {
            list = m2.a();
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.f();
        }
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = iterable.iterator();
        while (true) {
            boolean z3 = false;
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            if (((Tracks.Group) next).c() == 2) {
                z3 = true;
            }
            if (z3) {
                arrayList.add(next);
            }
        }
        Iterable<Pair> L0 = L0(arrayList);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.p(L0, 10));
        for (Pair c2 : L0) {
            arrayList2.add(o2((Format) c2.c()));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : iterable) {
            if (((Tracks.Group) next2).c() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                arrayList3.add(next2);
            }
        }
        Iterable<Pair> L02 = L0(arrayList3);
        ArrayList arrayList4 = new ArrayList(CollectionsKt__IterablesKt.p(L02, 10));
        for (Pair c3 : L02) {
            arrayList4.add(n2((Format) c3.c()));
        }
        ExoPlayer exoPlayer2 = this.f32364e;
        if (exoPlayer2 == null || (a2 = exoPlayer2.a()) == null) {
            videoTrack = null;
        } else {
            videoTrack = o2(a2);
        }
        ExoPlayer exoPlayer3 = this.f32364e;
        if (!(exoPlayer3 == null || (Z2 = exoPlayer3.Z()) == null)) {
            audioTrack = n2(Z2);
        }
        return new CurrentTracks(videoTrack, audioTrack, arrayList2, arrayList4);
    }

    /* access modifiers changed from: protected */
    public int M0() {
        return this.f32388y;
    }

    /* access modifiers changed from: protected */
    public final CustomPlayerControllViewBinding P0() {
        return this.A;
    }

    public final void P1() {
        try {
            Iterable<AudioTrack> a2 = J0().a();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(a2, 10));
            for (AudioTrack b2 : a2) {
                arrayList.add(b2.b());
            }
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select Audio Track");
            builder.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), this.f32386w, new y(ref$IntRef));
            builder.setPositiveButton("OK", new z(this, ref$IntRef));
            builder.setNegativeButton("Cancel", new a0(this));
            AlertDialog create = builder.create();
            create.setOnShowListener(new b0(create));
            create.show();
        } catch (Exception e2) {
            Timber.f42178a.c(e2);
        }
    }

    public final int Q0() {
        DisplayMetrics displayMetrics = this.f32373j;
        return Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public final int R0() {
        DisplayMetrics displayMetrics = this.f32373j;
        return Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public final void U1(Context context, Function0<Unit> function0) {
        Intrinsics.f(context, "context");
        Intrinsics.f(function0, "onExitConfirmed");
        new AlertDialog.Builder(context).setTitle("Confirm Exit").setMessage("Are you sure you want to exit?").setPositiveButton("Exit", new m0(function0)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.movie.ui.activity.player.utils.SubtitleData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.movie.ui.activity.player.utils.SubtitleData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.movie.ui.activity.player.utils.SubtitleData} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: com.movie.ui.activity.player.utils.SubtitleData} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void V0(com.movie.ui.activity.player.event.PlayerEvent r10) {
        /*
            r9 = this;
            java.lang.String r0 = "event"
            kotlin.jvm.internal.Intrinsics.f(r10, r0)
            boolean r0 = r10 instanceof com.movie.ui.activity.player.event.ErrorEvent
            if (r0 == 0) goto L_0x0014
            com.movie.ui.activity.player.event.ErrorEvent r10 = (com.movie.ui.activity.player.event.ErrorEvent) r10
            java.lang.Throwable r10 = r10.a()
            r9.l1(r10)
            goto L_0x00e8
        L_0x0014:
            boolean r0 = r10 instanceof com.movie.ui.activity.player.event.ResizedEvent
            if (r0 == 0) goto L_0x0027
            com.movie.ui.activity.player.event.ResizedEvent r10 = (com.movie.ui.activity.player.event.ResizedEvent) r10
            int r0 = r10.b()
            int r10 = r10.a()
            r9.j1(r0, r10)
            goto L_0x00e8
        L_0x0027:
            boolean r0 = r10 instanceof com.movie.ui.activity.player.event.StatusEvent
            if (r0 != 0) goto L_0x00e8
            boolean r0 = r10 instanceof com.movie.ui.activity.player.event.TracksChangedEvent
            if (r0 == 0) goto L_0x0034
            r9.k1()
            goto L_0x00e8
        L_0x0034:
            boolean r0 = r10 instanceof com.movie.ui.activity.player.event.EmbeddedSubtitlesFetchedEvent
            if (r0 == 0) goto L_0x00e8
            com.movie.ui.activity.player.event.EmbeddedSubtitlesFetchedEvent r10 = (com.movie.ui.activity.player.event.EmbeddedSubtitlesFetchedEvent) r10
            java.util.List r0 = r10.a()
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x00e8
            com.movie.ui.activity.player.utils.SubtitleHelper r0 = r9.B
            java.util.List r10 = r10.a()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Set r10 = kotlin.collections.CollectionsKt___CollectionsKt.d0(r10)
            r0.l(r10)
            com.yoku.marumovie.databinding.CustomPlayerControllViewBinding r10 = r9.A
            r0 = 0
            if (r10 == 0) goto L_0x005b
            android.widget.ImageButton r10 = r10.R
            goto L_0x005c
        L_0x005b:
            r10 = r0
        L_0x005c:
            r1 = 0
            if (r10 != 0) goto L_0x0060
            goto L_0x0063
        L_0x0060:
            r10.setVisibility(r1)
        L_0x0063:
            boolean r10 = r9.f32387x
            if (r10 == 0) goto L_0x00e8
            com.movie.ui.activity.player.utils.SubtitleHelper r10 = r9.B
            java.util.Set r10 = r10.c()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0073:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00d3
            java.lang.Object r2 = r10.next()
            r3 = r2
            com.movie.ui.activity.player.utils.SubtitleData r3 = (com.movie.ui.activity.player.utils.SubtitleData) r3
            android.content.SharedPreferences r4 = com.movie.FreeMoviesApp.p()
            java.util.HashSet r5 = new java.util.HashSet
            r6 = 1
            java.lang.String[] r7 = new java.lang.String[r6]
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r8 = r8.getLanguage()
            r7[r1] = r8
            java.util.List r7 = java.util.Arrays.asList(r7)
            java.util.Collection r7 = (java.util.Collection) r7
            r5.<init>(r7)
            java.lang.String r7 = "pref_sub_language_international_v3"
            java.util.Set r4 = r4.getStringSet(r7, r5)
            if (r4 == 0) goto L_0x00b1
            java.lang.String r5 = r3.c()
            boolean r4 = r4.contains(r5)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x00b2
        L_0x00b1:
            r4 = r0
        L_0x00b2:
            java.lang.String r3 = r3.b()
            com.movie.ui.activity.player.utils.SubtitleData r5 = r9.f32370h
            if (r5 == 0) goto L_0x00bf
            java.lang.String r5 = r5.b()
            goto L_0x00c0
        L_0x00bf:
            r5 = r0
        L_0x00c0:
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r3, r5)
            if (r3 != 0) goto L_0x00d0
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r3 = kotlin.jvm.internal.Intrinsics.a(r4, r3)
            if (r3 == 0) goto L_0x00cf
            goto L_0x00d0
        L_0x00cf:
            r6 = 0
        L_0x00d0:
            if (r6 == 0) goto L_0x0073
            r0 = r2
        L_0x00d3:
            com.movie.ui.activity.player.utils.SubtitleData r0 = (com.movie.ui.activity.player.utils.SubtitleData) r0
            r9.y1(r0)
            com.movie.ui.activity.player.utils.SubtitleHelper r10 = r9.B
            java.util.Set r10 = r10.c()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            int r10 = kotlin.collections.CollectionsKt___CollectionsKt.F(r10, r0)
            r9.f32385v = r10
            r9.f32387x = r1
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.PlayerActivity.V0(com.movie.ui.activity.player.event.PlayerEvent):void");
    }

    public final void W0(PlayerEventType playerEventType) {
        Intrinsics.f(playerEventType, "event");
        switch (WhenMappings.f32401e[playerEventType.ordinal()]) {
            case 1:
                p2();
                return;
            case 2:
                ExoPlayer exoPlayer = this.f32364e;
                if (exoPlayer != null) {
                    exoPlayer.pause();
                    return;
                }
                return;
            case 3:
                ExoPlayer exoPlayer2 = this.f32364e;
                if (exoPlayer2 == null) {
                    return;
                }
                if (exoPlayer2.isPlaying()) {
                    exoPlayer2.pause();
                    return;
                } else {
                    exoPlayer2.play();
                    return;
                }
            case 4:
                ExoPlayer exoPlayer3 = this.f32364e;
                if (exoPlayer3 != null) {
                    exoPlayer3.play();
                    return;
                }
                return;
            case 5:
                g1();
                w1();
                return;
            case 6:
                ExoPlayer exoPlayer4 = this.f32364e;
                if (exoPlayer4 != null) {
                    exoPlayer4.seekTo(exoPlayer4.getCurrentPosition() + this.N);
                    return;
                }
                return;
            case 7:
                b2();
                return;
            case 8:
                ExoPlayer exoPlayer5 = this.f32364e;
                if (exoPlayer5 != null) {
                    exoPlayer5.seekTo(exoPlayer5.getCurrentPosition() - this.N);
                    return;
                }
                return;
            case 10:
                h1();
                return;
            case 11:
                W1();
                return;
            default:
                return;
        }
    }

    public final void W1() {
        try {
            r1();
            Iterable<MediaSource> iterable = this.f32382s;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
            for (MediaSource mediaSource : iterable) {
                arrayList.add(mediaSource.toString());
            }
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select Media Source");
            builder.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new String[0]), this.f32383t, new h0(ref$IntRef));
            builder.setPositiveButton("OK", new i0(this, ref$IntRef));
            builder.setNegativeButton("Cancel", new j0(this));
            AlertDialog create = builder.create();
            create.setOnShowListener(new k0(create));
            create.show();
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: com.original.tase.model.media.MediaSource} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void X0() {
        /*
            r15 = this;
            android.content.Intent r0 = r15.getIntent()
            android.os.Bundle r0 = r0.getExtras()
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            java.lang.String r1 = "mediasources"
            android.os.Parcelable[] r1 = r0.getParcelableArray(r1)
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x002a
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r5 = r1.length
            r6 = 0
        L_0x001c:
            if (r6 >= r5) goto L_0x002b
            r7 = r1[r6]
            boolean r8 = r7 instanceof com.original.tase.model.media.MediaSource
            if (r8 == 0) goto L_0x0027
            r4.add(r7)
        L_0x0027:
            int r6 = r6 + 1
            goto L_0x001c
        L_0x002a:
            r4 = r3
        L_0x002b:
            java.lang.String r1 = "subtitles"
            android.os.Parcelable[] r1 = r0.getParcelableArray(r1)
            if (r1 == 0) goto L_0x009c
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r6 = r1.length
            r7 = 0
        L_0x003a:
            if (r7 >= r6) goto L_0x0048
            r8 = r1[r7]
            boolean r9 = r8 instanceof com.utils.subtitle.SubtitleInfo
            if (r9 == 0) goto L_0x0045
            r5.add(r8)
        L_0x0045:
            int r7 = r7 + 1
            goto L_0x003a
        L_0x0048:
            java.util.ArrayList r1 = new java.util.ArrayList
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.p(r5, r6)
            r1.<init>(r6)
            java.util.Iterator r5 = r5.iterator()
        L_0x0057:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x009d
            java.lang.Object r6 = r5.next()
            com.utils.subtitle.SubtitleInfo r6 = (com.utils.subtitle.SubtitleInfo) r6
            com.movie.ui.activity.player.utils.SubtitleData r14 = new com.movie.ui.activity.player.utils.SubtitleData
            java.lang.String r8 = r6.f37702b
            java.lang.String r7 = "name"
            kotlin.jvm.internal.Intrinsics.e(r8, r7)
            java.lang.String r9 = r6.f37703c
            java.lang.String r7 = "dataLink"
            kotlin.jvm.internal.Intrinsics.e(r9, r7)
            com.movie.ui.activity.player.utils.SubtitleHelper r10 = r15.B
            java.lang.String r11 = r6.f37703c
            kotlin.jvm.internal.Intrinsics.e(r11, r7)
            boolean r7 = r10.k(r11)
            if (r7 == 0) goto L_0x0083
            com.movie.ui.activity.player.utils.SubtitleOrigin r7 = com.movie.ui.activity.player.utils.SubtitleOrigin.DOWNLOADED_FILE
            goto L_0x0085
        L_0x0083:
            com.movie.ui.activity.player.utils.SubtitleOrigin r7 = com.movie.ui.activity.player.utils.SubtitleOrigin.URL
        L_0x0085:
            r10 = r7
            java.lang.String r11 = "application/x-subrip"
            java.util.Map r12 = kotlin.collections.MapsKt__MapsKt.g()
            com.movie.ui.activity.player.utils.SubtitleHelper r7 = r15.B
            java.lang.String r6 = r6.f37704d
            java.lang.String r13 = r7.p(r6)
            r7 = r14
            r7.<init>(r8, r9, r10, r11, r12, r13)
            r1.add(r14)
            goto L_0x0057
        L_0x009c:
            r1 = r3
        L_0x009d:
            java.lang.String r5 = "title"
            java.lang.String r5 = r0.getString(r5)
            com.yoku.marumovie.databinding.CustomPlayerControllViewBinding r6 = r15.A
            if (r6 == 0) goto L_0x00aa
            android.widget.TextView r6 = r6.D
            goto L_0x00ab
        L_0x00aa:
            r6 = r3
        L_0x00ab:
            if (r6 != 0) goto L_0x00ae
            goto L_0x00b1
        L_0x00ae:
            r6.setText(r5)
        L_0x00b1:
            java.lang.String r5 = "position"
            long r5 = r0.getLong(r5)
            java.lang.String r7 = "subtitle_start_index"
            r0.getInt(r7)
            java.lang.String r7 = "mediasources_start_index"
            int r0 = r0.getInt(r7)
            if (r4 == 0) goto L_0x00c9
            java.util.List<com.original.tase.model.media.MediaSource> r7 = r15.f32382s
            r7.addAll(r4)
        L_0x00c9:
            if (r1 == 0) goto L_0x00e2
            java.util.List<com.movie.ui.activity.player.utils.SubtitleData> r7 = r15.f32384u
            r7.clear()
            java.util.List<com.movie.ui.activity.player.utils.SubtitleData> r7 = r15.f32384u
            r7.addAll(r1)
            com.movie.ui.activity.player.utils.SubtitleHelper r1 = r15.B
            java.util.List<com.movie.ui.activity.player.utils.SubtitleData> r7 = r15.f32384u
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Set r7 = kotlin.collections.CollectionsKt___CollectionsKt.d0(r7)
            r1.m(r7)
        L_0x00e2:
            java.util.List<com.movie.ui.activity.player.utils.SubtitleData> r1 = r15.f32384u
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x00eb
            r2 = 1
        L_0x00eb:
            r15.f32387x = r2
            if (r4 == 0) goto L_0x00f6
            java.lang.Object r0 = r4.get(r0)
            r3 = r0
            com.original.tase.model.media.MediaSource r3 = (com.original.tase.model.media.MediaSource) r3
        L_0x00f6:
            java.lang.Long r0 = java.lang.Long.valueOf(r5)
            r15.b1(r15, r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.player.PlayerActivity.X0():void");
    }

    public final void a1(Activity activity) {
        Intrinsics.f(activity, "<this>");
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final void b1(Context context, MediaSource mediaSource, Long l2) {
        Intrinsics.f(context, "context");
        this.f32368g = 0;
        if (l2 != null) {
            this.f32368g = l2.longValue();
        }
        o1(this, false, 1, (Object) null);
        if (mediaSource != null) {
            e1(context, mediaSource);
            CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
            if (customPlayerControllViewBinding != null) {
                TextView textView = customPlayerControllViewBinding.X;
                String filename = mediaSource.getFilename();
                if (filename == null) {
                    filename = mediaSource.toString();
                }
                textView.setText(filename);
                FrameLayout frameLayout = customPlayerControllViewBinding.F;
                Intrinsics.e(frameLayout, "playerPausePlayHolderHolder");
                frameLayout.setVisibility(8);
                ProgressBar progressBar = customPlayerControllViewBinding.f38130s;
                Intrinsics.e(progressBar, "playerBuffering");
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Requires link or uri");
    }

    public final void c1(SubtitleView subtitleView, FrameLayout frameLayout, SaveCaptionStyle saveCaptionStyle) {
        this.B.j(subtitleView, frameLayout, saveCaptionStyle);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Intrinsics.f(keyEvent, "event");
        if (this.M) {
            this.D++;
        }
        if (Y0(keyEvent, false) || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra(ViewProps.POSITION, this.f32368g);
        setResult(-1, intent);
        super.finish();
    }

    public final void g1() {
        int length = (this.H + 1) % PlayerResize.values().length;
        this.H = length;
        p1(length, true);
    }

    public final void g2() {
        r1();
        try {
            List k2 = CollectionsKt__CollectionsKt.k("Off Subtitle");
            Iterable<SubtitleData> c2 = this.B.c();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(c2, 10));
            for (SubtitleData subtitleData : c2) {
                arrayList.add(subtitleData.toString());
            }
            k2.addAll(arrayList);
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select Subtitle");
            builder.setSingleChoiceItems((CharSequence[]) k2.toArray(new String[0]), this.f32385v + 1, new c0(ref$IntRef));
            builder.setPositiveButton("OK", new d0(ref$IntRef, this));
            builder.setNegativeButton("Cancel", new e0(this));
            AlertDialog create = builder.create();
            create.setOnShowListener(new f0(create));
            create.show();
        } catch (Exception unused) {
        }
    }

    public final void k1() {
        ImageButton imageButton;
        String str;
        String str2;
        String str3;
        boolean z2;
        int i2;
        CurrentTracks J0 = J0();
        CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
        if (customPlayerControllViewBinding != null) {
            imageButton = customPlayerControllViewBinding.f38129r;
        } else {
            imageButton = null;
        }
        if (imageButton != null) {
            if (J0.a().size() < 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageButton.setVisibility(i2);
        }
        if (this.f32386w == -1) {
            Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_sub_language_international_v3", new HashSet(Arrays.asList(new String[]{Locale.getDefault().getLanguage()})));
            for (AudioTrack audioTrack : J0.a()) {
                String b2 = audioTrack.b();
                if (b2 != null) {
                    str = b2.toLowerCase(Locale.ROOT);
                    Intrinsics.e(str, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                } else {
                    str = null;
                }
                if (stringSet == null || (str3 = (String) CollectionsKt___CollectionsKt.B(stringSet)) == null) {
                    str2 = null;
                } else {
                    str2 = str3.toLowerCase(Locale.ROOT);
                    Intrinsics.e(str2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                }
                if (Intrinsics.a(str, str2)) {
                    this.f32386w = J0.a().indexOf(audioTrack);
                    t1(audioTrack.b(), audioTrack.a());
                    return;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    public final void l2(String str, Integer num) {
        runOnUiThread(new u(this, str, num));
    }

    public void onBackPressed() {
        U1(this, new PlayerActivity$onBackPressed$1(this));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SubtitleView subtitleView;
        super.onCreate(bundle);
        setContentView(M0());
        Window window = getWindow();
        if (window != null) {
            window.addFlags(128);
        }
        setRequestedOrientation(6);
        this.A = CustomPlayerControllViewBinding.a(findViewById(R.id.player_holder));
        this.f32381r = (PlayerView) findViewById(R.id.player_view);
        this.C = (FrameLayout) findViewById(R.id.subtitle_holder);
        PlayerView playerView = this.f32381r;
        if (playerView != null) {
            subtitleView = (SubtitleView) playerView.findViewById(R.id.exo_subtitles);
        } else {
            subtitleView = null;
        }
        this.J = subtitleView;
        this.I = this.B.f();
        if (bundle != null) {
            long j2 = bundle.getLong(ViewProps.POSITION);
            float f2 = bundle.getFloat("speed");
            int i2 = bundle.getInt("resize_mode");
            this.f32368g = j2;
            this.f32378o = f2;
            this.H = i2;
        }
        c1(this.J, this.C, this.I);
        z1();
        X0();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        G0();
        PlayerView playerView = this.f32381r;
        if (playerView != null) {
            playerView.setPlayer((Player) null);
        }
        SimpleCache simpleCache = this.f32360c;
        if (simpleCache != null) {
            simpleCache.x();
        }
        o1(this, false, 1, (Object) null);
        super.onDestroy();
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        PlayerEventType playerEventType;
        switch (i2) {
            case 7:
            case 46:
            case 144:
                playerEventType = PlayerEventType.Resize;
                break;
            case 10:
            case 33:
            case 147:
                playerEventType = PlayerEventType.ShowSpeed;
                break;
            case 14:
            case 40:
            case 151:
                playerEventType = PlayerEventType.Lock;
                break;
            case 15:
            case 43:
            case 152:
                playerEventType = PlayerEventType.SearchSubtitlesOnline;
                break;
            case 16:
            case 47:
            case 153:
                playerEventType = PlayerEventType.ShowSources;
                break;
            case 29:
            case 89:
            case 273:
                playerEventType = PlayerEventType.SeekBack;
                break;
            case 32:
            case 90:
            case 125:
            case 272:
                playerEventType = PlayerEventType.SeekForward;
                break;
            case 36:
            case 82:
                playerEventType = PlayerEventType.ToggleHide;
                break;
            case 41:
            case 164:
                playerEventType = PlayerEventType.ToggleMute;
                break;
            case 44:
            case 62:
            case 66:
            case 85:
            case 160:
                playerEventType = PlayerEventType.PlayPauseToggle;
                break;
            case 108:
            case 126:
                playerEventType = PlayerEventType.Play;
                break;
            case 127:
                playerEventType = PlayerEventType.Pause;
                break;
            default:
                playerEventType = null;
                break;
        }
        if (playerEventType != null) {
            W0(playerEventType);
            return true;
        }
        if (i2 == 23) {
            System.out.println("DPAD PRESSED");
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        ExoPlayer exoPlayer;
        r1();
        ExoPlayer exoPlayer2 = this.f32364e;
        boolean z2 = false;
        if (exoPlayer2 != null && exoPlayer2.isPlaying()) {
            z2 = true;
        }
        if (z2 && (exoPlayer = this.f32364e) != null) {
            exoPlayer.pause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        ExoPlayer exoPlayer;
        F0();
        ExoPlayer exoPlayer2 = this.f32364e;
        boolean z2 = false;
        if (exoPlayer2 != null && !exoPlayer2.isPlaying()) {
            z2 = true;
        }
        if (z2 && (exoPlayer = this.f32364e) != null) {
            exoPlayer.play();
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        Intrinsics.f(bundle, "outState");
        super.onSaveInstanceState(bundle);
        long j2 = this.f32368g;
        float f2 = this.f32378o;
        int i2 = this.H;
        bundle.putLong(ViewProps.POSITION, j2);
        bundle.putFloat("speed", f2);
        bundle.putInt("resize_mode", i2);
    }

    public final void p1(int i2, boolean z2) {
        FreeMoviesApp.p().edit().putInt(this.f32358b, i2).apply();
        q1(PlayerResize.values()[i2], z2);
    }

    @SuppressLint({"UnsafeOptInUsageError"})
    public final void q1(PlayerResize playerResize, boolean z2) {
        Intrinsics.f(playerResize, "resize");
        int i2 = WhenMappings.f32398b[playerResize.ordinal()];
        int i3 = 3;
        if (i2 != 1) {
            if (i2 == 2) {
                i3 = 0;
            } else if (i2 == 3) {
                i3 = 4;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        PlayerView playerView = this.f32381r;
        if (playerView != null) {
            playerView.setResizeMode(i3);
        }
        if (z2) {
            l2(getResources().getString(playerResize.b()), 0);
        }
    }

    public final void r1() {
        ExoPlayer exoPlayer = this.f32364e;
        if (exoPlayer != null) {
            this.f32368g = exoPlayer.getCurrentPosition();
            this.f32366f = exoPlayer.V();
        }
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().c(this);
    }

    /* access modifiers changed from: protected */
    public final void t0() {
        float f2;
        float f3;
        float f4;
        float f5;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        FrameLayout frameLayout;
        if (this.M) {
            w2();
        } else {
            CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
            if (!(customPlayerControllViewBinding == null || (frameLayout = customPlayerControllViewBinding.f38136y) == null)) {
                frameLayout.postDelayed(new r(this), 200);
            }
        }
        float f6 = 0.0f;
        if (this.M) {
            f2 = 0.0f;
        } else {
            f2 = -((float) UiExtKt.a(50));
        }
        CustomPlayerControllViewBinding customPlayerControllViewBinding2 = this.A;
        if (!(customPlayerControllViewBinding2 == null || (linearLayout3 = customPlayerControllViewBinding2.T) == null)) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout3, "translationY", new float[]{f2});
            ofFloat.setDuration(200);
            ofFloat.start();
        }
        CustomPlayerControllViewBinding customPlayerControllViewBinding3 = this.A;
        if (!(customPlayerControllViewBinding3 == null || (linearLayout2 = customPlayerControllViewBinding3.T) == null)) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(linearLayout2, "translationY", new float[]{f2});
            ofFloat2.setDuration(200);
            ofFloat2.start();
        }
        if (this.M) {
            f3 = 0.0f;
        } else {
            f3 = (float) UiExtKt.a(70);
        }
        CustomPlayerControllViewBinding customPlayerControllViewBinding4 = this.A;
        if (!(customPlayerControllViewBinding4 == null || (linearLayout = customPlayerControllViewBinding4.f38113b) == null)) {
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(linearLayout, "translationY", new float[]{f3});
            ofFloat3.setDuration(200);
            ofFloat3.start();
        }
        if (this.M) {
            f4 = 1.0f;
        } else {
            f4 = 0.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f - f4, f4);
        alphaAnimation.setDuration(100);
        alphaAnimation.setFillAfter(true);
        SubtitleView subtitleView = this.J;
        SaveCaptionStyle saveCaptionStyle = this.I;
        if (!(subtitleView == null || saveCaptionStyle == null)) {
            if (this.M) {
                f5 = (-((float) UiExtKt.a(70))) - ((float) UiExtKt.a(saveCaptionStyle.getElevation()));
            } else {
                f5 = -((float) UiExtKt.a(saveCaptionStyle.getElevation()));
            }
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(subtitleView, "translationY", new float[]{f5});
            ofFloat4.setDuration(200);
            ofFloat4.start();
        }
        if (!this.M) {
            f6 = -((float) UiExtKt.a(50));
        }
        CustomPlayerControllViewBinding customPlayerControllViewBinding5 = this.A;
        if (customPlayerControllViewBinding5 != null) {
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(customPlayerControllViewBinding5.E, "translationY", new float[]{f6});
            ofFloat5.setDuration(200);
            ofFloat5.start();
            if (!this.L) {
                customPlayerControllViewBinding5.f38132u.setAlpha(1.0f);
                customPlayerControllViewBinding5.N.setAlpha(1.0f);
                View view = customPlayerControllViewBinding5.Y;
                Intrinsics.e(view, "shadowOverlay");
                view.setVisibility(0);
                customPlayerControllViewBinding5.Y.startAnimation(alphaAnimation);
                customPlayerControllViewBinding5.f38132u.startAnimation(alphaAnimation);
                customPlayerControllViewBinding5.N.startAnimation(alphaAnimation);
                customPlayerControllViewBinding5.f38120i.startAnimation(alphaAnimation);
            }
            customPlayerControllViewBinding5.f38113b.startAnimation(alphaAnimation);
            customPlayerControllViewBinding5.E.startAnimation(alphaAnimation);
            customPlayerControllViewBinding5.U.startAnimation(alphaAnimation);
        }
    }

    public final void t1(String str, String str2) {
        TrackSelectionParameters v2;
        TrackSelectionParameters.Builder a2;
        TrackSelectionParameters.Builder K2;
        Pair<TrackGroup, Integer> pair;
        TrackSelectionParameters v3;
        TrackSelectionParameters.Builder a3;
        TrackSelectionParameters.Builder J2;
        Tracks m2;
        ImmutableList<Tracks.Group> a4;
        TrackSelectionParameters trackSelectionParameters = null;
        if (str2 != null) {
            ExoPlayer exoPlayer = this.f32364e;
            if (exoPlayer == null || (m2 = exoPlayer.m()) == null || (a4 = m2.a()) == null) {
                pair = null;
            } else {
                ArrayList arrayList = new ArrayList();
                for (T next : a4) {
                    boolean z2 = true;
                    if (((Tracks.Group) next).c() != 1) {
                        z2 = false;
                    }
                    if (z2) {
                        arrayList.add(next);
                    }
                }
                pair = T0(arrayList, str2);
            }
            if (pair != null) {
                ExoPlayer exoPlayer2 = this.f32364e;
                if (exoPlayer2 != null) {
                    if (!(exoPlayer2 == null || (v3 = exoPlayer2.v()) == null || (a3 = v3.a()) == null || (J2 = a3.J(new TrackSelectionOverride(pair.c(), pair.d().intValue()))) == null)) {
                        trackSelectionParameters = J2.C();
                    }
                    if (trackSelectionParameters != null) {
                        exoPlayer2.a0(trackSelectionParameters);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        ExoPlayer exoPlayer3 = this.f32364e;
        if (exoPlayer3 != null) {
            if (!(exoPlayer3 == null || (v2 = exoPlayer3.v()) == null || (a2 = v2.a()) == null || (K2 = a2.K(str)) == null)) {
                trackSelectionParameters = K2.C();
            }
            if (trackSelectionParameters != null) {
                exoPlayer3.a0(trackSelectionParameters);
            }
        }
    }

    public final boolean u1(SubtitleData subtitleData) {
        Object obj;
        this.f32370h = subtitleData;
        ExoPlayer exoPlayer = this.f32364e;
        DefaultTrackSelector defaultTrackSelector = null;
        if (exoPlayer != null) {
            obj = exoPlayer.c();
        } else {
            obj = null;
        }
        if (obj instanceof DefaultTrackSelector) {
            defaultTrackSelector = (DefaultTrackSelector) obj;
        }
        if (defaultTrackSelector == null) {
            return false;
        }
        if (subtitleData == null) {
            defaultTrackSelector.i0(defaultTrackSelector.F().N(3, true).D(3));
        } else {
            int i2 = WhenMappings.f32397a[this.B.o(subtitleData).ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    DefaultTrackSelector.Parameters.Builder F2 = defaultTrackSelector.F();
                    Pair<TrackGroup, Integer> v1 = v1(this, subtitleData.b());
                    if (v1 != null) {
                        F2.N(3, false);
                        F2.J(new TrackSelectionOverride(v1.c(), v1.d().intValue()));
                    }
                    defaultTrackSelector.i0(F2);
                } else if (i2 != 3) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void v0() {
        FrameLayout frameLayout;
        int i2 = this.D + 1;
        this.D = i2;
        CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
        if (customPlayerControllViewBinding != null && (frameLayout = customPlayerControllViewBinding.f38136y) != null) {
            frameLayout.postDelayed(new s(this, i2), 2000);
        }
    }

    public final void w2() {
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = 0;
        if (this.L || !this.M) {
            z2 = true;
        } else {
            z2 = false;
        }
        CustomPlayerControllViewBinding customPlayerControllViewBinding = this.A;
        if (customPlayerControllViewBinding != null) {
            LinearLayout linearLayout = customPlayerControllViewBinding.B;
            Intrinsics.e(linearLayout, "playerLockHolder");
            if (z2) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            linearLayout.setVisibility(i2);
            ConstraintLayout constraintLayout = customPlayerControllViewBinding.V;
            Intrinsics.e(constraintLayout, "playerVideoBar");
            if (z2) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            constraintLayout.setVisibility(i3);
            ImageButton imageButton = customPlayerControllViewBinding.f38120i;
            Intrinsics.e(imageButton, "exoPlayPause");
            if (z2) {
                i4 = 8;
            } else {
                i4 = 0;
            }
            imageButton.setVisibility(i4);
            FrameLayout frameLayout = customPlayerControllViewBinding.U;
            Intrinsics.e(frameLayout, "playerTopHolder");
            if (z2) {
                i5 = 8;
            } else {
                i5 = 0;
            }
            frameLayout.setVisibility(i5);
            ConstraintLayout constraintLayout2 = customPlayerControllViewBinding.f38131t;
            Intrinsics.e(constraintLayout2, "playerCenterMenu");
            if (z2) {
                i6 = 8;
            } else {
                i6 = 0;
            }
            constraintLayout2.setVisibility(i6);
            FrameLayout frameLayout2 = customPlayerControllViewBinding.f38135x;
            Intrinsics.e(frameLayout2, "playerGoBackHolder");
            if (z2) {
                i7 = 8;
            } else {
                i7 = 0;
            }
            frameLayout2.setVisibility(i7);
            ImageButton imageButton2 = customPlayerControllViewBinding.P;
            Intrinsics.e(imageButton2, "playerSourcesBtt");
            if (z2) {
                i8 = 8;
            }
            imageButton2.setVisibility(i8);
            ImageButton imageButton3 = customPlayerControllViewBinding.A;
            Intrinsics.e(imageButton3, "playerLock");
            imageButton3.setVisibility(8);
        }
    }

    public static final class MediaItemSlice {

        /* renamed from: a  reason: collision with root package name */
        private final MediaItem f32390a;

        /* renamed from: b  reason: collision with root package name */
        private final long f32391b;

        public MediaItemSlice(MediaItem mediaItem, long j2, DrmMetadata drmMetadata) {
            Intrinsics.f(mediaItem, "mediaItem");
            this.f32390a = mediaItem;
            this.f32391b = j2;
        }

        public final DrmMetadata a() {
            return null;
        }

        public final long b() {
            return this.f32391b;
        }

        public final MediaItem c() {
            return this.f32390a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemSlice)) {
                return false;
            }
            MediaItemSlice mediaItemSlice = (MediaItemSlice) obj;
            return Intrinsics.a(this.f32390a, mediaItemSlice.f32390a) && this.f32391b == mediaItemSlice.f32391b && Intrinsics.a((Object) null, (Object) null);
        }

        public int hashCode() {
            return (((this.f32390a.hashCode() * 31) + b0.y.a(this.f32391b)) * 31) + 0;
        }

        public String toString() {
            return "MediaItemSlice(mediaItem=" + this.f32390a + ", durationUs=" + this.f32391b + ", drm=" + null + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ MediaItemSlice(MediaItem mediaItem, long j2, DrmMetadata drmMetadata, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(mediaItem, j2, (i2 & 4) != 0 ? null : drmMetadata);
        }
    }
}

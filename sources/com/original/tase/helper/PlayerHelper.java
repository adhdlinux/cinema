package com.original.tase.helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import com.database.entitys.MovieEntity;
import com.database.entitys.TvWatchedEpisode;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.movie.FreeMoviesApp;
import com.movie.data.model.MovieInfo;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.I18N;
import com.original.tase.helper.StreamAction;
import com.original.tase.helper.player.BasePlayer;
import com.original.tase.helper.player.CSPlayer;
import com.original.tase.helper.player.CinemaPlayer;
import com.original.tase.helper.player.MXPlayer;
import com.original.tase.helper.player.VLCPlayer;
import com.original.tase.model.media.MediaSource;
import com.utils.Utils;
import com.utils.cast.CastHelper;
import com.utils.subtitle.SubtitleInfo;
import com.yoku.marumovie.R;
import e1.a;
import e1.b;
import e1.c;
import e1.d;
import e1.e;
import e1.f;
import e1.g;
import e1.h;
import e1.i;
import e1.j;
import e1.k;
import e1.l;
import e1.m;
import e1.n;
import e1.o;
import e1.p;
import e1.q;
import e1.r;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import timber.log.Timber;

public final class PlayerHelper {

    /* renamed from: i  reason: collision with root package name */
    public static final Companion f33837i = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    private final MoviesHelper f33838a;

    /* renamed from: b  reason: collision with root package name */
    private CompositeDisposable f33839b;

    /* renamed from: c  reason: collision with root package name */
    private Listener f33840c;

    /* renamed from: d  reason: collision with root package name */
    private PlayData f33841d;

    /* renamed from: e  reason: collision with root package name */
    private final BasePlayer[] f33842e = {new CinemaPlayer(), new CSPlayer(), new MXPlayer(), new VLCPlayer()};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ProgressDialog f33843f;

    /* renamed from: g  reason: collision with root package name */
    private ActivityResultLauncher<Intent> f33844g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public WeakReference<AppCompatActivity> f33845h;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BasePlayer a() {
            return new CinemaPlayer();
        }
    }

    public interface Listener {
        void s(StreamAction.ActionID actionID, MediaSource mediaSource);

        void x(boolean z2);
    }

    @Inject
    public PlayerHelper(MoviesHelper moviesHelper) {
        Intrinsics.f(moviesHelper, "_movieHelper");
        this.f33838a = moviesHelper;
    }

    /* access modifiers changed from: private */
    public static final void B(PlayData playData, AppCompatActivity appCompatActivity, PlayerHelper playerHelper, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(playData, "$playData");
        Intrinsics.f(appCompatActivity, "$activity");
        Intrinsics.f(playerHelper, "this$0");
        playData.d().setPosition(0);
        D(appCompatActivity, playerHelper, playData);
    }

    /* access modifiers changed from: private */
    public static final void C(PlayData playData, AppCompatActivity appCompatActivity, PlayerHelper playerHelper, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(playData, "$playData");
        Intrinsics.f(appCompatActivity, "$activity");
        Intrinsics.f(playerHelper, "this$0");
        D(appCompatActivity, playerHelper, playData);
    }

    private static final void D(AppCompatActivity appCompatActivity, PlayerHelper playerHelper, PlayData playData) {
        boolean z2;
        boolean z3;
        if (CastHelper.e(appCompatActivity)) {
            CastHelper.f(appCompatActivity, playData, Long.valueOf(playData.d().getPosition()));
        } else {
            BasePlayer x2 = playerHelper.x();
            boolean z4 = true;
            if (x2 instanceof CinemaPlayer) {
                z2 = true;
            } else {
                z2 = x2 instanceof MXPlayer;
            }
            if (z2) {
                z3 = true;
            } else {
                z3 = x2 instanceof CSPlayer;
            }
            if (!z3) {
                z4 = x2 instanceof VLCPlayer;
            }
            if (z4) {
                try {
                    ActivityResultLauncher<PlayData> e2 = x2.e();
                    if (e2 != null) {
                        e2.a(playData);
                    }
                } catch (ActivityNotFoundException unused) {
                    playerHelper.X(x2);
                }
            }
        }
        playerHelper.f33841d = playData;
    }

    /* access modifiers changed from: private */
    public static final void I(PlayerHelper playerHelper, BasePlayer basePlayer, ActivityResult activityResult) {
        boolean z2;
        Intrinsics.f(playerHelper, "this$0");
        Intrinsics.f(basePlayer, "$currentPlayer");
        PlayData playData = playerHelper.f33841d;
        boolean z3 = true;
        if (playData == null || !playData.g()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            Intrinsics.c(activityResult);
            long h2 = basePlayer.h(activityResult);
            PlayData playData2 = playerHelper.f33841d;
            if (playData2 != null) {
                playerHelper.M(h2, false, playData2);
            }
            Listener listener = playerHelper.f33840c;
            if (listener != null) {
                if (h2 <= 0) {
                    z3 = false;
                }
                listener.x(z3);
                return;
            }
            return;
        }
        Intrinsics.c(activityResult);
        List<Pair<Integer, Long>> i2 = basePlayer.i(activityResult);
        PlayData playData3 = playerHelper.f33841d;
        if (playData3 != null) {
            playerHelper.N(i2, false, playData3);
        }
        Listener listener2 = playerHelper.f33840c;
        if (listener2 != null) {
            if (i2.size() <= 0) {
                z3 = false;
            }
            listener2.x(z3);
        }
    }

    /* access modifiers changed from: private */
    public static final void J(PlayerHelper playerHelper, ActivityResult activityResult) {
        Intrinsics.f(playerHelper, "this$0");
        PlayData playData = playerHelper.f33841d;
        if (playData != null) {
            playerHelper.M(0, true, playData);
        }
        Listener listener = playerHelper.f33840c;
        if (listener != null) {
            listener.x(true);
        }
    }

    /* access modifiers changed from: private */
    public final void K(Function0<Unit> function0) {
        new Handler(Looper.getMainLooper()).post(new i(function0));
    }

    /* access modifiers changed from: private */
    public static final void L(Function0 function0) {
        Intrinsics.f(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    public static final void O(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void P(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void Q(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void R(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void S(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void T(Function1 function1, Object obj) {
        Intrinsics.f(function1, "$tmp0");
        function1.invoke(obj);
    }

    private final void W(BasePlayer basePlayer) {
        AppCompatActivity appCompatActivity;
        WeakReference<AppCompatActivity> weakReference = this.f33845h;
        if (weakReference != null && (appCompatActivity = weakReference.get()) != null) {
            new AlertDialog.Builder(appCompatActivity);
            ProgressDialog progressDialog = new ProgressDialog(appCompatActivity);
            progressDialog.setTitle("Downloading APK...");
            progressDialog.setMessage("Please wait while the APK is being downloaded.");
            progressDialog.setProgressStyle(1);
            progressDialog.setMax(100);
            progressDialog.setCancelable(false);
            progressDialog.show();
            this.f33843f = progressDialog;
            String d2 = basePlayer.d();
            if (d2 != null) {
                w(d2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void Y(BasePlayer basePlayer, PlayerHelper playerHelper, AppCompatActivity appCompatActivity, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(basePlayer, "$player");
        Intrinsics.f(playerHelper, "this$0");
        Intrinsics.f(appCompatActivity, "$activity");
        dialogInterface.dismiss();
        if (basePlayer.d() != null) {
            playerHelper.W(basePlayer);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + basePlayer.g(appCompatActivity)));
        intent.addFlags(1208483840);
        try {
            appCompatActivity.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            appCompatActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + basePlayer.g(appCompatActivity))));
        }
    }

    /* access modifiers changed from: private */
    public static final void Z(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void b0(List list, PlayerHelper playerHelper, MediaSource mediaSource, AdapterView adapterView, View view, int i2, long j2) {
        Intrinsics.f(list, "$arrayList");
        Intrinsics.f(playerHelper, "this$0");
        Intrinsics.f(mediaSource, "$mediaSource");
        StreamAction.ActionID actionID = (StreamAction.ActionID) list.get(i2);
        Listener listener = playerHelper.f33840c;
        if (listener != null) {
            listener.s(actionID, mediaSource);
        }
    }

    /* access modifiers changed from: private */
    public static final void c0(PlayerHelper playerHelper, View view) {
        Intrinsics.f(playerHelper, "this$0");
        playerHelper.d0();
    }

    /* access modifiers changed from: private */
    public static final void e0(Ref$IntRef ref$IntRef, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(ref$IntRef, "$selectedItemIndex");
        ref$IntRef.f40427b = i2;
    }

    /* access modifiers changed from: private */
    public static final void f0(Ref$IntRef ref$IntRef, PlayerHelper playerHelper, DialogInterface dialogInterface, int i2) {
        Intrinsics.f(ref$IntRef, "$selectedItemIndex");
        Intrinsics.f(playerHelper, "this$0");
        if (ref$IntRef.f40427b != -1) {
            playerHelper.U(playerHelper.G()[ref$IntRef.f40427b]);
        }
    }

    /* access modifiers changed from: private */
    public static final void g0(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
    }

    private final void w(String str) {
        if (Utils.v() == null) {
            Toast.makeText(Utils.v(), "Something was wrong!!", 0).show();
        }
        new OkHttpClient().newCall(new Request.Builder().url(str).build()).enqueue(new PlayerHelper$downloadApk$1(this));
    }

    /* access modifiers changed from: private */
    public final void y(File file) {
        Context v2 = Utils.v();
        if (v2 != null) {
            Uri f2 = FileProvider.f(v2, "com.yoku.marumovie.provider", file);
            Intrinsics.e(f2, "getUriForFile(...)");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(f2, "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            intent.addFlags(1);
            v2.startActivity(intent);
        }
    }

    public final void A(PlayData playData) {
        AppCompatActivity appCompatActivity;
        Intrinsics.f(playData, "playData");
        WeakReference<AppCompatActivity> weakReference = this.f33845h;
        if (weakReference != null && (appCompatActivity = weakReference.get()) != null) {
            if (playData.d().getPosition() < NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                D(appCompatActivity, this, playData);
            } else {
                new AlertDialog.Builder(appCompatActivity).setTitle("Resume playback").g("Do you want to start over or resume from where you left off?").l("Start Over", new a(playData, appCompatActivity, this)).i("Resume", new j(playData, appCompatActivity, this)).q();
            }
        }
    }

    public final void E(PlayData playData) {
        Intrinsics.f(playData, "playData");
        for (BasePlayer basePlayer : G()) {
            if (Intrinsics.a(basePlayer.f(), "CSPlayer")) {
                try {
                    ActivityResultLauncher<PlayData> e2 = basePlayer.e();
                    if (e2 != null) {
                        e2.a(playData);
                    }
                } catch (ActivityNotFoundException unused) {
                    X(basePlayer);
                }
                this.f33841d = playData;
                return;
            }
        }
        throw new NoSuchElementException("Array contains no element matching the predicate.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void F(com.original.tase.helper.PlayerHelper.PlayData r14) {
        /*
            r13 = this;
            java.lang.String r0 = "playData"
            kotlin.jvm.internal.Intrinsics.f(r14, r0)
            com.database.entitys.MovieEntity r0 = r14.d()
            com.original.tase.model.media.MediaSource r1 = r14.b()
            com.movie.data.model.MovieInfo r2 = r14.e()
            android.content.Intent r3 = new android.content.Intent
            java.lang.String r4 = "android.intent.action.VIEW"
            r3.<init>(r4)
            java.lang.String r4 = r1.getStreamLink()
            android.net.Uri r4 = android.net.Uri.parse(r4)
            boolean r5 = r1.isHLS()
            java.lang.String r6 = "application/x-mpegURL"
            java.lang.String r7 = "video/*"
            if (r5 == 0) goto L_0x002c
            r5 = r6
            goto L_0x002d
        L_0x002c:
            r5 = r7
        L_0x002d:
            r3.setDataAndType(r4, r5)
            java.util.HashMap r5 = r1.getPlayHeader()
            r8 = 1
            r9 = 0
            if (r5 == 0) goto L_0x0041
            boolean r10 = r5.isEmpty()
            if (r10 == 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r10 = 0
            goto L_0x0042
        L_0x0041:
            r10 = 1
        L_0x0042:
            if (r10 != 0) goto L_0x0082
            java.util.HashMap r5 = com.original.tase.utils.SourceUtils.a(r5)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Set r5 = r5.entrySet()
            java.util.Iterator r5 = r5.iterator()
        L_0x0055:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x0075
            java.lang.Object r11 = r5.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.String r12 = "null cannot be cast to non-null type kotlin.collections.Map.Entry<kotlin.String, kotlin.String>"
            kotlin.jvm.internal.Intrinsics.d(r11, r12)
            java.lang.Object r12 = r11.getKey()
            r10.add(r12)
            java.lang.Object r11 = r11.getValue()
            r10.add(r11)
            goto L_0x0055
        L_0x0075:
            java.lang.String[] r5 = new java.lang.String[r9]
            java.lang.Object[] r5 = r10.toArray(r5)
            java.lang.String[] r5 = (java.lang.String[]) r5
            java.lang.String r10 = "headers"
            r3.putExtra(r10, r5)
        L_0x0082:
            boolean r5 = r1.isHLS()
            if (r5 == 0) goto L_0x0089
            goto L_0x0091
        L_0x0089:
            java.lang.String r1 = r1.getStreamLink()
            java.lang.String r6 = com.utils.Utils.L(r1)
        L_0x0091:
            java.lang.String r1 = r0.getRealeaseDate()
            if (r1 == 0) goto L_0x0114
            java.lang.String r1 = r0.getRealeaseDate()
            java.lang.String r5 = "getRealeaseDate(...)"
            kotlin.jvm.internal.Intrinsics.e(r1, r5)
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x00a8
            r1 = 1
            goto L_0x00a9
        L_0x00a8:
            r1 = 0
        L_0x00a9:
            if (r1 == 0) goto L_0x0114
            java.lang.String r1 = r0.getRealeaseDate()
            kotlin.jvm.internal.Intrinsics.e(r1, r5)
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00ba
            r1 = 1
            goto L_0x00bb
        L_0x00ba:
            r1 = 0
        L_0x00bb:
            if (r1 == 0) goto L_0x00c0
            java.lang.String r1 = ""
            goto L_0x0116
        L_0x00c0:
            java.lang.String r1 = r0.getRealeaseDate()
            kotlin.jvm.internal.Intrinsics.e(r1, r5)
            kotlin.text.Regex r5 = new kotlin.text.Regex
            java.lang.String r10 = "-"
            r5.<init>((java.lang.String) r10)
            java.util.List r1 = r5.k(r1, r9)
            boolean r5 = r1.isEmpty()
            if (r5 != 0) goto L_0x0103
            int r5 = r1.size()
            java.util.ListIterator r5 = r1.listIterator(r5)
        L_0x00e0:
            boolean r10 = r5.hasPrevious()
            if (r10 == 0) goto L_0x0103
            java.lang.Object r10 = r5.previous()
            java.lang.String r10 = (java.lang.String) r10
            int r10 = r10.length()
            if (r10 != 0) goto L_0x00f4
            r10 = 1
            goto L_0x00f5
        L_0x00f4:
            r10 = 0
        L_0x00f5:
            if (r10 != 0) goto L_0x00e0
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            int r5 = r5.nextIndex()
            int r5 = r5 + r8
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.U(r1, r5)
            goto L_0x0107
        L_0x0103:
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.f()
        L_0x0107:
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.String[] r5 = new java.lang.String[r9]
            java.lang.Object[] r1 = r1.toArray(r5)
            java.lang.String[] r1 = (java.lang.String[]) r1
            r1 = r1[r9]
            goto L_0x0116
        L_0x0114:
            java.lang.String r1 = "1970"
        L_0x0116:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = r0.getName()
            r5.append(r0)
            r0 = 32
            r5.append(r0)
            java.lang.String r0 = r2.session
            r5.append(r0)
            r0 = 120(0x78, float:1.68E-43)
            r5.append(r0)
            java.lang.String r0 = r2.eps
            r5.append(r0)
            java.lang.String r0 = " ("
            r5.append(r0)
            r5.append(r1)
            r0 = 41
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
            java.lang.String r1 = "title"
            android.content.Intent r0 = r3.putExtra(r1, r0)
            if (r0 != 0) goto L_0x0161
            r3.putExtra(r1, r6)
        L_0x0161:
            r3.setDataAndTypeAndNormalize(r4, r7)
            androidx.activity.result.ActivityResultLauncher<android.content.Intent> r0 = r13.f33844g
            if (r0 == 0) goto L_0x016b
            r0.a(r3)
        L_0x016b:
            r13.f33841d = r14
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.PlayerHelper.F(com.original.tase.helper.PlayerHelper$PlayData):void");
    }

    public final BasePlayer[] G() {
        return this.f33842e;
    }

    public final void H(AppCompatActivity appCompatActivity) {
        Intrinsics.f(appCompatActivity, "baseActivity");
        CompositeDisposable compositeDisposable = this.f33839b;
        if (compositeDisposable != null) {
            compositeDisposable.d();
        }
        this.f33839b = new CompositeDisposable();
        BasePlayer x2 = x();
        if (x2 != null) {
            for (BasePlayer basePlayer : G()) {
                basePlayer.k(appCompatActivity.registerForActivityResult(basePlayer, new m(this, x2)));
            }
            this.f33844g = appCompatActivity.registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new n(this));
            this.f33845h = new WeakReference<>(appCompatActivity);
        }
    }

    public final void M(long j2, boolean z2, PlayData playData) {
        AppCompatActivity appCompatActivity;
        MovieInfo e2;
        Intrinsics.f(playData, "playData");
        WeakReference<AppCompatActivity> weakReference = this.f33845h;
        if (weakReference != null && (appCompatActivity = weakReference.get()) != null && (e2 = playData.e()) != null) {
            MovieEntity d2 = playData.d();
            MoviesHelper moviesHelper = this.f33838a;
            if (moviesHelper != null) {
                if (Intrinsics.a(playData.d().getTV(), Boolean.TRUE)) {
                    TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
                    Integer eps = e2.getEps();
                    Intrinsics.e(eps, "getEps(...)");
                    tvWatchedEpisode.m(eps.intValue());
                    Integer session = e2.getSession();
                    Intrinsics.e(session, "getSession(...)");
                    tvWatchedEpisode.q(session.intValue());
                    tvWatchedEpisode.s(d2.getTmdbID());
                    tvWatchedEpisode.o(d2.getImdbIDStr());
                    tvWatchedEpisode.u(d2.getTvdbID());
                    tvWatchedEpisode.t(d2.getTraktID());
                    tvWatchedEpisode.p(j2);
                    CompositeDisposable compositeDisposable = this.f33839b;
                    if (compositeDisposable != null) {
                        compositeDisposable.b(moviesHelper.l(d2, tvWatchedEpisode, true, z2).observeOn(AndroidSchedulers.a()).subscribe(new o(new PlayerHelper$saveToDatabase$1(appCompatActivity)), new p(new PlayerHelper$saveToDatabase$2(appCompatActivity))));
                        return;
                    }
                    return;
                }
                d2.setPosition(j2);
                d2.setWatched_at(OffsetDateTime.now((ZoneId) ZoneOffset.UTC));
                CompositeDisposable compositeDisposable2 = this.f33839b;
                if (compositeDisposable2 != null) {
                    compositeDisposable2.b(moviesHelper.k(d2, false).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new q(new PlayerHelper$saveToDatabase$3(appCompatActivity)), new r(new PlayerHelper$saveToDatabase$4(appCompatActivity))));
                }
            }
        }
    }

    public final void N(List<Pair<Integer, Long>> list, boolean z2, PlayData playData) {
        Intrinsics.f(list, "positions");
        Intrinsics.f(playData, "playData");
        for (Pair pair : list) {
            int intValue = ((Number) pair.c()).intValue();
            long longValue = ((Number) pair.d()).longValue();
            MovieInfo e2 = playData.e();
            if (e2 != null) {
                MovieEntity d2 = playData.d();
                MoviesHelper moviesHelper = this.f33838a;
                if (moviesHelper != null) {
                    if (Intrinsics.a(playData.d().getTV(), Boolean.TRUE)) {
                        TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
                        tvWatchedEpisode.m(intValue);
                        Integer session = e2.getSession();
                        Intrinsics.e(session, "getSession(...)");
                        tvWatchedEpisode.q(session.intValue());
                        tvWatchedEpisode.s(d2.getTmdbID());
                        tvWatchedEpisode.o(d2.getImdbIDStr());
                        tvWatchedEpisode.u(d2.getTvdbID());
                        tvWatchedEpisode.t(d2.getTraktID());
                        tvWatchedEpisode.p(longValue);
                        CompositeDisposable compositeDisposable = this.f33839b;
                        if (compositeDisposable != null) {
                            compositeDisposable.b(moviesHelper.l(d2, tvWatchedEpisode, true, z2).observeOn(AndroidSchedulers.a()).subscribe(new b(new PlayerHelper$saveToDatabase$5$1(this)), new c(new PlayerHelper$saveToDatabase$5$2(this))));
                        }
                    } else {
                        Timber.f42178a.h("not supported for movie", new Object[0]);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void U(BasePlayer basePlayer) {
        Intrinsics.f(basePlayer, "player");
        FreeMoviesApp.p().edit().putString("pref_choose_default_player", basePlayer.f()).apply();
    }

    public final void V(Listener listener) {
        this.f33840c = listener;
    }

    public final void X(BasePlayer basePlayer) {
        AppCompatActivity appCompatActivity;
        Intrinsics.f(basePlayer, "player");
        WeakReference<AppCompatActivity> weakReference = this.f33845h;
        if (weakReference != null && (appCompatActivity = weakReference.get()) != null && !appCompatActivity.isFinishing()) {
            AlertDialog create = new AlertDialog.Builder(appCompatActivity).create();
            Intrinsics.e(create, "create(...)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.f40434a;
            String string = appCompatActivity.getString(R.string.player_unable_to_start);
            Intrinsics.e(string, "getString(...)");
            String format = String.format(string, Arrays.copyOf(new Object[]{basePlayer.f()}, 1));
            Intrinsics.e(format, "format(format, *args)");
            String string2 = appCompatActivity.getString(R.string.player_unable_to_start_message);
            Intrinsics.e(string2, "getString(...)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{basePlayer.f()}, 1));
            Intrinsics.e(format2, "format(format, *args)");
            create.setTitle(format);
            create.e(format2);
            create.d(-1, I18N.a(R.string.install), new d(basePlayer, this, appCompatActivity));
            create.d(-2, I18N.a(R.string.cancel), new e());
            create.show();
        }
    }

    public final void a0(Activity activity, List<? extends MediaSource> list, MediaSource mediaSource) {
        boolean z2;
        String str;
        Intrinsics.f(activity, "activity");
        Intrinsics.f(list, "mediaSources");
        Intrinsics.f(mediaSource, "mediaSource");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String string = FreeMoviesApp.p().getString("pref_choose_default_action", "Always ask");
        LinkedHashMap<String, StreamAction.ActionID> a2 = StreamAction.a();
        Iterator<String> it2 = a2.keySet().iterator();
        while (true) {
            z2 = false;
            if (!it2.hasNext()) {
                break;
            }
            String next = it2.next();
            if (mediaSource.isHLS()) {
                Intrinsics.c(next);
                if (StringsKt__StringsKt.L(next, "Download", false, 2, (Object) null)) {
                }
            }
            Intrinsics.c(next);
            arrayList.add(next);
            StreamAction.ActionID actionID = a2.get(next);
            Intrinsics.c(actionID);
            arrayList2.add(actionID);
        }
        if (StringsKt__StringsJVMKt.t(string, "Always ask", true) || CastHelper.e(activity)) {
            if (mediaSource.getFilename() != null) {
                String filename = mediaSource.getFilename();
                Intrinsics.e(filename, "getFilename(...)");
                if (filename.length() > 0) {
                    z2 = true;
                }
                if (z2) {
                    str = mediaSource.getFilename();
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    LayoutInflater layoutInflater = activity.getLayoutInflater();
                    Intrinsics.e(layoutInflater, "getLayoutInflater(...)");
                    View inflate = layoutInflater.inflate(R.layout.play_option_dialog, (ViewGroup) null);
                    builder.setView(inflate);
                    ((TextView) inflate.findViewById(R.id.dialog_title)).setText(str);
                    ListView listView = (ListView) inflate.findViewById(R.id.dialog_list);
                    listView.setAdapter(new ArrayAdapter(activity, 17367043, arrayList));
                    listView.setOnItemClickListener(new k(arrayList2, this, mediaSource));
                    ((ImageButton) inflate.findViewById(R.id.btnChangePlayer)).setOnClickListener(new l(this));
                    listView.requestFocus();
                    AlertDialog create = builder.create();
                    Intrinsics.e(create, "create(...)");
                    create.show();
                    return;
                }
            }
            str = mediaSource.toString2();
            AlertDialog.Builder builder2 = new AlertDialog.Builder(activity);
            LayoutInflater layoutInflater2 = activity.getLayoutInflater();
            Intrinsics.e(layoutInflater2, "getLayoutInflater(...)");
            View inflate2 = layoutInflater2.inflate(R.layout.play_option_dialog, (ViewGroup) null);
            builder2.setView(inflate2);
            ((TextView) inflate2.findViewById(R.id.dialog_title)).setText(str);
            ListView listView2 = (ListView) inflate2.findViewById(R.id.dialog_list);
            listView2.setAdapter(new ArrayAdapter(activity, 17367043, arrayList));
            listView2.setOnItemClickListener(new k(arrayList2, this, mediaSource));
            ((ImageButton) inflate2.findViewById(R.id.btnChangePlayer)).setOnClickListener(new l(this));
            listView2.requestFocus();
            AlertDialog create2 = builder2.create();
            Intrinsics.e(create2, "create(...)");
            create2.show();
            return;
        }
        StreamAction.ActionID actionID2 = a2.get(string);
        Intrinsics.c(actionID2);
        StreamAction.ActionID actionID3 = actionID2;
        Listener listener = this.f33840c;
        if (listener != null) {
            listener.s(actionID3, mediaSource);
        }
    }

    public final void d0() {
        AppCompatActivity appCompatActivity;
        String str;
        WeakReference<AppCompatActivity> weakReference = this.f33845h;
        if (weakReference != null && (appCompatActivity = weakReference.get()) != null) {
            BasePlayer[] G = G();
            ArrayList arrayList = new ArrayList(G.length);
            int i2 = 0;
            for (BasePlayer f2 : G) {
                arrayList.add(f2.f());
            }
            String[] strArr = (String[]) arrayList.toArray(new String[0]);
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            BasePlayer[] G2 = G();
            int length = G2.length;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                }
                String f3 = G2[i2].f();
                BasePlayer x2 = x();
                if (x2 != null) {
                    str = x2.f();
                } else {
                    str = null;
                }
                if (Intrinsics.a(f3, str)) {
                    break;
                }
                i2++;
            }
            ref$IntRef.f40427b = i2;
            AlertDialog.Builder builder = new AlertDialog.Builder(appCompatActivity);
            builder.setTitle("Choose a player").n((CharSequence[]) strArr, ref$IntRef.f40427b, new f(ref$IntRef)).l("OK", new g(ref$IntRef, this)).i("Cancel", new h());
            AlertDialog create = builder.create();
            Intrinsics.e(create, "create(...)");
            create.show();
        }
    }

    public final BasePlayer x() {
        String string = FreeMoviesApp.p().getString("pref_choose_default_player", f33837i.a().f());
        for (BasePlayer basePlayer : G()) {
            if (Intrinsics.a(basePlayer.f(), string)) {
                return basePlayer;
            }
        }
        return f33837i.a();
    }

    public final void z() {
        this.f33840c = null;
        for (BasePlayer e2 : G()) {
            ActivityResultLauncher<PlayData> e3 = e2.e();
            if (e3 != null) {
                e3.c();
            }
        }
        ActivityResultLauncher<Intent> activityResultLauncher = this.f33844g;
        if (activityResultLauncher != null) {
            activityResultLauncher.c();
        }
        CompositeDisposable compositeDisposable = this.f33839b;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
        this.f33845h = null;
    }

    public static final class PlayData implements Parcelable {
        public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);

        /* renamed from: b  reason: collision with root package name */
        private MovieEntity f33846b;

        /* renamed from: c  reason: collision with root package name */
        private MediaSource f33847c;

        /* renamed from: d  reason: collision with root package name */
        private List<? extends MediaSource> f33848d;

        /* renamed from: e  reason: collision with root package name */
        private List<? extends SubtitleInfo> f33849e;

        /* renamed from: f  reason: collision with root package name */
        private MovieInfo f33850f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f33851g;

        public static final class CREATOR implements Parcelable.Creator<PlayData> {
            private CREATOR() {
            }

            public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: a */
            public PlayData createFromParcel(Parcel parcel) {
                Intrinsics.f(parcel, "parcel");
                return new PlayData(parcel);
            }

            /* renamed from: b */
            public PlayData[] newArray(int i2) {
                return new PlayData[i2];
            }
        }

        public PlayData(MovieEntity movieEntity, MediaSource mediaSource, List<? extends MediaSource> list, List<? extends SubtitleInfo> list2, MovieInfo movieInfo) {
            Intrinsics.f(movieEntity, "movieEntity");
            Intrinsics.f(mediaSource, "mediaSource");
            Intrinsics.f(movieInfo, "movieInfo");
            this.f33846b = movieEntity;
            this.f33847c = mediaSource;
            this.f33848d = list;
            this.f33849e = list2;
            this.f33850f = movieInfo;
            this.f33851g = true;
        }

        public final MediaSource b() {
            return this.f33847c;
        }

        public final List<MediaSource> c() {
            return this.f33848d;
        }

        public final MovieEntity d() {
            return this.f33846b;
        }

        public int describeContents() {
            return 0;
        }

        public final MovieInfo e() {
            return this.f33850f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlayData)) {
                return false;
            }
            PlayData playData = (PlayData) obj;
            return Intrinsics.a(this.f33846b, playData.f33846b) && Intrinsics.a(this.f33847c, playData.f33847c) && Intrinsics.a(this.f33848d, playData.f33848d) && Intrinsics.a(this.f33849e, playData.f33849e) && Intrinsics.a(this.f33850f, playData.f33850f);
        }

        public final List<SubtitleInfo> f() {
            return this.f33849e;
        }

        public final boolean g() {
            return this.f33851g;
        }

        public final void h(List<? extends MediaSource> list) {
            this.f33848d = list;
        }

        public int hashCode() {
            int hashCode = ((this.f33846b.hashCode() * 31) + this.f33847c.hashCode()) * 31;
            List<? extends MediaSource> list = this.f33848d;
            int i2 = 0;
            int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
            List<? extends SubtitleInfo> list2 = this.f33849e;
            if (list2 != null) {
                i2 = list2.hashCode();
            }
            return ((hashCode2 + i2) * 31) + this.f33850f.hashCode();
        }

        public final void i(boolean z2) {
            this.f33851g = z2;
        }

        public String toString() {
            return "PlayData(movieEntity=" + this.f33846b + ", mediaSource=" + this.f33847c + ", mediaSources=" + this.f33848d + ", subtitleInfos=" + this.f33849e + ", movieInfo=" + this.f33850f + ')';
        }

        public void writeToParcel(Parcel parcel, int i2) {
            Intrinsics.f(parcel, "parcel");
            parcel.writeParcelable(this.f33846b, i2);
            parcel.writeParcelable(this.f33847c, i2);
            parcel.writeTypedList(this.f33848d);
            parcel.writeTypedList(this.f33849e);
            parcel.writeParcelable(this.f33850f, i2);
            parcel.writeByte(this.f33851g ? (byte) 1 : 0);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PlayData(android.os.Parcel r8) {
            /*
                r7 = this;
                java.lang.String r0 = "parcel"
                kotlin.jvm.internal.Intrinsics.f(r8, r0)
                java.lang.Class<com.database.entitys.MovieEntity> r0 = com.database.entitys.MovieEntity.class
                java.lang.ClassLoader r0 = r0.getClassLoader()
                android.os.Parcelable r0 = r8.readParcelable(r0)
                kotlin.jvm.internal.Intrinsics.c(r0)
                r2 = r0
                com.database.entitys.MovieEntity r2 = (com.database.entitys.MovieEntity) r2
                java.lang.Class<com.original.tase.model.media.MediaSource> r0 = com.original.tase.model.media.MediaSource.class
                java.lang.ClassLoader r0 = r0.getClassLoader()
                android.os.Parcelable r0 = r8.readParcelable(r0)
                kotlin.jvm.internal.Intrinsics.c(r0)
                r3 = r0
                com.original.tase.model.media.MediaSource r3 = (com.original.tase.model.media.MediaSource) r3
                android.os.Parcelable$Creator<com.original.tase.model.media.MediaSource> r0 = com.original.tase.model.media.MediaSource.CREATOR
                java.util.ArrayList r4 = r8.createTypedArrayList(r0)
                android.os.Parcelable$Creator<com.utils.subtitle.SubtitleInfo> r0 = com.utils.subtitle.SubtitleInfo.CREATOR
                java.util.ArrayList r5 = r8.createTypedArrayList(r0)
                java.lang.Class<com.movie.data.model.MovieInfo> r0 = com.movie.data.model.MovieInfo.class
                java.lang.ClassLoader r0 = r0.getClassLoader()
                android.os.Parcelable r0 = r8.readParcelable(r0)
                kotlin.jvm.internal.Intrinsics.c(r0)
                r6 = r0
                com.movie.data.model.MovieInfo r6 = (com.movie.data.model.MovieInfo) r6
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                byte r8 = r8.readByte()
                if (r8 == 0) goto L_0x004d
                r8 = 1
                goto L_0x004e
            L_0x004d:
                r8 = 0
            L_0x004e:
                r7.f33851g = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.PlayerHelper.PlayData.<init>(android.os.Parcel):void");
        }
    }
}

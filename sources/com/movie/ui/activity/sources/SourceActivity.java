package com.movie.ui.activity.sources;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import com.ads.videoreward.AdsManager;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.TvWatchedEpisode;
import com.database.entitys.premiumEntitys.torrents.CachedTorrentFileEntity;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.CastStateListener;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.gson.Gson;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.TorrentObject;
import com.movie.data.model.cinema.Video;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.DaggerBaseActivityComponent;
import com.movie.ui.activity.MainActivity;
import com.movie.ui.adapter.MediaSourceArrayAdapter;
import com.movie.ui.customdialog.AddMagnetDialog;
import com.movie.ui.helper.MoviesHelper;
import com.movie.ui.widget.AnimatorStateView;
import com.original.Constants;
import com.original.tase.Logger;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.exception.NeedTimeAddToDeb;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.StreamAction;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.player.BasePlayer;
import com.original.tase.model.media.MediaSource;
import com.original.tase.model.socket.ClientObject;
import com.original.tase.socket.Client;
import com.original.tase.utils.DeviceUtils;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.Getlink.Provider.ZeroTV;
import com.utils.Getlink.Resolver.BaseResolver;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import com.utils.NavIds;
import com.utils.PermissionHelper;
import com.utils.Utils;
import com.utils.download.DownloadDialog;
import com.utils.subtitle.ExpandableListSubtitleAdapter;
import com.utils.subtitle.SubtitleInfo;
import com.utils.subtitle.services.SubServiceBase;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import timber.log.Timber;

public class SourceActivity extends BaseActivity implements MediaSourceArrayAdapter.Listener, PlayerHelper.Listener {
    private String A = "eng";
    private Toolbar B;
    private ArrayList<String> C = null;
    Map<String, List<SubtitleInfo>> D = null;
    /* access modifiers changed from: private */
    public AlertDialog E;
    /* access modifiers changed from: private */
    public MediaSource F = null;
    /* access modifiers changed from: private */
    public ExpandableListSubtitleAdapter G = null;
    private ExpandableListView H;
    private View I = null;
    private TextView J = null;
    @Inject
    @Named("RealDebrid")
    OkHttpClient K;
    @BindView(2131361882)
    FrameLayout adViewFrameLayout;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<MediaSource> f32843b;

    /* renamed from: c  reason: collision with root package name */
    public MediaSourceArrayAdapter f32844c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public MovieEntity f32845d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public MovieInfo f32846e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f32847f = "";
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public CompositeDisposable f32848g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CompositeDisposable f32849h;

    /* renamed from: i  reason: collision with root package name */
    private SessionManagerListener f32850i = null;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public CastSession f32851j;

    /* renamed from: k  reason: collision with root package name */
    private CastContext f32852k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public IntroductoryOverlay f32853l;
    @BindView(2131362356)
    ListView lvSources;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public MenuItem f32854m;
    @BindView(2131362909)
    AnimatorStateView mViewAnimator;

    /* renamed from: n  reason: collision with root package name */
    private CastStateListener f32855n;

    /* renamed from: o  reason: collision with root package name */
    private CompositeDisposable f32856o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public CompositeDisposable f32857p;
    @BindView(2131362547)
    ProgressBar progressbar;

    /* renamed from: q  reason: collision with root package name */
    boolean f32858q = false;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    MoviesApi f32859r;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    MoviesHelper f32860s;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    MvDatabase f32861t;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    OpenSubtitleV1Api f32862u;

    /* renamed from: v  reason: collision with root package name */
    boolean f32863v = false;
    @Inject
    @Named("SourceActivity")

    /* renamed from: w  reason: collision with root package name */
    PlayerHelper f32864w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f32865x = false;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public int f32866y = 10;

    /* renamed from: z  reason: collision with root package name */
    private boolean f32867z = false;

    /* renamed from: com.movie.ui.activity.sources.SourceActivity$15  reason: invalid class name */
    static /* synthetic */ class AnonymousClass15 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32875a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.original.tase.helper.StreamAction$ActionID[] r0 = com.original.tase.helper.StreamAction.ActionID.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f32875a = r0
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.CAST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f32875a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.PLAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f32875a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.CAST_WITH_SUBTITLES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f32875a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.PLAY_WITH_SUBTITLES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f32875a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.OPEN_WITH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f32875a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f32875a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.COPY_TO_CLIPBOARD     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f32875a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.OPEN_WITH_PLAYER_PLUGIN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.sources.SourceActivity.AnonymousClass15.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A0(TvWatchedEpisode tvWatchedEpisode) throws Exception {
        this.f32845d.setPosition(tvWatchedEpisode.e());
        this.f32845d.setSubtitlepath(tvWatchedEpisode.g());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0(Throwable th) throws Exception {
        this.f32845d.setPosition(0);
        this.f32845d.setSubtitlepath("");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0(MediaSource mediaSource, StreamAction.ActionID actionID) throws Exception {
        String str;
        this.F = mediaSource;
        BasePlayer x2 = this.f32864w.x();
        switch (AnonymousClass15.f32875a[actionID.ordinal()]) {
            case 1:
            case 2:
                this.f32864w.A(new PlayerHelper.PlayData(this.f32845d, this.F, this.f32843b, (List<? extends SubtitleInfo>) null, this.f32846e));
                return;
            case 3:
            case 4:
                if (!this.f32845d.getRealeaseDate().isEmpty()) {
                    String str2 = this.f32845d.getRealeaseDate().split("-")[0];
                }
                this.f32846e.tmdbID = this.f32845d.getTmdbID();
                j1(this.f32846e);
                return;
            case 5:
                this.f32864w.F(new PlayerHelper.PlayData(this.f32845d, this.F, (List<? extends MediaSource>) null, (List<? extends SubtitleInfo>) null, this.f32846e));
                return;
            case 6:
                if (!PermissionHelper.a(this)) {
                    ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) new LovelyStandardDialog(this, LovelyStandardDialog.ButtonLayout.HORIZONTAL).m(R.color.darkDeepOrange)).r(R.color.darkDeepOrange).h(R.drawable.database_24px)).k("Warning")).j(getResources().getString(R.string.storage_permission_msg))).u(17039370, new View.OnClickListener() {
                        public void onClick(View view) {
                            PermissionHelper.b(SourceActivity.this, 1212);
                        }
                    }).o();
                    return;
                } else {
                    o(this.F);
                    return;
                }
            case 7:
                Utils.p(this, this.F.getStreamLink(), false);
                return;
            case 8:
                if (x2 == null) {
                    str = "CINEMA";
                } else {
                    str = x2.f();
                }
                Client.getIntance().senddata(new ClientObject(str, this.F.getStreamLink(), this.F.isHLS(), this.f32845d.getName(), -1.0d, this.F.getOriginalLink(), Constants.C, !this.F.getPlayHeader().isEmpty()).toString(), this);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(MediaSource mediaSource, StreamAction.ActionID actionID, MediaSource mediaSource2) throws Exception {
        mediaSource.setStreamLink(mediaSource2.getStreamLink());
        mediaSource.setResolved(true);
        v0(actionID, mediaSource);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H0(Throwable th) throws Exception {
        hideWaitingDialog();
        Utils.i0(this, th.getMessage());
        if (th instanceof NeedTimeAddToDeb) {
            Utils.y0(this, "Download in Progress", th.getMessage(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Intent intent = new Intent(SourceActivity.this, MainActivity.class);
                    intent.putExtra("GotNavID", NavIds.NAV_TORRENT_MANAGER.name());
                    SourceActivity.this.startActivity(intent);
                }
            }, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            return;
        }
        String message = th.getMessage();
        Objects.requireNonNull(message);
        Utils.A0(this, message);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void I0() throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J0(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K0(MediaSource mediaSource, MovieInfo movieInfo, Throwable th) throws Exception {
        hideWaitingDialog();
        this.f32864w.A(new PlayerHelper.PlayData(this.f32845d, mediaSource, this.f32843b, (List<? extends SubtitleInfo>) null, movieInfo));
        Utils.h0(this, R.string.not_subtitle_found);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(MediaSource mediaSource, MovieInfo movieInfo, ArrayList arrayList) throws Exception {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.E.dismiss();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add((SubtitleInfo) arrayList.get(0));
            this.f32864w.A(new PlayerHelper.PlayData(this.f32845d, mediaSource, this.f32843b, arrayList2, movieInfo));
        }
        hideWaitingDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M0(final MovieInfo movieInfo, ArrayList arrayList) throws Exception {
        if (arrayList != null) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SubtitleInfo subtitleInfo = (SubtitleInfo) it2.next();
                String str = subtitleInfo.f37704d;
                if (!this.D.containsKey(str)) {
                    this.D.put(str, new ArrayList());
                }
                this.D.get(str).add(subtitleInfo);
            }
        }
        if (this.E == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View inflate = getLayoutInflater().inflate(R.layout.dialog_listsubtitle, (ViewGroup) null);
            this.I = inflate.findViewById(R.id.loadMore);
            this.J = (TextView) inflate.findViewById(R.id.subtitleTitle);
            builder.setView(inflate);
            builder.setPositiveButton(R.string.close_msg, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    SourceActivity.this.hideWaitingDialog();
                    SourceActivity.this.f32848g.d();
                }
            });
            this.E = builder.create();
            ExpandableListView expandableListView = (ExpandableListView) inflate.findViewById(R.id.subtitle_expand_view);
            this.H = expandableListView;
            expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                /* access modifiers changed from: private */
                public /* synthetic */ void d(MovieInfo movieInfo, SubtitleInfo subtitleInfo) throws Exception {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(subtitleInfo);
                    SourceActivity.this.f32864w.A(new PlayerHelper.PlayData(SourceActivity.this.f32845d, SourceActivity.this.F, SourceActivity.this.f32843b, arrayList, movieInfo));
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void e(Throwable th) throws Exception {
                    Utils.i0(SourceActivity.this, th.getMessage());
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void f() throws Exception {
                }

                public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
                    final SubtitleInfo subtitleInfo = (SubtitleInfo) SourceActivity.this.G.getChild(i2, i3);
                    SourceActivity.this.E.dismiss();
                    final boolean z02 = SourceActivity.this.z0();
                    Utils.i0(SourceActivity.this, "Repairing subtitle....");
                    SourceActivity.this.f32857p.b(Observable.create(new ObservableOnSubscribe<SubtitleInfo>() {
                        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0021, code lost:
                            r0 = r1;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public void subscribe(io.reactivex.ObservableEmitter<com.utils.subtitle.SubtitleInfo> r4) throws java.lang.Exception {
                            /*
                                r3 = this;
                                boolean r0 = r2
                                if (r0 == 0) goto L_0x0015
                                com.utils.subtitle.SubtitleInfo r0 = r1
                                java.lang.String r1 = r0.f37703c
                                r2 = 1
                                java.lang.String r1 = com.utils.subtitle.services.SubServiceBase.c(r1, r2)
                                r0.f37703c = r1
                                com.utils.subtitle.SubtitleInfo r0 = r1
                                r4.onNext(r0)
                                goto L_0x0042
                            L_0x0015:
                                com.utils.subtitle.SubtitleInfo r0 = r1
                                java.lang.String r0 = r0.f37703c
                                java.lang.String r1 = ".zip"
                                boolean r0 = r0.endsWith(r1)
                                if (r0 != 0) goto L_0x0032
                                com.utils.subtitle.SubtitleInfo r0 = r1
                                com.utils.subtitle.SubtitleInfo$Source r1 = r0.f37706f
                                com.utils.subtitle.SubtitleInfo$Source r2 = com.utils.subtitle.SubtitleInfo.Source.OpenSubtitleRest
                                if (r1 == r2) goto L_0x0032
                                com.utils.subtitle.SubtitleInfo$Source r2 = com.utils.subtitle.SubtitleInfo.Source.SubDL
                                if (r1 != r2) goto L_0x002e
                                goto L_0x0032
                            L_0x002e:
                                r4.onNext(r0)
                                goto L_0x0042
                            L_0x0032:
                                com.utils.subtitle.SubtitleInfo r0 = r1
                                java.lang.String r1 = r0.f37703c
                                r2 = 0
                                java.lang.String r1 = com.utils.subtitle.services.SubServiceBase.c(r1, r2)
                                r0.f37703c = r1
                                com.utils.subtitle.SubtitleInfo r0 = r1
                                r4.onNext(r0)
                            L_0x0042:
                                r4.onComplete()
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.sources.SourceActivity.AnonymousClass7.AnonymousClass1.subscribe(io.reactivex.ObservableEmitter):void");
                        }
                    }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new i0(this, movieInfo), new j0(this), new k0()));
                    return true;
                }
            });
        }
        ExpandableListSubtitleAdapter expandableListSubtitleAdapter = new ExpandableListSubtitleAdapter(this, this.D);
        this.G = expandableListSubtitleAdapter;
        this.H.setAdapter(expandableListSubtitleAdapter);
        if (this.D.keySet().size() == 1) {
            this.H.expandGroup(0);
        }
        this.E.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                Logger.b("openSubtitleLoginDialog", "OnCancelListener");
                SourceActivity.this.hideWaitingDialog();
                SourceActivity.this.f32848g.d();
            }
        });
        this.J.setText(String.format("%d subtitles found", new Object[]{Integer.valueOf(y0())}));
        this.E.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N0(Throwable th) throws Exception {
        hideWaitingDialog();
        Utils.h0(this, R.string.not_subtitle_found);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0() throws Exception {
        View view;
        if (!(this.E == null || (view = this.I) == null)) {
            view.setVisibility(8);
        }
        if (this.D.size() <= 0) {
            Utils.i0(this, "No subtitles found");
        }
        hideWaitingDialog();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean S0(MediaSource mediaSource) throws Exception {
        boolean z2;
        if (mediaSource.isTorrent() || mediaSource.getFileSize() > 0 || mediaSource.isHLS()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!Utils.f37609b) {
            return z2;
        }
        if (!mediaSource.isHD() || !z2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean T0(MediaSource mediaSource) throws Exception {
        if (Utils.f37610c) {
            return !mediaSource.getQuality().toLowerCase().contains("cam");
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V0(MovieInfo movieInfo, MediaSource mediaSource) throws Exception {
        this.f32843b.get(0).setResolved(mediaSource.isResolved());
        this.f32843b.get(0).setStreamLink(mediaSource.getStreamLink());
        if (this.f32867z) {
            if (!this.f32845d.getRealeaseDate().isEmpty()) {
                String str = this.f32845d.getRealeaseDate().split("-")[0];
            }
            this.f32846e.tmdbID = this.f32845d.getTmdbID();
            showWaitingDialog("Auto play will get the first subtiles in setting.");
            i1(this.f32846e, this.f32843b.get(0), this.A, this.f32845d.getPosition());
            return;
        }
        this.f32864w.A(new PlayerHelper.PlayData(this.f32845d, this.f32843b.get(0), this.f32843b, (List<? extends SubtitleInfo>) null, movieInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W0(Throwable th) throws Exception {
        Utils.A0(this, th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X0(MovieInfo movieInfo, MediaSource mediaSource) throws Exception {
        if (this.f32865x && (this.f32843b.size() >= this.f32866y || this.f32856o.isDisposed())) {
            this.f32856o.dispose();
            this.f32848g.b(PremiumResolver.p(this.f32843b.get(0)).observeOn(AndroidSchedulers.a()).subscribe(new m(this, movieInfo), new n(this)));
        } else if (!Utils.f37611d) {
            c1(mediaSource);
        } else if (mediaSource.isDebrid()) {
            c1(mediaSource);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y0(Throwable th) throws Exception {
        Logger.d(th, new boolean[0]);
        x0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(MovieInfo movieInfo, MediaSource mediaSource) throws Exception {
        this.f32843b.get(0).setResolved(mediaSource.isResolved());
        this.f32843b.get(0).setStreamLink(mediaSource.getStreamLink());
        if (this.f32867z) {
            if (!this.f32845d.getRealeaseDate().isEmpty()) {
                String str = this.f32845d.getRealeaseDate().split("-")[0];
            }
            this.f32846e.tmdbID = this.f32845d.getTmdbID();
            showWaitingDialog("Auto play will get the first subtiles in setting.");
            i1(this.f32846e, this.f32843b.get(0), this.A, this.f32845d.getPosition());
            return;
        }
        this.f32864w.A(new PlayerHelper.PlayData(this.f32845d, this.f32843b.get(0), this.f32843b, (List<? extends SubtitleInfo>) null, movieInfo));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a1(Throwable th) throws Exception {
        Utils.A0(this, th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b1(MovieInfo movieInfo) throws Exception {
        Logger.b("SOURCEACTIVITY", "ALL = " + BaseProvider.f37247c.length);
        x0();
        if (this.f32865x && !this.f32843b.isEmpty()) {
            if (this.f32843b.size() >= this.f32866y || this.f32856o.isDisposed()) {
                this.f32856o.dispose();
                this.f32848g.b(PremiumResolver.p(this.f32843b.get(0)).observeOn(AndroidSchedulers.a()).subscribe(new o(this, movieInfo), new p(this)));
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d1(Throwable th) throws Exception {
    }

    private void e1() {
        this.f32856o.b(Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                List<CachedTorrentFileEntity> b2 = SourceActivity.this.f32861t.y().b((int) SourceActivity.this.f32845d.getTmdbID(), SourceActivity.this.f32846e.getSession().intValue(), SourceActivity.this.f32846e.getEps().intValue());
                if (b2 != null) {
                    for (CachedTorrentFileEntity next : b2) {
                        boolean z2 = false;
                        MediaSource mediaSource = new MediaSource("UserCachedTorrent", next.h().name(), false);
                        mediaSource.setStreamLink(next.e());
                        mediaSource.setFilename(next.d());
                        if (next.h() == TorrentObject.Type.RD) {
                            z2 = true;
                        }
                        mediaSource.setRealdebrid(z2);
                        observableEmitter.onNext(mediaSource);
                    }
                }
            }
        }).subscribeOn(Schedulers.c()).flatMap(new a0()).observeOn(AndroidSchedulers.a()).subscribe(new b0(this), new c0()));
    }

    private void g1() {
        this.f32850i = new SessionManagerListener<CastSession>() {
            private void a(CastSession castSession) {
                CastSession unused = SourceActivity.this.f32851j = castSession;
                SourceActivity.this.hideWaitingDialog();
                Utils.h0(SourceActivity.this, R.string.cast_connected);
            }

            private void b() {
                CastSession unused = SourceActivity.this.f32851j = null;
                SourceActivity.this.invalidateOptionsMenu();
            }

            /* renamed from: c */
            public void onSessionEnded(CastSession castSession, int i2) {
                b();
            }

            /* renamed from: d */
            public void onSessionEnding(CastSession castSession) {
            }

            /* renamed from: e */
            public void onSessionResumeFailed(CastSession castSession, int i2) {
                b();
            }

            /* renamed from: f */
            public void onSessionResumed(CastSession castSession, boolean z2) {
                a(castSession);
            }

            /* renamed from: g */
            public void onSessionResuming(CastSession castSession, String str) {
            }

            /* renamed from: h */
            public void onSessionStartFailed(CastSession castSession, int i2) {
                b();
            }

            /* renamed from: i */
            public void onSessionStarted(CastSession castSession, String str) {
                a(castSession);
            }

            /* renamed from: j */
            public void onSessionStarting(CastSession castSession) {
            }

            /* renamed from: k */
            public void onSessionSuspended(CastSession castSession, int i2) {
            }
        };
    }

    /* access modifiers changed from: private */
    public void h1() {
        IntroductoryOverlay introductoryOverlay = this.f32853l;
        if (introductoryOverlay != null) {
            introductoryOverlay.remove();
        }
        MenuItem menuItem = this.f32854m;
        if (menuItem != null && menuItem.isVisible()) {
            new Handler().post(new Runnable() {
                public void run() {
                    SourceActivity sourceActivity = SourceActivity.this;
                    IntroductoryOverlay unused = sourceActivity.f32853l = new IntroductoryOverlay.Builder((Activity) sourceActivity, sourceActivity.f32854m).setTitleText(SourceActivity.this.getString(R.string.introducing_cast)).setOverlayColor(R.color.theme_primary).setSingleTime().setOnOverlayDismissedListener(new IntroductoryOverlay.OnOverlayDismissedListener() {
                        public void onOverlayDismissed() {
                            IntroductoryOverlay unused = SourceActivity.this.f32853l = null;
                        }
                    }).build();
                    SourceActivity.this.f32853l.show();
                }
            });
        }
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.B = toolbar;
        if (toolbar == null) {
            Timber.g("Didn't find a toolbar", new Object[0]);
            return;
        }
        ViewCompat.z0(toolbar, getResources().getDimension(R.dimen.toolbar_elevation));
        setSupportActionBar(this.B);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.y(true);
        }
    }

    private void v0(StreamAction.ActionID actionID, MediaSource mediaSource) {
        this.f32848g.b(this.f32860s.f(this.f32845d.getTmdbID(), this.f32845d.getImdbIDStr(), this.f32845d.getTraktID(), this.f32845d.getTvdbID(), this.f32846e.getSession().intValue(), this.f32846e.getEps().intValue()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new q(this), new r(this), new s(this, mediaSource, actionID)));
    }

    /* access modifiers changed from: private */
    public void x0() {
        this.f32856o.dispose();
        ProgressBar progressBar = this.progressbar;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (this.f32843b.size() == 0) {
            this.mViewAnimator.setVisibility(0);
        }
    }

    private int y0() {
        int i2 = 0;
        for (List<SubtitleInfo> size : this.D.values()) {
            i2 += size.size();
        }
        return i2;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        CastContext castContext = this.f32852k;
        if (castContext == null) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (castContext.onDispatchVolumeKeyEventBeforeJellyBean(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        return false;
    }

    /* renamed from: f1 */
    public void c1(MediaSource mediaSource) {
        boolean z2;
        Iterator<MediaSource> it2 = this.f32843b.iterator();
        while (true) {
            if (it2.hasNext()) {
                if (it2.next().getStreamLink().equals(mediaSource.getStreamLink())) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (!z2) {
            this.f32843b.add(mediaSource);
            this.f32844c.e();
        }
        Toolbar toolbar = this.B;
        toolbar.setSubtitle((CharSequence) this.f32846e.session + "x" + this.f32846e.eps + " (" + this.f32843b.size() + " streams found)");
        if (this.f32843b.size() >= Utils.f37608a) {
            this.f32856o.dispose();
            this.progressbar.setVisibility(4);
        }
    }

    public void i1(MovieInfo movieInfo, MediaSource mediaSource, String str, long j2) {
        movieInfo.tmdbID = this.f32845d.getTmdbID();
        movieInfo.imdbIDStr = this.f32845d.getImdbIDStr();
        movieInfo.fileName = mediaSource.getFilename();
        this.f32848g.b(SubServiceBase.g(movieInfo, this.f32862u, this.f32864w.x()).observeOn(AndroidSchedulers.a()).subscribe(new t(this, mediaSource, movieInfo), new u(this, mediaSource, movieInfo)));
    }

    public void j1(MovieInfo movieInfo) {
        AlertDialog alertDialog;
        movieInfo.tmdbID = this.f32845d.getTmdbID();
        movieInfo.imdbIDStr = this.f32845d.getImdbIDStr();
        movieInfo.fileName = this.F.getFilename();
        this.D = new HashMap();
        showWaitingDialog("");
        if (!this.D.isEmpty() && (alertDialog = this.E) != null) {
            alertDialog.show();
        }
        View view = this.I;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f32848g.b(SubServiceBase.g(movieInfo, this.f32862u, this.f32864w.x()).observeOn(AndroidSchedulers.a()).subscribe(new v(this, movieInfo), new x(this), new y(this)));
    }

    public void k1(MovieInfo movieInfo) {
        movieInfo.tmdbID = this.f32845d.getTmdbID();
        this.progressbar.setVisibility(0);
        this.mViewAnimator.setVisibility(8);
        Utils.f37609b = FreeMoviesApp.p().getBoolean("pref_show_hd_only", false);
        Utils.f37612e = Utils.d0();
        Utils.f37610c = FreeMoviesApp.p().getBoolean("pref_filter_cam", false);
        Utils.f37611d = FreeMoviesApp.p().getBoolean("pref_show_debrid_only", false);
        Utils.n();
        List<BaseProvider> x2 = Utils.x();
        int g2 = Utils.g();
        this.f32856o.b(Observable.fromIterable(x2).flatMap(new d0(movieInfo), g2).filter(new f0()).flatMap(new b(), g2).map(new c()).flatMap(new d()).filter(new e()).filter(new f()).map(new g()).observeOn(AndroidSchedulers.a()).subscribe(new h(this, movieInfo), new i(this), new e0(this, movieInfo)));
    }

    public void l1(MediaSource mediaSource) {
        if (mediaSource.isHD()) {
            this.f32856o.b(BaseResolver.m(mediaSource).subscribeOn(Schedulers.c()).flatMap(new d()).observeOn(AndroidSchedulers.a()).subscribe(new j(this), new k()));
        }
    }

    public void o(MediaSource mediaSource) {
        mediaSource.setMovieName(this.f32846e.name + "(" + this.f32846e.getYear() + ")");
        this.f32846e.tempStreamLink = mediaSource.getStreamLink();
        this.f32846e.extension = mediaSource.getExtension();
        this.f32846e.fileSizeString = mediaSource.getFileSizeString();
        this.f32846e.tmdbID = this.f32845d.getTmdbID();
        this.f32846e.imdbIDStr = this.f32845d.getImdbIDStr();
        if (mediaSource.getFileSize() > Utils.J() - 100000) {
            Utils.i0(this, "No space left on device!!");
            return;
        }
        try {
            DownloadDialog.I(mediaSource, this.f32846e, this.f32845d.getTmdbID()).show(getSupportFragmentManager(), "downloadDialog");
        } catch (Exception unused) {
            Utils.h0(this, R.string.could_not_setup_download_menu);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_source);
        this.f32864w.V(this);
        this.f32848g = new CompositeDisposable();
        this.f32856o = new CompositeDisposable();
        this.f32857p = new CompositeDisposable();
        this.f32849h = new CompositeDisposable();
        this.f32848g.b(this.f32856o);
        this.f32848g.b(this.f32857p);
        ArrayList<MediaSource> arrayList = this.f32843b;
        if (arrayList == null || arrayList.isEmpty()) {
            this.f32843b = new ArrayList<>();
        }
        this.lvSources.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                SourceActivity sourceActivity = SourceActivity.this;
                if (!sourceActivity.f32858q) {
                    CompositeDisposable e02 = sourceActivity.f32849h;
                    SourceActivity sourceActivity2 = SourceActivity.this;
                    FreeMoviesApp.x(e02, sourceActivity2.f32859r, sourceActivity2.f32846e, SourceActivity.this.f32843b);
                    SourceActivity.this.f32858q = true;
                }
                SourceActivity sourceActivity3 = SourceActivity.this;
                PlayerHelper playerHelper = sourceActivity3.f32864w;
                ArrayList<MediaSource> arrayList = sourceActivity3.f32843b;
                playerHelper.a0(sourceActivity3, arrayList, arrayList.get(i2));
                SourceActivity.this.x0();
            }
        });
        this.lvSources.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void c(int i2, AlertDialog.Builder builder, MediaSource mediaSource) throws Exception {
                SourceActivity.this.f32843b.get(i2).setResolved(mediaSource.isResolved());
                SourceActivity.this.f32843b.get(i2).setStreamLink(mediaSource.getStreamLink());
                String filename = SourceActivity.this.f32843b.get(i2).getFilename();
                if (filename == null) {
                    filename = URLUtil.guessFileName(SourceActivity.this.f32843b.get(i2).getStreamLink(), (String) null, (String) null);
                }
                builder.g(filename);
                builder.l("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder.q();
                SourceActivity.this.hideWaitingDialog();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void d(Throwable th) throws Exception {
                SourceActivity.this.hideWaitingDialog();
                if (th instanceof NeedTimeAddToDeb) {
                    Utils.y0(SourceActivity.this, "Download in Progress", th.getMessage(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent(SourceActivity.this, MainActivity.class);
                            intent.putExtra("GotNavID", NavIds.NAV_TORRENT_MANAGER.name());
                            SourceActivity.this.startActivity(intent);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                    return;
                }
                SourceActivity sourceActivity = SourceActivity.this;
                String message = th.getMessage();
                Objects.requireNonNull(message);
                Utils.A0(sourceActivity, message);
            }

            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SourceActivity.this);
                builder.setTitle("File Name :");
                MediaSource mediaSource = SourceActivity.this.f32843b.get(i2);
                if (!mediaSource.isResolved()) {
                    SourceActivity.this.showWaitingDialog("resolving file name...");
                    SourceActivity.this.f32848g.b(PremiumResolver.p(mediaSource).observeOn(AndroidSchedulers.a()).subscribe(new g0(this, i2, builder), new h0(this)));
                    return true;
                }
                String filename = mediaSource.getFilename();
                if (filename == null) {
                    filename = URLUtil.guessFileName(mediaSource.getStreamLink(), (String) null, (String) null);
                }
                builder.g(filename);
                builder.l("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder.q();
                return true;
            }
        });
        MediaSourceArrayAdapter mediaSourceArrayAdapter = new MediaSourceArrayAdapter(this, R.layout.item_source, this.f32843b);
        this.f32844c = mediaSourceArrayAdapter;
        mediaSourceArrayAdapter.d(this);
        this.lvSources.setAdapter(this.f32844c);
        Bundle extras = getIntent().getExtras();
        if (extras.getString("LINKID") == null) {
            str = "";
        } else {
            str = extras.getString("LINKID");
        }
        this.f32847f = str;
        if (extras.getBoolean("isFromAnotherApp")) {
            this.f32845d = (MovieEntity) new Gson().l(extras.getString("Movie"), MovieEntity.class);
            this.f32846e = (MovieInfo) new Gson().l(extras.getString("MovieInfo"), MovieInfo.class);
        } else {
            this.f32845d = (MovieEntity) extras.getParcelable("Movie");
            this.f32846e = (MovieInfo) extras.getParcelable("MovieInfo");
        }
        w0(extras);
        k1(this.f32846e);
        if (BaseProvider.v()) {
            e1();
        }
        if (!DeviceUtils.b()) {
            AdsManager.d().o(this.adViewFrameLayout);
        }
        setupToolbar();
        if (this.B != null) {
            if (this.f32845d.getTV().booleanValue()) {
                this.B.setTitle((CharSequence) this.f32845d.getName());
                Toolbar toolbar = this.B;
                toolbar.setSubtitle((CharSequence) this.f32846e.session + "x" + this.f32846e.eps);
            } else {
                Toolbar toolbar2 = this.B;
                toolbar2.setTitle((CharSequence) this.f32845d.getName() + " " + this.f32845d.getRealeaseDate().split("-")[0]);
            }
            this.B.setNavigationOnClickListener(new a(this));
        }
        if (Utils.f0()) {
            try {
                g1();
                CastContext sharedInstance = CastContext.getSharedInstance(this);
                this.f32852k = sharedInstance;
                this.f32851j = sharedInstance.getSessionManager().getCurrentCastSession();
                this.f32855n = new CastStateListener() {
                    public void onCastStateChanged(int i2) {
                        if (i2 != 1) {
                            SourceActivity.this.h1();
                        }
                    }
                };
            } catch (Exception unused) {
                this.f32852k = null;
            }
        }
        this.f32865x = FreeMoviesApp.p().getBoolean("pref_auto_next_eps", false);
        this.f32866y = Integer.valueOf(FreeMoviesApp.p().getString("pref_auto_next_eps_number_of_link", "10")).intValue();
        this.f32867z = FreeMoviesApp.p().getBoolean("pref_auto_next_with_fisrt_sub", false);
        this.A = FreeMoviesApp.p().getString("auto_play_next_with_last_sub_language", "eng");
        this.f32864w.H(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.activity_source, menu);
        this.f32854m = CastButtonFactory.setUpMediaRouteButton(getApplicationContext(), menu, R.id.media_route_menu_item);
        h1();
        CheckBox checkBox = (CheckBox) menu.findItem(R.id.auto_play_next).getActionView();
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                boolean unused = SourceActivity.this.f32865x = z2;
                FreeMoviesApp.p().edit().putBoolean("pref_auto_next_eps", z2).apply();
                if (z2) {
                    SourceActivity sourceActivity = SourceActivity.this;
                    String string = FreeMoviesApp.p().getString("pref_auto_next_eps_number_of_link", "10");
                    Objects.requireNonNull(string);
                    int unused2 = sourceActivity.f32866y = Integer.parseInt(string);
                    Utils.i0(SourceActivity.this, String.format(SourceActivity.this.getString(R.string.auto_play_next), new Object[]{Integer.valueOf(SourceActivity.this.f32866y)}));
                }
            }
        });
        checkBox.setChecked(this.f32865x);
        checkBox.setText("Auto play");
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32848g.d();
        this.f32848g.dispose();
        this.f32849h.dispose();
        this.f32858q = false;
        HttpHelper.i().k();
        Utils.t0();
        if (this.K != null && RealDebridCredentialsHelper.d().isValid()) {
            Utils.h(this.K);
        }
        OkHttpClient okHttpClient = ZeroTV.f37508g;
        if (okHttpClient != null) {
            Utils.h(okHttpClient);
        }
        this.f32864w.z();
        BaseProvider.G();
        hideWaitingDialog();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.auto_play_next) {
            FreeMoviesApp.p().getBoolean("pref_auto_next_eps", false);
            return true;
        }
        if (itemId == R.id.add_rd_magnet) {
            this.f32856o.dispose();
            HttpHelper.i().k();
            AddMagnetDialog O0 = AddMagnetDialog.O0(this.f32845d, this.f32846e);
            FragmentTransaction n2 = getSupportFragmentManager().n();
            Fragment i02 = getSupportFragmentManager().i0("fragment_add_magnet");
            if (i02 != null) {
                n2.o(i02);
            }
            n2.g((String) null);
            O0.show(n2, "fragment_add_magnet");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        CastContext castContext;
        if (Utils.f0() && (castContext = this.f32852k) != null) {
            castContext.getSessionManager().removeSessionManagerListener(this.f32850i, CastSession.class);
            this.f32852k.removeCastStateListener(this.f32855n);
        }
        x0();
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        CastContext castContext;
        if (this.f32863v) {
            AdsManager.d().p(this);
            this.f32863v = false;
        }
        if (Utils.f0() && (castContext = this.f32852k) != null) {
            castContext.getSessionManager().addSessionManagerListener(this.f32850i, CastSession.class);
            this.f32852k.addCastStateListener(this.f32855n);
            CastSession castSession = this.f32851j;
            if (castSession == null || !castSession.isConnected()) {
                Log.i("MOVIES_TAG", "CAST SESSION RESUME DIS_CONNECTED");
            } else {
                Log.i("MOVIES_TAG", "CAST SESSION RESUME CONNECTED");
            }
        }
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        HttpHelper.i().z(HttpHelper.f33895d);
        hideWaitingDialog();
        super.onStop();
    }

    public void s(StreamAction.ActionID actionID, MediaSource mediaSource) {
        showWaitingDialog("");
        if (mediaSource.isResolved()) {
            v0(actionID, mediaSource);
        } else {
            this.f32848g.b(PremiumResolver.p(mediaSource).observeOn(AndroidSchedulers.a()).subscribe(new l(this, mediaSource, actionID), new w(this), new z()));
        }
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().l(this);
    }

    public void w0(Bundle bundle) {
        ArrayList<Video> parcelableArrayList = bundle.getParcelableArrayList("STREAM");
        if (parcelableArrayList != null) {
            for (Video video : parcelableArrayList) {
                String site = video.getSite();
                if (!site.isEmpty()) {
                    if (GoogleVideoHelper.n(site)) {
                        MediaSource mediaSource = new MediaSource("Cinema", "GoogleVideo Video", false);
                        mediaSource.setStreamLink(video.getSite());
                        mediaSource.setQuality(video.getSize() + ContextChain.TAG_PRODUCT);
                        l1(mediaSource);
                    } else {
                        MediaSource mediaSource2 = new MediaSource("Cinema", "Unknow CDN", true);
                        mediaSource2.setQuality("");
                        mediaSource2.setStreamLink(video.getSite());
                        l1(mediaSource2);
                    }
                }
            }
        }
    }

    public void x(boolean z2) {
        if (!z2) {
            this.f32863v = true;
        } else if (FreeMoviesApp.p().getBoolean("pref_auto_next_eps", false)) {
            this.f32844c.clear();
            int parseInt = Integer.parseInt(this.f32846e.eps);
            MovieInfo movieInfo = this.f32846e;
            if (parseInt < movieInfo.epsCount) {
                movieInfo.eps = String.valueOf(Integer.parseInt(movieInfo.eps) + 1);
                CompositeDisposable compositeDisposable = new CompositeDisposable();
                this.f32856o = compositeDisposable;
                this.f32848g.b(compositeDisposable);
                this.f32846e.tmdbID = this.f32845d.getTmdbID();
                this.f32845d.setPosition(0);
                k1(this.f32846e);
                if (this.B == null) {
                    return;
                }
                if (this.f32845d.getTV().booleanValue()) {
                    this.B.setTitle((CharSequence) this.f32845d.getName());
                    Toolbar toolbar = this.B;
                    toolbar.setSubtitle((CharSequence) this.f32846e.session + "x" + this.f32846e.eps);
                    return;
                }
                Toolbar toolbar2 = this.B;
                toolbar2.setTitle((CharSequence) this.f32845d.getName() + " " + this.f32845d.getRealeaseDate().split("-")[0]);
                return;
            }
            this.f32863v = true;
            finish();
        } else {
            this.f32863v = true;
        }
    }

    public boolean z0() {
        CastSession castSession = this.f32851j;
        return castSession != null && castSession.isConnected();
    }
}

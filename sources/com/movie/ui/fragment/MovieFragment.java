package com.movie.ui.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;
import com.ads.videoreward.AdsManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.facebook.common.callercontext.ContextChain;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.google.android.material.appbar.AppBarLayout;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.tmdb.TMDBApi;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.cinema.Video;
import com.movie.data.model.tmvdb.MovieTMDB;
import com.movie.data.repository.tmdb.TMDBRepositoryImpl;
import com.movie.ui.activity.MainActivity;
import com.movie.ui.activity.sources.c;
import com.movie.ui.activity.sources.d;
import com.movie.ui.adapter.MediaSourceArrayAdapter;
import com.movie.ui.customdialog.AddMagnetDialog;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.I18N;
import com.original.tase.Logger;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.exception.NeedTimeAddToDeb;
import com.original.tase.helper.GoogleVideoHelper;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.StreamAction;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.model.media.MediaSource;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.Getlink.Resolver.BaseResolver;
import com.utils.Getlink.Resolver.premium.PremiumResolver;
import com.utils.NavIds;
import com.utils.PermissionHelper;
import com.utils.PosterCacheHelper;
import com.utils.Utils;
import com.utils.cast.CastHelper;
import com.utils.download.DownloadDialog;
import com.utils.subtitle.ExpandableListSubtitleAdapter;
import com.utils.subtitle.SubtitleInfo;
import com.utils.subtitle.services.SubServiceBase;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.OkHttpClient;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;

public final class MovieFragment extends BaseFragment implements ObservableScrollViewCallbacks, PlayerHelper.Listener, MediaSourceArrayAdapter.Listener {
    private int A = -1;
    boolean B = false;
    boolean C = false;
    Map<String, List<SubtitleInfo>> D = new HashMap();
    private boolean E = false;
    private ProgressDialog F = null;
    /* access modifiers changed from: private */
    public MediaSource G = null;
    private AlertDialog H = null;
    /* access modifiers changed from: private */
    public ExpandableListSubtitleAdapter I = null;
    private ExpandableListView J;
    private View K = null;
    private TextView L = null;
    @BindView(2131361902)
    Button addWatchedListbtn;

    /* renamed from: d  reason: collision with root package name */
    public MediaSourceArrayAdapter f33244d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<MediaSource> f33245e = new ArrayList<>();
    @Inject

    /* renamed from: f  reason: collision with root package name */
    OpenSubtitleV1Api f33246f;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    TMDBRepositoryImpl f33247g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    MvDatabase f33248h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    MoviesApi f33249i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    public TMDBApi f33250j;
    @Inject

    /* renamed from: k  reason: collision with root package name */
    MoviesHelper f33251k;

    /* renamed from: l  reason: collision with root package name */
    AppBarLayout f33252l;
    @BindView(2131362356)
    ListView lvSources;
    @Inject
    @Named("RealDebrid")

    /* renamed from: m  reason: collision with root package name */
    OkHttpClient f33253m;
    @BindColor(2131099706)
    int mColorTextWhite;
    @BindColor(2131100164)
    int mColorThemePrimary;
    @BindView(2131362215)
    FrameLayout mNativeAdHolder;
    @BindView(2131362400)
    TextView mOverview;
    @BindView(2131362401)
    ImageView mPosterImage;
    @BindView(2131362390)
    TextView mRating;
    @BindView(2131362403)
    TextView mReleaseDate;
    @BindView(2131362841)
    Button mTrailerBtn;
    @BindView(2131362228)
    Button mViewAds;
    @BindView(2131362408)
    TextView movie_videos_header;
    @Inject
    @Named("MovieDetailsActivity")

    /* renamed from: n  reason: collision with root package name */
    PlayerHelper f33254n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public CompositeDisposable f33255o;

    /* renamed from: p  reason: collision with root package name */
    private CompositeDisposable f33256p;
    @BindView(2131362547)
    ProgressBar progressBar;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public CompositeDisposable f33257q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public CompositeDisposable f33258r;

    /* renamed from: s  reason: collision with root package name */
    private List<Runnable> f33259s = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public MovieEntity f33260t;

    /* renamed from: u  reason: collision with root package name */
    private List<Video> f33261u;

    /* renamed from: v  reason: collision with root package name */
    private Video f33262v;

    /* renamed from: w  reason: collision with root package name */
    private String f33263w = "";

    /* renamed from: x  reason: collision with root package name */
    private List<Video> f33264x = new ArrayList();

    /* renamed from: y  reason: collision with root package name */
    private ShowcaseView f33265y = null;

    /* renamed from: z  reason: collision with root package name */
    private MenuItem f33266z;

    /* renamed from: com.movie.ui.fragment.MovieFragment$14  reason: invalid class name */
    static /* synthetic */ class AnonymousClass14 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33277a;

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
                f33277a = r0
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.CAST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33277a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.PLAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33277a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.PLAY_WITH_SUBTITLES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f33277a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.CAST_WITH_SUBTITLES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f33277a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.OPEN_WITH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f33277a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f33277a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.COPY_TO_CLIPBOARD     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f33277a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.original.tase.helper.StreamAction$ActionID r1 = com.original.tase.helper.StreamAction.ActionID.OPEN_WITH_PLAYER_PLUGIN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.fragment.MovieFragment.AnonymousClass14.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A0(Throwable th) throws Exception {
        this.f33260t.setPosition(0);
        this.f33260t.setSubtitlepath("");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0(MediaSource mediaSource, StreamAction.ActionID actionID) throws Exception {
        String str;
        this.G = mediaSource;
        mediaSource.setMovieName(this.f33260t.getName());
        if (this.f33260t.getRealeaseDate().isEmpty()) {
            str = "";
        } else {
            str = this.f33260t.getRealeaseDate().split("-")[0];
        }
        MovieInfo movieInfo = new MovieInfo(this.f33260t.getName(), str, "", "", "");
        movieInfo.imdbIDStr = this.f33260t.getImdbIDStr();
        movieInfo.tmdbID = this.f33260t.getTmdbID();
        this.G.isRawTorrent();
        switch (AnonymousClass14.f33277a[actionID.ordinal()]) {
            case 1:
            case 2:
                this.f33254n.A(new PlayerHelper.PlayData(this.f33260t, this.G, this.f33245e, (List<? extends SubtitleInfo>) null, movieInfo));
                return;
            case 3:
            case 4:
                showWaitingDialog("subtitle loading..");
                this.G = this.G.cloneDeeply();
                h1(movieInfo);
                return;
            case 5:
                this.f33254n.F(new PlayerHelper.PlayData(this.f33260t, this.G, this.f33245e, (List<? extends SubtitleInfo>) null, movieInfo));
                return;
            case 6:
                if (!PermissionHelper.a(getActivity())) {
                    ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) new LovelyStandardDialog(getActivity(), LovelyStandardDialog.ButtonLayout.HORIZONTAL).m(R.color.darkDeepOrange)).r(R.color.darkDeepOrange).h(R.drawable.database_24px)).k("Warning")).j(getActivity().getResources().getString(R.string.storage_permission_msg))).u(17039370, new View.OnClickListener() {
                        public void onClick(View view) {
                            PermissionHelper.b(MovieFragment.this.getActivity(), 23321);
                        }
                    }).o();
                    return;
                } else {
                    f1(this.G);
                    return;
                }
            case 7:
                ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Source Text", this.G.getStreamLink()));
                Utils.i0(getActivity(), "copied");
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0(Video.Response response) throws Exception {
        c1(response.videos, response.linkID);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(Throwable th) throws Exception {
        c1((List<Video>) null, "");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E0(MediaSource mediaSource, StreamAction.ActionID actionID, MediaSource mediaSource2) throws Exception {
        mediaSource.setStreamLink(mediaSource2.getStreamLink());
        mediaSource.setResolved(mediaSource2.isResolved());
        t0(actionID, mediaSource);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F0(Throwable th) throws Exception {
        hideWaitingDialog();
        Utils.i0(getActivity(), th.getMessage());
        if (th instanceof NeedTimeAddToDeb) {
            Utils.y0(getActivity(), "Download in Progress", th.getMessage(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Intent intent = new Intent(MovieFragment.this.getActivity(), MainActivity.class);
                    intent.putExtra("GotNavID", NavIds.NAV_TORRENT_MANAGER.name());
                    MovieFragment.this.startActivity(intent);
                }
            }, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        } else {
            Utils.A0(getActivity(), th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(MovieEntity movieEntity) throws Exception {
        boolean z2;
        int i2;
        String str;
        Button button = this.addWatchedListbtn;
        if (movieEntity.getWatched_at() != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        button.setTag(Boolean.valueOf(z2));
        Button button2 = this.addWatchedListbtn;
        if (movieEntity.getWatched_at() != null) {
            i2 = R.drawable.ic_minus;
        } else {
            i2 = R.drawable.adding;
        }
        button2.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        Button button3 = this.addWatchedListbtn;
        if (movieEntity.getWatched_at() != null) {
            str = "Remove from History";
        } else {
            str = "WATCHED";
        }
        button3.setText(str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H0(Throwable th) throws Exception {
        this.addWatchedListbtn.setTag(Boolean.FALSE);
        this.addWatchedListbtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.adding, 0, 0, 0);
        this.addWatchedListbtn.setText("WATCHED");
        I0();
        Logger.a(th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J0(View view) {
        AdsManager.d().p(getActivity());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K0(View view) {
        this.f33251k.i(getActivity(), (Video) view.getTag());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(boolean z2) {
        this.f33266z.setVisible(z2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M0(final MovieInfo movieInfo, ArrayList arrayList) throws Exception {
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                SubtitleInfo subtitleInfo = (SubtitleInfo) it2.next();
                String str = subtitleInfo.f37704d;
                if (!this.D.containsKey(str)) {
                    this.D.put(str, new ArrayList());
                }
                this.D.get(str).add(subtitleInfo);
            }
            if (this.H == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_listsubtitle, (ViewGroup) null);
                this.K = inflate.findViewById(R.id.loadMore);
                this.L = (TextView) inflate.findViewById(R.id.subtitleTitle);
                builder.setView(inflate);
                builder.setPositiveButton(R.string.close_msg, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        MovieFragment.this.hideWaitingDialog();
                        MovieFragment.this.f33257q.d();
                    }
                });
                this.H = builder.create();
                ExpandableListView expandableListView = (ExpandableListView) inflate.findViewById(R.id.subtitle_expand_view);
                this.J = expandableListView;
                expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    /* access modifiers changed from: private */
                    public /* synthetic */ void d(MovieInfo movieInfo, SubtitleInfo subtitleInfo) throws Exception {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(subtitleInfo);
                        MovieFragment.this.f33254n.A(new PlayerHelper.PlayData(MovieFragment.this.f33260t, MovieFragment.this.G, MovieFragment.this.f33245e, arrayList, movieInfo));
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void e(Throwable th) throws Exception {
                        Utils.i0(MovieFragment.this.getActivity(), th.getMessage());
                    }

                    /* access modifiers changed from: private */
                    public static /* synthetic */ void f() throws Exception {
                    }

                    public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
                        final SubtitleInfo subtitleInfo = (SubtitleInfo) MovieFragment.this.I.getChild(i2, i3);
                        final boolean e2 = CastHelper.e(MovieFragment.this.getActivity());
                        Utils.i0(MovieFragment.this.getActivity(), "Repairing subtitle....");
                        MovieFragment.this.f33257q.b(Observable.create(new ObservableOnSubscribe<SubtitleInfo>() {
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
                                throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.fragment.MovieFragment.AnonymousClass12.AnonymousClass1.subscribe(io.reactivex.ObservableEmitter):void");
                            }
                        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new g0(this, movieInfo), new h0(this), new i0()));
                        return true;
                    }
                });
            }
            ExpandableListSubtitleAdapter expandableListSubtitleAdapter = new ExpandableListSubtitleAdapter(getActivity(), this.D);
            this.I = expandableListSubtitleAdapter;
            this.J.setAdapter(expandableListSubtitleAdapter);
            if (this.D.keySet().size() == 1) {
                this.J.expandGroup(0);
            }
            this.H.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    Logger.b("openSubtitleLoginDialog", "OnCancelListener");
                    MovieFragment.this.hideWaitingDialog();
                    MovieFragment.this.f33257q.d();
                }
            });
            this.L.setText(String.format("%d subtitles found", new Object[]{Integer.valueOf(w0())}));
            this.H.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N0(Throwable th) throws Exception {
        G(th.getMessage());
        hideWaitingDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0() throws Exception {
        View view;
        if (!(this.H == null || (view = this.K) == null)) {
            view.setVisibility(8);
        }
        if (!this.f33257q.isDisposed() && this.D.size() <= 0) {
            G("No subtitles found");
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
    public static /* synthetic */ boolean U0(MediaSource mediaSource) throws Exception {
        if (mediaSource.isHLS()) {
            return true;
        }
        if (mediaSource.getQuality().contains("4K") && mediaSource.getFileSize() < 2097152000) {
            return false;
        }
        if (!mediaSource.getQuality().contains("1080") || mediaSource.getFileSize() >= 1097152000) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V0(MediaSource mediaSource) throws Exception {
        if (!Utils.f37611d) {
            X0(mediaSource);
        } else if (mediaSource.isDebrid()) {
            X0(mediaSource);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W0(Throwable th) throws Exception {
        th.printStackTrace();
        v0();
    }

    private void Z0() {
        this.f33256p.b(this.f33247g.k0(this.f33260t.getTmdbID()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new f0(this), new d(this)));
    }

    public static MovieFragment a1(MovieEntity movieEntity) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("arg_movie", movieEntity);
        MovieFragment movieFragment = new MovieFragment();
        movieFragment.setArguments(bundle);
        return movieFragment;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0060 A[EDGE_INSN: B:13:0x0060->B:10:0x0060 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c1(java.util.List<com.movie.data.model.cinema.Video> r3, java.lang.String r4) {
        /*
            r2 = this;
            r2.f33261u = r3
            r2.f33263w = r4
            android.widget.Button r3 = r2.mViewAds
            com.movie.ui.fragment.j r4 = new com.movie.ui.fragment.j
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
            android.view.LayoutInflater.from(r3)
            java.util.List<com.movie.data.model.cinema.Video> r3 = r2.f33261u
            boolean r3 = com.utils.Lists.a(r3)
            if (r3 != 0) goto L_0x0060
            java.util.List<com.movie.data.model.cinema.Video> r3 = r2.f33261u
            java.util.Iterator r3 = r3.iterator()
        L_0x0023:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0060
            java.lang.Object r4 = r3.next()
            com.movie.data.model.cinema.Video r4 = (com.movie.data.model.cinema.Video) r4
            java.lang.String r0 = r4.getType()
            java.lang.String r1 = "Trailer"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0047
            java.lang.String r0 = r4.getType()
            java.lang.String r1 = "YouTube"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0023
        L_0x0047:
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r0 = "Found trailer!"
            timber.log.Timber.b(r0, r3)
            r2.f33262v = r4
            android.widget.Button r3 = r2.mTrailerBtn
            r3.setTag(r4)
            android.widget.Button r3 = r2.mTrailerBtn
            com.movie.ui.fragment.k r4 = new com.movie.ui.fragment.k
            r4.<init>(r2)
            r3.setOnClickListener(r4)
        L_0x0060:
            java.util.List<com.movie.data.model.cinema.Video> r3 = r2.f33264x
            r2.u0(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.fragment.MovieFragment.c1(java.util.List, java.lang.String):void");
    }

    private void g1(boolean z2) {
        this.f33259s.add(new p(this, z2));
        k1();
    }

    private void k1() {
        if (this.f33266z != null) {
            for (Runnable run : this.f33259s) {
                run.run();
            }
            this.f33259s.clear();
        }
    }

    @SuppressLint({"StringFormatMatches"})
    private void s0(MovieEntity movieEntity) {
        this.f33260t = movieEntity;
        this.mRating.setText(getString(R.string.movie_details_rating, movieEntity.getVote()));
        this.mReleaseDate.setText(Utils.F(movieEntity.getRealeaseDate()));
        if (movieEntity.getOverview() == null) {
            this.mOverview.setText("");
        } else if (movieEntity.getOverview().length() <= 197 || !this.mOverview.isFocusable()) {
            this.mOverview.setText(movieEntity.getOverview());
        } else {
            TextView textView = this.mOverview;
            textView.setText(movieEntity.getOverview().substring(0, 197) + "...");
        }
        if (this.mPosterImage == null) {
            return;
        }
        if (movieEntity.getPoster_path() == null || movieEntity.getPoster_path().isEmpty()) {
            String e2 = PosterCacheHelper.d().e(this.f33260t.getTmdbID(), this.f33260t.getTvdbID(), this.f33260t.getImdbIDStr());
            if (e2 == null) {
                this.f33255o.b(this.f33250j.getMovieDetails(movieEntity.getTmdbID(), (String) null).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new h(this), new i()));
                return;
            }
            Glide.u(this).h(e2).a(new RequestOptions().c()).x0(new DrawableTransitionOptions().e()).q0(this.mPosterImage);
            return;
        }
        Glide.u(this).h(movieEntity.getPoster_path()).a(new RequestOptions().c()).x0(new DrawableTransitionOptions().e()).q0(this.mPosterImage);
    }

    private void t0(StreamAction.ActionID actionID, MediaSource mediaSource) {
        this.f33255o.b(this.f33251k.e(this.f33260t.getTmdbID(), this.f33260t.getImdbIDStr(), this.f33260t.getTraktID(), this.f33260t.getTvdbID()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new s(this), new t(this), new u(this, mediaSource, actionID)));
    }

    /* access modifiers changed from: private */
    public void v0() {
        this.f33256p.dispose();
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    private int w0() {
        int i2 = 0;
        for (List<SubtitleInfo> size : this.D.values()) {
            i2 += size.size();
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0(MovieTMDB.ResultsBean resultsBean) throws Exception {
        Glide.u(this).h(resultsBean.getPoster_path()).a(new RequestOptions().c()).x0(new DrawableTransitionOptions().e()).q0(this.mPosterImage);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void y0(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z0(MovieEntity movieEntity) throws Exception {
        this.f33260t.setPosition(movieEntity.getPosition());
        this.f33260t.setSubtitlepath(movieEntity.getSubtitlepath());
    }

    public void A() {
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().c(this);
    }

    /* renamed from: b1 */
    public void X0(MediaSource mediaSource) {
        Logger.b("onAddMediaSouce", mediaSource.toStringAllObjs());
        if (!this.E) {
            this.E = true;
        }
        try {
            this.f33245e.add(mediaSource);
            g1(true);
            this.f33244d.c(mediaSource);
            this.f33244d.e();
            this.f33244d.notifyDataSetChanged();
            TextView textView = this.movie_videos_header;
            textView.setText("Streams: (" + this.f33245e.size() + " found)");
            if (this.f33245e.size() > Utils.f37608a) {
                v0();
            }
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
        }
    }

    /* renamed from: d1 */
    public void I0() {
        this.addWatchedListbtn.setOnClickListener(new View.OnClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void g(String str) throws Exception {
                if (!str.isEmpty()) {
                    Utils.i0(MovieFragment.this.getActivity(), str);
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void h(Throwable th) throws Exception {
                Utils.i0(MovieFragment.this.getActivity(), th.getMessage());
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void i() throws Exception {
                if (MovieFragment.this.addWatchedListbtn.getTag() == null || !((Boolean) MovieFragment.this.addWatchedListbtn.getTag()).booleanValue()) {
                    MovieFragment.this.addWatchedListbtn.setTag(Boolean.TRUE);
                    MovieFragment.this.addWatchedListbtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_minus, 0, 0, 0);
                    MovieFragment.this.addWatchedListbtn.setText("Remove from History");
                    return;
                }
                MovieFragment.this.addWatchedListbtn.setTag(Boolean.FALSE);
                MovieFragment.this.addWatchedListbtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.adding, 0, 0, 0);
                MovieFragment.this.addWatchedListbtn.setText("WATCHED");
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void j(String str) throws Exception {
                Utils.i0(MovieFragment.this.getActivity(), str);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void k(Throwable th) throws Exception {
                Utils.i0(MovieFragment.this.getActivity(), th.getMessage());
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void l() throws Exception {
                if (MovieFragment.this.addWatchedListbtn.getTag() == null || !((Boolean) MovieFragment.this.addWatchedListbtn.getTag()).booleanValue()) {
                    MovieFragment.this.addWatchedListbtn.setTag(Boolean.TRUE);
                    MovieFragment.this.addWatchedListbtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_minus, 0, 0, 0);
                    MovieFragment.this.addWatchedListbtn.setText("Remove from History");
                    return;
                }
                MovieFragment.this.addWatchedListbtn.setTag(Boolean.FALSE);
                MovieFragment.this.addWatchedListbtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.adding, 0, 0, 0);
                MovieFragment.this.addWatchedListbtn.setText("WATCHED");
            }

            public void onClick(View view) {
                OffsetDateTime offsetDateTime;
                MovieEntity l02 = MovieFragment.this.f33260t;
                if (MovieFragment.this.f33260t.getWatched_at() == null) {
                    offsetDateTime = OffsetDateTime.now((ZoneId) ZoneOffset.UTC);
                } else {
                    offsetDateTime = null;
                }
                l02.setWatched_at(offsetDateTime);
                if (MovieFragment.this.f33260t.getWatched_at() != null) {
                    CompositeDisposable o02 = MovieFragment.this.f33255o;
                    MovieFragment movieFragment = MovieFragment.this;
                    o02.b(movieFragment.f33251k.k(movieFragment.f33260t, true).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new l0(this), new m0(this), new n0(this)));
                    return;
                }
                CompositeDisposable o03 = MovieFragment.this.f33255o;
                MovieFragment movieFragment2 = MovieFragment.this;
                o03.b(movieFragment2.f33251k.c(movieFragment2.f33260t).observeOn(AndroidSchedulers.a()).subscribe(new o0(this), new p0(this), new q0(this)));
            }
        });
    }

    public void e1(AppBarLayout appBarLayout) {
        this.f33252l = appBarLayout;
    }

    public void f1(MediaSource mediaSource) {
        String str;
        if (this.f33260t.getRealeaseDate().isEmpty()) {
            str = "";
        } else {
            str = this.f33260t.getRealeaseDate().split("-")[0];
        }
        MovieInfo movieInfo = new MovieInfo(this.f33260t.getName(), str, "", "", "");
        mediaSource.setMovieName(this.f33260t.getName() + "(" + movieInfo.getYear() + ")");
        movieInfo.tempStreamLink = mediaSource.getStreamLink();
        movieInfo.extension = mediaSource.getExtension();
        movieInfo.cinemaID = this.f33260t.getTmdbID();
        movieInfo.fileSizeString = mediaSource.getFileSizeString();
        movieInfo.tmdbID = this.f33260t.getTmdbID();
        movieInfo.imdbIDStr = this.f33260t.getImdbIDStr();
        movieInfo.tmdbID = this.f33260t.getTmdbID();
        if (mediaSource.getFileSize() > Utils.J() - 100000) {
            Utils.i0(getActivity(), "No space left on device!!");
            return;
        }
        try {
            DownloadDialog.I(mediaSource, movieInfo, this.f33260t.getTmdbID()).show(getActivity().getSupportFragmentManager(), "downloadDialog");
        } catch (Exception e2) {
            Utils.h0(getActivity(), R.string.could_not_setup_download_menu);
            e2.printStackTrace();
        }
    }

    public void h1(MovieInfo movieInfo) {
        movieInfo.tmdbID = this.f33260t.getTmdbID();
        movieInfo.imdbIDStr = this.f33260t.getImdbIDStr();
        movieInfo.cinemaID = this.f33260t.getTmdbID();
        this.D.clear();
        View view = this.K;
        if (view != null) {
            view.setVisibility(0);
        }
        this.f33257q.b(SubServiceBase.g(movieInfo, this.f33246f, this.f33254n.x()).observeOn(AndroidSchedulers.a()).subscribe(new v(this, movieInfo), new w(this), new x(this)));
    }

    public void hideWaitingDialog() {
        ProgressDialog progressDialog = this.F;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void i1(MovieInfo movieInfo) {
        movieInfo.tmdbID = this.f33260t.getTmdbID();
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(0);
        }
        Utils.f37609b = FreeMoviesApp.p().getBoolean("pref_show_hd_only", false);
        Utils.f37612e = Utils.d0();
        Utils.f37610c = FreeMoviesApp.p().getBoolean("pref_filter_cam", false);
        Utils.f37611d = FreeMoviesApp.p().getBoolean("pref_show_debrid_only", false);
        Utils.n();
        List<BaseProvider> x2 = Utils.x();
        int g2 = Utils.g();
        this.f33256p.b(Observable.fromIterable(x2).flatMap(new c(movieInfo), g2).filter(new y()).flatMap(new z(), g2).map(new c()).flatMap(new d()).filter(new a0()).filter(new b0()).filter(new c0()).observeOn(AndroidSchedulers.a()).subscribe(new d0(this), new e0(this), new n(this)));
    }

    public void j1(MediaSource mediaSource) {
        this.f33256p.b(BaseResolver.m(mediaSource).subscribeOn(Schedulers.c()).flatMap(new q()).observeOn(AndroidSchedulers.a()).subscribe(new r(this)));
    }

    public void o(MediaSource mediaSource) {
        String str;
        if (this.f33260t.getRealeaseDate().isEmpty()) {
            str = "";
        } else {
            str = this.f33260t.getRealeaseDate().split("-")[0];
        }
        MovieInfo movieInfo = new MovieInfo(this.f33260t.getName(), str, "", "", "");
        movieInfo.imdbIDStr = this.f33260t.getImdbIDStr();
        movieInfo.tmdbID = this.f33260t.getTmdbID();
        mediaSource.setMovieName(this.f33260t.getName() + "(" + movieInfo.getYear() + ")");
        movieInfo.tempStreamLink = mediaSource.getStreamLink();
        movieInfo.extension = mediaSource.getExtension();
        movieInfo.cinemaID = this.f33260t.getTmdbID();
        movieInfo.fileSizeString = mediaSource.getFileSizeString();
        if (mediaSource.getFileSize() > Utils.J() - 100000) {
            Utils.i0(getActivity(), "No space left on device!!");
            return;
        }
        try {
            DownloadDialog.I(mediaSource, movieInfo, this.f33260t.getTmdbID()).show(getActivity().getSupportFragmentManager(), "downloadDialog");
        } catch (Exception unused) {
            Utils.h0(getActivity(), R.string.could_not_setup_download_menu);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        setHasOptionsMenu(true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_movie_fragment, menu);
        menu.findItem(R.id.add_rd_magnet).setVisible(RealDebridCredentialsHelper.d().isValid());
        MenuItem findItem = menu.findItem(R.id.menu_favorite);
        if (this.f33260t.getCollected_at() == null) {
            findItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_border));
        } else {
            findItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_full));
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_movie, viewGroup, false);
    }

    public void onDestroyView() {
        this.f33255o.d();
        this.f33255o.dispose();
        this.f33257q.dispose();
        this.B = false;
        Utils.t0();
        if (this.f33253m != null && RealDebridCredentialsHelper.d().isValid()) {
            Utils.h(this.f33253m);
        }
        super.onDestroyView();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        String str;
        boolean z2 = false;
        if (menuItem.getItemId() == R.id.add_rd_magnet) {
            this.f33256p.dispose();
            HttpHelper.i().k();
            if (this.f33260t.getRealeaseDate() == null || this.f33260t.getRealeaseDate().isEmpty()) {
                str = "";
            } else {
                str = this.f33260t.getRealeaseDate().split("-")[0];
            }
            MovieInfo movieInfo = new MovieInfo(this.f33260t.getName(), str, "", "", "", this.f33260t.getGenres());
            movieInfo.imdbIDStr = this.f33260t.getImdbIDStr();
            movieInfo.tmdbID = this.f33260t.getTmdbID();
            AddMagnetDialog O0 = AddMagnetDialog.O0(this.f33260t, movieInfo);
            FragmentTransaction n2 = getActivity().getSupportFragmentManager().n();
            Fragment i02 = getActivity().getSupportFragmentManager().i0("fragment_add_magnet");
            if (i02 != null) {
                n2.o(i02);
            }
            n2.g((String) null);
            O0.show(n2, "fragment_add_magnet");
        }
        if (menuItem.getItemId() != R.id.menu_favorite) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.f33260t.getCollected_at() == null) {
            this.f33260t.setCollected_at(OffsetDateTime.now((ZoneId) ZoneOffset.UTC));
        } else {
            this.f33260t.setCollected_at((OffsetDateTime) null);
        }
        MoviesHelper moviesHelper = this.f33251k;
        FragmentActivity activity = getActivity();
        MovieEntity movieEntity = this.f33260t;
        if (movieEntity.getCollected_at() != null) {
            z2 = true;
        }
        moviesHelper.m(activity, movieEntity, z2);
        if (this.f33260t.getCollected_at() == null) {
            menuItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_border));
        } else {
            menuItem.setIcon(getResources().getDrawable(R.drawable.ic_favorite_full));
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131362400})
    public void onOverviewClick() {
        new AlertDialog.Builder(getActivity()).g(this.f33260t.getOverview()).l(I18N.a(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).q();
    }

    public void onPause() {
        v0();
        super.onPause();
    }

    public void onResume() {
        if (this.C) {
            AdsManager.d().p(getActivity());
            this.C = false;
        }
        if (GlobalVariable.c().b().getAds() != null) {
            this.mViewAds.setVisibility(0);
            this.mViewAds.setText("Watch Video");
        } else {
            this.mViewAds.setVisibility(8);
        }
        this.f33255o.b(this.f33251k.d(this.f33260t.getTmdbID(), this.f33260t.getImdbIDStr(), this.f33260t.getTraktID(), this.f33260t.getTvdbID()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e(this), new f(this), new g(this)));
        super.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        ArrayList<MediaSource> arrayList = this.f33245e;
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList<MediaSource> arrayList2 = this.f33245e;
            bundle.putParcelableArrayList("arrayMediaSource", new ArrayList(arrayList2.subList(0, Math.min(arrayList2.size(), 20))));
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(final View view, Bundle bundle) {
        String str;
        super.onViewCreated(view, bundle);
        this.f33255o = new CompositeDisposable();
        this.f33256p = new CompositeDisposable();
        this.f33258r = new CompositeDisposable();
        this.f33257q = new CompositeDisposable();
        this.f33255o.b(this.f33256p);
        this.f33255o.b(this.f33258r);
        MovieEntity movieEntity = (MovieEntity) getArguments().getParcelable("arg_movie");
        if (movieEntity != null) {
            s0(movieEntity);
        }
        if (bundle != null) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("arrayMediaSource");
            if (parcelableArrayList != null) {
                this.f33245e.clear();
                this.f33245e.addAll(parcelableArrayList);
                this.f33244d = new MediaSourceArrayAdapter(getActivity(), R.layout.item_source, this.f33245e);
            }
        } else {
            if (this.f33260t.getRealeaseDate() == null || this.f33260t.getRealeaseDate().isEmpty()) {
                str = "";
            } else {
                str = this.f33260t.getRealeaseDate().split("-")[0];
            }
            MovieInfo movieInfo = new MovieInfo(this.f33260t.getName(), str, "", "", "", this.f33260t.getGenres());
            movieInfo.imdbIDStr = this.f33260t.getImdbIDStr();
            movieInfo.tmdbID = this.f33260t.getTmdbID();
            i1(movieInfo);
        }
        List<Video> list = this.f33261u;
        if (list != null) {
            c1(list, this.f33263w);
        } else {
            Z0();
        }
        this.f33254n.V(this);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
        this.lvSources.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                MediaSource mediaSource = (MediaSource) MovieFragment.this.f33245e.get(i2);
                mediaSource.setPlayed(true);
                Collections.sort(MovieFragment.this.f33245e);
                MovieFragment movieFragment = MovieFragment.this;
                movieFragment.f33254n.a0(movieFragment.getActivity(), MovieFragment.this.f33245e, mediaSource);
                if (!MovieFragment.this.B) {
                    MovieInfo movieInfo = new MovieInfo("", "", "-1", "-1", "");
                    movieInfo.imdbIDStr = MovieFragment.this.f33260t.getImdbIDStr();
                    movieInfo.tmdbID = MovieFragment.this.f33260t.getTmdbID();
                    CompositeDisposable m02 = MovieFragment.this.f33258r;
                    MovieFragment movieFragment2 = MovieFragment.this;
                    FreeMoviesApp.x(m02, movieFragment2.f33249i, movieInfo, movieFragment2.f33245e);
                    MovieFragment.this.B = true;
                }
                MovieFragment.this.v0();
            }
        });
        this.lvSources.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void c(int i2, AlertDialog.Builder builder, MediaSource mediaSource) throws Exception {
                ((MediaSource) MovieFragment.this.f33245e.get(i2)).setResolved(mediaSource.isResolved());
                ((MediaSource) MovieFragment.this.f33245e.get(i2)).setStreamLink(mediaSource.getStreamLink());
                String filename = ((MediaSource) MovieFragment.this.f33245e.get(i2)).getFilename();
                if (filename == null) {
                    filename = URLUtil.guessFileName(((MediaSource) MovieFragment.this.f33245e.get(i2)).getStreamLink(), (String) null, (String) null);
                }
                builder.g(filename);
                builder.l("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        dialogInterface.dismiss();
                    }
                });
                builder.q();
                MovieFragment.this.hideWaitingDialog();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void d(Throwable th) throws Exception {
                MovieFragment.this.hideWaitingDialog();
                Utils.i0(MovieFragment.this.getActivity(), th.getMessage());
                if (th instanceof NeedTimeAddToDeb) {
                    Utils.y0(MovieFragment.this.getActivity(), "Download in Progress", th.getMessage(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            Intent intent = new Intent(MovieFragment.this.getActivity(), MainActivity.class);
                            intent.putExtra("GotNavID", NavIds.NAV_TORRENT_MANAGER.name());
                            MovieFragment.this.startActivity(intent);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    });
                } else {
                    Utils.A0(MovieFragment.this.getActivity(), th.getMessage());
                }
            }

            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MovieFragment.this.getActivity());
                builder.setTitle("File Name :");
                MediaSource mediaSource = (MediaSource) MovieFragment.this.f33245e.get(i2);
                if (!mediaSource.isResolved()) {
                    MovieFragment.this.showWaitingDialog("Resolving file name...");
                    MovieFragment.this.f33255o.b(PremiumResolver.p(mediaSource).observeOn(AndroidSchedulers.a()).subscribe(new j0(this, i2, builder), new k0(this)));
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
        MediaSourceArrayAdapter mediaSourceArrayAdapter = new MediaSourceArrayAdapter(getActivity(), R.layout.item_source, this.f33245e);
        this.f33244d = mediaSourceArrayAdapter;
        mediaSourceArrayAdapter.d(this);
        this.lvSources.setAdapter(this.f33244d);
        this.lvSources.setNestedScrollingEnabled(true);
        this.lvSources.setScrollContainer(false);
        this.lvSources.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z2) {
                AppBarLayout appBarLayout = MovieFragment.this.f33252l;
                if (appBarLayout != null) {
                    appBarLayout.p(!z2, true);
                }
            }
        });
    }

    public void q(int i2, boolean z2, boolean z3) {
    }

    public void s(StreamAction.ActionID actionID, MediaSource mediaSource) {
        if (mediaSource.isResolved() || mediaSource.isRawTorrent()) {
            t0(actionID, mediaSource);
            return;
        }
        showWaitingDialog("Stream loading...");
        this.f33255o.b(PremiumResolver.p(mediaSource).observeOn(AndroidSchedulers.a()).firstElement().e(new l(this, mediaSource, actionID), new m(this), new o(this)));
    }

    public void showWaitingDialog(String str) {
        if (this.F == null) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            this.F = progressDialog;
            try {
                progressDialog.show();
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        this.F.setCancelable(true);
        this.F.getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.F.setContentView(R.layout.progressbar);
        TextView textView = (TextView) this.F.findViewById(R.id.tv_title);
        if (!str.isEmpty()) {
            textView.setText(str);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        this.F.show();
    }

    public void u0(List<Video> list) {
        if (list != null) {
            for (Video next : list) {
                String site = next.getSite();
                if (!site.isEmpty()) {
                    if (GoogleVideoHelper.n(site)) {
                        MediaSource mediaSource = new MediaSource("Cinema", "GoogleVideo Video", false);
                        mediaSource.setStreamLink(next.getSite());
                        mediaSource.setQuality(next.getSize() + ContextChain.TAG_PRODUCT);
                        j1(mediaSource);
                    } else {
                        MediaSource mediaSource2 = new MediaSource("Server Crawler", "OpenLoad", true);
                        mediaSource2.setQuality("");
                        mediaSource2.setStreamLink(next.getSite());
                        j1(mediaSource2);
                    }
                }
            }
        }
    }

    public void x(boolean z2) {
        this.C = z2;
    }

    public void y(ScrollState scrollState) {
    }
}

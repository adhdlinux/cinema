package com.movie.ui.activity.sources.episodesPack;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.ads.videoreward.AdsManager;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.database.entitys.TvWatchedEpisode;
import com.movie.AppComponent;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.alldebrid.AllDebridApi;
import com.movie.data.api.alldebrid.AllDebridModule;
import com.movie.data.api.premiumize.PremiumizeApi;
import com.movie.data.api.premiumize.PremiumizeModule;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.TorrentObject;
import com.movie.data.model.cinema.SyncSeasonPack;
import com.movie.data.model.realdebrid.UnRestrictCheckObject;
import com.movie.data.model.realdebrid.UnRestrictObject;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.DaggerBaseActivityComponent;
import com.movie.ui.fragment.premium.adapter.FilesTorrentAdapter;
import com.movie.ui.helper.MoviesHelper;
import com.movie.ui.widget.AnimatorStateView;
import com.original.Constants;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.StreamAction;
import com.original.tase.helper.player.BasePlayer;
import com.original.tase.model.debrid.alldebrid.ADResponceLink;
import com.original.tase.model.media.MediaSource;
import com.original.tase.model.socket.ClientObject;
import com.original.tase.socket.Client;
import com.original.tase.utils.Regex;
import com.utils.PermissionHelper;
import com.utils.Utils;
import com.utils.download.DownloadDialog;
import com.utils.subtitle.SubtitleInfo;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import okhttp3.ResponseBody;
import retrofit2.Response;
import timber.log.Timber;

public class EpisodesActivity extends BaseActivity implements FilesTorrentAdapter.FileTorrentListener, PlayerHelper.Listener {

    /* renamed from: b  reason: collision with root package name */
    MediaSource f32913b;

    /* renamed from: c  reason: collision with root package name */
    MovieEntity f32914c;

    /* renamed from: d  reason: collision with root package name */
    SeasonEntity f32915d;

    /* renamed from: e  reason: collision with root package name */
    TorrentObject f32916e;

    /* renamed from: f  reason: collision with root package name */
    boolean f32917f = false;
    @Inject

    /* renamed from: g  reason: collision with root package name */
    MoviesHelper f32918g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    MvDatabase f32919h;
    @Inject

    /* renamed from: i  reason: collision with root package name */
    RealDebridApi f32920i;
    @Inject

    /* renamed from: j  reason: collision with root package name */
    MoviesApi f32921j;
    @Inject
    @Named("EpisodeActivity")

    /* renamed from: k  reason: collision with root package name */
    PlayerHelper f32922k;

    /* renamed from: l  reason: collision with root package name */
    AllDebridApi f32923l = AllDebridModule.b();
    @BindView(2131362548)
    ProgressBar loading;

    /* renamed from: m  reason: collision with root package name */
    PremiumizeApi f32924m = PremiumizeModule.b();

    /* renamed from: n  reason: collision with root package name */
    TvWatchedEpisode f32925n = null;

    /* renamed from: o  reason: collision with root package name */
    CompositeDisposable f32926o;

    /* renamed from: p  reason: collision with root package name */
    private FilesTorrentAdapter f32927p;

    /* renamed from: q  reason: collision with root package name */
    MovieInfo f32928q = null;
    @BindView(2131362651)
    RecyclerView rv_magnetfiles;
    @BindView(2131362909)
    AnimatorStateView viewEmpty;

    /* renamed from: com.movie.ui.activity.sources.episodesPack.EpisodesActivity$11  reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32931a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f32932b;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|23|24|25|26|(3:27|28|30)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007b */
        static {
            /*
                com.original.tase.helper.StreamAction$ActionID[] r0 = com.original.tase.helper.StreamAction.ActionID.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f32932b = r0
                r1 = 1
                com.original.tase.helper.StreamAction$ActionID r2 = com.original.tase.helper.StreamAction.ActionID.CAST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f32932b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.original.tase.helper.StreamAction$ActionID r3 = com.original.tase.helper.StreamAction.ActionID.PLAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f32932b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.CAST_WITH_SUBTITLES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f32932b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.PLAY_WITH_SUBTITLES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f32932b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.OPEN_WITH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f32932b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r3 = f32932b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.COPY_TO_CLIPBOARD     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = f32932b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.OPEN_WITH_PLAYER_PLUGIN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                com.movie.data.model.TorrentObject$Type[] r3 = com.movie.data.model.TorrentObject.Type.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f32931a = r3
                com.movie.data.model.TorrentObject$Type r4 = com.movie.data.model.TorrentObject.Type.RD     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = f32931a     // Catch:{ NoSuchFieldError -> 0x007b }
                com.movie.data.model.TorrentObject$Type r3 = com.movie.data.model.TorrentObject.Type.AD     // Catch:{ NoSuchFieldError -> 0x007b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f32931a     // Catch:{ NoSuchFieldError -> 0x0085 }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.PM     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.sources.episodesPack.EpisodesActivity.AnonymousClass11.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public MediaSource A0(TorrentObject.FileBean fileBean) throws Exception {
        MediaSource mediaSource = new MediaSource("User Torrent", "RealDebrid", false);
        mediaSource.setMovieName(fileBean.getName());
        Response<UnRestrictObject> execute = this.f32920i.unrestrictLink(fileBean.getLink(), "", 0).execute();
        if (execute.code() == 200) {
            UnRestrictObject body = execute.body();
            mediaSource.setStreamLink(body.getDownload());
            mediaSource.setFileSize(body.getFilesize());
            mediaSource.setRealdebrid(true);
            mediaSource.setResolved(true);
            mediaSource.setFilename(body.getFilename());
            return mediaSource;
        }
        throw new Exception("unRestrictObjectResponse Error : " + execute.code());
    }

    private void B0() {
        Toolbar toolbar = this.mToolbar;
        if (toolbar == null) {
            Timber.g("Didn't find a toolbar", new Object[0]);
            return;
        }
        ViewCompat.z0(toolbar, getResources().getDimension(R.dimen.toolbar_elevation));
        setSupportActionBar(this.mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.B(this.f32914c.getName() + " - " + String.format("Season %02d", new Object[]{Integer.valueOf(this.f32915d.j())}));
            supportActionBar.r(true);
            supportActionBar.y(true);
            this.mToolbar.setNavigationOnClickListener(new m(this));
        }
    }

    /* access modifiers changed from: private */
    public MediaSource Y(TorrentObject.FileBean fileBean) throws Exception {
        MediaSource mediaSource = new MediaSource("User Torrent", "AllDebrid", false);
        mediaSource.setMovieName(fileBean.getName());
        Response<ADResponceLink> execute = this.f32923l.getdownloadlink(fileBean.getLink()).execute();
        if (!execute.isSuccessful() || execute.body() == null || execute.body().getStatus().contains(MRAIDPresenter.ERROR)) {
            throw new Exception("getDownloading Error : " + execute.code());
        }
        ADResponceLink body = execute.body();
        mediaSource.setStreamLink(body.getData().getLink());
        mediaSource.setFileSize(body.getData().getFilesize());
        mediaSource.setAlldebrid(true);
        mediaSource.setResolved(true);
        HashMap hashMap = new HashMap();
        hashMap.put(TheTvdb.HEADER_ACCEPT, "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        hashMap.put("Accept-Encoding", "gzip, deflate, br");
        hashMap.put(TheTvdb.HEADER_ACCEPT_LANGUAGE, "en-US,en;q=0.5");
        hashMap.put("DNT", "1");
        hashMap.put("Connection", "keep-alive");
        hashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:81.0) Gecko/20100101 Firefox/81.0");
        mediaSource.setFilename(body.getData().getFilename());
        return mediaSource;
    }

    private String Z(String str) {
        String a2 = Regex.a(str, "([Ss]?([0-9]{1,2}))[Eex]", 2);
        String a3 = Regex.a(str, "([Eex]([0-9]{2})(?:[^0-9]|$))", 2);
        int indexOf = str.toLowerCase().indexOf(String.format("s%se%s", new Object[]{a2, a3}));
        if (indexOf > -1) {
            return str.substring(0, indexOf);
        }
        return "";
    }

    private void a0() {
        int i2 = AnonymousClass11.f32931a[this.f32916e.getType().ordinal()];
        if (i2 == 1) {
            this.loading.setVisibility(0);
            this.f32926o.b(Observable.fromIterable(this.f32916e.getListLink()).flatMap(new i(this)).toList().h(AndroidSchedulers.a()).i(new j(this), new k(this)));
        } else if (i2 == 2 || i2 == 3) {
            FilesTorrentAdapter filesTorrentAdapter = new FilesTorrentAdapter(this.f32916e);
            this.f32927p = filesTorrentAdapter;
            filesTorrentAdapter.e(this);
            this.rv_magnetfiles.setAdapter(this.f32927p);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource c0(final String str) throws Exception {
        return Observable.create(new ObservableOnSubscribe<TorrentObject.FileBean>() {
            public void subscribe(ObservableEmitter<TorrentObject.FileBean> observableEmitter) throws Exception {
                Response<UnRestrictCheckObject> execute = EpisodesActivity.this.f32920i.unrestrictCheck(str, (String) null).execute();
                if (execute.isSuccessful() && execute.body() != null) {
                    UnRestrictCheckObject body = execute.body();
                    observableEmitter.onNext(new TorrentObject.FileBean(body.getFilename(), str, body.getFilesize(), body.getHost()));
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d0(List list) throws Exception {
        this.f32916e.setFiles(list);
        this.loading.setVisibility(4);
        FilesTorrentAdapter filesTorrentAdapter = new FilesTorrentAdapter(this.f32916e);
        this.f32927p = filesTorrentAdapter;
        filesTorrentAdapter.e(this);
        this.rv_magnetfiles.setAdapter(this.f32927p);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e0(Throwable th) throws Exception {
        Utils.i0(this, th.getMessage());
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f0(String str) throws Exception {
        Utils.i0(this, str);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g0(Throwable th) throws Exception {
        Utils.i0(this, th.getMessage());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h0(ResponseBody responseBody) throws Exception {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i0(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(TvWatchedEpisode tvWatchedEpisode) throws Exception {
        this.f32925n = tvWatchedEpisode;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(MediaSource mediaSource) throws Exception {
        this.f32922k.a0(this, Collections.singletonList(mediaSource), mediaSource);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void l0(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(List list) throws Exception {
        PlayerHelper.PlayData playData = new PlayerHelper.PlayData(this.f32914c, (MediaSource) list.get(0), list, (List<? extends SubtitleInfo>) null, this.f32928q);
        playData.i(false);
        this.f32922k.E(playData);
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(Throwable th) throws Exception {
        Utils.i0(this, th.getMessage());
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource o0(final TorrentObject.FileBean fileBean) throws Exception {
        return Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                observableEmitter.onNext(EpisodesActivity.this.z0(fileBean));
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0(List list) throws Exception {
        PlayerHelper.PlayData playData = new PlayerHelper.PlayData(this.f32914c, (MediaSource) list.get(0), list, (List<? extends SubtitleInfo>) null, this.f32928q);
        playData.i(false);
        this.f32922k.E(playData);
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(Throwable th) throws Exception {
        Utils.i0(this, th.getMessage());
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource r0(final TorrentObject.FileBean fileBean) throws Exception {
        return Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                observableEmitter.onNext(EpisodesActivity.this.A0(fileBean));
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List s0(List list) throws Exception {
        Collections.sort(list, new Comparator<MediaSource>() {
            /* renamed from: a */
            public int compare(MediaSource mediaSource, MediaSource mediaSource2) {
                return mediaSource.getEpisodeOrder() < mediaSource2.getEpisodeOrder() ? -1 : 1;
            }
        });
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(List list) throws Exception {
        MediaSource mediaSource = (MediaSource) list.get(0);
        if (this.f32925n != null) {
            int i2 = 0;
            while (true) {
                if (i2 < list.size()) {
                    if (((MediaSource) list.get(i2)).getSeason() == this.f32925n.f() && ((MediaSource) list.get(i2)).getEps() == this.f32925n.c()) {
                        mediaSource = (MediaSource) list.get(i2);
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            this.f32914c.setPosition(this.f32925n.e());
            this.f32928q.session = String.valueOf(this.f32925n.f());
            this.f32928q.eps = String.valueOf(this.f32925n.c());
        }
        PlayerHelper.PlayData playData = new PlayerHelper.PlayData(this.f32914c, mediaSource, list, (List<? extends SubtitleInfo>) null, this.f32928q);
        playData.i(false);
        this.f32922k.E(playData);
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u0(Throwable th) throws Exception {
        Utils.i0(this, th.getMessage());
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource v0(final TorrentObject.FileBean fileBean) throws Exception {
        return Observable.create(new ObservableOnSubscribe<MediaSource>() {
            public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                observableEmitter.onNext(EpisodesActivity.this.Y(fileBean));
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public MediaSource z0(TorrentObject.FileBean fileBean) throws Exception {
        MediaSource mediaSource = new MediaSource("User Torrent", "PM", false);
        mediaSource.setMovieName(fileBean.getName());
        mediaSource.setQuality(fileBean.getQuality());
        mediaSource.setStreamLink(fileBean.getLink());
        mediaSource.setFileSize(fileBean.getSize());
        mediaSource.setPremiumize(true);
        mediaSource.setResolved(true);
        mediaSource.setFilename(fileBean.getName());
        return mediaSource;
    }

    public void C(final TorrentObject.FileBean fileBean) {
        Observable observable;
        int i2 = AnonymousClass11.f32931a[this.f32916e.getType().ordinal()];
        if (i2 == 1) {
            observable = Observable.create(new ObservableOnSubscribe<MediaSource>() {
                public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                    observableEmitter.onNext(EpisodesActivity.this.A0(fileBean));
                }
            }).subscribeOn(Schedulers.c());
        } else if (i2 == 2) {
            observable = Observable.create(new ObservableOnSubscribe<MediaSource>() {
                public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                    observableEmitter.onNext(EpisodesActivity.this.Y(fileBean));
                }
            }).subscribeOn(Schedulers.c());
        } else if (i2 != 3) {
            observable = null;
        } else {
            observable = Observable.create(new ObservableOnSubscribe<MediaSource>() {
                public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                    observableEmitter.onNext(EpisodesActivity.this.z0(fileBean));
                }
            }).subscribeOn(Schedulers.c());
        }
        if (observable != null) {
            this.f32926o.b(observable.observeOn(AndroidSchedulers.a()).subscribe(new g(this), new h()));
        }
    }

    /* access modifiers changed from: package-private */
    public Observable<TvWatchedEpisode> b0() {
        return Observable.create(new ObservableOnSubscribe<TvWatchedEpisode>() {
            public void subscribe(ObservableEmitter<TvWatchedEpisode> observableEmitter) throws Exception {
                TvWatchedEpisode f2 = EpisodesActivity.this.f32919h.E().f(EpisodesActivity.this.f32915d.j());
                if (f2 != null) {
                    observableEmitter.onNext(f2);
                }
                observableEmitter.onComplete();
            }
        });
    }

    public void o(MediaSource mediaSource) {
        mediaSource.setMovieName(this.f32928q.name + "(" + this.f32928q.getYear() + ")");
        this.f32928q.tempStreamLink = mediaSource.getStreamLink();
        this.f32928q.extension = mediaSource.getExtension();
        this.f32928q.fileSizeString = mediaSource.getFileSizeString();
        this.f32928q.tmdbID = this.f32914c.getTmdbID();
        this.f32928q.imdbIDStr = this.f32914c.getImdbIDStr();
        if (mediaSource.getFileSize() > Utils.J() - 100000) {
            Utils.i0(this, "No space left on device!!");
            return;
        }
        try {
            DownloadDialog.I(mediaSource, this.f32928q, this.f32914c.getTmdbID()).show(getSupportFragmentManager(), "downloadDialog");
        } catch (Exception unused) {
            Utils.h0(this, R.string.could_not_setup_download_menu);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r4 != 44454) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            super.onActivityResult(r4, r5, r6)
            android.content.SharedPreferences r5 = com.movie.FreeMoviesApp.p()
            java.lang.String r0 = "pref_auto_next_eps"
            r1 = 0
            r5.getBoolean(r0, r1)
            r5 = 90
            if (r4 != r5) goto L_0x0020
            if (r6 == 0) goto L_0x0020
            java.lang.String r0 = "end_by"
            java.lang.String r0 = r6.getStringExtra(r0)
            if (r0 == 0) goto L_0x0020
            java.lang.String r2 = "user"
            r0.contains(r2)
        L_0x0020:
            r0 = 5
            r2 = 1
            if (r4 == r0) goto L_0x008a
            if (r4 == r5) goto L_0x0064
            r5 = 431(0x1af, float:6.04E-43)
            if (r4 == r5) goto L_0x003e
            r5 = 32123(0x7d7b, float:4.5014E-41)
            if (r4 == r5) goto L_0x008a
            r5 = 37701(0x9345, float:5.283E-41)
            if (r4 == r5) goto L_0x0039
            r5 = 44454(0xada6, float:6.2293E-41)
            if (r4 == r5) goto L_0x008a
            goto L_0x003b
        L_0x0039:
            r3.f32917f = r2
        L_0x003b:
            r3.f32917f = r2
            goto L_0x0091
        L_0x003e:
            if (r6 == 0) goto L_0x0061
            android.os.Bundle r4 = r6.getExtras()
            if (r4 == 0) goto L_0x0061
            android.os.Bundle r4 = r6.getExtras()
            java.lang.String r5 = "extra_position"
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L_0x0061
            java.lang.String r4 = r4.toString()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            long r4 = r4.longValue()
            r3.x0(r4, r1)
        L_0x0061:
            r3.f32917f = r2
            goto L_0x0091
        L_0x0064:
            if (r6 == 0) goto L_0x0087
            android.os.Bundle r4 = r6.getExtras()
            if (r4 == 0) goto L_0x0087
            android.os.Bundle r4 = r6.getExtras()
            java.lang.String r5 = "position"
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L_0x0087
            java.lang.String r4 = r4.toString()
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            long r4 = r4.longValue()
            r3.x0(r4, r1)
        L_0x0087:
            r3.f32917f = r2
            goto L_0x0091
        L_0x008a:
            r4 = 0
            r3.x0(r4, r2)
            r3.f32917f = r2
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.sources.episodesPack.EpisodesActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_episodes);
        this.f32922k.H(this);
        this.f32922k.V(this);
        this.f32913b = (MediaSource) getIntent().getParcelableExtra("mediaSource");
        this.f32914c = (MovieEntity) getIntent().getParcelableExtra("movieEntity");
        this.f32915d = (SeasonEntity) getIntent().getParcelableExtra("seasonEntity");
        this.f32916e = (TorrentObject) getIntent().getParcelableExtra("torrentObject");
        this.rv_magnetfiles.setLayoutManager(new LinearLayoutManager(this));
        registerForContextMenu(this.rv_magnetfiles);
        this.f32926o = new CompositeDisposable();
        a0();
        B0();
        this.f32926o.b(b0().subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new b(this)));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_episodes_pack, menu);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32926o.dispose();
        this.f32922k.z();
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_play_all) {
            y0();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.f32917f) {
            AdsManager.d().p(this);
            this.f32917f = false;
        }
        super.onResume();
    }

    public void s(StreamAction.ActionID actionID, MediaSource mediaSource) {
        String str;
        String str2;
        MediaSource mediaSource2 = mediaSource;
        String movieName = mediaSource.getMovieName();
        Utils.i0(this, Z(movieName));
        ArrayList<String> h2 = Regex.h(movieName, "(?:PPV\\.)?[HP]DTV|(?:HD)?CAM|B[rR]Rip|TS|(?:PPV )?WEB-?DL(?: DVDRip)?|H[dD]Rip|DVDRip|DVDRiP|DVDRIP|CamRip|W[EB]B[rR]ip|[Bb]lu[Rr]ay|DvDScr|hdtv", false);
        String a2 = Regex.a(movieName, "([Ss]?([0-9]{1,2}))[Eex]", 2);
        String a3 = Regex.a(movieName, "([Eex]([0-9]{2})(?:[^0-9]|$))", 2);
        if (a2 == null || a2.isEmpty()) {
            a2 = String.valueOf(this.f32915d.j());
        }
        String str3 = a2;
        if (a3 == null || a3.isEmpty()) {
            str = "-1";
        } else {
            str = a3;
        }
        ArrayList<String> h3 = Regex.h(movieName, "([\\[\\(]?((?:19[0-9]|20[01])[0-9])[\\]\\)]?)", false);
        Regex.h(movieName, "/xvid|x264|h\\.?264/i", false);
        Regex.h(movieName, "(([0-9]{3,4}p))", false);
        mediaSource2.setQuality(Utils.f(h2, "HD", false));
        MovieInfo movieInfo = new MovieInfo(movieName, Utils.f(h3, "1997", true), str3, str, Utils.f(h2, "1997", true));
        this.f32928q = movieInfo;
        movieInfo.tmdbID = this.f32914c.getTmdbID();
        this.f32928q.imdbIDStr = this.f32914c.getImdbIDStr();
        BasePlayer x2 = this.f32922k.x();
        switch (AnonymousClass11.f32932b[actionID.ordinal()]) {
            case 1:
            case 2:
                this.f32922k.A(new PlayerHelper.PlayData(this.f32914c, mediaSource, Collections.singletonList(mediaSource), (List<? extends SubtitleInfo>) null, this.f32928q));
                return;
            case 3:
            case 4:
                Utils.i0(this, "Coming Soon");
                return;
            case 5:
                this.f32922k.F(new PlayerHelper.PlayData(this.f32914c, mediaSource, (List<? extends MediaSource>) null, (List<? extends SubtitleInfo>) null, this.f32928q));
                return;
            case 6:
                if (!PermissionHelper.a(this)) {
                    ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) ((LovelyStandardDialog) new LovelyStandardDialog(this, LovelyStandardDialog.ButtonLayout.HORIZONTAL).m(R.color.darkDeepOrange)).r(R.color.darkDeepOrange).h(R.drawable.database_24px)).k("Warning")).j(getResources().getString(R.string.storage_permission_msg))).u(17039370, new View.OnClickListener() {
                        public void onClick(View view) {
                            PermissionHelper.b(EpisodesActivity.this, 1212);
                        }
                    }).o();
                    return;
                } else {
                    o(mediaSource2);
                    return;
                }
            case 7:
                Utils.p(this, mediaSource.getStreamLink(), false);
                return;
            case 8:
                if (x2 == null) {
                    str2 = "CINEMA";
                } else {
                    str2 = x2.f();
                }
                Client.getIntance().senddata(new ClientObject(str2, mediaSource.getStreamLink(), mediaSource.isHLS(), this.f32914c.getName(), -1.0d, mediaSource.getOriginalLink(), Constants.C, !mediaSource.getPlayHeader().isEmpty()).toString(), this);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().g(this);
    }

    public void x(boolean z2) {
        this.f32917f = z2;
    }

    public void x0(long j2, boolean z2) {
        TvWatchedEpisode tvWatchedEpisode = new TvWatchedEpisode();
        tvWatchedEpisode.m(this.f32928q.getEps().intValue());
        tvWatchedEpisode.q(this.f32928q.getSession().intValue());
        tvWatchedEpisode.s(this.f32914c.getTmdbID());
        tvWatchedEpisode.o(this.f32914c.getImdbIDStr());
        tvWatchedEpisode.u(this.f32914c.getTvdbID());
        tvWatchedEpisode.t(this.f32914c.getTraktID());
        tvWatchedEpisode.p(j2);
        this.f32926o.b(this.f32918g.l(this.f32914c, tvWatchedEpisode, true, z2).observeOn(AndroidSchedulers.a()).subscribe(new c(this), new d(this)));
        this.f32926o.b(this.f32921j.syncSeasonPack(new SyncSeasonPack()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e(), new f()));
    }

    public void y0() {
        MovieInfo movieInfo = new MovieInfo(this.f32914c.getName(), this.f32914c.getRealeaseDate(), String.valueOf(this.f32915d.j()), "-1", this.f32915d.c());
        this.f32928q = movieInfo;
        movieInfo.tmdbID = this.f32914c.getTmdbID();
        this.f32928q.imdbIDStr = this.f32914c.getImdbIDStr();
        int i2 = AnonymousClass11.f32931a[this.f32916e.getType().ordinal()];
        if (i2 == 1) {
            this.loading.setVisibility(0);
            this.f32926o.b(Observable.fromIterable(this.f32916e.getFiles()).flatMap(new a(this)).toList().g(new l(this)).h(AndroidSchedulers.a()).i(new n(this), new o(this)));
        } else if (i2 == 2) {
            this.f32926o.b(Observable.fromIterable(this.f32916e.getFiles()).flatMap(new p(this)).toList().h(AndroidSchedulers.a()).i(new q(this), new r(this)));
        } else if (i2 == 3) {
            this.f32926o.b(Observable.fromIterable(this.f32916e.getFiles()).flatMap(new s(this)).toList().h(AndroidSchedulers.a()).i(new t(this), new u(this)));
        }
    }
}

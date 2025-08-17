package com.movie.ui.activity.sources.seasonPack;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.SeasonEntity;
import com.database.entitys.premiumEntitys.torrents.CachedTorrentFileEntity;
import com.database.entitys.premiumEntitys.torrents.TorrentEntity;
import com.movie.AppComponent;
import com.movie.data.api.alldebrid.AllDebridApi;
import com.movie.data.api.alldebrid.AllDebridModule;
import com.movie.data.api.premiumize.PremiumizeApi;
import com.movie.data.api.premiumize.PremiumizeModule;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.api.realdebrid.exceptions.AddMagnetException;
import com.movie.data.api.realdebrid.exceptions.MagnetExpriedException;
import com.movie.data.model.TorrentObject;
import com.movie.data.model.realdebrid.MagnetObject;
import com.movie.data.model.realdebrid.RealDebridHashInstanceInfo;
import com.movie.data.model.realdebrid.RealDebridTorrentInfoObject;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.DaggerBaseActivityComponent;
import com.movie.ui.activity.MainActivity;
import com.movie.ui.activity.sources.adapter.SeasonPackAdapter;
import com.movie.ui.activity.sources.episodesPack.EpisodesActivity;
import com.movie.ui.widget.AnimatorStateView;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.model.debrid.alldebrid.ADstatusSingle;
import com.original.tase.model.debrid.alldebrid.Torrent.ADTorrentUpload;
import com.original.tase.model.debrid.premiumize.PremiumizeTorrentDirectDL;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.NavIds;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import retrofit2.Response;
import timber.log.Timber;

public class SeasonPackActivity extends BaseActivity implements SeasonPackAdapter.SeasonPackListener {
    @BindView(2131361882)
    FrameLayout adViewFrameLayout;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public MovieEntity f32992b;

    /* renamed from: c  reason: collision with root package name */
    private SeasonEntity f32993c;

    /* renamed from: d  reason: collision with root package name */
    private CompositeDisposable f32994d;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    MvDatabase f32995e;

    /* renamed from: f  reason: collision with root package name */
    private List<MagnetObject> f32996f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    SeasonPackAdapter f32997g;
    @Inject

    /* renamed from: h  reason: collision with root package name */
    RealDebridApi f32998h;

    /* renamed from: i  reason: collision with root package name */
    private List<RealDebridHashInstanceInfo> f32999i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    AllDebridApi f33000j = AllDebridModule.b();

    /* renamed from: k  reason: collision with root package name */
    PremiumizeApi f33001k = PremiumizeModule.b();

    /* renamed from: l  reason: collision with root package name */
    private List<RealDebridHashInstanceInfo> f33002l = new ArrayList();
    @BindView(2131362909)
    AnimatorStateView mViewAnimator;
    @BindView(2131362548)
    ProgressBar progressbar;
    @BindView(2131362652)
    RecyclerView recyclerView;

    /* renamed from: com.movie.ui.activity.sources.seasonPack.SeasonPackActivity$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33013a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.movie.data.model.TorrentObject$Type[] r0 = com.movie.data.model.TorrentObject.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33013a = r0
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.RD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33013a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.PM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33013a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.AD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.sources.seasonPack.SeasonPackActivity.AnonymousClass8.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public RealDebridTorrentInfoObject J(String str) throws Exception {
        RealDebridApi realDebridApi = this.f32998h;
        String id = realDebridApi.addMagnet("magnet:?xt=urn:btih:" + str, "rd").execute().body().getId();
        Response<RealDebridTorrentInfoObject> execute = this.f32998h.torrentInfos(id).execute();
        if (!execute.isSuccessful() || execute.body() == null || this.f32998h.selectFiles(id, TextUtils.join(",", K(str, execute.body().getFiles()))).execute().isSuccessful()) {
            RealDebridTorrentInfoObject body = this.f32998h.torrentInfos(id).execute().body();
            ArrayList arrayList = new ArrayList();
            for (RealDebridTorrentInfoObject.FilesBean next : body.getFiles()) {
                CachedTorrentFileEntity cachedTorrentFileEntity = new CachedTorrentFileEntity();
                cachedTorrentFileEntity.j(next.getBytes());
                cachedTorrentFileEntity.l(String.valueOf(next.getId()));
                cachedTorrentFileEntity.k(next.getPath());
                cachedTorrentFileEntity.o(TorrentObject.Type.RD);
                cachedTorrentFileEntity.l(next.getLink());
                try {
                    String a2 = Regex.a(next.getPath(), "(?:S|s)(\\d\\d)(?:E|e)(\\d\\d)", 1);
                    String a3 = Regex.a(next.getPath(), "(?:S|s)(\\d\\d)(?:E|e)(\\d\\d)", 2);
                    cachedTorrentFileEntity.n(Integer.valueOf(a2).intValue());
                    cachedTorrentFileEntity.i(Integer.valueOf(a3).intValue());
                } catch (Exception e2) {
                    cachedTorrentFileEntity.n(0);
                    cachedTorrentFileEntity.i(0);
                    e2.printStackTrace();
                }
                cachedTorrentFileEntity.m((int) this.f32992b.getTmdbID());
                arrayList.add(cachedTorrentFileEntity);
            }
            U(id, str, body.getFileIDList(), TorrentObject.Type.RD, arrayList);
            return body;
        }
        throw new AddMagnetException("Select files fail");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031 A[Catch:{ Exception -> 0x0079 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void M(com.utils.Getlink.Provider.BaseProvider r9, io.reactivex.ObservableEmitter r10) throws java.lang.Exception {
        /*
            r8 = this;
            com.database.entitys.MovieEntity r0 = r8.f32992b     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = r0.getRealeaseDate()     // Catch:{ Exception -> 0x0079 }
            r1 = 0
            java.lang.String r2 = "-"
            java.lang.String r3 = ""
            if (r0 == 0) goto L_0x0028
            com.database.entitys.MovieEntity r0 = r8.f32992b     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = r0.getRealeaseDate()     // Catch:{ Exception -> 0x0079 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0079 }
            if (r0 == 0) goto L_0x001a
            goto L_0x0028
        L_0x001a:
            com.database.entitys.MovieEntity r0 = r8.f32992b     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = r0.getRealeaseDate()     // Catch:{ Exception -> 0x0079 }
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0079 }
            r0 = r0[r1]     // Catch:{ Exception -> 0x0079 }
            r4 = r0
            goto L_0x0029
        L_0x0028:
            r4 = r3
        L_0x0029:
            com.database.entitys.SeasonEntity r0 = r8.f32993c     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x0079 }
            if (r0 == 0) goto L_0x004a
            com.database.entitys.SeasonEntity r0 = r8.f32993c     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x0079 }
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x0079 }
            if (r0 == 0) goto L_0x003e
            goto L_0x004a
        L_0x003e:
            com.database.entitys.SeasonEntity r0 = r8.f32993c     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = r0.c()     // Catch:{ Exception -> 0x0079 }
            java.lang.String[] r0 = r0.split(r2)     // Catch:{ Exception -> 0x0079 }
            r3 = r0[r1]     // Catch:{ Exception -> 0x0079 }
        L_0x004a:
            r5 = r3
            com.movie.data.model.MovieInfo r6 = new com.movie.data.model.MovieInfo     // Catch:{ Exception -> 0x0079 }
            com.database.entitys.MovieEntity r0 = r8.f32992b     // Catch:{ Exception -> 0x0079 }
            java.lang.String r1 = r0.getName()     // Catch:{ Exception -> 0x0079 }
            com.database.entitys.SeasonEntity r0 = r8.f32993c     // Catch:{ Exception -> 0x0079 }
            int r0 = r0.j()     // Catch:{ Exception -> 0x0079 }
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0079 }
            java.lang.String r7 = "-1"
            r0 = r6
            r2 = r4
            r4 = r7
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0079 }
            com.database.entitys.MovieEntity r0 = r8.f32992b     // Catch:{ Exception -> 0x0079 }
            java.lang.String r0 = r0.getImdbIDStr()     // Catch:{ Exception -> 0x0079 }
            r6.imdbIDStr = r0     // Catch:{ Exception -> 0x0079 }
            com.database.entitys.MovieEntity r0 = r8.f32992b     // Catch:{ Exception -> 0x0079 }
            long r0 = r0.getTmdbID()     // Catch:{ Exception -> 0x0079 }
            r6.tmdbID = r0     // Catch:{ Exception -> 0x0079 }
            r9.C(r6, r10)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0081
        L_0x0079:
            r9 = move-exception
            java.lang.String r9 = r9.getMessage()
            com.original.tase.Logger.a(r9)
        L_0x0081:
            r10.onComplete()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.sources.seasonPack.SeasonPackActivity.M(com.utils.Getlink.Provider.BaseProvider, io.reactivex.ObservableEmitter):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(SeasonPackAdapter.SeasonPackData seasonPackData, TorrentObject torrentObject) throws Exception {
        Intent intent = new Intent(this, EpisodesActivity.class);
        intent.putExtra("mediaSource", seasonPackData.a());
        intent.putExtra("torrentObject", torrentObject);
        intent.putExtra("movieEntity", this.f32992b);
        intent.putExtra("seasonEntity", this.f32993c);
        startActivity(intent);
        hideWaitingDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(Throwable th) throws Exception {
        hideWaitingDialog();
        if (th instanceof MagnetExpriedException) {
            Utils.y0(this, "Warning", th.getMessage(), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    Intent intent = new Intent(SeasonPackActivity.this, MainActivity.class);
                    intent.putExtra("GotNavID", NavIds.NAV_TORRENT_MANAGER.name());
                    SeasonPackActivity.this.startActivity(intent);
                }
            }, (DialogInterface.OnClickListener) null);
        } else if (th instanceof AddMagnetException) {
            Utils.y0(this, "Error", th.getMessage(), (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        } else {
            showAlertDialog("Error", "Can't resolve this torrent", (DialogInterface.OnClickListener) null, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P(SeasonPackAdapter.SeasonPackData seasonPackData) throws Exception {
        this.f32997g.f(seasonPackData);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q(Throwable th) throws Exception {
        this.progressbar.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R() throws Exception {
        this.progressbar.setVisibility(8);
        if (this.f32997g.getItemCount() == 0) {
            this.mViewAnimator.setMessageText("No item found");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        finish();
    }

    private void V() {
        Toolbar toolbar = this.mToolbar;
        if (toolbar == null) {
            Timber.g("Didn't find a toolbar", new Object[0]);
            return;
        }
        toolbar.setTitle((CharSequence) this.f32992b.getName());
        Toolbar toolbar2 = this.mToolbar;
        toolbar2.setSubtitle((CharSequence) "season " + this.f32993c.j());
        ViewCompat.z0(this.mToolbar, getResources().getDimension(R.dimen.toolbar_elevation));
        setSupportActionBar(this.mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.y(true);
        supportActionBar.r(true);
        this.mToolbar.setNavigationOnClickListener(new i(this));
    }

    /* access modifiers changed from: package-private */
    public List<String> K(String str, List<RealDebridTorrentInfoObject.FilesBean> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<RealDebridHashInstanceInfo> it2 = this.f32999i.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            RealDebridHashInstanceInfo next = it2.next();
            if (next.items.size() > 0 && str.toLowerCase().contains(next.hash)) {
                Map map = next.items.get(0);
                for (int i2 = 1; i2 < next.items.size(); i2++) {
                    if (map.size() < next.items.get(i2).size()) {
                        map = next.items.get(i2);
                    }
                }
                for (Map.Entry key : map.entrySet()) {
                    arrayList.add((String) key.getKey());
                }
            }
        }
        if (arrayList.isEmpty()) {
            for (RealDebridTorrentInfoObject.FilesBean next2 : list) {
                if (next2.getBytes() > 30000000) {
                    next2.setSelected(1);
                    arrayList.add(String.valueOf(next2.getId()));
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Observable<SeasonPackAdapter.SeasonPackData> L(final MediaSource mediaSource) {
        if (mediaSource.getMagnetObjects() == null || mediaSource.getMagnetObjects().isEmpty()) {
            SeasonPackAdapter.SeasonPackData seasonPackData = new SeasonPackAdapter.SeasonPackData();
            seasonPackData.f(mediaSource.cloneDeeply());
            return Observable.just(seasonPackData);
        }
        final MagnetObject magnetObject = mediaSource.getMagnetObjects().get(0);
        final String magnet = magnetObject.getMagnet();
        return Observable.create(new ObservableOnSubscribe<SeasonPackAdapter.SeasonPackData>() {
            /* JADX WARNING: Removed duplicated region for block: B:11:0x0055  */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void subscribe(io.reactivex.ObservableEmitter<com.movie.ui.activity.sources.adapter.SeasonPackAdapter.SeasonPackData> r9) throws java.lang.Exception {
                /*
                    r8 = this;
                    com.movie.ui.activity.sources.seasonPack.SeasonPackActivity r0 = com.movie.ui.activity.sources.seasonPack.SeasonPackActivity.this
                    com.database.MvDatabase r0 = r0.f32995e
                    com.database.daos.premiumDAO.torrents.TorrentDAO r0 = r0.D()
                    java.lang.String r1 = r1
                    com.movie.ui.activity.sources.seasonPack.SeasonPackActivity r2 = com.movie.ui.activity.sources.seasonPack.SeasonPackActivity.this
                    com.database.entitys.MovieEntity r2 = r2.f32992b
                    long r2 = r2.getTmdbID()
                    java.lang.String r2 = java.lang.String.valueOf(r2)
                    com.movie.data.model.TorrentObject$Type r3 = com.movie.data.model.TorrentObject.Type.RD
                    java.lang.String r4 = com.database.entitys.premiumEntitys.torrents.TorrentTypeConverter.b(r3)
                    com.database.entitys.premiumEntitys.torrents.TorrentEntity r0 = r0.d(r1, r2, r4)
                    com.original.tase.model.debrid.realdebrid.RealDebridCredentialsInfo r1 = com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper.d()
                    boolean r1 = r1.isValid()
                    if (r1 == 0) goto L_0x007e
                    r1 = 0
                    if (r0 == 0) goto L_0x0052
                    com.movie.ui.activity.sources.seasonPack.SeasonPackActivity r2 = com.movie.ui.activity.sources.seasonPack.SeasonPackActivity.this
                    com.movie.data.api.realdebrid.RealDebridApi r2 = r2.f32998h
                    java.lang.String r0 = r0.d()
                    retrofit2.Call r0 = r2.torrentInfos(r0)
                    retrofit2.Response r0 = r0.execute()
                    boolean r2 = r0.isSuccessful()
                    if (r2 == 0) goto L_0x0052
                    java.lang.Object r2 = r0.body()
                    if (r2 == 0) goto L_0x0052
                    java.lang.Object r0 = r0.body()
                    com.movie.data.model.realdebrid.RealDebridTorrentInfoObject r0 = (com.movie.data.model.realdebrid.RealDebridTorrentInfoObject) r0
                    goto L_0x0053
                L_0x0052:
                    r0 = r1
                L_0x0053:
                    if (r0 == 0) goto L_0x005a
                    com.movie.data.model.TorrentObject r0 = r0.convert()
                    goto L_0x006a
                L_0x005a:
                    com.movie.data.model.TorrentObject r0 = new com.movie.data.model.TorrentObject
                    r0.<init>()
                    java.lang.String r2 = r1
                    r0.setHash(r2)
                    r0.setType(r3)
                    r0.setStatusBean(r1)
                L_0x006a:
                    com.movie.ui.activity.sources.adapter.SeasonPackAdapter$SeasonPackData r1 = new com.movie.ui.activity.sources.adapter.SeasonPackAdapter$SeasonPackData
                    r1.<init>()
                    com.original.tase.model.media.MediaSource r2 = r4
                    com.original.tase.model.media.MediaSource r2 = r2.cloneDeeply()
                    r1.f(r2)
                    r1.g(r0)
                    r9.onNext(r1)
                L_0x007e:
                    com.original.tase.model.debrid.alldebrid.AllDebridCredentialsInfo r0 = com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper.b()
                    boolean r0 = r0.isValid()
                    if (r0 == 0) goto L_0x00c2
                    com.movie.data.model.TorrentObject r0 = new com.movie.data.model.TorrentObject
                    r0.<init>()
                    java.lang.String r1 = r1
                    r0.setHash(r1)
                    com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.AD
                    r0.setType(r1)
                    com.movie.data.model.realdebrid.MagnetObject r1 = r0
                    boolean r1 = r1.isPremiumCached()
                    if (r1 == 0) goto L_0x00ae
                    com.movie.data.model.TorrentObject$StatusBean r1 = new com.movie.data.model.TorrentObject$StatusBean
                    java.lang.String r3 = "Cached"
                    r4 = 0
                    r5 = 0
                    r6 = 0
                    r2 = r1
                    r2.<init>(r3, r4, r5, r6)
                    r0.setStatusBean(r1)
                L_0x00ae:
                    com.movie.ui.activity.sources.adapter.SeasonPackAdapter$SeasonPackData r1 = new com.movie.ui.activity.sources.adapter.SeasonPackAdapter$SeasonPackData
                    r1.<init>()
                    com.original.tase.model.media.MediaSource r2 = r4
                    com.original.tase.model.media.MediaSource r2 = r2.cloneDeeply()
                    r1.f(r2)
                    r1.g(r0)
                    r9.onNext(r1)
                L_0x00c2:
                    com.original.tase.model.debrid.premiumize.PremiumizeCredentialsInfo r0 = com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper.b()
                    boolean r0 = r0.isValid()
                    if (r0 == 0) goto L_0x0106
                    com.movie.data.model.TorrentObject r0 = new com.movie.data.model.TorrentObject
                    r0.<init>()
                    java.lang.String r1 = r1
                    r0.setHash(r1)
                    com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.PM
                    r0.setType(r1)
                    com.movie.data.model.realdebrid.MagnetObject r1 = r0
                    boolean r1 = r1.isPremiumCached()
                    if (r1 == 0) goto L_0x00f2
                    com.movie.data.model.TorrentObject$StatusBean r1 = new com.movie.data.model.TorrentObject$StatusBean
                    java.lang.String r3 = "Cached"
                    r4 = 0
                    r5 = 0
                    r6 = 0
                    r2 = r1
                    r2.<init>(r3, r4, r5, r6)
                    r0.setStatusBean(r1)
                L_0x00f2:
                    com.movie.ui.activity.sources.adapter.SeasonPackAdapter$SeasonPackData r1 = new com.movie.ui.activity.sources.adapter.SeasonPackAdapter$SeasonPackData
                    r1.<init>()
                    com.original.tase.model.media.MediaSource r2 = r4
                    com.original.tase.model.media.MediaSource r2 = r2.cloneDeeply()
                    r1.f(r2)
                    r1.g(r0)
                    r9.onNext(r1)
                L_0x0106:
                    r9.onComplete()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.sources.seasonPack.SeasonPackActivity.AnonymousClass1.subscribe(io.reactivex.ObservableEmitter):void");
            }
        });
    }

    /* access modifiers changed from: package-private */
    public Observable<MediaSource> T(BaseProvider baseProvider) {
        return Observable.create(new h(this, baseProvider));
    }

    public void U(String str, String str2, List<String> list, TorrentObject.Type type, List<CachedTorrentFileEntity> list2) throws Exception {
        this.f32992b.setWatched_at(OffsetDateTime.now((ZoneId) ZoneOffset.UTC));
        this.f32995e.A().b(this.f32992b);
        MovieEntity l2 = this.f32995e.A().l(this.f32992b.getTmdbID(), this.f32992b.getImdbIDStr(), this.f32992b.getTraktID(), this.f32992b.getTvdbID());
        TorrentEntity torrentEntity = new TorrentEntity();
        torrentEntity.g(list);
        torrentEntity.j(l2.getId());
        torrentEntity.k(type);
        torrentEntity.h(str2);
        String str3 = str;
        torrentEntity.i(str);
        this.f32995e.D().e(torrentEntity);
        this.f32995e.y().a((CachedTorrentFileEntity[]) list2.toArray(new CachedTorrentFileEntity[list2.size()]));
    }

    public void l(final SeasonPackAdapter.SeasonPackData seasonPackData) {
        final String hash = seasonPackData.d().getHash();
        if (seasonPackData.d().getListLink().isEmpty()) {
            showWaitingDialog("Verify link...");
            this.f32994d.b(Observable.create(new ObservableOnSubscribe<TorrentObject>() {
                public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                    int i2 = AnonymousClass8.f33013a[seasonPackData.d().getType().ordinal()];
                    if (i2 == 1) {
                        RealDebridTorrentInfoObject I = SeasonPackActivity.this.J(hash);
                        if (!I.getLinks().isEmpty()) {
                            observableEmitter.onNext(I.convert());
                        } else {
                            throw new MagnetExpriedException("This torrent has been expired on RD, start over dowloading...");
                        }
                    } else if (i2 == 2) {
                        String hash = seasonPackData.d().getHash();
                        if (seasonPackData.a().getMagnetObjects().get(0).isPremiumCached()) {
                            String quality = seasonPackData.a().getQuality();
                            PremiumizeTorrentDirectDL body = SeasonPackActivity.this.f33001k.getPremiumizeTorrentDirectDL(PremiumizeCredentialsHelper.b().getAccessToken(), hash).execute().body();
                            if (body == null || !body.getStatus().contains("success")) {
                                throw new AddMagnetException("Can't add Magnet to Rd");
                            }
                            List<PremiumizeTorrentDirectDL.ContentBean> content = body.getContent();
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            for (PremiumizeTorrentDirectDL.ContentBean next : content) {
                                if (next.getTranscode_status().contains("finished") || next.getTranscode_status().contains("good_as_is")) {
                                    String link = next.getLink();
                                    if (link.isEmpty()) {
                                        link = next.getStream_link();
                                    }
                                    TorrentObject.FileBean fileBean = new TorrentObject.FileBean(next.getPath(), link, Long.parseLong(next.getSize()), (String) null);
                                    fileBean.setQuality(quality);
                                    arrayList.add(fileBean);
                                    arrayList2.add(link);
                                }
                            }
                            TorrentObject d2 = seasonPackData.d();
                            d2.setFiles(arrayList);
                            d2.setListLink(arrayList2);
                            SeasonPackActivity.this.U(String.valueOf(seasonPackData.d().getHash()), hash, new ArrayList(), TorrentObject.Type.AD, new ArrayList());
                            observableEmitter.onNext(d2);
                        } else {
                            SeasonPackActivity.this.f33001k.transferCreate(PremiumizeCredentialsHelper.b().getAccessToken(), hash).execute().body();
                            throw new MagnetExpriedException("This torrent has beeen expired on RD, start over dowloading...");
                        }
                    } else if (i2 == 3) {
                        for (ADTorrentUpload.DataBean.MagnetsBean next2 : SeasonPackActivity.this.f33000j.uploadMagnet(Arrays.asList(new String[]{hash})).execute().body().getData().getMagnets()) {
                            if (next2.isReady()) {
                                Response<ADstatusSingle> execute = SeasonPackActivity.this.f33000j.status(String.valueOf(next2.getId()), (String) null).execute();
                                if (execute.isSuccessful() && execute.body() != null && execute.body().getStatus().contains("success") && execute.body().getData().getMagnets().getLinks().size() > 0) {
                                    SeasonPackActivity.this.U(String.valueOf(next2.getId()), hash, new ArrayList(), TorrentObject.Type.AD, new ArrayList());
                                    observableEmitter.onNext(execute.body().getData().getMagnets().convert());
                                }
                            } else {
                                throw new MagnetExpriedException("This torrent has beeen expired on AD, start over dowloading...");
                            }
                        }
                    }
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(this, seasonPackData), new b(this)));
            return;
        }
        Intent intent = new Intent(this, EpisodesActivity.class);
        intent.putExtra("mediaSource", seasonPackData.a());
        intent.putExtra("torrentObject", seasonPackData.d());
        intent.putExtra("movieEntity", this.f32992b);
        intent.putExtra("seasonEntity", this.f32993c);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f32992b = (MovieEntity) getIntent().getExtras().getParcelable("MovieEntity");
        this.f32993c = (SeasonEntity) getIntent().getExtras().getParcelable("seasonEntity");
        this.f32994d = new CompositeDisposable();
        setContentView(R.layout.activity_seasonpack);
        V();
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SeasonPackAdapter seasonPackAdapter = new SeasonPackAdapter(new ArrayList(), this, this.f32993c.d());
        this.f32997g = seasonPackAdapter;
        this.recyclerView.setAdapter(seasonPackAdapter);
        List<BaseProvider> x2 = Utils.x();
        this.progressbar.setVisibility(0);
        this.f32994d.b(Observable.fromIterable(x2).flatMap(new c(this)).flatMap(new d(this)).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e(this), new f(this), new g(this)));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32994d.dispose();
        this.progressbar.setVisibility(8);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            NavUtils.e(this);
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_filter) {
            this.f32997g.getFilter().filter("full episode only");
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().f(this);
    }
}

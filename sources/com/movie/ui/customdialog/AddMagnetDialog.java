package com.movie.ui.customdialog;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.premiumEntitys.torrents.CachedTorrentFileEntity;
import com.database.entitys.premiumEntitys.torrents.TorrentEntity;
import com.database.entitys.premiumEntitys.torrents.TorrentTypeConverter;
import com.facebook.common.callercontext.ContextChain;
import com.movie.FreeMoviesApp;
import com.movie.data.api.alldebrid.AllDebridApi;
import com.movie.data.api.alldebrid.AllDebridModule;
import com.movie.data.api.premiumize.PremiumizeApi;
import com.movie.data.api.premiumize.PremiumizeModule;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.TorrentObject;
import com.movie.data.model.premiumize.FolderList;
import com.movie.data.model.premiumize.ItemDetails;
import com.movie.data.model.premiumize.TransferCreate;
import com.movie.data.model.premiumize.TransferList;
import com.movie.data.model.realdebrid.RealDebridTorrentInfoObject;
import com.movie.data.model.realdebrid.UnRestrictCheckObject;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.adapter.MagnetInfoAdapter;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.fragment.premium.FilesBottomSheetFragment;
import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.model.debrid.alldebrid.ADstatusSingle;
import com.original.tase.model.debrid.alldebrid.Torrent.ADTorrentUpload;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import retrofit2.Response;

public class AddMagnetDialog extends DialogFragment implements MagnetInfoAdapter.MagnetInfoListener {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    RealDebridApi f33153b;
    @BindView(2131361956)
    ImageButton btnAddMagnet;

    /* renamed from: c  reason: collision with root package name */
    AllDebridApi f33154c = AllDebridModule.b();
    @BindView(2131362015)
    CheckBox cbAD;
    @BindView(2131362016)
    CheckBox cbPM;
    @BindView(2131362017)
    CheckBox cbRD;

    /* renamed from: d  reason: collision with root package name */
    PremiumizeApi f33155d = PremiumizeModule.b();
    @Inject

    /* renamed from: e  reason: collision with root package name */
    MvDatabase f33156e;
    @BindView(2131362118)
    EditText edtAddMagnet;

    /* renamed from: f  reason: collision with root package name */
    BaseActivity f33157f;

    /* renamed from: g  reason: collision with root package name */
    private Unbinder f33158g;

    /* renamed from: h  reason: collision with root package name */
    private CompositeDisposable f33159h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public MovieEntity f33160i;
    @BindView(2131362277)
    ImageButton imgbtncopy;

    /* renamed from: j  reason: collision with root package name */
    private MovieInfo f33161j;

    /* renamed from: k  reason: collision with root package name */
    List<Integer> f33162k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private MagnetInfoAdapter f33163l;

    /* renamed from: m  reason: collision with root package name */
    private String f33164m = "";
    @BindView(2131362598)
    ProgressBar progressBar;
    @BindView(2131362649)
    RecyclerView rvMagnet;

    /* renamed from: com.movie.ui.customdialog.AddMagnetDialog$13  reason: invalid class name */
    static /* synthetic */ class AnonymousClass13 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33173a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.movie.data.model.TorrentObject$Type[] r0 = com.movie.data.model.TorrentObject.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33173a = r0
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.RD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33173a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.AD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33173a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.PM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.customdialog.AddMagnetDialog.AnonymousClass13.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A0(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B0() throws Exception {
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void C0(TorrentObject torrentObject) throws Exception {
        torrentObject.setGotDetails(true);
        this.f33163l.i(torrentObject);
        if (!this.f33164m.isEmpty()) {
            T0(torrentObject);
            this.f33164m = "";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void D0(Throwable th) throws Exception {
        Utils.i0(getActivity(), "update progress error");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void E0(TorrentObject torrentObject) throws Exception {
        torrentObject.setGotDetails(true);
        this.f33163l.i(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void F0(Throwable th) throws Exception {
        Utils.i0(getActivity(), "update progress error");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void G0(TorrentObject torrentObject) throws Exception {
        torrentObject.setGotDetails(true);
        this.f33163l.i(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H0(Throwable th) throws Exception {
        Utils.i0(getActivity(), "update progress error");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource I0(final String str) throws Exception {
        return Observable.create(new ObservableOnSubscribe<TorrentObject.FileBean>() {
            public void subscribe(ObservableEmitter<TorrentObject.FileBean> observableEmitter) throws Exception {
                Response<UnRestrictCheckObject> execute = AddMagnetDialog.this.f33153b.unrestrictCheck(str, (String) null).execute();
                if (execute.isSuccessful() && execute.body() != null) {
                    UnRestrictCheckObject body = execute.body();
                    observableEmitter.onNext(new TorrentObject.FileBean(body.getFilename(), str, body.getFilesize(), body.getHost()));
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List J0(List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            TorrentObject.FileBean fileBean = (TorrentObject.FileBean) it2.next();
            CachedTorrentFileEntity cachedTorrentFileEntity = new CachedTorrentFileEntity();
            cachedTorrentFileEntity.j(fileBean.getSize());
            cachedTorrentFileEntity.k(fileBean.getName());
            cachedTorrentFileEntity.o(TorrentObject.Type.RD);
            cachedTorrentFileEntity.l(fileBean.getLink());
            try {
                String a2 = Regex.a(fileBean.getName(), "(?:S|s)(\\d\\d)(?:E|e)(\\d\\d)", 1);
                String a3 = Regex.a(fileBean.getName(), "(?:S|s)(\\d\\d)(?:E|e)(\\d\\d)", 2);
                cachedTorrentFileEntity.n(Integer.valueOf(a2).intValue());
                cachedTorrentFileEntity.i(Integer.valueOf(a3).intValue());
            } catch (Exception e2) {
                cachedTorrentFileEntity.n(0);
                cachedTorrentFileEntity.i(0);
                e2.printStackTrace();
            }
            cachedTorrentFileEntity.m((int) this.f33160i.getTmdbID());
            arrayList.add(cachedTorrentFileEntity);
        }
        this.f33156e.y().a((CachedTorrentFileEntity[]) arrayList.toArray(new CachedTorrentFileEntity[arrayList.size()]));
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K0(TorrentObject torrentObject, List list) throws Exception {
        torrentObject.setFiles(list);
        FilesBottomSheetFragment c02 = FilesBottomSheetFragment.c0(torrentObject);
        c02.show(getActivity().getSupportFragmentManager(), c02.getTag());
        ((BaseActivity) getActivity()).hideWaitingDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L0(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
        ((BaseActivity) getActivity()).hideWaitingDialog();
    }

    public static AddMagnetDialog O0(MovieEntity movieEntity, MovieInfo movieInfo) {
        AddMagnetDialog addMagnetDialog = new AddMagnetDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable("movieEntity", movieEntity);
        bundle.putParcelable("movieInfo", movieInfo);
        addMagnetDialog.setArguments(bundle);
        return addMagnetDialog;
    }

    private Disposable P0(final String str) {
        return Observable.create(new ObservableOnSubscribe<TorrentObject>() {
            public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                for (ADTorrentUpload.DataBean.MagnetsBean next : AddMagnetDialog.this.f33154c.uploadMagnet(Arrays.asList(new String[]{str})).execute().body().getData().getMagnets()) {
                    AddMagnetDialog.this.S0(String.valueOf(next.getId()), str, new ArrayList(), TorrentObject.Type.AD, new ArrayList());
                    observableEmitter.onNext(next.convert());
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(this), new l(this), new t(this));
    }

    private Disposable Q0(final String str) {
        return Observable.create(new ObservableOnSubscribe<TorrentObject>() {
            public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                PremiumizeApi premiumizeApi = AddMagnetDialog.this.f33155d;
                String accessToken = PremiumizeCredentialsHelper.b().getAccessToken();
                Response<TransferCreate> execute = premiumizeApi.transferCreate(accessToken, "magnet:?xt=urn:btih:" + str).execute();
                if (execute.isSuccessful() && execute.body() != null) {
                    Response<TransferList> execute2 = AddMagnetDialog.this.f33155d.transferlist(PremiumizeCredentialsHelper.b().getAccessToken()).execute();
                    if (execute2.isSuccessful() && execute2.body() != null) {
                        Iterator<TransferList.TransfersBean> it2 = execute2.body().getTransfers().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            TransferList.TransfersBean next = it2.next();
                            if (next.getId().equals(execute.body().getId())) {
                                AddMagnetDialog.this.S0(String.valueOf(next.getId()), str, new ArrayList(), TorrentObject.Type.PM, new ArrayList());
                                observableEmitter.onNext(next.convert());
                                break;
                            }
                        }
                    }
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new n(this), new o(this), new p(this));
    }

    private Disposable R0(final String str) {
        return Observable.create(new ObservableOnSubscribe<TorrentObject>() {
            public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                if (str.isEmpty()) {
                    observableEmitter.onComplete();
                    return;
                }
                TorrentEntity d2 = AddMagnetDialog.this.f33156e.D().d(str, String.valueOf(AddMagnetDialog.this.f33160i.getTmdbID()), TorrentTypeConverter.b(TorrentObject.Type.RD));
                RealDebridApi realDebridApi = AddMagnetDialog.this.f33153b;
                String id = realDebridApi.addMagnet("magnet:?xt=urn:btih:" + str, "").execute().body().getId();
                RealDebridTorrentInfoObject body = AddMagnetDialog.this.f33153b.torrentInfos(id).execute().body();
                AddMagnetDialog addMagnetDialog = AddMagnetDialog.this;
                if (addMagnetDialog.f33153b.selectFiles(id, TextUtils.join(",", addMagnetDialog.i0(body.getFiles()))).execute().isSuccessful()) {
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
                        cachedTorrentFileEntity.m((int) AddMagnetDialog.this.f33160i.getTmdbID());
                        arrayList.add(cachedTorrentFileEntity);
                    }
                    AddMagnetDialog.this.S0(body.getId(), str, body.getFileIDList(), TorrentObject.Type.RD, arrayList);
                }
                if (d2 == null) {
                    observableEmitter.onNext(body.convert());
                    observableEmitter.onComplete();
                    return;
                }
                throw new Exception("This torrent already added");
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a0(this), new b(this), new c(this));
    }

    private void T0(TorrentObject torrentObject) {
        int i2 = AnonymousClass13.f33173a[torrentObject.getType().ordinal()];
        if (i2 == 1) {
            ((BaseActivity) getActivity()).showWaitingDialog("checking available links...");
            this.f33159h.b(Observable.fromIterable(torrentObject.getListLink()).flatMap(new d(this)).toList().g(new e(this)).h(AndroidSchedulers.a()).i(new f(this, torrentObject), new g(this)));
        } else if (i2 == 2) {
            FilesBottomSheetFragment c02 = FilesBottomSheetFragment.c0(torrentObject);
            c02.show(getActivity().getSupportFragmentManager(), c02.getTag());
        } else if (i2 == 3) {
            FilesBottomSheetFragment c03 = FilesBottomSheetFragment.c0(torrentObject);
            c03.show(getActivity().getSupportFragmentManager(), c03.getTag());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource m0(TorrentEntity torrentEntity) throws Exception {
        return k0(torrentEntity).subscribeOn(Schedulers.c());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(TorrentObject torrentObject) throws Exception {
        torrentObject.setGotDetails(true);
        this.f33163l.c(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(Throwable th) throws Exception {
        FragmentActivity activity = getActivity();
        Utils.i0(activity, "Load data error + " + th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0() throws Exception {
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q0(TorrentObject torrentObject) throws Exception {
        this.edtAddMagnet.setText("");
        this.f33163l.e().add(torrentObject);
        this.f33163l.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(Throwable th) throws Exception {
        FragmentActivity activity = getActivity();
        Utils.i0(activity, "add AD magnet error " + th.getMessage());
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s0() throws Exception {
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(TorrentObject torrentObject, Object obj) throws Exception {
        this.f33163l.d(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u0(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object v0(TorrentObject torrentObject, Object obj) throws Exception {
        this.f33156e.D().a(torrentObject.getHash(), torrentObject.getId());
        return obj;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(TorrentObject torrentObject) throws Exception {
        this.edtAddMagnet.setText("");
        this.f33163l.e().add(torrentObject);
        this.f33163l.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0(Throwable th) throws Exception {
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y0() throws Exception {
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z0(TorrentObject torrentObject) throws Exception {
        this.edtAddMagnet.setText("");
        this.f33163l.e().add(torrentObject);
        this.f33163l.notifyDataSetChanged();
    }

    public void B(TorrentObject torrentObject) {
        T0(torrentObject);
    }

    public void M0() {
        this.f33162k.clear();
        this.progressBar.setVisibility(0);
        this.f33159h.b(Observable.create(new ObservableOnSubscribe<List<TorrentEntity>>() {
            public void subscribe(ObservableEmitter<List<TorrentEntity>> observableEmitter) throws Exception {
                MovieEntity l2 = AddMagnetDialog.this.f33156e.A().l(AddMagnetDialog.this.f33160i.getTmdbID(), AddMagnetDialog.this.f33160i.getImdbIDStr(), AddMagnetDialog.this.f33160i.getTraktID(), AddMagnetDialog.this.f33160i.getTvdbID());
                if (l2 != null) {
                    List<TorrentEntity> b2 = AddMagnetDialog.this.f33156e.D().b(l2.getId());
                    for (TorrentEntity c2 : b2) {
                        AddMagnetDialog.this.f33162k.add(Integer.valueOf(c2.c().hashCode()));
                    }
                    observableEmitter.onNext(b2);
                }
                observableEmitter.onComplete();
            }
        }).flatMap(new h()).flatMap(new i(this)).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new j(this), new k(this), new m(this)));
    }

    /* access modifiers changed from: package-private */
    public void N0() {
        this.cbAD.setChecked(AllDebridCredentialsHelper.b().isValid());
        this.cbRD.setChecked(RealDebridCredentialsHelper.d().isValid());
        this.cbPM.setChecked(PremiumizeCredentialsHelper.b().isValid());
    }

    public void S0(String str, String str2, List<String> list, TorrentObject.Type type, List<CachedTorrentFileEntity> list2) throws Exception {
        this.f33160i.setWatched_at(OffsetDateTime.now((ZoneId) ZoneOffset.UTC));
        this.f33156e.A().b(this.f33160i);
        MovieEntity l2 = this.f33156e.A().l(this.f33160i.getTmdbID(), this.f33160i.getImdbIDStr(), this.f33160i.getTraktID(), this.f33160i.getTvdbID());
        TorrentEntity torrentEntity = new TorrentEntity();
        torrentEntity.g(list);
        torrentEntity.j(l2.getId());
        torrentEntity.k(type);
        torrentEntity.h(str2);
        String str3 = str;
        torrentEntity.i(str);
        this.f33156e.D().e(torrentEntity);
        this.f33156e.y().a((CachedTorrentFileEntity[]) list2.toArray(new CachedTorrentFileEntity[list2.size()]));
    }

    public void a(final TorrentObject torrentObject, int i2) {
        int i3 = AnonymousClass13.f33173a[torrentObject.getType().ordinal()];
        if (i3 == 1) {
            this.f33159h.b(Observable.create(new ObservableOnSubscribe<TorrentObject>() {
                public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                    Response<RealDebridTorrentInfoObject> execute = AddMagnetDialog.this.f33153b.torrentInfos(torrentObject.getId()).execute();
                    TorrentObject convert = execute.body().convert();
                    convert.setTorrentEntity(AddMagnetDialog.this.f33156e.D().d(execute.body().getHash(), execute.body().getId(), TorrentTypeConverter.b(TorrentObject.Type.RD)));
                    observableEmitter.onNext(convert);
                    observableEmitter.onComplete();
                }
            }).delay((long) i2, TimeUnit.SECONDS).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new u(this), new v(this)));
        } else if (i3 == 2) {
            this.f33159h.b(Observable.create(new ObservableOnSubscribe<TorrentObject>() {
                public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                    ADstatusSingle.DataBean.MagnetsBean magnets = AddMagnetDialog.this.f33154c.status(torrentObject.getHash(), (String) null).execute().body().getData().getMagnets();
                    if (magnets.getHash().equals(torrentObject.getHash())) {
                        observableEmitter.onNext(magnets.convert());
                    }
                    observableEmitter.onComplete();
                }
            }).delay((long) i2, TimeUnit.SECONDS).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new w(this), new x(this)));
        } else if (i3 == 3) {
            this.f33159h.b(Observable.create(new ObservableOnSubscribe<TorrentObject>() {
                public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                    Long l2;
                    ArrayList arrayList = new ArrayList();
                    Long l3 = new Long(0);
                    if (torrentObject.getFolder_id() != null) {
                        AddMagnetDialog addMagnetDialog = AddMagnetDialog.this;
                        TorrentObject torrentObject = torrentObject;
                        Pair<List<TorrentObject.FileBean>, Long> j02 = addMagnetDialog.j0(torrentObject, torrentObject.getFolder_id(), 0);
                        arrayList.addAll((Collection) j02.first);
                        l2 = Long.valueOf(l3.longValue() + ((Long) j02.second).longValue());
                    } else {
                        ItemDetails body = AddMagnetDialog.this.f33155d.itemDetails(PremiumizeCredentialsHelper.b().getAccessToken(), torrentObject.getId()).execute().body();
                        TorrentObject.FileBean fileBean = new TorrentObject.FileBean(body.getName(), body.getLink(), body.getSize(), String.valueOf(body.getId()));
                        fileBean.setQuality(body.getResx() + ContextChain.TAG_PRODUCT);
                        arrayList.add(fileBean);
                        l2 = Long.valueOf(l3.longValue() + body.getSize());
                    }
                    torrentObject.setFiles(arrayList);
                    torrentObject.setSize(l2.longValue());
                    observableEmitter.onNext(torrentObject);
                    observableEmitter.onComplete();
                }
            }).delay((long) i2, TimeUnit.SECONDS).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new y(this), new z(this)));
        }
    }

    public void b(final TorrentObject torrentObject) {
        Observable observable;
        int i2 = AnonymousClass13.f33173a[torrentObject.getType().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                Observable.create(new ObservableOnSubscribe<Object>() {
                    public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                        if (AddMagnetDialog.this.f33154c.delete(torrentObject.getId()).execute().isSuccessful()) {
                            observableEmitter.onNext(new Boolean(true));
                        }
                        observableEmitter.onComplete();
                    }
                });
            } else if (i2 != 3) {
                observable = null;
            }
            observable = Observable.create(new ObservableOnSubscribe<Object>() {
                public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                    if (AddMagnetDialog.this.f33155d.transferdelete(PremiumizeCredentialsHelper.b().getAccessToken(), torrentObject.getId()).execute().isSuccessful()) {
                        observableEmitter.onNext(new Boolean(true));
                    }
                    observableEmitter.onComplete();
                }
            });
        } else {
            observable = Observable.create(new ObservableOnSubscribe<Object>() {
                public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                    if (AddMagnetDialog.this.f33153b.delete(torrentObject.getId()).execute().isSuccessful()) {
                        observableEmitter.onNext(new Boolean(true));
                    }
                    observableEmitter.onComplete();
                }
            });
        }
        this.f33159h.b(observable.subscribeOn(Schedulers.c()).map(new q(this, torrentObject)).observeOn(AndroidSchedulers.a()).subscribe(new r(this, torrentObject), new s(this)));
    }

    /* access modifiers changed from: package-private */
    public void h0(String str, boolean z2, boolean z3, boolean z4) {
        this.progressBar.setVisibility(0);
        if (z2) {
            this.f33159h.b(R0(str));
        }
        if (z3) {
            this.f33159h.b(P0(str));
        }
        if (z4) {
            this.f33159h.b(Q0(str));
        }
    }

    /* access modifiers changed from: package-private */
    public List<RealDebridTorrentInfoObject.FilesBean> i0(List<RealDebridTorrentInfoObject.FilesBean> list) {
        ArrayList arrayList = new ArrayList();
        for (RealDebridTorrentInfoObject.FilesBean next : list) {
            if (next.getBytes() > 30000000) {
                arrayList.add(next);
                next.setSelected(1);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public Pair<List<TorrentObject.FileBean>, Long> j0(TorrentObject torrentObject, String str, int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        Long l2 = new Long(0);
        for (FolderList.ContentBean next : this.f33155d.folderList(PremiumizeCredentialsHelper.b().getAccessToken(), str, Boolean.FALSE).execute().body().getContent()) {
            TorrentObject.FileBean fileBean = new TorrentObject.FileBean(next.getName(), next.getLink(), next.getSize(), String.valueOf(next.getId()));
            fileBean.setQuality(next.getResx() + ContextChain.TAG_PRODUCT);
            if (next.getType().contains("folder")) {
                int i3 = i2 + 1;
                Pair<List<TorrentObject.FileBean>, Long> j02 = j0(torrentObject, next.getId(), i2);
                arrayList.addAll((Collection) j02.first);
                l2 = Long.valueOf(l2.longValue() + ((Long) j02.second).longValue());
                i2 = i3;
            } else {
                l2 = Long.valueOf(l2.longValue() + fileBean.getSize());
                arrayList.add(fileBean);
            }
        }
        return new Pair<>(arrayList, l2);
    }

    public Observable<TorrentObject> k0(final TorrentEntity torrentEntity) {
        return Observable.create(new ObservableOnSubscribe<TorrentObject>() {
            public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                Long l2;
                int i2 = AnonymousClass13.f33173a[torrentEntity.f().ordinal()];
                if (i2 == 1) {
                    Response<RealDebridTorrentInfoObject> execute = AddMagnetDialog.this.f33153b.torrentInfos(torrentEntity.d()).execute();
                    if (execute.isSuccessful() && execute.body() != null) {
                        TorrentObject convert = execute.body().convert();
                        convert.setTorrentEntity(torrentEntity);
                        observableEmitter.onNext(convert);
                    }
                } else if (i2 == 2) {
                    Response<ADstatusSingle> execute2 = AddMagnetDialog.this.f33154c.status(torrentEntity.c(), (String) null).execute();
                    if (!(!execute2.isSuccessful() || execute2.body() == null || execute2.body().getData() == null)) {
                        observableEmitter.onNext(execute2.body().getData().getMagnets().convert());
                    }
                } else if (i2 == 3) {
                    Response<TransferList> execute3 = AddMagnetDialog.this.f33155d.transferlist(PremiumizeCredentialsHelper.b().getAccessToken()).execute();
                    if (execute3.isSuccessful() && execute3.body() != null) {
                        for (TransferList.TransfersBean next : execute3.body().getTransfers()) {
                            if (next.getSrc().toLowerCase().contains(torrentEntity.c())) {
                                ArrayList arrayList = new ArrayList();
                                TorrentObject convert2 = next.convert();
                                Long l3 = new Long(0);
                                if (next.getFolder_id() != null) {
                                    convert2.setFolder_id(next.getFolder_id());
                                    Pair<List<TorrentObject.FileBean>, Long> j02 = AddMagnetDialog.this.j0(convert2, convert2.getId(), 0);
                                    arrayList.addAll((Collection) j02.first);
                                    l2 = Long.valueOf(l3.longValue() + ((Long) j02.second).longValue());
                                } else {
                                    convert2.setId(next.getFile_id());
                                    ItemDetails body = AddMagnetDialog.this.f33155d.itemDetails(PremiumizeCredentialsHelper.b().getAccessToken(), convert2.getId()).execute().body();
                                    TorrentObject.FileBean fileBean = new TorrentObject.FileBean(body.getName(), body.getLink(), body.getSize(), String.valueOf(body.getId()));
                                    fileBean.setQuality(body.getResx() + ContextChain.TAG_PRODUCT);
                                    arrayList.add(fileBean);
                                    l2 = Long.valueOf(l3.longValue() + body.getSize());
                                }
                                convert2.setId(next.getId());
                                convert2.setFiles(arrayList);
                                convert2.setSize(l2.longValue());
                                convert2.setTorrentEntity(torrentEntity);
                                observableEmitter.onNext(convert2);
                            }
                        }
                    }
                }
                observableEmitter.onComplete();
            }
        });
    }

    @OnClick({2131361956})
    public void onAddMagnetBtnClick() {
        if (this.f33159h.isDisposed()) {
            this.f33159h = new CompositeDisposable();
        }
        String lowerCase = Regex.a(this.edtAddMagnet.getText().toString(), "magnet:\\?xt=urn:btih:([^&.]+)", 1).toLowerCase();
        if (!lowerCase.isEmpty()) {
            this.f33164m = lowerCase;
            h0(lowerCase, this.cbRD.isChecked(), this.cbAD.isChecked(), this.cbPM.isChecked());
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerBaseFragmentComponent.a().a(FreeMoviesApp.m((Activity) context).l()).b().w(this);
    }

    @OnClick({2131362277})
    public void onCopyTitleToClipBoard() {
        String name = this.f33160i.getName();
        if (this.f33161j.getSession().intValue() > 0 && this.f33161j.getEps().intValue() > 0) {
            name = name + String.format(" s%02de%02d", new Object[]{this.f33161j.getSession(), this.f33161j.getEps()});
        }
        Utils.p(getActivity(), name, false);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, R.style.DialogStyle90);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.add_magnet_dialog, viewGroup, false);
        this.f33158g = ButterKnife.bind((Object) this, inflate);
        this.f33159h = new CompositeDisposable();
        return inflate;
    }

    public void onDestroyView() {
        this.f33158g.unbind();
        this.f33159h.dispose();
        super.onDestroyView();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f33160i = (MovieEntity) getArguments().getParcelable("movieEntity");
        this.f33161j = (MovieInfo) getArguments().getParcelable("movieInfo");
        this.f33157f = (BaseActivity) getActivity();
        MagnetInfoAdapter magnetInfoAdapter = new MagnetInfoAdapter(new ArrayList());
        this.f33163l = magnetInfoAdapter;
        magnetInfoAdapter.h(this);
        this.rvMagnet.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.rvMagnet.setAdapter(this.f33163l);
        N0();
        M0();
    }
}

package com.movie.ui.fragment.premium;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.database.MvDatabase;
import com.database.entitys.premiumEntitys.torrents.TorrentEntity;
import com.database.entitys.premiumEntitys.torrents.TorrentTypeConverter;
import com.facebook.common.callercontext.ContextChain;
import com.movie.AppComponent;
import com.movie.data.api.alldebrid.AllDebridApi;
import com.movie.data.api.alldebrid.AllDebridModule;
import com.movie.data.api.premiumize.PremiumizeApi;
import com.movie.data.api.premiumize.PremiumizeModule;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.model.TorrentObject;
import com.movie.data.model.premiumize.FolderList;
import com.movie.data.model.premiumize.ItemDetails;
import com.movie.data.model.premiumize.TransferList;
import com.movie.data.model.realdebrid.RealDebridTorrentInfoObject;
import com.movie.data.model.realdebrid.UnRestrictCheckObject;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.fragment.premium.adapter.TorrentAdapter;
import com.movie.ui.listener.EndlessScrollListener;
import com.movie.ui.widget.AnimatorStateView;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.model.debrid.alldebrid.ADstatus;
import com.original.tase.model.debrid.alldebrid.ADstatusSingle;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import retrofit2.Response;
import timber.log.Timber;

public class TorrentAdapterListFragment extends BaseFragment implements EndlessScrollListener.OnLoadMoreCallback, TorrentAdapter.TorrentAdapterListener {

    /* renamed from: d  reason: collision with root package name */
    private final int f33495d = 10;
    @Inject

    /* renamed from: e  reason: collision with root package name */
    MvDatabase f33496e;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    RealDebridApi f33497f;

    /* renamed from: g  reason: collision with root package name */
    AllDebridApi f33498g = AllDebridModule.b();

    /* renamed from: h  reason: collision with root package name */
    PremiumizeApi f33499h = PremiumizeModule.b();

    /* renamed from: i  reason: collision with root package name */
    TorrentAdapter f33500i;

    /* renamed from: j  reason: collision with root package name */
    CompositeDisposable f33501j;

    /* renamed from: k  reason: collision with root package name */
    TorrentObject.Type f33502k;

    /* renamed from: l  reason: collision with root package name */
    EndlessScrollListener f33503l;

    /* renamed from: m  reason: collision with root package name */
    private int f33504m = 0;

    /* renamed from: n  reason: collision with root package name */
    private boolean f33505n = false;

    /* renamed from: o  reason: collision with root package name */
    private int f33506o = 0;
    @BindView(2131362651)
    RecyclerView rv_magnetfiles;
    @BindView(2131362909)
    AnimatorStateView viewEmpty;

    /* renamed from: com.movie.ui.fragment.premium.TorrentAdapterListFragment$11  reason: invalid class name */
    static /* synthetic */ class AnonymousClass11 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33510a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.movie.data.model.TorrentObject$Type[] r0 = com.movie.data.model.TorrentObject.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33510a = r0
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.RD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33510a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.AD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f33510a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.PM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.fragment.premium.TorrentAdapterListFragment.AnonymousClass11.<clinit>():void");
        }
    }

    public static TorrentAdapterListFragment A0(TorrentObject.Type type) {
        Bundle bundle = new Bundle();
        TorrentAdapterListFragment torrentAdapterListFragment = new TorrentAdapterListFragment();
        bundle.putSerializable("type", type);
        torrentAdapterListFragment.setArguments(bundle);
        return torrentAdapterListFragment;
    }

    private void B0(LinearLayoutManager linearLayoutManager, int i2) {
        EndlessScrollListener endlessScrollListener = this.f33503l;
        if (endlessScrollListener != null) {
            this.rv_magnetfiles.removeOnScrollListener(endlessScrollListener);
        }
        EndlessScrollListener f2 = EndlessScrollListener.a(linearLayoutManager, 10, i2).f(this);
        this.f33503l = f2;
        this.rv_magnetfiles.addOnScrollListener(f2);
    }

    public static int d0(TorrentObject.Type type) {
        int i2 = AnonymousClass11.f33510a[type.ordinal()];
        int i3 = 1;
        if (i2 != 1) {
            i3 = 2;
            if (i2 != 2) {
                i3 = 3;
                if (i2 != 3) {
                    return 0;
                }
            }
        }
        return i3;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List e0(ADstatus aDstatus) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (ADstatus.DataBean.MagnetsBean next : aDstatus.getData().getMagnets()) {
            TorrentEntity d2 = this.f33496e.D().d(next.getHash(), String.valueOf(next.getId()), TorrentTypeConverter.b(TorrentObject.Type.AD));
            TorrentObject convert = next.convert();
            convert.setTorrentEntity(d2);
            arrayList.add(convert);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List f0(List list) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((RealDebridTorrentInfoObject) it2.next()).convert());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List g0(TransferList transferList) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (TransferList.TransfersBean convert : transferList.getTransfers()) {
            arrayList.add(convert.convert());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h0(List list) throws Exception {
        int i2 = this.f33504m + 1;
        this.f33504m = i2;
        if (this.f33506o > i2) {
            this.f33506o = i2;
        }
        Timber.b(String.format("Page %d is loaded, %d new items", new Object[]{Integer.valueOf(i2), Integer.valueOf(list.size())}), new Object[0]);
        if (this.f33504m == 1) {
            this.f33500i.d();
        }
        this.f33500i.p(list);
        TorrentObject.Type type = this.f33502k;
        if (type == TorrentObject.Type.AD || type == TorrentObject.Type.PM) {
            this.f33500i.m(false);
        } else {
            this.f33500i.m(!list.isEmpty());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void i0(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void j0(int i2) throws Exception {
        if (this.f33500i.g().size() == 0 && i2 == 1) {
            this.viewEmpty.setMessageText("Empty");
            this.viewEmpty.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k0(TorrentObject torrentObject, Object obj) throws Exception {
        this.f33500i.q(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l0(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void m0(TorrentObject torrentObject, Object obj) throws Exception {
        this.f33500i.q(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n0(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o0(TorrentObject torrentObject, Object obj) throws Exception {
        this.f33500i.q(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p0(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource q0(final String str) throws Exception {
        return Observable.create(new ObservableOnSubscribe<TorrentObject.FileBean>() {
            public void subscribe(ObservableEmitter<TorrentObject.FileBean> observableEmitter) throws Exception {
                Response<UnRestrictCheckObject> execute = TorrentAdapterListFragment.this.f33497f.unrestrictCheck(str, (String) null).execute();
                if (execute.isSuccessful() && execute.body() != null) {
                    UnRestrictCheckObject body = execute.body();
                    observableEmitter.onNext(new TorrentObject.FileBean(body.getFilename(), str, body.getFilesize(), body.getHost()));
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.a());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r0(TorrentObject torrentObject, List list) throws Exception {
        torrentObject.setFiles(list);
        FilesBottomSheetFragment c02 = FilesBottomSheetFragment.c0(torrentObject);
        c02.show(getActivity().getSupportFragmentManager(), c02.getTag());
        ((BaseActivity) getActivity()).hideWaitingDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s0(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
        ((BaseActivity) getActivity()).hideWaitingDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t0(TorrentObject torrentObject) throws Exception {
        torrentObject.setGotDetails(true);
        this.f33500i.t(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u0(Throwable th) throws Exception {
        Utils.i0(getActivity(), "update progress error");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v0(TorrentObject torrentObject) throws Exception {
        torrentObject.setGotDetails(true);
        this.f33500i.t(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w0(Throwable th) throws Exception {
        Utils.i0(getActivity(), "update progress error");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x0(TorrentObject torrentObject) throws Exception {
        torrentObject.setGotDetails(true);
        this.f33500i.t(torrentObject);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y0(Throwable th) throws Exception {
        Utils.i0(getActivity(), "update progress error");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void z0(final int r6) {
        /*
            r5 = this;
            int[] r0 = com.movie.ui.fragment.premium.TorrentAdapterListFragment.AnonymousClass11.f33510a
            com.movie.data.model.TorrentObject$Type r1 = r5.f33502k
            int r1 = r1.ordinal()
            r0 = r0[r1]
            java.lang.String r1 = "You are not logged in"
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L_0x0087
            r4 = 2
            if (r0 == r4) goto L_0x0050
            r4 = 3
            if (r0 == r4) goto L_0x0018
            goto L_0x00bb
        L_0x0018:
            com.original.tase.model.debrid.premiumize.PremiumizeCredentialsInfo r0 = com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper.b()
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x0040
            if (r6 != r2) goto L_0x00bb
            com.movie.ui.fragment.premium.TorrentAdapterListFragment$3 r0 = new com.movie.ui.fragment.premium.TorrentAdapterListFragment$3
            r0.<init>()
            io.reactivex.Observable r0 = io.reactivex.Observable.create(r0)
            com.movie.ui.fragment.premium.k r1 = new com.movie.ui.fragment.premium.k
            r1.<init>()
            io.reactivex.Observable r0 = r0.map(r1)
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.c()
            io.reactivex.Observable r0 = r0.subscribeOn(r1)
            goto L_0x00bc
        L_0x0040:
            com.movie.ui.fragment.premium.adapter.TorrentAdapter r0 = r5.f33500i
            r0.m(r3)
            com.movie.ui.widget.AnimatorStateView r0 = r5.viewEmpty
            r0.setMessageText(r1)
            com.movie.ui.widget.AnimatorStateView r0 = r5.viewEmpty
            r0.setVisibility(r3)
            goto L_0x00bb
        L_0x0050:
            com.original.tase.model.debrid.alldebrid.AllDebridCredentialsInfo r0 = com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper.b()
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x0077
            if (r6 != r2) goto L_0x00bb
            com.movie.ui.fragment.premium.TorrentAdapterListFragment$1 r0 = new com.movie.ui.fragment.premium.TorrentAdapterListFragment$1
            r0.<init>()
            io.reactivex.Observable r0 = io.reactivex.Observable.create(r0)
            com.movie.ui.fragment.premium.c0 r1 = new com.movie.ui.fragment.premium.c0
            r1.<init>(r5)
            io.reactivex.Observable r0 = r0.map(r1)
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.c()
            io.reactivex.Observable r0 = r0.subscribeOn(r1)
            goto L_0x00bc
        L_0x0077:
            com.movie.ui.fragment.premium.adapter.TorrentAdapter r0 = r5.f33500i
            r0.m(r3)
            com.movie.ui.widget.AnimatorStateView r0 = r5.viewEmpty
            r0.setMessageText(r1)
            com.movie.ui.widget.AnimatorStateView r0 = r5.viewEmpty
            r0.setVisibility(r3)
            goto L_0x00bb
        L_0x0087:
            com.original.tase.model.debrid.realdebrid.RealDebridCredentialsInfo r0 = com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper.d()
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x00ac
            com.movie.ui.fragment.premium.TorrentAdapterListFragment$2 r0 = new com.movie.ui.fragment.premium.TorrentAdapterListFragment$2
            r0.<init>(r6)
            io.reactivex.Observable r0 = io.reactivex.Observable.create(r0)
            com.movie.ui.fragment.premium.j r1 = new com.movie.ui.fragment.premium.j
            r1.<init>()
            io.reactivex.Observable r0 = r0.map(r1)
            io.reactivex.Scheduler r1 = io.reactivex.schedulers.Schedulers.c()
            io.reactivex.Observable r0 = r0.subscribeOn(r1)
            goto L_0x00bc
        L_0x00ac:
            com.movie.ui.fragment.premium.adapter.TorrentAdapter r0 = r5.f33500i
            r0.m(r3)
            com.movie.ui.widget.AnimatorStateView r0 = r5.viewEmpty
            r0.setMessageText(r1)
            com.movie.ui.widget.AnimatorStateView r0 = r5.viewEmpty
            r0.setVisibility(r3)
        L_0x00bb:
            r0 = 0
        L_0x00bc:
            if (r0 == 0) goto L_0x00de
            io.reactivex.disposables.CompositeDisposable r1 = r5.f33501j
            io.reactivex.Scheduler r2 = io.reactivex.android.schedulers.AndroidSchedulers.a()
            io.reactivex.Observable r0 = r0.observeOn(r2)
            com.movie.ui.fragment.premium.l r2 = new com.movie.ui.fragment.premium.l
            r2.<init>(r5)
            com.movie.ui.fragment.premium.m r3 = new com.movie.ui.fragment.premium.m
            r3.<init>(r5)
            com.movie.ui.fragment.premium.n r4 = new com.movie.ui.fragment.premium.n
            r4.<init>(r5, r6)
            io.reactivex.disposables.Disposable r6 = r0.subscribe(r2, r3, r4)
            r1.b(r6)
        L_0x00de:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.fragment.premium.TorrentAdapterListFragment.z0(int):void");
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().n(this);
    }

    public void a(final TorrentObject torrentObject, int i2) {
        int i3 = AnonymousClass11.f33510a[torrentObject.getType().ordinal()];
        if (i3 == 1) {
            this.f33501j.b(Observable.create(new ObservableOnSubscribe<TorrentObject>() {
                public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                    Response<RealDebridTorrentInfoObject> execute = TorrentAdapterListFragment.this.f33497f.torrentInfos(torrentObject.getId()).execute();
                    TorrentObject convert = execute.body().convert();
                    convert.setTorrentEntity(TorrentAdapterListFragment.this.f33496e.D().d(execute.body().getHash(), execute.body().getId(), TorrentTypeConverter.b(TorrentObject.Type.RD)));
                    observableEmitter.onNext(convert);
                    observableEmitter.onComplete();
                }
            }).delay((long) i2, TimeUnit.SECONDS).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new i(this), new t(this)));
        } else if (i3 == 2) {
            this.f33501j.b(Observable.create(new ObservableOnSubscribe<TorrentObject>() {
                public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                    ADstatusSingle.DataBean.MagnetsBean magnets = TorrentAdapterListFragment.this.f33498g.status(torrentObject.getHash(), (String) null).execute().body().getData().getMagnets();
                    if (magnets.getHash().equals(torrentObject.getHash())) {
                        TorrentObject convert = magnets.convert();
                        convert.setTorrentEntity(TorrentAdapterListFragment.this.f33496e.D().d(magnets.getHash(), String.valueOf(magnets.getId()), TorrentTypeConverter.b(TorrentObject.Type.AD)));
                        observableEmitter.onNext(convert);
                    }
                    observableEmitter.onComplete();
                }
            }).delay((long) i2, TimeUnit.SECONDS).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new v(this), new w(this)));
        } else if (i3 == 3) {
            this.f33501j.b(Observable.create(new ObservableOnSubscribe<TorrentObject>() {
                public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                    Long l2;
                    ArrayList arrayList = new ArrayList();
                    Long l3 = new Long(0);
                    if (torrentObject.getFolder_id() != null) {
                        TorrentAdapterListFragment torrentAdapterListFragment = TorrentAdapterListFragment.this;
                        TorrentObject torrentObject = torrentObject;
                        Pair<List<TorrentObject.FileBean>, Long> c02 = torrentAdapterListFragment.c0(torrentObject, torrentObject.getFolder_id(), 0);
                        arrayList.addAll((Collection) c02.first);
                        l2 = Long.valueOf(l3.longValue() + ((Long) c02.second).longValue());
                    } else {
                        ItemDetails body = TorrentAdapterListFragment.this.f33499h.itemDetails(PremiumizeCredentialsHelper.b().getAccessToken(), torrentObject.getFile_id()).execute().body();
                        TorrentObject.FileBean fileBean = new TorrentObject.FileBean(body.getName(), body.getLink(), body.getSize(), String.valueOf(body.getId()));
                        fileBean.setQuality(body.getResx() + ContextChain.TAG_PRODUCT);
                        arrayList.add(fileBean);
                        l2 = Long.valueOf(l3.longValue() + body.getSize());
                    }
                    torrentObject.setFiles(arrayList);
                    torrentObject.setSize(l2.longValue());
                    torrentObject.setTorrentEntity(TorrentAdapterListFragment.this.f33496e.D().d(torrentObject.getHash(), torrentObject.getId(), TorrentTypeConverter.b(TorrentObject.Type.PM)));
                    observableEmitter.onNext(torrentObject);
                    observableEmitter.onComplete();
                }
            }).delay((long) i2, TimeUnit.SECONDS).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new x(this), new y(this)));
        }
    }

    /* access modifiers changed from: package-private */
    public Pair<List<TorrentObject.FileBean>, Long> c0(TorrentObject torrentObject, String str, int i2) throws IOException {
        ArrayList arrayList = new ArrayList();
        Long l2 = new Long(0);
        for (FolderList.ContentBean next : this.f33499h.folderList(PremiumizeCredentialsHelper.b().getAccessToken(), str, Boolean.FALSE).execute().body().getContent()) {
            TorrentObject.FileBean fileBean = new TorrentObject.FileBean(next.getName(), next.getLink(), next.getSize(), String.valueOf(next.getId()));
            fileBean.setQuality(next.getResx() + ContextChain.TAG_PRODUCT);
            if (next.getType().contains("folder")) {
                int i3 = i2 + 1;
                Pair<List<TorrentObject.FileBean>, Long> c02 = c0(torrentObject, next.getId(), i2);
                arrayList.addAll((Collection) c02.first);
                l2 = Long.valueOf(l2.longValue() + ((Long) c02.second).longValue());
                i2 = i3;
            } else {
                l2 = Long.valueOf(l2.longValue() + fileBean.getSize());
                arrayList.add(fileBean);
            }
        }
        return new Pair<>(arrayList, l2);
    }

    public void h(TorrentObject torrentObject) {
        int i2 = AnonymousClass11.f33510a[torrentObject.getType().ordinal()];
        if (i2 == 1) {
            ((BaseActivity) getActivity()).showWaitingDialog("checking available links...");
            this.f33501j.b(Observable.fromIterable(torrentObject.getListLink()).flatMap(new z(this)).toList().h(AndroidSchedulers.a()).i(new a0(this, torrentObject), new b0(this)));
        } else if (i2 == 2) {
            FilesBottomSheetFragment c02 = FilesBottomSheetFragment.c0(torrentObject);
            c02.show(getActivity().getSupportFragmentManager(), c02.getTag());
        } else if (i2 == 3) {
            FilesBottomSheetFragment c03 = FilesBottomSheetFragment.c0(torrentObject);
            c03.show(getActivity().getSupportFragmentManager(), c03.getTag());
        }
    }

    public void i(final TorrentObject torrentObject) {
        int i2 = AnonymousClass11.f33510a[torrentObject.getType().ordinal()];
        if (i2 == 1) {
            this.f33501j.b(Observable.create(new ObservableOnSubscribe<Object>() {
                public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                    if (TorrentAdapterListFragment.this.f33497f.delete(torrentObject.getId()).execute().isSuccessful()) {
                        observableEmitter.onNext(new Boolean(true));
                    }
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new o(this, torrentObject), new p(this)));
        } else if (i2 == 2) {
            this.f33501j.b(Observable.create(new ObservableOnSubscribe<Object>() {
                public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                    if (TorrentAdapterListFragment.this.f33498g.delete(torrentObject.getId()).execute().isSuccessful()) {
                        observableEmitter.onNext(new Boolean(true));
                    }
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new q(this, torrentObject), new r(this)));
        } else if (i2 == 3) {
            this.f33501j.b(Observable.create(new ObservableOnSubscribe<Object>() {
                public void subscribe(ObservableEmitter<Object> observableEmitter) throws Exception {
                    if (TorrentAdapterListFragment.this.f33499h.transferdelete(PremiumizeCredentialsHelper.b().getAccessToken(), torrentObject.getId()).execute().isSuccessful()) {
                        observableEmitter.onNext(new Boolean(true));
                    }
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new s(this, torrentObject), new u(this)));
        }
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (d0(this.f33502k) == menuItem.getGroupId()) {
            TorrentObject torrentObject = (TorrentObject) this.f33500i.f(menuItem.getOrder());
            int itemId = menuItem.getItemId();
            if (itemId == 1) {
                i(torrentObject);
            } else if (itemId == 3) {
                h(torrentObject);
            }
        }
        return super.onContextItemSelected(menuItem);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.select_magnet_files_fragment, viewGroup, false);
    }

    public void onDestroy() {
        this.f33501j.d();
        super.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onStart() {
        this.f33504m = 0;
        this.viewEmpty.setVisibility(8);
        this.f33500i.d();
        int i2 = this.f33504m + 1;
        this.f33504m = i2;
        z0(i2);
        super.onStart();
    }

    public void onStop() {
        unregisterForContextMenu(this.rv_magnetfiles);
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f33226c = false;
        this.f33502k = (TorrentObject.Type) getArguments().get("type");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.rv_magnetfiles.setLayoutManager(linearLayoutManager);
        TorrentAdapter torrentAdapter = new TorrentAdapter(getActivity(), new ArrayList());
        this.f33500i = torrentAdapter;
        torrentAdapter.m(true);
        this.f33500i.r(this);
        this.rv_magnetfiles.setAdapter(this.f33500i);
        registerForContextMenu(this.rv_magnetfiles);
        B0(linearLayoutManager, this.f33504m);
        this.f33501j = new CompositeDisposable();
    }

    public void z(int i2, int i3) {
        if (this.f33500i.h()) {
            z0(i2);
        }
    }
}

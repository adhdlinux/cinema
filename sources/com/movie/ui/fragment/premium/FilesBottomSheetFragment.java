package com.movie.ui.fragment.premium;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.ads.videoreward.AdsManager;
import com.database.MvDatabase;
import com.database.entitys.MovieEntity;
import com.database.entitys.premiumEntitys.torrents.TorrentEntity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.movie.FreeMoviesApp;
import com.movie.data.api.alldebrid.AllDebridApi;
import com.movie.data.api.alldebrid.AllDebridModule;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.data.model.MovieInfo;
import com.movie.data.model.TorrentObject;
import com.movie.data.model.realdebrid.RealDebridTorrentInfoObject;
import com.movie.data.model.realdebrid.UnRestrictObject;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.movie.ui.fragment.premium.adapter.FilesTorrentAdapter;
import com.movie.ui.helper.MoviesHelper;
import com.original.tase.Logger;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.StreamAction;
import com.original.tase.model.debrid.alldebrid.ADResponceLink;
import com.original.tase.model.media.MediaSource;
import com.original.tase.utils.Regex;
import com.utils.Utils;
import com.utils.subtitle.ExpandableListSubtitleAdapter;
import com.utils.subtitle.SubtitleInfo;
import com.utils.subtitle.services.SubServiceBase;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.uwetrottmann.thetvdb.TheTvdb;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
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
import javax.inject.Inject;
import javax.inject.Named;
import retrofit2.Response;

public class FilesBottomSheetFragment extends BottomSheetDialogFragment implements FilesTorrentAdapter.FileTorrentListener, PlayerHelper.Listener {
    @Inject

    /* renamed from: b  reason: collision with root package name */
    MoviesHelper f33456b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    RealDebridApi f33457c;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    MvDatabase f33458d;
    @Inject
    @Named("MainActivity")

    /* renamed from: e  reason: collision with root package name */
    PlayerHelper f33459e;
    @Inject

    /* renamed from: f  reason: collision with root package name */
    OpenSubtitleV1Api f33460f;

    /* renamed from: g  reason: collision with root package name */
    AllDebridApi f33461g = AllDebridModule.b();

    /* renamed from: h  reason: collision with root package name */
    LinearLayoutManager f33462h = null;

    /* renamed from: i  reason: collision with root package name */
    TorrentObject f33463i;

    /* renamed from: j  reason: collision with root package name */
    private Unbinder f33464j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public CompositeDisposable f33465k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public FilesTorrentAdapter f33466l;
    @BindView(2131362348)
    ProgressBar loading;

    /* renamed from: m  reason: collision with root package name */
    private MovieEntity f33467m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public AlertDialog f33468n;

    /* renamed from: o  reason: collision with root package name */
    private ExpandableListView f33469o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public ExpandableListSubtitleAdapter f33470p;

    /* renamed from: q  reason: collision with root package name */
    Map<String, List<SubtitleInfo>> f33471q = null;

    /* renamed from: r  reason: collision with root package name */
    private ProgressDialog f33472r = null;
    @BindView(2131362648)
    RecyclerView rvList;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public MediaSource f33473s = null;
    @BindView(2131362662)
    SearchView searchView;

    /* renamed from: t  reason: collision with root package name */
    private ExpandableListSubtitleAdapter f33474t = null;

    /* renamed from: u  reason: collision with root package name */
    private View f33475u = null;

    /* renamed from: v  reason: collision with root package name */
    private TextView f33476v = null;

    /* renamed from: w  reason: collision with root package name */
    MovieInfo f33477w = null;

    /* renamed from: x  reason: collision with root package name */
    boolean f33478x = false;

    /* renamed from: com.movie.ui.fragment.premium.FilesBottomSheetFragment$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33492a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f33493b;

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
                f33493b = r0
                r1 = 1
                com.original.tase.helper.StreamAction$ActionID r2 = com.original.tase.helper.StreamAction.ActionID.PLAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f33493b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.original.tase.helper.StreamAction$ActionID r3 = com.original.tase.helper.StreamAction.ActionID.CAST     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f33493b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.PLAY_WITH_SUBTITLES     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f33493b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.CAST_WITH_SUBTITLES     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f33493b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.OPEN_WITH     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f33493b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.DOWNLOAD     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r3 = f33493b     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.COPY_TO_CLIPBOARD     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r3 = f33493b     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.original.tase.helper.StreamAction$ActionID r4 = com.original.tase.helper.StreamAction.ActionID.OPEN_WITH_PLAYER_PLUGIN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                com.movie.data.model.TorrentObject$Type[] r3 = com.movie.data.model.TorrentObject.Type.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f33492a = r3
                com.movie.data.model.TorrentObject$Type r4 = com.movie.data.model.TorrentObject.Type.RD     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r1 = f33492a     // Catch:{ NoSuchFieldError -> 0x007b }
                com.movie.data.model.TorrentObject$Type r3 = com.movie.data.model.TorrentObject.Type.AD     // Catch:{ NoSuchFieldError -> 0x007b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f33492a     // Catch:{ NoSuchFieldError -> 0x0085 }
                com.movie.data.model.TorrentObject$Type r1 = com.movie.data.model.TorrentObject.Type.PM     // Catch:{ NoSuchFieldError -> 0x0085 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0085 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0085 }
            L_0x0085:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.fragment.premium.FilesBottomSheetFragment.AnonymousClass9.<clinit>():void");
        }
    }

    private String S(String str) {
        String a2 = Regex.a(str, "([Ss]?([0-9]{1,2}))[Eex]", 2);
        String a3 = Regex.a(str, "([Eex]([0-9]{2})(?:[^0-9]|$))", 2);
        int indexOf = str.toLowerCase().indexOf(String.format("s%se%s", new Object[]{a2, a3}));
        if (indexOf > -1) {
            return str.substring(0, indexOf);
        }
        return "";
    }

    private int T() {
        int i2 = 0;
        for (List<SubtitleInfo> size : this.f33471q.values()) {
            i2 += size.size();
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ MediaSource U(MediaSource mediaSource) throws Exception {
        TorrentEntity torrentEntity = this.f33463i.getTorrentEntity();
        if (this.f33463i.getTorrentEntity() != null) {
            this.f33467m = this.f33458d.A().h(torrentEntity.e());
        } else {
            this.f33467m = null;
        }
        return mediaSource;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(MediaSource mediaSource) throws Exception {
        this.f33459e.a0(getActivity(), new ArrayList(), mediaSource);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void W(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(TorrentObject torrentObject) throws Exception {
        FilesTorrentAdapter filesTorrentAdapter = new FilesTorrentAdapter(torrentObject);
        this.f33466l = filesTorrentAdapter;
        filesTorrentAdapter.e(this);
        this.loading.setVisibility(8);
        this.rvList.setAdapter(this.f33466l);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(Throwable th) throws Exception {
        Utils.i0(getActivity(), th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(final MovieEntity movieEntity, final MovieInfo movieInfo, ArrayList arrayList) throws Exception {
        this.f33471q = new HashMap();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            SubtitleInfo subtitleInfo = (SubtitleInfo) it2.next();
            String str = subtitleInfo.f37704d;
            if (!this.f33471q.containsKey(str)) {
                this.f33471q.put(str, new ArrayList());
            }
            this.f33471q.get(str).add(subtitleInfo);
        }
        if (this.f33468n == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            View inflate = getLayoutInflater().inflate(R.layout.dialog_listsubtitle, (ViewGroup) null);
            builder.setView(inflate);
            this.f33475u = inflate.findViewById(R.id.loadMore);
            this.f33476v = (TextView) inflate.findViewById(R.id.subtitleTitle);
            builder.setPositiveButton(R.string.close_msg, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    FilesBottomSheetFragment.this.hideWaitingDialog();
                    FilesBottomSheetFragment.this.f33465k.d();
                }
            });
            this.f33468n = builder.create();
            ExpandableListView expandableListView = (ExpandableListView) inflate.findViewById(R.id.subtitle_expand_view);
            this.f33469o = expandableListView;
            expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
                    FilesBottomSheetFragment.this.f33468n.dismiss();
                    ArrayList arrayList = new ArrayList();
                    arrayList.add((SubtitleInfo) FilesBottomSheetFragment.this.f33470p.getChild(i2, i3));
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(FilesBottomSheetFragment.this.f33473s);
                    FilesBottomSheetFragment.this.f33459e.A(new PlayerHelper.PlayData(movieEntity, FilesBottomSheetFragment.this.f33473s, arrayList2, arrayList, movieInfo));
                    return true;
                }
            });
        }
        ExpandableListSubtitleAdapter expandableListSubtitleAdapter = new ExpandableListSubtitleAdapter(getActivity(), this.f33471q);
        this.f33470p = expandableListSubtitleAdapter;
        this.f33469o.setAdapter(expandableListSubtitleAdapter);
        if (this.f33471q.keySet().size() == 1) {
            this.f33469o.expandGroup(0);
        }
        this.f33468n.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                Logger.b("openSubtitleLoginDialog", "OnCancelListener");
                FilesBottomSheetFragment.this.hideWaitingDialog();
                FilesBottomSheetFragment.this.f33465k.d();
            }
        });
        this.f33476v.setText(String.format("%d subtitles found", new Object[]{Integer.valueOf(T())}));
        this.f33468n.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(Throwable th) throws Exception {
        hideWaitingDialog();
        Utils.h0(getActivity(), R.string.not_subtitle_found);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b0() throws Exception {
        View view;
        if (!(this.f33468n == null || (view = this.f33475u) == null)) {
            view.setVisibility(8);
        }
        if (this.f33471q.size() <= 0) {
            Utils.i0(getActivity(), "No subtitles found");
        }
        hideWaitingDialog();
    }

    public static FilesBottomSheetFragment c0(TorrentObject torrentObject) {
        FilesBottomSheetFragment filesBottomSheetFragment = new FilesBottomSheetFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("infoObject", torrentObject);
        filesBottomSheetFragment.setArguments(bundle);
        return filesBottomSheetFragment;
    }

    public void C(final TorrentObject.FileBean fileBean) {
        Observable observable;
        int i2 = AnonymousClass9.f33492a[this.f33463i.getType().ordinal()];
        if (i2 == 1) {
            observable = Observable.create(new ObservableOnSubscribe<MediaSource>() {
                public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                    MediaSource mediaSource = new MediaSource("User Torrent", "RealDebrid", false);
                    mediaSource.setMovieName(fileBean.getName());
                    Response<UnRestrictObject> execute = FilesBottomSheetFragment.this.f33457c.unrestrictLink(fileBean.getLink(), "", 0).execute();
                    if (execute.code() == 200) {
                        UnRestrictObject body = execute.body();
                        mediaSource.setStreamLink(body.getDownload());
                        mediaSource.setFileSize(body.getFilesize());
                        mediaSource.setRealdebrid(true);
                        mediaSource.setResolved(true);
                        mediaSource.setFilename(body.getFilename());
                        observableEmitter.onNext(mediaSource);
                        return;
                    }
                    throw new Exception("unRestrictObjectResponse Error : " + execute.code());
                }
            }).subscribeOn(Schedulers.c());
        } else if (i2 != 2) {
            if (i2 == 3) {
                MediaSource mediaSource = new MediaSource("User Torrent", "PM", false);
                mediaSource.setMovieName(fileBean.getName());
                mediaSource.setQuality(fileBean.getQuality());
                mediaSource.setStreamLink(fileBean.getLink());
                mediaSource.setFileSize(fileBean.getSize());
                mediaSource.setPremiumize(true);
                mediaSource.setResolved(true);
                mediaSource.setFilename(fileBean.getName());
                this.f33459e.a0(getActivity(), new ArrayList(), mediaSource);
            }
            observable = null;
        } else {
            observable = Observable.create(new ObservableOnSubscribe<MediaSource>() {
                public void subscribe(ObservableEmitter<MediaSource> observableEmitter) throws Exception {
                    MediaSource mediaSource = new MediaSource("User Torrent", "AllDebrid", false);
                    mediaSource.setMovieName(fileBean.getName());
                    Response<ADResponceLink> execute = FilesBottomSheetFragment.this.f33461g.getdownloadlink(fileBean.getLink()).execute();
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
                    observableEmitter.onNext(mediaSource);
                }
            }).subscribeOn(Schedulers.c());
        }
        if (observable != null) {
            this.f33465k.b(observable.map(new c(this)).observeOn(AndroidSchedulers.a()).subscribe(new d(this), new e()));
        }
    }

    public void d0(MovieInfo movieInfo, MovieEntity movieEntity) {
        showWaitingDialog("");
        this.f33465k.b(SubServiceBase.g(movieInfo, this.f33460f, this.f33459e.x()).observeOn(AndroidSchedulers.a()).subscribe(new f(this, movieEntity, movieInfo), new g(this), new h(this)));
    }

    public void hideWaitingDialog() {
        ProgressDialog progressDialog = this.f33472r;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerBaseFragmentComponent.a().a(FreeMoviesApp.m(context).l()).b().s(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.files_torrent_bottom_sheet, viewGroup, false);
        this.f33464j = ButterKnife.bind((Object) this, inflate);
        inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                inflate.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                BottomSheetBehavior I = BottomSheetBehavior.I((FrameLayout) ((BottomSheetDialog) FilesBottomSheetFragment.this.getDialog()).findViewById(R.id.design_bottom_sheet));
                I.S(3);
                I.Q(0);
            }
        });
        return inflate;
    }

    public void onDestroyView() {
        this.f33464j.unbind();
        this.f33465k.dispose();
        super.onDestroyView();
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        if (this.f33478x) {
            AdsManager.d().p(getActivity());
            this.f33478x = false;
        }
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f33459e.V(this);
        this.f33465k = new CompositeDisposable();
        this.f33463i = (TorrentObject) getArguments().getParcelable("infoObject");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        this.f33462h = linearLayoutManager;
        linearLayoutManager.setStackFromEnd(false);
        this.rvList.setLayoutManager(this.f33462h);
        this.rvList.setNestedScrollingEnabled(true);
        this.loading.setVisibility(0);
        if (this.f33463i.isGotDetails()) {
            FilesTorrentAdapter filesTorrentAdapter = new FilesTorrentAdapter(this.f33463i);
            this.f33466l = filesTorrentAdapter;
            filesTorrentAdapter.e(this);
            this.loading.setVisibility(8);
            this.rvList.setAdapter(this.f33466l);
        } else {
            this.f33465k.b(Observable.create(new ObservableOnSubscribe<TorrentObject>() {
                public void subscribe(ObservableEmitter<TorrentObject> observableEmitter) throws Exception {
                    FilesBottomSheetFragment filesBottomSheetFragment = FilesBottomSheetFragment.this;
                    Response<RealDebridTorrentInfoObject> execute = filesBottomSheetFragment.f33457c.torrentInfos(filesBottomSheetFragment.f33463i.getId()).execute();
                    if (execute.isSuccessful() && execute.body() != null) {
                        observableEmitter.onNext(execute.body().convert());
                    }
                    observableEmitter.onComplete();
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(this), new b(this)));
        }
        this.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            public boolean a(String str) {
                FilesBottomSheetFragment.this.f33466l.getFilter().filter(str);
                return false;
            }

            public boolean b(String str) {
                return false;
            }
        });
        this.searchView.setSearchableInfo(((SearchManager) getContext().getSystemService("search")).getSearchableInfo(getActivity().getComponentName()));
        this.searchView.requestFocus();
    }

    public void s(StreamAction.ActionID actionID, MediaSource mediaSource) {
        String str;
        this.f33473s = mediaSource;
        String movieName = mediaSource.getMovieName();
        Utils.i0(getActivity(), S(movieName));
        ArrayList<String> h2 = Regex.h(movieName, "(?:PPV\\.)?[HP]DTV|(?:HD)?CAM|B[rR]Rip|TS|(?:PPV )?WEB-?DL(?: DVDRip)?|H[dD]Rip|DVDRip|DVDRiP|DVDRIP|CamRip|W[EB]B[rR]ip|[Bb]lu[Rr]ay|DvDScr|hdtv", false);
        String a2 = Regex.a(movieName, "([Ss]?([0-9]{1,2}))[Eex]", 2);
        String a3 = Regex.a(movieName, "([Eex]([0-9]{2})(?:[^0-9]|$))", 2);
        String str2 = "-1";
        if (a2 == null || a2.isEmpty()) {
            str = str2;
        } else {
            str = a2;
        }
        if (a3 != null && !a3.isEmpty()) {
            str2 = a3;
        }
        ArrayList<String> h3 = Regex.h(movieName, "([\\[\\(]?((?:19[0-9]|20[01])[0-9])[\\]\\)]?)", false);
        Regex.h(movieName, "/xvid|x264|h\\.?264/i", false);
        Regex.h(movieName, "(([0-9]{3,4}p))", false);
        this.f33473s.setQuality(Utils.f(h2, "HD", false));
        MovieEntity movieEntity = this.f33467m;
        if (movieEntity == null) {
            movieEntity = new MovieEntity();
            movieEntity.setRealeaseDate(Utils.f(h3, "1997", true));
            movieEntity.setName(this.f33473s.getMovieName());
        }
        MovieEntity movieEntity2 = movieEntity;
        MovieInfo movieInfo = new MovieInfo(movieName, Utils.f(h3, "1997", true), str, str2, Utils.f(h2, "1997", true));
        this.f33477w = movieInfo;
        movieInfo.imdbIDStr = movieEntity2.getImdbIDStr();
        if (!movieEntity2.getRealeaseDate().isEmpty()) {
            String str3 = movieEntity2.getRealeaseDate().split("-")[0];
        }
        this.f33477w.tmdbID = movieEntity2.getTmdbID();
        int i2 = AnonymousClass9.f33493b[actionID.ordinal()];
        if (i2 == 1 || i2 == 2) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f33473s);
            this.f33459e.A(new PlayerHelper.PlayData(movieEntity2, this.f33473s, arrayList, (List<? extends SubtitleInfo>) null, this.f33477w));
        } else if (i2 == 3 || i2 == 4) {
            this.f33477w.fileName = this.f33473s.getFilename();
            d0(this.f33477w, movieEntity2);
        } else if (i2 == 5) {
            this.f33459e.F(new PlayerHelper.PlayData(movieEntity2, this.f33473s, new ArrayList(), (List<? extends SubtitleInfo>) null, this.f33477w));
        } else if (i2 == 7) {
            Utils.p(getActivity(), this.f33473s.getStreamLink(), false);
        }
    }

    public void showWaitingDialog(String str) {
        if (this.f33472r == null) {
            ProgressDialog progressDialog = new ProgressDialog(getActivity());
            this.f33472r = progressDialog;
            try {
                progressDialog.show();
            } catch (WindowManager.BadTokenException unused) {
            }
        }
        this.f33472r.setCancelable(true);
        this.f33472r.getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.f33472r.setContentView(R.layout.progressbar);
        TextView textView = (TextView) this.f33472r.findViewById(R.id.tv_title);
        if (!str.isEmpty()) {
            textView.setText(str);
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        this.f33472r.show();
    }

    public void x(boolean z2) {
        this.f33478x = true;
    }
}

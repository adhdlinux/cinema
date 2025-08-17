package com.movie.ui.activity.gamechallenge;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.movie.AppComponent;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.gamechallenge.GameChallengeModel;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.DaggerBaseActivityComponent;
import com.movie.ui.activity.gamechallenge.GameItemAdapter;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class GameChallenge extends BaseActivity implements GameItemAdapter.GameAdapterListener {

    /* renamed from: b  reason: collision with root package name */
    GameItemAdapter f32224b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    MoviesApi f32225c;

    /* renamed from: d  reason: collision with root package name */
    CompositeDisposable f32226d;
    @BindView(2131362646)
    RecyclerView rvApllication;

    /* access modifiers changed from: private */
    public /* synthetic */ void F(PackageManager packageManager, List list, GameChallengeModel gameChallengeModel) throws Exception {
        if (gameChallengeModel != null) {
            for (GameChallengeModel.AndroidBean next : gameChallengeModel.getAndroid()) {
                PromotionAppModel promotionAppModel = new PromotionAppModel();
                promotionAppModel.j(next.getPackageX());
                promotionAppModel.i(next.getName());
                promotionAppModel.f(next.getDescription());
                promotionAppModel.h(next.getIcon());
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(next.getPackageX(), 0);
                    if (packageInfo != null) {
                        promotionAppModel.g(packageInfo.applicationInfo.loadIcon(packageManager));
                    }
                } catch (Exception unused) {
                }
                list.add(promotionAppModel);
                this.f32224b.h(list);
            }
        }
        this.f32224b.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void G(Throwable th) throws Exception {
    }

    /* access modifiers changed from: package-private */
    public List<PromotionAppModel> E() {
        ArrayList arrayList = new ArrayList();
        this.f32226d.b(this.f32225c.getGameChallengeList("android", Utils.t()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new c(this, getPackageManager(), arrayList), new d()));
        return arrayList;
    }

    public void d(PromotionAppModel promotionAppModel) {
        Utils.i0(this, promotionAppModel.e());
        this.f32226d.b(this.f32225c.getGameChallengeData(promotionAppModel.e(), Utils.t()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a(), new b()));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_game_challenge);
        this.f32226d = new CompositeDisposable();
        this.rvApllication.setLayoutManager(new LinearLayoutManager(this));
        GameItemAdapter d2 = GameItemAdapter.d(new ArrayList(), this);
        this.f32224b = d2;
        this.rvApllication.setAdapter(d2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32226d.dispose();
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        E();
        this.f32224b.g(this);
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().j(this);
    }
}

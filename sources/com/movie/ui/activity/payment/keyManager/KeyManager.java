package com.movie.ui.activity.payment.keyManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.movie.AppComponent;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.AppConfig;
import com.movie.data.model.cinema.KeyResponse;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.DaggerBaseActivityComponent;
import com.movie.ui.activity.payment.keyManager.DevicesApdater;
import com.movie.ui.widget.AnimatorStateView;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Iterator;
import javax.inject.Inject;

public class KeyManager extends BaseActivity implements DevicesApdater.DeviceItemListener {

    /* renamed from: b  reason: collision with root package name */
    DevicesApdater f32328b;
    @Inject

    /* renamed from: c  reason: collision with root package name */
    MoviesApi f32329c;

    /* renamed from: d  reason: collision with root package name */
    String f32330d;

    /* renamed from: e  reason: collision with root package name */
    String f32331e;

    /* renamed from: f  reason: collision with root package name */
    String f32332f;

    /* renamed from: g  reason: collision with root package name */
    CompositeDisposable f32333g = new CompositeDisposable();
    @BindView(2131362602)
    ProgressBar loading;
    @BindView(2131362647)
    RecyclerView rvDeviceItems;
    @BindView(2131362826)
    Toolbar toolbar;
    @BindView(2131362910)
    AnimatorStateView view_error;

    /* access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(KeyResponse.DevicesBean devicesBean, AppConfig appConfig) throws Exception {
        Iterator<KeyResponse.DevicesBean> it2 = this.f32328b.c().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            KeyResponse.DevicesBean next = it2.next();
            if (next.getId().equals(devicesBean.getId())) {
                this.f32328b.c().remove(next);
                this.f32328b.notifyDataSetChanged();
                break;
            }
        }
        Utils.i0(this, "deleted");
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(Throwable th) throws Exception {
        Utils.i0(this, th.getMessage());
        this.view_error.setVisibility(0);
        this.view_error.setMessageText(th.getMessage());
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K(KeyResponse keyResponse) throws Exception {
        DevicesApdater devicesApdater = new DevicesApdater();
        this.f32328b = devicesApdater;
        devicesApdater.f(this);
        this.f32328b.g(keyResponse.getDevices());
        this.rvDeviceItems.setAdapter(this.f32328b);
        this.loading.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(Throwable th) throws Exception {
        Utils.i0(this, th.getMessage());
        this.view_error.setVisibility(0);
        this.view_error.setMessageText(th.getMessage());
        this.loading.setVisibility(4);
    }

    private void M(String str, String str2, String str3) {
        this.f32333g.b(this.f32329c.getActivateInfo(str3, str, str2).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new c(this), new d(this)));
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_key_manager);
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.t(true);
            this.toolbar.setTitle((CharSequence) "Devices List");
            this.toolbar.setNavigationOnClickListener(new a(this));
        }
        getToolbar().setNavigationOnClickListener(new b(this));
        this.rvDeviceItems.setLayoutManager(new LinearLayoutManager(this));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f32330d = extras.getString("TRANSACTION");
            this.f32331e = extras.getString("EMAIL");
            this.f32332f = extras.getString("KEY");
        }
        M(this.f32330d, this.f32331e, this.f32332f);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32333g.dispose();
        super.onDestroy();
    }

    public void r(KeyResponse.DevicesBean devicesBean) {
        this.f32333g.b(this.f32329c.deactiveKey(this.f32332f, devicesBean.getId()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e(this, devicesBean), new f(this)));
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().i(this);
    }
}

package com.movie.ui.activity.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.ads.videoreward.AdsManager;
import com.google.gson.Gson;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.AppConfig;
import com.movie.data.model.cinema.KeyResponse;
import com.movie.data.model.payment.bitcoin.BitcoinPaymentInfo;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.original.tase.helper.DateTimeHelper;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;
import org.joda.time.DateTime;

public class PaymentResultFragment extends BaseFragment {
    @BindView(2131361953)
    Button btnRestart;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    MoviesApi f32301d;

    /* renamed from: e  reason: collision with root package name */
    CompositeDisposable f32302e;
    @BindView(2131362608)
    ProgressBar progressBar;
    @BindView(2131362865)
    TextView tvStatus;
    @BindView(2131362869)
    TextView tvTitlte;

    /* access modifiers changed from: private */
    public /* synthetic */ AppConfig L(BitcoinPaymentInfo bitcoinPaymentInfo, AppConfig appConfig) throws Exception {
        this.tvStatus.setText("Member code is activated. You must restart app to get effect");
        if (appConfig != null && appConfig.getAds() == null) {
            AdsManager.d().c();
            GlobalVariable.c().d(new Gson().u(appConfig));
            Utils.s0(bitcoinPaymentInfo.getKey());
        }
        return appConfig;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource M(BitcoinPaymentInfo bitcoinPaymentInfo, AppConfig appConfig) throws Exception {
        return this.f32301d.getActivateInfo(bitcoinPaymentInfo.getKey(), (String) null, (String) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(BitcoinPaymentInfo bitcoinPaymentInfo, KeyResponse keyResponse) throws Exception {
        TextView textView = this.tvStatus;
        textView.setText(this.tvStatus.getText() + "\nKey code : " + bitcoinPaymentInfo.getKey());
        TextView textView2 = this.tvStatus;
        textView2.setText(this.tvStatus.getText() + "\nExpired time : " + DateTimeHelper.b(DateTime.parse(keyResponse.getStartTime()).plus(keyResponse.getTtl()).toString()));
        TextView textView3 = this.tvStatus;
        textView3.setText(this.tvStatus.getText() + "\nRemaining devices : " + (keyResponse.getLimit() - keyResponse.getCurrentNumberOfDevice()));
        this.progressBar.setVisibility(8);
        this.btnRestart.setVisibility(0);
        Utils.s0(bitcoinPaymentInfo.getKey());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(Throwable th) throws Exception {
        TextView textView = this.tvStatus;
        textView.setText(this.tvStatus.getText() + "\n\nError : " + th.getMessage());
        this.progressBar.setVisibility(8);
    }

    public static PaymentResultFragment P(BitcoinPaymentInfo bitcoinPaymentInfo) {
        PaymentResultFragment paymentResultFragment = new PaymentResultFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("bitcoinPaymentInfo", bitcoinPaymentInfo);
        paymentResultFragment.setArguments(bundle);
        return paymentResultFragment;
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().m(this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_bitcoin_payment_result, viewGroup, false);
    }

    public void onDestroy() {
        this.f32302e.dispose();
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361953})
    public void onRestartClick() {
        Utils.q0(getActivity());
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.tvTitlte.setText("Activation");
        BitcoinPaymentInfo bitcoinPaymentInfo = (BitcoinPaymentInfo) getArguments().getParcelable("bitcoinPaymentInfo");
        this.f32302e = new CompositeDisposable();
        if (bitcoinPaymentInfo.getStatus().intValue() == 0) {
            this.f32302e.b(this.f32301d.activeKey(bitcoinPaymentInfo.getKey()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).map(new l(this, bitcoinPaymentInfo)).observeOn(Schedulers.c()).flatMap(new m(this, bitcoinPaymentInfo)).observeOn(AndroidSchedulers.a()).subscribe(new n(this, bitcoinPaymentInfo), new o(this)));
            return;
        }
        Boolean valueOf = Boolean.valueOf(FreeMoviesApp.p().getBoolean("pref_payment_bit_split_keys_mode", false));
        String string = FreeMoviesApp.p().getString("pref_payment_bit_mail", "");
        if (valueOf.booleanValue()) {
            TextView textView = this.tvStatus;
            textView.setText(this.tvStatus.getText() + "\nYour multiple keys will send to " + string);
        }
        this.progressBar.setVisibility(8);
        this.btnRestart.setVisibility(0);
    }
}

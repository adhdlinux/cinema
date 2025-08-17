package com.movie.ui.activity.payment;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import com.google.gson.Gson;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.model.payment.bitcoin.BitcoinPaymentInfo;
import com.movie.data.model.payment.bitcoin.ProductResponse;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.payment.ChooseProductFragment;
import com.movie.ui.activity.payment.PaymentProcessingFragment;
import com.yoku.marumovie.R;

public class BitcoinGatewayActivity extends BaseActivity implements ChooseProductFragment.ChooseProductListListener, PaymentProcessingFragment.PaymentProcessingFragmentListener {

    /* renamed from: b  reason: collision with root package name */
    Boolean f32255b = Boolean.FALSE;
    @BindView(2131362826)
    Toolbar toolbar;

    /* access modifiers changed from: private */
    public /* synthetic */ void A(View view) {
        for (Fragment next : getSupportFragmentManager().t0()) {
            if (next instanceof IOnBackPressed) {
                ((IOnBackPressed) next).onBackPressed();
                return;
            }
        }
        finish();
    }

    private void B(Fragment fragment) {
        getSupportFragmentManager().n().q(R.id.content, fragment, "payment_process_step").r(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).i();
    }

    public void e(ProductResponse.ResultsBean resultsBean, String str, Boolean bool) {
        this.f32255b = bool;
        B(PaymentProcessingFragment.a0(this, "", resultsBean, str, bool));
    }

    public void onBackPressed() {
        for (Fragment next : getSupportFragmentManager().t0()) {
            if (next instanceof IOnBackPressed) {
                ((IOnBackPressed) next).onBackPressed();
                return;
            }
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bitcoin_gateway);
        setSupportActionBar(this.toolbar);
        this.f32255b = Boolean.valueOf(getIntent().getExtras().getBoolean("isSplitKey"));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.t(true);
            this.toolbar.setTitle((CharSequence) "Bitcoin payment with 3 steps");
            this.toolbar.setNavigationOnClickListener(new a(this));
        }
        String string = FreeMoviesApp.p().getString("pref_payment_bit_address", "");
        if (string.isEmpty()) {
            B(ChooseProductFragment.Q(this));
            return;
        }
        B(PaymentProcessingFragment.a0(this, string, (ProductResponse.ResultsBean) new Gson().l(FreeMoviesApp.p().getString("pref_payment_bit_product_id", ""), ProductResponse.ResultsBean.class), FreeMoviesApp.p().getString("pref_payment_bit_mail", ""), this.f32255b));
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }

    public void t(BitcoinPaymentInfo bitcoinPaymentInfo) {
        B(PaymentResultFragment.P(bitcoinPaymentInfo));
    }
}

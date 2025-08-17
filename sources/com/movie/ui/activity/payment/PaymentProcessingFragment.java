package com.movie.ui.activity.payment;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.Scopes;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.payment.bitcoin.BitcoinAddressResponse;
import com.movie.data.model.payment.bitcoin.BitcoinAdressRequest;
import com.movie.data.model.payment.bitcoin.BitcoinCancelPaymentRequest;
import com.movie.data.model.payment.bitcoin.BitcoinPaymentInfo;
import com.movie.data.model.payment.bitcoin.ProductResponse;
import com.movie.ui.fragment.BaseFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import okhttp3.ResponseBody;

public class PaymentProcessingFragment extends BaseFragment implements IOnBackPressed {
    @BindView(2131361945)
    Button btnCancelPayment;
    @BindView(2131361947)
    Button btnCopyAddress;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    MoviesApi f32269d;

    /* renamed from: e  reason: collision with root package name */
    CompositeDisposable f32270e;

    /* renamed from: f  reason: collision with root package name */
    long f32271f = 0;

    /* renamed from: g  reason: collision with root package name */
    long f32272g = 0;

    /* renamed from: h  reason: collision with root package name */
    private PaymentProcessingFragmentListener f32273h;

    /* renamed from: i  reason: collision with root package name */
    private ProductResponse.ResultsBean f32274i;
    @BindView(2131362270)
    ImageView imgAddressQR;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f32275j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f32276k;

    /* renamed from: l  reason: collision with root package name */
    private String f32277l;
    @BindView(2131362305)
    ConstraintLayout layout_address_content;

    /* renamed from: m  reason: collision with root package name */
    private Boolean f32278m = Boolean.FALSE;

    /* renamed from: n  reason: collision with root package name */
    private CountDownTimer f32279n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public long f32280o = 60000;
    @BindView(2131362603)
    ProgressBar progressBarCircle;
    @BindView(2131362608)
    ProgressBar progressbar;
    @BindView(2131362799)
    TextView textViewTime;
    @BindView(2131362849)
    TextView tvBTC;
    @BindView(2131362869)
    TextView tvTitle;
    @BindView(2131362874)
    TextView tvaddress;

    public interface PaymentProcessingFragmentListener {
        void t(BitcoinPaymentInfo bitcoinPaymentInfo);
    }

    /* access modifiers changed from: private */
    public String U(long j2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format("%02d:%02d", new Object[]{Long.valueOf(timeUnit.toMinutes(j2) - TimeUnit.HOURS.toMinutes(timeUnit.toHours(j2))), Long.valueOf(timeUnit.toSeconds(j2) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j2)))});
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void V(CompositeDisposable compositeDisposable, BitcoinPaymentInfo bitcoinPaymentInfo) throws Exception {
        if (bitcoinPaymentInfo != null && bitcoinPaymentInfo.getKey() != null) {
            this.f32273h.t(bitcoinPaymentInfo);
            compositeDisposable.dispose();
            FreeMoviesApp.p().edit().putString("pref_payment_bit_address", "").apply();
            FreeMoviesApp.p().edit().putBoolean("pref_payment_bit_split_keys_mode", false).apply();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X(CompositeDisposable compositeDisposable, BitcoinAddressResponse bitcoinAddressResponse, Long l2) throws Exception {
        Log.d("PAYMENT", "moviesApi.paymentInfo count = " + l2);
        compositeDisposable.b(this.f32269d.paymentInfo(bitcoinAddressResponse.getAddress(), this.f32275j, Utils.t(), Utils.C(), this.f32278m).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new h(this, compositeDisposable), new i()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(BitcoinAddressResponse bitcoinAddressResponse) throws Exception {
        this.progressbar.setVisibility(8);
        this.layout_address_content.setVisibility(0);
        FreeMoviesApp.p().edit().putBoolean("pref_payment_bit_split_keys_mode", bitcoinAddressResponse.getSplitKey().booleanValue()).apply();
        String address = bitcoinAddressResponse.getAddress();
        if (address == null || address.isEmpty()) {
            final AlertDialog create = new AlertDialog.Builder(getActivity()).g(bitcoinAddressResponse.getMessage()).create();
            create.setCancelable(false);
            create.d(-1, "ok", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    create.dismiss();
                    FreeMoviesApp.p().edit().putString("pref_payment_bit_address", "").apply();
                    PaymentProcessingFragment.this.getActivity().finish();
                }
            });
            create.show();
            return;
        }
        FreeMoviesApp.p().edit().putString("pref_payment_bit_address", address).apply();
        if (bitcoinAddressResponse.getRemainingTime() != null) {
            this.f32280o = bitcoinAddressResponse.getRemainingTime().longValue();
        } else {
            this.f32280o -= this.f32272g - this.f32271f;
        }
        d0();
        this.tvaddress.setText(bitcoinAddressResponse.getAddress());
        String btc = bitcoinAddressResponse.getBtc();
        this.f32277l = btc;
        Utils.x0(this.tvBTC, String.format("Send exactly %s BTC to above address", new Object[]{btc}), this.f32277l, -16711936, 1.3f);
        this.f32276k = bitcoinAddressResponse.getAddress();
        b0(bitcoinAddressResponse.getAddress());
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        compositeDisposable.b(Observable.interval(1000, 5000, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.c()).subscribe(new g(this, compositeDisposable, bitcoinAddressResponse)));
        this.f32270e.b(compositeDisposable);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void Z(Throwable th) throws Exception {
    }

    public static PaymentProcessingFragment a0(PaymentProcessingFragmentListener paymentProcessingFragmentListener, String str, ProductResponse.ResultsBean resultsBean, String str2, Boolean bool) {
        PaymentProcessingFragment paymentProcessingFragment = new PaymentProcessingFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppLovinEventTypes.USER_VIEWED_PRODUCT, resultsBean);
        bundle.putString(Scopes.EMAIL, str2);
        bundle.putString("oldAdress", str);
        bundle.putBoolean("isSplitKey", bool.booleanValue());
        paymentProcessingFragment.setArguments(bundle);
        paymentProcessingFragment.f32273h = paymentProcessingFragmentListener;
        return paymentProcessingFragment;
    }

    /* access modifiers changed from: private */
    public void c0() {
        this.progressBarCircle.setMax(((int) this.f32280o) / 1000);
        this.progressBarCircle.setProgress(((int) this.f32280o) / 1000);
    }

    private void d0() {
        CountDownTimer countDownTimer = this.f32279n;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer start = new CountDownTimer(this.f32280o, 1000) {
            public void onFinish() {
                PaymentProcessingFragment paymentProcessingFragment = PaymentProcessingFragment.this;
                paymentProcessingFragment.textViewTime.setText(paymentProcessingFragment.U(paymentProcessingFragment.f32280o));
                PaymentProcessingFragment.this.c0();
            }

            public void onTick(long j2) {
                PaymentProcessingFragment paymentProcessingFragment = PaymentProcessingFragment.this;
                paymentProcessingFragment.textViewTime.setText(paymentProcessingFragment.U(j2));
                PaymentProcessingFragment.this.progressBarCircle.setProgress((int) (j2 / 1000));
            }
        }.start();
        this.f32279n = start;
        start.start();
    }

    private void e0() {
        CountDownTimer countDownTimer = this.f32279n;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* access modifiers changed from: protected */
    public void F(AppComponent appComponent) {
        DaggerBaseFragmentComponent.a().a(appComponent).b().y(this);
    }

    public void T() {
        final AlertDialog create = new AlertDialog.Builder(getActivity()).g("Do you want to cancel payment process ? \n(Sometime Blockchain service is busy, receipt maybe come lately to our server. If you have already sent the BTC, please click WAIT button)").create();
        create.setCancelable(false);
        create.d(-1, "YES", new DialogInterface.OnClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void c(AlertDialog alertDialog, ResponseBody responseBody) throws Exception {
                if (responseBody.string().contains("done")) {
                    alertDialog.dismiss();
                    PaymentProcessingFragment.this.getActivity().finish();
                    FreeMoviesApp.p().edit().putString("pref_payment_bit_address", "").apply();
                    FreeMoviesApp.p().edit().putBoolean("isSplitKey", false);
                    return;
                }
                PaymentProcessingFragment.this.G("cancel error");
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void d(Throwable th) throws Exception {
                PaymentProcessingFragment.this.G("cancel error");
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                BitcoinCancelPaymentRequest bitcoinCancelPaymentRequest = new BitcoinCancelPaymentRequest();
                bitcoinCancelPaymentRequest.setAddress(PaymentProcessingFragment.this.f32276k);
                bitcoinCancelPaymentRequest.setEmail(PaymentProcessingFragment.this.f32275j);
                bitcoinCancelPaymentRequest.setDeviceID(Utils.t());
                PaymentProcessingFragment paymentProcessingFragment = PaymentProcessingFragment.this;
                paymentProcessingFragment.f32270e.b(paymentProcessingFragment.f32269d.cancelPayment(bitcoinCancelPaymentRequest).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new j(this, create), new k(this)));
            }
        });
        create.d(-2, "NO", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                create.dismiss();
            }
        });
        create.d(-3, "Wait", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                Utils.i0(PaymentProcessingFragment.this.getActivity(), "Please come back later ...");
                PaymentProcessingFragment.this.getActivity().finish();
            }
        });
        create.show();
    }

    public void b0(String str) {
        int i2;
        try {
            BitMatrix a2 = new QRCodeWriter().a(str, BarcodeFormat.QR_CODE, 512, 512);
            int d2 = a2.d();
            int c2 = a2.c();
            Bitmap createBitmap = Bitmap.createBitmap(d2, c2, Bitmap.Config.RGB_565);
            for (int i3 = 0; i3 < d2; i3++) {
                for (int i4 = 0; i4 < c2; i4++) {
                    if (a2.b(i3, i4)) {
                        i2 = -16777216;
                    } else {
                        i2 = -1;
                    }
                    createBitmap.setPixel(i3, i4, i2);
                }
            }
            this.imgAddressQR.setImageBitmap(createBitmap);
        } catch (WriterException e2) {
            e2.printStackTrace();
        }
    }

    public boolean onBackPressed() {
        T();
        return true;
    }

    @OnClick({2131361945})
    public void onBtnCancelPaymentClick() {
        T();
    }

    @OnClick({2131361948})
    public void onBtnCopyBTCClick() {
        Utils.p(getActivity(), this.f32277l, false);
    }

    @OnLongClick({2131361948})
    public void onBtnCopyBTCLongClick() {
        Utils.p(getActivity(), this.f32277l, true);
    }

    @OnClick({2131361947})
    public void onBtnCopyClick() {
        Utils.p(getActivity(), this.f32276k, false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_bitcoin_processing, viewGroup, false);
    }

    public void onDestroy() {
        e0();
        super.onDestroy();
    }

    public void onPause() {
        this.f32271f = System.currentTimeMillis();
        this.f32270e.dispose();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f32272g = System.currentTimeMillis();
        BitcoinAdressRequest bitcoinAdressRequest = new BitcoinAdressRequest();
        bitcoinAdressRequest.setDeviceID(Utils.t());
        bitcoinAdressRequest.setEmail(this.f32275j);
        bitcoinAdressRequest.setDeviceName(Utils.C());
        bitcoinAdressRequest.setProductID(this.f32274i.getId());
        bitcoinAdressRequest.setTest(Boolean.FALSE);
        bitcoinAdressRequest.setAddress(this.f32276k);
        bitcoinAdressRequest.setSplitKey(this.f32278m);
        this.layout_address_content.setVisibility(8);
        this.progressbar.setVisibility(0);
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        this.f32270e = compositeDisposable;
        compositeDisposable.b(this.f32269d.requestAddress(bitcoinAdressRequest).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e(this), new f()));
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        view.getContext();
        this.f32275j = arguments.getString(Scopes.EMAIL);
        this.f32274i = (ProductResponse.ResultsBean) arguments.getParcelable(AppLovinEventTypes.USER_VIEWED_PRODUCT);
        this.f32276k = arguments.getString("oldAdress");
        this.f32278m = Boolean.valueOf(arguments.getBoolean("isSplitKey"));
    }
}

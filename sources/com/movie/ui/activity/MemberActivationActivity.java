package com.movie.ui.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;
import com.ads.videoreward.AdsManager;
import com.google.gson.Gson;
import com.movie.AppComponent;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.api.MoviesApi;
import com.movie.data.model.AppConfig;
import com.movie.data.model.payment.bitcoin.BitcoinAddressResponse;
import com.movie.data.model.payment.bitcoin.BitcoinAdressRequest;
import com.movie.data.model.payment.bitcoin.ProductResponse;
import com.movie.ui.activity.gamechallenge.GameChallenge;
import com.movie.ui.activity.payment.BitcoinGatewayActivity;
import com.movie.ui.activity.payment.keyManager.KeyManager;
import com.original.tase.I18N;
import com.original.tase.model.socket.UserResponces;
import com.utils.Utils;
import com.yoku.marumovie.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import javax.inject.Inject;

public class MemberActivationActivity extends BaseActivity {
    @BindView(2131361878)
    ConstraintLayout activateResult;
    @BindView(2131361880)
    Button activeNow;

    /* renamed from: b  reason: collision with root package name */
    ProgressDialog f32084b = null;
    @BindView(2131361947)
    Button btnCopy;
    @BindView(2131361952)
    Button btnRemove;
    @BindView(2131361957)
    Button btn_amz_gift;
    @BindView(2131361958)
    Button btn_bitcoin;
    @BindView(2131361960)
    Button btn_game_challenge;

    /* renamed from: c  reason: collision with root package name */
    CompositeDisposable f32085c;
    @BindView(2131362044)
    TextView code;
    @Inject

    /* renamed from: d  reason: collision with root package name */
    MoviesApi f32086d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f32087e = "";

    /* renamed from: f  reason: collision with root package name */
    private List<AppConfig.PaymentMethod> f32088f = null;
    @BindView(2131362284)
    ConstraintLayout introLayout;
    @BindView(2131362348)
    ProgressBar loading;
    @BindView(2131362550)
    ProgressBar pbbitcoin;
    @BindView(2131362826)
    Toolbar toolbar;

    private AppConfig.PaymentMethod I(String str) {
        List<AppConfig.PaymentMethod> list = this.f32088f;
        if (list == null) {
            return null;
        }
        for (AppConfig.PaymentMethod next : list) {
            if (next.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007c, code lost:
        if (r4.compareTo((org.joda.time.ReadableInstant) org.joda.time.DateTime.now()) < 0) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void K(java.lang.String r8, com.movie.data.model.cinema.KeyResponse r9) throws java.lang.Exception {
        /*
            r7 = this;
            com.movie.data.api.GlobalVariable r0 = com.movie.data.api.GlobalVariable.c()
            com.movie.data.model.AppConfig r0 = r0.b()
            com.movie.data.model.AppConfig$AdsBean r0 = r0.getAds()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0012
            r0 = 1
            goto L_0x0013
        L_0x0012:
            r0 = 0
        L_0x0013:
            r3 = 8
            if (r9 == 0) goto L_0x00d8
            java.lang.String r4 = r9.getId()
            if (r4 == 0) goto L_0x00d8
            java.lang.String r4 = r9.getId()
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x00d8
            android.widget.Button r4 = r7.activeNow
            r4.setVisibility(r3)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r7.activateResult
            r4.setVisibility(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Key code : "
            r4.append(r5)
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.String r4 = r9.getStartTime()
            if (r4 == 0) goto L_0x007f
            java.lang.String r4 = r9.getStartTime()
            org.joda.time.DateTime r4 = org.joda.time.DateTime.parse(r4)
            long r5 = r9.getTtl()
            org.joda.time.DateTime r4 = r4.plus((long) r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r8)
            java.lang.String r8 = "\nExpired time : "
            r5.append(r8)
            java.lang.String r8 = r4.toString()
            java.lang.String r8 = com.original.tase.helper.DateTimeHelper.b(r8)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            org.joda.time.DateTime r5 = org.joda.time.DateTime.now()
            int r4 = r4.compareTo((org.joda.time.ReadableInstant) r5)
            if (r4 >= 0) goto L_0x0090
            goto L_0x0091
        L_0x007f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r8)
            java.lang.String r8 = "\nnot activate yet!"
            r1.append(r8)
            java.lang.String r8 = r1.toString()
        L_0x0090:
            r1 = 0
        L_0x0091:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            java.lang.String r8 = "\nRemaining devices : "
            r4.append(r8)
            int r8 = r9.getLimit()
            int r9 = r9.getCurrentNumberOfDevice()
            int r8 = r8 - r9
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            if (r0 == 0) goto L_0x00c3
            if (r1 != 0) goto L_0x00c3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r8)
            java.lang.String r8 = "\nSomethings was wrong : Go Setting -> Apps -> Force close and open again to remove Ads."
            r9.append(r8)
            java.lang.String r8 = r9.toString()
        L_0x00c3:
            android.widget.TextView r9 = r7.code
            r9.setText(r8)
            android.widget.ProgressBar r8 = r7.loading
            r8.setVisibility(r3)
            android.widget.Button r8 = r7.btnCopy
            r8.setVisibility(r2)
            android.widget.Button r8 = r7.btnRemove
            r8.setVisibility(r2)
            goto L_0x00ee
        L_0x00d8:
            android.widget.ProgressBar r8 = r7.loading
            r8.setVisibility(r3)
            android.widget.Button r8 = r7.activeNow
            r8.setVisibility(r2)
            android.widget.TextView r8 = r7.code
            java.lang.String r9 = "You haven't had the code yet."
            r8.setText(r9)
            java.lang.String r8 = ""
            com.utils.Utils.s0(r8)
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.movie.ui.activity.MemberActivationActivity.K(java.lang.String, com.movie.data.model.cinema.KeyResponse):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(Throwable th) throws Exception {
        this.code.setText("Make sure your ISP is not blocked our payment service");
        this.loading.setVisibility(8);
        this.activeNow.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(BitcoinAddressResponse bitcoinAddressResponse) throws Exception {
        if (bitcoinAddressResponse.getCode().intValue() != 200) {
            bitcoinAddressResponse.getCode().intValue();
        } else if (bitcoinAddressResponse.getRemainingTime().longValue() > 0) {
            Intent intent = new Intent(this, BitcoinGatewayActivity.class);
            intent.putExtra("isSplitKey", bitcoinAddressResponse.getSplitKey());
            FreeMoviesApp.p().edit().putBoolean("isSplitKey", bitcoinAddressResponse.getSplitKey().booleanValue()).apply();
            startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(Throwable th) throws Exception {
        this.pbbitcoin.setVisibility(8);
    }

    private void P() {
        View inflate = getLayoutInflater().inflate(R.layout.input_key_dialog, (ViewGroup) null);
        AlertDialog create = new AlertDialog.Builder(this).p(R.layout.input_key_dialog).create();
        create.f(inflate);
        final EditText editText = (EditText) inflate.findViewById(R.id.edt_key_input);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, final boolean z2) {
                editText.post(new Runnable() {
                    public void run() {
                        InputMethodManager inputMethodManager = (InputMethodManager) MemberActivationActivity.this.getSystemService("input_method");
                        if (z2) {
                            inputMethodManager.showSoftInput(editText, 1);
                        } else {
                            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        }
                    }
                });
            }
        });
        create.d(-1, "active", new DialogInterface.OnClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void d(String str, AppConfig appConfig) throws Exception {
                if (appConfig == null || appConfig.getAds() != null) {
                    MemberActivationActivity.this.S(UserResponces.USER_RESPONCE_FAIL, "The key not available or reach maximum registered devices");
                    return;
                }
                AdsManager.d().c();
                GlobalVariable.c().d(new Gson().u(appConfig));
                MemberActivationActivity memberActivationActivity = MemberActivationActivity.this;
                memberActivationActivity.S(200, memberActivationActivity.getString(R.string.unlock_result_success));
                Utils.s0(str);
                String unused = MemberActivationActivity.this.f32087e = str;
                MemberActivationActivity memberActivationActivity2 = MemberActivationActivity.this;
                memberActivationActivity2.H(memberActivationActivity2.f32087e);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void e(Throwable th) throws Exception {
                MemberActivationActivity.this.S(UserResponces.USER_RESPONCE_FAIL, th.getMessage());
                MemberActivationActivity.this.J();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void f() throws Exception {
                MemberActivationActivity.this.J();
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                String obj = editText.getText().toString();
                MemberActivationActivity.this.R();
                MemberActivationActivity memberActivationActivity = MemberActivationActivity.this;
                memberActivationActivity.f32085c.b(memberActivationActivity.f32086d.activeKey(obj).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a0(this, obj), new b0(this), new c0(this)));
            }
        });
        create.d(-2, I18N.a(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        create.show();
    }

    public void H(String str) {
        this.loading.setVisibility(0);
        this.activeNow.setVisibility(8);
        this.f32085c.b(this.f32086d.getActivateInfo(str, (String) null, (String) null).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new v(this, str), new w(this)));
    }

    public void J() {
        this.loading.setVisibility(8);
        this.activeNow.setVisibility(0);
    }

    public void Q() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View inflate = getLayoutInflater().inflate(R.layout.dialog_key_manager, (ViewGroup) null);
        builder.setView(inflate);
        builder.setTitle("Input payment informations");
        final EditText editText = (EditText) inflate.findViewById(R.id.edtTransaction);
        final EditText editText2 = (EditText) inflate.findViewById(R.id.edtEmail);
        final EditText editText3 = (EditText) inflate.findViewById(R.id.edtKey);
        editText.requestFocusFromTouch();
        ((InputMethodManager) getSystemService("input_method")).toggleSoftInput(2, 1);
        ((ImageButton) inflate.findViewById(R.id.helpbtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Utils.o0(MemberActivationActivity.this, "https://cryptomaxx.freshdesk.com/support/solutions/articles/25000001250-where-do-i-get-my-transaction-id-in-coinbase-");
            }
        });
        editText3.setText(Utils.R());
        editText2.setText(FreeMoviesApp.p().getString("pref_payment_bit_mail", ""));
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                Intent intent = new Intent(MemberActivationActivity.this, KeyManager.class);
                intent.putExtra("TRANSACTION", editText.getText().toString());
                intent.putExtra("EMAIL", editText2.getText().toString());
                intent.putExtra("KEY", editText3.getText().toString());
                MemberActivationActivity.this.startActivity(intent);
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.q();
    }

    public void R() {
        this.loading.setVisibility(0);
        this.activeNow.setVisibility(8);
    }

    public void S(final int i2, String str) {
        AlertDialog.Builder l2 = new AlertDialog.Builder(this).g(str).l(I18N.a(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (i2 == 200) {
                    Utils.q0(MemberActivationActivity.this);
                }
                dialogInterface.dismiss();
            }
        });
        if (i2 == 200) {
            l2 = l2.i(I18N.a(R.string.cancel), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
        }
        l2.q();
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361880})
    public void onActivateClick() {
        P();
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361958})
    public void onBtnBitcoinClick() {
        Utils.o0(this, I("crypto").getUrl());
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361947})
    public void onCopyCodeClick() {
        Utils.p(this, this.f32087e, false);
    }

    /* access modifiers changed from: package-private */
    @OnLongClick({2131361947})
    public void onCopyCodeLongClick() {
        Utils.p(this, this.f32087e, true);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_member_activation);
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
            supportActionBar.t(true);
            this.toolbar.setTitle((CharSequence) "Member activation");
            this.toolbar.setNavigationOnClickListener(new s(this));
        }
        this.f32088f = GlobalVariable.c().b().getPayments();
        this.f32087e = Utils.R();
        this.f32085c = new CompositeDisposable();
        if (!this.f32087e.isEmpty()) {
            H(this.f32087e);
        } else {
            this.code.setText("");
            this.loading.setVisibility(8);
        }
        if (I("crypto") == null) {
            this.btn_bitcoin.setVisibility(8);
        } else {
            this.btn_bitcoin.setVisibility(0);
        }
        if (I("amzgiftcard") == null) {
            this.btn_amz_gift.setVisibility(8);
        } else {
            this.btn_amz_gift.setVisibility(0);
        }
        if (!GlobalVariable.c().b().getPayments().contains("game")) {
            this.btn_game_challenge.setVisibility(8);
        } else {
            this.btn_game_challenge.setVisibility(0);
        }
        Uri data = getIntent().getData();
        if (data != null) {
            List<String> pathSegments = data.getPathSegments();
            String str = pathSegments.get(pathSegments.size() - 1);
        }
        String string = FreeMoviesApp.p().getString("pref_payment_bit_mail", "");
        ProductResponse.ResultsBean resultsBean = (ProductResponse.ResultsBean) new Gson().l(FreeMoviesApp.p().getString("pref_payment_bit_product_id", ""), ProductResponse.ResultsBean.class);
        String string2 = FreeMoviesApp.p().getString("pref_payment_bit_address", "");
        if (!string.isEmpty() && !string2.isEmpty()) {
            BitcoinAdressRequest bitcoinAdressRequest = new BitcoinAdressRequest();
            bitcoinAdressRequest.setAddress(string2);
            bitcoinAdressRequest.setDeviceID(Utils.t());
            bitcoinAdressRequest.setEmail(string);
            bitcoinAdressRequest.setProductID(resultsBean.getId());
            bitcoinAdressRequest.setDeviceName(Utils.C());
            this.f32085c.b(this.f32086d.checkPaymentProcess(bitcoinAdressRequest).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new t(this), new u(this)));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_keymanager, menu);
        menu.findItem(R.id.action_device_manager);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f32085c.dispose();
        super.onDestroy();
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361960})
    public void onGameChallengeClick() {
        startActivity(new Intent(this, GameChallenge.class));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.action_device_manager) {
            Q();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: package-private */
    @OnClick({2131361952})
    public void onRemoveClick() {
        new AlertDialog.Builder(this).g("Do you want to deactivate?").l(I18N.a(R.string.ok), new DialogInterface.OnClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void d(AppConfig appConfig) throws Exception {
                if (appConfig != null) {
                    AdsManager.d().c();
                    GlobalVariable.c().d(new Gson().u(appConfig));
                    MemberActivationActivity memberActivationActivity = MemberActivationActivity.this;
                    memberActivationActivity.S(200, memberActivationActivity.getString(R.string.deactive_success));
                    Utils.s0("");
                    MemberActivationActivity memberActivationActivity2 = MemberActivationActivity.this;
                    String unused = memberActivationActivity2.f32087e = memberActivationActivity2.f32087e;
                    MemberActivationActivity memberActivationActivity3 = MemberActivationActivity.this;
                    memberActivationActivity3.H(memberActivationActivity3.f32087e);
                    MemberActivationActivity.this.btnRemove.setVisibility(8);
                    MemberActivationActivity.this.btnCopy.setVisibility(8);
                    return;
                }
                MemberActivationActivity memberActivationActivity4 = MemberActivationActivity.this;
                memberActivationActivity4.S(UserResponces.USER_RESPONCE_FAIL, memberActivationActivity4.getString(R.string.deactive_faild));
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void e(Throwable th) throws Exception {
                MemberActivationActivity memberActivationActivity = MemberActivationActivity.this;
                memberActivationActivity.S(UserResponces.USER_RESPONCE_FAIL, memberActivationActivity.getString(R.string.deactive_faild));
                MemberActivationActivity.this.J();
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void f() throws Exception {
                MemberActivationActivity.this.J();
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                MemberActivationActivity.this.R();
                MemberActivationActivity memberActivationActivity = MemberActivationActivity.this;
                memberActivationActivity.f32085c.b(memberActivationActivity.f32086d.deactiveKey(memberActivationActivity.f32087e, Utils.t()).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new x(this), new y(this), new z(this)));
            }
        }).i(I18N.a(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).q();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
        DaggerBaseActivityComponent.a().a(appComponent).b().b(this);
    }
}

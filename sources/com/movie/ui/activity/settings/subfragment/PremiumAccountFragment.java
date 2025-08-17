package com.movie.ui.activity.settings.subfragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.database.MvDatabase;
import com.google.gson.Gson;
import com.movie.FreeMoviesApp;
import com.movie.data.api.GlobalVariable;
import com.movie.data.api.MoviesApi;
import com.movie.data.api.premiumize.PremiumizeModule;
import com.movie.data.api.realdebrid.RealDebridApi;
import com.movie.ui.activity.AllDebridAuthWebViewActivity;
import com.movie.ui.activity.RealDebridAuthWebViewActivity;
import com.movie.ui.activity.TraktAuthWebViewActivity;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.original.tase.I18N;
import com.original.tase.Logger;
import com.original.tase.RxBus;
import com.original.tase.api.TraktUserApi;
import com.original.tase.debrid.alldebrid.AllDebridCredentialsHelper;
import com.original.tase.debrid.alldebrid.AllDebridUserApi;
import com.original.tase.debrid.premiumize.PremiumizeCredentialsHelper;
import com.original.tase.debrid.premiumize.PremiumizeUserApi;
import com.original.tase.debrid.realdebrid.RealDebridCredentialsHelper;
import com.original.tase.event.ApiAllDebridWaitingToVerifyEvent;
import com.original.tase.event.ApiDebridGetTokenFailedEvent;
import com.original.tase.event.ApiDebridGetTokenSuccessEvent;
import com.original.tase.event.ApiRealDebridWaitingToVerifyEvent;
import com.original.tase.event.trakt.TraktGetTokenFailedEvent;
import com.original.tase.event.trakt.TraktGetTokenSuccessEvent;
import com.original.tase.event.trakt.TraktWaitingToVerifyEvent;
import com.original.tase.helper.DateTimeHelper;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.trakt.TraktCredentialsHelper;
import com.original.tase.helper.trakt.TraktHelper;
import com.original.tase.model.debrid.alldebrid.ADGetTokenResult;
import com.original.tase.model.debrid.alldebrid.ADPin;
import com.original.tase.model.debrid.alldebrid.ADUserInfor;
import com.original.tase.model.debrid.alldebrid.AllDebridCredentialsInfo;
import com.original.tase.model.debrid.premiumize.PremiumizeCredentialsInfo;
import com.original.tase.model.debrid.premiumize.PremiumizeUserInfo;
import com.original.tase.model.debrid.realdebrid.RealDebridCheckAuthResult;
import com.original.tase.model.debrid.realdebrid.RealDebridGetDeviceCodeResult;
import com.original.tase.model.debrid.realdebrid.RealDebridGetTokenResult;
import com.original.tase.model.debrid.realdebrid.RealDebridUserInfor;
import com.utils.Getlink.Provider.BaseProvider;
import com.utils.Utils;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.uwetrottmann.trakt5.entities.User;
import com.uwetrottmann.trakt5.entities.UserSlug;
import com.uwetrottmann.trakt5.enums.Extended;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Response;

public class PremiumAccountFragment extends BaseSettingFragment implements Preference.OnPreferenceChangeListener {
    public static final int requestOpenWebviewCode = 100;
    Preference adPref;
    CompositeDisposable compositeDisposable;
    CompositeDisposable loginDisposable;
    @Inject
    MoviesApi moviesApi;
    @Inject
    MvDatabase mvDatabase;
    @Inject
    OpenSubtitleV1Api openSubtitleV1Api;
    Preference pmPref;
    Preference rdPref;
    @Inject
    RealDebridApi realDebridApi;
    Preference traktPref;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getAlDebirdUserInfo$6(Void voidR) throws Exception {
        this.adPref.setSummary((CharSequence) getSharedPreference().getString("pref_ad_expiration", ""));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getAlDebirdUserInfo$7(Throwable th) throws Exception {
        getSharedPreference().edit().putString("pref_ad_expiration", "").commit();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getPremiumizeDebirdUserInfo$10(String str, PremiumizeUserInfo premiumizeUserInfo) throws Exception {
        if (premiumizeUserInfo.getStatus().isEmpty() || !premiumizeUserInfo.getStatus().contains("success")) {
            getSharedPreference().edit().putString("pref_pm_info", "").commit();
            this.pmPref.setSummary((CharSequence) "");
            this.pmPref.setTitle((CharSequence) "Login to Premiumize");
            return;
        }
        PremiumizeCredentialsInfo premiumizeCredentialsInfo = new PremiumizeCredentialsInfo();
        premiumizeCredentialsInfo.setAccessToken(str);
        premiumizeCredentialsInfo.setPremium_until(premiumizeUserInfo.getLongPremium_until());
        String c2 = DateTimeHelper.c(premiumizeCredentialsInfo.getPremium_until());
        SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
        edit.putString("pref_premiumize_expiration", "\nApikey : " + str + "\nType : Premium \nExpiration : " + c2).commit();
        PremiumizeCredentialsHelper.c(premiumizeCredentialsInfo);
        FreeMoviesApp.p().edit().putBoolean("pref_premiumize_type", true).commit();
        getSharedPreference().edit().putString("pref_pm_info", premiumizeUserInfo.toString()).commit();
        this.pmPref.setSummary((CharSequence) premiumizeUserInfo.toString());
        PremiumizeUserApi.c().a();
        this.pmPref.setTitle((CharSequence) "Logout");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getPremiumizeDebirdUserInfo$11(Throwable th) throws Exception {
        getSharedPreference().edit().putString("pref_pm_info", "").commit();
        this.pmPref.setSummary((CharSequence) "");
        this.pmPref.setTitle((CharSequence) "Login to Premiumize");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getRealDebirdUserInfo$2(RealDebridUserInfor realDebridUserInfor) throws Exception {
        Logger.b("Real Debrid ", realDebridUserInfor.toString());
        boolean equalsIgnoreCase = realDebridUserInfor.type.equalsIgnoreCase("premium");
        getSharedPreference().edit().putBoolean("pref_realdebrid_type", equalsIgnoreCase).commit();
        getSharedPreference().edit().putString("pref_realdebrid_expiration_str", realDebridUserInfor.expiration).commit();
        String b2 = DateTimeHelper.b(realDebridUserInfor.expiration);
        if (equalsIgnoreCase) {
            SharedPreferences.Editor edit = getSharedPreference().edit();
            edit.putString("pref_rd_expiration", "Real-Debrid authorized \nUsername : " + realDebridUserInfor.username + "\nType : " + realDebridUserInfor.type + "\nExpiration : " + b2).commit();
        } else {
            SharedPreferences.Editor edit2 = getSharedPreference().edit();
            edit2.putString("pref_rd_expiration", "Real-Debrid authorized \nUsername : " + realDebridUserInfor.username + "\nType : " + realDebridUserInfor.type).commit();
        }
        this.rdPref.setSummary((CharSequence) getSharedPreference().getString("pref_rd_expiration", ""));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getRealDebirdUserInfo$3(Throwable th) throws Exception {
        RealDebridCredentialsHelper.b();
        getSharedPreference().edit().putString("pref_rd_expiration", "").commit();
        this.rdPref.setTitle((CharSequence) "Login to Real-Debird");
        this.rdPref.setSummary((CharSequence) "");
        getSharedPreference().edit().putBoolean("pref_show_debrid_only", false).apply();
        FragmentActivity activity = getActivity();
        Utils.i0(activity, "RealDebrid Error " + th.getMessage());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getTraktUserInfo$14(User user) throws Exception {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append("Username: ");
        sb.append(user.username);
        sb.append("\nName: ");
        sb.append(user.name);
        sb.append("\nJoined at : ");
        sb.append(user.joined_at.toLocalDate().toString());
        sb.append("\nType: ");
        if (user.vip.booleanValue()) {
            str = "Vip";
        } else {
            str = "Free";
        }
        sb.append(str);
        sb.append("\nPrivate:  ");
        if (user.isPrivate.booleanValue()) {
            str2 = "Yes";
        } else {
            str2 = "No";
        }
        sb.append(str2);
        String sb2 = sb.toString();
        getSharedPreference().edit().putString("pref_trakt_info", sb2).commit();
        this.traktPref.setSummary((CharSequence) sb2);
        this.traktPref.setTitle((CharSequence) "Logout");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$getTraktUserInfo$15(Throwable th) throws Exception {
        getSharedPreference().edit().putString("pref_trakt_info", "").commit();
        this.traktPref.setSummary((CharSequence) "");
        this.traktPref.setTitle((CharSequence) "Login to Trakt");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loginALlDebird$8(Boolean bool) throws Exception {
        Object obj;
        String str;
        boolean isValid = AllDebridCredentialsHelper.b().isValid();
        if (isValid) {
            Preference preference = this.adPref;
            if (!isValid) {
                str = "All-Debird";
            } else {
                str = "All-Debrid authorized";
            }
            preference.setSummary((CharSequence) str);
            getAlDebirdUserInfo();
        }
        RxBus a2 = RxBus.a();
        if (isValid) {
            obj = new ApiDebridGetTokenSuccessEvent();
        } else {
            obj = new ApiDebridGetTokenFailedEvent();
        }
        a2.b(obj);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loginALlDebird$9(Throwable th) throws Exception {
        hideWaitingDialog();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loginRealDebird$4(RealDebridGetTokenResult realDebridGetTokenResult) throws Exception {
        hideWaitingDialog();
        RealDebridCredentialsHelper.f(realDebridGetTokenResult.getAccess_token(), realDebridGetTokenResult.getRefresh_token(), realDebridGetTokenResult.getLast_clientID(), realDebridGetTokenResult.getLast_clientSecret());
        getRealDebirdUserInfo();
        RxBus.a().b(new ApiDebridGetTokenSuccessEvent());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loginRealDebird$5(Throwable th) throws Exception {
        hideWaitingDialog();
        RxBus.a().b(new ApiDebridGetTokenFailedEvent());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loginTrakt$12(Boolean bool) throws Exception {
        String str;
        Object obj;
        boolean isValid = TraktCredentialsHelper.b().isValid();
        if (isValid) {
            Preference preference = this.traktPref;
            if (!isValid) {
                str = "Trakt-Tv";
            } else {
                str = "Trakt-Tv authorized";
            }
            preference.setSummary((CharSequence) str);
            getSharedPreference().edit().putBoolean("pre_show_my_calenda_shows_only", true).apply();
            RxBus a2 = RxBus.a();
            if (bool.booleanValue()) {
                obj = new TraktGetTokenSuccessEvent();
            } else {
                obj = new TraktGetTokenFailedEvent();
            }
            a2.b(obj);
            TraktUserApi.M().k0(FreeMoviesApp.m(getActivity()).n(), getActivity(), this.mvDatabase);
            getTraktUserInfo();
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$loginTrakt$13(Throwable th) throws Exception {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreferences$0(Object obj) throws Exception {
        hideWaitingDialog();
        if (obj instanceof ApiRealDebridWaitingToVerifyEvent) {
            ApiRealDebridWaitingToVerifyEvent apiRealDebridWaitingToVerifyEvent = (ApiRealDebridWaitingToVerifyEvent) obj;
            Intent intent = new Intent(getActivity(), RealDebridAuthWebViewActivity.class);
            intent.putExtra("verificationUrl", apiRealDebridWaitingToVerifyEvent.b());
            intent.putExtra("userCode", apiRealDebridWaitingToVerifyEvent.a());
            getActivity().startActivityForResult(intent, 100);
        } else if (obj instanceof ApiAllDebridWaitingToVerifyEvent) {
            ApiAllDebridWaitingToVerifyEvent apiAllDebridWaitingToVerifyEvent = (ApiAllDebridWaitingToVerifyEvent) obj;
            Intent intent2 = new Intent(getActivity(), AllDebridAuthWebViewActivity.class);
            intent2.putExtra("verificationUrl", apiAllDebridWaitingToVerifyEvent.b());
            intent2.putExtra("pin", apiAllDebridWaitingToVerifyEvent.a());
            getActivity().startActivityForResult(intent2, 100);
        } else if (obj instanceof TraktWaitingToVerifyEvent) {
            TraktWaitingToVerifyEvent traktWaitingToVerifyEvent = (TraktWaitingToVerifyEvent) obj;
            Intent intent3 = new Intent(getActivity(), TraktAuthWebViewActivity.class);
            intent3.putExtra("verificationUrl", traktWaitingToVerifyEvent.b());
            intent3.putExtra("userCode", traktWaitingToVerifyEvent.a());
            getActivity().startActivityForResult(intent3, 100);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreatePreferences$1(Throwable th) throws Exception {
    }

    /* access modifiers changed from: package-private */
    public void getAlDebirdUserInfo() {
        final AllDebridCredentialsInfo b2 = AllDebridCredentialsHelper.b();
        if (b2.isValid()) {
            this.adPref.setTitle((CharSequence) "Logout");
            this.adPref.setSummary((CharSequence) getSharedPreference().getString("pref_ad_expiration", ""));
            this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<Void>() {
                public void subscribe(ObservableEmitter<Void> observableEmitter) throws Exception {
                    String str;
                    try {
                        str = "https://api.alldebrid.com/v4/user?agent=" + URLEncoder.encode(Utils.f37622o, "UTF-8") + "&apikey=" + URLEncoder.encode(b2.getApikey(), "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                        str = "https://api.alldebrid.com/v4/user?agent=" + Utils.f37622o + "&apikey=" + b2.getApikey();
                    }
                    String string = new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute().body().string();
                    if (!string.isEmpty()) {
                        ADUserInfor aDUserInfor = (ADUserInfor) new Gson().l(string, ADUserInfor.class);
                        Logger.b("All Debrid ", aDUserInfor.toString());
                        if (aDUserInfor.getStatus().contains("success")) {
                            String d2 = DateTimeHelper.d(aDUserInfor.getData().getUser().getPremiumUntil());
                            PremiumAccountFragment.this.getSharedPreference().edit().putBoolean("pref_alldebrid_type", aDUserInfor.getData().getUser().isIsPremium()).commit();
                            PremiumAccountFragment.this.getSharedPreference().edit().putString("pref_alldebrid_expiration_str", aDUserInfor.getData().getUser().getPremiumUntil()).commit();
                            if (aDUserInfor.getData().getUser().isIsPremium()) {
                                PremiumAccountFragment.this.getSharedPreference().edit().putString("pref_ad_expiration", "All-Debrid authorized \nUsername : " + aDUserInfor.getData().getUser().getUsername() + "\nType : Premium \nExpiration : " + d2).commit();
                            } else {
                                PremiumAccountFragment.this.getSharedPreference().edit().putString("pref_ad_expiration", "All-Debrid authorized \nUsername : " + aDUserInfor.getData().getUser().getUsername() + "\nType : Free").commit();
                            }
                            AllDebridUserApi.d().a();
                        }
                    }
                }
            }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new a0(this), new b0(this)));
        }
    }

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    /* access modifiers changed from: package-private */
    public void getPremiumizeDebirdUserInfo(final String str) {
        String string = getSharedPreference().getString("pref_pm_info", "");
        if (!string.isEmpty()) {
            this.pmPref.setTitle((CharSequence) "Logout");
            this.pmPref.setSummary((CharSequence) string);
        }
        this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<PremiumizeUserInfo>() {
            public void subscribe(ObservableEmitter<PremiumizeUserInfo> observableEmitter) throws Exception {
                observableEmitter.onNext(PremiumizeModule.b().getPremiumizeUserInfo(str).execute().body());
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new w(this, str), new x(this)));
    }

    /* access modifiers changed from: package-private */
    public void getRealDebirdUserInfo() {
        String string = getSharedPreference().getString("pref_rd_expiration", "");
        if (!string.isEmpty()) {
            this.rdPref.setTitle((CharSequence) "Logout");
            this.rdPref.setSummary((CharSequence) string);
        }
        this.loginDisposable.b(Observable.create(new ObservableOnSubscribe<RealDebridUserInfor>() {
            public void subscribe(ObservableEmitter<RealDebridUserInfor> observableEmitter) throws Exception {
                Response<RealDebridUserInfor> execute = PremiumAccountFragment.this.realDebridApi.getUserInfo().execute();
                if (execute.code() == 200) {
                    observableEmitter.onNext(execute.body());
                }
                if (execute.code() != 401) {
                    observableEmitter.onComplete();
                    return;
                }
                throw new Exception(execute.message());
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new p(this), new q(this)));
    }

    /* access modifiers changed from: package-private */
    public void getTraktUserInfo() {
        String string = getSharedPreference().getString("pref_trakt_info", "");
        if (!string.isEmpty()) {
            this.traktPref.setTitle((CharSequence) "Logout");
            this.traktPref.setSummary((CharSequence) string);
        }
        this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<User>() {
            public void subscribe(ObservableEmitter<User> observableEmitter) throws Exception {
                observableEmitter.onNext(TraktHelper.a().users().profile(UserSlug.ME, Extended.FULL).execute().body());
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new u(this), new v(this)));
    }

    /* access modifiers changed from: package-private */
    public void loginALlDebird() {
        showWaitingDialog((int) R.string.msg_wait);
        this.loginDisposable.b(Observable.create(new ObservableOnSubscribe<Boolean>() {
            public void subscribe(ObservableEmitter<Boolean> observableEmitter) throws Exception {
                ADGetTokenResult aDGetTokenResult;
                Exception e2;
                if (AllDebridCredentialsHelper.b().isValid()) {
                    observableEmitter.onNext(Boolean.TRUE);
                    observableEmitter.onComplete();
                    return;
                }
                HashMap<String, String> c2 = AllDebridUserApi.c();
                try {
                    Gson gson = new Gson();
                    HttpHelper i2 = HttpHelper.i();
                    ADPin aDPin = (ADPin) gson.l(i2.m(String.format("https://api.alldebrid.com/v4/pin/get?agent=" + Utils.f37622o, new Object[0]), new Map[0]), ADPin.class);
                    if (aDPin != null) {
                        if (aDPin.getStatus().contains("success")) {
                            RxBus.a().b(new ApiAllDebridWaitingToVerifyEvent(aDPin.getData().getBase_url(), aDPin.getData().getPin()));
                            int expires_in = aDPin.getData().getExpires_in();
                            ADGetTokenResult aDGetTokenResult2 = null;
                            int i3 = 0;
                            while (true) {
                                if (i3 >= expires_in || observableEmitter.isDisposed()) {
                                    break;
                                }
                                try {
                                    Thread.sleep(3000);
                                    aDGetTokenResult = (ADGetTokenResult) new Gson().l(HttpHelper.i().m(String.format(aDPin.getData().getCheck_url(), new Object[]{Utils.f37622o}), c2), ADGetTokenResult.class);
                                    try {
                                        if (aDGetTokenResult.getStatus().contains("success") && aDGetTokenResult.getData().isActivated() && aDGetTokenResult.getData().getApikey() != null && !aDGetTokenResult.getData().getApikey().isEmpty()) {
                                            aDGetTokenResult2 = aDGetTokenResult;
                                            break;
                                        }
                                    } catch (Exception e3) {
                                        e2 = e3;
                                        Logger.d(e2, new boolean[0]);
                                        aDGetTokenResult2 = aDGetTokenResult;
                                        i3++;
                                    }
                                } catch (Exception e4) {
                                    Exception exc = e4;
                                    aDGetTokenResult = aDGetTokenResult2;
                                    e2 = exc;
                                    Logger.d(e2, new boolean[0]);
                                    aDGetTokenResult2 = aDGetTokenResult;
                                    i3++;
                                }
                                aDGetTokenResult2 = aDGetTokenResult;
                                i3++;
                            }
                            if (!(aDGetTokenResult2 == null || aDGetTokenResult2.getData().getApikey() == null)) {
                                if (!aDGetTokenResult2.getData().getApikey().isEmpty()) {
                                    AllDebridCredentialsInfo allDebridCredentialsInfo = new AllDebridCredentialsInfo();
                                    allDebridCredentialsInfo.setApiKey(aDGetTokenResult2.getData().getApikey(), (long) aDGetTokenResult2.getData().getExpires_in());
                                    allDebridCredentialsInfo.setPin(aDPin.getData().getPin());
                                    AllDebridCredentialsHelper.d(allDebridCredentialsInfo);
                                    observableEmitter.onNext(Boolean.TRUE);
                                    observableEmitter.onComplete();
                                    return;
                                }
                            }
                            observableEmitter.onNext(Boolean.FALSE);
                            observableEmitter.onComplete();
                            return;
                        }
                    }
                    observableEmitter.onNext(Boolean.FALSE);
                    observableEmitter.onComplete();
                } catch (Exception e5) {
                    Logger.d(e5, new boolean[0]);
                    observableEmitter.onNext(Boolean.FALSE);
                }
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new r(this), new s(this)));
    }

    /* access modifiers changed from: package-private */
    public void loginPremiumize() {
        AlertDialog create = new AlertDialog.Builder(getActivity()).setTitle("Authorize Premiumize").create();
        create.e(" Enter Apikey. Available at https://www.premiumize.me/account");
        final EditText editText = new EditText(getActivity());
        editText.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, final boolean z2) {
                editText.post(new Runnable() {
                    public void run() {
                        InputMethodManager inputMethodManager = (InputMethodManager) PremiumAccountFragment.this.getActivity().getSystemService("input_method");
                        if (z2) {
                            inputMethodManager.showSoftInput(editText, 1);
                        } else {
                            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
                        }
                    }
                });
            }
        });
        create.f(editText);
        create.d(-1, I18N.a(R.string.ok), new DialogInterface.OnClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void c(String str, Boolean bool) throws Exception {
                if (bool.booleanValue()) {
                    PremiumAccountFragment.this.pmPref.setTitle((CharSequence) "Logout");
                    PremiumAccountFragment.this.getPremiumizeDebirdUserInfo(str);
                    return;
                }
                Utils.h0(PremiumAccountFragment.this.getActivity(), R.string.premiumiz_error_incorrect_apikey);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void d(Throwable th) throws Exception {
                Utils.h0(PremiumAccountFragment.this.getActivity(), R.string.premiumiz_error_incorrect_apikey);
            }

            public void onClick(DialogInterface dialogInterface, int i2) {
                String obj = editText.getText().toString();
                if (obj.isEmpty()) {
                    Utils.h0(PremiumAccountFragment.this.getActivity(), R.string.premiumiz_error_incorrect_apikey);
                    return;
                }
                Utils.h0(PremiumAccountFragment.this.getActivity(), R.string.msg_wait);
                PremiumAccountFragment.this.compositeDisposable.b(PremiumizeUserApi.c().d(obj).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new c0(this, obj), new d0(this)));
            }
        });
        create.d(-2, I18N.a(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        create.show();
    }

    /* access modifiers changed from: package-private */
    public void loginRealDebird() {
        showWaitingDialog((int) R.string.msg_wait);
        this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<RealDebridGetTokenResult>() {
            public void subscribe(ObservableEmitter<RealDebridGetTokenResult> observableEmitter) throws Exception {
                String rd_client_id = GlobalVariable.c().b().getRd_config().getRd_client_id();
                RealDebridGetDeviceCodeResult body = PremiumAccountFragment.this.realDebridApi.oauthDeviceCode(rd_client_id).execute().body();
                String verification_url = body.getVerification_url();
                String user_code = body.getUser_code();
                String device_code = body.getDevice_code();
                int expires_in = body.getExpires_in();
                int interval = body.getInterval();
                RxBus.a().b(new ApiRealDebridWaitingToVerifyEvent(verification_url, user_code));
                int i2 = 0;
                while (true) {
                    if (i2 >= expires_in || PremiumAccountFragment.this.compositeDisposable.isDisposed()) {
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                        if (((float) i2) % ((float) interval) == 0.0f) {
                            RealDebridCheckAuthResult body2 = PremiumAccountFragment.this.realDebridApi.oauthDeviceCredentials(rd_client_id, device_code).execute().body();
                            try {
                                String client_id = body2.getClient_id();
                                String client_secret = body2.getClient_secret();
                                if (client_id != null && client_secret != null && !client_id.isEmpty() && !client_secret.isEmpty()) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("client_id", client_id);
                                    hashMap.put("client_secret", client_secret);
                                    hashMap.put("code", device_code);
                                    hashMap.put("grant_type", "http://oauth.net/grant_type/device/1.0");
                                    RealDebridGetTokenResult body3 = PremiumAccountFragment.this.realDebridApi.oauthtoken(hashMap).execute().body();
                                    if (body3 != null) {
                                        body3.setLast_clientID(client_id);
                                        body3.setLast_clientSecret(client_secret);
                                        observableEmitter.onNext(body3);
                                        break;
                                    }
                                }
                            } catch (Exception e2) {
                                Logger.d(e2, new boolean[0]);
                            }
                        }
                    } catch (Exception e3) {
                        Logger.d(e3, new boolean[0]);
                    }
                    i2++;
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new y(this), new z(this)));
    }

    /* access modifiers changed from: package-private */
    public void loginTrakt() {
        this.compositeDisposable.b(TraktUserApi.M().i0().subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new n(this), new o()));
    }

    /* access modifiers changed from: package-private */
    public void logoutAllDebird() {
        final AlertDialog create = new AlertDialog.Builder(getActivity()).g("Do you want logout to All-Debrid?").create();
        create.d(-1, "ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                AllDebridCredentialsHelper.a();
                CookieManager.getInstance().removeAllCookie();
                PremiumAccountFragment.this.adPref.setSummary((CharSequence) "All-Debird");
                PremiumAccountFragment.this.getSharedPreference().edit().putString("pref_ad_expiration", "").commit();
                PremiumAccountFragment.this.adPref.setTitle((CharSequence) "Login to All-Debird");
                create.dismiss();
            }
        });
        create.d(-2, "cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                create.dismiss();
            }
        });
        create.show();
    }

    /* access modifiers changed from: package-private */
    public void logoutPremiumize() {
        final AlertDialog create = new AlertDialog.Builder(getActivity()).g("Do you want logout to Premiumize?").create();
        create.d(-1, "ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                PremiumizeCredentialsHelper.a();
                PremiumAccountFragment.this.pmPref.setTitle((CharSequence) "Login to Premiumize");
                PremiumAccountFragment.this.pmPref.setSummary((CharSequence) "Premiumize");
                PremiumAccountFragment.this.getSharedPreference().edit().putString("pref_premiumize_expiration", "").commit();
                create.dismiss();
            }
        });
        create.d(-2, "cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                create.dismiss();
            }
        });
        create.show();
    }

    /* access modifiers changed from: package-private */
    public void logoutRealDebird() {
        final AlertDialog create = new AlertDialog.Builder(getActivity()).g("Do you want logout to Real-Debrid?").create();
        create.d(-1, "ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                RealDebridCredentialsHelper.b();
                CookieManager.getInstance().removeAllCookies(new ValueCallback<Boolean>() {
                    /* renamed from: a */
                    public void onReceiveValue(Boolean bool) {
                    }
                });
                HttpHelper.i().D("https://api.real-debrid.com", "__beaconTrackerID=; __gacid=;");
                PremiumAccountFragment.this.getSharedPreference().edit().putString("pref_rd_expiration", "").commit();
                PremiumAccountFragment.this.rdPref.setTitle((CharSequence) "Login to Real-Debird");
                PremiumAccountFragment.this.rdPref.setSummary((CharSequence) "");
                create.dismiss();
            }
        });
        create.d(-2, "cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                create.dismiss();
            }
        });
        create.show();
    }

    /* access modifiers changed from: package-private */
    public void logoutTrakt() {
        final AlertDialog create = new AlertDialog.Builder(getActivity()).g("Do you want logout to Trakt-TV?").create();
        create.d(-1, "ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                TraktCredentialsHelper.a();
                CookieManager.getInstance().removeAllCookie();
                HttpHelper.i().D("https://api.trakt.tv", "__beaconTrackerID=; __gacid=;");
                PremiumAccountFragment.this.traktPref.setSummary((CharSequence) "Trakt-Tv (Unauthorize)");
                PremiumAccountFragment.this.traktPref.setTitle((CharSequence) "Login to Trakt TV");
                create.dismiss();
            }
        });
        create.d(-2, "cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                create.dismiss();
            }
        });
        create.show();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerBaseFragmentComponent.a().a(FreeMoviesApp.m(getActivity()).l()).b().b(this);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_premium_account, str);
        this.compositeDisposable = new CompositeDisposable();
        CompositeDisposable compositeDisposable2 = new CompositeDisposable();
        this.loginDisposable = compositeDisposable2;
        this.compositeDisposable.b(compositeDisposable2);
        this.rdPref = findPreference("pref_auth_real_debrid");
        this.adPref = findPreference("pref_auth_All_debrid");
        this.pmPref = findPreference("pref_auth_premiumize_debrid");
        this.traktPref = findPreference("pref_auth_trakt_tv");
        if (RealDebridCredentialsHelper.d().isValid()) {
            getRealDebirdUserInfo();
        }
        if (AllDebridCredentialsHelper.b().isValid()) {
            getAlDebirdUserInfo();
        }
        if (TraktCredentialsHelper.b().isValid()) {
            getTraktUserInfo();
        }
        if (PremiumizeCredentialsHelper.b().isValid()) {
            getPremiumizeDebirdUserInfo(PremiumizeCredentialsHelper.b().getAccessToken());
        }
        this.compositeDisposable.b(RxBus.a().c().subscribe(new m(this), new t()));
        this.rdPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                if (RealDebridCredentialsHelper.d().isValid()) {
                    PremiumAccountFragment.this.logoutRealDebird();
                    return true;
                }
                PremiumAccountFragment.this.loginRealDebird();
                return true;
            }
        });
        this.adPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                if (AllDebridCredentialsHelper.b().isValid()) {
                    PremiumAccountFragment.this.logoutAllDebird();
                    return true;
                }
                PremiumAccountFragment.this.loginALlDebird();
                return true;
            }
        });
        this.pmPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                if (PremiumizeCredentialsHelper.b().isValid()) {
                    PremiumAccountFragment.this.logoutPremiumize();
                    return true;
                }
                PremiumAccountFragment.this.loginPremiumize();
                return true;
            }
        });
        this.traktPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                if (TraktCredentialsHelper.b().isValid()) {
                    PremiumAccountFragment.this.logoutTrakt();
                    return true;
                }
                PremiumAccountFragment.this.loginTrakt();
                return true;
            }
        });
    }

    public void onDestroy() {
        this.compositeDisposable.dispose();
        BaseProvider.H();
        super.onDestroy();
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        return false;
    }
}

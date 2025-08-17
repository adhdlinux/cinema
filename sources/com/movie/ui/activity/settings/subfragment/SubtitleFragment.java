package com.movie.ui.activity.settings.subfragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import com.domain.network.api.openSubtitle.OpenSubtitleOAuthSettings;
import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.movie.FreeMoviesApp;
import com.movie.e;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.utils.Utils;
import com.utils.subtitle.services.LanguageId;
import com.utils.subtitle.services.openSubtitle.OpenSubtitleV1Api;
import com.utils.subtitle.services.openSubtitle.models.LoginRequest;
import com.utils.subtitle.services.openSubtitle.models.LoginResponse;
import com.utils.subtitle.services.openSubtitle.models.User;
import com.utils.subtitle.services.openSubtitle.models.UserInfoResponse;
import com.yoku.marumovie.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.inject.Inject;
import retrofit2.Response;

public class SubtitleFragment extends BaseSettingFragment implements Preference.OnPreferenceChangeListener {
    public static Set<String> defaultSubtitleProviders = new HashSet(Arrays.asList(new String[]{"OpenSubtitleIO", "OpenSubtitleApi", "OpenSubtitleRest", "SubtitleCat", "SubDL"}));
    CompositeDisposable compositeDisposable;
    @Inject
    Gson gson;
    /* access modifiers changed from: private */
    public AlertDialog openSubtitleLoginDialog = null;
    @Inject
    OpenSubtitleV1Api openSubtitleV1Api;

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreatePreferences$0(UserInfoResponse userInfoResponse) throws Exception {
        OpenSubtitleOAuthSettings openSubtitleOAuthSettings = OpenSubtitleOAuthSettings.f19367a;
        openSubtitleOAuthSettings.f(userInfoResponse.getData());
        Preference findPreference = findPreference("pref_open_subtitle_summary");
        if (findPreference != null) {
            findPreference.setSummary((CharSequence) openSubtitleOAuthSettings.d());
        }
    }

    /* access modifiers changed from: private */
    public void logout() {
        final AlertDialog create = new AlertDialog.Builder(getActivity()).g("Do you want logout?").create();
        create.d(-1, "ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                SubtitleFragment.this.getSharedPreference().edit().putString("pref_open_subtitle_summary", "").commit();
                Preference findPreference = SubtitleFragment.this.findPreference("pref_open_subtitle_summary");
                findPreference.setTitle((CharSequence) "Login");
                findPreference.setSummary((CharSequence) "");
                OpenSubtitleOAuthSettings.f19367a.a();
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

    private void openSubtitleSetup() {
        Preference findPreference = findPreference("pref_open_subtitle_summary");
        final Preference findPreference2 = findPreference("button_open_subtitles_logout");
        OpenSubtitleOAuthSettings openSubtitleOAuthSettings = OpenSubtitleOAuthSettings.f19367a;
        User c2 = openSubtitleOAuthSettings.c();
        if (findPreference != null) {
            if (c2 != null) {
                findPreference.setSummary((CharSequence) openSubtitleOAuthSettings.d());
                findPreference2.setVisible(true);
            } else {
                findPreference.setTitle((CharSequence) requireContext().getResources().getString(R.string.login));
                findPreference2.setVisible(false);
                findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    public boolean a(Preference preference) {
                        View inflate = SubtitleFragment.this.getLayoutInflater().inflate(R.layout.open_subtitles_login_dialog, (ViewGroup) null);
                        final TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.usernameInputLayout);
                        final TextInputEditText textInputEditText = (TextInputEditText) inflate.findViewById(R.id.usernameEditText);
                        final TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.passwordInputLayout);
                        final TextInputEditText textInputEditText2 = (TextInputEditText) inflate.findViewById(R.id.passwordEditText);
                        final TextView textView = (TextView) inflate.findViewById(R.id.textError);
                        ((Button) inflate.findViewById(R.id.loginButton)).setOnClickListener(new View.OnClickListener() {
                            /* access modifiers changed from: private */
                            public /* synthetic */ void c(LoginResponse loginResponse) throws Exception {
                                OpenSubtitleOAuthSettings openSubtitleOAuthSettings = OpenSubtitleOAuthSettings.f19367a;
                                openSubtitleOAuthSettings.e(loginResponse.getToken());
                                openSubtitleOAuthSettings.f(loginResponse.getUser());
                                Preference findPreference = SubtitleFragment.this.findPreference("pref_open_subtitle_summary");
                                if (findPreference != null) {
                                    findPreference.setSummary((CharSequence) openSubtitleOAuthSettings.d());
                                }
                                SubtitleFragment.this.openSubtitleLoginDialog.dismiss();
                                SubtitleFragment.this.hideWaitingDialog();
                            }

                            /* access modifiers changed from: private */
                            public /* synthetic */ void d(TextView textView, Throwable th) throws Exception {
                                textView.setVisibility(0);
                                textView.setText(SubtitleFragment.this.requireContext().getResources().getString(R.string.failed_login));
                                SubtitleFragment.this.hideWaitingDialog();
                            }

                            public void onClick(View view) {
                                final String obj = textInputEditText.getText().toString();
                                final String obj2 = textInputEditText2.getText().toString();
                                if (obj.isEmpty()) {
                                    textInputLayout.setError("Please enter a username");
                                    return;
                                }
                                textInputLayout.setError((CharSequence) null);
                                if (obj2.isEmpty()) {
                                    textInputLayout2.setError("Please enter a password");
                                    return;
                                }
                                textInputLayout2.setError((CharSequence) null);
                                SubtitleFragment.this.showWaitingDialog("waiting...");
                                SubtitleFragment.this.compositeDisposable.b(Observable.create(new ObservableOnSubscribe<LoginResponse>() {
                                    public void subscribe(ObservableEmitter<LoginResponse> observableEmitter) throws Exception {
                                        Response<LoginResponse> execute = SubtitleFragment.this.openSubtitleV1Api.login(new LoginRequest(obj, obj2)).execute();
                                        if (execute.isSuccessful() && execute.body() != null) {
                                            observableEmitter.onNext(execute.body());
                                            observableEmitter.onComplete();
                                        }
                                        throw new Exception(execute.message());
                                    }
                                }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new f0(this), new g0(this, textView)));
                            }
                        });
                        SubtitleFragment subtitleFragment = SubtitleFragment.this;
                        AlertDialog unused = subtitleFragment.openSubtitleLoginDialog = new AlertDialog.Builder(subtitleFragment.requireContext()).o(R.string.login).setView(inflate).q();
                        return true;
                    }
                });
            }
        }
        if (findPreference != null) {
            findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean a(Preference preference) {
                    SubtitleFragment.this.logout();
                    findPreference2.setVisible(false);
                    return true;
                }
            });
        }
    }

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerBaseFragmentComponent.a().a(FreeMoviesApp.m(requireActivity()).l()).b().r(this);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_subtitle, str);
        setupSubtitleList();
        setupSubProviders();
        setupColor();
        CompositeDisposable compositeDisposable2 = new CompositeDisposable();
        this.compositeDisposable = compositeDisposable2;
        compositeDisposable2.b(Observable.create(new ObservableOnSubscribe<UserInfoResponse>() {
            public void subscribe(ObservableEmitter<UserInfoResponse> observableEmitter) throws Exception {
                Response<UserInfoResponse> execute = SubtitleFragment.this.openSubtitleV1Api.getUsers().execute();
                if (execute.isSuccessful() && execute.body() != null) {
                    observableEmitter.onNext(execute.body());
                }
                observableEmitter.onComplete();
            }
        }).subscribeOn(Schedulers.c()).observeOn(AndroidSchedulers.a()).subscribe(new e0(this), new e()));
        openSubtitleSetup();
    }

    public void onDestroy() {
        this.compositeDisposable.dispose();
        super.onDestroy();
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (preference.getKey().equals("pref_sub_language_international_v3")) {
            preference.setSummary((CharSequence) obj.toString());
            return true;
        } else if (!preference.getKey().equals("pref_sub_enable_providers")) {
            return false;
        } else {
            preference.setSummary((CharSequence) obj.toString());
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void setupColor() {
        Preference findPreference = findPreference("pref_cc_subs_font_color");
        findPreference.setSummary((CharSequence) getSharedPreference().getString("pref_cc_subs_font_color", "#FFFFFFFF").toUpperCase());
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(final Preference preference) {
                ColorPickerDialogBuilder.s(SubtitleFragment.this.getActivity()).o("Choose subtitle color").h(Color.parseColor(FreeMoviesApp.p().getString("pref_cc_subs_font_color", "#FFFFFFFF"))).q(true).r(ColorPickerView.WHEEL_TYPE.FLOWER).d(12).m(new OnColorSelectedListener() {
                    public void a(int i2) {
                        FragmentActivity activity = SubtitleFragment.this.getActivity();
                        Utils.i0(activity, "onColorSelected: 0x" + Integer.toHexString(i2));
                    }
                }).n("ok", new ColorPickerClickListener() {
                    public void a(DialogInterface dialogInterface, int i2, Integer[] numArr) {
                        String hexString = Integer.toHexString(i2);
                        Utils.i0(SubtitleFragment.this.getActivity(), "onColorSelected: 0x" + hexString);
                        String str = "#" + hexString.toUpperCase();
                        preference.setSummary((CharSequence) str);
                        FreeMoviesApp.p().edit().putString("pref_cc_subs_font_color", str).apply();
                    }
                }).l("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i2) {
                    }
                }).c().show();
                return true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setupSubProviders() {
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) findPreference("pref_sub_enable_providers");
        multiSelectListPreference.setOnPreferenceChangeListener(this);
        Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_sub_enable_providers", defaultSubtitleProviders);
        multiSelectListPreference.setValues(stringSet);
        multiSelectListPreference.setSummary((CharSequence) stringSet.toString());
    }

    /* access modifiers changed from: package-private */
    public void setupSubtitleList() {
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) findPreference("pref_sub_language_international_v3");
        String[] e2 = LanguageId.a().e();
        multiSelectListPreference.setEntries((CharSequence[]) LanguageId.a().f());
        multiSelectListPreference.setEntryValues((CharSequence[]) e2);
        multiSelectListPreference.setOnPreferenceChangeListener(this);
        Set<String> stringSet = FreeMoviesApp.p().getStringSet("pref_sub_language_international_v3", new HashSet(Arrays.asList(new String[]{Locale.getDefault().getLanguage()})));
        multiSelectListPreference.setValues(stringSet);
        multiSelectListPreference.setSummary((CharSequence) stringSet.toString());
    }
}

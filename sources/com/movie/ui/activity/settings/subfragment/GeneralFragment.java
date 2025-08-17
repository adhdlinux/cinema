package com.movie.ui.activity.settings.subfragment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import com.ads.videoreward.AdsManager;
import com.movie.FreeMoviesApp;
import com.movie.ui.activity.HelpRecaptchar;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.movie.ui.fragment.DaggerBaseFragmentComponent;
import com.original.tase.helper.PlayerHelper;
import com.original.tase.helper.StreamAction;
import com.original.tase.helper.player.BasePlayer;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;

public class GeneralFragment extends BaseSettingFragment implements Preference.OnPreferenceChangeListener {
    @Inject
    @Named("MainActivity")
    PlayerHelper playerHelper;

    /* access modifiers changed from: package-private */
    public void configDefaultAction() {
        ListPreference listPreference = (ListPreference) findPreference("pref_choose_default_action");
        ArrayList arrayList = new ArrayList();
        for (String add : StreamAction.b(true).keySet()) {
            arrayList.add(add);
        }
        listPreference.setEntries((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
        listPreference.setEntryValues((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
        listPreference.setDefaultValue("Always ask");
        listPreference.setSummary(getSharedPreference().getString("pref_choose_default_action", "Always ask"));
        listPreference.setOnPreferenceChangeListener(this);
    }

    /* access modifiers changed from: package-private */
    public void configDefaultPlayer() {
        ListPreference listPreference = (ListPreference) findPreference("pref_choose_default_player");
        BasePlayer[] G = this.playerHelper.G();
        CharSequence[] charSequenceArr = new CharSequence[G.length];
        CharSequence[] charSequenceArr2 = new CharSequence[G.length];
        for (int i2 = 0; i2 < G.length; i2++) {
            charSequenceArr[i2] = G[i2].f();
            charSequenceArr2[i2] = G[i2].f();
        }
        listPreference.setEntries(charSequenceArr);
        listPreference.setEntryValues(charSequenceArr2);
        PlayerHelper.Companion companion = PlayerHelper.f33837i;
        listPreference.setDefaultValue(companion.a().f());
        listPreference.setSummary(getSharedPreference().getString("pref_choose_default_player", companion.a().f()));
        listPreference.setOnPreferenceChangeListener(this);
    }

    /* access modifiers changed from: package-private */
    public void configPosterImageSize() {
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        for (String add : Utils.U().keySet()) {
            arrayList.add(add);
        }
        ListPreference listPreference = (ListPreference) findPreference("pref_column_in_main");
        listPreference.setEntries((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
        listPreference.setEntryValues((CharSequence[]) arrayList.toArray(new CharSequence[arrayList.size()]));
        listPreference.setDefaultValue("Large");
        listPreference.setSummary(getSharedPreference().getString("pref_column_in_main", "Large"));
        listPreference.setOnPreferenceChangeListener(this);
    }

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        DaggerBaseFragmentComponent.a().a(FreeMoviesApp.m(getActivity()).l()).b().l(this);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_general, str);
        configDefaultPlayer();
        configPosterImageSize();
        configDefaultAction();
        findPreference("pref_changelog").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                GeneralFragment.this.showChangelog();
                return true;
            }
        });
        findPreference("pref_clear_cache").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                Utils.q(GeneralFragment.this.getActivity());
                Utils.i0(GeneralFragment.this.getActivity(), "Cache cleared.");
                return true;
            }
        });
        findPreference("pref_recoptchar").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                GeneralFragment.this.startActivityForResult(new Intent(Utils.v(), HelpRecaptchar.class), 5);
                return true;
            }
        });
        Preference findPreference = findPreference("pref_show_intertisial_ads");
        if (findPreference != null) {
            findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                public boolean a(Preference preference) {
                    AdsManager.d().p(GeneralFragment.this.getActivity());
                    return true;
                }
            });
        }
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        preference.setSummary((CharSequence) obj.toString());
        if (!preference.getKey().equals("pref_column_in_main")) {
            return true;
        }
        getSharedPreference().edit().putString("pref_column_in_main", obj.toString()).commit();
        Utils.q0(getActivity());
        return true;
    }

    public void showChangelog() {
        new SpannableStringBuilder("Change Logs").setSpan(new ForegroundColorSpan(-256), 0, 11, 33);
        new AlertDialog.Builder(getActivity()).setTitle("Change Logs").setView(getActivity().getLayoutInflater().inflate(R.layout.dialog_changelog, (ViewGroup) null)).l("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                }
            }
        }).create().show();
    }
}

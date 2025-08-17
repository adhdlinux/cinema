package com.movie.ui.activity.settings.subfragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.movie.ui.activity.MemberActivationActivity;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.utils.Utils;
import com.yoku.marumovie.R;

public class MembershipFragment extends BaseSettingFragment {
    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_membership, str);
        Preference findPreference = findPreference("pref_cc_unlock_full_version");
        String R = Utils.R();
        if (!R.isEmpty()) {
            findPreference.setSummary((CharSequence) R);
            return;
        }
        findPreference.setTitle((CharSequence) "Enter your member code");
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                MembershipFragment.this.startActivity(new Intent(MembershipFragment.this.getActivity(), MemberActivationActivity.class));
                return true;
            }
        });
    }
}

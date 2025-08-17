package com.movie.ui.activity.settings.subfragment;

import android.os.Bundle;
import android.widget.EditText;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.yoku.marumovie.R;

public class AutoPlayFragment extends BaseSettingFragment implements Preference.OnPreferenceChangeListener {
    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_auto_play, str);
        EditTextPreference editTextPreference = (EditTextPreference) findPreference("pref_auto_next_eps_number_of_link");
        editTextPreference.setOnBindEditTextListener(new EditTextPreference.OnBindEditTextListener() {
            public void a(EditText editText) {
                editText.setInputType(4098);
            }
        });
        editTextPreference.setOnPreferenceChangeListener(this);
        editTextPreference.setSummary((CharSequence) getSharedPreference().getString("pref_auto_next_eps_number_of_link", "10"));
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (!preference.getKey().equals("pref_auto_next_eps_number_of_link")) {
            return true;
        }
        preference.setSummary((CharSequence) obj.toString());
        return true;
    }
}

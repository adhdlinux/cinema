package com.movie.ui.activity.settings.subfragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.Setting;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.nononsenseapps.filepicker.FilePickerActivity;
import com.nononsenseapps.filepicker.Utils;
import com.original.tase.Logger;
import com.yoku.marumovie.R;
import java.io.File;

public class DownloadFragment extends BaseSettingFragment {
    public static int PATH_CODE = 1122;

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != PATH_CODE) {
            return;
        }
        if (i3 == -1) {
            File b2 = Utils.b(intent.getData());
            Logger.b("Setting", "XML path Uri (" + b2.toString() + ")");
            String file = b2.toString();
            findPreference("pref_dowload_path3").setSummary((CharSequence) file);
            getSharedPreference().edit().putString("pref_dowload_path3", file).apply();
            return;
        }
        com.utils.Utils.h0(getActivity(), R.string.no_folder_selected);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_download, str);
        Preference findPreference = findPreference("pref_dowload_path3");
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                Intent intent = new Intent(DownloadFragment.this.getActivity(), FilePickerActivity.class);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
                intent.putExtra("nononsense.intent.ALLOW_CREATE_DIR", true);
                intent.putExtra("nononsense.intent.MODE", 1);
                intent.putExtra("nononsense.intent.START_PATH", Setting.a(DownloadFragment.this.getContext()).getAbsolutePath());
                DownloadFragment.this.getActivity().startActivityForResult(intent, DownloadFragment.PATH_CODE);
                return false;
            }
        });
        findPreference.setSummary((CharSequence) Setting.a(getContext()).getAbsolutePath());
    }
}

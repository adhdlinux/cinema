package com.movie.ui.activity.settings.subfragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.MultiSelectListPreference;
import androidx.preference.Preference;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.original.tase.I18N;
import com.utils.Getlink.Resolver.BaseResolver;
import com.utils.Utils;
import com.yoku.marumovie.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PerformanceFragment extends BaseSettingFragment implements Preference.OnPreferenceChangeListener {
    public static String hostStreamPriority = "";

    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_performance, str);
        setupProviders();
        setupPriorityHost();
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        String str;
        if (!preference.getKey().equals("pref_choose_provider_enabled2")) {
            return false;
        }
        getSharedPreference().edit().putBoolean("pref_zerotv_enabled", obj.toString().contains("ZeroTV")).apply();
        Set<String> T = Utils.T();
        HashSet hashSet = new HashSet();
        for (String next : T) {
            Iterator it2 = ((Set) obj).iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((String) it2.next()).equals(next)) {
                        str = next;
                        break;
                    }
                } else {
                    str = "";
                    break;
                }
            }
            if (str.length() == 0) {
                hashSet.add(next.toString());
            }
        }
        getSharedPreference().edit().putStringSet("pref_choose_provider_disabled", hashSet).apply();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setupPriorityHost() {
        findPreference("pref_choose_host_priority3").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                PerformanceFragment.this.showHostStreamPriority();
                return true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setupProviders() {
        String str;
        MultiSelectListPreference multiSelectListPreference = (MultiSelectListPreference) findPreference("pref_choose_provider_enabled2");
        Set<String> T = Utils.T();
        Set<String> stringSet = getSharedPreference().getStringSet("pref_choose_provider_disabled", new HashSet());
        HashSet hashSet = new HashSet();
        if (T.size() > 0) {
            for (CharSequence next : T) {
                Iterator<String> it2 = stringSet.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        str = "";
                        break;
                    }
                    str = it2.next();
                    if (next.equals(str)) {
                        break;
                    }
                }
                if (str.length() == 0) {
                    hashSet.add(next.toString());
                }
            }
        }
        multiSelectListPreference.setDefaultValue(T);
        multiSelectListPreference.setEntries((CharSequence[]) T.toArray(new CharSequence[T.size()]));
        multiSelectListPreference.setEntryValues((CharSequence[]) T.toArray(new CharSequence[T.size()]));
        if (hashSet.size() > 0) {
            multiSelectListPreference.setValues(hashSet);
        } else {
            multiSelectListPreference.setValues(T);
        }
        multiSelectListPreference.setOnPreferenceChangeListener(this);
    }

    public void showHostStreamPriority() {
        final Preference findPreference = findPreference("pref_choose_host_priority3");
        String string = getSharedPreference().getString("pref_choose_host_priority3", BaseResolver.d());
        final ArrayList arrayList = new ArrayList();
        if (string.contains(",")) {
            for (String add : string.split(",")) {
                arrayList.add(add);
            }
        }
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), 17367046, arrayList);
        new AlertDialog.Builder(getActivity()).setTitle(I18N.a(R.string.host_stream_priority)).a(arrayAdapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
            }
        }).l(I18N.a(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                String str;
                StringBuilder sb = new StringBuilder();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str2 = (String) it2.next();
                    if (sb.indexOf(str2 + ",") == -1) {
                        sb.append(str2);
                        sb.append(",");
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() - 1 > 0) {
                    str = sb2.substring(0, sb2.length() - 1);
                } else {
                    str = "";
                }
                PerformanceFragment.this.getSharedPreference().edit().putString("pref_choose_host_priority3", str).apply();
                findPreference.setSummary((CharSequence) str);
                PerformanceFragment.hostStreamPriority = str;
                dialogInterface.dismiss();
            }
        }).i(I18N.a(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).q().b().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (i2 > 0) {
                    Collections.swap(arrayList, i2, i2 - 1);
                    arrayAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}

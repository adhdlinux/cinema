package com.movie.ui.activity.settings.subfragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import com.movie.ui.activity.settings.BaseSettingFragment;
import com.movie.ui.activity.settings.CategoryRetrictionDialog;
import com.utils.Utils;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.yoku.marumovie.R;

public class RestrictionFragment extends BaseSettingFragment implements Preference.OnPreferenceChangeListener {
    public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
        return b.a(this);
    }

    public void onCreatePreferences(Bundle bundle, String str) {
        super.onCreatePreferences(bundle, str);
        setPreferencesFromResource(R.xml.preferences_restriction, str);
        Preference findPreference = findPreference("pref_restrict_password");
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                RestrictionFragment.this.showSetPassword();
                return true;
            }
        });
        Preference findPreference2 = findPreference("pref_category_restriction");
        findPreference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean a(Preference preference) {
                RestrictionFragment.this.showCategoryRetriction();
                return true;
            }
        });
        findPreference2.setOnPreferenceChangeListener(this);
        final String string = getSharedPreference().getString("pref_restrict_password", "");
        if (!string.isEmpty()) {
            setSumaryPassword(findPreference, string);
            final EditText editText = new EditText(getActivity());
            Utils.z0(getActivity(), "Enter the password", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                }
            }, editText, new DialogInterface.OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (string.equals(editText.getText().toString())) {
                        dialogInterface.dismiss();
                        return;
                    }
                    Utils.i0(RestrictionFragment.this.getActivity(), "Password is wrong");
                    RestrictionFragment.this.getParentFragmentManager().X0();
                }
            });
        }
    }

    public boolean onPreferenceChange(Preference preference, Object obj) {
        if (!preference.getKey().contains("pref_restrict_password")) {
            return false;
        }
        setSumaryPassword(preference, obj.toString());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setSumaryPassword(Preference preference, String str) {
        if (str.length() > 2) {
            preference.setSummary((CharSequence) str.substring(0, 2) + "*************");
        } else if (str.isEmpty()) {
            preference.setSummary((CharSequence) "password not set");
        } else {
            preference.setSummary((CharSequence) "********");
        }
    }

    public void showCategoryRetriction() {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction n2 = supportFragmentManager.n();
        Fragment i02 = supportFragmentManager.i0("CategoryRetrictionDialog");
        if (i02 != null) {
            n2.o(i02);
        }
        n2.g((String) null);
        CategoryRetrictionDialog.F().show(n2, "CategoryRetrictionDialog");
    }

    public void showNewPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Enter new password");
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.input_new_password_dialog, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.EditText_Pwd1);
        final EditText editText2 = (EditText) inflate.findViewById(R.id.EditText_Pwd2);
        editText.setInputType(Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE);
        editText2.setInputType(Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE);
        builder.setView(inflate);
        builder.l("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (editText.getText().toString().equals(editText2.getText().toString())) {
                    RestrictionFragment.this.getSharedPreference().edit().putString("pref_restrict_password", editText.getText().toString()).commit();
                    Utils.i0(RestrictionFragment.this.getActivity(), "Set password successfully");
                    return;
                }
                Utils.i0(RestrictionFragment.this.getActivity(), "Passwords not match");
            }
        });
        builder.q();
    }

    public void showSetPassword() {
        final String string = getSharedPreference().getString("pref_restrict_password", "");
        if (string.isEmpty()) {
            showNewPasswordDialog();
            return;
        }
        final EditText editText = new EditText(getActivity());
        Utils.z0(getActivity(), "Enter old password", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (string.equals(editText.getText().toString())) {
                    RestrictionFragment.this.showNewPasswordDialog();
                } else {
                    Utils.i0(RestrictionFragment.this.getActivity(), "Password is wrong");
                }
            }
        }, editText, (DialogInterface.OnDismissListener) null);
    }
}

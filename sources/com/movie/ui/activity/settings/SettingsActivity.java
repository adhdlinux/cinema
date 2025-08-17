package com.movie.ui.activity.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.b;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import com.ads.videoreward.AdsManager;
import com.movie.AppComponent;
import com.movie.ui.activity.BaseActivity;
import com.movie.ui.activity.settings.subfragment.PremiumAccountFragment;
import com.yoku.marumovie.R;
import io.reactivex.disposables.CompositeDisposable;

public class SettingsActivity extends BaseActivity implements PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {
    private static final String TITLE_TAG = "settingsActivityTitle";
    CompositeDisposable compositeDisposable;

    public static class HeaderFragment extends PreferenceFragmentCompat {
        /* access modifiers changed from: private */
        public /* synthetic */ boolean lambda$onCreatePreferences$0(Preference preference) {
            AdsManager.d().p(getActivity());
            return true;
        }

        public /* bridge */ /* synthetic */ CreationExtras getDefaultViewModelCreationExtras() {
            return b.a(this);
        }

        public void onCreatePreferences(Bundle bundle, String str) {
            setPreferencesFromResource(R.xml.header_preferences, str);
            Preference findPreference = findPreference("advertisement_header");
            findPreference.setOnPreferenceClickListener(new g(this));
            findPreference.setVisible(false);
        }

        public RecyclerView onCreateRecyclerView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            RecyclerView onCreateRecyclerView = super.onCreateRecyclerView(layoutInflater, viewGroup, bundle);
            onCreateRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), 1));
            return onCreateRecyclerView;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (Fragment onActivityResult : getSupportFragmentManager().t0()) {
            onActivityResult.onActivityResult(i2, i3, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setContentView(R.layout.settings_activity);
        this.compositeDisposable = new CompositeDisposable();
        if (bundle == null) {
            getSupportFragmentManager().n().p(R.id.settings, new HeaderFragment()).h();
        } else {
            setTitle(bundle.getCharSequence(TITLE_TAG));
        }
        getSupportFragmentManager().i(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                if (SettingsActivity.this.getSupportFragmentManager().m0() == 0) {
                    SettingsActivity.this.setTitle(R.string.title_activity_settings);
                }
            }
        });
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.r(true);
        }
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null && (string = intent.getExtras().getString("goto")) != null && string.equals(PremiumAccountFragment.class.getName())) {
            getSupportFragmentManager().n().p(R.id.settings, new PremiumAccountFragment()).g((String) null).h();
            setTitle("Account");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.compositeDisposable.dispose();
        super.onDestroy();
    }

    public boolean onPreferenceStartFragment(PreferenceFragmentCompat preferenceFragmentCompat, Preference preference) {
        Bundle extras = preference.getExtras();
        Fragment a2 = getSupportFragmentManager().r0().a(getClassLoader(), preference.getFragment());
        a2.setArguments(extras);
        a2.setTargetFragment(preferenceFragmentCompat, 0);
        getSupportFragmentManager().n().r(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right).p(R.id.settings, a2).g((String) null).h();
        setTitle(preference.getTitle());
        return true;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence(TITLE_TAG, getTitle());
    }

    public boolean onSupportNavigateUp() {
        if (getSupportFragmentManager().Z0()) {
            return true;
        }
        return super.onSupportNavigateUp();
    }

    /* access modifiers changed from: protected */
    public void setupComponent(AppComponent appComponent) {
    }
}

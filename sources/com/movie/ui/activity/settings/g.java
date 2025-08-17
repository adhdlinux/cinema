package com.movie.ui.activity.settings;

import androidx.preference.Preference;
import com.movie.ui.activity.settings.SettingsActivity;

public final /* synthetic */ class g implements Preference.OnPreferenceClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SettingsActivity.HeaderFragment f32538a;

    public /* synthetic */ g(SettingsActivity.HeaderFragment headerFragment) {
        this.f32538a = headerFragment;
    }

    public final boolean a(Preference preference) {
        return this.f32538a.lambda$onCreatePreferences$0(preference);
    }
}

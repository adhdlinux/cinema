package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;

public class PreferenceManager {

    /* renamed from: a  reason: collision with root package name */
    private Context f10865a;

    /* renamed from: b  reason: collision with root package name */
    private long f10866b = 0;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f10867c;

    /* renamed from: d  reason: collision with root package name */
    private PreferenceDataStore f10868d;

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences.Editor f10869e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10870f;

    /* renamed from: g  reason: collision with root package name */
    private String f10871g;

    /* renamed from: h  reason: collision with root package name */
    private int f10872h;

    /* renamed from: i  reason: collision with root package name */
    private int f10873i = 0;

    /* renamed from: j  reason: collision with root package name */
    private PreferenceScreen f10874j;

    /* renamed from: k  reason: collision with root package name */
    private PreferenceComparisonCallback f10875k;

    /* renamed from: l  reason: collision with root package name */
    private OnPreferenceTreeClickListener f10876l;

    /* renamed from: m  reason: collision with root package name */
    private OnDisplayPreferenceDialogListener f10877m;

    /* renamed from: n  reason: collision with root package name */
    private OnNavigateToScreenListener f10878n;

    public interface OnDisplayPreferenceDialogListener {
        void onDisplayPreferenceDialog(Preference preference);
    }

    public interface OnNavigateToScreenListener {
        void onNavigateToScreen(PreferenceScreen preferenceScreen);
    }

    public interface OnPreferenceTreeClickListener {
        boolean onPreferenceTreeClick(Preference preference);
    }

    public static abstract class PreferenceComparisonCallback {
        public abstract boolean arePreferenceContentsTheSame(Preference preference, Preference preference2);

        public abstract boolean arePreferenceItemsTheSame(Preference preference, Preference preference2);
    }

    public static class SimplePreferenceComparisonCallback extends PreferenceComparisonCallback {
        public boolean arePreferenceContentsTheSame(Preference preference, Preference preference2) {
            if (preference.getClass() != preference2.getClass()) {
                return false;
            }
            if ((preference == preference2 && preference.wasDetached()) || !TextUtils.equals(preference.getTitle(), preference2.getTitle()) || !TextUtils.equals(preference.getSummary(), preference2.getSummary())) {
                return false;
            }
            Drawable icon = preference.getIcon();
            Drawable icon2 = preference2.getIcon();
            if ((icon != icon2 && (icon == null || !icon.equals(icon2))) || preference.isEnabled() != preference2.isEnabled() || preference.isSelectable() != preference2.isSelectable()) {
                return false;
            }
            if ((preference instanceof TwoStatePreference) && ((TwoStatePreference) preference).isChecked() != ((TwoStatePreference) preference2).isChecked()) {
                return false;
            }
            if (!(preference instanceof DropDownPreference) || preference == preference2) {
                return true;
            }
            return false;
        }

        public boolean arePreferenceItemsTheSame(Preference preference, Preference preference2) {
            return preference.getId() == preference2.getId();
        }
    }

    public PreferenceManager(Context context) {
        this.f10865a = context;
        r(b(context));
    }

    private static String b(Context context) {
        return context.getPackageName() + "_preferences";
    }

    private void l(boolean z2) {
        SharedPreferences.Editor editor;
        if (!z2 && (editor = this.f10869e) != null) {
            editor.apply();
        }
        this.f10870f = z2;
    }

    public <T extends Preference> T a(CharSequence charSequence) {
        PreferenceScreen preferenceScreen = this.f10874j;
        if (preferenceScreen == null) {
            return null;
        }
        return preferenceScreen.findPreference(charSequence);
    }

    /* access modifiers changed from: package-private */
    public SharedPreferences.Editor c() {
        if (this.f10868d != null) {
            return null;
        }
        if (!this.f10870f) {
            return j().edit();
        }
        if (this.f10869e == null) {
            this.f10869e = j().edit();
        }
        return this.f10869e;
    }

    /* access modifiers changed from: package-private */
    public long d() {
        long j2;
        synchronized (this) {
            j2 = this.f10866b;
            this.f10866b = 1 + j2;
        }
        return j2;
    }

    public OnNavigateToScreenListener e() {
        return this.f10878n;
    }

    public OnPreferenceTreeClickListener f() {
        return this.f10876l;
    }

    public PreferenceComparisonCallback g() {
        return this.f10875k;
    }

    public PreferenceDataStore h() {
        return this.f10868d;
    }

    public PreferenceScreen i() {
        return this.f10874j;
    }

    public SharedPreferences j() {
        Context context;
        if (h() != null) {
            return null;
        }
        if (this.f10867c == null) {
            if (this.f10873i != 1) {
                context = this.f10865a;
            } else {
                context = ContextCompat.createDeviceProtectedStorageContext(this.f10865a);
            }
            this.f10867c = context.getSharedPreferences(this.f10871g, this.f10872h);
        }
        return this.f10867c;
    }

    public PreferenceScreen k(Context context, int i2, PreferenceScreen preferenceScreen) {
        l(true);
        PreferenceScreen preferenceScreen2 = (PreferenceScreen) new PreferenceInflater(context, this).d(i2, preferenceScreen);
        preferenceScreen2.onAttachedToHierarchy(this);
        l(false);
        return preferenceScreen2;
    }

    public void m(OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener) {
        this.f10877m = onDisplayPreferenceDialogListener;
    }

    public void n(OnNavigateToScreenListener onNavigateToScreenListener) {
        this.f10878n = onNavigateToScreenListener;
    }

    public void o(OnPreferenceTreeClickListener onPreferenceTreeClickListener) {
        this.f10876l = onPreferenceTreeClickListener;
    }

    public boolean p(PreferenceScreen preferenceScreen) {
        PreferenceScreen preferenceScreen2 = this.f10874j;
        if (preferenceScreen == preferenceScreen2) {
            return false;
        }
        if (preferenceScreen2 != null) {
            preferenceScreen2.onDetached();
        }
        this.f10874j = preferenceScreen;
        return true;
    }

    public void q(int i2) {
        this.f10872h = i2;
        this.f10867c = null;
    }

    public void r(String str) {
        this.f10871g = str;
        this.f10867c = null;
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        return !this.f10870f;
    }

    public void t(Preference preference) {
        OnDisplayPreferenceDialogListener onDisplayPreferenceDialogListener = this.f10877m;
        if (onDisplayPreferenceDialogListener != null) {
            onDisplayPreferenceDialogListener.onDisplayPreferenceDialog(preference);
        }
    }
}

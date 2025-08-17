package com.startapp;

import android.content.SharedPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class x6 implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f36913a;

    /* renamed from: b  reason: collision with root package name */
    public final b f36914b;

    public interface b {
    }

    public x6(SharedPreferences sharedPreferences) {
        this(sharedPreferences, (b) null);
    }

    /* renamed from: a */
    public a edit() {
        return new a(this.f36913a.edit(), this.f36913a.getAll(), this.f36914b);
    }

    public boolean contains(String str) {
        try {
            return this.f36913a.contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public Map<String, ?> getAll() {
        try {
            return this.f36913a.getAll();
        } catch (Throwable unused) {
            return Collections.emptyMap();
        }
    }

    public boolean getBoolean(String str, boolean z2) {
        try {
            return this.f36913a.getBoolean(str, z2);
        } catch (Throwable unused) {
            return z2;
        }
    }

    public float getFloat(String str, float f2) {
        try {
            return this.f36913a.getFloat(str, f2);
        } catch (Throwable unused) {
            return f2;
        }
    }

    public int getInt(String str, int i2) {
        try {
            return this.f36913a.getInt(str, i2);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public long getLong(String str, long j2) {
        try {
            return this.f36913a.getLong(str, j2);
        } catch (Throwable unused) {
            return j2;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.f36913a.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.f36913a.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f36913a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f36913a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public x6(SharedPreferences sharedPreferences, b bVar) {
        this.f36913a = sharedPreferences;
        this.f36914b = bVar;
    }

    public static class a implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public final SharedPreferences.Editor f36915a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, ?> f36916b;

        /* renamed from: c  reason: collision with root package name */
        public final b f36917c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f36918d;

        public a(SharedPreferences.Editor editor, Map<String, ?> map, b bVar) {
            this.f36915a = editor;
            this.f36916b = map;
            this.f36917c = bVar;
        }

        public final <T> void a(String str, T t2) {
            if (this.f36917c != null && !lb.a(this.f36916b.get(str), t2)) {
                this.f36918d = true;
            }
        }

        public void apply() {
            this.f36915a.apply();
            b bVar = this.f36917c;
            if (bVar != null && this.f36918d) {
                this.f36918d = false;
                hb.f34639a.a(((bd) bVar).f34263a.f36461b, MetaDataRequest.RequestReason.EXTRAS);
            }
        }

        public SharedPreferences.Editor clear() {
            if (!this.f36916b.isEmpty()) {
                this.f36918d = true;
            }
            this.f36915a.clear();
            return this;
        }

        public boolean commit() {
            return this.f36915a.commit();
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z2) {
            a(str, Boolean.valueOf(z2));
            this.f36915a.putBoolean(str, z2);
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f2) {
            a(str, Float.valueOf(f2));
            this.f36915a.putFloat(str, f2);
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i2) {
            a(str, Integer.valueOf(i2));
            this.f36915a.putInt(str, i2);
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j2) {
            a(str, Long.valueOf(j2));
            this.f36915a.putLong(str, j2);
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            a(str, str2);
            this.f36915a.putString(str, str2);
            return this;
        }

        public SharedPreferences.Editor putStringSet(String str, Set set) {
            a(str, set);
            this.f36915a.putStringSet(str, set);
            return this;
        }

        public a a(String str, String str2) {
            a(str, str2);
            this.f36915a.putString(str, str2);
            return this;
        }

        public a a(String str, int i2) {
            a(str, Integer.valueOf(i2));
            this.f36915a.putInt(str, i2);
            return this;
        }

        public a a(String str, long j2) {
            a(str, Long.valueOf(j2));
            this.f36915a.putLong(str, j2);
            return this;
        }

        /* renamed from: a */
        public a remove(String str) {
            if (this.f36916b.containsKey(str)) {
                this.f36918d = true;
            }
            this.f36915a.remove(str);
            return this;
        }
    }
}

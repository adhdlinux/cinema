package com.applovin.impl.sdk.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.sdk.e.a;
import com.applovin.impl.sdk.e.o;
import com.applovin.impl.sdk.e.z;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.v;
import java.util.Set;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static m f15241a;

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f15242b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f15243c;

    public e(m mVar) {
        this.f15243c = mVar.L().getSharedPreferences("com.applovin.sdk.preferences." + mVar.z(), 0);
        if (!mVar.e()) {
            f15241a = mVar;
        }
    }

    private static SharedPreferences a(Context context) {
        if (f15242b == null) {
            f15242b = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f15242b;
    }

    public static <T> T a(String str, T t2, Class cls, SharedPreferences sharedPreferences) {
        T t3;
        long j2;
        int i2;
        Class<Integer> cls2 = Integer.class;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (sharedPreferences.contains(str)) {
                if (Boolean.class.equals(cls)) {
                    t3 = Boolean.valueOf(t2 != null ? sharedPreferences.getBoolean(str, ((Boolean) t2).booleanValue()) : sharedPreferences.getBoolean(str, false));
                } else if (Float.class.equals(cls)) {
                    t3 = Float.valueOf(t2 != null ? sharedPreferences.getFloat(str, ((Float) t2).floatValue()) : sharedPreferences.getFloat(str, 0.0f));
                } else {
                    Class<Long> cls3 = Long.class;
                    if (cls2.equals(cls)) {
                        if (t2 != null) {
                            i2 = sharedPreferences.getInt(str, t2.getClass().equals(cls3) ? ((Long) t2).intValue() : ((Integer) t2).intValue());
                        } else {
                            i2 = sharedPreferences.getInt(str, 0);
                        }
                        t3 = Integer.valueOf(i2);
                    } else if (cls3.equals(cls)) {
                        if (t2 != null) {
                            j2 = sharedPreferences.getLong(str, t2.getClass().equals(cls2) ? ((Integer) t2).longValue() : ((Long) t2).longValue());
                        } else {
                            j2 = sharedPreferences.getLong(str, 0);
                        }
                        t3 = Long.valueOf(j2);
                    } else if (Double.class.equals(cls)) {
                        t3 = Double.valueOf(t2 != null ? Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) t2).doubleValue()))) : Double.longBitsToDouble(sharedPreferences.getLong(str, 0)));
                    } else {
                        t3 = String.class.equals(cls) ? sharedPreferences.getString(str, (String) t2) : Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) t2) : t2;
                    }
                }
                if (t3 != null) {
                    return cls.cast(t3);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                return t2;
            }
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return t2;
        } catch (Throwable th) {
            if (v.a()) {
                v.c("SharedPreferencesManager", "Error getting value for key: " + str, th);
            }
            return t2;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    private static void a(final SharedPreferences.Editor editor) {
        try {
            m mVar = f15241a;
            if (mVar != null && ((Boolean) mVar.a(b.eJ)).booleanValue()) {
                if (!Utils.isMainThread()) {
                    editor.commit();
                    return;
                } else if (f15241a.S() != null) {
                    f15241a.S().a((a) new z(f15241a, new Runnable() {
                        public void run() {
                            editor.commit();
                        }
                    }), o.a.BACKGROUND);
                    return;
                }
            }
            editor.apply();
        } catch (Throwable th) {
            if (v.a()) {
                v.c("SharedPreferencesManager", "Unable to apply changes", th);
            }
        }
    }

    public static <T> void a(d<T> dVar, T t2, Context context) {
        a(dVar.a(), t2, a(context), (SharedPreferences.Editor) null);
    }

    public static <T> void a(String str, T t2, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        long doubleToRawLongBits;
        boolean z2 = true;
        boolean z3 = editor != null;
        if (!z3) {
            editor = sharedPreferences.edit();
        }
        if (t2 == null) {
            editor.remove(str);
        } else if (t2 instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) t2).booleanValue());
        } else if (t2 instanceof Float) {
            editor.putFloat(str, ((Float) t2).floatValue());
        } else if (t2 instanceof Integer) {
            editor.putInt(str, ((Integer) t2).intValue());
        } else {
            if (t2 instanceof Long) {
                doubleToRawLongBits = ((Long) t2).longValue();
            } else if (t2 instanceof Double) {
                doubleToRawLongBits = Double.doubleToRawLongBits(((Double) t2).doubleValue());
            } else if (t2 instanceof String) {
                editor.putString(str, (String) t2);
            } else if (t2 instanceof Set) {
                editor.putStringSet(str, (Set) t2);
            } else {
                if (v.a()) {
                    v.i("SharedPreferencesManager", "Unable to put default value of invalid type: " + t2);
                }
                z2 = false;
            }
            editor.putLong(str, doubleToRawLongBits);
        }
        if (z2 && !z3) {
            a(editor);
        }
    }

    public static <T> T b(d<T> dVar, T t2, Context context) {
        return a(dVar.a(), t2, (Class) dVar.b(), a(context));
    }

    public void a(SharedPreferences sharedPreferences) {
        a(sharedPreferences.edit().clear());
    }

    public <T> void a(d<T> dVar) {
        a(this.f15243c.edit().remove(dVar.a()));
    }

    public <T> void a(d<T> dVar, T t2) {
        a(dVar, t2, this.f15243c);
    }

    public <T> void a(d<T> dVar, T t2, SharedPreferences sharedPreferences) {
        a(dVar.a(), t2, sharedPreferences);
    }

    public <T> void a(String str, T t2, SharedPreferences.Editor editor) {
        a(str, t2, (SharedPreferences) null, editor);
    }

    public <T> void a(String str, T t2, SharedPreferences sharedPreferences) {
        a(str, t2, sharedPreferences, (SharedPreferences.Editor) null);
    }

    public <T> T b(d<T> dVar, T t2) {
        return b(dVar, t2, this.f15243c);
    }

    public <T> T b(d<T> dVar, T t2, SharedPreferences sharedPreferences) {
        return a(dVar.a(), t2, (Class) dVar.b(), sharedPreferences);
    }
}

package com.vungle.ads.internal.persistence;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.util.CollectionsConcurrencyUtil;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class FilePreferences {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String FILENAME = "settings_vungle";
    public static final String GENERIC_TPAT_FAILED_FILENAME = "failedGenericTpats";
    public static final String TPAT_FAILED_FILENAME = "failedTpats";
    /* access modifiers changed from: private */
    public static final ConcurrentHashMap<String, FilePreferences> filePreferenceMap = new ConcurrentHashMap<>();
    private final File file;
    private final Executor ioExecutor;
    private final ConcurrentHashMap<String, Object> values;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ FilePreferences get$default(Companion companion, Executor executor, PathProvider pathProvider, String str, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str = FilePreferences.FILENAME;
            }
            return companion.get(executor, pathProvider, str);
        }

        public static /* synthetic */ void getFILENAME$annotations() {
        }

        public final synchronized FilePreferences get(Executor executor, PathProvider pathProvider, String str) {
            Object obj;
            Intrinsics.f(executor, "ioExecutor");
            Intrinsics.f(pathProvider, "pathProvider");
            Intrinsics.f(str, "filename");
            ConcurrentHashMap access$getFilePreferenceMap$cp = FilePreferences.filePreferenceMap;
            obj = access$getFilePreferenceMap$cp.get(str);
            if (obj == null) {
                obj = new FilePreferences(executor, pathProvider, str, (DefaultConstructorMarker) null);
                Object putIfAbsent = access$getFilePreferenceMap$cp.putIfAbsent(str, obj);
                if (putIfAbsent != null) {
                    obj = putIfAbsent;
                }
            }
            Intrinsics.e(obj, "filePreferenceMap.getOrP…, filename)\n            }");
            return (FilePreferences) obj;
        }
    }

    private FilePreferences(Executor executor, PathProvider pathProvider, String str) {
        this.ioExecutor = executor;
        File file2 = new File(pathProvider.getSharedPrefsDir(), str);
        this.file = file2;
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        this.values = concurrentHashMap;
        Object readSerializable = FileUtility.readSerializable(file2);
        if (readSerializable instanceof HashMap) {
            concurrentHashMap.putAll((HashMap) readSerializable);
        }
    }

    public /* synthetic */ FilePreferences(Executor executor, PathProvider pathProvider, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(executor, pathProvider, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: apply$lambda-0  reason: not valid java name */
    public static final void m194apply$lambda0(FilePreferences filePreferences, Serializable serializable) {
        Intrinsics.f(filePreferences, "this$0");
        Intrinsics.f(serializable, "$serializable");
        FileUtility.writeSerializable(filePreferences.file, serializable);
    }

    public static final synchronized FilePreferences get(Executor executor, PathProvider pathProvider, String str) {
        FilePreferences filePreferences;
        synchronized (FilePreferences.class) {
            filePreferences = Companion.get(executor, pathProvider, str);
        }
        return filePreferences;
    }

    public final void apply() {
        this.ioExecutor.execute(new a(this, new HashMap(this.values)));
    }

    public final boolean getBoolean(String str, boolean z2) {
        Intrinsics.f(str, "key");
        Object obj = this.values.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z2;
    }

    public final int getInt(String str, int i2) {
        Intrinsics.f(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Integer) {
            return ((Number) obj).intValue();
        }
        return i2;
    }

    public final long getLong(String str, long j2) {
        Intrinsics.f(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Long) {
            return ((Number) obj).longValue();
        }
        return j2;
    }

    public final String getString(String str, String str2) {
        Intrinsics.f(str, "key");
        Intrinsics.f(str2, "defaultValue");
        Object obj = this.values.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public final HashSet<String> getStringSet(String str, HashSet<String> hashSet) {
        Intrinsics.f(str, "key");
        Intrinsics.f(hashSet, "defaultValue");
        Object obj = this.values.get(str);
        if (obj instanceof HashSet) {
            return CollectionsConcurrencyUtil.getNewHashSet((HashSet) obj);
        }
        return hashSet;
    }

    public final FilePreferences put(String str, boolean z2) {
        Intrinsics.f(str, "key");
        this.values.put(str, Boolean.valueOf(z2));
        return this;
    }

    public final FilePreferences remove(String str) {
        Intrinsics.f(str, "key");
        if (this.values.containsKey(str)) {
            this.values.remove(str);
        }
        return this;
    }

    public final FilePreferences put(String str, String str2) {
        Intrinsics.f(str, "key");
        Intrinsics.f(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.values.put(str, str2);
        return this;
    }

    public final Boolean getBoolean(String str) {
        Intrinsics.f(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    public final String getString(String str) {
        Intrinsics.f(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final FilePreferences put(String str, int i2) {
        Intrinsics.f(str, "key");
        this.values.put(str, Integer.valueOf(i2));
        return this;
    }

    public final FilePreferences put(String str, HashSet<String> hashSet) {
        Intrinsics.f(str, "key");
        this.values.put(str, CollectionsConcurrencyUtil.getNewHashSet(hashSet));
        return this;
    }

    public final FilePreferences put(String str, long j2) {
        Intrinsics.f(str, "key");
        this.values.put(str, Long.valueOf(j2));
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ FilePreferences(Executor executor, PathProvider pathProvider, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(executor, pathProvider, (i2 & 4) != 0 ? FILENAME : str);
    }
}

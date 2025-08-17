package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.Logger;
import java.util.HashMap;
import java.util.WeakHashMap;

public class WakeLocks {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12604a = Logger.f("WakeLocks");

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<PowerManager.WakeLock, String> f12605b = new WeakHashMap<>();

    private WakeLocks() {
    }

    public static void a() {
        HashMap hashMap = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = f12605b;
        synchronized (weakHashMap) {
            hashMap.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : hashMap.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                Logger.c().h(f12604a, String.format("WakeLock held for %s", new Object[]{hashMap.get(wakeLock)}), new Throwable[0]);
            }
        }
    }

    public static PowerManager.WakeLock b(Context context, String str) {
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str2);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = f12605b;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, str2);
        }
        return newWakeLock;
    }
}

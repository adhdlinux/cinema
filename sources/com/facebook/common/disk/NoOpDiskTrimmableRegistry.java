package com.facebook.common.disk;

import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.STRICT)
public class NoOpDiskTrimmableRegistry implements DiskTrimmableRegistry {
    private static NoOpDiskTrimmableRegistry sInstance;

    private NoOpDiskTrimmableRegistry() {
    }

    public static synchronized NoOpDiskTrimmableRegistry getInstance() {
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            if (sInstance == null) {
                sInstance = new NoOpDiskTrimmableRegistry();
            }
            noOpDiskTrimmableRegistry = sInstance;
        }
        return noOpDiskTrimmableRegistry;
    }

    public void registerDiskTrimmable(DiskTrimmable diskTrimmable) {
    }

    public void unregisterDiskTrimmable(DiskTrimmable diskTrimmable) {
    }
}

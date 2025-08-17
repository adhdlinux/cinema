package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DynamicDefaultDiskStorage;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe(Nullsafe.Mode.LOCAL)
public class DynamicDefaultDiskStorageFactory implements DiskStorageFactory {
    public DiskStorage get(DiskCacheConfig diskCacheConfig) {
        return new DynamicDefaultDiskStorage(diskCacheConfig.getVersion(), diskCacheConfig.getBaseDirectoryPathSupplier(), diskCacheConfig.getBaseDirectoryName(), diskCacheConfig.getCacheErrorLogger());
    }
}

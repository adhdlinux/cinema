package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy {

    /* renamed from: a  reason: collision with root package name */
    public static final DiskCacheStrategy f16454a = new DiskCacheStrategy() {
        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static final DiskCacheStrategy f16455b = new DiskCacheStrategy() {
        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean c(DataSource dataSource) {
            return false;
        }

        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static final DiskCacheStrategy f16456c = new DiskCacheStrategy() {
        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }

        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static final DiskCacheStrategy f16457d = new DiskCacheStrategy() {
        public boolean a() {
            return false;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return false;
        }

        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static final DiskCacheStrategy f16458e = new DiskCacheStrategy() {
        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z2 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    };

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z2, DataSource dataSource, EncodeStrategy encodeStrategy);
}

package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;
import java.util.Map;

public class SimpleDataSource<T> extends AbstractDataSource<T> {
    private SimpleDataSource() {
    }

    public static <T> SimpleDataSource<T> create() {
        return new SimpleDataSource<>();
    }

    public boolean setFailure(Throwable th) {
        return super.setFailure((Throwable) Preconditions.checkNotNull(th));
    }

    public boolean setProgress(float f2) {
        return super.setProgress(f2);
    }

    public boolean setResult(T t2, boolean z2, Map<String, Object> map) {
        return super.setResult(Preconditions.checkNotNull(t2), z2, map);
    }

    public boolean setResult(T t2) {
        return super.setResult(Preconditions.checkNotNull(t2), true, (Map<String, Object>) null);
    }
}

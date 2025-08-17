package com.google.android.datatransport.runtime.synchronization;

public interface SynchronizationGuard {

    public interface CriticalSection<T> {
        T execute();
    }

    <T> T f(CriticalSection<T> criticalSection);
}

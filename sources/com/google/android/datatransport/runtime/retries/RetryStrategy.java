package com.google.android.datatransport.runtime.retries;

public interface RetryStrategy<TInput, TResult> {
    TInput a(TInput tinput, TResult tresult);
}

package kotlinx.coroutines.flow;

import kotlinx.coroutines.Job;

final class ReadonlyStateFlow<T> implements StateFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Job f40708a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ StateFlow<T> f40709b;

    public ReadonlyStateFlow(StateFlow<? extends T> stateFlow, Job job) {
        this.f40708a = job;
        this.f40709b = stateFlow;
    }
}

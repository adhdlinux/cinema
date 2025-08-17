package kotlinx.coroutines.flow;

import kotlinx.coroutines.Job;

final /* synthetic */ class FlowKt__ShareKt {
    public static final <T> StateFlow<T> a(MutableStateFlow<T> mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, (Job) null);
    }
}

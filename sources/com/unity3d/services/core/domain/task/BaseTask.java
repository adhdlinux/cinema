package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.task.BaseParams;
import kotlin.coroutines.Continuation;

public interface BaseTask<P extends BaseParams, R> extends IServiceComponent {

    public static final class DefaultImpls {
        public static <P extends BaseParams, R> IServiceProvider getServiceProvider(BaseTask<? super P, R> baseTask) {
            return IServiceComponent.DefaultImpls.getServiceProvider(baseTask);
        }

        public static <P extends BaseParams, R> Object invoke(BaseTask<? super P, R> baseTask, P p2, Continuation<? super R> continuation) {
            return baseTask.doWork(p2, continuation);
        }
    }

    Object doWork(P p2, Continuation<? super R> continuation);

    Object invoke(P p2, Continuation<? super R> continuation);
}

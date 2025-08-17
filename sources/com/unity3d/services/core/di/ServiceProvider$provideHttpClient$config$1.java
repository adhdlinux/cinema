package com.unity3d.services.core.di;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.di.ServiceProvider$provideHttpClient$config$1", f = "ServiceProvider.kt", l = {134}, m = "invokeSuspend")
final class ServiceProvider$provideHttpClient$config$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    final /* synthetic */ ConfigFileFromLocalStorage $configFileFromLocalStorage;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceProvider$provideHttpClient$config$1(ConfigFileFromLocalStorage configFileFromLocalStorage, Continuation<? super ServiceProvider$provideHttpClient$config$1> continuation) {
        super(2, continuation);
        this.$configFileFromLocalStorage = configFileFromLocalStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ServiceProvider$provideHttpClient$config$1 serviceProvider$provideHttpClient$config$1 = new ServiceProvider$provideHttpClient$config$1(this.$configFileFromLocalStorage, continuation);
        serviceProvider$provideHttpClient$config$1.L$0 = obj;
        return serviceProvider$provideHttpClient$config$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((ServiceProvider$provideHttpClient$config$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ConfigFileFromLocalStorage configFileFromLocalStorage = this.$configFileFromLocalStorage;
            Result.Companion companion = Result.f40263c;
            ConfigFileFromLocalStorage.Params params = new ConfigFileFromLocalStorage.Params();
            this.label = 1;
            obj = configFileFromLocalStorage.invoke(params, this);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.b(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f40263c;
                obj2 = Result.b(ResultKt.a(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        obj2 = Result.b((Configuration) obj);
        if (Result.g(obj2)) {
            return null;
        }
        return obj2;
    }
}

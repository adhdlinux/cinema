package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$doWork$2", f = "ConfigFileFromLocalStorage.kt", l = {}, m = "invokeSuspend")
final class ConfigFileFromLocalStorage$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    int label;

    ConfigFileFromLocalStorage$doWork$2(Continuation<? super ConfigFileFromLocalStorage$doWork$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfigFileFromLocalStorage$doWork$2(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((ConfigFileFromLocalStorage$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.label == 0) {
            ResultKt.b(obj);
            return new Configuration(new JSONObject(FilesKt__FileReadWriteKt.b(new File(SdkProperties.getLocalConfigurationFilepath()), (Charset) null, 1, (Object) null)));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

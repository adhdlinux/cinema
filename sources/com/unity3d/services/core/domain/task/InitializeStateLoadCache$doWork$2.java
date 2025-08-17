package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import java.nio.charset.Charset;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2", f = "InitializeStateLoadCache.kt", l = {}, m = "invokeSuspend")
final class InitializeStateLoadCache$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InitializeStateLoadCache.LoadCacheResult>, Object> {
    final /* synthetic */ InitializeStateLoadCache.Params $params;
    int label;
    final /* synthetic */ InitializeStateLoadCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateLoadCache$doWork$2(InitializeStateLoadCache initializeStateLoadCache, InitializeStateLoadCache.Params params, Continuation<? super InitializeStateLoadCache$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateLoadCache;
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateLoadCache$doWork$2(this.this$0, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InitializeStateLoadCache.LoadCacheResult> continuation) {
        return ((InitializeStateLoadCache$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.label == 0) {
            ResultKt.b(obj);
            DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
            byte[] access$getWebViewData = this.this$0.getWebViewData();
            boolean z2 = true;
            if (access$getWebViewData == null) {
                return new InitializeStateLoadCache.LoadCacheResult(true, (String) null, 2, (DefaultConstructorMarker) null);
            }
            String Sha256 = Utilities.Sha256(access$getWebViewData);
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.e(forName, "forName(\"UTF-8\")");
            String str = new String(access$getWebViewData, forName);
            if (Sha256 != null && Intrinsics.a(Sha256, this.$params.getConfig().getWebViewHash())) {
                z2 = false;
            }
            if (!z2) {
                DeviceLog.info("Unity Ads init: webapp loaded from local cache");
            }
            return new InitializeStateLoadCache.LoadCacheResult(z2, str);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}

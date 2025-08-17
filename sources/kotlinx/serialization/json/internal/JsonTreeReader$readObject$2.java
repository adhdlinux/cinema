package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.serialization.json.JsonElement;

@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {23}, m = "readObject")
final class JsonTreeReader$readObject$2 extends ContinuationImpl {

    /* renamed from: i  reason: collision with root package name */
    Object f41247i;

    /* renamed from: j  reason: collision with root package name */
    Object f41248j;

    /* renamed from: k  reason: collision with root package name */
    Object f41249k;

    /* renamed from: l  reason: collision with root package name */
    Object f41250l;

    /* renamed from: m  reason: collision with root package name */
    /* synthetic */ Object f41251m;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ JsonTreeReader f41252n;

    /* renamed from: o  reason: collision with root package name */
    int f41253o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsonTreeReader$readObject$2(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readObject$2> continuation) {
        super(continuation);
        this.f41252n = jsonTreeReader;
    }

    public final Object invokeSuspend(Object obj) {
        this.f41251m = obj;
        this.f41253o |= Integer.MIN_VALUE;
        return this.f41252n.h((DeepRecursiveScope<Unit, JsonElement>) null, this);
    }
}

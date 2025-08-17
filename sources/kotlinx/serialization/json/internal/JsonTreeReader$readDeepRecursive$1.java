package kotlinx.serialization.json.internal;

import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.serialization.json.JsonElement;

@DebugMetadata(c = "kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", l = {112}, m = "invokeSuspend")
final class JsonTreeReader$readDeepRecursive$1 extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, JsonElement>, Unit, Continuation<? super JsonElement>, Object> {

    /* renamed from: j  reason: collision with root package name */
    int f41244j;

    /* renamed from: k  reason: collision with root package name */
    private /* synthetic */ Object f41245k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ JsonTreeReader f41246l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    JsonTreeReader$readDeepRecursive$1(JsonTreeReader jsonTreeReader, Continuation<? super JsonTreeReader$readDeepRecursive$1> continuation) {
        super(3, continuation);
        this.f41246l = jsonTreeReader;
    }

    /* renamed from: a */
    public final Object invoke(DeepRecursiveScope<Unit, JsonElement> deepRecursiveScope, Unit unit, Continuation<? super JsonElement> continuation) {
        JsonTreeReader$readDeepRecursive$1 jsonTreeReader$readDeepRecursive$1 = new JsonTreeReader$readDeepRecursive$1(this.f41246l, continuation);
        jsonTreeReader$readDeepRecursive$1.f41245k = deepRecursiveScope;
        return jsonTreeReader$readDeepRecursive$1.invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f41244j;
        if (i2 == 0) {
            ResultKt.b(obj);
            DeepRecursiveScope deepRecursiveScope = (DeepRecursiveScope) this.f41245k;
            byte E = this.f41246l.f41241a.E();
            if (E == 1) {
                return this.f41246l.j(true);
            }
            if (E == 0) {
                return this.f41246l.j(false);
            }
            if (E == 6) {
                JsonTreeReader jsonTreeReader = this.f41246l;
                this.f41244j = 1;
                obj = jsonTreeReader.h(deepRecursiveScope, this);
                if (obj == e2) {
                    return e2;
                }
            } else if (E == 8) {
                return this.f41246l.f();
            } else {
                AbstractJsonLexer.y(this.f41246l.f41241a, "Can't begin reading element, unexpected token", 0, (String) null, 6, (Object) null);
                throw new KotlinNothingValueException();
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (JsonElement) obj;
    }
}

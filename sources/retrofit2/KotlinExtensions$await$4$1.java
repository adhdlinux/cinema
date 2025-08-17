package retrofit2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class KotlinExtensions$await$4$1 extends Lambda implements Function1<Throwable, Unit> {
    final /* synthetic */ Call<T> $this_await;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KotlinExtensions$await$4$1(Call<T> call) {
        super(1);
        this.$this_await = call;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f40298a;
    }

    public final void invoke(Throwable th) {
        this.$this_await.cancel();
    }
}

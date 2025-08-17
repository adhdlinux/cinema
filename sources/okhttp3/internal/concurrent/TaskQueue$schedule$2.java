package okhttp3.internal.concurrent;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class TaskQueue$schedule$2 extends Task {
    final /* synthetic */ Function0<Long> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskQueue$schedule$2(String str, Function0<Long> function0) {
        super(str, false, 2, (DefaultConstructorMarker) null);
        this.$block = function0;
    }

    public long runOnce() {
        return this.$block.invoke().longValue();
    }
}

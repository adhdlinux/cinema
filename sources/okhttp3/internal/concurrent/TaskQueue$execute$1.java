package okhttp3.internal.concurrent;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public final class TaskQueue$execute$1 extends Task {
    final /* synthetic */ Function0<Unit> $block;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(String str, boolean z2, Function0<Unit> function0) {
        super(str, z2);
        this.$block = function0;
    }

    public long runOnce() {
        this.$block.invoke();
        return -1;
    }
}

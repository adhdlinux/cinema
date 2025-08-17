package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class YieldContext extends AbstractCoroutineContextElement {

    /* renamed from: c  reason: collision with root package name */
    public static final Key f40697c = new Key((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    public boolean f40698b;

    public static final class Key implements CoroutineContext.Key<YieldContext> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public YieldContext() {
        super(f40697c);
    }
}

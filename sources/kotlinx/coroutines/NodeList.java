package kotlinx.coroutines;

import kotlinx.coroutines.internal.LockFreeLinkedListHead;

public final class NodeList extends LockFreeLinkedListHead implements Incomplete {
    public NodeList a() {
        return this;
    }

    public boolean isActive() {
        return true;
    }

    public String toString() {
        return super.toString();
    }
}

package kotlinx.coroutines;

public final class InactiveNodeList implements Incomplete {

    /* renamed from: b  reason: collision with root package name */
    private final NodeList f40654b;

    public InactiveNodeList(NodeList nodeList) {
        this.f40654b = nodeList;
    }

    public NodeList a() {
        return this.f40654b;
    }

    public boolean isActive() {
        return false;
    }

    public String toString() {
        return super.toString();
    }
}

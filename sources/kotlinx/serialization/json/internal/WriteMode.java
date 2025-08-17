package kotlinx.serialization.json.internal;

public enum WriteMode {
    OBJ('{', '}'),
    LIST('[', ']'),
    MAP('{', '}'),
    POLY_OBJ('[', ']');
    

    /* renamed from: b  reason: collision with root package name */
    public final char f41285b;

    /* renamed from: c  reason: collision with root package name */
    public final char f41286c;

    private WriteMode(char c2, char c3) {
        this.f41285b = c2;
        this.f41286c = c3;
    }
}

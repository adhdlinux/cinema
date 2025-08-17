package kotlinx.serialization.internal;

public abstract class PrimitiveArrayBuilder<Array> {
    public static /* synthetic */ void c(PrimitiveArrayBuilder primitiveArrayBuilder, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i2 = primitiveArrayBuilder.d() + 1;
            }
            primitiveArrayBuilder.b(i2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
    }

    public abstract Array a();

    public abstract void b(int i2);

    public abstract int d();
}

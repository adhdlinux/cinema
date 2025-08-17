package kotlin;

class LazyKt__LazyKt extends LazyKt__LazyJVMKt {
    public static <T> Lazy<T> c(T t2) {
        return new InitializedLazyImpl(t2);
    }
}

package kotlinx.coroutines.flow;

public interface MutableStateFlow<T> extends StateFlow<T> {
    boolean a(T t2, T t3);

    T getValue();

    void setValue(T t2);
}

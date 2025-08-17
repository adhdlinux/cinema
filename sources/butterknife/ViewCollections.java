package butterknife;

import android.util.Property;
import android.view.View;
import java.util.List;

public final class ViewCollections {
    private ViewCollections() {
    }

    @SafeVarargs
    public static <T extends View> void run(List<T> list, Action<? super T>... actionArr) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            for (Action<? super T> apply : actionArr) {
                apply.apply((View) list.get(i2), i2);
            }
        }
    }

    public static <T extends View, V> void set(List<T> list, Setter<? super T, V> setter, V v2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            setter.set((View) list.get(i2), v2, i2);
        }
    }

    public static <T extends View, V> void set(T[] tArr, Setter<? super T, V> setter, V v2) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            setter.set(tArr[i2], v2, i2);
        }
    }

    @SafeVarargs
    public static <T extends View> void run(T[] tArr, Action<? super T>... actionArr) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            for (Action<? super T> apply : actionArr) {
                apply.apply(tArr[i2], i2);
            }
        }
    }

    public static <T extends View, V> void set(T t2, Setter<? super T, V> setter, V v2) {
        setter.set(t2, v2, 0);
    }

    public static <T extends View, V> void set(List<T> list, Property<? super T, V> property, V v2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            property.set(list.get(i2), v2);
        }
    }

    public static <T extends View> void run(List<T> list, Action<? super T> action) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            action.apply((View) list.get(i2), i2);
        }
    }

    public static <T extends View, V> void set(T[] tArr, Property<? super T, V> property, V v2) {
        for (T t2 : tArr) {
            property.set(t2, v2);
        }
    }

    public static <T extends View> void run(T[] tArr, Action<? super T> action) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            action.apply(tArr[i2], i2);
        }
    }

    public static <T extends View, V> void set(T t2, Property<? super T, V> property, V v2) {
        property.set(t2, v2);
    }

    @SafeVarargs
    public static <T extends View> void run(T t2, Action<? super T>... actionArr) {
        for (Action<? super T> apply : actionArr) {
            apply.apply(t2, 0);
        }
    }

    public static <T extends View> void run(T t2, Action<? super T> action) {
        action.apply(t2, 0);
    }
}

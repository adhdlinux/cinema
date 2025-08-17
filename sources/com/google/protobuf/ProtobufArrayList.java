package com.google.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST;
    private E[] array;
    private int size;

    static {
        ProtobufArrayList<Object> protobufArrayList = new ProtobufArrayList<>(new Object[0], 0);
        EMPTY_LIST = protobufArrayList;
        protobufArrayList.makeImmutable();
    }

    ProtobufArrayList() {
        this(new Object[10], 0);
    }

    private static <E> E[] createArray(int i2) {
        return new Object[i2];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i2) {
        if (i2 < 0 || i2 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i2) {
        return "Index:" + i2 + ", Size:" + this.size;
    }

    public boolean add(E e2) {
        ensureIsMutable();
        int i2 = this.size;
        E[] eArr = this.array;
        if (i2 == eArr.length) {
            this.array = Arrays.copyOf(eArr, ((i2 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i3 = this.size;
        this.size = i3 + 1;
        eArr2[i3] = e2;
        this.modCount++;
        return true;
    }

    public E get(int i2) {
        ensureIndexInRange(i2);
        return this.array[i2];
    }

    public E remove(int i2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        E[] eArr = this.array;
        E e2 = eArr[i2];
        int i3 = this.size;
        if (i2 < i3 - 1) {
            System.arraycopy(eArr, i2 + 1, eArr, i2, (i3 - i2) - 1);
        }
        this.size--;
        this.modCount++;
        return e2;
    }

    public E set(int i2, E e2) {
        ensureIsMutable();
        ensureIndexInRange(i2);
        E[] eArr = this.array;
        E e3 = eArr[i2];
        eArr[i2] = e2;
        this.modCount++;
        return e3;
    }

    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] eArr, int i2) {
        this.array = eArr;
        this.size = i2;
    }

    public ProtobufArrayList<E> mutableCopyWithCapacity(int i2) {
        if (i2 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i2), this.size);
        }
        throw new IllegalArgumentException();
    }

    public void add(int i2, E e2) {
        int i3;
        ensureIsMutable();
        if (i2 < 0 || i2 > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i2));
        }
        E[] eArr = this.array;
        if (i3 < eArr.length) {
            System.arraycopy(eArr, i2, eArr, i2 + 1, i3 - i2);
        } else {
            E[] createArray = createArray(((i3 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, createArray, 0, i2);
            System.arraycopy(this.array, i2, createArray, i2 + 1, this.size - i2);
            this.array = createArray;
        }
        this.array[i2] = e2;
        this.size++;
        this.modCount++;
    }
}

package com.google.common.collect;

final class Hashing {
    private Hashing() {
    }

    static int a(int i2, double d2) {
        int max = Math.max(i2, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d2 * ((double) highestOneBit)))) {
            return highestOneBit;
        }
        int i3 = highestOneBit << 1;
        if (i3 > 0) {
            return i3;
        }
        return 1073741824;
    }

    static int b(int i2) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i2) * -862048943), 15)) * 461845907);
    }

    static int c(Object obj) {
        return b(obj == null ? 0 : obj.hashCode());
    }
}

package androidx.customview.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy {

    public interface BoundsAdapter<T> {
        void a(T t2, Rect rect);
    }

    public interface CollectionAdapter<T, V> {
        V a(T t2, int i2);

        int b(T t2);
    }

    private static class SequentialComparator<T> implements Comparator<T> {

        /* renamed from: b  reason: collision with root package name */
        private final Rect f2999b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        private final Rect f3000c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3001d;

        /* renamed from: e  reason: collision with root package name */
        private final BoundsAdapter<T> f3002e;

        SequentialComparator(boolean z2, BoundsAdapter<T> boundsAdapter) {
            this.f3001d = z2;
            this.f3002e = boundsAdapter;
        }

        public int compare(T t2, T t3) {
            Rect rect = this.f2999b;
            Rect rect2 = this.f3000c;
            this.f3002e.a(t2, rect);
            this.f3002e.a(t3, rect2);
            int i2 = rect.top;
            int i3 = rect2.top;
            if (i2 < i3) {
                return -1;
            }
            if (i2 > i3) {
                return 1;
            }
            int i4 = rect.left;
            int i5 = rect2.left;
            if (i4 < i5) {
                if (this.f3001d) {
                    return 1;
                }
                return -1;
            } else if (i4 <= i5) {
                int i6 = rect.bottom;
                int i7 = rect2.bottom;
                if (i6 < i7) {
                    return -1;
                }
                if (i6 > i7) {
                    return 1;
                }
                int i8 = rect.right;
                int i9 = rect2.right;
                if (i8 < i9) {
                    if (this.f3001d) {
                        return 1;
                    }
                    return -1;
                } else if (i8 <= i9) {
                    return 0;
                } else {
                    if (this.f3001d) {
                        return -1;
                    }
                    return 1;
                }
            } else if (this.f3001d) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private FocusStrategy() {
    }

    private static boolean a(int i2, Rect rect, Rect rect2, Rect rect3) {
        boolean b2 = b(i2, rect, rect2);
        if (b(i2, rect, rect3) || !b2) {
            return false;
        }
        if (j(i2, rect, rect3) && i2 != 17 && i2 != 66 && k(i2, rect, rect2) >= m(i2, rect, rect3)) {
            return false;
        }
        return true;
    }

    private static boolean b(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static <L, T> T c(L l2, CollectionAdapter<L, T> collectionAdapter, BoundsAdapter<T> boundsAdapter, T t2, Rect rect, int i2) {
        Rect rect2 = new Rect(rect);
        if (i2 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i2 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i2 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i2 == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int b2 = collectionAdapter.b(l2);
        Rect rect3 = new Rect();
        T t3 = null;
        for (int i3 = 0; i3 < b2; i3++) {
            T a2 = collectionAdapter.a(l2, i3);
            if (a2 != t2) {
                boundsAdapter.a(a2, rect3);
                if (h(i2, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t3 = a2;
                }
            }
        }
        return t3;
    }

    public static <L, T> T d(L l2, CollectionAdapter<L, T> collectionAdapter, BoundsAdapter<T> boundsAdapter, T t2, int i2, boolean z2, boolean z3) {
        int b2 = collectionAdapter.b(l2);
        ArrayList arrayList = new ArrayList(b2);
        for (int i3 = 0; i3 < b2; i3++) {
            arrayList.add(collectionAdapter.a(l2, i3));
        }
        Collections.sort(arrayList, new SequentialComparator(z2, boundsAdapter));
        if (i2 == 1) {
            return f(t2, arrayList, z3);
        }
        if (i2 == 2) {
            return e(t2, arrayList, z3);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T e(T t2, ArrayList<T> arrayList, boolean z2) {
        int i2;
        int size = arrayList.size();
        if (t2 == null) {
            i2 = -1;
        } else {
            i2 = arrayList.lastIndexOf(t2);
        }
        int i3 = i2 + 1;
        if (i3 < size) {
            return arrayList.get(i3);
        }
        if (!z2 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T f(T t2, ArrayList<T> arrayList, boolean z2) {
        int i2;
        int size = arrayList.size();
        if (t2 == null) {
            i2 = size;
        } else {
            i2 = arrayList.indexOf(t2);
        }
        int i3 = i2 - 1;
        if (i3 >= 0) {
            return arrayList.get(i3);
        }
        if (!z2 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int g(int i2, int i3) {
        return (i2 * 13 * i2) + (i3 * i3);
    }

    private static boolean h(int i2, Rect rect, Rect rect2, Rect rect3) {
        if (!i(rect, rect2, i2)) {
            return false;
        }
        if (!i(rect, rect3, i2) || a(i2, rect, rect2, rect3)) {
            return true;
        }
        if (!a(i2, rect, rect3, rect2) && g(k(i2, rect, rect2), o(i2, rect, rect2)) < g(k(i2, rect, rect3), o(i2, rect, rect3))) {
            return true;
        }
        return false;
    }

    private static boolean i(Rect rect, Rect rect2, int i2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            if ((i3 > i4 || rect.left >= i4) && rect.left > rect2.left) {
                return true;
            }
            return false;
        } else if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if ((i5 > i6 || rect.top >= i6) && rect.top > rect2.top) {
                return true;
            }
            return false;
        } else if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            if ((i7 < i8 || rect.right <= i8) && rect.right < rect2.right) {
                return true;
            }
            return false;
        } else if (i2 == 130) {
            int i9 = rect.top;
            int i10 = rect2.top;
            if ((i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom) {
                return true;
            }
            return false;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean j(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    } else if (rect.bottom <= rect2.top) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (rect.right <= rect2.left) {
                    return true;
                } else {
                    return false;
                }
            } else if (rect.top >= rect2.bottom) {
                return true;
            } else {
                return false;
            }
        } else if (rect.left >= rect2.right) {
            return true;
        } else {
            return false;
        }
    }

    private static int k(int i2, Rect rect, Rect rect2) {
        return Math.max(0, l(i2, rect, rect2));
    }

    private static int l(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else if (i2 == 130) {
            i3 = rect2.top;
            i4 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i3 - i4;
    }

    private static int m(int i2, Rect rect, Rect rect2) {
        return Math.max(1, n(i2, rect, rect2));
    }

    private static int n(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.left;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.top;
        } else if (i2 == 66) {
            i3 = rect2.right;
            i4 = rect.right;
        } else if (i2 == 130) {
            i3 = rect2.bottom;
            i4 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i3 - i4;
    }

    private static int o(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}

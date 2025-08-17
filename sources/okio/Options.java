package okio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class Options extends AbstractList<ByteString> implements RandomAccess {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f41357e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: c  reason: collision with root package name */
    private final ByteString[] f41358c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f41359d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(long j2, Buffer buffer, int i2, List<? extends ByteString> list, int i3, int i4, List<Integer> list2) {
            boolean z2;
            int i5;
            int i6;
            boolean z3;
            int i7;
            int i8;
            Buffer buffer2;
            boolean z4;
            Buffer buffer3 = buffer;
            int i9 = i2;
            List<? extends ByteString> list3 = list;
            int i10 = i3;
            int i11 = i4;
            List<Integer> list4 = list2;
            if (i10 < i11) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                int i12 = i10;
                while (i12 < i11) {
                    if (((ByteString) list3.get(i12)).size() >= i9) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (z4) {
                        i12++;
                    } else {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                ByteString byteString = (ByteString) list.get(i3);
                ByteString byteString2 = (ByteString) list3.get(i11 - 1);
                if (i9 == byteString.size()) {
                    int intValue = list4.get(i10).intValue();
                    int i13 = i10 + 1;
                    i5 = i13;
                    i6 = intValue;
                    byteString = (ByteString) list3.get(i13);
                } else {
                    i5 = i10;
                    i6 = -1;
                }
                if (byteString.f(i9) != byteString2.f(i9)) {
                    int i14 = 1;
                    for (int i15 = i5 + 1; i15 < i11; i15++) {
                        if (((ByteString) list3.get(i15 - 1)).f(i9) != ((ByteString) list3.get(i15)).f(i9)) {
                            i14++;
                        }
                    }
                    long c2 = j2 + c(buffer3) + ((long) 2) + ((long) (i14 * 2));
                    buffer3.writeInt(i14);
                    buffer3.writeInt(i6);
                    for (int i16 = i5; i16 < i11; i16++) {
                        byte f2 = ((ByteString) list3.get(i16)).f(i9);
                        if (i16 == i5 || f2 != ((ByteString) list3.get(i16 - 1)).f(i9)) {
                            buffer3.writeInt(f2 & 255);
                        }
                    }
                    Buffer buffer4 = new Buffer();
                    while (i5 < i11) {
                        byte f3 = ((ByteString) list3.get(i5)).f(i9);
                        int i17 = i5 + 1;
                        int i18 = i17;
                        while (true) {
                            if (i18 >= i11) {
                                i7 = i11;
                                break;
                            } else if (f3 != ((ByteString) list3.get(i18)).f(i9)) {
                                i7 = i18;
                                break;
                            } else {
                                i18++;
                            }
                        }
                        if (i17 == i7 && i9 + 1 == ((ByteString) list3.get(i5)).size()) {
                            buffer3.writeInt(list4.get(i5).intValue());
                            i8 = i7;
                            buffer2 = buffer4;
                        } else {
                            buffer3.writeInt(((int) (c2 + c(buffer4))) * -1);
                            i8 = i7;
                            buffer2 = buffer4;
                            a(c2, buffer4, i9 + 1, list, i5, i7, list2);
                        }
                        buffer4 = buffer2;
                        i5 = i8;
                    }
                    buffer3.y(buffer4);
                    return;
                }
                int min = Math.min(byteString.size(), byteString2.size());
                int i19 = i9;
                int i20 = 0;
                while (i19 < min && byteString.f(i19) == byteString2.f(i19)) {
                    i20++;
                    i19++;
                }
                long c3 = j2 + c(buffer3) + ((long) 2) + ((long) i20) + 1;
                buffer3.writeInt(-i20);
                buffer3.writeInt(i6);
                int i21 = i9 + i20;
                while (i9 < i21) {
                    buffer3.writeInt(byteString.f(i9) & 255);
                    i9++;
                }
                if (i5 + 1 == i11) {
                    if (i21 == ((ByteString) list3.get(i5)).size()) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z3) {
                        buffer3.writeInt(list4.get(i5).intValue());
                        return;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                Buffer buffer5 = new Buffer();
                buffer3.writeInt(((int) (c(buffer5) + c3)) * -1);
                a(c3, buffer5, i21, list, i5, i4, list2);
                buffer3.y(buffer5);
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        static /* synthetic */ void b(Companion companion, long j2, Buffer buffer, int i2, List list, int i3, int i4, List list2, int i5, Object obj) {
            long j3;
            int i6;
            int i7;
            int i8;
            if ((i5 & 1) != 0) {
                j3 = 0;
            } else {
                j3 = j2;
            }
            if ((i5 & 4) != 0) {
                i6 = 0;
            } else {
                i6 = i2;
            }
            if ((i5 & 16) != 0) {
                i7 = 0;
            } else {
                i7 = i3;
            }
            if ((i5 & 32) != 0) {
                i8 = list.size();
            } else {
                i8 = i4;
            }
            companion.a(j3, buffer, i6, list, i7, i8, list2);
        }

        private final long c(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        public final Options d(ByteString... byteStringArr) {
            boolean z2;
            boolean z3;
            boolean z4;
            ByteString[] byteStringArr2 = byteStringArr;
            Intrinsics.f(byteStringArr2, "byteStrings");
            int i2 = 0;
            if (byteStringArr2.length == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return new Options(new ByteString[0], new int[]{0, -1}, (DefaultConstructorMarker) null);
            }
            List R = ArraysKt___ArraysKt.R(byteStringArr);
            CollectionsKt__MutableCollectionsJVMKt.s(R);
            ArrayList arrayList = new ArrayList(byteStringArr2.length);
            for (ByteString byteString : byteStringArr2) {
                arrayList.add(-1);
            }
            Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
            List k2 = CollectionsKt__CollectionsKt.k(Arrays.copyOf(numArr, numArr.length));
            int length = byteStringArr2.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                k2.set(CollectionsKt__CollectionsKt.e(R, byteStringArr2[i3], 0, 0, 6, (Object) null), Integer.valueOf(i4));
                i3++;
                i4++;
            }
            if (((ByteString) R.get(0)).size() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                int i5 = 0;
                while (i5 < R.size()) {
                    ByteString byteString2 = (ByteString) R.get(i5);
                    int i6 = i5 + 1;
                    int i7 = i6;
                    while (i7 < R.size()) {
                        ByteString byteString3 = (ByteString) R.get(i7);
                        if (!byteString3.v(byteString2)) {
                            continue;
                            break;
                        }
                        if (byteString3.size() != byteString2.size()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z4) {
                            throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                        } else if (((Number) k2.get(i7)).intValue() > ((Number) k2.get(i5)).intValue()) {
                            R.remove(i7);
                            k2.remove(i7);
                        } else {
                            i7++;
                        }
                    }
                    i5 = i6;
                }
                Buffer buffer = new Buffer();
                b(this, 0, buffer, 0, R, 0, 0, k2, 53, (Object) null);
                int[] iArr = new int[((int) c(buffer))];
                while (!buffer.V()) {
                    iArr[i2] = buffer.readInt();
                    i2++;
                }
                Object[] copyOf = Arrays.copyOf(byteStringArr2, byteStringArr2.length);
                Intrinsics.e(copyOf, "copyOf(this, size)");
                return new Options((ByteString[]) copyOf, iArr, (DefaultConstructorMarker) null);
            }
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.f41358c = byteStringArr;
        this.f41359d = iArr;
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    public int a() {
        return this.f41358c.length;
    }

    public /* bridge */ boolean b(ByteString byteString) {
        return super.contains(byteString);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (!(obj instanceof ByteString)) {
            return false;
        }
        return b((ByteString) obj);
    }

    /* renamed from: d */
    public ByteString get(int i2) {
        return this.f41358c[i2];
    }

    public final ByteString[] e() {
        return this.f41358c;
    }

    public final int[] g() {
        return this.f41359d;
    }

    public /* bridge */ int h(ByteString byteString) {
        return super.indexOf(byteString);
    }

    public /* bridge */ int i(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return h((ByteString) obj);
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (!(obj instanceof ByteString)) {
            return -1;
        }
        return i((ByteString) obj);
    }
}

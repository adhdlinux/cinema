package com.google.android.gms.common.internal.safeparcel;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
    private SafeParcelWriter() {
    }

    public static int beginObjectHeader(Parcel parcel) {
        return zza(parcel, 20293);
    }

    public static void finishObjectHeader(Parcel parcel, int i2) {
        zzb(parcel, i2);
    }

    public static void writeBigDecimal(Parcel parcel, int i2, BigDecimal bigDecimal, boolean z2) {
        if (bigDecimal != null) {
            int zza = zza(parcel, i2);
            parcel.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            parcel.writeInt(bigDecimal.scale());
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeBigDecimalArray(Parcel parcel, int i2, BigDecimal[] bigDecimalArr, boolean z2) {
        if (bigDecimalArr != null) {
            int zza = zza(parcel, i2);
            int length = bigDecimalArr.length;
            parcel.writeInt(length);
            for (int i3 = 0; i3 < length; i3++) {
                parcel.writeByteArray(bigDecimalArr[i3].unscaledValue().toByteArray());
                parcel.writeInt(bigDecimalArr[i3].scale());
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeBigInteger(Parcel parcel, int i2, BigInteger bigInteger, boolean z2) {
        if (bigInteger != null) {
            int zza = zza(parcel, i2);
            parcel.writeByteArray(bigInteger.toByteArray());
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeBigIntegerArray(Parcel parcel, int i2, BigInteger[] bigIntegerArr, boolean z2) {
        if (bigIntegerArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeInt(r5);
            for (BigInteger byteArray : bigIntegerArr) {
                parcel.writeByteArray(byteArray.toByteArray());
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeBoolean(Parcel parcel, int i2, boolean z2) {
        zzc(parcel, i2, 4);
        parcel.writeInt(z2 ? 1 : 0);
    }

    public static void writeBooleanArray(Parcel parcel, int i2, boolean[] zArr, boolean z2) {
        if (zArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeBooleanArray(zArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeBooleanList(Parcel parcel, int i2, List<Boolean> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).booleanValue() ? 1 : 0);
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeBooleanObject(Parcel parcel, int i2, Boolean bool, boolean z2) {
        if (bool != null) {
            zzc(parcel, i2, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeBundle(Parcel parcel, int i2, Bundle bundle, boolean z2) {
        if (bundle != null) {
            int zza = zza(parcel, i2);
            parcel.writeBundle(bundle);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeByte(Parcel parcel, int i2, byte b2) {
        zzc(parcel, i2, 4);
        parcel.writeInt(b2);
    }

    public static void writeByteArray(Parcel parcel, int i2, byte[] bArr, boolean z2) {
        if (bArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeByteArray(bArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeByteArrayArray(Parcel parcel, int i2, byte[][] bArr, boolean z2) {
        if (bArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeInt(r5);
            for (byte[] writeByteArray : bArr) {
                parcel.writeByteArray(writeByteArray);
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeByteArraySparseArray(Parcel parcel, int i2, SparseArray<byte[]> sparseArray, boolean z2) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeByteArray(sparseArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeChar(Parcel parcel, int i2, char c2) {
        zzc(parcel, i2, 4);
        parcel.writeInt(c2);
    }

    public static void writeCharArray(Parcel parcel, int i2, char[] cArr, boolean z2) {
        if (cArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeCharArray(cArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeDouble(Parcel parcel, int i2, double d2) {
        zzc(parcel, i2, 8);
        parcel.writeDouble(d2);
    }

    public static void writeDoubleArray(Parcel parcel, int i2, double[] dArr, boolean z2) {
        if (dArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeDoubleArray(dArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeDoubleList(Parcel parcel, int i2, List<Double> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeDouble(list.get(i3).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeDoubleObject(Parcel parcel, int i2, Double d2, boolean z2) {
        if (d2 != null) {
            zzc(parcel, i2, 8);
            parcel.writeDouble(d2.doubleValue());
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeDoubleSparseArray(Parcel parcel, int i2, SparseArray<Double> sparseArray, boolean z2) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeDouble(sparseArray.valueAt(i3).doubleValue());
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeFloat(Parcel parcel, int i2, float f2) {
        zzc(parcel, i2, 4);
        parcel.writeFloat(f2);
    }

    public static void writeFloatArray(Parcel parcel, int i2, float[] fArr, boolean z2) {
        if (fArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeFloatArray(fArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeFloatList(Parcel parcel, int i2, List<Float> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeFloat(list.get(i3).floatValue());
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeFloatObject(Parcel parcel, int i2, Float f2, boolean z2) {
        if (f2 != null) {
            zzc(parcel, i2, 4);
            parcel.writeFloat(f2.floatValue());
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeFloatSparseArray(Parcel parcel, int i2, SparseArray<Float> sparseArray, boolean z2) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeFloat(sparseArray.valueAt(i3).floatValue());
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeIBinder(Parcel parcel, int i2, IBinder iBinder, boolean z2) {
        if (iBinder != null) {
            int zza = zza(parcel, i2);
            parcel.writeStrongBinder(iBinder);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeIBinderArray(Parcel parcel, int i2, IBinder[] iBinderArr, boolean z2) {
        if (iBinderArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeBinderArray(iBinderArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeIBinderList(Parcel parcel, int i2, List<IBinder> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            parcel.writeBinderList(list);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeIBinderSparseArray(Parcel parcel, int i2, SparseArray<IBinder> sparseArray, boolean z2) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeStrongBinder(sparseArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeInt(Parcel parcel, int i2, int i3) {
        zzc(parcel, i2, 4);
        parcel.writeInt(i3);
    }

    public static void writeIntArray(Parcel parcel, int i2, int[] iArr, boolean z2) {
        if (iArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeIntArray(iArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeIntegerList(Parcel parcel, int i2, List<Integer> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(list.get(i3).intValue());
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeIntegerObject(Parcel parcel, int i2, Integer num, boolean z2) {
        if (num != null) {
            zzc(parcel, i2, 4);
            parcel.writeInt(num.intValue());
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeList(Parcel parcel, int i2, List list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            parcel.writeList(list);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeLong(Parcel parcel, int i2, long j2) {
        zzc(parcel, i2, 8);
        parcel.writeLong(j2);
    }

    public static void writeLongArray(Parcel parcel, int i2, long[] jArr, boolean z2) {
        if (jArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeLongArray(jArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeLongList(Parcel parcel, int i2, List<Long> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeLong(list.get(i3).longValue());
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeLongObject(Parcel parcel, int i2, Long l2, boolean z2) {
        if (l2 != null) {
            zzc(parcel, i2, 8);
            parcel.writeLong(l2.longValue());
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeParcel(Parcel parcel, int i2, Parcel parcel2, boolean z2) {
        if (parcel2 != null) {
            int zza = zza(parcel, i2);
            parcel.appendFrom(parcel2, 0, parcel2.dataSize());
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeParcelArray(Parcel parcel, int i2, Parcel[] parcelArr, boolean z2) {
        if (parcelArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeInt(r7);
            for (Parcel parcel2 : parcelArr) {
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeParcelList(Parcel parcel, int i2, List<Parcel> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcel parcel2 = list.get(i3);
                if (parcel2 != null) {
                    parcel.writeInt(parcel2.dataSize());
                    parcel.appendFrom(parcel2, 0, parcel2.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeParcelSparseArray(Parcel parcel, int i2, SparseArray<Parcel> sparseArray, boolean z2) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                Parcel valueAt = sparseArray.valueAt(i3);
                if (valueAt != null) {
                    parcel.writeInt(valueAt.dataSize());
                    parcel.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    parcel.writeInt(0);
                }
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeParcelable(Parcel parcel, int i2, Parcelable parcelable, int i3, boolean z2) {
        if (parcelable != null) {
            int zza = zza(parcel, i2);
            parcelable.writeToParcel(parcel, i3);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writePendingIntent(Parcel parcel, int i2, PendingIntent pendingIntent, boolean z2) {
        if (pendingIntent != null) {
            int zza = zza(parcel, i2);
            PendingIntent.writePendingIntentOrNullToParcel(pendingIntent, parcel);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeShort(Parcel parcel, int i2, short s2) {
        zzc(parcel, i2, 4);
        parcel.writeInt(s2);
    }

    public static void writeSparseBooleanArray(Parcel parcel, int i2, SparseBooleanArray sparseBooleanArray, boolean z2) {
        if (sparseBooleanArray != null) {
            int zza = zza(parcel, i2);
            parcel.writeSparseBooleanArray(sparseBooleanArray);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeSparseIntArray(Parcel parcel, int i2, SparseIntArray sparseIntArray, boolean z2) {
        if (sparseIntArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseIntArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseIntArray.keyAt(i3));
                parcel.writeInt(sparseIntArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeSparseLongArray(Parcel parcel, int i2, SparseLongArray sparseLongArray, boolean z2) {
        if (sparseLongArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseLongArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseLongArray.keyAt(i3));
                parcel.writeLong(sparseLongArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeString(Parcel parcel, int i2, String str, boolean z2) {
        if (str != null) {
            int zza = zza(parcel, i2);
            parcel.writeString(str);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeStringArray(Parcel parcel, int i2, String[] strArr, boolean z2) {
        if (strArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeStringArray(strArr);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeStringList(Parcel parcel, int i2, List<String> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            parcel.writeStringList(list);
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static void writeStringSparseArray(Parcel parcel, int i2, SparseArray<String> sparseArray, boolean z2) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                parcel.writeString(sparseArray.valueAt(i3));
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedArray(Parcel parcel, int i2, T[] tArr, int i3, boolean z2) {
        if (tArr != null) {
            int zza = zza(parcel, i2);
            parcel.writeInt(r7);
            for (T t2 : tArr) {
                if (t2 == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, t2, i3);
                }
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedList(Parcel parcel, int i2, List<T> list, boolean z2) {
        if (list != null) {
            int zza = zza(parcel, i2);
            int size = list.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                Parcelable parcelable = (Parcelable) list.get(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    public static <T extends Parcelable> void writeTypedSparseArray(Parcel parcel, int i2, SparseArray<T> sparseArray, boolean z2) {
        if (sparseArray != null) {
            int zza = zza(parcel, i2);
            int size = sparseArray.size();
            parcel.writeInt(size);
            for (int i3 = 0; i3 < size; i3++) {
                parcel.writeInt(sparseArray.keyAt(i3));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i3);
                if (parcelable == null) {
                    parcel.writeInt(0);
                } else {
                    zzd(parcel, parcelable, 0);
                }
            }
            zzb(parcel, zza);
        } else if (z2) {
            zzc(parcel, i2, 0);
        }
    }

    private static int zza(Parcel parcel, int i2) {
        parcel.writeInt(i2 | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void zzb(Parcel parcel, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i2 - 4);
        parcel.writeInt(dataPosition - i2);
        parcel.setDataPosition(dataPosition);
    }

    private static void zzc(Parcel parcel, int i2, int i3) {
        parcel.writeInt(i2 | (i3 << 16));
    }

    private static void zzd(Parcel parcel, Parcelable parcelable, int i2) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i2);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
}

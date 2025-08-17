package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() {
        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        /* renamed from: b */
        public SpliceInsertCommand[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final long f25466b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f25467c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f25468d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f25469e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f25470f;

    /* renamed from: g  reason: collision with root package name */
    public final long f25471g;

    /* renamed from: h  reason: collision with root package name */
    public final long f25472h;

    /* renamed from: i  reason: collision with root package name */
    public final List<ComponentSplice> f25473i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f25474j;

    /* renamed from: k  reason: collision with root package name */
    public final long f25475k;

    /* renamed from: l  reason: collision with root package name */
    public final int f25476l;

    /* renamed from: m  reason: collision with root package name */
    public final int f25477m;

    /* renamed from: n  reason: collision with root package name */
    public final int f25478n;

    public static final class ComponentSplice {

        /* renamed from: a  reason: collision with root package name */
        public final int f25479a;

        /* renamed from: b  reason: collision with root package name */
        public final long f25480b;

        /* renamed from: c  reason: collision with root package name */
        public final long f25481c;

        public static ComponentSplice a(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f25479a);
            parcel.writeLong(this.f25480b);
            parcel.writeLong(this.f25481c);
        }

        private ComponentSplice(int i2, long j2, long j3) {
            this.f25479a = i2;
            this.f25480b = j2;
            this.f25481c = j3;
        }
    }

    static SpliceInsertCommand b(ParsableByteArray parsableByteArray, long j2, TimestampAdjuster timestampAdjuster) {
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        int i4;
        long j3;
        boolean z4;
        List list;
        long j4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        long j5;
        long j6;
        boolean z11;
        boolean z12;
        long j7;
        TimestampAdjuster timestampAdjuster2 = timestampAdjuster;
        long J = parsableByteArray.J();
        if ((parsableByteArray.H() & 128) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        List emptyList = Collections.emptyList();
        if (!z2) {
            int H = parsableByteArray.H();
            if ((H & 128) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if ((H & 64) != 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if ((H & 32) != 0) {
                z9 = true;
            } else {
                z9 = false;
            }
            if ((H & 16) != 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z8 || z10) {
                j5 = -9223372036854775807L;
            } else {
                j5 = TimeSignalCommand.c(parsableByteArray, j2);
            }
            if (!z8) {
                int H2 = parsableByteArray.H();
                ArrayList arrayList = new ArrayList(H2);
                for (int i5 = 0; i5 < H2; i5++) {
                    int H3 = parsableByteArray.H();
                    if (!z10) {
                        j7 = TimeSignalCommand.c(parsableByteArray, j2);
                    } else {
                        j7 = -9223372036854775807L;
                    }
                    arrayList.add(new ComponentSplice(H3, j7, timestampAdjuster2.b(j7)));
                }
                emptyList = arrayList;
            }
            if (z9) {
                long H4 = (long) parsableByteArray.H();
                if ((128 & H4) != 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                j6 = ((((H4 & 1) << 32) | parsableByteArray.J()) * 1000) / 90;
                z11 = z12;
            } else {
                z11 = false;
                j6 = -9223372036854775807L;
            }
            int N = parsableByteArray.N();
            i4 = N;
            z3 = z8;
            i3 = parsableByteArray.H();
            i2 = parsableByteArray.H();
            list = emptyList;
            long j8 = j5;
            z4 = z11;
            j3 = j6;
            z5 = z10;
            z6 = z7;
            j4 = j8;
        } else {
            list = emptyList;
            z6 = false;
            z5 = false;
            j4 = -9223372036854775807L;
            z4 = false;
            j3 = -9223372036854775807L;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            z3 = false;
        }
        return new SpliceInsertCommand(J, z2, z6, z3, z5, j4, timestampAdjuster2.b(j4), list, z4, j3, i4, i3, i2);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f25466b);
        parcel.writeByte(this.f25467c ? (byte) 1 : 0);
        parcel.writeByte(this.f25468d ? (byte) 1 : 0);
        parcel.writeByte(this.f25469e ? (byte) 1 : 0);
        parcel.writeByte(this.f25470f ? (byte) 1 : 0);
        parcel.writeLong(this.f25471g);
        parcel.writeLong(this.f25472h);
        int size = this.f25473i.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f25473i.get(i3).b(parcel);
        }
        parcel.writeByte(this.f25474j ? (byte) 1 : 0);
        parcel.writeLong(this.f25475k);
        parcel.writeInt(this.f25476l);
        parcel.writeInt(this.f25477m);
        parcel.writeInt(this.f25478n);
    }

    private SpliceInsertCommand(long j2, boolean z2, boolean z3, boolean z4, boolean z5, long j3, long j4, List<ComponentSplice> list, boolean z6, long j5, int i2, int i3, int i4) {
        this.f25466b = j2;
        this.f25467c = z2;
        this.f25468d = z3;
        this.f25469e = z4;
        this.f25470f = z5;
        this.f25471g = j3;
        this.f25472h = j4;
        this.f25473i = Collections.unmodifiableList(list);
        this.f25474j = z6;
        this.f25475k = j5;
        this.f25476l = i2;
        this.f25477m = i3;
        this.f25478n = i4;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f25466b = parcel.readLong();
        boolean z2 = false;
        this.f25467c = parcel.readByte() == 1;
        this.f25468d = parcel.readByte() == 1;
        this.f25469e = parcel.readByte() == 1;
        this.f25470f = parcel.readByte() == 1;
        this.f25471g = parcel.readLong();
        this.f25472h = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(ComponentSplice.a(parcel));
        }
        this.f25473i = Collections.unmodifiableList(arrayList);
        this.f25474j = parcel.readByte() == 1 ? true : z2;
        this.f25475k = parcel.readLong();
        this.f25476l = parcel.readInt();
        this.f25477m = parcel.readInt();
        this.f25478n = parcel.readInt();
    }
}

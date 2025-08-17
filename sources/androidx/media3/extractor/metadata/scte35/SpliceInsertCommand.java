package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
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
    public final long f8363b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f8364c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f8365d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f8366e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8367f;

    /* renamed from: g  reason: collision with root package name */
    public final long f8368g;

    /* renamed from: h  reason: collision with root package name */
    public final long f8369h;

    /* renamed from: i  reason: collision with root package name */
    public final List<ComponentSplice> f8370i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f8371j;

    /* renamed from: k  reason: collision with root package name */
    public final long f8372k;

    /* renamed from: l  reason: collision with root package name */
    public final int f8373l;

    /* renamed from: m  reason: collision with root package name */
    public final int f8374m;

    /* renamed from: n  reason: collision with root package name */
    public final int f8375n;

    public static final class ComponentSplice {

        /* renamed from: a  reason: collision with root package name */
        public final int f8376a;

        /* renamed from: b  reason: collision with root package name */
        public final long f8377b;

        /* renamed from: c  reason: collision with root package name */
        public final long f8378c;

        public static ComponentSplice a(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void b(Parcel parcel) {
            parcel.writeInt(this.f8376a);
            parcel.writeLong(this.f8377b);
            parcel.writeLong(this.f8378c);
        }

        private ComponentSplice(int i2, long j2, long j3) {
            this.f8376a = i2;
            this.f8377b = j2;
            this.f8378c = j3;
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

    public String toString() {
        return "SCTE-35 SpliceInsertCommand { programSplicePts=" + this.f8368g + ", programSplicePlaybackPositionUs= " + this.f8369h + " }";
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f8363b);
        parcel.writeByte(this.f8364c ? (byte) 1 : 0);
        parcel.writeByte(this.f8365d ? (byte) 1 : 0);
        parcel.writeByte(this.f8366e ? (byte) 1 : 0);
        parcel.writeByte(this.f8367f ? (byte) 1 : 0);
        parcel.writeLong(this.f8368g);
        parcel.writeLong(this.f8369h);
        int size = this.f8370i.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f8370i.get(i3).b(parcel);
        }
        parcel.writeByte(this.f8371j ? (byte) 1 : 0);
        parcel.writeLong(this.f8372k);
        parcel.writeInt(this.f8373l);
        parcel.writeInt(this.f8374m);
        parcel.writeInt(this.f8375n);
    }

    private SpliceInsertCommand(long j2, boolean z2, boolean z3, boolean z4, boolean z5, long j3, long j4, List<ComponentSplice> list, boolean z6, long j5, int i2, int i3, int i4) {
        this.f8363b = j2;
        this.f8364c = z2;
        this.f8365d = z3;
        this.f8366e = z4;
        this.f8367f = z5;
        this.f8368g = j3;
        this.f8369h = j4;
        this.f8370i = Collections.unmodifiableList(list);
        this.f8371j = z6;
        this.f8372k = j5;
        this.f8373l = i2;
        this.f8374m = i3;
        this.f8375n = i4;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f8363b = parcel.readLong();
        boolean z2 = false;
        this.f8364c = parcel.readByte() == 1;
        this.f8365d = parcel.readByte() == 1;
        this.f8366e = parcel.readByte() == 1;
        this.f8367f = parcel.readByte() == 1;
        this.f8368g = parcel.readLong();
        this.f8369h = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(ComponentSplice.a(parcel));
        }
        this.f8370i = Collections.unmodifiableList(arrayList);
        this.f8371j = parcel.readByte() == 1 ? true : z2;
        this.f8372k = parcel.readLong();
        this.f8373l = parcel.readInt();
        this.f8374m = parcel.readInt();
        this.f8375n = parcel.readInt();
    }
}

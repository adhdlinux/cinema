package androidx.media3.extractor.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() {
        /* renamed from: a */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        /* renamed from: b */
        public SpliceScheduleCommand[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final List<Event> f8379b;

    public static final class ComponentSplice {

        /* renamed from: a  reason: collision with root package name */
        public final int f8380a;

        /* renamed from: b  reason: collision with root package name */
        public final long f8381b;

        /* access modifiers changed from: private */
        public static ComponentSplice c(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.f8380a);
            parcel.writeLong(this.f8381b);
        }

        private ComponentSplice(int i2, long j2) {
            this.f8380a = i2;
            this.f8381b = j2;
        }
    }

    static SpliceScheduleCommand b(ParsableByteArray parsableByteArray) {
        int H = parsableByteArray.H();
        ArrayList arrayList = new ArrayList(H);
        for (int i2 = 0; i2 < H; i2++) {
            arrayList.add(Event.e(parsableByteArray));
        }
        return new SpliceScheduleCommand((List<Event>) arrayList);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int size = this.f8379b.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f8379b.get(i3).f(parcel);
        }
    }

    private SpliceScheduleCommand(List<Event> list) {
        this.f8379b = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Event.d(parcel));
        }
        this.f8379b = Collections.unmodifiableList(arrayList);
    }

    public static final class Event {

        /* renamed from: a  reason: collision with root package name */
        public final long f8382a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f8383b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f8384c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f8385d;

        /* renamed from: e  reason: collision with root package name */
        public final long f8386e;

        /* renamed from: f  reason: collision with root package name */
        public final List<ComponentSplice> f8387f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f8388g;

        /* renamed from: h  reason: collision with root package name */
        public final long f8389h;

        /* renamed from: i  reason: collision with root package name */
        public final int f8390i;

        /* renamed from: j  reason: collision with root package name */
        public final int f8391j;

        /* renamed from: k  reason: collision with root package name */
        public final int f8392k;

        private Event(long j2, boolean z2, boolean z3, boolean z4, List<ComponentSplice> list, long j3, boolean z5, long j4, int i2, int i3, int i4) {
            this.f8382a = j2;
            this.f8383b = z2;
            this.f8384c = z3;
            this.f8385d = z4;
            this.f8387f = Collections.unmodifiableList(list);
            this.f8386e = j3;
            this.f8388g = z5;
            this.f8389h = j4;
            this.f8390i = i2;
            this.f8391j = i3;
            this.f8392k = i4;
        }

        /* access modifiers changed from: private */
        public static Event d(Parcel parcel) {
            return new Event(parcel);
        }

        /* access modifiers changed from: private */
        public static Event e(ParsableByteArray parsableByteArray) {
            boolean z2;
            boolean z3;
            int i2;
            int i3;
            int i4;
            long j2;
            boolean z4;
            long j3;
            ArrayList arrayList;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            long j4;
            long j5;
            boolean z9;
            boolean z10;
            long J = parsableByteArray.J();
            if ((parsableByteArray.H() & 128) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            ArrayList arrayList2 = new ArrayList();
            if (!z2) {
                int H = parsableByteArray.H();
                if ((H & 128) != 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                if ((H & 64) != 0) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if ((H & 32) != 0) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z7) {
                    j4 = parsableByteArray.J();
                } else {
                    j4 = -9223372036854775807L;
                }
                if (!z7) {
                    int H2 = parsableByteArray.H();
                    ArrayList arrayList3 = new ArrayList(H2);
                    for (int i5 = 0; i5 < H2; i5++) {
                        arrayList3.add(new ComponentSplice(parsableByteArray.H(), parsableByteArray.J()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long H3 = (long) parsableByteArray.H();
                    if ((128 & H3) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    j5 = ((((H3 & 1) << 32) | parsableByteArray.J()) * 1000) / 90;
                    z9 = z10;
                } else {
                    z9 = false;
                    j5 = -9223372036854775807L;
                }
                int N = parsableByteArray.N();
                int H4 = parsableByteArray.H();
                z3 = z7;
                i2 = parsableByteArray.H();
                j2 = j5;
                arrayList = arrayList2;
                long j6 = j4;
                i4 = N;
                i3 = H4;
                j3 = j6;
                boolean z11 = z6;
                z4 = z9;
                z5 = z11;
            } else {
                arrayList = arrayList2;
                z5 = false;
                j3 = -9223372036854775807L;
                z4 = false;
                j2 = -9223372036854775807L;
                i4 = 0;
                i3 = 0;
                i2 = 0;
                z3 = false;
            }
            return new Event(J, z2, z5, z3, arrayList, j3, z4, j2, i4, i3, i2);
        }

        /* access modifiers changed from: private */
        public void f(Parcel parcel) {
            parcel.writeLong(this.f8382a);
            parcel.writeByte(this.f8383b ? (byte) 1 : 0);
            parcel.writeByte(this.f8384c ? (byte) 1 : 0);
            parcel.writeByte(this.f8385d ? (byte) 1 : 0);
            int size = this.f8387f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f8387f.get(i2).d(parcel);
            }
            parcel.writeLong(this.f8386e);
            parcel.writeByte(this.f8388g ? (byte) 1 : 0);
            parcel.writeLong(this.f8389h);
            parcel.writeInt(this.f8390i);
            parcel.writeInt(this.f8391j);
            parcel.writeInt(this.f8392k);
        }

        private Event(Parcel parcel) {
            this.f8382a = parcel.readLong();
            boolean z2 = false;
            this.f8383b = parcel.readByte() == 1;
            this.f8384c = parcel.readByte() == 1;
            this.f8385d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(ComponentSplice.c(parcel));
            }
            this.f8387f = Collections.unmodifiableList(arrayList);
            this.f8386e = parcel.readLong();
            this.f8388g = parcel.readByte() == 1 ? true : z2;
            this.f8389h = parcel.readLong();
            this.f8390i = parcel.readInt();
            this.f8391j = parcel.readInt();
            this.f8392k = parcel.readInt();
        }
    }
}

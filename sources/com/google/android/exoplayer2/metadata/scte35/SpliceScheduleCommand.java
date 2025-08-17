package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
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
    public final List<Event> f25482b;

    public static final class ComponentSplice {

        /* renamed from: a  reason: collision with root package name */
        public final int f25483a;

        /* renamed from: b  reason: collision with root package name */
        public final long f25484b;

        /* access modifiers changed from: private */
        public static ComponentSplice c(Parcel parcel) {
            return new ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        /* access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.f25483a);
            parcel.writeLong(this.f25484b);
        }

        private ComponentSplice(int i2, long j2) {
            this.f25483a = i2;
            this.f25484b = j2;
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
        int size = this.f25482b.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f25482b.get(i3).f(parcel);
        }
    }

    private SpliceScheduleCommand(List<Event> list) {
        this.f25482b = Collections.unmodifiableList(list);
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(Event.d(parcel));
        }
        this.f25482b = Collections.unmodifiableList(arrayList);
    }

    public static final class Event {

        /* renamed from: a  reason: collision with root package name */
        public final long f25485a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f25486b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f25487c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f25488d;

        /* renamed from: e  reason: collision with root package name */
        public final long f25489e;

        /* renamed from: f  reason: collision with root package name */
        public final List<ComponentSplice> f25490f;

        /* renamed from: g  reason: collision with root package name */
        public final boolean f25491g;

        /* renamed from: h  reason: collision with root package name */
        public final long f25492h;

        /* renamed from: i  reason: collision with root package name */
        public final int f25493i;

        /* renamed from: j  reason: collision with root package name */
        public final int f25494j;

        /* renamed from: k  reason: collision with root package name */
        public final int f25495k;

        private Event(long j2, boolean z2, boolean z3, boolean z4, List<ComponentSplice> list, long j3, boolean z5, long j4, int i2, int i3, int i4) {
            this.f25485a = j2;
            this.f25486b = z2;
            this.f25487c = z3;
            this.f25488d = z4;
            this.f25490f = Collections.unmodifiableList(list);
            this.f25489e = j3;
            this.f25491g = z5;
            this.f25492h = j4;
            this.f25493i = i2;
            this.f25494j = i3;
            this.f25495k = i4;
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
            parcel.writeLong(this.f25485a);
            parcel.writeByte(this.f25486b ? (byte) 1 : 0);
            parcel.writeByte(this.f25487c ? (byte) 1 : 0);
            parcel.writeByte(this.f25488d ? (byte) 1 : 0);
            int size = this.f25490f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f25490f.get(i2).d(parcel);
            }
            parcel.writeLong(this.f25489e);
            parcel.writeByte(this.f25491g ? (byte) 1 : 0);
            parcel.writeLong(this.f25492h);
            parcel.writeInt(this.f25493i);
            parcel.writeInt(this.f25494j);
            parcel.writeInt(this.f25495k);
        }

        private Event(Parcel parcel) {
            this.f25485a = parcel.readLong();
            boolean z2 = false;
            this.f25486b = parcel.readByte() == 1;
            this.f25487c = parcel.readByte() == 1;
            this.f25488d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(ComponentSplice.c(parcel));
            }
            this.f25490f = Collections.unmodifiableList(arrayList);
            this.f25489e = parcel.readLong();
            this.f25491g = parcel.readByte() == 1 ? true : z2;
            this.f25492h = parcel.readLong();
            this.f25493i = parcel.readInt();
            this.f25494j = parcel.readInt();
            this.f25495k = parcel.readInt();
        }
    }
}

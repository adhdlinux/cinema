package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() {
        /* renamed from: a */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        /* renamed from: b */
        public TimeSignalCommand[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final long f25496b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25497c;

    static TimeSignalCommand b(ParsableByteArray parsableByteArray, long j2, TimestampAdjuster timestampAdjuster) {
        long c2 = c(parsableByteArray, j2);
        return new TimeSignalCommand(c2, timestampAdjuster.b(c2));
    }

    static long c(ParsableByteArray parsableByteArray, long j2) {
        long H = (long) parsableByteArray.H();
        if ((128 & H) != 0) {
            return 8589934591L & ((((H & 1) << 32) | parsableByteArray.J()) + j2);
        }
        return -9223372036854775807L;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f25496b);
        parcel.writeLong(this.f25497c);
    }

    private TimeSignalCommand(long j2, long j3) {
        this.f25496b = j2;
        this.f25497c = j3;
    }
}

package org.threeten.bp.zone;

import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.cast.MediaError;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;
import org.threeten.bp.ZoneOffset;

final class Ser implements Externalizable {
    static final byte SZR = 1;
    static final byte ZOT = 2;
    static final byte ZOTRULE = 3;
    private static final long serialVersionUID = -8885321777449118786L;
    private Object object;
    private byte type;

    public Ser() {
    }

    static Object read(DataInput dataInput) throws IOException, ClassNotFoundException {
        return readInternal(dataInput.readByte(), dataInput);
    }

    static long readEpochSec(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte() & 255;
        if (readByte == 255) {
            return dataInput.readLong();
        }
        return (((long) (((readByte << 16) + ((dataInput.readByte() & 255) << 8)) + (dataInput.readByte() & 255))) * 900) - 4575744000L;
    }

    private static Object readInternal(byte b2, DataInput dataInput) throws IOException, ClassNotFoundException {
        if (b2 == 1) {
            return StandardZoneRules.readExternal(dataInput);
        }
        if (b2 == 2) {
            return ZoneOffsetTransition.readExternal(dataInput);
        }
        if (b2 == 3) {
            return ZoneOffsetTransitionRule.readExternal(dataInput);
        }
        throw new StreamCorruptedException("Unknown serialized type");
    }

    static ZoneOffset readOffset(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        if (readByte == Byte.MAX_VALUE) {
            return ZoneOffset.ofTotalSeconds(dataInput.readInt());
        }
        return ZoneOffset.ofTotalSeconds(readByte * 900);
    }

    private Object readResolve() {
        return this.object;
    }

    static void write(Object obj, DataOutput dataOutput) throws IOException {
        writeInternal(SZR, obj, dataOutput);
    }

    static void writeEpochSec(long j2, DataOutput dataOutput) throws IOException {
        if (j2 < -4575744000L || j2 >= 10413792000L || j2 % 900 != 0) {
            dataOutput.writeByte(JfifUtil.MARKER_FIRST_BYTE);
            dataOutput.writeLong(j2);
            return;
        }
        int i2 = (int) ((j2 + 4575744000L) / 900);
        dataOutput.writeByte((i2 >>> 16) & JfifUtil.MARKER_FIRST_BYTE);
        dataOutput.writeByte((i2 >>> 8) & JfifUtil.MARKER_FIRST_BYTE);
        dataOutput.writeByte(i2 & JfifUtil.MARKER_FIRST_BYTE);
    }

    private static void writeInternal(byte b2, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b2);
        if (b2 == 1) {
            ((StandardZoneRules) obj).writeExternal(dataOutput);
        } else if (b2 == 2) {
            ((ZoneOffsetTransition) obj).writeExternal(dataOutput);
        } else if (b2 == 3) {
            ((ZoneOffsetTransitionRule) obj).writeExternal(dataOutput);
        } else {
            throw new InvalidClassException("Unknown serialized type");
        }
    }

    static void writeOffset(ZoneOffset zoneOffset, DataOutput dataOutput) throws IOException {
        int i2;
        int totalSeconds = zoneOffset.getTotalSeconds();
        if (totalSeconds % MediaError.DetailedErrorCode.APP == 0) {
            i2 = totalSeconds / MediaError.DetailedErrorCode.APP;
        } else {
            i2 = 127;
        }
        dataOutput.writeByte(i2);
        if (i2 == 127) {
            dataOutput.writeInt(totalSeconds);
        }
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        byte readByte = objectInput.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, objectInput);
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        writeInternal(this.type, this.object, objectOutput);
    }

    Ser(byte b2, Object obj) {
        this.type = b2;
        this.object = obj;
    }
}

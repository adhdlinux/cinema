package androidx.media3.extractor.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class EventMessageEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f8276a;

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f8277b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f8276a = byteArrayOutputStream;
        this.f8277b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f8276a.reset();
        try {
            b(this.f8277b, eventMessage.f8270b);
            String str = eventMessage.f8271c;
            if (str == null) {
                str = "";
            }
            b(this.f8277b, str);
            this.f8277b.writeLong(eventMessage.f8272d);
            this.f8277b.writeLong(eventMessage.f8273e);
            this.f8277b.write(eventMessage.f8274f);
            this.f8277b.flush();
            return this.f8276a.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}

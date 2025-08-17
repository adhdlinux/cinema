package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class EventMessageEncoder {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f25376a;

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f25377b;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f25376a = byteArrayOutputStream;
        this.f25377b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f25376a.reset();
        try {
            b(this.f25377b, eventMessage.f25370b);
            String str = eventMessage.f25371c;
            if (str == null) {
                str = "";
            }
            b(this.f25377b, str);
            this.f25377b.writeLong(eventMessage.f25372d);
            this.f25377b.writeLong(eventMessage.f25373e);
            this.f25377b.write(eventMessage.f25374f);
            this.f25377b.flush();
            return this.f25376a.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}

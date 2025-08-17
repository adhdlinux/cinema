package com.google.protobuf;

final class RawMessageInfo implements MessageInfo {
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    RawMessageInfo(MessageLite messageLite, String str, Object[] objArr) {
        this.defaultInstance = messageLite;
        this.info = str;
        this.objects = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.flags = charAt;
            return;
        }
        char c2 = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 >= 55296) {
                c2 |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            } else {
                this.flags = c2 | (charAt2 << i2);
                return;
            }
        }
    }

    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    /* access modifiers changed from: package-private */
    public Object[] getObjects() {
        return this.objects;
    }

    /* access modifiers changed from: package-private */
    public String getStringInfo() {
        return this.info;
    }

    public ProtoSyntax getSyntax() {
        return (this.flags & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    public boolean isMessageSetWireFormat() {
        return (this.flags & 2) == 2;
    }
}

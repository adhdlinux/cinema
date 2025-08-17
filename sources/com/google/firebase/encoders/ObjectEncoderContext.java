package com.google.firebase.encoders;

import java.io.IOException;

public interface ObjectEncoderContext {
    ObjectEncoderContext a(FieldDescriptor fieldDescriptor, long j2) throws IOException;

    ObjectEncoderContext c(FieldDescriptor fieldDescriptor, Object obj) throws IOException;
}

package com.google.firebase.encoders;

import java.io.IOException;

public interface ValueEncoderContext {
    ValueEncoderContext b(String str) throws IOException;

    ValueEncoderContext d(boolean z2) throws IOException;
}

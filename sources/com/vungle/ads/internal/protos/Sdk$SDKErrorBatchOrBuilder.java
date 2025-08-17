package com.vungle.ads.internal.protos;

import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface Sdk$SDKErrorBatchOrBuilder extends MessageLiteOrBuilder {
    /* synthetic */ MessageLite getDefaultInstanceForType();

    Sdk$SDKError getErrors(int i2);

    int getErrorsCount();

    List<Sdk$SDKError> getErrorsList();

    /* synthetic */ boolean isInitialized();
}

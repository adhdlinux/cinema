package com.vungle.ads.internal.protos;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public interface Sdk$SDKErrorOrBuilder extends MessageLiteOrBuilder {
    String getAdSource();

    ByteString getAdSourceBytes();

    long getAt();

    String getConnectionType();

    ByteString getConnectionTypeBytes();

    String getConnectionTypeDetail();

    String getConnectionTypeDetailAndroid();

    ByteString getConnectionTypeDetailAndroidBytes();

    ByteString getConnectionTypeDetailBytes();

    String getCreativeId();

    ByteString getCreativeIdBytes();

    /* synthetic */ MessageLite getDefaultInstanceForType();

    String getEventId();

    ByteString getEventIdBytes();

    long getIsHbPlacement();

    boolean getIsLowDataModeEnabled();

    String getMake();

    ByteString getMakeBytes();

    String getMessage();

    ByteString getMessageBytes();

    String getModel();

    ByteString getModelBytes();

    String getOs();

    ByteString getOsBytes();

    String getOsVersion();

    ByteString getOsVersionBytes();

    String getPlacementReferenceId();

    ByteString getPlacementReferenceIdBytes();

    String getPlacementType();

    ByteString getPlacementTypeBytes();

    Sdk$SDKError.Reason getReason();

    int getReasonValue();

    String getSessionId();

    ByteString getSessionIdBytes();

    /* synthetic */ boolean isInitialized();
}

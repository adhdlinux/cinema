package com.vungle.ads.internal.protos;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;

public interface Sdk$SDKMetricOrBuilder extends MessageLiteOrBuilder {
    String getAdSource();

    ByteString getAdSourceBytes();

    String getConnectionType();

    ByteString getConnectionTypeBytes();

    String getConnectionTypeDetail();

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

    String getMeta();

    ByteString getMetaBytes();

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

    String getSessionId();

    ByteString getSessionIdBytes();

    Sdk$SDKMetric.SDKMetricType getType();

    int getTypeValue();

    long getValue();

    /* synthetic */ boolean isInitialized();
}

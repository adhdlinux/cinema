package com.vungle.ads.internal.protos;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Sdk$MetricBatch extends GeneratedMessageLite<Sdk$MetricBatch, Builder> implements Sdk$MetricBatchOrBuilder {
    /* access modifiers changed from: private */
    public static final Sdk$MetricBatch DEFAULT_INSTANCE;
    public static final int METRICS_FIELD_NUMBER = 1;
    private static volatile Parser<Sdk$MetricBatch> PARSER;
    private Internal.ProtobufList<Sdk$SDKMetric> metrics_ = GeneratedMessageLite.emptyProtobufList();

    public static final class Builder extends GeneratedMessageLite.Builder<Sdk$MetricBatch, Builder> implements Sdk$MetricBatchOrBuilder {
        /* synthetic */ Builder(Sdk$1 sdk$1) {
            this();
        }

        public Builder addAllMetrics(Iterable<? extends Sdk$SDKMetric> iterable) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addAllMetrics(iterable);
            return this;
        }

        public Builder addMetrics(Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addMetrics(sdk$SDKMetric);
            return this;
        }

        public Builder clearMetrics() {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).clearMetrics();
            return this;
        }

        public Sdk$SDKMetric getMetrics(int i2) {
            return ((Sdk$MetricBatch) this.instance).getMetrics(i2);
        }

        public int getMetricsCount() {
            return ((Sdk$MetricBatch) this.instance).getMetricsCount();
        }

        public List<Sdk$SDKMetric> getMetricsList() {
            return Collections.unmodifiableList(((Sdk$MetricBatch) this.instance).getMetricsList());
        }

        public Builder removeMetrics(int i2) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).removeMetrics(i2);
            return this;
        }

        public Builder setMetrics(int i2, Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).setMetrics(i2, sdk$SDKMetric);
            return this;
        }

        private Builder() {
            super(Sdk$MetricBatch.DEFAULT_INSTANCE);
        }

        public Builder addMetrics(int i2, Sdk$SDKMetric sdk$SDKMetric) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addMetrics(i2, sdk$SDKMetric);
            return this;
        }

        public Builder setMetrics(int i2, Sdk$SDKMetric.Builder builder) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).setMetrics(i2, (Sdk$SDKMetric) builder.build());
            return this;
        }

        public Builder addMetrics(Sdk$SDKMetric.Builder builder) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addMetrics((Sdk$SDKMetric) builder.build());
            return this;
        }

        public Builder addMetrics(int i2, Sdk$SDKMetric.Builder builder) {
            copyOnWrite();
            ((Sdk$MetricBatch) this.instance).addMetrics(i2, (Sdk$SDKMetric) builder.build());
            return this;
        }
    }

    static {
        Sdk$MetricBatch sdk$MetricBatch = new Sdk$MetricBatch();
        DEFAULT_INSTANCE = sdk$MetricBatch;
        GeneratedMessageLite.registerDefaultInstance(Sdk$MetricBatch.class, sdk$MetricBatch);
    }

    private Sdk$MetricBatch() {
    }

    /* access modifiers changed from: private */
    public void addAllMetrics(Iterable<? extends Sdk$SDKMetric> iterable) {
        ensureMetricsIsMutable();
        AbstractMessageLite.addAll(iterable, this.metrics_);
    }

    /* access modifiers changed from: private */
    public void addMetrics(Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.add(sdk$SDKMetric);
    }

    /* access modifiers changed from: private */
    public void clearMetrics() {
        this.metrics_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureMetricsIsMutable() {
        Internal.ProtobufList<Sdk$SDKMetric> protobufList = this.metrics_;
        if (!protobufList.isModifiable()) {
            this.metrics_ = GeneratedMessageLite.mutableCopy(protobufList);
        }
    }

    public static Sdk$MetricBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sdk$MetricBatch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$MetricBatch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Sdk$MetricBatch> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeMetrics(int i2) {
        ensureMetricsIsMutable();
        this.metrics_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void setMetrics(int i2, Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.set(i2, sdk$SDKMetric);
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Sdk$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$MetricBatch();
            case 2:
                return new Builder((Sdk$1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"metrics_", Sdk$SDKMetric.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Sdk$MetricBatch> parser = PARSER;
                if (parser == null) {
                    synchronized (Sdk$MetricBatch.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Sdk$SDKMetric getMetrics(int i2) {
        return this.metrics_.get(i2);
    }

    public int getMetricsCount() {
        return this.metrics_.size();
    }

    public List<Sdk$SDKMetric> getMetricsList() {
        return this.metrics_;
    }

    public Sdk$SDKMetricOrBuilder getMetricsOrBuilder(int i2) {
        return this.metrics_.get(i2);
    }

    public List<? extends Sdk$SDKMetricOrBuilder> getMetricsOrBuilderList() {
        return this.metrics_;
    }

    public static Builder newBuilder(Sdk$MetricBatch sdk$MetricBatch) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(sdk$MetricBatch);
    }

    public static Sdk$MetricBatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addMetrics(int i2, Sdk$SDKMetric sdk$SDKMetric) {
        sdk$SDKMetric.getClass();
        ensureMetricsIsMutable();
        this.metrics_.add(i2, sdk$SDKMetric);
    }

    public static Sdk$MetricBatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$MetricBatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$MetricBatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$MetricBatch parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Sdk$MetricBatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$MetricBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}

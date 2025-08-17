package com.vungle.ads.internal.protos;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class Sdk$SDKErrorBatch extends GeneratedMessageLite<Sdk$SDKErrorBatch, Builder> implements Sdk$SDKErrorBatchOrBuilder {
    /* access modifiers changed from: private */
    public static final Sdk$SDKErrorBatch DEFAULT_INSTANCE;
    public static final int ERRORS_FIELD_NUMBER = 1;
    private static volatile Parser<Sdk$SDKErrorBatch> PARSER;
    private Internal.ProtobufList<Sdk$SDKError> errors_ = GeneratedMessageLite.emptyProtobufList();

    public static final class Builder extends GeneratedMessageLite.Builder<Sdk$SDKErrorBatch, Builder> implements Sdk$SDKErrorBatchOrBuilder {
        /* synthetic */ Builder(Sdk$1 sdk$1) {
            this();
        }

        public Builder addAllErrors(Iterable<? extends Sdk$SDKError> iterable) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).addAllErrors(iterable);
            return this;
        }

        public Builder addErrors(Sdk$SDKError sdk$SDKError) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).addErrors(sdk$SDKError);
            return this;
        }

        public Builder clearErrors() {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).clearErrors();
            return this;
        }

        public Sdk$SDKError getErrors(int i2) {
            return ((Sdk$SDKErrorBatch) this.instance).getErrors(i2);
        }

        public int getErrorsCount() {
            return ((Sdk$SDKErrorBatch) this.instance).getErrorsCount();
        }

        public List<Sdk$SDKError> getErrorsList() {
            return Collections.unmodifiableList(((Sdk$SDKErrorBatch) this.instance).getErrorsList());
        }

        public Builder removeErrors(int i2) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).removeErrors(i2);
            return this;
        }

        public Builder setErrors(int i2, Sdk$SDKError sdk$SDKError) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).setErrors(i2, sdk$SDKError);
            return this;
        }

        private Builder() {
            super(Sdk$SDKErrorBatch.DEFAULT_INSTANCE);
        }

        public Builder addErrors(int i2, Sdk$SDKError sdk$SDKError) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).addErrors(i2, sdk$SDKError);
            return this;
        }

        public Builder setErrors(int i2, Sdk$SDKError.Builder builder) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).setErrors(i2, (Sdk$SDKError) builder.build());
            return this;
        }

        public Builder addErrors(Sdk$SDKError.Builder builder) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).addErrors((Sdk$SDKError) builder.build());
            return this;
        }

        public Builder addErrors(int i2, Sdk$SDKError.Builder builder) {
            copyOnWrite();
            ((Sdk$SDKErrorBatch) this.instance).addErrors(i2, (Sdk$SDKError) builder.build());
            return this;
        }
    }

    static {
        Sdk$SDKErrorBatch sdk$SDKErrorBatch = new Sdk$SDKErrorBatch();
        DEFAULT_INSTANCE = sdk$SDKErrorBatch;
        GeneratedMessageLite.registerDefaultInstance(Sdk$SDKErrorBatch.class, sdk$SDKErrorBatch);
    }

    private Sdk$SDKErrorBatch() {
    }

    /* access modifiers changed from: private */
    public void addAllErrors(Iterable<? extends Sdk$SDKError> iterable) {
        ensureErrorsIsMutable();
        AbstractMessageLite.addAll(iterable, this.errors_);
    }

    /* access modifiers changed from: private */
    public void addErrors(Sdk$SDKError sdk$SDKError) {
        sdk$SDKError.getClass();
        ensureErrorsIsMutable();
        this.errors_.add(sdk$SDKError);
    }

    /* access modifiers changed from: private */
    public void clearErrors() {
        this.errors_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureErrorsIsMutable() {
        Internal.ProtobufList<Sdk$SDKError> protobufList = this.errors_;
        if (!protobufList.isModifiable()) {
            this.errors_ = GeneratedMessageLite.mutableCopy(protobufList);
        }
    }

    public static Sdk$SDKErrorBatch getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return (Builder) DEFAULT_INSTANCE.createBuilder();
    }

    public static Sdk$SDKErrorBatch parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKErrorBatch parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Sdk$SDKErrorBatch> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void removeErrors(int i2) {
        ensureErrorsIsMutable();
        this.errors_.remove(i2);
    }

    /* access modifiers changed from: private */
    public void setErrors(int i2, Sdk$SDKError sdk$SDKError) {
        sdk$SDKError.getClass();
        ensureErrorsIsMutable();
        this.errors_.set(i2, sdk$SDKError);
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Sdk$1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
            case 1:
                return new Sdk$SDKErrorBatch();
            case 2:
                return new Builder((Sdk$1) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"errors_", Sdk$SDKError.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Sdk$SDKErrorBatch> parser = PARSER;
                if (parser == null) {
                    synchronized (Sdk$SDKErrorBatch.class) {
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

    public Sdk$SDKError getErrors(int i2) {
        return this.errors_.get(i2);
    }

    public int getErrorsCount() {
        return this.errors_.size();
    }

    public List<Sdk$SDKError> getErrorsList() {
        return this.errors_;
    }

    public Sdk$SDKErrorOrBuilder getErrorsOrBuilder(int i2) {
        return this.errors_.get(i2);
    }

    public List<? extends Sdk$SDKErrorOrBuilder> getErrorsOrBuilderList() {
        return this.errors_;
    }

    public static Builder newBuilder(Sdk$SDKErrorBatch sdk$SDKErrorBatch) {
        return (Builder) DEFAULT_INSTANCE.createBuilder(sdk$SDKErrorBatch);
    }

    public static Sdk$SDKErrorBatch parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKErrorBatch parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Sdk$SDKErrorBatch parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* access modifiers changed from: private */
    public void addErrors(int i2, Sdk$SDKError sdk$SDKError) {
        sdk$SDKError.getClass();
        ensureErrorsIsMutable();
        this.errors_.add(i2, sdk$SDKError);
    }

    public static Sdk$SDKErrorBatch parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Sdk$SDKErrorBatch parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Sdk$SDKErrorBatch parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Sdk$SDKErrorBatch parseFrom(InputStream inputStream) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Sdk$SDKErrorBatch parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Sdk$SDKErrorBatch parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Sdk$SDKErrorBatch parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Sdk$SDKErrorBatch) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}

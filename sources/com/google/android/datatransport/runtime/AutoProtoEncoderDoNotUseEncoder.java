package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.GlobalMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.firebase.transport.LogSourceMetrics;
import com.google.android.datatransport.runtime.firebase.transport.StorageMetrics;
import com.google.android.datatransport.runtime.firebase.transport.TimeWindow;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.google.firebase.encoders.proto.AtProtobuf;
import java.io.IOException;

public final class AutoProtoEncoderDoNotUseEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final Configurator f22447a = new AutoProtoEncoderDoNotUseEncoder();

    private static final class ClientMetricsEncoder implements ObjectEncoder<ClientMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final ClientMetricsEncoder f22448a = new ClientMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22449b = FieldDescriptor.a("window").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22450c = FieldDescriptor.a("logSourceMetrics").b(AtProtobuf.b().c(2).a()).a();

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f22451d = FieldDescriptor.a("globalMetrics").b(AtProtobuf.b().c(3).a()).a();

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f22452e = FieldDescriptor.a("appNamespace").b(AtProtobuf.b().c(4).a()).a();

        private ClientMetricsEncoder() {
        }

        /* renamed from: b */
        public void a(ClientMetrics clientMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f22449b, clientMetrics.d());
            objectEncoderContext.c(f22450c, clientMetrics.c());
            objectEncoderContext.c(f22451d, clientMetrics.b());
            objectEncoderContext.c(f22452e, clientMetrics.a());
        }
    }

    private static final class GlobalMetricsEncoder implements ObjectEncoder<GlobalMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final GlobalMetricsEncoder f22453a = new GlobalMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22454b = FieldDescriptor.a("storageMetrics").b(AtProtobuf.b().c(1).a()).a();

        private GlobalMetricsEncoder() {
        }

        /* renamed from: b */
        public void a(GlobalMetrics globalMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f22454b, globalMetrics.a());
        }
    }

    private static final class LogEventDroppedEncoder implements ObjectEncoder<LogEventDropped> {

        /* renamed from: a  reason: collision with root package name */
        static final LogEventDroppedEncoder f22455a = new LogEventDroppedEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22456b = FieldDescriptor.a("eventsDroppedCount").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22457c = FieldDescriptor.a("reason").b(AtProtobuf.b().c(3).a()).a();

        private LogEventDroppedEncoder() {
        }

        /* renamed from: b */
        public void a(LogEventDropped logEventDropped, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.a(f22456b, logEventDropped.a());
            objectEncoderContext.c(f22457c, logEventDropped.b());
        }
    }

    private static final class LogSourceMetricsEncoder implements ObjectEncoder<LogSourceMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final LogSourceMetricsEncoder f22458a = new LogSourceMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22459b = FieldDescriptor.a("logSource").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22460c = FieldDescriptor.a("logEventDropped").b(AtProtobuf.b().c(2).a()).a();

        private LogSourceMetricsEncoder() {
        }

        /* renamed from: b */
        public void a(LogSourceMetrics logSourceMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f22459b, logSourceMetrics.b());
            objectEncoderContext.c(f22460c, logSourceMetrics.a());
        }
    }

    private static final class ProtoEncoderDoNotUseEncoder implements ObjectEncoder<ProtoEncoderDoNotUse> {

        /* renamed from: a  reason: collision with root package name */
        static final ProtoEncoderDoNotUseEncoder f22461a = new ProtoEncoderDoNotUseEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22462b = FieldDescriptor.d("clientMetrics");

        private ProtoEncoderDoNotUseEncoder() {
        }

        /* renamed from: b */
        public void a(ProtoEncoderDoNotUse protoEncoderDoNotUse, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f22462b, protoEncoderDoNotUse.b());
        }
    }

    private static final class StorageMetricsEncoder implements ObjectEncoder<StorageMetrics> {

        /* renamed from: a  reason: collision with root package name */
        static final StorageMetricsEncoder f22463a = new StorageMetricsEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22464b = FieldDescriptor.a("currentCacheSizeBytes").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22465c = FieldDescriptor.a("maxCacheSizeBytes").b(AtProtobuf.b().c(2).a()).a();

        private StorageMetricsEncoder() {
        }

        /* renamed from: b */
        public void a(StorageMetrics storageMetrics, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.a(f22464b, storageMetrics.a());
            objectEncoderContext.a(f22465c, storageMetrics.b());
        }
    }

    private static final class TimeWindowEncoder implements ObjectEncoder<TimeWindow> {

        /* renamed from: a  reason: collision with root package name */
        static final TimeWindowEncoder f22466a = new TimeWindowEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22467b = FieldDescriptor.a("startMs").b(AtProtobuf.b().c(1).a()).a();

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22468c = FieldDescriptor.a("endMs").b(AtProtobuf.b().c(2).a()).a();

        private TimeWindowEncoder() {
        }

        /* renamed from: b */
        public void a(TimeWindow timeWindow, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.a(f22467b, timeWindow.b());
            objectEncoderContext.a(f22468c, timeWindow.a());
        }
    }

    private AutoProtoEncoderDoNotUseEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        encoderConfig.a(ProtoEncoderDoNotUse.class, ProtoEncoderDoNotUseEncoder.f22461a);
        encoderConfig.a(ClientMetrics.class, ClientMetricsEncoder.f22448a);
        encoderConfig.a(TimeWindow.class, TimeWindowEncoder.f22466a);
        encoderConfig.a(LogSourceMetrics.class, LogSourceMetricsEncoder.f22458a);
        encoderConfig.a(LogEventDropped.class, LogEventDroppedEncoder.f22455a);
        encoderConfig.a(GlobalMetrics.class, GlobalMetricsEncoder.f22453a);
        encoderConfig.a(StorageMetrics.class, StorageMetricsEncoder.f22463a);
    }
}

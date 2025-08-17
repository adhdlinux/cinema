package com.google.android.datatransport.cct.internal;

import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

public final class AutoBatchedLogRequestEncoder implements Configurator {

    /* renamed from: a  reason: collision with root package name */
    public static final Configurator f22288a = new AutoBatchedLogRequestEncoder();

    private static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final AndroidClientInfoEncoder f22289a = new AndroidClientInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22290b = FieldDescriptor.d("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22291c = FieldDescriptor.d("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f22292d = FieldDescriptor.d("hardware");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f22293e = FieldDescriptor.d("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f22294f = FieldDescriptor.d(AppLovinEventTypes.USER_VIEWED_PRODUCT);

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f22295g = FieldDescriptor.d("osBuild");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f22296h = FieldDescriptor.d("manufacturer");

        /* renamed from: i  reason: collision with root package name */
        private static final FieldDescriptor f22297i = FieldDescriptor.d("fingerprint");

        /* renamed from: j  reason: collision with root package name */
        private static final FieldDescriptor f22298j = FieldDescriptor.d(Constants.LOCALE);

        /* renamed from: k  reason: collision with root package name */
        private static final FieldDescriptor f22299k = FieldDescriptor.d("country");

        /* renamed from: l  reason: collision with root package name */
        private static final FieldDescriptor f22300l = FieldDescriptor.d("mccMnc");

        /* renamed from: m  reason: collision with root package name */
        private static final FieldDescriptor f22301m = FieldDescriptor.d("applicationBuild");

        private AndroidClientInfoEncoder() {
        }

        /* renamed from: b */
        public void a(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f22290b, androidClientInfo.m());
            objectEncoderContext.c(f22291c, androidClientInfo.j());
            objectEncoderContext.c(f22292d, androidClientInfo.f());
            objectEncoderContext.c(f22293e, androidClientInfo.d());
            objectEncoderContext.c(f22294f, androidClientInfo.l());
            objectEncoderContext.c(f22295g, androidClientInfo.k());
            objectEncoderContext.c(f22296h, androidClientInfo.h());
            objectEncoderContext.c(f22297i, androidClientInfo.e());
            objectEncoderContext.c(f22298j, androidClientInfo.g());
            objectEncoderContext.c(f22299k, androidClientInfo.c());
            objectEncoderContext.c(f22300l, androidClientInfo.i());
            objectEncoderContext.c(f22301m, androidClientInfo.b());
        }
    }

    private static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {

        /* renamed from: a  reason: collision with root package name */
        static final BatchedLogRequestEncoder f22302a = new BatchedLogRequestEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22303b = FieldDescriptor.d("logRequest");

        private BatchedLogRequestEncoder() {
        }

        /* renamed from: b */
        public void a(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f22303b, batchedLogRequest.c());
        }
    }

    private static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final ClientInfoEncoder f22304a = new ClientInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22305b = FieldDescriptor.d("clientType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22306c = FieldDescriptor.d("androidClientInfo");

        private ClientInfoEncoder() {
        }

        /* renamed from: b */
        public void a(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f22305b, clientInfo.c());
            objectEncoderContext.c(f22306c, clientInfo.b());
        }
    }

    private static final class LogEventEncoder implements ObjectEncoder<LogEvent> {

        /* renamed from: a  reason: collision with root package name */
        static final LogEventEncoder f22307a = new LogEventEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22308b = FieldDescriptor.d("eventTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22309c = FieldDescriptor.d("eventCode");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f22310d = FieldDescriptor.d("eventUptimeMs");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f22311e = FieldDescriptor.d("sourceExtension");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f22312f = FieldDescriptor.d("sourceExtensionJsonProto3");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f22313g = FieldDescriptor.d("timezoneOffsetSeconds");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f22314h = FieldDescriptor.d("networkConnectionInfo");

        private LogEventEncoder() {
        }

        /* renamed from: b */
        public void a(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.a(f22308b, logEvent.c());
            objectEncoderContext.c(f22309c, logEvent.b());
            objectEncoderContext.a(f22310d, logEvent.d());
            objectEncoderContext.c(f22311e, logEvent.f());
            objectEncoderContext.c(f22312f, logEvent.g());
            objectEncoderContext.a(f22313g, logEvent.h());
            objectEncoderContext.c(f22314h, logEvent.e());
        }
    }

    private static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {

        /* renamed from: a  reason: collision with root package name */
        static final LogRequestEncoder f22315a = new LogRequestEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22316b = FieldDescriptor.d("requestTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22317c = FieldDescriptor.d("requestUptimeMs");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f22318d = FieldDescriptor.d("clientInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f22319e = FieldDescriptor.d("logSource");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f22320f = FieldDescriptor.d("logSourceName");

        /* renamed from: g  reason: collision with root package name */
        private static final FieldDescriptor f22321g = FieldDescriptor.d("logEvent");

        /* renamed from: h  reason: collision with root package name */
        private static final FieldDescriptor f22322h = FieldDescriptor.d("qosTier");

        private LogRequestEncoder() {
        }

        /* renamed from: b */
        public void a(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.a(f22316b, logRequest.g());
            objectEncoderContext.a(f22317c, logRequest.h());
            objectEncoderContext.c(f22318d, logRequest.b());
            objectEncoderContext.c(f22319e, logRequest.d());
            objectEncoderContext.c(f22320f, logRequest.e());
            objectEncoderContext.c(f22321g, logRequest.c());
            objectEncoderContext.c(f22322h, logRequest.f());
        }
    }

    private static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {

        /* renamed from: a  reason: collision with root package name */
        static final NetworkConnectionInfoEncoder f22323a = new NetworkConnectionInfoEncoder();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f22324b = FieldDescriptor.d("networkType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f22325c = FieldDescriptor.d("mobileSubtype");

        private NetworkConnectionInfoEncoder() {
        }

        /* renamed from: b */
        public void a(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.c(f22324b, networkConnectionInfo.c());
            objectEncoderContext.c(f22325c, networkConnectionInfo.b());
        }
    }

    private AutoBatchedLogRequestEncoder() {
    }

    public void a(EncoderConfig<?> encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.f22302a;
        encoderConfig.a(BatchedLogRequest.class, batchedLogRequestEncoder);
        encoderConfig.a(AutoValue_BatchedLogRequest.class, batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.f22315a;
        encoderConfig.a(LogRequest.class, logRequestEncoder);
        encoderConfig.a(AutoValue_LogRequest.class, logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.f22304a;
        encoderConfig.a(ClientInfo.class, clientInfoEncoder);
        encoderConfig.a(AutoValue_ClientInfo.class, clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.f22289a;
        encoderConfig.a(AndroidClientInfo.class, androidClientInfoEncoder);
        encoderConfig.a(AutoValue_AndroidClientInfo.class, androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.f22307a;
        encoderConfig.a(LogEvent.class, logEventEncoder);
        encoderConfig.a(AutoValue_LogEvent.class, logEventEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.f22323a;
        encoderConfig.a(NetworkConnectionInfo.class, networkConnectionInfoEncoder);
        encoderConfig.a(AutoValue_NetworkConnectionInfo.class, networkConnectionInfoEncoder);
    }
}

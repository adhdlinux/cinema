package com.chartboost.sdk.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public interface tb {

    /* renamed from: a  reason: collision with root package name */
    public static final c f18650a = c.f18667a;

    public enum a implements tb {
        IGNORED("cache_ignored"),
        START("cache_start"),
        FINISH_SUCCESS("cache_finish_success"),
        FINISH_FAILURE("cache_finish_failure"),
        GET_RESPONSE_PARSING_ERROR("cache_get_response_parsing_error"),
        BID_RESPONSE_PARSING_ERROR("cache_bid_response_parsing_error"),
        ASSET_DOWNLOAD_ERROR("cache_asset_download_error"),
        REQUEST_ERROR("cache_request_error"),
        SERVER_ERROR("cache_server_error");
        

        /* renamed from: b  reason: collision with root package name */
        public final String f18661b;

        /* access modifiers changed from: public */
        a(String str) {
            this.f18661b = str;
        }

        public String getValue() {
            return this.f18661b;
        }
    }

    public enum b implements tb {
        SUCCESS("click_success"),
        FAILURE("click_failure"),
        INVALID_URL_ERROR("click_invalid_url_error");
        

        /* renamed from: b  reason: collision with root package name */
        public final String f18666b;

        /* access modifiers changed from: public */
        b(String str) {
            this.f18666b = str;
        }

        public String getValue() {
            return this.f18666b;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ c f18667a = new c();

        /* renamed from: b  reason: collision with root package name */
        public static final Lazy f18668b = LazyKt__LazyJVMKt.b(a.f18669b);

        public static final class a extends Lambda implements Function0 {

            /* renamed from: b  reason: collision with root package name */
            public static final a f18669b = new a();

            public a() {
                super(0);
            }

            /* renamed from: a */
            public final List invoke() {
                return ArraysKt__ArraysKt.c(new Object[][]{a.values(), h.values(), b.values(), d.values(), f.values(), g.values(), i.values(), e.values()});
            }
        }

        public final List a() {
            return (List) f18668b.getValue();
        }

        public final List a(List list) {
            Intrinsics.f(list, "values");
            List a2 = a();
            ArrayList arrayList = new ArrayList();
            for (Object next : a2) {
                if (list.contains(((tb) next).getValue())) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        }
    }

    public enum d implements tb {
        SUBCLASSING_ERROR("consent_subclassing_error"),
        DECODING_ERROR("consent_decoding_error"),
        CREATION_ERROR("consent_creation_error"),
        PERSISTED_DATA_READING_ERROR("consent_persisted_data_reading_error"),
        PERSISTENCE_ERROR("consent_persistence_error");
        

        /* renamed from: b  reason: collision with root package name */
        public final String f18676b;

        /* access modifiers changed from: public */
        d(String str) {
            this.f18676b = str;
        }

        public String getValue() {
            return this.f18676b;
        }
    }

    public enum e implements tb {
        USER_AGENT_UPDATE_ERROR("user_agent_update_error"),
        PREFETCH_REQUEST_ERROR("prefetch_request_error"),
        CONFIG_REQUEST_ERROR("config_request_error"),
        INSTALL_REQUEST_ERROR("install_request_error"),
        IMPRESSION_RECORDED("impression_recorded"),
        UNSUPPORTED_OS_VERSION("unsupported_os_version"),
        TOO_MANY_EVENTS("too_many_events");
        

        /* renamed from: b  reason: collision with root package name */
        public final String f18685b;

        /* access modifiers changed from: public */
        e(String str) {
            this.f18685b = str;
        }

        public String getValue() {
            return this.f18685b;
        }
    }

    public enum f implements tb {
        SUCCESS("navigation_success"),
        FAILURE("navigation_failure");
        

        /* renamed from: b  reason: collision with root package name */
        public final String f18689b;

        /* access modifiers changed from: public */
        f(String str) {
            this.f18689b = str;
        }

        public String getValue() {
            return this.f18689b;
        }
    }

    public enum g implements tb {
        REQUEST_JSON_SERIALIZATION_ERROR("request_json_serialization_error"),
        RESPONSE_JSON_SERIALIZATION_ERROR("response_json_serialization_error"),
        RESPONSE_DATA_WRITE_ERROR("response_data_write_error"),
        DISPATCHER_EXCEPTION("network_failure_dispatcher_exception");
        

        /* renamed from: b  reason: collision with root package name */
        public final String f18695b;

        /* access modifiers changed from: public */
        g(String str) {
            this.f18695b = str;
        }

        public String getValue() {
            return this.f18695b;
        }
    }

    public enum h implements tb {
        START("show_start"),
        FINISH_SUCCESS("show_finish_success"),
        FINISH_FAILURE("show_finish_failure"),
        UNAVAILABLE_ASSET_ERROR("show_unavailable_asset_error"),
        TIMEOUT_EVENT("show_timeout_error"),
        HTML_MISSING_MUSTACHE_ERROR("show_html_missing_mustache_error"),
        WEBVIEW_SSL_ERROR("show_webview_ssl_error"),
        WEBVIEW_ERROR("show_webview_error"),
        WEBVIEW_CRASH("show_webview_crash"),
        UNEXPECTED_DISMISS_ERROR("show_unexpected_dismiss_error"),
        REQUEST_ERROR("show_request_error"),
        CLOSE_BEFORE_TEMPLATE_SHOW_ERROR("show_close_before_template_show_error"),
        DISMISS_MISSING("dismiss_missing");
        

        /* renamed from: b  reason: collision with root package name */
        public final String f18710b;

        /* access modifiers changed from: public */
        h(String str) {
            this.f18710b = str;
        }

        public String getValue() {
            return this.f18710b;
        }
    }

    public enum i implements tb {
        FINISH_SUCCESS("video_finish_success"),
        FINISH_FAILURE("video_finish_failure");
        

        /* renamed from: b  reason: collision with root package name */
        public final String f18714b;

        /* access modifiers changed from: public */
        i(String str) {
            this.f18714b = str;
        }

        public String getValue() {
            return this.f18714b;
        }
    }

    String getValue();
}

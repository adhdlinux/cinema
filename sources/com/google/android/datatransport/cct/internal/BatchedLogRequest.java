package com.google.android.datatransport.cct.internal;

import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

@AutoValue
public abstract class BatchedLogRequest {
    public static BatchedLogRequest a(List<LogRequest> list) {
        return new AutoValue_BatchedLogRequest(list);
    }

    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().j(AutoBatchedLogRequestEncoder.f22288a).k(true).i();
    }

    public abstract List<LogRequest> c();
}

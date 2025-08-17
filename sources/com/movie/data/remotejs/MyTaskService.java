package com.movie.data.remotejs;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;

public class MyTaskService extends HeadlessJsTaskService {
    /* access modifiers changed from: protected */
    public HeadlessJsTaskConfig getTaskConfig(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            return new HeadlessJsTaskConfig("HeadlessTask", Arguments.fromBundle(extras), 5000, true);
        }
        return null;
    }
}

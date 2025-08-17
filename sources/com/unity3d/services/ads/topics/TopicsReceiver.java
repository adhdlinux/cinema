package com.unity3d.services.ads.topics;

import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.annotation.SuppressLint;
import android.os.OutcomeReceiver;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"NewApi", "MissingPermission"})
public final class TopicsReceiver implements OutcomeReceiver<GetTopicsResponse, Exception> {
    private final IEventSender eventSender;

    public TopicsReceiver(IEventSender iEventSender) {
        Intrinsics.f(iEventSender, "eventSender");
        this.eventSender = iEventSender;
    }

    public final JSONObject formatTopic(Topic topic) {
        Intrinsics.f(topic, "topic");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("taxonomyVersion", topic.getTaxonomyVersion());
        jSONObject.put("modelVersion", topic.getModelVersion());
        jSONObject.put("topicId", topic.getTopicId());
        return jSONObject;
    }

    public void onError(Exception exc) {
        Intrinsics.f(exc, MRAIDPresenter.ERROR);
        DeviceLog.debug("GetTopics exception: " + exc);
        this.eventSender.sendEvent(WebViewEventCategory.TOPICS, TopicsEvents.NOT_AVAILABLE, TopicsErrors.ERROR_EXCEPTION, exc.toString());
    }

    public void onResult(GetTopicsResponse getTopicsResponse) {
        Intrinsics.f(getTopicsResponse, "result");
        JSONArray jSONArray = new JSONArray();
        List<Topic> topics = getTopicsResponse.getTopics();
        Intrinsics.e(topics, "result.topics");
        for (Topic topic : topics) {
            Intrinsics.e(topic, "it");
            jSONArray.put(formatTopic(topic));
        }
        IEventSender iEventSender = this.eventSender;
        WebViewEventCategory webViewEventCategory = WebViewEventCategory.TOPICS;
        TopicsEvents topicsEvents = TopicsEvents.TOPICS_AVAILABLE;
        String jSONArray2 = jSONArray.toString();
        Intrinsics.e(jSONArray2, "resultArray.toString()");
        iEventSender.sendEvent(webViewEventCategory, topicsEvents, jSONArray2);
    }
}

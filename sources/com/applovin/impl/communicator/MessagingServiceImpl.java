package com.applovin.impl.communicator;

import android.content.Context;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorMessagingService;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class MessagingServiceImpl implements AppLovinCommunicatorMessagingService {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f14143a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledThreadPoolExecutor f14144b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Queue<CommunicatorMessageImpl>> f14145c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Object f14146d = new Object();

    public MessagingServiceImpl(Context context) {
        this.f14143a = context;
        this.f14144b = a();
    }

    private Queue<CommunicatorMessageImpl> a(String str) {
        LinkedList linkedList;
        synchronized (this.f14146d) {
            Queue queue = this.f14145c.get(str);
            linkedList = queue != null ? new LinkedList(queue) : new LinkedList();
        }
        return linkedList;
    }

    private ScheduledThreadPoolExecutor a() {
        return new ScheduledThreadPoolExecutor(4, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AppLovinSdk:com.applovin.communicator");
                thread.setPriority(10);
                thread.setDaemon(true);
                return thread;
            }
        });
    }

    private void a(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (appLovinCommunicatorMessage.sticky) {
            synchronized (this.f14146d) {
                Queue queue = this.f14145c.get(appLovinCommunicatorMessage.getTopic());
                if (queue != null) {
                    queue.add(appLovinCommunicatorMessage);
                    if (queue.size() > 100) {
                        queue.remove();
                    }
                } else {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(appLovinCommunicatorMessage);
                    this.f14145c.put(appLovinCommunicatorMessage.getTopic(), linkedList);
                }
            }
        }
    }

    private void a(final CommunicatorMessageImpl communicatorMessageImpl) {
        this.f14144b.execute(new Runnable() {
            public void run() {
                AppLovinBroadcastManager.getInstance(MessagingServiceImpl.this.f14143a).sendBroadcastSync(communicatorMessageImpl, (Map<String, Object>) null);
            }
        });
    }

    public void maybeFlushStickyMessages(String str) {
        for (CommunicatorMessageImpl a2 : a(str)) {
            a(a2);
        }
    }

    public void publish(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        a((CommunicatorMessageImpl) appLovinCommunicatorMessage);
        a(appLovinCommunicatorMessage);
    }

    public String toString() {
        return "MessagingServiceImpl{}";
    }
}

package org.apache.commons.vfs2.util;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class Messages {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentMap<String, MessageFormat> f41474a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private static final ResourceBundle f41475b = new CombinedResources("org.apache.commons.vfs2.Resources");

    private Messages() {
    }

    private static MessageFormat a(String str) throws MissingResourceException {
        MessageFormat messageFormat = f41474a.get(str);
        if (messageFormat != null) {
            return messageFormat;
        }
        f41474a.putIfAbsent(str, new MessageFormat(f41475b.getString(str)));
        return f41474a.get(str);
    }

    public static String b(String str, Object... objArr) {
        if (str == null) {
            return null;
        }
        try {
            return a(str).format(objArr);
        } catch (MissingResourceException unused) {
            return "Unknown message with code \"" + str + "\".";
        }
    }
}

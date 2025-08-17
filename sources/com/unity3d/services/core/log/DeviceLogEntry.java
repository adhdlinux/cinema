package com.unity3d.services.core.log;

class DeviceLogEntry {
    private DeviceLogLevel _logLevel;
    private String _originalMessage;
    private StackTraceElement _stackTraceElement;

    public DeviceLogEntry(DeviceLogLevel deviceLogLevel, String str, StackTraceElement stackTraceElement) {
        this._logLevel = deviceLogLevel;
        this._originalMessage = str;
        this._stackTraceElement = stackTraceElement;
    }

    public DeviceLogLevel getLogLevel() {
        return this._logLevel;
    }

    public String getParsedMessage() {
        int i2;
        String str;
        String str2;
        String str3 = this._originalMessage;
        StackTraceElement stackTraceElement = this._stackTraceElement;
        if (stackTraceElement != null) {
            str2 = stackTraceElement.getClassName();
            str = this._stackTraceElement.getMethodName();
            i2 = this._stackTraceElement.getLineNumber();
        } else {
            str2 = "UnknownClass";
            str = "unknownMethod";
            i2 = -1;
        }
        if (str3 != null && !str3.isEmpty()) {
            str3 = " :: " + str3;
        }
        if (str3 == null) {
            str3 = "";
        }
        return str2 + "." + str + "()" + (" (line:" + i2 + ")") + str3;
    }
}

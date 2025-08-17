package com.unity3d.services.core.device;

import com.unity3d.services.core.device.StorageManager;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.JsonStorage;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.io.File;
import java.io.FileNotFoundException;
import org.json.JSONObject;

public class Storage extends JsonStorage {
    private String _targetFileName;
    private StorageManager.StorageType _type;

    public Storage(String str, StorageManager.StorageType storageType) {
        this._targetFileName = str;
        this._type = storageType;
    }

    public synchronized boolean clearStorage() {
        clearData();
        return new File(this._targetFileName).delete();
    }

    public StorageManager.StorageType getType() {
        return this._type;
    }

    public synchronized boolean initStorage() {
        readStorage();
        super.initData();
        return true;
    }

    public synchronized boolean readStorage() {
        try {
            byte[] readFileBytes = Utilities.readFileBytes(new File(this._targetFileName));
            if (readFileBytes == null) {
                return false;
            }
            setData(new JSONObject(new String(readFileBytes)));
            return true;
        } catch (FileNotFoundException e2) {
            DeviceLog.debug("Storage JSON file not found in local cache:", e2);
            return false;
        } catch (Exception e3) {
            DeviceLog.debug("Failed to read storage JSON file:", e3);
            return false;
        }
    }

    public synchronized void sendEvent(StorageEvent storageEvent, Object obj) {
        boolean z2 = false;
        if (WebViewApp.getCurrentApp() != null) {
            z2 = WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.STORAGE, storageEvent, this._type.name(), obj);
        }
        if (!z2) {
            DeviceLog.debug("Couldn't send storage event to WebApp");
        }
    }

    public synchronized boolean storageFileExists() {
        return new File(this._targetFileName).exists();
    }

    public synchronized boolean writeStorage() {
        File file = new File(this._targetFileName);
        if (getData() == null) {
            return false;
        }
        return Utilities.writeFile(file, getData().toString());
    }
}

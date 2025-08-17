package com.unity3d.services.core.device.reader;

import com.unity3d.services.core.device.reader.pii.NonBehavioralFlag;
import com.unity3d.services.core.device.reader.pii.NonBehavioralFlagReader;
import java.util.Map;

public class DeviceInfoReaderWithBehavioralFlag implements IDeviceInfoReader {
    private final IDeviceInfoReader _deviceInfoReader;
    private final NonBehavioralFlagReader _nonBehavioralFlagReader;

    public DeviceInfoReaderWithBehavioralFlag(IDeviceInfoReader iDeviceInfoReader, NonBehavioralFlagReader nonBehavioralFlagReader) {
        this._deviceInfoReader = iDeviceInfoReader;
        this._nonBehavioralFlagReader = nonBehavioralFlagReader;
    }

    public Map<String, Object> getDeviceInfoData() {
        boolean z2;
        Map<String, Object> deviceInfoData = this._deviceInfoReader.getDeviceInfoData();
        if (this._nonBehavioralFlagReader.getUserNonBehavioralFlag() != NonBehavioralFlag.UNKNOWN) {
            if (this._nonBehavioralFlagReader.getUserNonBehavioralFlag() == NonBehavioralFlag.TRUE) {
                z2 = true;
            } else {
                z2 = false;
            }
            deviceInfoData.put(JsonStorageKeyNames.USER_NON_BEHAVIORAL_KEY, Boolean.valueOf(z2));
        }
        return deviceInfoData;
    }
}

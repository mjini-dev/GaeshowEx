package mjin.gaeshowex.data.deviceInfo.local

import mjin.gaeshowex.util.DeviceInfo

interface DeviceInfoLocalDataSource {

    fun getDeviceInfo(): DeviceInfo
}
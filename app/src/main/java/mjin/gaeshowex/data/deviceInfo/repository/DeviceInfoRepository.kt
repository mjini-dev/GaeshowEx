package mjin.gaeshowex.data.deviceInfo.repository

import mjin.gaeshowex.util.DeviceInfo

interface DeviceInfoRepository {

    fun getDeviceInfo(): DeviceInfo
}
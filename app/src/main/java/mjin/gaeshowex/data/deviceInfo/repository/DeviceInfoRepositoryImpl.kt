package mjin.gaeshowex.data.deviceInfo.repository

import mjin.gaeshowex.data.deviceInfo.local.DeviceInfoLocalDataSource
import mjin.gaeshowex.util.DeviceInfo

class DeviceInfoRepositoryImpl(
    private val deviceInfoLocalDataSource: DeviceInfoLocalDataSource
) : DeviceInfoRepository {
    override fun getDeviceInfo(): DeviceInfo {
        return deviceInfoLocalDataSource.getDeviceInfo()
    }
}
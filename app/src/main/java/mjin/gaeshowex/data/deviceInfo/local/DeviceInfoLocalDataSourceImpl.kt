package mjin.gaeshowex.data.deviceInfo.local

import android.content.Context
import mjin.gaeshowex.util.DeviceInfo

class DeviceInfoLocalDataSourceImpl(context: Context) : DeviceInfoLocalDataSource {

    private val deviceInfo = DeviceInfo(context)

    override fun getDeviceInfo(): DeviceInfo {
        return deviceInfo
    }
}
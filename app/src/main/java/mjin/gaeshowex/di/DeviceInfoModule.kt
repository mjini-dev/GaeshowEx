package mjin.gaeshowex.di

import mjin.gaeshowex.data.deviceInfo.local.DeviceInfoLocalDataSource
import mjin.gaeshowex.data.deviceInfo.local.DeviceInfoLocalDataSourceImpl
import mjin.gaeshowex.data.deviceInfo.repository.DeviceInfoRepository
import mjin.gaeshowex.data.deviceInfo.repository.DeviceInfoRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val deviceInfoModule = module {
    single<DeviceInfoRepository> { DeviceInfoRepositoryImpl(get()) }
    single<DeviceInfoLocalDataSource> { DeviceInfoLocalDataSourceImpl(androidContext()) }
}
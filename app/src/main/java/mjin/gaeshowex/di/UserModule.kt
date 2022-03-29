package mjin.gaeshowex.di

import mjin.gaeshowex.data.user.source.local.UserLocalDataSource
import mjin.gaeshowex.data.user.source.local.UserLocalDataSourceImpl
import mjin.gaeshowex.data.user.source.remote.UserRemoteDataSource
import mjin.gaeshowex.data.user.source.remote.UserRemoteDataSourceImpl
import mjin.gaeshowex.data.user.source.repository.UserRepository
import mjin.gaeshowex.data.user.source.repository.UserRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val userModule = module {
    single<UserRepository> { UserRepositoryImpl(get(), get()) }
    single<UserLocalDataSource> { UserLocalDataSourceImpl(androidContext()) }
    single<UserRemoteDataSource> { UserRemoteDataSourceImpl(get()) }
}
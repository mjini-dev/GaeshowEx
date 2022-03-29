package mjin.gaeshowex.di

import mjin.gaeshowex.data.user.source.local.TokenLocalDataSource
import mjin.gaeshowex.data.user.source.local.TokenLocalDataSourceImpl
import mjin.gaeshowex.data.user.source.repository.TokenRepository
import mjin.gaeshowex.data.user.source.repository.TokenRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val tokenModule = module {
    single<TokenRepository> { TokenRepositoryImpl(get()) }
    single<TokenLocalDataSource> { TokenLocalDataSourceImpl(androidContext()) }
}
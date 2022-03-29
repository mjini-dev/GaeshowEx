package mjin.gaeshowex.di

import mjin.tutorials.gaeshowex.view.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginViewModelModule = module {
    viewModel {
        LoginViewModel(get(), get(), get(), get())
    }
}
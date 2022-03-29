package mjin.gaeshowex.di

import mjin.tutorials.gaeshowex.view.home.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModelModule = module {
    viewModel {
        MainViewModel(get(), get(), get())
    }
}
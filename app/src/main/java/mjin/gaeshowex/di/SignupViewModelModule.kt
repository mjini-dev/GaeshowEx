package mjin.gaeshowex.di

import mjin.tutorials.gaeshowex.view.join.SignupViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val signupViewModelNodule = module {
    viewModel {
        SignupViewModel(get(),get(),get(),get(),get())
    }
}
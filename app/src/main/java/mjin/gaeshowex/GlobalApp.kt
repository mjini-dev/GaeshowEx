package mjin.gaeshowex

import android.app.Application
import mjin.gaeshowex.di.*
import mjin.gaeshowex.network.networkModule

class GlobalApp : Application() {

    override fun onCreate() {
        super.onCreate()

        //Kakao SDK를 사용하기 위해서 Native App Key로 초기화진행행
        KakaoSdk.init(this, "")

        //DI_Module Application 시작과 함께 startKoin을 통해 인자로 넘겨준다
        startKoin {
            androidContext(this@GlobalApp)
            modules(
                networkModule,
                userModule,
                tokenModule,
                deviceInfoModule,

                signupViewModelNodule,
                loginViewModelModule,

            )
        }
    }
}
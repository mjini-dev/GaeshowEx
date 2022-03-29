package mjin.gaeshowex.network

import mjin.gaeshowex.data.user.model.CheckUserRequest
import mjin.gaeshowex.data.user.model.CheckUserResponse
import mjin.gaeshowex.data.user.model.LoginRequest
import mjin.gaeshowex.data.user.model.LoginResponse
import retrofit2.Call
import retrofit2.http.*

interface RetrofitInterface {

    //가입여부체크
    @POST("users/check")
    fun checkUser(@Body request: CheckUserRequest): Call<CheckUserResponse>

    // 로그인
    @POST("users/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

}
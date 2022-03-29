package  mjin.gaeshowex.data.user.source.remote

import android.util.Log
import mjin.gaeshowex.data.user.model.CheckUserRequest
import mjin.gaeshowex.data.user.model.CheckUserResponse
import mjin.gaeshowex.data.user.model.LoginRequest
import mjin.gaeshowex.data.user.model.LoginResponse
import mjin.gaeshowex.network.NetworkCheck
import mjin.gaeshowex.network.RetrofitInterface
import mjin.gaeshowex.util.TOKEN_EXPIRED
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

/**
UserRemoteDataSource를 구현하는 구현체
 */

class UserRemoteDataSourceImpl(
    private val retrofitApiService: RetrofitInterface
) : UserRemoteDataSource {

    override fun checkUser(
        request: CheckUserRequest,
        onSuccess: (response: CheckUserResponse) -> Unit,
        notSuccessStatus: (errorCode: Int) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        retrofitApiService.checkUser(request).enqueue(object : Callback<CheckUserResponse> {
            override fun onFailure(call: Call<CheckUserResponse>, t: Throwable) {
                onFailure(t)
            }

            override fun onResponse(
                call: Call<CheckUserResponse>,
                response: Response<CheckUserResponse>
            ) {
                val responseBody = response.body()
                if (responseBody != null && response.isSuccessful) {
                    onSuccess(responseBody)
                } else {
                    val errorCode = HttpException(response).code()
                    if (errorCode in 400..599) {
                        notSuccessStatus(errorCode)
                    }
                    onFailure(HttpException(response))
                }
            }

        })
    }

    override fun login(
        request: LoginRequest,
        onSuccess: (response: LoginResponse) -> Unit,
        notSuccessStatus: (errorCode: Int) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        retrofitApiService.login(request).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onFailure(t)
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                val responseBody = response.body()
                if (responseBody != null && response.isSuccessful) {
                    onSuccess(responseBody)
                } else {
                    val errorBody = response.errorBody()?.let { NetworkCheck.getErrorResponse(it) }.toString()
                    val errorCode = HttpException(response).code()

                    if (errorCode == 401) {
                        Log.e("loginResponse", errorBody)
                        when (errorBody) {
                            "ErrorResponse(code=signin_token_expired)" -> notSuccessStatus(TOKEN_EXPIRED)
                            "ErrorResponse(code=access_token_expired)" -> notSuccessStatus(TOKEN_EXPIRED)
                            else -> notSuccessStatus(0)
                        }
                    } else notSuccessStatus(errorCode)

                    onFailure(HttpException(response))
                }
            }

        })
    }
}
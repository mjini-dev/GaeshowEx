package  mjin.gaeshowex.data.user.source.remote

import mjin.gaeshowex.data.user.model.CheckUserRequest
import mjin.gaeshowex.data.user.model.CheckUserResponse
import mjin.gaeshowex.data.user.model.LoginRequest
import mjin.gaeshowex.data.user.model.LoginResponse

/**
 * user조회 API Remote DataSource
 */
interface UserRemoteDataSource {

    fun checkUser(
        request: CheckUserRequest,
        onSuccess: (response: CheckUserResponse) -> Unit,
        notSuccessStatus: (errorCode: Int) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )

    fun login(
        request: LoginRequest,
        onSuccess: (response: LoginResponse) -> Unit,
        notSuccessStatus: (errorCode: Int) -> Unit,
        onFailure: (e: Throwable) -> Unit
    )

}
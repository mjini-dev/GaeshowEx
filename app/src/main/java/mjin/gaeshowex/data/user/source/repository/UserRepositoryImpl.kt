package mjin.gaeshowex.data.user.source.repository

import mjin.gaeshowex.data.user.model.CheckUserRequest
import mjin.gaeshowex.data.user.model.CheckUserResponse
import mjin.gaeshowex.data.user.model.LoginRequest
import mjin.gaeshowex.data.user.model.LoginResponse
import mjin.gaeshowex.data.user.source.local.UserLocalDataSource
import mjin.gaeshowex.data.user.source.remote.UserRemoteDataSource
import mjin.gaeshowex.data.user.source.repository.UserRepository

class UserRepositoryImpl(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) : UserRepository {


    override fun checkUser(
        request: CheckUserRequest,
        onSuccess: (response: CheckUserResponse) -> Unit,
        notSuccessStatus: (errorCode: Int) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        userRemoteDataSource.checkUser(request, onSuccess, notSuccessStatus, onFailure)
    }

    override fun login(
        request: LoginRequest,
        onSuccess: (response: LoginResponse) -> Unit,
        notSuccessStatus: (errorCode: Int) -> Unit,
        onFailure: (e: Throwable) -> Unit
    ) {
        userRemoteDataSource.login(request, onSuccess, notSuccessStatus, onFailure)
    }

}
package mjin.gaeshowex.data.user.source.local

import mjin.gaeshowex.data.user.model.AccessToken
import mjin.gaeshowex.data.user.model.SigninToken

interface TokenLocalDataSource {

    fun getSigninToken(
        tokenExisted: (token: SigninToken) -> Unit,
        tokenNotExist: () -> Unit
    )

    fun saveSigninToken(token: SigninToken)

    fun getAccessToken(
        accessTokenExisted: (token: AccessToken) -> Unit,
        accessTokenNotExist: () -> Unit
    )

    fun saveAccessToken(token: AccessToken)

    fun deleteToken()

}
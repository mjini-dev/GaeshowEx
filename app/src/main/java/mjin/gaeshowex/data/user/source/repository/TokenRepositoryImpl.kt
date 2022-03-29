package mjin.gaeshowex.data.user.source.repository

import mjin.gaeshowex.data.user.model.AccessToken
import mjin.gaeshowex.data.user.model.SigninToken
import mjin.gaeshowex.data.user.source.local.TokenLocalDataSource
import mjin.gaeshowex.data.user.source.repository.TokenRepository

class TokenRepositoryImpl(private val tokenLocalDataSource: TokenLocalDataSource) :
    TokenRepository {
    override fun getSigninToken(
        tokenExisted: (token: SigninToken) -> Unit,
        tokenNotExist: () -> Unit
    ) {
        tokenLocalDataSource.getSigninToken(tokenExisted, tokenNotExist)
    }

    override fun saveSigninToken(token: SigninToken) {
        tokenLocalDataSource.saveSigninToken(token)
    }

    override fun getAccessToken(
        accessTokenExisted: (token: AccessToken) -> Unit,
        accessTokenNotExist: () -> Unit
    ) {
        tokenLocalDataSource.getAccessToken(accessTokenExisted, accessTokenNotExist)
    }

    override fun saveAccessToken(token: AccessToken) {
        tokenLocalDataSource.saveAccessToken(token)
    }

    override fun deleteToken() {
        tokenLocalDataSource.deleteToken()
    }

}
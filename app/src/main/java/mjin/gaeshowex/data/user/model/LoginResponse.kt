package mjin.gaeshowex.data.user.model

import mjin.gaeshowex.data.user.model.User

/**
 * 로그인 서버 응답 데이터클래스
 */

data class LoginResponse(
    val access_token: String,
    val user: User
)
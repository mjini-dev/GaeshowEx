package mjin.gaeshowex.data.user.source.local


import mjin.gaeshowex.data.user.model.SimpleLoginUserProfile
import mjin.gaeshowex.data.user.model.User

interface UserLocalDataSource {

    fun saveUserProfile(user: User)

    fun getUserProfile(
        onProfileExist: (user: User) -> Unit,
        onProfileNotExist: () -> Unit
    )

    fun saveSimpleLoginUserProfile(SimpleLoginUserProfile: SimpleLoginUserProfile)

    fun getSimpleLoginUserProfile(
        onProfileExist: (SimpleLoginUserProfile: SimpleLoginUserProfile) -> Unit,
        onProfileNotExist: () -> Unit
    )

    fun deleteProfile()


}
package chat.rocket.android.authentication.presentation

import android.content.Intent
import chat.rocket.android.R
import chat.rocket.android.app.MainActivity
import chat.rocket.android.authentication.ui.AuthenticationActivity
import chat.rocket.android.authentication.ui.LoginFragment
import chat.rocket.android.authentication.ui.SignupFragment
import chat.rocket.android.util.addFragmentBackStack

class AuthenticationNavigator(internal val activity: AuthenticationActivity) {
    var currentServer: String? = null

    fun toLogin(server: String) {
        currentServer = server
        activity.addFragmentBackStack("loginFragment", R.id.fragment_container) {
            LoginFragment.newInstance(server)
        }
    }

    fun toChatList() {
        val chatRoom = Intent(activity, MainActivity::class.java).apply {
            //TODO any parameter to pass
        }
        activity.startActivity(chatRoom)
        activity.finish()
    }

    fun toSignUp(server: String) {
        activity.addFragmentBackStack("signupFragment", R.id.fragment_container) {
            SignupFragment.newInstance(server)
        }
    }
}

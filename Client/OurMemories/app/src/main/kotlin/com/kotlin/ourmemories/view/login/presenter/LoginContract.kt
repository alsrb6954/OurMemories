package com.kotlin.ourmemories.view.login.presenter

import android.content.BroadcastReceiver
import com.facebook.CallbackManager
import com.facebook.login.LoginManager
import com.kotlin.ourmemories.data.source.login.LoginRepository
import com.kotlin.ourmemories.view.login.LoginActivity

/**
 * Created by kimmingyu on 2017. 11. 2..
 */
interface LoginContract {
    interface Presenter{
        var activity:LoginActivity
        var mLoginManager: LoginManager
        var callbackManager: CallbackManager
        var callback:LoginPresenter.SessionCallback
        var mRegistrationBroadcastReceiver:BroadcastReceiver
        var loginData: LoginRepository

        fun animation()
        fun facebookLogin()
        fun kakaoLogin()
        fun checkPlayServices(): Boolean
        fun isLogin(): Boolean
    }
}
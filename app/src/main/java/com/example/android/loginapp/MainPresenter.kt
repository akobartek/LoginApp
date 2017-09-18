package com.example.android.loginapp

import kotlinx.android.synthetic.main.activity_main.*

class MainPresenter (private val view: MainView){

    fun onLoginInfoChanged(currentLogin: String, currentPassword: String) {
        if (checkLogin(currentLogin.trim()) && checkPassword(currentPassword.trim())) {
            view.enableLoginButton()
        } else {
            view.disableLoginButton()
        }
    }

    private fun checkLogin(sequence: CharSequence) =
            sequence.length > 2 && sequence.none { it.isWhitespace() } && sequence.none {
                it.isDigit()
            }

    private fun checkPassword(sequence: CharSequence) =
            sequence.length > 5 && sequence.any { it.isDigit() } && sequence.any { it.isUpperCase() }

    fun onLoginButtonClicked(currentLogin: String, currentPassword: String) {
        view.showLoading()
//                Thread.sleep(5000)
//                if (loginET.text.toString().trim() == login && passwordET.text.toString().trim() == password)
//                    Toast.makeText(applicationContext, "Logged in", Toast.LENGTH_SHORT).show()
//                else
//                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
//                loadingLayout.visibility = View.INVISIBLE
    }

}
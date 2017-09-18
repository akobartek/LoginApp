package com.example.android.loginapp

class MainPresenter(private val view: MainView) {

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
        view.hideKeyboard()
        view.showLoading()
        Thread.sleep(5000)
        if (currentLogin == "login" && currentPassword == "Passw0rd")
            view.showToast("Logged in")
        else
            view.showToast("Error")
        view.hideLoading()
    }
}
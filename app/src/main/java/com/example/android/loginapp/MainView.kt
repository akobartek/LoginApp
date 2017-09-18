package com.example.android.loginapp

interface MainView {

    fun enableLoginButton()
    fun disableLoginButton()
    fun showLoading()
    fun showToast(msg: String)
    fun hideLoading()
    fun hideKeyboard()
}
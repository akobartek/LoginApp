package com.example.android.loginapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textWatcher: TextWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                presenter.onLoginInfoChanged(loginET.text.toString(), passwordET.text.toString())
            }
        }
        loginET.addTextChangedListener(textWatcher)

        passwordET.addTextChangedListener(textWatcher)

        loginBtn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                presenter.onLoginButtonClicked(loginET.text.toString(), passwordET.text.toString())
            }
        })
    }

    override fun enableLoginButton() {
        loginBtn.isEnabled = true
    }

    override fun disableLoginButton() {
        loginBtn.isEnabled = false;
    }

    override fun showLoading() {
        loadingLayout.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loadingLayout.visibility = View.GONE
    }

    override fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }
}

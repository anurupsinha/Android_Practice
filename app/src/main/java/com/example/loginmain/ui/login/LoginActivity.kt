package com.example.loginmain.ui.login

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.View.OnHoverListener
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

import com.example.loginmain.R

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login2)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)

        //      getActionBar()?.setTitle("Login App")

        val login = findViewById<Button>(R.id.login)


        login.setOnClickListener{
            if (username.text.toString().isNotBlank() and password.text.toString().isNotBlank()) {

                if(username.text.toString().contains("@") && username.text.toString().endsWith(".com")){

                    if(password.text.toString().length >= 8) {

//                        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, SuccessPage::class.java)
                        startActivity(intent)
                    }
                }

                else
                    Toast.makeText(this, "Login with corrected credentials", Toast.LENGTH_SHORT).show()

                }

            else
                Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show()



        }

    }
}
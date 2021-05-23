package com.ankush.constraintlayout.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.ankush.constraintlayout.R
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
   val  MyPREFERENCES = "MyPrefs" ;
    var sharedpreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        register_text.setOnClickListener {
            var intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
        login_button.setOnClickListener{
            val email = edit_email.text.toString()
            val password = edit_password.text.toString()
            if(email==""){
                Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show()
            }
            else if(password==""){
                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()
            }
            else if(email==""&&password==""){
                Toast.makeText(this, "Please enter credentials", Toast.LENGTH_LONG).show()
            }
            else if(email=="ankushkumar9100@gmail.com"&&password=="admin@123"){
               val editor = sharedpreferences!!.edit()
                editor!!.putInt("success",1)
                editor!!.apply()
                editor!!.commit()
                var intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Invalid credentails credentials", Toast.LENGTH_LONG).show()

            }
        }
    }
}
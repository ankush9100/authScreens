package com.ankush.constraintlayout.ui.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ankush.constraintlayout.R
import com.ankush.constraintlayout.ui.Dashboard.DashboardActivity
import com.ankush.constraintlayout.ui.SignUp.SignupActivity
import com.ankush.constraintlayout.utils.Utlity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {
   val  MyPREFERENCES = "MyPrefs" ;
    var sharedpreferences: SharedPreferences? = null
    lateinit var mainActivityViewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val utility = Utlity()
        mainActivityViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
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
                edit_email.setError("Please enter email")
            }
            else if(password==""){
                edit_password.setError("Please enter password")
            }
            else if(email==""&&password==""){
                Toast.makeText(this, "Please enter credentials", Toast.LENGTH_LONG).show()
            }else if(!utility.isEmailValid(email)){
                edit_email.setError("Please enter a valid email address")
            }
            else if(password.length<6){
                edit_password.setError("Please enter a password greater than 6")
            }
            else{
                mainActivityViewModel.getUser(email,password)!!.observe(this, {
                    if (it.token != null) {
                        val editor = sharedpreferences!!.edit()
                        editor!!.putString("token", it.token)
                        editor!!.apply()
                        editor!!.commit()
                        var intent = Intent(this, DashboardActivity::class.java)
                        startActivity(intent)
                        finish()

                    }else{

                        Toast.makeText(this,"Invalid login credentials",Toast.LENGTH_LONG).show()
                    }
                })

//

            }
        }
    }


}
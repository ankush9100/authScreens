package com.ankush.constraintlayout.ui.SignUp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ankush.constraintlayout.R
import com.ankush.constraintlayout.ui.Dashboard.DashboardActivity
import com.ankush.constraintlayout.ui.login.LoginActivity
import com.ankush.constraintlayout.ui.login.LoginViewModel
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {
    val  MyPREFERENCES = "MyPrefs" ;
    var sharedpreferences: SharedPreferences? = null
    lateinit var mainActivityViewModel:CreateVendorViewModel
    lateinit var loginActivity:LoginViewModel
    private val foodType = ArrayList<String>()
    private  val coverImage=ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        login_text.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        foodType.add("Spicy")
        foodType.add("Sweet")
        coverImage.add("ll")

        mainActivityViewModel = ViewModelProvider(this).get(CreateVendorViewModel::class.java)
        btn_register.setOnClickListener {
            val name = editTextTextPersonName.text.toString()
            val ownerName = editTextOwnerName.text.toString()
            val pinCode = editTextPinCode.text.toString()
            val email = editTextemail.text.toString()
            val password = editTextTextPassword.text.toString()
            val phone = editTextPhone.text.toString()
            val address = editTextAddress.text.toString()
            mainActivityViewModel.createVendor(name,ownerName,foodType,pinCode,address,
            phone,email,password,serviceAvailable=false,rating=0
            ,coverImage)!!.observe(this,{
                loginActivity = ViewModelProvider(this).get(LoginViewModel::class.java)
                loginActivity.getUser(email,password)!!.observe(this,{
                    if(it.token!=null){
                        val editor = sharedpreferences!!.edit()
                        editor!!.putString("token",it.token)
                        editor!!.apply()
                        editor!!.commit()
                        var intent = Intent(this, DashboardActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                })

            })

        }

    }
}
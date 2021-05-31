package com.ankush.constraintlayout.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.widget.Toast
import com.ankush.constraintlayout.R
import com.ankush.constraintlayout.ui.Dashboard.DashboardActivity

class SplashActivity : AppCompatActivity() {
    var sharedPreferences: SharedPreferences? =  null
    val  MyPREFERENCES = "MyPrefs" ;
    var value: String?=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        sharedPreferences = this.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE)
        val successValue =  sharedPreferences?.getString("token",null)
         value = successValue



        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler().postDelayed({
           if(value!=null){
               val intent = Intent(this, DashboardActivity::class.java)
               startActivity(intent)
               finish()
           }else{
               val intent = Intent(this, MainActivity::class.java)
               startActivity(intent)
               finish()
           }


        }, 3000) // 30
    }
}
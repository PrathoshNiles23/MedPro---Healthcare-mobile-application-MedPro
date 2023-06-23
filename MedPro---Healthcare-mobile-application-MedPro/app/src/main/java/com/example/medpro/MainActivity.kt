package com.example.medpro

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.medpro.Controllers.UserC
import com.example.medpro.Models.User

class MainActivity : AppCompatActivity() {
    lateinit var register:Button
    lateinit var login:Button
    lateinit var email:EditText
    lateinit var password:EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        register = findViewById(R.id.btnSubmit1)
        login = findViewById(R.id.btnLogin)
        email = findViewById(R.id.edtFullname)
        password = findViewById(R.id.edtPassword)


        register.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))


        }

        login.setOnClickListener {
            var user = User()
            user.email = email.text.toString()
            user.password = password.text.toString()
            var db = UserC(applicationContext,"Medpro",null,1)

            if(user.email.isEmpty() || user.password.isEmpty()){
                Toast.makeText(applicationContext, "Fields can't be empty", Toast.LENGTH_LONG).show()
            }

            else{
                if(db.login(user.email,user.password) == 1){
                    Toast.makeText(applicationContext, "Logged In successfully", Toast.LENGTH_LONG).show()
                    var sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                    var editor = sharedPreferences.edit()
                    editor.putString("email",user.email)
                    editor.apply()

                    startActivity(Intent(this, HomeActivity::class.java))


                }
                else{
                    Toast.makeText(applicationContext, "Invalid Username / password", Toast.LENGTH_LONG).show()


                }

            }




        }




    }
}
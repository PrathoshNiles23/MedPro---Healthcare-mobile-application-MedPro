package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class UpdateActivity : AppCompatActivity() {
    lateinit var home: Button
    lateinit var email: TextView
    lateinit var name: EditText
    lateinit var phone: EditText
    lateinit var password: EditText
    lateinit var update: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        home = findViewById(R.id.btnHome)
        email = findViewById(R.id.Email)
        name = findViewById(R.id.Up_Name)
        phone = findViewById(R.id.Up_Phone)
        password = findViewById(R.id.Up_Password)
        update = findViewById(R.id.btnUpdate)
        var db = com.example.medpro.Controllers.UserC(applicationContext, "Medpro", null, 1)

        val sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE)
        val e = sharedPreferences.getString("email", "").toString()
        val x = db.getId(e)

        var a: com.example.medpro.Models.User = db.profile(e)

        name.setText(a.fullname)
        phone.setText(a.phone)
        password.setText(a.password)
        email.text = e


        update.setOnClickListener {

            a.fullname = name.text.toString()
            a.phone = phone.text.toString()
            a.password = password.text.toString()
            if (db.updateProfile(a)) {
                Toast.makeText(
                    applicationContext,
                    "Your account updated successfully",
                    Toast.LENGTH_LONG
                ).show()
                startActivity(Intent(this, UserProfileActivity::class.java))
            } else {
                Toast.makeText(applicationContext, "Could't update your account", Toast.LENGTH_LONG)
                    .show()

            }

        }

        home.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))

        }
    }
}
package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.medpro.Controllers.UserC



class UserProfileActivity : AppCompatActivity() {
    lateinit var update: Button
    lateinit var home: Button
    lateinit var fullname:EditText
    lateinit var email:EditText
    lateinit var phone: EditText
    lateinit var password:EditText
    lateinit var delete:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        update = findViewById(R.id.btnClickUpdate)
        home = findViewById(R.id.btnHome)
        fullname = findViewById(R.id.My_Name)
        email = findViewById(R.id.My_Email)
        phone = findViewById(R.id.My_Phone)
        password = findViewById(R.id.My_Password)
        delete = findViewById(R.id.btnDelete)
        var db = UserC(applicationContext, "Medpro", null, 1)

        val sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE)
        val e = sharedPreferences.getString("email", "").toString()

        var n = db.getId(e)
        print(n)

        var user = db.profile(e)
        fullname.setText(user.fullname)
        email.setText(e)
        phone.setText(user.phone)
        password.setText(user.password)

        delete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Delete Account")
            builder.setMessage("Are you sure you want to delete your account")
            builder.setPositiveButton("OK") { dialog, which ->

                if (db.delete(user)) {
                    Toast.makeText(
                        applicationContext,
                        "Your account has been deleted",
                        Toast.LENGTH_LONG
                    )
                    startActivity(Intent(this, RegisterActivity::class.java))

                } else {
                    Toast.makeText(
                        applicationContext,
                        "Couldn't delete your account",
                        Toast.LENGTH_LONG
                    )
                }

            }
            builder.setNegativeButton("Cancel"){dialog,which ->
                dialog.dismiss()

            }
            val dialog = builder.create()
            dialog.show()

        }




        update.setOnClickListener {
            startActivity(Intent(this, UpdateActivity::class.java))

        }

        home.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

    }

    fun displayAlert(title:String, message:String){
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton("OK") { dialog, which ->
// Do something when the "OK" button is clicked


        }
        val dialog = builder.create()
        dialog.show()
    }
    }

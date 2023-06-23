package com.example.medpro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.medpro.Controllers.UserC

class ShippingActivity : AppCompatActivity() {
    var t = ""
    lateinit var amount: EditText
    lateinit var pay:Button
    lateinit var home:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shipping)

        t = intent.getStringExtra("total").toString()
        amount = findViewById(R.id.Amount)
        amount.setText(t)
        
        pay = findViewById(R.id.btnSubmit1)
        home = findViewById(R.id.btnHome1)

        pay.setOnClickListener{
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        home.setOnClickListener{
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }




    }
}
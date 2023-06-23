package com.example.medpro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.annotation.SuppressLint
import android.content.Intent
import android.widget.Button
import androidx.cardview.widget.CardView

class DoctorActivity : AppCompatActivity() {
    lateinit var dentist:CardView
    lateinit var familyPhysician:CardView
    lateinit var cardiologist:CardView
    lateinit var dietician:CardView
    lateinit var button: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_doctor)
        familyPhysician = findViewById(R.id.FamilyPhysician)
        dentist=findViewById(R.id.dental)
        cardiologist=findViewById(R.id.CardioSurgeon)
        dietician=findViewById(R.id.diet)
        button=findViewById(R.id.button3)

        familyPhysician.setOnClickListener{
            val intent= Intent(this,FamilyPhysiciansActivity::class.java)
            startActivity(intent)
            finish()
        }

        cardiologist.setOnClickListener{
            val intent= Intent(this,CardiologistsActivity::class.java)
            startActivity(intent)
            finish()
        }

        dentist.setOnClickListener{
            val intent= Intent(this,DentistsActivity::class.java)
            startActivity(intent)
            finish()
        }

        dietician.setOnClickListener{
            val intent= Intent(this,DieticiansActivity::class.java)
            startActivity(intent)
            finish()
        }
        button.setOnClickListener{
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}
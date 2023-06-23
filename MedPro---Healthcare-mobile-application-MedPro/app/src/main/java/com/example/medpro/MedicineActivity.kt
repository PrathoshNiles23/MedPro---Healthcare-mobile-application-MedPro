package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.medpro.databinding.ActivityMainBinding

class MedicineActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var cough: CardView
    lateinit var diabetes:CardView
    lateinit var eye:CardView
    lateinit var gastric:CardView
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medicine)

        cough = findViewById(R.id.cardcough)
        diabetes = findViewById(R.id.carddiabetes)
        eye = findViewById(R.id.cardeye)
        gastric = findViewById(R.id.cardgastric)
        back=findViewById(R.id.btnHome)

        cough.setOnClickListener{
            val intent= Intent(this,CoughActivity::class.java)
            startActivity(intent)
            finish()
        }

        diabetes.setOnClickListener{
            val intent= Intent(this,DiabetesActivity::class.java)
            startActivity(intent)
            finish()
        }

        eye.setOnClickListener{
            val intent= Intent(this,GastricActivity::class.java)
            startActivity(intent)
            finish()
        }

        gastric.setOnClickListener{
            val intent= Intent(this,EyeMedicineActivity::class.java)
            startActivity(intent)
            finish()
        }

        back.setOnClickListener{
            val intent= Intent(this,::HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}
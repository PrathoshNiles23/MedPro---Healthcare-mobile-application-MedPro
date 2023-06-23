package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView
import com.example.medpro.databinding.ActivityLabBinding

class LabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLabBinding
    lateinit var body: CardView
    lateinit var glucose: CardView
    lateinit var immunity: CardView
    lateinit var thyroid: CardView
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityLabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab)

        body = findViewById(R.id.cardbody)
        glucose = findViewById(R.id.cardglucose)
        immunity = findViewById(R.id.cardimmunity)
        thyroid = findViewById(R.id.cardthyroid)
        back=findViewById(R.id.btnHome)

        body.setOnClickListener{
            val intent= Intent(this,BodyActivity::class.java)
            startActivity(intent)
            finish()
        }

        glucose.setOnClickListener{
            val intent= Intent(this,GlucoseFastingActivity::class.java)
            startActivity(intent)
            finish()
        }

        immunity.setOnClickListener{
            val intent= Intent(this,ImmunityActivity::class.java)
            startActivity(intent)
            finish()
        }

        thyroid.setOnClickListener{
            val intent= Intent(this,ThyroidCheckupActivity::class.java)
            startActivity(intent)
            finish()
        }

        back.setOnClickListener{
            val intent= Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}
package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Adapters.MyAdaptor
import com.example.medpro.Models.Model
import com.example.medpro.databinding.ActivityFamilyPhysiciansBinding

class FamilyPhysiciansActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFamilyPhysiciansBinding
    private lateinit var doctorArrayList: ArrayList<Model>
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding=ActivityFamilyPhysiciansBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back=findViewById<Button>(R.id.button)
        back.setOnClickListener{
            val intent= Intent(this,DoctorActivity::class.java)
            startActivity(intent)
            finish()
        }

        val img= intArrayOf(
            R.drawable.family1,R.drawable.family2,R.drawable.family3,R.drawable.family4
        )
        var docName= arrayOf(
            "Maddock Jude","Henry Peter","John Andrew","Aaron Alexander"
        )
        var hospital= arrayOf(
            "Cleveland Clinic Hospital","California Pacific Medical Center","WishyWave Hospital","Base Hospital"
        )
        var years= arrayOf(
            "6 years","7 years","10 years","5 years"
        )
        var fee= arrayOf(
            "5500.00","7800.00","3600.00","4200.00"
        )

        doctorArrayList=ArrayList()
        for(i in docName.indices){
            val user= Model(img[i],docName[i],hospital[i],years[i],fee[i])
            doctorArrayList.add(user)
        }
        binding.listView.isClickable=true
        binding.listView.adapter= MyAdaptor(this,doctorArrayList)

        binding.listView.setOnItemClickListener { parent, view, position, id ->

            val name=docName[position]
            val fee=fee[position]

            val i= Intent(this,BookAppointments::class.java)
            i.putExtra("docName",name)
            i.putExtra("fee",fee)
            startActivity(i)
        }
    }
}
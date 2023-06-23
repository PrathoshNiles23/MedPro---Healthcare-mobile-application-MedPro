package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SearchView
import com.example.medpro.Adapters.MyAdaptor
import com.example.medpro.Models.Model
import com.example.medpro.databinding.ActivityCardiologistsBinding

class CardiologistsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardiologistsBinding
    private lateinit var doctorArrayList: ArrayList<Model>
    lateinit var back: Button
    private lateinit var searchView: SearchView
    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding= ActivityCardiologistsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back=findViewById<Button>(R.id.button)
        back.setOnClickListener{
            val intent= Intent(this,DoctorActivity::class.java)
            startActivity(intent)
            finish()
        }

        val img= intArrayOf(
            R.drawable.cardio1,R.drawable.cardio2,R.drawable.cardio3,R.drawable.cardio4
        )
        val docName= arrayOf(
            "Harvey James","Benjamin Grey","Isaac Lee","Michael Kai"
        )
        val hospName= arrayOf(
            "Little Hearts","Asiri Central Heart Centre","Hope cardio thoracic theater LRH","Human heart valve and tissue bank"
        )
        val years= arrayOf(
            "6 years","9 years","11 years","15 years"
        )
        val fee= arrayOf(
            "10000.00","7500.00","6800.00","9000.00"
        )

        doctorArrayList=ArrayList()
        for(i in docName.indices){
            val user= Model(img[i],docName[i],hospName[i],years[i],fee[i])
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
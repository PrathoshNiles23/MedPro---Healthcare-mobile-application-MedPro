package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Adapters.MyAdaptor
import com.example.medpro.Models.Model
import com.example.medpro.databinding.ActivityDieticiansBinding

class DieticiansActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDieticiansBinding
    private lateinit var doctorArrayList: ArrayList<Model>
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding= ActivityDieticiansBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back=findViewById<Button>(R.id.button)
        back.setOnClickListener{
            val intent= Intent(this,DoctorActivity::class.java)
            startActivity(intent)
            finish()
        }

        val img= intArrayOf(
            R.drawable.diet1,R.drawable.diet2,R.drawable.diet3,R.drawable.diet4
        )
        val docName= arrayOf(
            "Sophia Jane","Mary Margret","Eden Rose","Adalyn Joy"
        )
        val hospName= arrayOf(
            "Alpha Health Care","Gold River Hospital","Serenity South Hills","New Path Health"
        )
        val years= arrayOf(
            "1 years","3 years","2 years","4 years"
        )
        val fee= arrayOf(
            "7200.00","4000.00","5500.00","9200.00"
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
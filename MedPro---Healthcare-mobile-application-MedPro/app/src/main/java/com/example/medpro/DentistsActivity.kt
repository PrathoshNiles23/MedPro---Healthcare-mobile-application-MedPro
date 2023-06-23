package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Adapters.MyAdaptor
import com.example.medpro.Models.Model
import com.example.medpro.databinding.ActivityDentistsBinding

class DentistsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDentistsBinding
    private lateinit var userArrayList: ArrayList<Model>
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        getSupportActionBar()?.hide()
        super.onCreate(savedInstanceState)
        binding= ActivityDentistsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back=findViewById<Button>(R.id.button)
        back.setOnClickListener{
            val intent= Intent(this,DoctorActivity::class.java)
            startActivity(intent)
            finish()
        }

        val img= intArrayOf(
            R.drawable.dentu,R.drawable.dent3,R.drawable.dent2,R.drawable.dent4
        )
        val docName= arrayOf(
            "Amelia Rose","Daisy Jade","Elizabeth Ann","Lily Grace"
        )
        val hospName= arrayOf(
            "Asiri Hospital","Durdans Hospital","Lanka Hospitals","Nawaloka Hospital"
        )
        val years= arrayOf(
            "4 years","2 years","5 years","3 years"
        )
        val fee= arrayOf(
            "2000.00","2500.00","3500.00","4000.00"
        )

        userArrayList=ArrayList()
        for(i in docName.indices){
            val user= Model(img[i],docName[i],hospName[i],years[i],fee[i])
            userArrayList.add(user)
        }
        binding.listView.isClickable=true
        binding.listView.adapter= MyAdaptor(this,userArrayList)

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

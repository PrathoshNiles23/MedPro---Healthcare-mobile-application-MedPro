package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Adapters.Medicine
import com.example.medpro.Models.MediModel
import com.example.medpro.databinding.ActivityGastricBinding

class GastricActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGastricBinding
    private lateinit var labArrayList: ArrayList<MediModel>
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gastric)

        getSupportActionBar()?.hide()
        binding = ActivityGastricBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back = findViewById<Button>(R.id.button)

        val mediname = arrayOf(
            "Omeprazole", "Lanzoprazole"
        )
        val description = arrayOf(
            "used to treat indigestion and acid burn","used to prevent and treat stomach ulcers"
        )

        val fee = arrayOf(
            "350", "450"
        )

        labArrayList = ArrayList()
        for (i in mediname.indices) {
            val user = MediModel(mediname[i], description[i], fee[i])
            labArrayList.add(user)
        }
        binding.listView.isClickable = true
        binding.listView.adapter = Medicine(this, labArrayList)

        binding.listView.setOnItemClickListener { parent, view, position, id ->

            val name = mediname[position]
            val fee = fee[position]

            val i= Intent(this,BuymedicineActivity::class.java)
            i.putExtra("labName",name)
            i.putExtra("fee",fee)
            startActivity(i)
        }

        back.setOnClickListener{
            val intent= Intent(this,MedicineActivity::class.java)
            startActivity(intent)
            finish()
        }
    }




}
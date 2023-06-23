package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Controllers.LabAdapter
import com.example.medpro.Models.Lab
import com.example.medpro.Models.LabModel
import com.example.medpro.databinding.ActivityBodyBinding

class BodyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBodyBinding
    private lateinit var labArrayList: ArrayList<LabModel>
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_body)

        getSupportActionBar()?.hide()
        binding = ActivityBodyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back = findViewById<Button>(R.id.button)

        val labName = arrayOf(
            "MRI", "Blood Test", "Liver Function Tests", "Urinalysis"
        )
        val description = arrayOf(
            "Magnetic resonance imaging is a medical imaging technique used in radiology to form pictures of the anatomy and the physiological processes of the body. MRI scanners use strong magnetic fields, magnetic field gradients, and radio waves to generate images of the organs in the body.",
            "A blood test is a laboratory analysis performed on a blood sample that is usually extracted from a vein in the arm using a hypodermic needle, or via fingerprick",
            "Liver function tests, also referred to as a hepatic panel, are groups of blood tests that provide information about the state of a patient's liver. These tests include prothrombin time, activated partial thromboplastin time, albumin, bilirubin, and others.",
            "Urinalysis, a portmanteau of the words urine and analysis, is a panel of medical tests that includes physical examination of the urine, chemical evaluation using urine test strips, and microscopic examination."
        )

        val fee = arrayOf(
            "10000.00", "7500.00", "6800.00", "9000.00"
        )

        labArrayList = ArrayList()
        for (i in labName.indices) {
            val user = LabModel(labName[i], description[i], fee[i])
            labArrayList.add(user)
        }
        binding.listView.isClickable = true
        binding.listView.adapter = com.example.medpro.Adapters.Lab(this, labArrayList)

        binding.listView.setOnItemClickListener { parent, view, position, id ->

            val name = labName[position]
            val fee = fee[position]

            val i= Intent(this,BookAppointmentActivity::class.java)
            i.putExtra("labName",name)
            i.putExtra("fee",fee)
            startActivity(i)
        }

        back.setOnClickListener{
            val intent= Intent(this,LabActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
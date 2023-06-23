package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Adapters.Lab
import com.example.medpro.Models.LabModel
import com.example.medpro.databinding.ActivityImmunityBinding

class ImmunityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImmunityBinding
    private lateinit var labArrayList: ArrayList<LabModel>
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_immunity)

        getSupportActionBar()?.hide()
        binding = ActivityImmunityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back = findViewById<Button>(R.id.button)

        val labName = arrayOf(
            "Antibody deficiencies", "Cellular (T cell) defects", "Neutrophil disorders", "Complement deficiencies"
        )
        val description = arrayOf(
            "The standard screening tests for humoral immune function starts with measurement of immunoglobulin (Ig), or antibody, levels in the blood serum. These consist of IgG, IgA, IgM, and sometimes IgE levels.",
            "The laboratory evaluation of cellular or T cell immunity focuses on determining the numbers of different types of T cells and evaluating the function of these cells. ",
            "The laboratory evaluation of the neutrophil begins by obtaining a series of white blood cell counts (WBC) with differentials. The WBC and differential will determine if there is a decline in the absolute neutrophil count (neutropenia).",
            "The standard screening test for deficiencies in the complement system is the total hemolytic complement assay or CH50. In situations with a defect in one complement component, the CH50 will be almost completely negative."
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
        binding.listView.adapter = Lab(this, labArrayList)

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
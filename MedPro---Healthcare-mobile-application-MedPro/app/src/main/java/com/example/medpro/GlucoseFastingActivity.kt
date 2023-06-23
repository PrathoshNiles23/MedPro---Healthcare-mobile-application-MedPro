package com.example.medpro

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Adapters.Lab
import com.example.medpro.Models.LabModel
import com.example.medpro.databinding.ActivityGlucoseFastingBinding

class GlucoseFastingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGlucoseFastingBinding
    private lateinit var labArrayList: ArrayList<LabModel>
    lateinit var back: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glucose_fasting)

        getSupportActionBar()?.hide()
        binding = ActivityGlucoseFastingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back = findViewById(R.id.button)

        val labName = arrayOf(
            "Fasting Blood Sugar Test",
            "Glucose Tolerance Test",
            "Random Blood Sugar Test",
            "Tests for Gestational Diabetes"
        )
        val description = arrayOf(
            "This measures your blood sugar after an overnight fast (not eating). A fasting blood sugar level of 99 mg/dL or lower is normal, 100 to 125 mg/dL indicates you have prediabetes, and 126 mg/dL or higher indicates you have diabetes.",
            "This measures your blood sugar before and after you drink a liquid that contains glucose. You’ll fast (not eat) overnight before the test and have your blood drawn to determine your fasting blood sugar level. ",
            "This measures your blood sugar at the time you’re tested. You can take this test at any time and don’t need to fast (not eat) first. A blood sugar level of 200 mg/dL or higher indicates you have diabetes.",
            "Gestational diabetes is diagnosed using blood tests. You’ll probably be tested between 24 and 28 weeks of pregnancy. If your risk is higher for getting gestational diabetes (due to having more risk factors), your doctor may test you earlier."
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
package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Adapters.Medicine
import com.example.medpro.Models.MediModel
import com.example.medpro.databinding.ActivityCoughBinding

class CoughActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoughBinding
    private lateinit var labArrayList: ArrayList<MediModel>
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cough)

        getSupportActionBar()?.hide()
        binding = ActivityCoughBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back = findViewById<Button>(R.id.button)

        val labName = arrayOf(
            "Acetaminophen", "Levocetirizine"
        )
        val description = arrayOf(
            "used to releive cough and fever","usedto releive the symptoms of highfever,running nose,cough and cold"
        )

        val fee = arrayOf(
            "400", "500"
        )

        labArrayList = ArrayList()
        for (i in labName.indices) {
            val user = MediModel(labName[i], description[i], fee[i])
            labArrayList.add(user)
        }
        binding.listView.isClickable = true
        binding.listView.adapter = Medicine(this, labArrayList)

        binding.listView.setOnItemClickListener { parent, view, position, id ->

            val name = labName[position]
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
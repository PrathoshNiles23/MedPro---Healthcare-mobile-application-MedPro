package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medpro.Adapters.Lab
import com.example.medpro.Models.LabModel
import com.example.medpro.databinding.ActivityThyroidCheckupBinding

class ThyroidCheckupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThyroidCheckupBinding
    private lateinit var labArrayList: ArrayList<LabModel>
    lateinit var back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thyroid_checkup)


        getSupportActionBar()?.hide()
        binding = ActivityThyroidCheckupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        back = findViewById<Button>(R.id.button)

        val labName = arrayOf(
            "Thyroid antibody tests", "Ultrasound", "Thyroid scan", "Radioactive iodine uptake test"
        )
        val description = arrayOf(
            "Measuring levels of thyroid antibodies may help diagnose an autoimmune thyroid disorder such as Graves’ disease—the most common cause of hyperthyroidism—and Hashimoto’s disease—the most common cause of hypothyroidism.",
            "Ultrasound of the thyroid is most often used to look for, or more closely at, thyroid nodules. Thyroid nodules are lumps in your neck. Ultrasound can help your doctor tell if the nodules are more likely to be cancerous.",
            "Health care professionals use a thyroid scan to look at the size, shape, and position of the thyroid gland.This test uses a small amount of radioactive iodine to help find the cause of hyperthyroidism and check for thyroid nodules.",
            "A radioactive iodine uptake test, also called a thyroid uptake test, can help check thyroid function and find the cause of hyperthyroidism. The thyroid “takes up” iodine from the blood to make thyroid hormones, which is why this is called an uptake test."
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
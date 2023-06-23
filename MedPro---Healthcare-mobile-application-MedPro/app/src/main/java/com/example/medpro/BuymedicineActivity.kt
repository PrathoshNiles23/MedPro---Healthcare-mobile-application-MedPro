package com.example.medpro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medpro.Adapters.RecycleViewAdapter
import com.example.medpro.Adapters.RecyclerViewMedicine
import com.example.medpro.Controllers.MedicineAdaptor
import com.example.medpro.databinding.ActivityBuymedicineBinding
import kotlin.properties.Delegates

class BuymedicineActivity : AppCompatActivity() {
    private var adapterTransaction by Delegates.notNull<RecyclerViewMedicine>()
    var dbhelper = MedicineAdaptor(this).TABLE_LABTESTS()
    var id_data = ""
    private lateinit var binding:ActivityBuymedicineBinding
    private lateinit var button: Button
    var t:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        binding=ActivityBuymedicineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button=findViewById(R.id.GoToCart)
        button.setOnClickListener{
            val intent= Intent(this,activityChcekout::class.java)
            intent.putExtra("total",t.toString())
            startActivity(intent)
            finish()
        }

        try {
            GET_DATA_PERSONE()

            val edpname=findViewById<EditText>(R.id.ED_PNAME)
            val eddname = findViewById<EditText>(R.id.ED_DNAME)
            val dname=intent.getStringExtra("labName")
            eddname.setText(dname)
            val edfee = findViewById<EditText>(R.id.ED_FEE)
            val fee=intent.getStringExtra("fee")
            edfee.setText(fee)
            val btn_add = findViewById<Button>(R.id.BTN_ADD)
            btn_add.setOnClickListener {
                try {
                    if (id_data == "") {
                        if (edpname.text.toString().trim() != "") {
                            ADD_DOCTOR(
                                edpname.text.toString().trim(),
                                eddname.text.toString().trim(),
                                edfee.text.toString().trim(),
                            )
                            Handler().postDelayed({
                                val edpname = findViewById<EditText>(R.id.ED_PNAME).setText("")
                                val eddname = findViewById<EditText>(R.id.ED_DNAME).setText("")
                                val edfee = findViewById<EditText>(R.id.ED_FEE).setText("")
                                Toast.makeText(
                                    this,
                                    "Added successfully",
                                    Toast.LENGTH_SHORT
                                ).show()
                                GET_DATA_PERSONE()
                            }, 1000)
                        } else {
                            Toast.makeText(
                                this,
                                "Please enter your name",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    } else {
                        if (edpname.text.toString().trim() != "") {
                            UPDATE_DATA(
                                id_data,
                                edpname.text.toString().trim(),
                                eddname.text.toString().trim(),
                                edfee.text.toString().trim(),
                            )
                            Handler().postDelayed({
                                val edpname = findViewById<EditText>(R.id.ED_PNAME).setText("")
                                val eddname = findViewById<EditText>(R.id.ED_DNAME).setText("")
                                val edfee = findViewById<EditText>(R.id.ED_FEE).setText("")
                                val btn_add = findViewById<Button>(R.id.BTN_ADD)
                                btn_add.setText("Add")
                                id_data = ""
                                Toast.makeText(
                                    this,
                                    "Update successfully",
                                    Toast.LENGTH_SHORT
                                ).show()
                                GET_DATA_PERSONE()
                            }, 1000)
                        } else {
                            Toast.makeText(
                                this,
                                "Please enter name",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                } catch (e: Exception) {
                    Toast.makeText(
                        this,
                        "e.toString()",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        } catch (e: Exception) {
            Log.d(" Data Error ", e.toString())
        }

    }

    private fun ADD_DOCTOR(
        pname: String,
        dname: String,
        fee:String,
    ) {
        var addperson = dbhelper.ADD_DATA_LABTESTS(pname, dname, fee)
    }

    private fun GET_DATA_PERSONE() {
        try {
            var dataPerson = dbhelper.GET_DATA_LABTESTS()
            t = dbhelper.total
            adapterTransaction = RecyclerViewMedicine(
                this,
                dataPerson,
                this
            )
            Toast.makeText(
                this,
                "Update successfully $t",
                Toast.LENGTH_SHORT
            ).show()
            val rvmain = findViewById<RecyclerView>(R.id.rv_main)

            rvmain.layoutManager = LinearLayoutManager(this@BuymedicineActivity)
            rvmain.adapter = adapterTransaction

        } catch (e: Exception) {
            Log.e("Error : ", e.toString())
        }
    }

    fun DELETE_DATA(id: String) {
        try {
            Log.d("id :", id)
            var dataPerson = dbhelper.DELETE_DATA_LABTESTS(id)
            Handler().postDelayed({
                Toast.makeText(
                    this,
                    "Delete successfully",
                    Toast.LENGTH_SHORT
                ).show()
                GET_DATA_PERSONE()
            }, 1000)
        } catch (e: Exception) {

        }
    }

    private fun UPDATE_DATA(
        id: String,
        pname: String,
        dname: String,
        fee:String,
    ) {
        var dataPerson = dbhelper.UPDATE_DATA_LABTESTS(id, pname, dname, fee)
    }

    fun DATA_FROM_RECYCLEVIEW(
        id: String,
        pname: String,
        dname: String,
        fee: Int,
    ) {

        id_data = id
        val btn_add = findViewById<Button>(R.id.BTN_ADD)
        btn_add.setText("Update")
        val edname = findViewById<EditText>(R.id.ED_PNAME).setText(pname)
        val eddname=findViewById<EditText>(R.id.ED_DNAME).setText(dname)
        val edfee = findViewById<EditText>(R.id.ED_FEE).setText(fee)
    }

}

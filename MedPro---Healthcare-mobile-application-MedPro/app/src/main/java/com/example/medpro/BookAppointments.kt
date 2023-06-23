package com.example.medpro

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
import com.example.medpro.Controllers.dbAdaptorDoctor
import com.example.medpro.databinding.ActivityBookAppointmentsBinding
import kotlin.properties.Delegates

class BookAppointments : AppCompatActivity() {
    private var adapterTransaction by Delegates.notNull<RecycleViewAdapter>()
    var dbhelper = dbAdaptorDoctor(this).TABLE_APPOINTMENT()
    var id_data = ""
    private lateinit var binding:ActivityBookAppointmentsBinding

    //var total = dbhelper.total()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        binding=ActivityBookAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)




        try {
            GET_DATA_PERSONE()

            val edpname=findViewById<EditText>(R.id.ED_PNAME)
            val eddname = findViewById<EditText>(R.id.ED_DNAME)
            val dname=intent.getStringExtra("docName")
            eddname.setText(dname)
            val edfee = findViewById<EditText>(R.id.ED_FEE)
            val fee=intent.getStringExtra("fee")
            edfee.setText(fee)
            val eddate = findViewById<EditText>(R.id.ED_DATE)
            var edtime=findViewById<EditText>(R.id.ED_TIME)
            val btn_add = findViewById<Button>(R.id.BTN_ADD)
            btn_add.setOnClickListener {
                try {
                    if (id_data == "") {
                        if (edpname.text.toString().trim() != "") {
                            ADD_DOCTOR(
                                edpname.text.toString().trim(),
                                eddname.text.toString().trim(),
                                edfee.text.toString().trim(),
                                eddate.text.toString().trim(),
                                edtime.text.toString().trim(),
                            )
                            Handler().postDelayed({
                                val edpname = findViewById<EditText>(R.id.ED_PNAME).setText("")
                                val eddname = findViewById<EditText>(R.id.ED_DNAME).setText("")
                                val edfee = findViewById<EditText>(R.id.ED_FEE).setText("")
                                val eddate = findViewById<EditText>(R.id.ED_DATE).setText("")
                                val edtime = findViewById<EditText>(R.id.ED_TIME).setText("")
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
                                eddate.text.toString().trim(),
                                edtime.text.toString().trim(),
                            )
                            Handler().postDelayed({
                                val edpname = findViewById<EditText>(R.id.ED_PNAME).setText("")
                                val eddname = findViewById<EditText>(R.id.ED_DNAME).setText("")
                                val edfee = findViewById<EditText>(R.id.ED_FEE).setText("")
                                val eddate = findViewById<EditText>(R.id.ED_DATE).setText("")
                                val edtime = findViewById<EditText>(R.id.ED_TIME).setText("")
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
        date:String,
        time:String
    ) {
        var addperson = dbhelper.ADD_DATA_APPOINTMENT(pname, dname, fee,date,time)
    }

    private fun GET_DATA_PERSONE() {
        try {
            var dataPerson = dbhelper.GET_DATA_APPOINTMENT()
            //var total = dbhelper.total()

            adapterTransaction = RecycleViewAdapter(
                this,
                dataPerson,
                this
            )
            val rvmain = findViewById<RecyclerView>(R.id.rv_main)

            rvmain.layoutManager = LinearLayoutManager(this@BookAppointments)
            rvmain.adapter = adapterTransaction

        } catch (e: Exception) {
            Log.e("Error : ", e.toString())
        }
    }

    fun DELETE_DATA(id: String) {
        try {
            Log.d("id :", id)
            var dataPerson = dbhelper.DELETE_DATA_APPOINTMENT(id)
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
        date:String,
        time:String
    ) {
        var dataPerson = dbhelper.UPDATE_DATA_APPOINTMENT(id, pname, dname, fee,date,time)
    }

    fun DATA_FROM_RECYCLEVIEW(
        id: String,
        pname: String,
        dname: String,
        fee:String,
        date:String,
        time:String
    ) {

        id_data = id
        val btn_add = findViewById<Button>(R.id.BTN_ADD)
        btn_add.setText("Update")
        val edname = findViewById<EditText>(R.id.ED_PNAME).setText(pname)
        val eddname=findViewById<EditText>(R.id.ED_DNAME).setText(dname)
        val edfee = findViewById<EditText>(R.id.ED_FEE).setText(fee)
        val eddate = findViewById<EditText>(R.id.ED_DATE).setText(date)
        val edtime=findViewById<EditText>(R.id.ED_TIME).setText(time)
    }



}
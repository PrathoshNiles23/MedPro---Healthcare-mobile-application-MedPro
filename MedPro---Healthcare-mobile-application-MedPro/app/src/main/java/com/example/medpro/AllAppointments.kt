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
import com.example.medpro.Adapters.DoctorsListAdapter
import com.example.medpro.Controllers.dbAdaptorDoctor
import com.example.medpro.databinding.ActivityAllAppointmentsBinding
import kotlin.properties.Delegates

class AllAppointments : AppCompatActivity() {
    private var adapterTransaction by Delegates.notNull<DoctorsListAdapter>()
    var dbhelper = dbAdaptorDoctor(this).TABLE_APPOINTMENT()
    var id_data = ""

    private lateinit var binding: ActivityAllAppointmentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        binding=ActivityAllAppointmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try {
            GET_DATA_PERSONE()


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

            adapterTransaction = DoctorsListAdapter(
                this,
                dataPerson,
                this
            )
            val rvmain = findViewById<RecyclerView>(R.id.rv_doctor)

            rvmain.layoutManager = LinearLayoutManager(this@AllAppointments)
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
        Date:String,
        Time:String
    ) {

        id_data = id
        val btn_add = findViewById<Button>(R.id.BTN_ADD)
        btn_add.setText("Update")
        val edname = findViewById<EditText>(R.id.ED_PNAME).setText(pname)
        val eddname=findViewById<EditText>(R.id.ED_DNAME).setText(dname)
        val edfee = findViewById<EditText>(R.id.ED_FEE).setText(fee)
        val eddate=findViewById<EditText>(R.id.ED_DATE).setText(Date)
        val edtime=findViewById<EditText>(R.id.ED_TIME).setText(Time)
    }
}
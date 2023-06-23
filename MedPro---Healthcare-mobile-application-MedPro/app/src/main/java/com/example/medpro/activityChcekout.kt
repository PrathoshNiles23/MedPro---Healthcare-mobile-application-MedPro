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
import com.example.medpro.Adapters.RecyclerViewCheckout
import com.example.medpro.Controllers.MedicineAdaptor
import com.example.medpro.databinding.ActivityChcekoutBinding
import kotlin.properties.Delegates

class activityChcekout : AppCompatActivity() {
    private var adapterTransaction by Delegates.notNull<RecyclerViewCheckout>()
    var dbhelper = MedicineAdaptor(this).TABLE_LABTESTS()
    var id_data = ""

    private lateinit var binding: ActivityChcekoutBinding
    lateinit var checkout: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        var t = ""

        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        binding=ActivityChcekoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkout = findViewById(R.id.checkout)

        t = intent.getStringExtra("total").toString()
        checkout.setOnClickListener{
            val intent= Intent(this,ShippingActivity::class.java)
            intent.putExtra("total",t)
            startActivity(intent)
            finish()
        }





        Toast.makeText(
            this,
            "Added successfully $t",
            Toast.LENGTH_SHORT
        ).show()


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
    ) {
        var addperson = dbhelper.ADD_DATA_LABTESTS(pname, dname, fee)
    }

    private fun GET_DATA_PERSONE() {
        try {
            var dataPerson = dbhelper.GET_DATA_LABTESTS()

            adapterTransaction = RecyclerViewCheckout(
                this,
                dataPerson,
                this
            )
            val rvmain = findViewById<RecyclerView>(R.id.rv_main)

            rvmain.layoutManager = LinearLayoutManager(this@activityChcekout)
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
        fee:String,
    ) {

        id_data = id
        val btn_add = findViewById<Button>(R.id.BTN_ADD)
        btn_add.setText("Update")
        val edname = findViewById<EditText>(R.id.ED_PNAME).setText(pname)
        val eddname=findViewById<EditText>(R.id.ED_DNAME).setText(dname)
        val edfee = findViewById<EditText>(R.id.ED_FEE).setText(fee)
    }

}

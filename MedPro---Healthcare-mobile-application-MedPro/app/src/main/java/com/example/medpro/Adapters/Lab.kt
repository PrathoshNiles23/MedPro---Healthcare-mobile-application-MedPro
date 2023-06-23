package com.example.medpro.Adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.medpro.Models.LabModel
import com.example.medpro.R

class  Lab(private val context: Activity, private val arrayList: ArrayList<LabModel>):
    ArrayAdapter<LabModel>(context,
        R.layout.row1,arrayList)
{
    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View =inflater.inflate(R.layout.labtest,null)


        val labName: TextView =view.findViewById(R.id.labName)
        val description: TextView =view.findViewById(R.id.desc)
        val fees: TextView =view.findViewById(R.id.fee)

        labName.text = arrayList[position].Name
        description.text = arrayList[position].description
        fees.text=arrayList[position].fee

        return view
    }

}
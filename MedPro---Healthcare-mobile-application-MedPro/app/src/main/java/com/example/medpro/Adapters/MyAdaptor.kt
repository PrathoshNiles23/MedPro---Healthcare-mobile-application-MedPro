package com.example.medpro.Adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.medpro.Models.Model
import com.example.medpro.R

class MyAdaptor(private val context: Activity, private val arrayList: ArrayList<Model>):
    ArrayAdapter<Model>(context,
    R.layout.row,arrayList)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View =inflater.inflate(R.layout.row,null)

        val imageview: ImageView =view.findViewById(R.id.doctor)
        val doctorName: TextView =view.findViewById(R.id.docName)
        val hospital: TextView =view.findViewById(R.id.hospitalName)
        val experience: TextView =view.findViewById(R.id.yearsOfExp)
        val fees: TextView =view.findViewById(R.id.fee)

        imageview.setImageResource(arrayList[position].img)
        doctorName.text=arrayList[position].docName
        hospital.text=arrayList[position].hospName
        experience.text=arrayList[position].years
        fees.text=arrayList[position].fee

        return view
    }
}
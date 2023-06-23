package com.example.medpro.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.medpro.Models.Medi
import com.example.medpro.R
import com.example.medpro.activityChcekout

class RecyclerViewCheckout(

    private val context: Context,
    private var resultTransaction: List<Medi>,
    private val activity: activityChcekout

) : RecyclerView.Adapter<RecyclerViewCheckout.ViewHolderTransaction>() {
    private val TAG = javaClass.simpleName

    companion object {
        private const val VIEW_TYPE_DATA = 0;
        private const val VIEW_TYPE_PROGRESS = 1;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTransaction {
        return when (viewType) {
            VIEW_TYPE_DATA -> {//inflates row layout
                val view = LayoutInflater.from(parent?.context)
                    .inflate(R.layout.medicine_checkout, parent, false)
                ViewHolderTransaction(view)
            }
            VIEW_TYPE_PROGRESS -> {//inflates progressbar layout
                val view = LayoutInflater.from(parent?.context)
                    .inflate(R.layout.medicine_checkout, parent, false)
                ViewHolderTransaction(view)
            }
            else -> throw IllegalArgumentException("Different View type")
        }
    }

    override fun getItemCount(): Int = resultTransaction.size

    fun refreshAdapter(resultTransaction: List<Medi>) {
        this.resultTransaction = resultTransaction
        notifyItemRangeChanged(0, this.resultTransaction.size)
    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(
        holder: ViewHolderTransaction,
        position: Int
    ) {
        val txtPname: TextView
        val txtDname: TextView
        val txtFee: TextView

        txtPname = holder.itemView.findViewById(R.id.TXT_PNAME) as TextView
        txtDname = holder.itemView.findViewById(R.id.TXT_DNAME) as TextView
        txtFee = holder.itemView.findViewById(R.id.TXT_FEE) as TextView

        if (holder.itemViewType == VIEW_TYPE_DATA) {
            val resultItem = resultTransaction[position]
            txtPname.text = resultItem.Name
            txtDname.text = resultItem.medicine
            txtFee.text = resultItem.fee.toString()


        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (resultTransaction[position] == null) {
            VIEW_TYPE_PROGRESS
        } else {
            VIEW_TYPE_DATA
        }
    }

    inner class ViewHolderTransaction(itemView: View?) : RecyclerView.ViewHolder(itemView!!)
}
package com.kargo.tech.ui.jobcard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kargo.tech.R
import com.kargo.tech.databinding.ItemJobCardBinding
import com.kargo.tech.models.KargoJob
import com.kargo.tech.ui.common.ListItemClickListener
import java.util.*
import kotlin.collections.ArrayList

class JobListAdapter(val clickListener:ListItemClickListener): RecyclerView.Adapter<JobListAdapter.Holder>() {
    val jobList = ArrayList<KargoJob>()

    class Holder(val binding:ItemJobCardBinding) :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_job_card, parent, false))
    }

    fun appendData(dataList:ArrayList<KargoJob>){
        val i = jobList.size
        jobList.addAll(dataList)
        notifyItemRangeInserted(i, dataList.size)
    }

    fun sortByPrice(order:Int){
        if(order==1) {
            jobList.sortBy { it.price }
        }else{
            jobList.sortByDescending { it.price }
        }
        notifyDataSetChanged()
    }
    fun sortByDate(order:Int){
        if(order==1) {
            jobList.sortBy { it.date }
        }else{
            jobList.sortByDescending { it.date }
        }
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val kargoJob = jobList[position]
        holder.binding.job = kargoJob
    }

    override fun getItemCount(): Int {
        return jobList.size
    }
}
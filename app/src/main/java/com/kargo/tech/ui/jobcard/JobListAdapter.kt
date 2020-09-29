package com.kargo.tech.ui.jobcard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kargo.tech.R
import com.kargo.tech.databinding.ItemJobCardBinding
import com.kargo.tech.models.entities.JobUtils
import com.kargo.tech.models.entities.KargoJob

class JobListAdapter(
    val clickListener: JobListActivity,
    val sortOrderPrice: Int?,
    val value1: Int?
) : RecyclerView.Adapter<JobListAdapter.Holder>() {
    val jobList = ArrayList<KargoJob>()

    class Holder(val binding: ItemJobCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_job_card,
                parent,
                false
            )
        )
    }


    fun appendData(dataList: ArrayList<KargoJob>) {
        val i = jobList.size
        jobList.addAll(dataList)
        sortByTime(value1)
        sortByPrice(sortOrderPrice)
        notifyItemRangeInserted(i, dataList.size)
    }

    fun sortByPrice(order: Int?) {
        JobUtils.sortByPrice(jobList, order)
        if (order == 1 || order == -1)
            notifyDataSetChanged()
    }

    fun sortByTime(order: Int?) {
        JobUtils.sortByTime(jobList, order)
        if (order == 1 || order == -1)
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
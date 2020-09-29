package com.kargo.tech.ui.jobcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kargo.tech.R
import com.kargo.tech.databinding.ActivityJobListBinding
import kotlinx.android.synthetic.main.activity_job_list.*

class JobListActivity : AppCompatActivity() {
    lateinit var jobViewModel:JobViewModel
    lateinit var adapter:JobListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityJobListBinding>(this, R.layout.activity_job_list)
        binding.lifecycleOwner = this
        jobViewModel = ViewModelProvider(this).get(JobViewModel::class.java)
        binding.jobVM = jobViewModel
    }


    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        if(jobViewModel.list.value==null){
            jobViewModel.getList()
        }
        rv_jobs.layoutManager  = LinearLayoutManager(this)
        adapter = JobListAdapter(this, jobViewModel.sortPrice.value, jobViewModel.sortDate.value)
        rv_jobs.adapter = adapter
        jobViewModel.list.observe(this, {
            adapter.appendData(it)
        })
        jobViewModel.error.observe(this, {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        jobViewModel.sortPrice.observe(this, {
            jobViewModel.sortDate.value = 0
            adapter.sortByPrice(it)
        })
        jobViewModel.sortDate.observe(this, {
            jobViewModel.sortPrice.value = 0
            adapter.sortByDate(it)
        })
    }

    public fun sort(v: View){
        when(v.id){
            R.id.btn_date->{
                jobViewModel.sortDate.value = jobViewModel.sortDate.value?.times(-1)
            }
            R.id.btn_price->{
                jobViewModel.sortPrice.value = jobViewModel.sortPrice.value?.times(-1)
            }
        }
    }
}
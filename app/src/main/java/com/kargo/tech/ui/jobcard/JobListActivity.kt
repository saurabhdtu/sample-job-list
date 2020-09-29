package com.kargo.tech.ui.jobcard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kargo.tech.R
import com.kargo.tech.databinding.ActivityJobListBinding

class JobListActivity : AppCompatActivity() {
    lateinit var jobViewModel:JobViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityJobListBinding>(this, R.layout.activity_job_list)
        binding.lifecycleOwner = this
        jobViewModel = ViewModelProvider(this).get(JobViewModel::class.java)
        binding.jobVM = jobViewModel
    }


    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)

    }

    public fun sort(v: View){
        when(v.id){
            R.id.btn_date->{

            }
            R.id.btn_price->{

            }
        }
    }
}
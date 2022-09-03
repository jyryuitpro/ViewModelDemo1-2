package com.example.viewmodeldemo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Please do "Build => Clean Project" and "Build => Rebuild Project" before run the code 

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        binding.myViewModel = viewModel

//        binding.countText.text = viewModel.getCurrentCount().toString()
        viewModel.count.observe(this, Observer {
            binding.countText.text = it.toString()
        })

//        binding.button.setOnClickListener {
//            binding.countText.text = viewModel.getUpdatedCount().toString()
            viewModel.updateCount()
//        }
    }
}
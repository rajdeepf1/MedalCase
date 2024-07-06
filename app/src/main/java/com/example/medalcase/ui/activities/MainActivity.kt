package com.example.medalcase.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.medalcase.R
import com.example.medalcase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}
package com.rikkeisoft.navigation_component.container

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rikkeisoft.navigation_component.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        finish()
    }
}
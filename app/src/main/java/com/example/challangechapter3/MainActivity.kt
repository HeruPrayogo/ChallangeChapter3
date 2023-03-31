package com.example.challangechapter3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challangechapter3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentHomePageBinding = HomePageFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, fragmentHomePageBinding)
            .commit()
    }
}
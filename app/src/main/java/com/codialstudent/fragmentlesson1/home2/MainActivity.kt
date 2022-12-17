package com.codialstudent.fragmentlesson1.home2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codialstudent.fragmentlesson1.R
import com.codialstudent.fragmentlesson1.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment1 = Fragment1()
        val supportFragmentManager = supportFragmentManager
        supportFragmentManager.beginTransaction()
            .add(R.id.my_container, fragment1)
            .commit()
    }
}
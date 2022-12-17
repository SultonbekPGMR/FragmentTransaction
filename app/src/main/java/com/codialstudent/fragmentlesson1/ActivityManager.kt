package com.codialstudent.fragmentlesson1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.codialstudent.fragmentlesson1.databinding.ActivityManagerBinding
import com.codialstudent.fragmentlesson1.home1.MainActivity

class ActivityManager : AppCompatActivity() {
    private lateinit var binding: ActivityManagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tv1.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.tv2.setOnClickListener {
            startActivity(Intent(this, com.codialstudent.fragmentlesson1.home2.MainActivity::class.java))
        }
        binding.tv3.setOnClickListener {
            startActivity(Intent(this, com.codialstudent.fragmentlesson1.home3.MainActivity3::class.java))
        }

    }
}
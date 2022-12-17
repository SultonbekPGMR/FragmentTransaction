package com.codialstudent.fragmentlesson1.home3

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codialstudent.fragmentlesson1.R
import com.codialstudent.fragmentlesson1.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var stateAdded = false
        var stateFragment1 = false
        var stateFragment1Hided = false
        val firstFragment = FragmentFirst()
        val secondFragment = FragmentSecond()

        val supportFragmentManager = supportFragmentManager

        // ADD
        binding.btnAdd.setOnClickListener {
            if (stateAdded) {
                Toast.makeText(this, "Fragment Already added", Toast.LENGTH_SHORT).show()
            } else {
                supportFragmentManager.beginTransaction()
                    .add(R.id.home_3_container, firstFragment)
                    .commit()
                stateAdded = true
                stateFragment1 = true
            }


        }

        // REPLACE
        binding.btnReplace.setOnClickListener {
            if (!stateAdded) {
                Toast.makeText(this, "No fragment to Replace", Toast.LENGTH_SHORT).show()
            } else {
                stateFragment1 = if (stateFragment1) {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_3_container, secondFragment)
                        .commit()
                    false
                } else {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.home_3_container, firstFragment)
                        .commit()
                    true
                }
            }

        }

        // REMOVE
        binding.btnRemove.setOnClickListener {
            if (stateAdded) {
                if (stateFragment1) {
                    supportFragmentManager.beginTransaction()
                        .remove(firstFragment)
                        .commit()
                    stateFragment1 = false

                } else {
                    supportFragmentManager.beginTransaction()
                        .remove(secondFragment)
                        .commit()
                }
                stateAdded = false
            } else {
                Toast.makeText(this, "No Fragment to Remove", Toast.LENGTH_SHORT).show()
            }


        }

        //SHOW
        binding.btnShow.setOnClickListener {
            if (stateAdded) {
                if (stateFragment1Hided) {
                    supportFragmentManager.beginTransaction()
                        .show(firstFragment)
                        .commit()
                    stateFragment1Hided = false
                } else {
                    supportFragmentManager.beginTransaction()
                        .show(secondFragment)
                        .commit()
                    
                }
            } else {
                Toast.makeText(this, "No Fragment to show", Toast.LENGTH_SHORT).show()
            }
        }

        //HIDE
        binding.btnHide.setOnClickListener {
            if (stateAdded) {
                if (stateFragment1) {
                    supportFragmentManager.beginTransaction()
                        .hide(firstFragment)
                        .commit()
                    stateFragment1Hided = true
                } else {
                    supportFragmentManager.beginTransaction()
                        .hide(secondFragment)
                        .commit()
                }
            }else{
                Toast.makeText(this, "No Fragment to hide", Toast.LENGTH_SHORT).show()
            }
        }


    }
}
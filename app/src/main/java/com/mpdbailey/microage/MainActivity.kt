package com.mpdbailey.microage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mpdbailey.microage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportFragmentManager.findFragmentById(R.id.main_fragment_container)==null){
            showHome()
        }
    }

    fun showHome(){
        replaceMainFragment(HomeFragment())
    }

    private fun replaceMainFragment(fragment: Fragment) {
        val manager = supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.main_fragment_container, fragment)
            .commit()
    }
}
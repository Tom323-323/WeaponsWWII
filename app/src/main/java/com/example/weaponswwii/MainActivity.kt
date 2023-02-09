package com.example.weaponswwii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.weaponswwii.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        viewGone ()
        setContentView(binding.root)

    }

    // Full screen
    private fun viewGone(){
        val decorView: View = window.decorView
        val uiOptions: Int = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
        decorView.systemUiVisibility = uiOptions
    }
}
package com.tomaslab.app.presenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weaponswwii.R
import com.example.weaponswwii.databinding.FragmentSplashBinding
import com.tomaslab.app.domain.UseCaseLoadSplashScreen


class FragmentSplash: Fragment(R.layout.fragment_splash) {

    private var binding: FragmentSplashBinding? = null
    private val useCaseLoadSplashScreen = UseCaseLoadSplashScreen()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        binding!!.fragmentSplashScreen.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSplash_to_fragmentMainMenu)
        }
        init()
    }

    private fun init(){ // Set random text in SplashScreen
        binding?.tvContentSplash?.text = useCaseLoadSplashScreen.loadSplashScreen(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
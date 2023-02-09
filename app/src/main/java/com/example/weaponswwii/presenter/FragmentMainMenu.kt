package com.tomaslab.app.presenter

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.weaponswwii.R
import com.example.weaponswwii.databinding.FragmentMainMenuLandBinding


class FragmentMainMenu: Fragment(R.layout.fragment_main_menu_land), View.OnClickListener {

    private var binding: FragmentMainMenuLandBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainMenuLandBinding.bind(view)

        binding?.im1?.setOnClickListener(this)
        binding?.im2?.setOnClickListener(this)
        binding?.im3?.setOnClickListener(this)
        binding?.im4?.setOnClickListener(this)
        binding?.im5?.setOnClickListener(this)
        binding?.im6?.setOnClickListener(this)
        binding?.im7?.setOnClickListener(this)
        binding?.im8?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v){
            binding?.im1 -> selectLand(0)
            binding?.im2 -> selectLand(1)
            binding?.im3 -> selectLand(2)
            binding?.im4 -> selectLand(3)
            binding?.im5 -> selectLand(4)
            binding?.im6 -> selectLand(5)
            binding?.im7 -> selectLand(6)
            binding?.im8 -> selectLand(7)
        }
    }

    private fun selectLand(id: Int){
        findNavController().navigate(R.id.action_fragmentMainMenu_to_fragmentSelectWeapons,
        bundleOf(FragmentSelectWeapons.ID_LAND to id))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
package com.example.weaponswwii.presenter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.weaponswwii.R
import com.example.weaponswwii.databinding.FragmentContentWeaponsBinding


class FragmentContentWeapons: Fragment(R.layout.fragment_content_weapons) {

    companion object {
        const val ID_CONTENT = "id_content"
        const val ID_TYPE = "id_type"
        const val ID_LAND = "id_land"
    }

    private var binding: FragmentContentWeaponsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContentWeaponsBinding.bind(view)

        //Get arguments
        val id_weapon= requireArguments().getInt(ID_CONTENT,999)
        val id_type = requireArguments().getInt(ID_TYPE, 999)
        val id_land = requireArguments().getInt(ID_LAND,999)

        crateContent(id_land,id_type,id_weapon) // Create content

    }

    private fun crateContent(land: Int, type: Int, weapon: Int){
        val id_main = land.toString()+type.toString()+weapon.toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}
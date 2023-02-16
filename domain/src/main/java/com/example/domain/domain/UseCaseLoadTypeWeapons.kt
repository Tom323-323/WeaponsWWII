package com.example.domain.domain

import com.example.domain.domain.model.WeaponsModelType
import com.example.domain.domain.repository.DataRepository

class UseCaseLoadTypeWeapons  (private val dataRepository: DataRepository){

    fun loadTypeWeapons(id_land: Int, id_type: Int): MutableList<WeaponsModelType>{

        return dataRepository.loadTypeWeapons(id_land = id_land, id_type = id_type)

    }
}
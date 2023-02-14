package com.tomaslab.app.domain

import com.tomaslab.app.domain.model.WeaponsModelType
import com.tomaslab.app.domain.repository.DataRepository

class UseCaseLoadTypeWeapons  (private val dataRepository: DataRepository){

    fun loadTypeWeapons(id_land: Int, id_type: Int): MutableList<WeaponsModelType>{

        return dataRepository.loadTypeWeapons(id_land = id_land, id_type = id_type)

    }
}
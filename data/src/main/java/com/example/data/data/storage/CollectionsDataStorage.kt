package com.example.data.data.storage

import android.content.Context
import com.example.data.R
import com.example.data.data.storage.models.DataModelTypeWeapons
import com.example.data.data.storage.models.DataModelWeapons
import com.tomaslab.app.data.storage.DataStorage

class CollectionsDataStorage (): DataStorage {

    var array: ArrayList<Int> = arrayListOf()

    override fun loadWeaponsFromData(id: Int, context: Context): MutableList<DataModelWeapons> {
        val img_arr_weapons_0 = arrayListOf<Int>(
            R.drawable.img_german_pistol,
            R.drawable.img_pistol_usa,
            R.drawable.img_ussr_pistol,
            R.drawable.img_main_usa,
            R.drawable.img_main_fin,
            R.drawable.img_main_jp)
        val img_arr_weapons_1 = arrayListOf<Int>(
            R.drawable.img_german_pistol,
            R.drawable.img_pistol_usa,
            R.drawable.img_ussr_pistol,
            R.drawable.img_main_usa,
            R.drawable.img_main_fin,
            R.drawable.img_main_jp)
        val img_arr_weapons_2 = arrayListOf<Int>(
            R.drawable.img_german_pistol,
            R.drawable.img_pistol_usa,
            R.drawable.img_ussr_pistol,
            R.drawable.img_main_usa,
            R.drawable.img_main_fin,
            R.drawable.img_main_jp)
        val img_arr_weapons_3 = arrayListOf<Int>(
            R.drawable.img_german_pistol,
            R.drawable.img_pistol_usa,
            R.drawable.img_ussr_pistol,
            R.drawable.img_main_usa,
            R.drawable.img_main_fin,
            R.drawable.img_main_jp)
        val img_arr_weapons_4 = arrayListOf<Int>(
            R.drawable.img_german_pistol,
            R.drawable.img_pistol_usa,
            R.drawable.img_ussr_pistol,
            R.drawable.img_main_usa,
            R.drawable.img_main_fin,
            R.drawable.img_main_jp)
        val img_arr_weapons_5 = arrayListOf<Int>(
            R.drawable.img_german_pistol,
            R.drawable.img_pistol_usa,
            R.drawable.img_ussr_pistol,
            R.drawable.img_main_usa,
            R.drawable.img_main_fin,
            R.drawable.img_main_jp)
        val img_arr_weapons_6 = arrayListOf<Int>(
            R.drawable.img_german_pistol,
            R.drawable.img_pistol_usa,
            R.drawable.img_ussr_pistol,
            R.drawable.img_main_usa,
            R.drawable.img_main_fin,
            R.drawable.img_main_jp)
        val img_arr_weapons_7 = arrayListOf(
            R.drawable.img_german_pistol,
            R.drawable.img_pistol_usa,
            R.drawable.img_ussr_pistol,
            R.drawable.img_main_usa,
            R.drawable.img_main_fin,
            R.drawable.img_main_jp)

        val title_arr = context.resources.getStringArray(R.array.land_title)
        val content_arr = context.resources.getStringArray(R.array.land_content)
        when(id){
            0 -> array = img_arr_weapons_0
            1 -> array = img_arr_weapons_1
            2 -> array = img_arr_weapons_2
            3 -> array = img_arr_weapons_3
            4 -> array = img_arr_weapons_4
            5 -> array = img_arr_weapons_5
            6 -> array = img_arr_weapons_6
            7 -> array = img_arr_weapons_7
        }
        val dataWeapons = mutableListOf<DataModelWeapons>()
        for(i in 0..5){dataWeapons.add(DataModelWeapons(id = id, title = title_arr[i], img = array[i], content = content_arr[i]))}
        return dataWeapons
    }

    override fun loadTitleLand(idLand: Int, context: Context): Pair<Int, String> {
        val img_array_land = arrayListOf(R.drawable.img_main_gb,R.drawable.img_main_fr,R.drawable.img_main_ger,R.drawable.img_main_usa,R.drawable.img_main_fin,
            R.drawable.img_main_jp,R.drawable.img_main_ussr,R.drawable.img_main_ital)
        val title_array_land = context.resources.getStringArray(R.array.land_name_title)
        return Pair(img_array_land[idLand],title_array_land[idLand])
    }

    override fun loadTypeWeapons(id_land: Int, id_type: Int): MutableList<DataModelTypeWeapons> {
        val dataWeaponsType = mutableListOf<DataModelTypeWeapons>()
        for(i in 0..5){
            dataWeaponsType.add(
                DataModelTypeWeapons(
                    id = "",
                    name ="Maschinenpistole MP-40",
                    title = i.toString(),
                    calibr = id_land.toString(),
                    year = id_type.toString(),
                    men = "Designer: Hugo Schmeisser",
                    image = 77)
            )
        }
        return dataWeaponsType
    }


}
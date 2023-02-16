package com.example.weaponswwii.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weaponswwii.presenter.FragmentContentWeapons
import com.example.domain.domain.model.WeaponsModelType

class AdapterFragmentSelectTypeWeapons(private val dataTypeWeapons: ArrayList<WeaponsModelType>,
                                       private val parentFragment: Fragment,
                                       private val id_type: Int,
                                       private val id_land: Int): RecyclerView.Adapter<AdapterFragmentSelectTypeWeapons.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(com.example.weaponswwii.R.layout.view_holder_fragment_type_weapons, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataTypeWeapons[position], position)
    }

    override fun getItemCount(): Int {
        return dataTypeWeapons.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(dataTypeWeapons: WeaponsModelType, index: Int) {
            val image = itemView.findViewById<ImageView>(com.example.weaponswwii.R.id.holder_img_gun)
            val title = itemView.findViewById<TextView>(com.example.weaponswwii.R.id.holder_name_gun)
            val calibr = itemView.findViewById<TextView>(com.example.weaponswwii.R.id.holder_calibr_gun)
            val year = itemView.findViewById<TextView>(com.example.weaponswwii.R.id.razrab_year)
            val men = itemView.findViewById<TextView>(com.example.weaponswwii.R.id.constructor_men)

            image.setImageResource(com.example.weaponswwii.R.drawable.main_menu_logo_main) // TEST LOGO!!!!! Set Image, title and text in Holder
            title.text = dataTypeWeapons.title
            calibr.text = dataTypeWeapons.calibr
            year.text = dataTypeWeapons.year
            men.text = dataTypeWeapons.men

            itemView.setOnClickListener {
                onClick(index)
            }
        }
    }

    private fun onClick(index: Int) {
        val navCon = parentFragment.findNavController()
        navCon.navigate(
            com.example.weaponswwii.R.id.action_fragmentSelectTypeWeapons_to_fragmentContentWeapons,
            bundleOf(
                FragmentContentWeapons.ID_CONTENT to index,
                FragmentContentWeapons.ID_TYPE to id_type, FragmentContentWeapons.ID_LAND to id_land)
        )
    }
}
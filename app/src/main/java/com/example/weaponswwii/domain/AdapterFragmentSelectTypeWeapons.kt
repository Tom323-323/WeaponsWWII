package com.tomaslab.app.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.weaponswwii.R
import com.tomaslab.app.presenter.FragmentContentWeapons
import com.tomaslab.app.domain.model.WeaponsModelType

class AdapterFragmentSelectTypeWeapons(private val dataTypeWeapons: ArrayList<WeaponsModelType>,
                                       private val parentFragment: Fragment,
                                       private val id_type: Int,
                                       private val id_land: Int): RecyclerView.Adapter<AdapterFragmentSelectTypeWeapons.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterFragmentSelectTypeWeapons.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_holder_fragment_type_weapons, parent, false)
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
            val image = itemView.findViewById<ImageView>(R.id.holder_img_gun)
            val title = itemView.findViewById<TextView>(R.id.holder_name_gun)
            val calibr = itemView.findViewById<TextView>(R.id.holder_calibr_gun)
            val year = itemView.findViewById<TextView>(R.id.razrab_year)
            val men = itemView.findViewById<TextView>(R.id.constructor_men)

            image.setImageResource(R.drawable.main_menu_logo_main) // TEST LOGO!!!!! Set Image, title and text in Holder
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
        navCon.navigate(R.id.action_fragmentSelectTypeWeapons_to_fragmentContentWeapons,
            bundleOf(FragmentContentWeapons.ID_CONTENT to index,
                FragmentContentWeapons.ID_TYPE to id_type, FragmentContentWeapons.ID_LAND to id_land)
        )
    }
}
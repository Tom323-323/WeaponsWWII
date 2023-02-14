package com.tomaslab.app.presenter

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.weaponswwii.R
import com.example.weaponswwii.databinding.FragmentSelectWeaponsLandBinding
import com.tomaslab.app.data.DataRepository.DataRepositoryImp
import com.tomaslab.app.data.storage.CollectionsDataStorage
import com.example.weaponswwii.adapter.AdapterFragmentSelectWeapons
import com.tomaslab.app.domain.UseCaseLoadWeapons
import com.tomaslab.app.domain.model.WeaponsModel


class FragmentSelectWeapons: Fragment(R.layout.fragment_select_weapons_land) {

    private var binding: FragmentSelectWeaponsLandBinding? = null

    private val dataRepository = DataRepositoryImp(dataStorage = CollectionsDataStorage())

    companion object {
         const val ID_LAND = "id_land"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSelectWeaponsLandBinding.bind(view)

        val id_land = requireArguments().getInt(ID_LAND) // Get argument from FragmentMainMenu

        val dataWeapons = UseCaseLoadWeapons(dataRepository = dataRepository).loadWeapons(id_land,requireContext()) // UseCase LoadWeapons
        landManager(UseCaseLoadWeapons(dataRepository = dataRepository).loadLand(id_land,requireContext())) // Load headline and content.

        // ReccyclerView___________________________________________________
        val rv = binding!!.recyclerViewWeapons
        rv.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        rv.setHasFixedSize(true)
        rv.adapter = AdapterFragmentSelectWeapons(dataWeapons as ArrayList<WeaponsModel>,this, id_land)
        //_________________________________________________________________

        // Animation recycler view__________________________________________________________________
        rv.setPadding(110, 0, 110, 0)
        val shapHelper: SnapHelper = LinearSnapHelper()
        shapHelper.attachToRecyclerView(rv)
        Handler().postDelayed({
            val viewHolder: RecyclerView.ViewHolder? = rv.findViewHolderForPosition(0)
            val card = viewHolder?.itemView?.findViewById<CardView>(R.id.constrain_element_viewholder_select_weapons)
            card?.animate()?.setDuration(250)?.scaleX(1f)?.scaleY(1f)
                ?.setInterpolator(AccelerateInterpolator())?.start()
        }, 80)

        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val v = shapHelper.findSnapView(rv.layoutManager)
                val pos: Int = (rv.layoutManager as LinearLayoutManager).getPosition(v!!)
                val viewHolder: RecyclerView.ViewHolder = rv.findViewHolderForPosition(pos)!!
                val card = viewHolder.itemView.findViewById<CardView>(R.id.constrain_element_viewholder_select_weapons)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    card.animate().setDuration(250).scaleX(1f).scaleY(1f)
                        .setInterpolator(AccelerateInterpolator()).start()
                } else {
                    card.animate().setDuration(250).scaleX(0.85f).scaleY(0.85f)
                        .setInterpolator(AccelerateInterpolator()).start()
                }
            }
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        // Animation recycler view__________________________________________________________________
    }

    private fun landManager(id: Pair<Int, String>){
        if(id.second == getString(R.string.land_0)) {binding?.titleLand?.textSize = 22F} // Text size from long land - Great Brit
        binding?.titleLand?.text = id.second // Set title text in Head Line
        binding?.imgLand?.setImageResource(id.first)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
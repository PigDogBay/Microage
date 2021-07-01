package com.mpdbailey.microage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mpdbailey.microage.databinding.FragmentMissionBinding


class MissionFragment : Fragment() {
    private lateinit var binding : FragmentMissionBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMissionBinding.inflate(layoutInflater)
        binding.missionPager.adapter = MissionPagerAdapter(requireActivity())
        return binding.root
    }
}

class MissionPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() = 11

    override fun createFragment(position: Int): Fragment {
        val layoutId = when (position){
            1 -> R.layout.fragment_mission_1
            2 -> R.layout.fragment_mission_2
            3 -> R.layout.fragment_mission_3
            4 -> R.layout.fragment_mission_4
            5 -> R.layout.fragment_mission_5
            6 -> R.layout.fragment_mission_6
            7 -> R.layout.fragment_mission_7
            8 -> R.layout.fragment_mission_8
            9 -> R.layout.fragment_mission_9
            10 -> R.layout.fragment_mission_10
            else -> R.layout.fragment_mission_home
        }
        return MissionPageFragment(layoutId)
    }
}

class MissionPageFragment(private val layoutId : Int) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(layoutId, container, false)
    }
}
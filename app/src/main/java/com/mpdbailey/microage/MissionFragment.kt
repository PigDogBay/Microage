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
        return MissionPageFragment(R.layout.fragment_mission_home)
    }
}

class MissionPageFragment(val layoutId : Int) : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(layoutId, container, false)
    }
}
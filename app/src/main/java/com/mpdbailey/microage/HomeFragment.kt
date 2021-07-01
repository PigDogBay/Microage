package com.mpdbailey.microage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mpdbailey.microage.databinding.FragmentHomeBinding
import com.mpdbailey.microage.presenters.Screen


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val coordinator = MicroageApplication.instance.coordinator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.homeMission.setOnClickListener{coordinator.show(Screen.Mission)}
        binding.homeBadge.setOnClickListener{coordinator.show(Screen.Badge)}
        binding.homeAstronaut.setOnClickListener{coordinator.show(Screen.Astronaut)}
        binding.homeTeam.setOnClickListener{coordinator.show(Screen.Team)}
        binding.homeUpdates.setOnClickListener{coordinator.show(Screen.Updates)}
        return binding.root
    }

}
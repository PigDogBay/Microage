package com.mpdbailey.microage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mpdbailey.microage.databinding.FragmentTeamBinding
import com.mpdbailey.microage.databinding.FragmentTeamMemberBinding
import com.mpdbailey.microage.model.TeamFactory


class TeamFragment : Fragment() {

    private lateinit var binding : FragmentTeamBinding
    private val coordinator = MicroageApplication.instance.coordinator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTeamBinding.inflate(layoutInflater)
        binding.teamAnne.setOnClickListener { coordinator.show(TeamFactory.anne) }
        binding.teamSam.setOnClickListener { coordinator.show(TeamFactory.sam) }
        binding.teamKim.setOnClickListener { coordinator.show(TeamFactory.kim) }
        binding.teamHarvey.setOnClickListener { coordinator.show(TeamFactory.harvey) }
        binding.teamShah.setOnClickListener { coordinator.show(TeamFactory.shah) }
        binding.teamMalc.setOnClickListener { coordinator.show(TeamFactory.malc) }
        binding.teamJames.setOnClickListener { coordinator.show(TeamFactory.james) }
        binding.teamKai.setOnClickListener { coordinator.show(TeamFactory.kai) }
        binding.teamChris.setOnClickListener { coordinator.show(TeamFactory.chris) }
        binding.teamLibby.setOnClickListener { coordinator.show(TeamFactory.libby) }
        binding.teamGianluca.setOnClickListener { coordinator.show(TeamFactory.gianluca) }
        return binding.root
    }
}

class TeamMemberFragment : Fragment() {

    private lateinit var binding : FragmentTeamMemberBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentTeamMemberBinding.inflate(layoutInflater)
        val person = MicroageApplication.instance.coordinator.selectedPerson
        binding.teamMemberAcademic.text = person.academic
        binding.teamMemberLab.text = person.lab
        binding.teamMemberPlanet.text = person.planet
        binding.teamMemberFact.text = person.fact
        binding.teamMemberBio.text = person.bio
        binding.teamMemberImage.setImageResource(person.portraitId)
        if (person === TeamFactory.anne) {
            binding.teamMemberPlanetTitle.setText(R.string.team_member_title_planet_dwarf)
        }
        return binding.root
    }
}
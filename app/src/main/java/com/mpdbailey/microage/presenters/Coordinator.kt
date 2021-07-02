package com.mpdbailey.microage.presenters

import com.mpdbailey.microage.model.TeamFactory
import com.mpdbailey.microage.model.TeamMember

enum class Screen {
    Home, Mission, Badge, Astronaut, Team, Updates, TeamMember
}

class Coordinator {
    var view : CoordinatorView? = null
    var selectedPerson = TeamFactory.anne

    fun show(screen: Screen) {
        view?.show(screen)
    }

    fun show(person : TeamMember){
        selectedPerson = person
        view?.show(Screen.TeamMember)
    }

    fun onBackPressed() : Boolean{
        view?.show(Screen.Home)
        return false
    }

}
package com.mpdbailey.microage.presenters

enum class Screen {
    Home, Mission, Badge, Astronaut, Team, Updates
}

class Coordinator {
    var view : CoordinatorView? = null

    fun show(screen: Screen) {
        view?.show(screen)
    }

    fun onBackPressed() : Boolean{
        view?.show(Screen.Home)
        return false
    }

}
package com.mpdbailey.microage.presenters

interface CoordinatorView {
    fun show(screen: Screen)
    val currentScreen : Screen
}
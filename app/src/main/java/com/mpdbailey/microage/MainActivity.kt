package com.mpdbailey.microage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.mpdbailey.microage.databinding.ActivityMainBinding
import com.mpdbailey.microage.presenters.CoordinatorView
import com.mpdbailey.microage.presenters.Screen

class MainActivity : AppCompatActivity(), CoordinatorView {

    private lateinit var binding : ActivityMainBinding
    private val coordinator = MicroageApplication.instance.coordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MicroageApplication.instance.coordinator.view = this
        if (supportFragmentManager.findFragmentById(R.id.main_fragment_container)==null){
            coordinator.show(Screen.Home)
        }
    }

    override fun onDestroy() {
        coordinator.view = null
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (coordinator.onBackPressed()) {super.onBackPressed()}
    }

    private fun replaceMainFragment(fragment: Fragment, screen: Screen) {
        val manager = supportFragmentManager
        manager
            .beginTransaction()
            .replace(R.id.main_fragment_container, fragment, screen.name)
            .commit()
    }

    override fun show(screen: Screen) {
        val fragment = when (screen){
            Screen.Home -> HomeFragment()
            Screen.Mission -> MissionFragment()
            Screen.Badge -> BadgeFragment()
            Screen.Astronaut -> AstronautFragment()
            Screen.Team -> TeamFragment()
            Screen.Updates -> UpdateFragment()
            Screen.TeamMember -> TeamMemberFragment()
        }
        replaceMainFragment(fragment, screen)
    }

    override val currentScreen: Screen
        get() {
            val tag  = supportFragmentManager.findFragmentById(R.id.main_fragment_container)?.tag ?: Screen.Home.name
            return Screen.valueOf(tag)
        }
}
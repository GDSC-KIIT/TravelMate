package com.example.travelmate

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.travelmate.fragments.home_main_fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this@MainActivity, R.color.white)
        }
        val decor = window.decorView
        decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


        // Set the initial fragment
        val initialFragment: Fragment = home_main_fragment()
        replaceFragment(initialFragment)

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.fragmentFrame, fragment)
            .commit()
    }
}
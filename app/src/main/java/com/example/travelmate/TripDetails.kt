package com.example.travelmate

import android.os.Build
import android.os.Bundle
import android.view.ViewGroup.MarginLayoutParams
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class TripDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_details)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.Transparent)
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
            val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                val statusBarHeight = resources.getDimensionPixelSize(resourceId)
                val statusBarBackground = findViewById<ImageView>(R.id.image_holder)
                val params = statusBarBackground.layoutParams as MarginLayoutParams
                params.setMargins(0, -statusBarHeight, 0, 0)
            }
        }
    }
}
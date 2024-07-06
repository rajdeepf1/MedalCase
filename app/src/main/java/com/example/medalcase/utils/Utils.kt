package com.example.medalcase.utils

import android.app.Activity
import android.os.Build
import android.view.WindowManager
import androidx.core.content.ContextCompat
import com.example.medalcase.R

object Utils {
    fun changeStatusBarColor(activity: Activity){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(activity.applicationContext, R.color.toolbar_background_color);

        }
    }
}
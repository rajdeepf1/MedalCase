package com.example.medalcase.utils

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.medalcase.R
import kotlin.time.Duration

object Utils {
    fun changeStatusBarColor(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = ContextCompat.getColor(
                activity.applicationContext,
                R.color.toolbar_background_color
            );

        }
    }

    fun showToast(context: Context,message:String,duration: Int): Unit {
        Toast.makeText(context, message, duration).show()
    }
}
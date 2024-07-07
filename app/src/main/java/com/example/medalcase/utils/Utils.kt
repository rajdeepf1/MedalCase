package com.example.medalcase.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.medalcase.R

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

    fun showToast(context: Context, message: String, duration: Int): Unit {
        Toast.makeText(context, message, duration).show()
    }

    fun flipView(view: View) {
        val flipOut = ObjectAnimator.ofFloat(view, "rotationY", 0f, 90f)
        val flipIn = ObjectAnimator.ofFloat(view, "rotationY", -90f, 0f)

        flipOut.duration = 300
        flipIn.duration = 300

        flipOut.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                flipIn.start()
            }
        })

        flipOut.start()
    }
}
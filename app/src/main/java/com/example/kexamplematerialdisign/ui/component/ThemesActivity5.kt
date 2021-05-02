package com.example.kexamplematerialdisign.ui.component

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kexamplematerialdisign.R
import kotlinx.android.synthetic.main.themes_activity_5.*

class ThemesActivity5 : AppCompatActivity() {

    // новая activity - в manifest !!!
    companion object {
        fun start(context: Context) = Intent(context, ThemesActivity5::class.java).apply {
            context.startActivity(this)
        }

        var flag = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        when (flag) {
            1 -> setTheme(R.style.GreenAppTheme)
            2 -> setTheme(R.style.BrownAppTheme)
            3 -> setTheme(R.style.YellowAppTheme)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.themes_activity_5)
        supportActionBar?.title = "Action Bar (deprecated)"

    }

    override fun onResume() {
        super.onResume()
        changeThemeButton.setOnClickListener {
            flag++
            if (flag == 4) flag = 1
            recreate()
        }

    }
}
package com.example.kexamplematerialdisign.ui.component

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kexamplematerialdisign.R
import kotlinx.android.synthetic.main.chips_activity_4.*

// новая activity - в manifest !!!
class ChipsActivity4 : AppCompatActivity() {

    companion object {
        fun start(context: Context) = Intent(context, ChipsActivity4::class.java).apply {
            context.startActivity(this)
            //Toast.makeText(context, "------------------------------------------------- $mView.is", Toast.LENGTH_LONG).show()
        }

        var flag = true
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        flag = if (flag) {
            setTheme(R.style.GreenAppTheme)
            false
        } else{
            setTheme(R.style.BrownAppTheme)
            true
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chips_activity_4)


        //Toast.makeText(mContext, "------------------------------------------------- $it.id", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        first_chip_button.setOnClickListener {
            recreate()
        }

    }
}


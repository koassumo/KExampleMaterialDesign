package com.example.kexamplematerialdisign.ui.component

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.kexamplematerialdisign.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.chips_activity_4.*
import kotlinx.android.synthetic.main.item_component_0.view.*

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
            setTheme(R.style.MyAppTheme)
            false
        } else{
            setTheme(R.style.YourAppTheme)
            true
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chips_activity_4)


        //Toast.makeText(mContext, "------------------------------------------------- $it.id", Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        default_button.setOnClickListener {
            recreate()
        }

    }
}


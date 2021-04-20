package com.example.kexamplematerialdisign.ui.component

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.kexamplematerialdisign.R
import com.google.android.material.bottomsheet.BottomSheetBehavior

// новая activity - в manifest !!!
class ChipsActivity4 : AppCompatActivity () {

    companion object {
        fun start (context: Context) = Intent(context, ChipsActivity4::class.java).apply {
            context.startActivity(this)
            //Toast.makeText(context, "------------------------------------------------- $mView.is", Toast.LENGTH_LONG).show()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chips_activity_4)

    }


}
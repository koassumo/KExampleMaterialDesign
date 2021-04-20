package com.example.kexamplematerialdisign.ui.component

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import com.example.kexamplematerialdisign.R
import com.google.android.material.bottomsheet.BottomSheetBehavior

// новая activity - в manifest !!!
class BottomSheetActivity2 : AppCompatActivity () {


    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    companion object {
        fun start (context: Context) = Intent(context, BottomSheetActivity2::class.java).apply {
            context.startActivity(this)
            //Toast.makeText(context, "------------------------------------------------- $mView.is", Toast.LENGTH_LONG).show()
        }
    }

    lateinit var c2ViewModel2: BottomSheetViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_sheet_activity_2)

        c2ViewModel2 = ViewModelProvider(this).get(BottomSheetViewModel2::class.java)

        setBottomSheetBehavior(findViewById(R.id.bottom_sheet_container))
    }


    private fun setBottomSheetBehavior(bottomSheet: ConstraintLayout) {
        // инициализация
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        // первоначальное состояние
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED

        // проверка различных состояний
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //toast ("onSlide")
            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_DRAGGING -> toast("STATE_DRAGGING")
                    BottomSheetBehavior.STATE_COLLAPSED -> toast("STATE_COLLAPSED")
                    BottomSheetBehavior.STATE_EXPANDED -> toast("STATE_EXPANDED")
                    BottomSheetBehavior.STATE_HALF_EXPANDED -> toast("STATE_HALF_EXPANDED")
                    BottomSheetBehavior.STATE_HIDDEN -> toast("STATE_HIDDEN")
                    BottomSheetBehavior.STATE_SETTLING -> toast("STATE_SETTLING")
                }
            }
        })
    }


    private fun Activity.toast(string: String?) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }


}
package com.example.kexamplematerialdisign.ui.component

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.kexamplematerialdisign.R
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.bottom_app_bar_activity_3.*

// новая activity - в manifest !!!
class BottomAppBarActivity3 : AppCompatActivity() {

    // статичный кусок кода, используемый для запуска активити
    companion object {
        var isMain = true
        fun start(context: Context) = Intent(context, BottomAppBarActivity3::class.java).apply {
            context.startActivity(this)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_app_bar_activity_3)
        setBottomAppBar ()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_bottom_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_fav -> toast("Favourite")
//            R.id.app_bar_settings -> supportFragmentManager?.beginTransaction()
//                ?.add(R.id.container, ChipsFragment())?.addToBackStack(null)?.commit()
            android.R.id.home -> {

                    BottomNavigationDrawerFragment3().show(supportFragmentManager, "tag")

            }
        }
        return super.onOptionsItemSelected(item)
    }

//    Вариант для fragment, чтобы потом не искать:
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu_bottom_bar, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.app_bar_fav -> toast("Favourite")
//            R.id.app_bar_settings -> activity?.supportFragmentManager?.beginTransaction()?.add(R.id.container, ChipsFragment())?.addToBackStack(null)?.commit()
//            android.R.id.home -> {
//                activity?.let {
//                    BottomNavigationDrawerFragment().show(it.supportFragmentManager, "tag")
//                }
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }


    // замена верхнего Bar (по default) на нижний
    private fun setBottomAppBar() {
        // Внимание - вызов setSupportActionBar в теме с верним ActionBar приводит к ошибке
        setSupportActionBar (findViewById(R.id.bottom_app_bar))

        fab.setOnClickListener {
            if (isMain) {
                isMain = false
                bottom_app_bar.navigationIcon = null
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
                fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_back_fab))
                bottom_app_bar.replaceMenu(R.menu.menu_bottom_bar_other_screen)
            } else {
                isMain = true
                bottom_app_bar.navigationIcon =
                    ContextCompat.getDrawable(this, R.drawable.ic_hamburger_menu_bottom_bar)
                bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
                fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_plus_fab))
                bottom_app_bar.replaceMenu(R.menu.menu_bottom_bar)
            }
        }
    }



    private fun toast(string: String?) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }
}
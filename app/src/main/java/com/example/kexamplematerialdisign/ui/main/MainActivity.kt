package com.example.kexamplematerialdisign.ui.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kexamplematerialdisign.R
import com.example.kexamplematerialdisign.ui.component.ChipsActivity4
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    // (1) объявляем mViewModel
    lateinit var mViewModel : MainViewModel
    // объявляем adapter
    lateinit var adapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

    // (2) наполнение mViewModel
        mViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // подтягиваем rv, кладем layout на rv
        rv_main.layoutManager = GridLayoutManager(this, 2)
        // инициализируем адаптер, кладем его на rv
        adapter = MainAdapter(this)
        rv_main.adapter = adapter

    }


    override fun onStart() {
        super.onStart()
        ChipsActivity4.start (this)
//    <<<<<<<<<<<<<<<<[[[  2. Подписка на liveData
//    <<<<<<<<<<<<<<<<[[[  *4. И сразу при Подписке описание реакции подписчика, 4ка выполнится позже
        mViewModel.liveData.observe(this, Observer {
            adapter.aComponents = it     // вызов set
        })
    }

    fun toast(string: String?) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.BOTTOM, 0, 250)
            show()
        }
    }

}
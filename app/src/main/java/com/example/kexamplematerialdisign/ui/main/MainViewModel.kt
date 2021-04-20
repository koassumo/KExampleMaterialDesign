package com.example.kexamplematerialdisign.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.kexamplematerialdisign.model.ComponentRepository
import com.example.kexamplematerialdisign.model.entity.Component

// Вариант 1. Без возможности передачи контекста (owner, lifecycle)
// class MainViewModel : ViewModel() {
// Вариант 2. С возможностью передачи контекста
class MainViewModel(application: Application) : AndroidViewModel(application) {

    //   <<<<<<<<<<<<<<<<<<<[[   1. выставляем вышку
    val liveData = MutableLiveData<List<Component>>()

    init {
        startTimer()
    }

    private fun startTimer() {
        //    <<<<<<<<<<<<<<<<<<<[[   3. пихаем данные в вышку liveData - она разберется
        liveData.value = ComponentRepository.getComponents()
    }


}


package com.example.kexamplematerialdisign.model

import com.example.kexamplematerialdisign.model.entity.Component

object ComponentRepository {
    private val components: List<Component> = listOf(
        Component("+", "1", "EditText"),
        Component("+", "2", "BottomSheet"),
        Component("+", "3", "BottomAppBar"),
        Component("+", "4", "Chips"),
        Component("+", "5", "Themes"),
        Component("-", "6", "------"),
        Component("-", "7", "------"),
        Component("-", "8", "------"),
        Component("-", "9", "------")
    )

    fun getComponents(): List<Component> {
        return components
    }
}
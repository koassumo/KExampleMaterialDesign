package com.example.kexamplematerialdisign.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kexamplematerialdisign.R
import com.example.kexamplematerialdisign.model.entity.Component
import com.example.kexamplematerialdisign.ui.component.*
import kotlinx.android.synthetic.main.item_component_0.view.*

class MainAdapter (eContext: Context): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    val aContext: Context = eContext

    // не путать set с конструктором
    var aComponents: List<Component> = listOf()
        set (value) {
            field = value
            notifyDataSetChanged()
        }

    // (Один) при создании vh - onCreateViewHolder - в него передается itemView
    // (Два) при вызове у vh метода bind - в него передается данные из array, чтобы связать с itemView
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // "находим" (для kotlin) нужные вьюшки и связываем их
        fun bind(aVhComponent: Component) {

            itemView.tv_title.text = aVhComponent.mTitle
            itemView.tv_id.text = aVhComponent.mId
            itemView.tv_description.text = aVhComponent.mDescription

            itemView.setOnClickListener {
                when (it.tv_id.text) {
                    "1" ->  EditTextActivity1.start (aContext)
                    "2" ->  BottomSheetActivity2.start (aContext)
                    "3" ->  BottomAppBarActivity3.start (aContext)
                    "4" ->  ChipsActivity4.start (aContext)
                    "5" ->  ThemesActivity5.start (aContext)
                    "6" ->  EditTextActivity1.start (aContext)
                    "7" ->  EditTextActivity1.start (aContext)
                    "8" ->  EditTextActivity1.start (aContext)
                    "9" ->  EditTextActivity1.start (aContext)
                    "0" ->  EditTextActivity1.start (aContext)
                }
                //Toast.makeText(mContext, "------------------------------------------------- $it.id", Toast.LENGTH_LONG).show()
            }
        }
    }

    // 1. Создать vh путем передачи в него item_view.xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_component_0, parent, false))

    // 2. Передать строчку из arrayList во vh через метод bind
    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(aComponents[position])
    }

    // 3. из кода эта функция не вызывается
    override fun getItemCount(): Int {
        return aComponents.size
    }

}
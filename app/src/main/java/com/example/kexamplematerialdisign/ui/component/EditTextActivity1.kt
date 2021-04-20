package com.example.kexamplematerialdisign.ui.component

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kexamplematerialdisign.R
import kotlinx.android.synthetic.main.edit_text_activity_1.*

// новая activity - в manifest !!!
class EditTextActivity1 : AppCompatActivity () {

    // статичный кусок кода, используемый для запуска активити
    companion object {
        fun start(context: Context) = Intent(context, EditTextActivity1::class.java).apply {
            context.startActivity(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_text_activity_1)

        input_layout2.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://en.wikipedia.org/wiki/${input_edit_text.text.toString()}")
            })
        }
    }
}
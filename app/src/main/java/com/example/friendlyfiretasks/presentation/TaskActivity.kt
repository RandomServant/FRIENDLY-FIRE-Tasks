package com.example.friendlyfiretasks.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.friendlyfiretasks.R
import com.google.android.material.textfield.TextInputEditText

class TaskActivity : AppCompatActivity() {

    private lateinit var name: String
    private lateinit var description: String
    private lateinit var date: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        description = intent.getStringExtra(DESCRIPTION_EXTRA).toString()
        name = intent.getStringExtra(NAME_EXTRA).toString()
        date = intent.getStringExtra(DATE_EXTRA).toString()

        findViewById<EditText>(R.id.editName).setText(name)
        findViewById<EditText>(R.id.editDesc).setText(description)
        findViewById<EditText>(R.id.editDate).setText(date)
    }

    companion object {
        private const val NAME_EXTRA = "NAME"
        private const val DESCRIPTION_EXTRA = "DESK"
        private const val DATE_EXTRA = ""

        fun getIntent(context: Context, name: String, description: String, date: String) : Intent {
            val intent = Intent(context, TaskActivity::class.java)
            intent.putExtra(NAME_EXTRA, name)
            intent.putExtra(DESCRIPTION_EXTRA, description)
            intent.putExtra(DATE_EXTRA, date)
            return intent
        }
    }
}
package com.project.selfpromoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    private var contactNameEdittext: TextInputEditText? = null
    private var contactNumberEdittext: TextInputEditText? = null
    private var myDisplayEditText: TextInputEditText? = null
    private var startDateEdittext: TextInputEditText? = null
    private var juniorCheckBox: CheckBox? = null
    private var immediateStartCheckBox: CheckBox? = null
    private var jobTitleSpinner: Spinner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        contactNameEdittext = findViewById(R.id.edit_text_contact_name)
        contactNumberEdittext = findViewById(R.id.edit_text_contact_number)
        myDisplayEditText = findViewById(R.id.edit_text_display_name)
        startDateEdittext = findViewById(R.id.edit_text_start_date)
        juniorCheckBox = findViewById(R.id.check_box_junior)
        immediateStartCheckBox = findViewById(R.id.check_box_immediate_start)
        jobTitleSpinner = findViewById(R.id.spinner_job_title)

        val previewButton: Button = findViewById(R.id.button_preview)
        previewButton.setOnClickListener {
            onPreviewClicked()
        }
        val spinnerValues :Array<String> =arrayOf("Android dev","Android eng")
        val spinnerAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,spinnerValues)
        jobTitleSpinner!!.adapter =spinnerAdapter

    }

    private fun onPreviewClicked() {

        val message= Message(
            contactNameEdittext!!.text.toString(),
            contactNumberEdittext!!.text.toString(),
            myDisplayEditText!!.text.toString(),
            juniorCheckBox?.isChecked!!,
            jobTitleSpinner?.selectedItem.toString(),
            immediateStartCheckBox?.isChecked!!,
            startDateEdittext!!.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message",message)
        startActivity(previewActivityIntent)
    }
}
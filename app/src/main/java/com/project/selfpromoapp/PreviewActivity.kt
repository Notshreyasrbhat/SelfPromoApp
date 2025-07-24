package com.project.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class PreviewActivity : AppCompatActivity() {
    private lateinit var textmessage: TextView
    private lateinit var message: Message
    private lateinit var messagePreviewText: String
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preview)
        displayMessage()
        setButton()
    }

    private fun displayMessage() {
        @Suppress("DEPRECATION") // Suppress warning for now
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                Hi ${message.contactName},
                
                My name is ${message.displayName} and I am ${message.getJobDesc()}.
                
                I have a portfolio of apps to demonstrate my skills that I  can show on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Thanks and best regards.
                
            """.trimIndent()
        textmessage = findViewById(R.id.text_view_message)
        textmessage.text = messagePreviewText
    }

    private fun setButton() {
        button = findViewById(R.id.button_send_message)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }

    }
}
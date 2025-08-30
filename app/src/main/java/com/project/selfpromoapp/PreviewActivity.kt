package com.project.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        // Display preview message text from passed data
        displayMessage()

        // Setup SMS send button
        setButton()
    }

    private fun displayMessage() {
        @Suppress("DEPRECATION") // Using deprecated Serializable intent extra
        message = intent.getSerializableExtra("Message") as Message

        // Build formatted message string using user inputs
        messagePreviewText = """
                Hi ${message.contactName},
                
                My name is ${message.displayName} and I am ${message.getJobDesc()}.
                
                I have a portfolio of apps to demonstrate my skills that I can show on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Thanks and best regards.
                
            """.trimIndent()

        // Show formatted message in TextView
        textmessage = findViewById(R.id.text_view_message)
        textmessage.text = messagePreviewText
    }

    private fun setButton() {
        button = findViewById(R.id.button_send_message)
        button.setOnClickListener {
            // Open SMS app with recipient and pre-filled message body
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }
}

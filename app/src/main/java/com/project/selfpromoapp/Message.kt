package com.project.selfpromoapp

import java.io.Serializable
import java.sql.Date

// Holds all user input data to be passed between activities
data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val includeJunior: Boolean,
    val jobTitle: String,
    val immediateStart: Boolean,
    val startDate: String
) : Serializable {

    // Returns job description with optional "junior" prefix
    fun getJobDesc() = if (includeJunior) "a junior $jobTitle" else "an $jobTitle"

    // Returns availability text based on immediate start or chosen date
    fun getAvailability() = if (immediateStart) "immediately" else "from $startDate"
}

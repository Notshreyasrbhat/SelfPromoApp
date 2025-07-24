package com.project.selfpromoapp

import java.io.Serializable
import java.sql.Date

data class Message(
    val contactName: String,
    val contactNumber: String,
    val displayName: String,
    val includeJunior: Boolean,
    val jobTitle: String,
    val immediateStart: Boolean,
    val startDate: String
) : Serializable {

    fun getJobDesc() = if (includeJunior) "a junior $jobTitle" else "an $jobTitle"

    fun getAvailability()=if(immediateStart)"immediately" else "from $startDate"
}
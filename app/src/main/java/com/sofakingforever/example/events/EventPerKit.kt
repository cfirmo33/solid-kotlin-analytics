package com.sofakingforever.example.events

import com.sofakingforever.analytics.events.AnalyticsEvent
import com.sofakingforever.analytics.kits.AnalyticsKit
import com.sofakingforever.analytics.kits.AnswersKit
import com.sofakingforever.analytics.kits.FirebaseKit

class EventPerKit(private val whatever: Boolean) : AnalyticsEvent {
    override fun getEventName(kit: AnalyticsKit): String = when (kit) {
        is FirebaseKit -> "Event #42 - Firebase"
        is AnswersKit -> "Event #42 - Answers"
        else -> "Event #42"
    }


    override fun getParameters(kit: AnalyticsKit): MutableMap<String, Any> {
        val parameters = super.getParameters(kit)
        parameters["whatever"] = whatever
        return parameters
    }

}
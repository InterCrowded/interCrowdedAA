package com.example.intercrowded.utils

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import java.time.temporal.Temporal
import java.util.*

class DateConversion {

    companion object static {

        fun convertDate(from:Temporal, to:Temporal):String{

            val d = ChronoUnit.DAYS.between(from, to)
            val h = ChronoUnit.HOURS.between(from, to)
            val m = ChronoUnit.MINUTES.between(from, to)
            val s = ChronoUnit.SECONDS.between(from, to)

            if (d > 1){
                return d.toString() + " Tag(e)"
            }
            else if (h > 1){
                return h.toString() + " Stunde(n)"
            }
            else if (m > 1){
                return m.toString() + " Minute(n)"
            }
            else if (s > 1){
                return s.toString() + " Sekunde(n)"
            }

            return "jetzt"
        }
    }
}
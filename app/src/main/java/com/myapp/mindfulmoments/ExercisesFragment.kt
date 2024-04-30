package com.myapp.mindfulmoments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.TimeUnit

class ExercisesFragment : Fragment() {
    private var exercise1Time: Long = 0
    private var exercise2Time: Long = 0
    private var exercise1Timer: Timer? = null
    private var exercise2Timer: Timer? = null
    private lateinit var exercise1TimeText: TextView
    private lateinit var exercise2TimeText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_exercises, container, false)

        // Exercise 1
        val exercise1StartButton = view.findViewById<Button>(R.id.exercise1_start_button)
        val exercise1StopButton = view.findViewById<Button>(R.id.exercise1_stop_button)
        exercise1TimeText = view.findViewById(R.id.exercise1_time_text)

        exercise1StartButton.setOnClickListener { startTimer(1, exercise1TimeText) }
        exercise1StopButton.setOnClickListener { stopTimer(1, exercise1TimeText) }

        // Exercise 2
        val exercise2StartButton = view.findViewById<Button>(R.id.exercise2_start_button)
        val exercise2StopButton = view.findViewById<Button>(R.id.exercise2_stop_button)
        exercise2TimeText = view.findViewById(R.id.exercise2_time_text)

        exercise2StartButton.setOnClickListener { startTimer(2, exercise2TimeText) }
        exercise2StopButton.setOnClickListener { stopTimer(2, exercise2TimeText) }

        return view
    }

    private fun startTimer(exerciseNumber: Int, timeTextView: TextView) {
        if (exerciseNumber == 1) {
            exercise1Timer = Timer().apply {
                schedule(object : TimerTask() {
                    override fun run() {
                        exercise1Time += 1000
                        activity?.runOnUiThread { updateTimeText(exercise1Time, timeTextView) }
                    }
                }, 0, 1000)
            }
        } else {
            exercise2Timer = Timer().apply {
                schedule(object : TimerTask() {
                    override fun run() {
                        exercise2Time += 1000
                        activity?.runOnUiThread { updateTimeText(exercise2Time, timeTextView) }
                    }
                }, 0, 1000)
            }
        }
    }

    private fun stopTimer(exerciseNumber: Int, timeTextView: TextView) {
        if (exerciseNumber == 1) {
            exercise1Timer?.cancel()
            exercise1Timer = null
        } else {
            exercise2Timer?.cancel()
            exercise2Timer = null
        }
        updateTimeText(0, timeTextView)
    }

    private fun updateTimeText(time: Long, timeTextView: TextView) {
        val minutes = TimeUnit.MILLISECONDS.toMinutes(time)
        val seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MINUTES.toSeconds(minutes)
        timeTextView.text = String.format("%02d:%02d", minutes, seconds)
    }
}

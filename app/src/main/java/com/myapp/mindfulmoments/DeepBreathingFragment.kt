package com.myapp.mindfulmoments

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class DeepBreathingFragment : Fragment() {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var btnStart: Button // Declare btnStart as a class-level property

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_deep_breathing, container, false)

        btnStart = view.findViewById(R.id.buttonStartBreathing)     // Initialize btnStart here

        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.audio1)

        btnStart.setOnClickListener {
            toggleAudioPlayback()
        }

        return view
    }

    private fun toggleAudioPlayback() {
        try {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                btnStart.text = "Exhale"

            } else {
                mediaPlayer.start()
                btnStart.text = "Inhale"
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onStop() {
        super.onStop()
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}

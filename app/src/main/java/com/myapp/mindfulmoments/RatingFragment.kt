package com.myapp.mindfulmoments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView


class RatingFragment : Fragment() {
    private lateinit var ratingBar: RatingBar
    private lateinit var submitButton: Button
    private lateinit var averageTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rating, container, false)

        // Initialize views
        ratingBar = view.findViewById(R.id.ratingBar2)
        submitButton = view.findViewById(R.id.submitBtn)
        averageTextView = view.findViewById(R.id.averageText)

        // Set click listener for the submit button
        submitButton.setOnClickListener {
            submitRating()
        }

        return view
    }

    @SuppressLint("SetTextI18n")
    private fun submitRating() {
        val r1 = ratingBar.rating
        when (r1.toInt()) {
            5 -> {
                averageTextView.text = "best"
            }

            4 -> {
                averageTextView.text = "good"
            }

            3 -> {
                averageTextView.text = "average"
            }

            2 -> {
                averageTextView.text = "bad"
            }

            else ->
                averageTextView.text = "worst"
        }
    }
}
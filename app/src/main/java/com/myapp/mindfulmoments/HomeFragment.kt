package com.myapp.mindfulmoments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager

class HomeFragment : Fragment() {

    @SuppressLint("CommitTransaction")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val buttonExplore = view.findViewById<Button>(R.id.exploreButton)
        val ratingPage = view.findViewById<ImageButton>(R.id.rating_icon)

        buttonExplore.setOnClickListener {
            val activityFragment = ActivityFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, activityFragment)
                .addToBackStack(null)
                .commit() // Add this line to commit the transaction
        }

        ratingPage.setOnClickListener{
            val ratingFragment = RatingFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container , ratingFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}

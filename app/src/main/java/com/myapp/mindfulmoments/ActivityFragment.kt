package com.myapp.mindfulmoments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ActivityFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_activity, container, false)

        val btn = view.findViewById<Button>(R.id.deep_breathing_btn)
        val exerciseBtn = view.findViewById<Button>(R.id.body_exercise_btn)

        exerciseBtn.setOnClickListener {
            val exercisesFragment = ExercisesFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, exercisesFragment)
                .addToBackStack(null)
                .commit()
        }

        btn.setOnClickListener {
            val deepBreathingFragment = DeepBreathingFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, deepBreathingFragment)
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}
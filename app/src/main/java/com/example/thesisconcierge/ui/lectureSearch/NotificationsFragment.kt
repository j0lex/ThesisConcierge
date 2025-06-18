package com.example.thesisconcierge.ui.lectureSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.thesisconcierge.databinding.FragmentNotificationsBinding
import com.google.android.material.card.MaterialCardView
import java.util.*

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    // Lecture data class
    data class Lecture(val title: String, val date: String, val room: String, val time: String)

    // Example lectures with time slots
    private val lectures = mapOf(
        "Business Informatics" to listOf(
            Lecture("Software Engineering", "15/04/2025", "B1.2.14", "8:30-10:30"),
            Lecture("Data Analysis", "15/04/2025", "B1.3.15", "11:00-12:30"),
            Lecture("Machine Analysis", "15/04/2025", "B1.3.15", "12:00-12:30"),
            Lecture("Machine Analysis", "15/04/2025", "B1.3.15", "12:00-12:30"),
            Lecture("Machine Analysis", "15/04/2025", "B1.3.15", "12:00-12:30"),
            Lecture("Machine Analysis", "15/04/2025", "B1.3.15", "12:00-12:30"),
            Lecture("Digital Marketing", "16/04/2025", "B2.1.10", "9:00-10:30"),
            Lecture("Management Systems", "17/04/2025", "B3.2.12", "10:30-12:00")
        ),
        "Computer Science" to listOf(
            Lecture("Algorithms", "15/04/2025", "C2.1.10", "9:00-10:30"),
            Lecture("Artificial Intelligence", "15/04/2025", "C2.2.20", "13:00-15:00"),
            Lecture("Machine Learning", "16/04/2025", "C1.1.10", "8:00-10:00"),
            Lecture("Data Structures", "17/04/2025", "C2.3.15", "11:30-13:00")
        ),
        "Electrical Engineering" to listOf(
            Lecture("Circuit Design", "15/04/2025", "E3.1.11", "10:00-11:30"),
            Lecture("Power Systems", "15/04/2025", "E3.2.22", "14:00-15:30"),
            Lecture("Renewable Energy", "16/04/2025", "E4.1.20", "9:30-11:00"),
            Lecture("Signal Processing", "17/04/2025", "E3.3.18", "10:00-11:30")
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize UI components
        val datePicker: DatePicker = binding.datePicker
        val lectureContainer: LinearLayout = binding.lectureContainer

        // Set today's date as the default
        val today = Calendar.getInstance()
        datePicker.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH),
            null
        )

        // Dynamic button setup
        val buttons = mapOf(
            binding.buttonBusiness to "Business Informatics",
            binding.buttonCs to "Computer Science",
            binding.buttonEe to "Electrical Engineering"
        )

        buttons.forEach { (button, category) ->
            button.setOnClickListener {
                displayLectures(category, datePicker, lectureContainer)
            }
        }

        return root
    }

    private fun displayLectures(category: String, datePicker: DatePicker, container: LinearLayout) {
        val selectedDate = formatDateFromDatePicker(datePicker)
        val lecturesForCategory = lectures[category]?.filter { it.date == selectedDate }

        // Clear previous views
        container.removeAllViews()

        if (lecturesForCategory.isNullOrEmpty()) {
            val noLecturesView = TextView(requireContext()).apply {
                text = "No lectures found for $category on $selectedDate."
                textSize = 16f
                setPadding(8, 8, 8, 8)
            }
            container.addView(noLecturesView)
        } else {
            lecturesForCategory.forEach { lecture ->
                // Create a CardView for each lecture
                val cardView = MaterialCardView(requireContext()).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ).apply {
                        setMargins(8, 8, 8, 8) // Set margin between each card
                    }
                    radius = 16f // Rounded corners
                    cardElevation = 4f // Subtle shadow
                    strokeColor = resources.getColor(android.R.color.black, null) // Outline color
                    strokeWidth = 2 // Outline width
                }

                // Create a TextView inside the CardView to display lecture information
                val lectureText = TextView(requireContext()).apply {
                    text = """
                    ${lecture.title}
                    Date: ${lecture.date}
                    Time: ${lecture.time}
                    Room: ${lecture.room}
                """.trimIndent()
                    textSize = 16f
                    setPadding(16, 16, 16, 16) // Padding inside the card
                    setTextColor(resources.getColor(android.R.color.black, null))
                }

                // Add the TextView to the CardView
                cardView.addView(lectureText)

                // Add the CardView to the container
                container.addView(cardView)
            }
        }
    }


    private fun formatDateFromDatePicker(datePicker: DatePicker): String {
        val day = datePicker.dayOfMonth
        val month = datePicker.month + 1 // Months are indexed from 0
        val year = datePicker.year
        return String.format("%02d/%02d/%04d", day, month, year)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

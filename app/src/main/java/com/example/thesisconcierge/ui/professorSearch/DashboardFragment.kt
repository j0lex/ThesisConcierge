package com.example.thesisconcierge.ui.professorSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.SearchView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.thesisconcierge.R
import com.example.thesisconcierge.databinding.FragmentDashboardBinding
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest

class DashboardFragment : Fragment() {

    private lateinit var robot: Robot
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    // Dictionary mapping professors to rooms
    private val professorRoomMap = mapOf(
        "Alessandro Artale" to "B1.5.05",
        "Alessandro Torcinovich" to "B1.5.15",
        "Andrea Alexander Janes" to "B1.4.24",
        "Andrea Gasparella, Preside" to "B1.4.17",
        "Andrea Mazzullo" to "B1.5.35",
        "Andrea Rosani" to "B1.5.24",
        "Anton Dignös" to "B1.5.22",
        "Antonella De Angeli" to "B1.3.24",
        "Barbara Russo" to "B1.4.20",
        "Bruno Carpentieri" to "B1.5.23",
        "Chiara Ghidini" to "B1.5.02",
        "Claus Pahl" to "B1.4.21",
        "Davide Lanti" to "B1.5.06",
        "Diego Calvanese" to "B1.5.04",
        "Dominik Matt" to "B1.4.03",
        "Eduardo Martins Guerra" to "B1.4.34",
        "Enrico Franconi" to "B1.5.42",
        "Erwin Rauch" to "B1.4.02",
        "Fabrizio Maria Maggi" to "B1.5.43",
        "Francesco Patuzzi" to "B1.4.10",
        "Franco Cacialli" to "B1.3.16",
        "Franco Concli" to "B1.4.01",
        "Gabriele Pasetti Monizza" to "B1.4.04",
        "Giovanni Modanese" to "B1.5.09",
        "Giovanni Pernigotto" to "B1.4.15",
        "Giuseppe Di Fatta" to "B1.5.18",
        "Giuseppe Roberto Pisaturo" to "B1.4.14",
        "Guido Orzes" to "B1.4.07",
        "Ilenia Fronza" to "B1.4.30",
        "Ivano Colombaro" to "B1.5.12",
        "Jacopo Carlo Alberizzi" to "B1.4.59",
        "Johann Gamper" to "B1.5.21",
        "Jorge Augusto Melegati Goncalves" to "B1.4.33",
        "Julien Corman" to "B1.5.31",
        "Karl Dietrich von Ellenrieder" to "B1.4.23",
        "Laura Levaggi" to "B1.5.10",
        "Lorenzo Maccioni" to "B1.4.49",
        "Luca Gualtieri" to "B1.4.08",
        "Luisa Petti" to "B1.3.19",
        "Manuela Ciocca" to "B1.3.12",
        "Marco Baratieri" to "B1.4.09",
        "Marco Montali" to "B1.5.03",
        "Maria Letizia Bertotti" to "B1.5.11",
        "Maria Menendez Blanco" to "B1.3.22",
        "Margherita Molinaro" to "B1.4.07",
        "Markus Zanker" to "B1.3.23",
        "Massimiliano Renzi" to "B1.4.12",
        "Michael Haller" to "B1.3.15",
        "Muhammad Azfar Yaqub" to "B1.5.16",
        "Niccolò Pretto" to "B1.3.11",
        "Nicola Gigante" to "B1.5.35",
        "Niko Münzenrieder" to "B1.3.17",
        "Ognjen Savkovic" to "B1.5.32",
        "Oliver Kutz" to "B1.5.36",
        "Oswald Lanz" to "B1.5.14",
        "Ozan Kahramanogullari" to "B1.5.22",
        "Patrick Dallasega" to "B1.4.08",
        "Paolo Lugli" to "B1.3.13",
        "Pietro Ibba" to "B1.3.12",
        "Raffaella Bernardi" to "B1.1.05",
        "Rosella Gennari" to "B1.3.21",
        "Saman Babaie Kafaki" to "B1.5.12",
        "Santos Miguel Orozco Soto" to "B1.4.35",
        "Sergio Tessaris" to "B1.5.37",
        "Tiziano Dalmonte" to "B1.5.29",
        "Walburga Kerschbaumer" to "B1.4.05",
        "Werner Nutt" to "B1.5.33",
        "Xiaofeng Wang" to "B1.4.33",
        "Xiaozhou Li" to "B1.4.35",
        "Yuri Borgianni" to "B1.4.06"
    )

    private val buttonList = mutableListOf<Button>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        robot = Robot.getInstance()
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Reference to the TextView
        val displayRoomTextView: TextView = binding.textDashboard

        // Reference to the SearchView
        val searchView: SearchView = binding.searchView

        // Add buttons for each professor dynamically
        addProfessorButtons()

        // Add search functionality
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterButtons(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterButtons(newText)
                return true
            }
        })

        return root
    }

    private fun addProfessorButtons(filteredProfessors: Map<String, String> = professorRoomMap) {
        // Clear all existing buttons in the layout
        binding.professorButtonGrid.removeAllViews()

        filteredProfessors.forEach { (professor, room) ->
            val button = Button(requireContext()).apply {
                text = professor
                layoutParams = GridLayout.LayoutParams().apply {
                    columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                    setMargins(8, 8, 8, 8) // Add margins to avoid overlap
                }
                setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.blue))
                setTextColor(ContextCompat.getColor(requireContext(), android.R.color.white))
                visibility = View.VISIBLE
                setOnClickListener {
                    // Display the room when a professor button is clicked
                    val ttsRequest = TtsRequest.create("Room $room", true)
                    robot.speak(ttsRequest)
                }
            }
            buttonList.add(button)
            binding.professorButtonGrid.addView(button)
        }
    }

    private fun filterButtons(query: String?) {
        val lowerCaseQuery = query?.lowercase() ?: ""

        // Filter the professors based on the search query
        val filteredProfessors = professorRoomMap.filter {
            it.key.lowercase().contains(lowerCaseQuery)
        }

        // Re-add the filtered buttons to the layout
        addProfessorButtons(filteredProfessors)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

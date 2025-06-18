package com.example.thesisconcierge.ui.roomSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.thesisconcierge.databinding.FragmentHomeBinding
import com.robotemi.sdk.Robot
import com.robotemi.sdk.TtsRequest

class HomeFragment : Fragment() {
    private lateinit var robot: Robot
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var roomButtonsContainer: GridLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        robot = Robot.getInstance()
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        roomButtonsContainer = binding.roomButtonsContainer

        // Set floor button click listeners
        setFloorButtonClickListener(binding.buttonFloor1, 1)
        setFloorButtonClickListener(binding.buttonFloor2, 2)
        setFloorButtonClickListener(binding.buttonFloor3, 3)
        setFloorButtonClickListener(binding.buttonFloor4, 4)
        setFloorButtonClickListener(binding.buttonFloor5, 5)
        setFloorButtonClickListener(binding.buttonFloor6, 6)

        return root
    }

    private fun setFloorButtonClickListener(button: Button, floorNumber: Int) {
        button.setOnClickListener {
            // Show the corresponding number of room buttons for the selected floor
            showRoomButtons(floorNumber)
        }
    }

    private fun showRoomButtons(floorNumber: Int) {
        // Clear any previous room buttons
        roomButtonsContainer.removeAllViews()

        // Determine how many rooms to show based on the floor number
        val roomCount = when (floorNumber) {
            1 -> 32
            2 -> 32
            3 -> 30
            4 -> 44
            5 -> 37
            6 -> 22
            else -> 0
        }

        val excludedRoomsFloor1 = setOf(6, 16, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 29)
        val excludedRoomsFloor2 = setOf(6, 10, 17, 18, 19, 20, 22, 23, 24, 25, 26, 27, 28, 29)
        val excludedRoomsFloor3 = setOf(6)

        // Add room buttons for the selected floor
        for (roomNumber in 1..roomCount) {
            // Skip generating buttons for excluded rooms on floors 1 and 2
            if ((floorNumber == 1 && excludedRoomsFloor1.contains(roomNumber)) ||
                (floorNumber == 2 && excludedRoomsFloor2.contains(roomNumber)) ||
                (floorNumber == 3 && excludedRoomsFloor3.contains(roomNumber))
            ) {
                continue
            }

            val roomButton = Button(context).apply {
                text = "B1.$floorNumber.$roomNumber"
                setOnClickListener {
                    handleRoomClick(floorNumber, roomNumber)
                }
            }

            // Set the layout parameters for the button inside the GridLayout
            val layoutParams = GridLayout.LayoutParams().apply {
                width = 0
                height = GridLayout.LayoutParams.WRAP_CONTENT
                columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
                rowSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f)
            }
            roomButton.layoutParams = layoutParams
            roomButtonsContainer.addView(roomButton)
        }

        // Make the room buttons container visible
        roomButtonsContainer.visibility = View.VISIBLE
    }

    private fun handleRoomClick(floorNumber: Int, roomNumber: Int) {
        when (floorNumber) {
            1 -> handleFloor1(roomNumber)
            2 -> handleFloor2(roomNumber)
            3 -> handleFloor3(roomNumber)
            4 -> handleFloor4(roomNumber)
            5 -> handleFloor5(roomNumber)
            6 -> handleFloor6(roomNumber)
            else -> showToast("Floor not recognized")
        }
    }

    private fun handleFloor1(roomNumber: Int) {
        var text = ""
        when (roomNumber) {
            1 -> text = "Take the elevator to floor 1.\nThen, go on your right.\nAfter, turn right again and you will find the room."
            2 -> text = "Take the elevator to floor 1.\nThen, go on your right.\nAfter, turn right again and you will find the room by going right."
            3 -> text = "Take the elevator to floor 1.\nThen, go on your right.\nAfter, turn right again and you will find the room by going right."
            4 -> text = "Take the elevator to floor 1.\nThen, go on your left.\nAfter, turn left and you will find the room on your right."
            5 -> text = "Take the elevator to floor 1.\nThen, go on your left and you will find the room."
            7 -> text = "Take the elevator to floor 1.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            8 -> text = "Take the elevator to floor 1.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            9 -> text = "Take the elevator to floor 1.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            10 -> text = "Take the elevator to floor 1.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            11 -> text = "Take the elevator to floor 1.\nThen, go on your left and turn right.\nGo straight until you find the room on your right."
            12 -> text = "Take the elevator to floor 1.\nThen, go on your left and turn right.\nGo straight until you find the room on your right."
            13 -> text = "Take the elevator to floor 1.\nThen, go on your left and turn right.\nGo straight until you find the room on your right."
            14 -> text = "Take the elevator to floor 1.\nThen, go on your left and turn right.\nGo straight until you find the room on your right."
            15 -> text = "Take the elevator to floor 1.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            21 -> text = "Take the elevator to floor 1.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            30 -> text = "Take the elevator to floor 1.\nThen, go on your right and turn left.\nGo straight until you find the room on your left."
            31 -> text = "Take the elevator to floor 1.\nThen, go on your right and turn left.\nGo straight until you find the room on your left."
            32 -> text = "Take the elevator to floor 1.\nThen, go on your right and turn left.\nGo straight until you find the room on your left."
        }
        val ttsRequest = TtsRequest.create(text, true)
        robot.speak(ttsRequest)
    }

    private fun handleFloor2(roomNumber: Int) {
        var text = ""
        when (roomNumber) {
            1 -> text = "Take the elevator to floor 2.\nThen, go on your right.\nAfter, turn right again and you will find the room."
            2 -> text = "Take the elevator to floor 2.\nThen, go on your right.\nAfter, turn right again and you will find the room by going right."
            3 -> text = "Take the elevator to floor 2.\nThen, go on your right.\nAfter, turn right again and you will find the room by going right."
            4 -> text = "Take the elevator to floor 2.\nThen, go on your left.\nAfter, turn left and you will find the room on your right."
            5 -> text = "Take the elevator to floor 2.\nThen, go on your left and you will find the room."
            7 -> text = "Take the elevator to floor 2.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            8 -> text = "Take the elevator to floor 2.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            9 -> text = "Take the elevator to floor 2.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            11 -> text = "Take the elevator to floor 2.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            12 -> text = "Take the elevator to floor 2.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            13 -> text = "Take the elevator to floor 2.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            14 -> text = "Take the elevator to floor 2.\nThen, go on your left and turn right.\nGo straight until you find the room on your right."
            15 -> text = "Take the elevator to floor 2.\nThen, go on your left and turn right.\nGo straight until you find the room on your right."
            16 -> text = "Take the elevator to floor 2.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            21 -> text = "Take the elevator to floor 2.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            30 -> text = "Take the elevator to floor 2.\nThen go to your right and turn right\nGo straight until you find the room on your right."
            31 -> text = "Take the elevator to floor 2.\nThen, go on your right and turn left.\nGo straight until you find the room on your left."
            32 -> text = "Take the elevator to floor 2.\nThen, go on your right and turn left.\nGo straight until you find the room on your left."
        }
        val ttsRequest = TtsRequest.create(text, true)
        robot.speak(ttsRequest)
    }

    private fun handleFloor3(roomNumber: Int) {
        // Add specific logic for Floor 3 if needed
        var text = ""
        when (roomNumber) {
            1 -> text = "Take the elevator to floor 3.\nThen, go on your right.\nAfter, turn right again and you will find the room."
            2 -> text = "Take the elevator to floor 3.\nThen, go on your right.\nAfter, turn right again and you will find the room by going right."
            3 -> text = "Take the elevator to floor 3.\nThen, go on your left.\nAfter, turn left again and you will find the room by going right."
            4 -> text = "Take the elevator to floor 3.\nThen, go on your left.\nAfter, turn left again and you will find the room on the right."
            5 -> text = "Take the elevator to floor 3.\nThen, go on your left and you will find the room."
            7 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            8 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            9 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            10 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            11 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            12 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            13 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            14 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            15 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            16 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            17 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            18 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            19 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            20 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            21 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            22 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            23 -> text = "Take the elevator to floor 3.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            24 -> text = "Take the elevator to floor 3.\nThen, go on your right and turn left.\nGo straight and turn right.\nThe room is straight on your right."
            25 -> text = "Take the elevator to floor 3.\nThen, go on your right and turn left.\nGo straight and turn right.\nThe room is straight on your right."
            26 -> text = "Take the elevator to floor 3.\nThen, go on your right and turn left.\nGo straight and turn right.\nThe room is straight on your right."
            27 -> text = "Take the elevator to floor 3.\nThen, go on your right and turn left.\nGo straight and turn right.\nThe room is straight on your right."
            28 -> text = "Take the elevator to floor 3.\nThen, go on your right and turn left.\nGo straight and turn right.\nThe room is straight on your right."
            29 -> text = "Take the elevator to floor 3.\nThen, go on your right and turn left.\nGo straight and turn right."
            30 -> text = "Take the elevator to floor 3.\nThen, go on your right and turn left.\nGo straight and turn right."
        }
        val ttsRequest = TtsRequest.create(text, true)
        robot.speak(ttsRequest)
    }

    private fun handleFloor4(roomNumber: Int) {
        var text = ""
        when (roomNumber) {
            1 -> text = "Take the elevator to floor 4.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            2 -> text = "Take the elevator to floor 4.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            3 -> text = "Take the elevator to floor 4.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            4 -> text = "Take the elevator to floor 4.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            5 -> text = "Take the elevator to floor 4.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            6 -> text = "Take the elevator to floor 4.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            7 -> text = "Take the elevator to floor 4.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            8 -> text = "Take the elevator to floor 4.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            9 -> text = "Take the elevator to floor 4.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            10 -> text = "Take the elevator to floor 4.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            11 -> text = "Take the elevator to floor 4.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            12 -> text = "Take the elevator to floor 4.\nThen, go on your left and you will find the room."
            13 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            14 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            15 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            16 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            17 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            18 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            19 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            20 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            21 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            22 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            23 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            24 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            25 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            26 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            27 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            28 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            29 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            30 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            31 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            32 -> text = "Take the elevator to floor 4.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            33 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            34 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            35 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            36 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            37 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            38 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            39 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            40 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            41 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            42 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            43 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            44 -> text = "Take the elevator to floor 4.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."

        }
        val ttsRequest = TtsRequest.create(text, true)
        robot.speak(ttsRequest)
    }

    private fun handleFloor5(roomNumber: Int) {
        var text = ""
        when (roomNumber) {
            1 -> text = "Take the elevator to floor 5.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            2 -> text = "Take the elevator to floor 5.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            3 -> text = "Take the elevator to floor 5.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            4 -> text = "Take the elevator to floor 5.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            5 -> text = "Take the elevator to floor 5.\nThen, go on your right.\nAfter, turn right again and you will find the room on your left."
            6 -> text = "Take the elevator to floor 5.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            7 -> text = "Take the elevator to floor 5.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            8 -> text = "Take the elevator to floor 5.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            9 -> text = "Take the elevator to floor 5.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            10 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            11 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            12 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            13 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            14 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            15 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            16 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            17 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            18 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            19 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            20 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            21 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            22 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            23 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            24 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            25 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            26 -> text = "Take the elevator to floor 5.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            27 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            28 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            29 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            30 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            31 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            32 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            33 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            34 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            35 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            36 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            37 -> text = "Take the elevator to floor 5.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
        }
        val ttsRequest = TtsRequest.create(text, true)
        robot.speak(ttsRequest)
    }



    private fun handleFloor6(roomNumber: Int) {
        var text = ""
        when (roomNumber) {
            1 -> text = "Take the elevator to floor 6.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            2 -> text = "Take the elevator to floor 6.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            3 -> text = "Take the elevator to floor 6.\nThen, go on your left.\nAfter, turn left again and you will find the room on your right."
            4 -> text = "Take the elevator to floor 6.\\nThen, go on your left.\nAfter, go straight and you will find the room."
            5 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            6 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            7 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            8 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            9 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight until you find the room on your left."
            10 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            11 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            12 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            13 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            14 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            15 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            16 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            17 -> text = "Take the elevator to floor 6.\nThen, go on your left and turn right.\nGo straight and at the end of the corridor turn right.\nGo straight until you find the room on your left."
            18 -> text = "Take the elevator to floor 6.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            19 -> text = "Take the elevator to floor 6.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            20 -> text = "Take the elevator to floor 6.\nThen, go on your right and turn left.\nGo straight until you find the room on your right."
            21 -> text = "Take the elevator to floor 6.\nThen, go on your right and turn right.\nGo straight until you find the room on your left."
            22 -> text = "Take the elevator to floor 6.\nThen, go on your right and turn right.\nGo straight until you find the room on your left."
        }
        val ttsRequest = TtsRequest.create(text, true)
        robot.speak(ttsRequest)
    }

    private fun showToast(message: String) {
        // Show a toast message
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

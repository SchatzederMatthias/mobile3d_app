package com.example.myapplication


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_tool.*
import kotlinx.android.synthetic.main.fragment_tool.view.*
import kotlinx.android.synthetic.main.fragment_tool.view.text_input_distance
import kotlin.math.absoluteValue
import android.app.Activity
import android.os.Build
import android.os.VibrationEffect
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService




class Tool : Fragment() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tool, container, false)

        view.btn_extrude.setOnClickListener {
            val distance: Int = text_input_distance.text.toString().toInt()

            Toast.makeText(context, "extruding " + distance + "mm", Toast.LENGTH_SHORT).show()
        }

        /**
         * checks if the text input fields have focus and if they do not have focus it hides the keyboard
         */
        view.text_input_distance.setOnFocusChangeListener { _, hasFocus ->
            if(!hasFocus){
                hideKeyboard(view)
            }
        }

        view.text_input_nozzle_temperature.setOnFocusChangeListener { _, hasFocus ->
            if(!hasFocus){
                hideKeyboard(view)
            }
        }

        view.text_input_bed_temperature.setOnFocusChangeListener { _, hasFocus ->
            if(!hasFocus){
                hideKeyboard(view)
            }
        }
        
        /**
         * action buttons on click listeners
         */

        //retract
        view.btn_retract.setOnClickListener{
            myVib?.vibrate(VibrationEffect.createOneShot(20, 1))

        }

        //extrude
        view.btn_extrude.setOnClickListener{
            myVib?.vibrate(VibrationEffect.createOneShot(20, 1))

        }

        //set nozzle temperature
        view.btn_set_nozzle_temperature.setOnClickListener{
            myVib?.vibrate(VibrationEffect.createOneShot(20, 1))

        }

        //cool down nozzle
        view.btn_cool_down_nozzle.setOnClickListener{
            myVib?.vibrate(VibrationEffect.createOneShot(20, 1))

        }

        //set bed temperature
        view.btn_set_bed_temperature.setOnClickListener{
            myVib?.vibrate(VibrationEffect.createOneShot(20, 1))

        }

        //cool down bed
        view.btn_cool_down_bed.setOnClickListener{
            myVib?.vibrate(VibrationEffect.createOneShot(20, 1))

        }


        return view
    }

    /**
     * function that hides the keyboard
     */
    fun hideKeyboard(view: View){
        val inputMethodManager: InputMethodManager = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}

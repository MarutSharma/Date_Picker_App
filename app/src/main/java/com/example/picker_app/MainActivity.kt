package com.example.picker_app

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import com.example.picker_app.databinding.ActivityMainBinding
import java.text.DateFormat
import java.util.*

class MainActivity : AppCompatActivity(), OnDateSetListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            viewDateSelect.setOnClickListener {
                DatePickerFragment().show(supportFragmentManager, "SelectedDate")
            }
        }
    }


    class DatePickerFragment : DialogFragment() {

        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val date = c.get(Calendar.DATE)
            return DatePickerDialog(
                requireContext(),
                activity as OnDateSetListener,
                year,
                month,
                date
            )

        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, date: Int) {
        val c = Calendar.getInstance()
        c.set(Calendar.YEAR, year)
        c.set(Calendar.MONTH, month)
        c.set(Calendar.DAY_OF_MONTH, date)
        val selectedDate = DateFormat.getDateInstance().format(c.time)
        binding.tvSelectedDate.text = selectedDate
    }


}





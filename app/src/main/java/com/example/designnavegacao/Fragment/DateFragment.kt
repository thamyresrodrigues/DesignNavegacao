package com.example.designnavegacao.Fragment

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.designnavegacao.R
import kotlinx.android.synthetic.main.fragment_date.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class DateFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date, container, false)
    }

    override fun onViewCreated (view: View, savedInstanceState: Bundle ?) {
        super .onViewCreated(view,   savedInstanceState)
        date.setOnClickListener   {
            exibirSeletorDeData()
        }
    }

    private val dateListener =
        DatePickerDialog.OnDateSetListener {
                datePicker, y, m, d ->
            val dataFormatada = formatarData(d, m, y)
            date.setText(dataFormatada)
        }

    private fun exibirSeletorDeData() {
        context?.let { contexto->
            val c = Calendar.getInstance()
            // dia, mês e ano do momento atual
            val ano = c. get (Calendar.YEAR)
            val mes = c. get (Calendar.MONTH)
            val dia = c. get (Calendar.DAY_OF_MONTH)
            // Exibe o Date Picker usando a data atual
            // como referência
            DatePickerDialog(contexto,
                dateListener, ano, mes, dia).show()
        }
    }

    fun formatarData (dia: Int , mes: Int , ano: Int ): String {
        val c = Calendar.getInstance()
        // configura a data no calendário
        c. set (Calendar.YEAR, ano)
        c. set (Calendar.MONTH, mes)
        c. set (Calendar.DAY_OF_MONTH, dia)
        val data = c.time

        val dateFormat = SimpleDateFormat("dd/MM/yyyy")
        return dateFormat.format(data)
    }
}






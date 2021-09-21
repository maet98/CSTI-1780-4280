package com.pucmm.myfirstapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.pucmm.myfirstapp.models.Form
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var form: Form = Form("", "", birthDate = "", genre = "", languages = ArrayList(), programming = true)
    var checks: MutableList<CheckBox> = ArrayList()
    var radios: MutableList<RadioButton> = ArrayList()
    var checksLabel = listOf("java", "python", "js", "go land", "c/c++", "c#")
    private lateinit var firstName: EditText
    private lateinit var lastName: EditText
    private lateinit var birthdate: Button
    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<RadioGroup>(R.id.Programming).check(R.id.yes);

        this.firstName = findViewById<EditText>(R.id.firstName)
        this.lastName = findViewById<EditText>(R.id.lastName)
        this.birthdate = findViewById<Button>(R.id.pickDate)
        this.spinner = findViewById<Spinner>(R.id.genreSpinner)
        val pickDate = findViewById<Button>(R.id.pickDate)
        val genres = resources.getStringArray(R.array.genres)
        val adapter = ArrayAdapter.createFromResource(this,R.array.genres, android.R.layout.simple_spinner_item)
        this.checks.add(findViewById<CheckBox>(R.id.java))
        this.checks.add(findViewById<CheckBox>(R.id.python))
        this.checks.add(findViewById<CheckBox>(R.id.js))
        this.checks.add(findViewById<CheckBox>(R.id.go))
        this.checks.add(findViewById<CheckBox>(R.id.c))
        this.checks.add(findViewById<CheckBox>(R.id.cSharp))
        this.radios.add(findViewById(R.id.yes))
        this.radios.add(findViewById(R.id.programmingNo))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int, id: Long) {
                form.genre = genres[position]
//                Toast.makeText(this@MainActivity,
//                        getString(R.string.genre) + " " +
//                                "" + genres[position], Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }


    fun onClickSend(view: View) {
        var firstName = findViewById<EditText>(R.id.firstName)
        var lastName = findViewById<EditText>(R.id.lastName)
        for (i in this.checks.indices) {
            if(this.checks[i].isChecked) {
                this.form.addLanguage(this.checksLabel[i])
            }
        }
        this.form.firstName = firstName.text.toString()
        this.form.lastName = lastName.text.toString()
        var group = findViewById<RadioGroup>(R.id.Programming)
        this.form.programming = group.checkedRadioButtonId == R.id.yes
        if(this.form.genre.isBlank() || this.form.firstName.isBlank() || this.form.lastName.isBlank()) {
            Toast.makeText(this@MainActivity, "El nombre, apellido y genero son requeridos!", Toast.LENGTH_SHORT).show()
        } else if(this.form.languages.size == 0 && this.form.programming) {
            Toast.makeText(this@MainActivity, "Si le gusta programar, debe elegir al menos un lenguaje", Toast.LENGTH_SHORT).show()
        } else {
            OpenMessage();
        }
    }

    private fun OpenMessage() {
        val intent: Intent = Intent(this,MessageActivity::class.java);
        intent.putExtra("form", this.form);
        startActivity(intent);
    }

    fun onDatePicker(view: View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val style = AlertDialog.THEME_HOLO_LIGHT

        val dat = DatePickerDialog.OnDateSetListener{ view, year, month, day ->
            println(year)
            println(month)
            println(day)

            val pickDate = findViewById<Button>(R.id.pickDate)
            this.form.birthDate = getDateString(year, month, day)
            pickDate.text = getDateString(year, month, day)
        }

        val datePickerDialog = DatePickerDialog(this, style,dat , year, month,day)
        datePickerDialog.show()
    }

    private fun getDateString(year: Int, month: Int, day:Int): String {
        return "$day/$month/$year"
    }

    fun onRadioButton(view: View) {
        var group = findViewById<RadioGroup>(R.id.Programming)
        if ( group.checkedRadioButtonId == R.id.programmingNo) {
            for (check in this.checks) {
                check.isClickable = false
                check.isChecked = false
            }
        } else if ( group.checkedRadioButtonId == R.id.yes) {
            for (check in this.checks) {
                check.isClickable = true
            }
        }
    }

    fun onCheckButton(view: View) {

    }

    fun clean(view: View) {
        for( check in this.checks) {
            check.isChecked = false
        }

        for( radio in this.radios) {
            if(radio.id == R.id.programmingNo) {
                radio.isChecked = false
            } else {
                radio.isChecked = true
            }
        }
        firstName.setText("")
        lastName.setText("")
        birthdate.text = ""
        spinner.setSelection(0)

    }

}
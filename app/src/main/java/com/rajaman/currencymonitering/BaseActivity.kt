package com.rajaman.currencymonitering

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class BaseActivity : AppCompatActivity() {

    val arrOfCrr = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        val india = findViewById<CheckBox>(R.id.item1)
        val china = findViewById<CheckBox>(R.id.item2)
        val japan = findViewById<CheckBox>(R.id.item3)
        val australia = findViewById<CheckBox>(R.id.item4)
        val dubai = findViewById<CheckBox>(R.id.item5)
        val southafrica = findViewById<CheckBox>(R.id.item6)
        val england = findViewById<CheckBox>(R.id.item7)
        val trikey = findViewById<CheckBox>(R.id.item8)
        val isrel = findViewById<CheckBox>(R.id.item9)
        val germany = findViewById<CheckBox>(R.id.item10)
        val submitBtn = findViewById<Button>(R.id.mainValueBtn)

//        val url = "https://api.exchangeratesapi.io/latest?base=USD"
//        val queue = Volley.newRequestQueue(this)
//        val jsonObjectRequest: JsonObjectRequest = JsonObjectRequest(
//            Request.Method.GET, url, null,
//            Response.Listener { response ->
//                val main: JSONObject = response.getJSONObject("rates")
//                val inr = main.get("INR")
//
//            },
//            Response.ErrorListener {
//
//            }
//        )
//
//        queue.add(jsonObjectRequest)


        submitBtn.setOnClickListener {
            if (india.isChecked) {
                arrOfCrr.add("INR")
            }
            if (china.isChecked) {
                arrOfCrr.add("CNY")
            }
            if (japan.isChecked) {
                arrOfCrr.add("JPY")
            }
            if (australia.isChecked) {
                arrOfCrr.add("AUD")
            }
            if (dubai.isChecked) {
                arrOfCrr.add("CNY")
            }
            if (southafrica.isChecked) {
                arrOfCrr.add("ZAR")
            }
            if (england.isChecked) {
                arrOfCrr.add("EUR")
            }
            if (trikey.isChecked) {
                arrOfCrr.add("TRY")
            }
            if (isrel.isChecked) {
                arrOfCrr.add("ILS")
            }
            if (germany.isChecked) {
                arrOfCrr.add("RUB")
            }


            Toast.makeText(this, arrOfCrr.toString(), Toast.LENGTH_LONG).show()
            val intent = Intent(this, MainActivity::class.java)
            intent.putStringArrayListExtra("Values", arrOfCrr)
            startActivity(intent)
        }
    }
}
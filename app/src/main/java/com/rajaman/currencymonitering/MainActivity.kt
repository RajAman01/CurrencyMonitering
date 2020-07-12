package com.rajaman.currencymonitering

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card.view.*
import org.json.JSONObject
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    val url = "https://api.exchangeratesapi.io/latest?base=USD"
    val value = ArrayList<Double>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = intent.extras
        val newArr = intent?.getStringArrayList("Values")


        val queue = Volley.newRequestQueue(this)
        val jsonObj = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->

                val arrOfCrr = response.getJSONObject("rates")
                if (newArr != null) {
                    for (i in newArr) {
                        value.add(arrOfCrr.get(i.toString()) as Double)
                    }
//                    TextView1.text = value.toString()
                    val myAdapter = NewAdapter(this, value,newArr)
                    listView.adapter = myAdapter
                }

            }, Response.ErrorListener {
                Toast.makeText(this, "Network Error", Toast.LENGTH_LONG).show()
            })
        queue.add(jsonObj)


//        TextView.text = newArr.toString()
//        TextView1.text = value.toString()
        Toast.makeText(this,newArr.toString(),Toast.LENGTH_LONG).show()

    }

    inner class NewAdapter(
        val context: Context,
        val myAdapter: ArrayList<Double>,
        val newArr: java.util.ArrayList<String>?
    ) : BaseAdapter() {


        @SuppressLint("ViewHolder", "InflateParams")
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val newCard = inflater.inflate(R.layout.card, null, true)

            newCard.NameTextView.text = myAdapter[position].toString()
            newCard.RateTextView.text = newArr?.get(position).toString()
            return newCard
        }
        override fun getItem(position: Int): Any {
            return myAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return myAdapter.size
        }}

}
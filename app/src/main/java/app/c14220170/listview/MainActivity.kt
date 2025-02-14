package app.c14220170.listview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var data = mutableListOf<String>()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        data.addAll(listOf("1", "2", "3", "4", "5"))

        val lvAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        val _lv1 = findViewById<ListView>(R.id.lv1)
        _lv1.adapter = lvAdapter

        val _btnTambah = findViewById<Button>(R.id.btnTambah)
        _btnTambah.setOnClickListener {
            if (data.size == 0){
                data.add("1")
                lvAdapter.notifyDataSetChanged()
            }
            else {
                var dtAkhir = Integer.parseInt(data.get(data.size - 1)) + 1
                data.add(dtAkhir.toString())
                lvAdapter.notifyDataSetChanged()
            }
        }

        _lv1.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${data[position]}", Toast.LENGTH_SHORT).show()
        }

        val _btnHapus = findViewById<Button>(R.id.btnHapus)
        _btnHapus.setOnClickListener {
            if (data.size == 0) {
                Toast.makeText(this, "Data Kosong", Toast.LENGTH_SHORT).show()
            }
            else {
                data.removeFirst()
                lvAdapter.notifyDataSetChanged()
            }
        }

    }
}
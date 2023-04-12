package com.example.memberregistersqlitepro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.memberregistersqlitepro.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    lateinit var binding: ActivityListBinding
    lateinit var adapter: RecyclerAdapter
    var list : MutableList<Member>? = mutableListOf<Member>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dbHelper: DBHelper = DBHelper(applicationContext, MainActivity.DB_NAME, MainActivity.VERSION)

        list = dbHelper.selectAll()
        adapter = RecyclerAdapter(list!!)
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager = LinearLayoutManager(this)




    }
}

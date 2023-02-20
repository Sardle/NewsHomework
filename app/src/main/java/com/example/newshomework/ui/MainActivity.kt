package com.example.newshomework.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newshomework.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<NewsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        val progressBar = findViewById<ProgressBar>(R.id.progress)
        val adapter = NewsAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(
            this@MainActivity,
            LinearLayoutManager.VERTICAL,
            false
        )

        with(viewModel) {
            getNews()

            loadingLiveData.observe(this@MainActivity) {
                progressBar.isVisible = it
            }

            errorLiveData.observe(this@MainActivity) { res ->
                Toast.makeText(this@MainActivity, getString(res), Toast.LENGTH_SHORT).show()
            }

            newsLiveData.observe(this@MainActivity) {
                adapter.setItems(it)
            }
        }
    }
}
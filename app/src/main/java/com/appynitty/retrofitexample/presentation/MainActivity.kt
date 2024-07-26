package com.appynitty.retrofitexample.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.appynitty.retrofitexample.R
import com.appynitty.retrofitexample.repository.PhotoRepositoryImpl
import com.appynitty.retrofitexample.utils.NetworkResult
import com.appynitty.retrofitexample.utils.RetrofitHelper
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter: PhotoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = PhotoAdapter()
        progressBar = findViewById(R.id.progressBar)
        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val viewModelProviderFactory =
            MainViewModelFactory(PhotoRepositoryImpl(RetrofitHelper.profileApi))
        val viewModel = ViewModelProvider(this, viewModelProviderFactory)[MainViewModel::class.java]

        lifecycleScope.launch {
            viewModel.photosResult.collect {
                when (it) {
                    is NetworkResult.Failure -> {
                        Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_SHORT).show()
                    }

                    is NetworkResult.Loading -> {
                        progressBar.visibility = if (it.isLoading) View.VISIBLE else View.GONE
                    }

                    is NetworkResult.Success -> {
                        adapter.submitList(it.data)
                        Toast.makeText(this@MainActivity, "Data Fetched", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

    }
}
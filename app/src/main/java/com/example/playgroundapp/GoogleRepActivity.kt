package com.example.playgroundapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GoogleRepActivity : AppCompatActivity() {
    private lateinit var repoList:MutableList<String>
    private lateinit var adapter: GoogleRepoAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_rep)


        recyclerView = findViewById(R.id.rvGoogleRepos)
        recyclerView.layoutManager = LinearLayoutManager(this) //exibit the items, in a vertical way

        repoList = generateRepoList()
        adapter = GoogleRepoAdapter(repoList)
        recyclerView.adapter = adapter

    }
}

private fun generateRepoList():MutableList<String>{
    val list = mutableListOf<String>()
    val value1 = "google/.github"
    val value2 = "google/acai"

    for (i in 1..50) {
        list.add(value1)
        list.add(value2)
    }

    return list
}
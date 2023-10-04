package com.example.playgroundapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import java.util.Random

class EmojiListActivity : AppCompatActivity() {
    private lateinit var emojiList: MutableList<Int>
    private lateinit var adapter: EmojiAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emoji_list)

        recyclerView.adapter = adapter


        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        //atribuimos o evento setOnRefreshListener
        swipeRefreshLayout.setOnRefreshListener {
            refreshEmojiList()
        }

    }


    private fun generateEmojiList(): MutableList<Int> {
        val emojiList = mutableListOf<Int>()
        val originalEmojiList = listOf(
            R.drawable.dislike,
            R.drawable.hundred,
            R.drawable.like,
            R.drawable.numbers,


            )
        val random = Random()
        //flatmap
        val repeatedEmojis = originalEmojiList.flatMap { emoji -> List(100) { emoji } }.shuffled(random)

        //ciclo for
        /*for (emoji in originalEmojiList) {
        repeat(25) {
            emojiList.add(emoji)
        }
        }*/

        emojiList.addAll(repeatedEmojis)
        return emojiList
    }


    //remover o emoji da sua posição
    private fun removeEmoji(position: Int) {
        emojiList.removeAt(position)
        adapter.notifyDataSetChanged()
    }


    private fun refreshEmojiList() {
        Handler().postDelayed({ //2 sec of delay
            emojiList.clear() //clean all
            emojiList.addAll(generateEmojiList()) // new list
            adapter.notifyDataSetChanged() // notification of the change
            swipeRefreshLayout.isRefreshing = false //just to know when the refresh is over
        }, 2000)
    }

}
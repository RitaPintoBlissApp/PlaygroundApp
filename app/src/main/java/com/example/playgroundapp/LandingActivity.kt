package com.example.playgroundapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.appplayground.emojis

class LandingActivity : AppCompatActivity() {
    private lateinit var btnChangeEmoji: Button
    private lateinit var btEmojiList: Button
    private lateinit var imgEmoji: ImageView
    private lateinit var btAvatarList: Button

    val abc = emojis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)


        btnChangeEmoji = findViewById(R.id.btRandomEmoji)
        imgEmoji = findViewById(R.id.imageView)

        //change the emoji
        btnChangeEmoji.setOnClickListener {
            val randomIndex = (0 until emojis.size).random()
            val randomemoji = emojis[randomIndex]
            imgEmoji.setImageResource(randomemoji)
        }


        //  navigate to the emoji list
        btEmojiList = findViewById(R.id.btEmojiList)
        btEmojiList.setOnClickListener {
            val navigateEmojiList = Intent(this, EmojiListActivity::class.java)
            startActivity(navigateEmojiList)
        }


        //  navigate to the avatar list
        btAvatarList = findViewById(R.id.btAvatarList)
        btAvatarList.setOnClickListener {
            val navigatAvatarList = Intent(this, AvatarListActivity::class.java)
            startActivity(navigatAvatarList)
        }

    }
}
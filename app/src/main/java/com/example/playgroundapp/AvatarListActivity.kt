package com.example.playgroundapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random



class AvatarListActivity : AppCompatActivity() {
    private lateinit var avatarList: MutableList<Int>
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AvatarAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avatar_list)


        recyclerView = findViewById(R.id.rvAvatar)
        recyclerView.layoutManager = GridLayoutManager(this,4)

        avatarList = gerenateAvatarList()

        adapter = AvatarAdapter(avatarList){
                position -> removeAvatar(position)
        }

        recyclerView.adapter = adapter
    }



    private fun gerenateAvatarList(): MutableList<Int>{
        val avatarList = mutableListOf<Int>()
        val originalAvatarList = listOf(
            R.drawable.profile1,
            R.drawable.profile2,
            R.drawable.profile3,
        )
        val random = Random()
        val repeateAvatar = originalAvatarList.flatMap { avatar -> List(100) {avatar} }.shuffled(random)


        avatarList.addAll(repeateAvatar)
        return avatarList
    }

    //remover o emoji da sua posição
    private fun removeAvatar(position: Int) {
        avatarList.removeAt(position)
        adapter.notifyItemRemoved(position)

    }
}
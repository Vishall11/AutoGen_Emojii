package com.example.autogenemojii.viewmodel

import androidx.lifecycle.ViewModel
import com.example.autogenemojii.R
import com.example.autogenemojii.dataclass.RecyclerViewItems
import kotlin.random.Random

class EmojiViewModel: ViewModel() {

    var exampleList: List<RecyclerViewItems>? = null

    lateinit var taskEditTextNeeded: String

    private val list = ArrayList<RecyclerViewItems>()
    fun generatingList(): List<RecyclerViewItems>{
        val item = RecyclerViewItems(emojiToPass,"$taskEditTextNeeded")
        list += item
        return list
    }

    var emojiToPass: Int = -1

    fun generateEmoji(): Int{
        val emoji = listOf(
            R.drawable.ic_afraid_face,R.drawable.ic_agitated_face,
            R.drawable.ic_angry_face,R.drawable.ic_confused_face,R.drawable.ic_cool_face,R.drawable.ic_crying_face,
            R.drawable.ic_goofy_face,R.drawable.ic_happy_female_face,R.drawable.ic_laugh_extreme,
            R.drawable.ic_mad_face,R.drawable.ic_oval_face,R.drawable.ic_sad_face_1,R.drawable.ic_sad_face_with_big_eyes,
            R.drawable.ic_sad_face,R.drawable.ic_shocked_face,R.drawable.ic_smiling_face_1,R.drawable.ic_smiling_face,
            R.drawable.ic_surprised_face_1,R.drawable.ic_surprised_face,R.drawable.ic_triangle,R.drawable.ic_worried_face_1,
            R.drawable.ic_worried_face,R.drawable.ic_winking_face,R.drawable.ic_whistle_face,R.drawable.ic_zipped_up_mouth)
        return emoji[Random.nextInt(25)]
    }

}
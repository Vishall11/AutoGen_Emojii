package com.example.autogenemojii

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.autogenemojii.adapter.Adapter
import com.example.autogenemojii.databinding.ActivityMainBinding
import com.example.autogenemojii.viewmodel.EmojiViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: EmojiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        Log.i("MainActivity", "CalledViewModelProviders.of!!")
        viewModel = ViewModelProviders.of(this).get(EmojiViewModel::class.java)

        binding.addButton.setOnClickListener {
            viewModel.emojiToPass = viewModel.generateEmoji()
            viewModel.taskEditTextNeeded = binding.taskEditText.text.toString()
            viewModel.exampleList = viewModel.generatingList()
            recyclerView.adapter = Adapter(viewModel.exampleList)
            binding.taskEditText.text.clear()
            hideKeyBoard(it)
        }

        recyclerView.adapter = Adapter(viewModel.exampleList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun hideKeyBoard(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }

}
package com.nicoladalmaso.goosegamekata

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nicoladalmaso.goosegamekata.databinding.ActivityGooseGameBinding

class GooseGameActivity : AppCompatActivity() {

    private val viewModel: GooseGameActivityViewModel by viewModels()

    private lateinit var binding: ActivityGooseGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goose_game)
    }
}
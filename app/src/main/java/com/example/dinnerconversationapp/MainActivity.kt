package com.example.dinnerconversationapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.dinnerconversationapp.databinding.ActivityMainBinding

/**
 * Main screen where the user chooses which category of questions to explore.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply theme before super.onCreate
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val darkMode = prefs.getBoolean("dark_mode", true)
        AppCompatDelegate.setDefaultNightMode(
            if (darkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Activity Result API for settings
        val settingsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                recreate()
            }
        }

        // Launch the questions screen for the selected category when a card is tapped.
        binding.cardKids.setOnClickListener { openCategory(QuestionCategory.KIDS) }
        binding.cardRomantic.setOnClickListener { openCategory(QuestionCategory.ROMANTIC) }
        binding.cardParty.setOnClickListener { openCategory(QuestionCategory.PARTY) }
        binding.buttonSettings.setOnClickListener {
            settingsLauncher.launch(Intent(this, SettingsActivity::class.java))
        }
        binding.buttonSettings.setOnTouchListener { v, event ->
            when (event.action) {
                android.view.MotionEvent.ACTION_DOWN -> {
                    v.animate().scaleX(0.85f).scaleY(0.85f).setDuration(100).start()
                }
                android.view.MotionEvent.ACTION_UP, android.view.MotionEvent.ACTION_CANCEL -> {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(100).start()
                }
            }
            false // allow ripple and click to work
        }
    }

    /**
     * Starts the [QuestionsActivity] and passes the selected category as an extra.
     */
    private fun openCategory(category: QuestionCategory) {
        val intent = Intent(this, QuestionsActivity::class.java).apply {
            putExtra(QuestionsActivity.EXTRA_CATEGORY, category.name)
        }
        startActivity(intent)
    }
}
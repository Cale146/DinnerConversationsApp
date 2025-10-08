package com.example.dinnerconversationapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.dinnerconversationapp.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private lateinit var cacheManager: QuestionCacheManager

    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply theme before super.onCreate
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val darkMode = prefs.getBoolean("dark_mode", true)
        AppCompatDelegate.setDefaultNightMode(
            if (darkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cacheManager = QuestionCacheManager(this)

        val checkBoxes = mapOf(
            QuestionCategory.KIDS to binding.checkboxKids,
            QuestionCategory.ROMANTIC to binding.checkboxRomantic,
            QuestionCategory.PARTY to binding.checkboxParty
        )

        binding.buttonReset.setOnClickListener {
            var anyReset = false
            checkBoxes.forEach { (category, checkBox) ->
                if (checkBox.isChecked) {
                    cacheManager.resetAsked(category)
                    anyReset = true
                }
            }
            val msg = if (anyReset) "Selected game modes have been reset." else "Please select at least one mode."
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        // Theme switcher logic
        binding.switchTheme.isChecked = darkMode
        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean("dark_mode", isChecked).apply()
            AppCompatDelegate.setDefaultNightMode(
                if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
            )
            // Do NOT finish here; let user stay in SettingsActivity
        }
    }
}

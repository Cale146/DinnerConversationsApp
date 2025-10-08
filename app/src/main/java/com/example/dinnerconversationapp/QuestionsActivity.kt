package com.example.dinnerconversationapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dinnerconversationapp.databinding.ActivityQuestionsBinding

/**
 * Activity responsible for presenting a stream of questions for the selected category.
 * Users can swipe left or right to advance to a new question.
 */
class QuestionsActivity : AppCompatActivity() {

    companion object {
        /** Key used to pass the desired category to this activity. */
        const val EXTRA_CATEGORY = "extra_category"
    }

    private lateinit var binding: ActivityQuestionsBinding
    private lateinit var category: QuestionCategory
    private lateinit var questions: List<String>
    private lateinit var askedIndices: MutableSet<Int>
    private lateinit var cacheManager: QuestionCacheManager

    override fun onCreate(savedInstanceState: Bundle?) {
        // Apply theme before super.onCreate
        val prefs = getSharedPreferences("settings", MODE_PRIVATE)
        val darkMode = prefs.getBoolean("dark_mode", true)
        AppCompatDelegate.setDefaultNightMode(
            if (darkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Determine which category to show based on the supplied intent extra.
        val categoryName = intent.getStringExtra(EXTRA_CATEGORY) ?: QuestionCategory.KIDS.name
        category = QuestionCategory.valueOf(categoryName)
        questions = QuestionRepository.getQuestions(category)
        cacheManager = QuestionCacheManager(this)
        askedIndices = cacheManager.getAskedIndices(category)

        // Configure the ViewPager2 with a pager adapter that serves an infinite sequence of questions.
        val pagerAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int = Int.MAX_VALUE

            override fun createFragment(position: Int): Fragment {
                // If all questions have been asked, reset the tracking set.
                if (askedIndices.size >= questions.size) {
                    askedIndices.clear()
                    cacheManager.resetAsked(category)
                }
                // Determine a new question index that hasn't been seen recently.
                val remaining = (questions.indices.toSet() - askedIndices)
                val index = if (remaining.isNotEmpty()) {
                    remaining.random()
                } else {
                    questions.indices.random()
                }
                askedIndices.add(index)
                cacheManager.markAsAsked(category, index)
                return QuestionFragment.newInstance(questions[index], category)
            }
        }
        binding.viewPager.adapter = pagerAdapter

        // Set the title bar to include the category for context.
        supportActionBar?.title = getString(R.string.title_questions) + " - " + getString(
            when (category) {
                QuestionCategory.KIDS -> R.string.kids_category
                QuestionCategory.ROMANTIC -> R.string.romantic_category
                QuestionCategory.PARTY -> R.string.party_category
            }
        )
    }
}
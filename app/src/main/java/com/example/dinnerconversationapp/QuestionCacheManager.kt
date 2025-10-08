package com.example.dinnerconversationapp

import android.content.Context

/**
 * Persists and retrieves the set of question indices that have been shown to the user for
 * each category. The indices are stored in [SharedPreferences], which is appropriate for
 * small amounts of key‑value data and remains intact until the user clears the app cache or
 * uninstalls the app【471194565006150†L432-L536】.
 */
class QuestionCacheManager(private val context: Context) {

    /**
     * Returns the [SharedPreferences] instance associated with the given category. Each
     * category stores its asked indices in a separate file for isolation.
     */
    private fun getSharedPreferences(category: QuestionCategory) =
        context.getSharedPreferences("${context.packageName}.${category.name}_questions", Context.MODE_PRIVATE)

    /**
     * Retrieves the set of question indices that have been asked for the given category.
     */
    fun getAskedIndices(category: QuestionCategory): MutableSet<Int> {
        val prefs = getSharedPreferences(category)
        val rawSet = prefs.getStringSet(KEY_ASKED_INDICES, emptySet()) ?: emptySet()
        return rawSet.mapNotNull { it.toIntOrNull() }.toMutableSet()
    }

    /**
     * Adds the given index to the set of asked questions for the category and persists it.
     */
    fun markAsAsked(category: QuestionCategory, index: Int) {
        val prefs = getSharedPreferences(category)
        val currentSet = getAskedIndices(category)
        currentSet.add(index)
        prefs.edit().putStringSet(KEY_ASKED_INDICES, currentSet.map { it.toString() }.toSet()).apply()
    }

    /**
     * Clears the stored set of asked question indices for the category. This will
     * restart the cycle of questions when all have been used.
     */
    fun resetAsked(category: QuestionCategory) {
        val prefs = getSharedPreferences(category)
        prefs.edit().remove(KEY_ASKED_INDICES).apply()
    }

    private companion object {
        const val KEY_ASKED_INDICES = "asked_indices"
    }
}
package com.example.dinnerconversationapp

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.dinnerconversationapp.databinding.FragmentQuestionBinding

/**
 * A simple [Fragment] that displays a single question on screen.
 */
class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Populate the TextView with the question passed in via the arguments bundle.
        val question = arguments?.getString(ARG_QUESTION) ?: ""
        binding.textQuestion.text = question

        // Set theme based on category
        val categoryName = arguments?.getString(ARG_CATEGORY) ?: QuestionCategory.KIDS.name
        val category = QuestionCategory.valueOf(categoryName)
        when (category) {
            QuestionCategory.KIDS -> {
                binding.root.setBackgroundResource(R.drawable.bg_kids)
                binding.textQuestion.setTextColor(requireContext().getColor(R.color.kids_text))
                binding.textQuestion.typeface = Typeface.create("sans-serif-medium", Typeface.NORMAL)
            }
            QuestionCategory.ROMANTIC -> {
                binding.root.setBackgroundResource(R.drawable.bg_romantic)
                binding.textQuestion.setTextColor(requireContext().getColor(R.color.romantic_text))
                binding.textQuestion.typeface = Typeface.create("serif", Typeface.ITALIC)
            }
            QuestionCategory.PARTY -> {
                binding.root.setBackgroundResource(R.drawable.bg_party)
                binding.textQuestion.setTextColor(requireContext().getColor(R.color.party_text))
                binding.textQuestion.typeface = Typeface.create("sans-serif-black", Typeface.BOLD)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_QUESTION = "arg_question"
        private const val ARG_CATEGORY = "arg_category"

        /**
         * Factory method to create a new instance of this fragment using the provided parameters.
         */
        fun newInstance(question: String, category: QuestionCategory): QuestionFragment {
            val fragment = QuestionFragment()
            val args = Bundle().apply {
                putString(ARG_QUESTION, question)
                putString(ARG_CATEGORY, category.name)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
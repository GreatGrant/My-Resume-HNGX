package com.gralliams.myresume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.gralliams.myresume.databinding.FragmentEditResumeBinding

class EditResumeFragment : Fragment() {

    private var _binding: FragmentEditResumeBinding? = null
    private lateinit var resumeViewModel: ResumeViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEditResumeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resumeViewModel = ViewModelProvider(requireActivity())[ResumeViewModel::class.java]

        binding.saveButton.setOnClickListener {
            val isNameValid = validateField(binding.nameEditText, binding.nameTextInputLayout, "Enter a name")
            val isBioValid = validateField(binding.bioEditText, binding.bioTextInputLayout, "Write your bio")
            val isSlackValid = validateField(binding.slackEditText, binding.slackTextInputLayout, "Enter your slack handle")
            val isGitValid = validateField(binding.githubEditText, binding.githubTextInputLayout, "Enter your git handle")

            if (!isNameValid || !isBioValid || !isSlackValid || !isGitValid) {
                return@setOnClickListener
            }else{
                resumeViewModel.apply {
                    setName(binding.nameEditText.text.toString())
                    setBio(binding.bioEditText.text.toString())
                    setSlack(binding.slackEditText.text.toString())
                    setGit(binding.githubEditText.text.toString())
                }
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }


//        binding.buttonSecond.setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
//        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun validateField(
        editText: TextInputEditText,
        textInputLayout: TextInputLayout,
        errorMessage: String
    ): Boolean {
        val text = editText.text.toString().trim()
        return if (text.isEmpty()) {
            textInputLayout.error = errorMessage
            false
        } else {
            textInputLayout.error = null
            true
        }
    }

}
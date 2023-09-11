package com.gralliams.myresume

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gralliams.myresume.databinding.FragmentResumeBinding

class ResumeFragment : Fragment() {
    private var _binding: FragmentResumeBinding? = null
    private lateinit var resumeViewModel: ResumeViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResumeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        resumeViewModel = ViewModelProvider(requireActivity())[ResumeViewModel::class.java]

        resumeViewModel.apply {
            nameLiveData.observe(viewLifecycleOwner) { newName ->
                binding.nameTextView.text = newName
            }

            bioLiveData.observe(viewLifecycleOwner){newBio ->
                binding.bioTextView.text = newBio
            }

            slackLiveData.observe(viewLifecycleOwner){newSlackHandle ->
                binding.slackTextView.text = newSlackHandle
            }

            gitLiveData.observe(viewLifecycleOwner){newGitUrl ->
                binding.githubTextView.text = newGitUrl
            }
        }
            binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
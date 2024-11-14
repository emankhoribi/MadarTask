package com.example.myapplication.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentRegisterBinding
import com.example.myapplication.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterFragment : Fragment() {


    private val viewModel: RegisterViewModel by viewModels()
    private lateinit var binding: FragmentRegisterBinding
    private var gender: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener {
            if (isValidate()) {
                gender = if(binding.maleRd.isChecked)
                    binding.maleRd.text.toString()
                else
                    binding.femaleRd.text.toString()

                viewModel.addUser(
                    binding.nameEt.text.toString(),
                    Integer.parseInt(binding.ageEt.text.toString()),
                    binding.jobEt.text.toString(),
                    gender!!
                )
                lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.userFlow.collect {
                            if (it != null && it > -1)
                                findNavController().navigate(R.id.action_registerFragment_to_informationFragment)

                        }
                    }
                }
            }
        }
    }

    private fun isValidate(): Boolean {
        var isValid = true
        if (binding.nameEt.text.isNullOrEmpty()) {
            isValid = false
        } else if (binding.ageEt.text.isNullOrEmpty()) {
            isValid = false
        } else if (binding.jobEt.text.isNullOrEmpty()) {
            isValid = false
        } else if (!binding.maleRd.isChecked && !binding.femaleRd.isChecked) {
            isValid = false
        }
        if(!isValid)
            binding.msgTv.visibility = View.VISIBLE
        else
            binding.msgTv.visibility = View.INVISIBLE
        return isValid
    }
}
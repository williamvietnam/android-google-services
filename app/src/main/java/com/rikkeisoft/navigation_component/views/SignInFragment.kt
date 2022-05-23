package com.rikkeisoft.navigation_component.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.rikkeisoft.navigation_component.R
import com.rikkeisoft.navigation_component.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    companion object {
        private const val ACCOUNT_DEFAULT = "admin"
        private const val PASS_DEFAULT = "123"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        Log.d("test", "onViewCreated()...SignInFragment")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() {
        binding.btnSignIn.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val account = binding.inputAccount.text.toString()
        val pass = binding.inputPassword.text.toString()
        if (isLoginSuccess(account, pass)) {
            showToast("Đăng nhập thành công")
            Navigation.findNavController(binding.root).navigate(R.id.actionSignInToMain)
        } else {
            showToast("Tên đăng nhập hoặc mật khẩu ko đúng")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun isLoginSuccess(account: String, pass: String): Boolean {
        if (account == ACCOUNT_DEFAULT && pass == PASS_DEFAULT) {
            return true
        }
        return false
    }
}
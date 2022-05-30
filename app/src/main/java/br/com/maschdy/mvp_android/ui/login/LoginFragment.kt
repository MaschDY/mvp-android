package br.com.maschdy.mvp_android.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import br.com.maschdy.mvp_android.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), LoginContract.View {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        presenter = LoginPresenter(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setButton()
    }

    override fun onSuccess() {
        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }

    override fun onError() {
        Toast.makeText(requireContext(), "Login Failed!", Toast.LENGTH_SHORT).show()
    }

    override fun onLoading(isLoading: Boolean) = with(binding) {
        loadingLayout.isVisible = isLoading
        buttonLogin.isEnabled = !isLoading
    }

    private fun setButton() = with(binding) {
        buttonLogin.setOnClickListener {
            presenter.doLogin(emailTextField.text.toString(), passwordTextField.text.toString())
        }
    }
}

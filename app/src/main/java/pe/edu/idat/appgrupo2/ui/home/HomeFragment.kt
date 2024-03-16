package pe.edu.idat.appgrupo2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.ktx.R
import pe.edu.idat.appgrupo2.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root = binding.root

        val editTextUsername = binding.editTextUsername
        val editTextPassword = binding.editTextPassword
        val buttonLogin = binding.buttonLogin

        buttonLogin.setOnClickListener{
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username == "grupo2" && password == "SYS123"){
                Toast.makeText(requireContext(), "Usuario y contraseña correctos", Toast.LENGTH_SHORT).show()
                findNavController().navigate(pe.edu.idat.appgrupo2.R.id.listadoFragment)
            }
            else{
                Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
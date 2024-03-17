package pe.edu.idat.appgrupo2.Formulario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import pe.edu.idat.appgrupo2.databinding.FragmentListaFormularioBinding

class ListaFormularioFragment : Fragment() {
    private var _binding: FragmentListaFormularioBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentListaFormularioBinding.inflate(inflater, container, false)
        val listaFormularios = arguments?.getStringArrayList("listaformularios") ?: ArrayList()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listaFormularios)
        binding.lvformularios.adapter = adapter

        return binding.root
    }


}
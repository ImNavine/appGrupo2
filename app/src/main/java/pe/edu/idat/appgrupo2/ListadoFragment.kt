package pe.edu.idat.appgrupo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.appgrupo2.databinding.FragmentListadoBinding

class ListadoFragment : Fragment() {
    private var _binding: FragmentListadoBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding=FragmentListadoBinding.inflate(inflater, container, false)
        binding.rvlistado.layoutManager= LinearLayoutManager(requireContext())
        binding.rvlistado.adapter=AdapterResena(listaResena(), requireContext())
        return binding.root
    }

    fun listaResena(): List<Resena> {
    var lista=ArrayList<Resena>()
        lista.add(Resena("Kevin", "Prueba de descripcion",
            "16/03/2024", R.drawable.user1, R.drawable.star1))
        lista.add(Resena("Kevin", "Prueba de descripcion",
            "16/03/2024", R.drawable.user2, R.drawable.star2))
        lista.add(Resena("Kevin", "Prueba de descripcion",
            "16/03/2024", R.drawable.user3, R.drawable.star1))
        lista.add(Resena("Kevin", "Prueba de descripcion",
            "16/03/2024", R.drawable.user4, R.drawable.star1))
        return lista
    }

}
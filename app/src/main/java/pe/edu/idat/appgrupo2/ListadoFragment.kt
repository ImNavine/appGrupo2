package pe.edu.idat.appgrupo2

import android.annotation.SuppressLint
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
        lista.add(Resena("Juan", "Fantástica app, me ayuda mucho en mi día a día. ¡Gracias!",
            "16/03/2024", R.drawable.user1, R.drawable.star4))
        lista.add(Resena("María", "Súper útil y fácil de usar. Ha mejorado mi organización enormemente.",
            "15/03/2024", R.drawable.user2, R.drawable.star5))
        lista.add(Resena("Laura", "Increíble para llevar un seguimiento de mis tareas. Totalmente recomendada.",
            "14/03/2024", R.drawable.user3, R.drawable.star4))
        lista.add(Resena("Carlos", "La última actualización trajo funciones geniales. ¡Bravo al equipo de desarrollo!",
            "13/03/2024", R.drawable.user4, R.drawable.star5))
        lista.add(Resena("Marcos", "Me gustaba más antes, pero no está mal.",
            "12/03/2024", R.drawable.user5, R.drawable.star3))
        lista.add(Resena("Pablo", "Horrible.",
            "11/03/2024", R.drawable.user6, R.drawable.star1))
        lista.add(Resena("Sofía", "Simple y efectiva. Hace lo que promete sin complicaciones.",
            "10/03/2024", R.drawable.user7, R.drawable.star4))
        lista.add(Resena("Marta", "Sorprendente la cantidad de opciones de personalización, los cuales no sirven para nada.",
            "09/03/2024", R.drawable.user8, R.drawable.star1))
        lista.add(Resena("Andrea", "Una app imprescindible en mi vida diaria. ¡Gracias por tanto!",
            "08/03/2024", R.drawable.user9, R.drawable.star4))
        lista.add(Resena("Javier", "No ueso mucho la App.",
            "07/03/2024", R.drawable.user10, R.drawable.star3))
        return lista
    }

}
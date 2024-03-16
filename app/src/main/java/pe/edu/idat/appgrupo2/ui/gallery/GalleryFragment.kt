package pe.edu.idat.appgrupo2.ui.gallery

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.appgrupo2.R
import pe.edu.idat.appgrupo2.databinding.FragmentGalleryBinding
import java.util.Calendar

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root


        ArrayAdapter.createFromResource(requireContext(), R.array.dias, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spdia.adapter = adapter
        }

        ArrayAdapter.createFromResource(requireContext(), R.array.cantiPerros, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spcantiperros.adapter = adapter
        }

        binding.btnfecha.setOnClickListener {
            mostrarDatePicker()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun mostrarDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)


        val datePickerDialog = DatePickerDialog(requireContext(), { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            val fechaSeleccionada = "$dayOfMonth/$month/$year"
            binding.tvFecha.setText(fechaSeleccionada)
        }, year, month, dayOfMonth)

        datePickerDialog.show()
    }
}

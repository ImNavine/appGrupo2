package pe.edu.idat.appgrupo2.Formulario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import pe.edu.idat.appgrupo2.R
import pe.edu.idat.appgrupo2.databinding.FragmentFormularioBinding


class FormularioFragment : Fragment(), AdapterView.OnItemSelectedListener, View.OnClickListener {

    private var _binding: FragmentFormularioBinding?=null
    private val binding get() = _binding!!
    private var razonreserva=""
    private var cantidad=""
    private val listaFormularios=ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentFormularioBinding.inflate(inflater, container, false)

        binding.sprazonreserva.onItemSelectedListener=this
        binding.spcantidad.onItemSelectedListener=this

        binding.btnreservar.setOnClickListener(this)
        binding.btnlistar.setOnClickListener(this)

        ArrayAdapter.createFromResource(requireContext(), R.array.razon_reserva, android.R.layout.simple_spinner_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.sprazonreserva.adapter=adapter}

        ArrayAdapter.createFromResource(requireContext(), R.array.cantidad, android.R.layout.simple_spinner_item).also {
                adapter -> adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spcantidad.adapter=adapter}

        return binding.root
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        razonreserva=if(position>0){
            parent!!.getItemAtPosition(position).toString()
        }else ""

        cantidad=if (position>0){
            parent!!.getItemAtPosition(position).toString()
        }else ""
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onClick(vista: View) {
        when(vista.id){
            R.id.btnreservar->registrarFormulario()
            R.id.btnlistar -> {
                val navController = findNavController()
                val bundle = Bundle().apply {
                    putStringArrayList("listaformularios", listaFormularios)
                }
                navController.navigate(R.id.listaFormularioFragment, bundle)
            }


        }
    }

    fun validarFechaInicio():Boolean{
        var respuesta=true
        if(binding.etfechainicio.text.toString().trim().isEmpty()){
            binding.etfechainicio.isFocusableInTouchMode=true
            binding.etfechainicio.requestFocus()
            respuesta=false
        }
        return respuesta
    }

    fun validarFechaFinal():Boolean{
        var respuesta=true
        if(binding.etfechafinal.text.toString().trim().isEmpty()){
            binding.etfechafinal.isFocusableInTouchMode=true
            binding.etfechafinal.requestFocus()
            respuesta=false
        }
        return respuesta
    }

    fun validarRazonReserva():Boolean{
        return razonreserva!=""
    }

    fun validarCantidad():Boolean{
        return cantidad!=""
    }

    fun validarFormulario():Boolean{
        var respuesta=false
        if(!validarRazonReserva()){
            Toast.makeText(context, "Seleccione un motivo", Toast.LENGTH_LONG)
        } else if(!validarCantidad()){
            Toast.makeText(context, "Seleccione una cantidad", Toast.LENGTH_LONG)
        } else if (!validarFechaInicio()){
            Toast.makeText(context, "Ingrese una fecha de inicio", Toast.LENGTH_LONG)
        } else if(!validarFechaFinal()){
            Toast.makeText(context, "Ingrese una fecha final", Toast.LENGTH_LONG)
        }else respuesta=true
        return respuesta
    }

    private fun setearControles(){
        binding.sprazonreserva.setSelection(0)
        binding.spcantidad.setSelection(0)
        binding.etfechainicio.setText("")
        binding.etfechafinal.setText("")
    }
    fun registrarFormulario(){
        if (validarFormulario()){
            val infoFormulario= razonreserva+ " "+ cantidad+" "+
                    binding.etfechainicio.text.toString()+" "+binding.etfechafinal.text.toString()
            listaFormularios.add(infoFormulario)
            Toast.makeText(context, "Registro exitoso", Toast.LENGTH_LONG)
            setearControles()
        }
    }
}
package pe.edu.idat.appgrupo2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.appgrupo2.databinding.ItemResenaBinding

class AdapterResena ( val listaResena: List<Resena>, val context: Context)
    :RecyclerView.Adapter<AdapterResena.ViewHolder>(){

    inner class ViewHolder(val binding: ItemResenaBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemResenaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount()=listaResena.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listaResena[position]){
                binding.tvnombre.text=nombre
                binding.tvdescripcion.text=descripcion
                binding.tvfecha.text=fecha
                binding.ivusuario.setImageResource(img)
                binding.ivstar.setImageResource(star)
                binding.cvresena.setOnClickListener(View.OnClickListener {
                    Toast.makeText(context, "Ha seleccionado a $nombre", Toast.LENGTH_LONG).show()
                })
            }
        }
    }


}

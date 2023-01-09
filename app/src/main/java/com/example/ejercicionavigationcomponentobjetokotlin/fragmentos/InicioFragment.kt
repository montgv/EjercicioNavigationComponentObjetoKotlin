package com.example.ejercicionavigationcomponentobjetokotlin.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.ejercicionavigationcomponentobjetokotlin.Persona
import com.example.ejercicionavigationcomponentobjetokotlin.R
import com.example.ejercicionavigationcomponentobjetokotlin.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {
    private lateinit var binding: FragmentInicioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        binding.btSegundaPantalla.setOnClickListener {
            //Si los editText en la vista están vacíos, nos muestra un aviso con el texto
            //introducido, sino lo que hace es guardar en un objeto persona nuevo los
            //editText de la vista puesto que son los atributos del objeto persona
            if (binding.edNombre.getText().toString().isEmpty() || binding.edApellidos.getText()
                    .toString().isEmpty() || binding.edTelefono.getText().toString().isEmpty()) {
                Toast.makeText(context, "Debes introducir valores en todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                //Creamos un objeto persona, capturando los valores de los EditText
                val registro = Persona(binding.edNombre.getText().toString(), binding.edApellidos.getText().toString(),
                    binding.edTelefono.getText().toString().toInt()
                )

                //Creamos un objeto de tipo Bundle en el que guardamos el objeto persona que queremos
                //mandar a la siguiente activity
                val action = PrimerFragmentDirections.actionPrimerFragmentToSegundoFragment(registro)

                //Navegamos a un destino desde el gráfico de navegación actual y mandando el bundle
                navController.navigate(action)
            }
        }
    }
}
package com.example.ejercicionavigationcomponentobjetokotlin.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.ejercicionavigationcomponentobjetokotlin.Persona
import com.example.ejercicionavigationcomponentobjetokotlin.databinding.FragmentSegundoBinding

class SegundoFragment : Fragment() {
    private lateinit var binding: FragmentSegundoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSegundoBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        //Obtenemos los argumentos si no son nulos
        if (arguments != null) {
            //Obtenemos los argumentos via bundle
            val registro: Persona? = arguments?.getParcelable("persona")

            //Asignamos a las variables TextView que muestren los datos del objeto persona que
            //hemos mandado con bundle de la otra activity
            binding.txtNombre.setText("El nombre es: " + registro.getNombre())
            binding.txtApellido.setText("Los apellidos son: " + registro.getApellidos())
            binding.txtTelefono.setText("El telefono es: " + registro.getTelefono())
    }
}
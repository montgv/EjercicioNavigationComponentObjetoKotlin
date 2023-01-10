package com.example.ejercicionavigationcomponentobjetokotlin.fragmentos

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.ejercicionavigationcomponentobjetokotlin.Persona
import com.example.ejercicionavigationcomponentobjetokotlin.R
import com.example.ejercicionavigationcomponentobjetokotlin.databinding.FragmentSegundoBinding

//Creamos la clase SegundoFragmento que extiende de Fragment que representa una interfaz particular
// que se ejecuta dentro de un Activity
class SegundoFragment : Fragment() {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private lateinit var binding: FragmentSegundoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //Método llamado para que el fragmento cree una instancia de su vista de interfaz de usuario
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Estas lineas hace que se nos vincule las vistas con el fragmento
        binding = FragmentSegundoBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    //Indica que se debe ignorar las advertencias específicas
    @SuppressLint("SetTextI18n")
    //Método que se llama justo después que el anterior, haya regresado, pero antes de que se haya
    //restaurado cualquier estado guardado en la vista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Declaramos la variable para que encuentre ese componente en la vista
        val navController = Navigation.findNavController(view)

        //Obtenemos los argumentos si no son nulos
        if (arguments != null) {
            //Obtenemos los argumentos via bundle
            val registro: Persona? = arguments?.getParcelable("persona")

            //Asignamos a las variables TextView que muestren los datos del objeto persona que
            //hemos mandado con bundle del otro fragmento
            binding.txtNombre.text = "El nombre es: " + registro?.nombre
            binding.txtApellido.text = "Los apellidos son: " + registro?.apellidos
            binding.txtTelefono.text = "El telefono es: " + registro?.telefono
        }

        //Definimos un escuchador mediante el método setOnClickListener que esta asociado al boton
        //con su vista, cuando se pulsa el botón, navegamos a un destino desde el gráfico de
        //navegación actual
        binding.btPantallaFinal.setOnClickListener {
            navController.navigate(R.id.action_segundoFragment_to_finalFragment)
        }
    }
}
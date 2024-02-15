package asb.m08.m08_uf1_23_videojocs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)

        // Obté les dades del videojoc dels arguments (o d'on sigui que les passis)
        val videojoc = arguments?.getParcelable<Videojoc>("videojoc")

        // Actualitza els elements de la vista amb les dades del videojoc
        val lblVideojocTitol = view.findViewById<TextView>(R.id.TxtVwTitol)
        val imgVideojoc = view.findViewById<ImageView>(R.id.ImgVwCaratula)
        val lblVideojocJugadors = view.findViewById<TextView>(R.id.TxtVwJugs)

        videojoc?.let {
            lblVideojocTitol.text = it.titol
            imgVideojoc.setImageResource(it.imatge)
            lblVideojocJugadors.text = "Jugadors: ${it.jugadors}"
        }

        return view
    }
}
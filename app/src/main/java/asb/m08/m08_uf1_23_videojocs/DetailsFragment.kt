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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        //obtenim el layout del fragment (unió kotlin - xml)
        var view = inflater.inflate(R.layout.fragment_details, container, false)
        return view
    }
    fun setVideojoc(videojoc: Videojoc)
    {
        var ImgVwCaratula = view?.findViewById<ImageView>(R.id.ImgVwCaratula)
        ImgVwCaratula?.setImageResource(videojoc.imatge)
        var TxtVwTitol = view?.findViewById<TextView>(R.id.TxtVwTitol)
        TxtVwTitol?.text = videojoc.titol
        var TxtVwJugs = view?.findViewById<TextView>(R.id.TxtVwJugs)
        TxtVwJugs?.text = "Jugadors: " + videojoc.jugadors.toString()
    }
}
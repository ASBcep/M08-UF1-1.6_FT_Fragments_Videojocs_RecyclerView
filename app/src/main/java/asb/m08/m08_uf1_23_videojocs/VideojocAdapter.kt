package asb.m08.m08_uf1_23_videojocs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class VideojocAdapter (context: Context, val layout: Int, val videojocs: MutableList<Videojoc>):
    ArrayAdapter<Videojoc>(context, layout, videojocs)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        var view: View

        if(convertView != null)
        {
            view = convertView
        } else {
            view = LayoutInflater.from(getContext()).inflate(layout, parent, false)
        }

        bindVideojoc(view, videojocs[position])

        return view
    }
    fun bindVideojoc(view: View, videojoc: Videojoc)
    {
        val videojocCaratula = view.findViewById(R.id.ImgVwCaratulaList) as ImageView
        videojocCaratula.setImageResource(videojoc.imatge)

        val videojocTitol = view.findViewById(R.id.TxtVwTitolList) as TextView
        videojocTitol.text = videojoc.titol

        val videojocJugadors = view.findViewById(R.id.TxtVwJugsList) as TextView
        videojocJugadors.text = "Jugadors: " + videojoc.jugadors

    }
}
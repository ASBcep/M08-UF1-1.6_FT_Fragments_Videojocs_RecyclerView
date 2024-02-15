package asb.m08.m08_uf1_23_videojocs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment: Fragment()
{
    private lateinit var listener: MyOnClickListener
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val videojocs = getVideojocs()
        //obtenim el layout del fragment (unió kotlin - xml)
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val lstVideojocs = view.findViewById<RecyclerView>(R.id.RclrVwListVj)

        //val adapter = VideojocAdapter(activity, videojocs)
        val adapter = activity?.let { VideojocAdapter(it, videojocs) }//chatgpt 15-2-24
        lstVideojocs.hasFixedSize()
        lstVideojocs.layoutManager = LinearLayoutManager(activity)
        lstVideojocs.adapter = adapter

        if (adapter != null) {
            adapter.setOnClickListener()
            {
                val videojoc = videojocs[lstVideojocs.getChildAdapterPosition(it)]
                val lblVideojocTitol = view.findViewById(R.id.TxtVwTitol) as TextView
                lblVideojocTitol.text = videojoc.titol

                val imgVideojoc = view.findViewById(R.id.ImgVwCaratula) as ImageView
                imgVideojoc.setImageResource(videojoc.imatge)

                val lblVideojocJugadors = view.findViewById(R.id.TxtVwJugs) as TextView
                lblVideojocJugadors.text = "Jugadors: " + videojoc.jugadors
            }
        }
        return view
    }
    fun setListener(listen: MyOnClickListener?)
    {
        if (listen != null)
        {
            listener = listen
        }
    }
    fun getVideojocs(): MutableList<Videojoc>{
        return mutableListOf(
            Videojoc("Red Dead Redemption II", R.drawable.rdr2, 150000000),
            Videojoc("Grand Theft Auto V", R.drawable.gtav, 1000000000),
            Videojoc("Kingdom Hearts", R.drawable.kingdomhearts, 52424774),
            Videojoc("Super Mario Odissey", R.drawable.smo, 245789544),
            Videojoc("Pokémon edición Amarilla", R.drawable.pkmnamarillo, 999999999),
            Videojoc("Spyro 3: Year of the Dragon", R.drawable.spyro3, 65484825),
            Videojoc("Crash Bandicoot 2", R.drawable.crash2, 547471415),
            Videojoc("Metroid Dread", R.drawable.metroidread, 3389985),
            Videojoc("Hogwarts Legacy", R.drawable.hogwartslegacy, 514789),
            Videojoc("International Rally Championship", R.drawable.irc, 130000),
        )
    }
}
package asb.m08.m08_uf1_23_videojocs

import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_main)

        val videojocs = getVideojocs()

        val lstVideojocs = findViewById(R.id.RclrVwListVj) as RecyclerView

        val adapter = VideojocAdapter(this, videojocs)
        lstVideojocs.hasFixedSize()
        lstVideojocs.layoutManager = LinearLayoutManager(this)
        lstVideojocs.adapter = adapter

        adapter.setOnClickListener()
        {
            val videojoc = videojocs[lstVideojocs.getChildAdapterPosition(it)]
            val lblVideojocTitol = findViewById(R.id.TxtVwTitol) as TextView
            lblVideojocTitol.text = videojoc.titol

            val imgVideojoc = findViewById(R.id.ImgVwCaratula) as ImageView
            imgVideojoc.setImageResource(videojoc.imatge)

            val lblVideojocJugadors = findViewById(R.id.TxtVwJugs) as TextView
            lblVideojocJugadors.text = "Jugadors: " + videojoc.jugadors
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
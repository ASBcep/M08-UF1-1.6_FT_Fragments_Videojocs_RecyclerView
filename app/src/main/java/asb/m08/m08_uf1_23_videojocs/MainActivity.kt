package asb.m08.m08_uf1_23_videojocs

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

/*
* Has de crear un nou projecte Android anomenat Videojocs.
* Has de configurar la teva aplicació per què es vegi en horitzontal,
* encara que mantinguem el dispositiu en vertical (investigueu com).
* En la part esquerra de la pantalla, es mostrarà una llista de
* videojocs (han d’haver-hi entre 8 i 10). A la llista,
* per cada videojoc es mostrarà una imatge i el seu nom.
* Quan l’usuari faci clic sobre un videojoc de la llista,
* es mostrarà en la part dreta de la pantalla la seva imatge
* (en gran) i el seu nom (sota la imatge gran) i un número
* corresponent al número de jugadors que han jugat
* (us ho podeu inventar). Aquesta última dada no es mostrarà a la
* llista; només es mostrarà a la part dreta. Serà tasca teva decidir
* quins jocs formaran part de la llista i trobar les imatges
* (que hauran de ser rectangulars i no quadrades).
* */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        setContentView(R.layout.activity_main)

        var llistaMutableVideojocs = mutableListOf(Videojoc("Red Dead Redemption II", R.drawable.rdr2, 150000000),
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
        val lstVideojocs = this.findViewById(R.id.LstVwListVj) as ListView

        val adapter = VideojocAdapter(this, R.layout.listview_videojocs_items, llistaMutableVideojocs)
        lstVideojocs.adapter = adapter

        lstVideojocs.setOnItemClickListener()
        {
            adapterView, view, i, l ->

            val lblVideojocTitol = findViewById(R.id.TxtVwTitol) as TextView
            lblVideojocTitol.text = llistaMutableVideojocs[i].titol

            val imgVideojoc = findViewById(R.id.ImgVwCaratula) as ImageView
            imgVideojoc.setImageResource(llistaMutableVideojocs[i].imatge)

            val lblVideojocJugadors = findViewById(R.id.TxtVwJugs) as TextView
            lblVideojocJugadors.text = "Jugadors: " + llistaMutableVideojocs[i].jugadors.toString()

        }
    }
}
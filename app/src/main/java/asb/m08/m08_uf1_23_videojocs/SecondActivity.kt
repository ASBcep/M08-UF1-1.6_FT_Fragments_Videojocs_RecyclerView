package asb.m08.m08_uf1_23_videojocs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //rebo int de l'intent que obre l'activity
        val videojoc = intent.getSerializableExtra("videojoc") as Videojoc?
        var manager = supportFragmentManager
        var fragment = manager.findFragmentById(R.id.FrgDetails) as DetailsFragment
        if (videojoc != null) {
            fragment.setVideojoc(videojoc)
        }
    }
}
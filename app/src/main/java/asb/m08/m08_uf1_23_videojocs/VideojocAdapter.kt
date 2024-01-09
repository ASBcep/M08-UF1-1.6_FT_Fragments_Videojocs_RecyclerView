package asb.m08.m08_uf1_23_videojocs

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VideojocAdapter (private val context: Context, private val videojocs: MutableList<Videojoc>):
    RecyclerView.Adapter<VideojocAdapter.VideojocViewHolder>(),
    View.OnClickListener
{
    private val layout = R.layout.listview_videojocs_items
    private var clickListener: View.OnClickListener? = null
    class VideojocViewHolder(val view: View): RecyclerView.ViewHolder(view)
    {
        val videojocCaratula = view.findViewById(R.id.ImgVwCaratulaList) as ImageView
        val videojocTitol = view.findViewById(R.id.TxtVwTitolList) as TextView
        //val videojocJugadors = view.findViewById(R.id.TxtVwJugsList) as TextView

        /*
        val videojocCaratula: ImageView
        val videojocTitol = view.findViewById(R.id.TxtVwTitolList) as TextView
        //val videojocJugadors = view.findViewById(R.id.TxtVwJugsList) as TextView
        init {
            videojocCaratula = view.findViewById(R.id.ImgVwCaratulaList)
        }
        */
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideojocViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)

        view.setOnClickListener(this)

        return VideojocViewHolder(view)
    }
    override fun onBindViewHolder(holder: VideojocViewHolder, position: Int) {
    val videojoc = videojocs[position]
    bindVideojoc(holder, videojoc)
    }
    override fun getItemCount() = videojocs.size
    /*
    fun bindVideojoc(holder: VideojocViewHolder, videojoc: Videojoc)
    {
        val videojocPath = context.getFilesDir().toString() + "/img/" + videojoc.imatge
        val bitmap = BitmapFactory.decodeFile(videojocPath)
        holder.videojocCaratula?.setImageBitmap(bitmap)
        holder.videojocTitol?.text = videojoc.titol
        //holder.videojocJugadors?.text = "Jugadors: " + videojoc.jugadors
    }
    */
    fun bindVideojoc(holder: VideojocViewHolder, videojoc: Videojoc) {
        holder.videojocCaratula?.setImageResource(videojoc.imatge)
        holder.videojocTitol?.text = videojoc.titol
        //holder.videojocJugadors?.text = "Jugadors: " + videojoc.jugadors
    }


    fun setOnClickListener(listener: View.OnClickListener)
    {
        clickListener = listener
    }

    override fun onClick(view: View?)
    {
        clickListener?.onClick(view)
    }
}
    /*//original a partir d'aquí
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

    }*/

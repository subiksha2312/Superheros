package com.example.superheroes.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroes.R
import com.example.superheroes.data.SuperheroImage
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.superheroinfo.view.*
import okio.Utf8.size
import java.nio.file.Files.size


class SuperheroInfoAdapter(private val superInfoList: List<SuperheroImage>,
                           private val onItemClicked: (position: Int) -> Unit) : RecyclerView.Adapter<SuperheroInfoAdapter.ViewHolder> () {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.superheroinfo, parent, false)
        return ViewHolder(view, onItemClicked)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindSuperInfo(superInfoList[position])
    }

    override fun getItemCount(): Int =superInfoList.size


    class ViewHolder(val view: View, private val onItemClicked: (position: Int) -> Unit): RecyclerView.ViewHolder(view),View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bindSuperInfo(SuperInfo: SuperheroImage) {
            if (SuperInfo.name.isNotEmpty() ) {
                itemView.SuperheroName.text=SuperInfo.name ?:"Not Available"
                itemView.intelligence.text = (SuperInfo.powerstats.intelligence.toString()  ?: "Not Available")
                itemView.strength.text= (SuperInfo.powerstats.strength.toString() ?:"Not Available") as CharSequence?
                itemView.speed.text=(SuperInfo.powerstats.speed.toString() ?:"Not Available") as CharSequence?
                Picasso.get().load(SuperInfo.images.lg).into(itemView.SuperheroImage)
            }

            else {
                itemView.SuperheroName.text = "Breed Info Not Available"
                Picasso.get()
                    .load(SuperInfo.images.lg)
                    .resize(500,250)
                    .into(itemView.SuperheroImage)
            }


        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            onItemClicked(position)
        }
    }
}


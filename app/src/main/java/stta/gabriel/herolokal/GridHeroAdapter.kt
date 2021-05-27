package stta.gabriel.herolokal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<GridHeroAdapter.GridViewHolder>() {
    private lateinit var setonItemClickCallback: onItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: onItemClickCallback) {
        this.setonItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_grid_hero, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
                .load(listHero[position].photo)
                .apply(RequestOptions().override(350, 550))
                .into(holder.imgphoto)

      holder.itemView.setOnClickListener { setonItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }

    }

    override fun getItemCount(): Int {
        return listHero.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgphoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface onItemClickCallback {
        fun onItemClicked(data: Hero)

    }


}
package ya.deneno.plants

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ya.deneno.plants.databinding.PlantItemBinding

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder>() {
    private val plantList = ArrayList<Plant>()

    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        private val bcPlant = PlantItemBinding.bind(item)

        fun bind(plant: Plant) = with(bcPlant) {
            ivPlantItem.setImageResource(plant.imageId)
            tvPlantItem.text = plant.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return PlantHolder(view)
    }

    override fun onBindViewHolder(holder: PlantHolder, position: Int) {
        holder.bind(plantList[position])
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    fun addPlant(plant: Plant) {
        plantList.add(plant)
        notifyDataSetChanged()
    }
}
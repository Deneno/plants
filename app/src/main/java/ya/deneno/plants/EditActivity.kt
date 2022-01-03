package ya.deneno.plants

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ya.deneno.plants.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    private lateinit var bc: ActivityEditBinding
    private val imageList = listOf(
        R.drawable.plant1,
        R.drawable.plant2,
        R.drawable.plant3,
        R.drawable.plant4,
        R.drawable.plant5)
    private var indexImage = 0
    private var imageId = R.drawable.plant1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bc = ActivityEditBinding.inflate(layoutInflater)
        setContentView(bc.root)
        initButtons()
    }

    private fun initButtons() {
        bc.apply {
            bEditNext.setOnClickListener {
                indexImage++
                if (indexImage > imageList.size-1) indexImage = 0
                Log.d("MyLog", "Index: $indexImage")
                imageId = imageList[indexImage]
                ivPlantEdit.setImageResource(imageId)
            }
            bEditPrev.setOnClickListener {
                indexImage--
                if (indexImage < 0) indexImage = imageList.size-1
                Log.d("MyLog", "Index: $indexImage")
                imageId = imageList[indexImage]
                ivPlantEdit.setImageResource(imageId)
            }
            bDone.setOnClickListener {
                val plant = Plant(imageId, etPlantTitle.text.toString(), etPlantDesc.text.toString())
                intent.putExtra("plant", plant)
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}
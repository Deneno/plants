package ya.deneno.plants

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import ya.deneno.plants.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bc: ActivityMainBinding
    private val adapter = PlantAdapter()
    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bc.root)
        init()
        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
             if (it.resultCode == RESULT_OK) {
                adapter.addPlant(it.data?.getSerializableExtra("plant") as Plant)
            }
        }
    }

    private fun init() {
        bc.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
            button.setOnClickListener{
                editLauncher?.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }
}
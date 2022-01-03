package ya.deneno.plants

import java.io.FileDescriptor
import java.io.Serializable

data class Plant(
    val imageId: Int,
    val title: String,
    val description: String): Serializable

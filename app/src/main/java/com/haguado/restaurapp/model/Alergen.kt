package com.haguado.restaurapp.model

import com.haguado.restaurapp.R
import java.io.Serializable

enum class Alergen (val string: String, val img: Int ): Serializable{
    LACTOSE("Lactosa", R.drawable.lactose ),
    GLUTEN("Gluten", R.drawable.gluten),
    SOY("Soja", R.drawable.soyb),
    EGG("Huevo", R.drawable.egg),
    SHRIMP("Gambas", R.drawable.shrimp)
}

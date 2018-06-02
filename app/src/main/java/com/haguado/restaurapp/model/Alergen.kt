package com.haguado.restaurapp.model

import com.haguado.restaurapp.R

enum class Alergen (val string: String, val img: Int ){
    LACTOSE("Lactosa", R.drawable.lactose ),
    GLUTEN("Gluten", R.drawable.gluten),
    SOY("Soja", R.drawable.soyb),
    EGG("Huevo", R.drawable.egg),
    SHRIMP("Gambas", R.drawable.shrimp)
}

package com.haguado.restaurapp.model

import com.haguado.restaurapp.R

object RestaurantMenu {
    private val restaurantMenu: List<Meal> = listOf(
        Meal(1,"Arroz con marisco",
            "Arroz caldoso con marisco y deconstrucción de gambas de Galicia",
            10.50f,
            listOf(Alergen.SHRIMP),
            R.drawable.arroz_marisco),
        Meal(2, "Dim - Sum variado",
            "docena de Dim - Sum de harina de arroz al estilo pequinés. De cerdo, ternera, langostino y pollo",
            9.90f,
            listOf(Alergen.SHRIMP),
            R.drawable.dim_sum),
        Meal(3, "Boeuf Bourguignon",
            "Carne de ternera estofada, con salsa de champiñones, panceta y vino tinto de la tierra",
            9.50f,
            listOf(),
            R.drawable.boeuf_bourguignon),
        Meal(4, "Cordero lechal sobre puré de patata",
            "Costillas de cordero lechal asado a la cebolla sobre cama de puré espumoso de patata",
            11.50f,
            listOf(),
            R.drawable.cordero_lechal),
        Meal(5, "Quiche Antoshka",
            "Quiche de espárragos, brócoli, champiñones pimiento verde y perejil acompañada con una ensalada fresca de manzana",
            9.00f,
            listOf(Alergen.EGG, Alergen.GLUTEN, Alergen.LACTOSE),
            R.drawable.quiche),
        Meal(6, "Picadillo de tejares",
            "Picadillo al estilo charro de carne picada de ternera morucha, con cebolla, huevo, ajo y pan duro",
            10.00f,
            listOf(Alergen.EGG, Alergen.GLUTEN),
            R.drawable.picadillo),
        Meal(7, "Trufas de praliné",
            "Trufas de praliné, avellanas, chocolate con leche, galleta y quicos",
            15.02f,
            listOf(Alergen.EGG, Alergen.LACTOSE),
            R.drawable.trufas
        ),
        Meal(8, "Tarteleta silvestre",
            "Tartaleta de Crema Pastelera de soja y mousse de frutos rojos ( arándanos, frambuesas y grosellas",
            10.99f,
            listOf(Alergen.EGG, Alergen.GLUTEN, Alergen.SOY),
            R.drawable.tartaleta
        ),
        Meal(9, "Ponche al estilo segoviano",
            "El sabor de este postre típico de Segovia te sorprenderá. Bizcocho borracho relleno de crema y con cobertura de mazapán",
            12.50f,
            listOf(Alergen.EGG ,Alergen.GLUTEN, Alergen.LACTOSE),
            R.drawable.ponche)
    )

    val count
        get() = restaurantMenu.size

    fun getMeal(index: Int) = restaurantMenu[index]

}
package com.ecervera.cocktails.domain

data class Drink(
    val idDrink: String,
    val alcoholic: String,
    val category: String,
    val creativeCommonsConfirmed: String,
    val name: String,
    val drinkThumb: String? = null,
    val glass: String,
    val imageSource: String,
    val ingredient1: String,
    val ingredient10: String? = null,
    val ingredient11: String? = null,
    val ingredient12: String? = null,
    val ingredient13: String? = null,
    val ingredient14: String? = null,
    val ingredient15: String? = null,
    val ingredient2: String? = null,
    val ingredient3: String? = null,
    val ingredient4: String? = null,
    val ingredient5: String? = null,
    val ingredient6: String? = null,
    val ingredient7: String? = null,
    val ingredient8: String? = null,
    val ingredient9: String? = null,
    val instructions: String,
    val measure1: String,
    val measure10: String? = null,
    val measure11: String? = null,
    val measure12: String? = null,
    val measure13: String? = null,
    val measure14: String? = null,
    val measure15: String? = null,
    val measure2: String? = null,
    val measure3: String? = null,
    val measure4: String? = null,
    val measure5: String? = null,
    val measure6: String? = null,
    val measure7: String? = null,
    val measure8: String? = null,
    val measure9: String? = null,
    val tags: String? = null,
    val video: String? = null,
    val isFavorite: Boolean,
) {
    val painter: String
        get() = handlePainter(imageSource, drinkThumb)

    private val ingredients: List<String?>
        get() = generateIngredientList()

    private val measures: List<String?>
        get() = generateMeasureList()

    val ingredientsAndMeasure: List<IngredientAndMeasure>
        get() = generateIngredientAndMeasureList()

    private fun generateIngredientAndMeasureList(): List<IngredientAndMeasure> {
        var items: MutableList<IngredientAndMeasure> = mutableListOf()
        ingredients.forEachIndexed { i, ingredient ->

            if(ingredient != null) {
                items.add(IngredientAndMeasure(ingredient = ingredient, measure = measures[i] ?: ""))
            }
        }

        return items
    }

    private fun handlePainter(imageSource: String, drinkThumb: String?): String {
        return if (imageSource.contains("www.thecocktaildb.com")) imageSource
        else drinkThumb ?: ""
    }

    private fun generateMeasureList(): List<String?> = listOf(
        measure1,
        measure2,
        measure3,
        measure4,
        measure5,
        measure6,
        measure7,
        measure8,
        measure9,
        measure10,
        measure11,
        measure12,
        measure13,
        measure14,
        measure15
    )

    private fun generateIngredientList(): List<String?> = listOf(
        ingredient1,
        ingredient2,
        ingredient3,
        ingredient4,
        ingredient5,
        ingredient6,
        ingredient7,
        ingredient8,
        ingredient9,
        ingredient10,
        ingredient10,
        ingredient11,
        ingredient12,
        ingredient13,
        ingredient14,
        ingredient15
    )
}

data class IngredientAndMeasure(val ingredient: String, val measure: String)
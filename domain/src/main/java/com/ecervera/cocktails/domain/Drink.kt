package com.ecervera.cocktails.domain

data class Drink(
    val idDrink: String,
    val alcoholic: String,
    val category: String,
    val creativeCommonsConfirmed: String,
    val name: String,
    val drinkThumb: String?,
    val glass: String,
    val imageSource: String,
    val ingredient1: String,
    val ingredient10: String?,
    val ingredient11: String?,
    val ingredient12: String?,
    val ingredient13: String?,
    val ingredient14: String?,
    val ingredient15: String?,
    val ingredient2: String?,
    val ingredient3: String?,
    val ingredient4: String?,
    val ingredient5: String?,
    val ingredient6: String?,
    val ingredient7: String?,
    val ingredient8: String?,
    val ingredient9: String?,
    val instructions: String,
    val measure1: String,
    val measure10: String?,
    val measure11: String?,
    val measure12: String?,
    val measure13: String?,
    val measure14: String?,
    val measure15: String?,
    val measure2: String?,
    val measure3: String?,
    val measure4: String?,
    val measure5: String?,
    val measure6: String?,
    val measure7: String?,
    val measure8: String?,
    val measure9: String?,
    val tags: String?,
    val video: String?,
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
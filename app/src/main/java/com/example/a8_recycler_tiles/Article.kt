package com.example.a8_recycler_tiles

data class Article(
    val header: String,
    val text: String,
    val headerColor: String,
    val xGrid: Int,
    val yGrid: Int
) {
    companion object {
        fun getMockArticles() = listOf<Article>(
            Article(
                "ВНИМАНИЕ!",
                "Стипендия повышается на 1780 руб. ОДНИМ КЛИКОМ! Преподы НЕНАВИДЯТ этот способ...",
                "#FF0000",
                1,
                2
            ),
            Article(
                "Нам нечего постить",
                "Пришлите пожалуйста смешнявочки мы вам заплатим",
                "#000000",
                2,1
            ),
            Article(
                "Услуги сдачи диплома!",
                "Плагиат-тесты показывают всего лишь 60%! Не упустите!",
                "#0000FF",
                2,1
            ),
            Article(
                "Продам гараж",
                "+88005553555",
                "#00FF00",
                2,1
            ),
            Article(
                "Не хочешь в армию?",
                "Пойдешь негодяй ;)",
                "#008800",
                1,1
            )

        )
    }
}
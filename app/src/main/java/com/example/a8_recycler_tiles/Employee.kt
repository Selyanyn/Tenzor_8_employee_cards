package com.example.a8_recycler_tiles

data class Employee(
    val id: Long,
    val fullName: String,
    val photoUrl: String,
    val department: String
) {
    companion object {
        fun getMockEmployees() = listOf(
            Employee(
                0,
                "Степан Хардович",
                "",
                "Страдальческий отдел"
            ),
            Employee(
                1,
                "Дед инсайд",
                "",
                "Инсайдерский отдел"
            ),
            Employee(
                2,
                "Степик",
                "",
                "Отдел по решанию онлайн-курсов"
            )
        )
    }
}

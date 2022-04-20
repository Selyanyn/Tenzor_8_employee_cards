package com.example.a8_recycler_tiles

data class Employee(
    val id: Long,
    val fullName: String,
    val photoUrl: String,
    val department: String,
    var isLiked: Boolean = false
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false
        other as Employee
        return id == other.id
                && fullName == other.fullName
                && department == other.department
                && photoUrl == other.photoUrl
                && isLiked == other.isLiked
    }
}

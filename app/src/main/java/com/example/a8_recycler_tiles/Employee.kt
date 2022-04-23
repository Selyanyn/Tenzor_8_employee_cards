package com.example.a8_recycler_tiles

data class Employee(
    var id: Int,
    val fullName: String,
    val photoUrl: String,
    val department: String,
    var isLiked: Boolean = false
) {
    companion object {
        var currentId = 0
        fun getMockEmployees() = listOf(
            Employee(
                0,
                "Степан Хардович",
                "https://i.kym-cdn.com/photos/images/newsfeed/000/839/199/8a9.jpg",
                "Страдальческий отдел"
            ),
            Employee(
                1,
                "Дед инсайд",
                "https://stepik.org/static/frontend/topbar_logo.svg",
                "Инсайдерский отдел"
            ),
            Employee(
                2,
                "Степик",
                "https://memepedia.ru/wp-content/uploads/2019/09/do-it-again-meme.png",
                "Отдел по решанию онлайн-курсов"
            )
        )

        fun getRandomMockEmployee(): Employee {
            val employee = getMockEmployees().random()
            employee.id = ++currentId
            return employee
        }
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

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + fullName.hashCode()
        result = 31 * result + photoUrl.hashCode()
        result = 31 * result + department.hashCode()
        result = 31 * result + isLiked.hashCode()
        return result
    }
}

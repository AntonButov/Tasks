package ru.butov.tasks

fun List<Int>.operate(sum: Int, currentIndex: Int, target: Int): Boolean {
    if (currentIndex == this.size) {
        return sum == target
    }
    if (operate(sum + get(currentIndex), currentIndex + 1, target)) {
        return true
    }
    return operate(sum - get(currentIndex), currentIndex + 1, target)
}

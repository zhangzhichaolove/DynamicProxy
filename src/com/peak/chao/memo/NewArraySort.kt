package com.peak.chao.memo


fun main(args: Array<String>) {
    val nums = intArrayOf(11, 3, 998, 5455, 1, 152, 990)
    //nums.sort()
    //nums.sortDescending()
    System.err.println(nums.toList())


    /******************************************************************************************/
    var personList: MutableList<Person> = mutableListOf()
    personList.add(Person("Jim", 12))
    personList.add(Person("A-Lin", 12))
    personList.add(Person("Tom", 11))
    personList.add(Person("Mary", 14))
    println("----排序前----")
    personList.forEach(::println)
    personList.sortBy { it.age }
    println("----排序后----")
    personList.forEach(::println)
    //先根据age 升序排列，若age相同，根据name升序排列
    personList.sortWith(compareBy({ it.age }, { it.name }))
    println("----With排序后----")
    personList.forEach(::println)
    //sorted 方法返回排序好的list
    val sorted = personList.sorted()
    println("----Comparable排序后----")
    sorted.forEach(::println)
}

class NewArraySort {


}

data class Person(var name: String, var age: Int) : Comparable<Person> {

    override fun compareTo(other: Person): Int {
        return if (this.age == other.age) {
            this.name.compareTo(other.name)
        } else {
            this.age.compareTo(other.age)
        }
    }

}
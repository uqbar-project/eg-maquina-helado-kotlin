package ar.edu.unsam.algo2.maquinaHelado

interface IceMachine2000 {
    fun action(actionCode: Int)
    fun add(ingredientCode: Int, amount: Int)
    fun getStatus(): Int
    fun getValue(code: Int): Int
    fun setValue(code: Int, value: Int)
}
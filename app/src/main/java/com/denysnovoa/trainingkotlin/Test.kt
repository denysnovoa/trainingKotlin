package com.denysnovoa.trainingkotlin

import android.view.View
import kotlin.properties.Delegates

class Test() {

  var positiveNumber: Int by Delegates.vetoable(0) { p, old, new ->
    new > 0
  }

  val list = emptyList<Int>()

  val list2 = listOf(2, 3, 4)
  val newList = list2 + 5

  val result = list2.filterIndexed { index, i -> i % 2 == 0 }

  val result2 = list2.filter { it % 2 == 0 }

  fun test() {
    for (i in 1 until 10 step 2) {

    }

    val result = 3 suma 4
    val pair = Pair(3, "sr")
    val pair2 = 3 to "st"
  }
}

infix fun Int.suma(other: Int) = this + other


sealed class Op {
  object Show : Op()
  object Hide : Op()
  class TranslateX(val translation: Int) : Op()
  class TranslateY(val translation: Int) : Op()
}

fun runOp(op: Op, view: View) = when (op) {
  Op.Show -> view.visible(true)
  Op.Hide -> view.visible(false)
  is Op.TranslateX ->
    view.translationX = op.translation.toFloat()
  is Op.TranslateY -> view.translationY = op.translation.toFloat()
}
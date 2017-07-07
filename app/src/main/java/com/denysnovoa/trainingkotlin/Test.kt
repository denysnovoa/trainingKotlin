package com.denysnovoa.trainingkotlin

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

}
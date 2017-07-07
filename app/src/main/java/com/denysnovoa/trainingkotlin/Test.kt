package com.denysnovoa.trainingkotlin

import kotlin.properties.Delegates

class Test() {

  var positiveNumber: Int by Delegates.vetoable(0) { p, old, new ->
    new > 0
  }

  val list = emptyList<Int>()

  val list2 = listOf(2, 3, 4)
  val newList = list2 + 5

}
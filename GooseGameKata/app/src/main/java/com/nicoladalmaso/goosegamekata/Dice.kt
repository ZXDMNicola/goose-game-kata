package com.nicoladalmaso.goosegamekata

/**
 * Created by Nicola Dal Maso on 03/08/23.
 * Zextras S.R.L.
 */

data class Dice(
    var faces: Int
) {
    fun getResult() = (1..faces).random()
}
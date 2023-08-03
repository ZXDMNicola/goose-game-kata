package com.nicoladalmaso.goosegamekata

import com.google.common.truth.Truth.assertThat
import org.junit.Test


/**
 * Created by Nicola Dal Maso on 03/08/23.
 * Zextras S.R.L.
 */

class DiceTest {

    @Test
    fun checkResultBasedOnSize() {
        for(i in 0..20) {
            val faces = (1..100).random()
            val dice = Dice(faces)

            assertThat(dice.getResult()).isAtLeast(1)
            assertThat(dice.getResult()).isAtMost(faces)
        }
    }

}
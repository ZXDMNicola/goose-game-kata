package com.nicoladalmaso.goosegamekata

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test


/**
 * Created by Nicola Dal Maso on 03/08/23.
 * Zextras S.R.L.
 */
class GooseGameTest {

    lateinit var sut: GooseGame

    private val player1Name = "Nicola"
    private val player2Name = "Anna"

    @Before
    fun setup() {
        sut = GooseGame()
    }

    @Test
    fun addPlayer_Success() {
        assertThat(sut.addPlayer(player1Name)).isTrue()
        assertThat(sut.getPlayers()).hasSize(1)
        assertThat(sut.getPlayers().first().name).isEqualTo(player1Name)
    }

    @Test
    fun addPlayer_Failure() {
        assertThat(sut.addPlayer(player1Name)).isTrue()
        assertThat(sut.addPlayer(player1Name)).isFalse()
        assertThat(sut.getPlayers()).hasSize(1)
    }

    @Test
    fun startGame_Success() {
        sut.addPlayer(player1Name)
        sut.addPlayer(player2Name)
        sut.start()

        assertThat(sut.getCurrentPlayer().name).isEqualTo(player1Name)
    }

    @Test
    fun startGame_FailWithoutPlayers() {
        try {
            sut.start()
            assertThat(true).isFalse()
        } catch (_: Exception) {}
    }

    @Test
    fun throwDices_CheckResult() {

    }

}
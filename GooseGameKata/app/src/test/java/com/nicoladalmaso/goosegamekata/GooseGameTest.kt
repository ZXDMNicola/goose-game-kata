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
    private val player3Name = "Pippo"

    @Before
    fun setup() {
        sut = GooseGame()

        sut.addPlayer(player1Name)
        sut.addPlayer(player2Name)
        sut.addPlayer(player3Name)

        sut.start()
    }

    @Test
    fun addPlayer_Success() {
        sut = GooseGame()

        assertThat(sut.addPlayer(player1Name)).isTrue()
        assertThat(sut.getPlayers()).hasSize(1)
        assertThat(sut.getPlayers().first().name).isEqualTo(player1Name)
    }

    @Test
    fun addPlayer_Failure() {
        sut = GooseGame()

        assertThat(sut.addPlayer(player1Name)).isTrue()
        assertThat(sut.addPlayer(player1Name)).isFalse()
        assertThat(sut.getPlayers()).hasSize(1)
    }

    @Test
    fun startGame_Success() {
        sut = GooseGame()

        sut.addPlayer(player1Name)
        sut.addPlayer(player2Name)
        sut.start()

        assertThat(sut.getCurrentPlayer().name).isEqualTo(player1Name)
    }

    @Test
    fun startGame_FailWithoutPlayers() {
        sut = GooseGame()

        try {
            sut.start()
            assertThat(true).isFalse()
        } catch (_: Exception) {}
    }

    @Test
    fun throwDices_IncreasePositionAndPassToNextPlayer() {
        val player = sut.getCurrentPlayer()
        val previousValue = player.position

        sut.throwDices()

        //Position increase
        assertThat(player.position).isGreaterThan(previousValue)

        //Passed to the next player
        assertThat(sut.getCurrentPlayer()).isNotEqualTo(player)
    }

}
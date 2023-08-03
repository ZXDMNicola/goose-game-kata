package com.nicoladalmaso.goosegamekata

/**
 * Created by Nicola Dal Maso on 03/08/23.
 * Zextras S.R.L.
 */

class GooseGame {

    private var players: ArrayList<Player> = arrayListOf()
    private var dices: ArrayList<Dice> = arrayListOf()

    private var currentPlayerIndex: Int = 0


    @Throws(Exception::class)
    fun start() {
        if(players.isEmpty()) {
            throw Exception("You cannot start a game without players!")
        }

        val dice = Dice(2)
        dices.clear()
        dices.add(dice)
        dices.add(dice)

        currentPlayerIndex = 0
    }

    /**
     * Add player to the game
     * @param name the name of the player
     * @return true if added, else false
     */
    fun addPlayer(name: String): Boolean {
        if(players.any { it.name == name }) {
            return false
        }

        players.add(Player(name))

        return true
    }

    fun throwDices() {
        val result = dices.sumOf { it.getResult() }
        getCurrentPlayer().position += result
        nextPlayer()
    }

    fun getCurrentPlayer() = players[currentPlayerIndex]

    fun getPlayers() = players.toList()

    fun getPlayer(name: String) = players.first { it.name == name }

    private fun nextPlayer() {
        currentPlayerIndex = if(currentPlayerIndex >= players.size) {
            0
        } else {
            1
        }
    }

}
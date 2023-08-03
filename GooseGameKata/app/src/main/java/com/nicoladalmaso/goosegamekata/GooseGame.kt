package com.nicoladalmaso.goosegamekata

/**
 * Created by Nicola Dal Maso on 03/08/23.
 * Zextras S.R.L.
 */

class GooseGame {

    var players: ArrayList<Player> = arrayListOf()

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

}
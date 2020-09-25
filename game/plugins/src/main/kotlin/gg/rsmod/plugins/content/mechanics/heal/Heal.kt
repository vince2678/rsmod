package gg.rsmod.plugins.content.mechanics.heal

import gg.rsmod.game.model.entity.Player
import gg.rsmod.game.model.timer.TimerKey
import gg.rsmod.plugins.api.ext.getVarbit
import gg.rsmod.plugins.api.ext.hasEquipped
import gg.rsmod.plugins.api.ext.heal
import gg.rsmod.plugins.content.mechanics.prayer.Prayer


object Heal {

    val MAIN_HEALTH_TIMER = TimerKey()
    val DREAM_HEALTH_TIMER = TimerKey()

    var tick = 0

    private val HITPOINTS_CAPE = intArrayOf(9768)
    private val REGEN_BRACELET = intArrayOf(11133)

    fun incrementTick()
    {
        tick = (tick + 1) % 4
    }

    fun dream(p: Player)
    {
        val dreamActive = false //check if dream is active
        if (!dreamActive)
        {
            return
        }

        p.heal(1, 0)
    }

    fun heal(p: Player)
    {
        var rate = 1

        if (p.getVarbit(Prayer.RAPID_HEAL.varbit) == 1 || p.hasEquipped(HITPOINTS_CAPE))
        {
            rate *= 2
        }

        if (p.hasEquipped(REGEN_BRACELET))
        {
            rate *= 2
        }

        when (rate) {
            1 -> {
                if (tick == 0) {
                    p.heal(1, 0)
                }

                return
            }
            2 -> {
                if ((tick % 2) == 0) {
                    p.heal(1, 0)
                }

                return
            }
            in 4..Int.MAX_VALUE -> {
                p.heal(1, 0)
                return
            }
        }
    }
}
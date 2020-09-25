package gg.rsmod.plugins.content.mechanics.heal

on_login {
    player.timers[Heal.MAIN_HEALTH_TIMER] = 25
    player.timers[Heal.MAIN_HEALTH_TIMER] = 33
}

on_timer(Heal.MAIN_HEALTH_TIMER)
{
    Heal.heal(player)
    Heal.incrementTick()
    player.timers[Heal.MAIN_HEALTH_TIMER] = 25
}

on_timer(Heal.DREAM_HEALTH_TIMER)
{
    Heal.dream(player)
    player.timers[Heal.DREAM_HEALTH_TIMER] = 33
}


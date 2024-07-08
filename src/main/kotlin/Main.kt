package org.rework.uhc.api

import org.bukkit.plugin.java.JavaPlugin

class RWAPI : JavaPlugin() {
    override fun onEnable() {
        logger.info("ReWork UHC API Enabled")
    }

    
}

abstract class ReWorkPlugin : JavaPlugin() {
    abstract val api: RWAPI
}
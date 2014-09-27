package com.Funergy.BPM;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public class BungeePM extends Plugin{
	
	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerCommand(this, new PMCommand());
	}
	
	
}

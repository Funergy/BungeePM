package com.Funergy.BPM;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class PMCommand extends Command {
	public BungeePM bungeepm;

	public PMCommand() {
		super("msg", "bungeepm.use", "pm");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		 if (args.length < 1) {
             sender.sendMessage(new TextComponent(ChatColor.RED + "/msg <player> <message>"));
             return;
     }
		 
    
     ProxiedPlayer p = ProxyServer.getInstance().getPlayer(args[0]);
    
     if (p == null) {
             sender.sendMessage(new TextComponent(ChatColor.RED + "Could not find player " + args[0] + "."));
             return;
     }
     if(p.hasPermission("bungeepm.dnd")&&!sender.hasPermission("bungeepm.bypass.dnd")){
    	 sender.sendMessage(new TextComponent(ChatColor.RED + "You can't message " + args[0] + "!"));
         return;
     }
    
     StringBuilder msgBuilder = new StringBuilder();
    
     for (int i = 1; i < args.length; i++) {
             msgBuilder.append(args[i]).append(" ");
     }
    
     String msg = msgBuilder.toString().trim();
    
     p.sendMessage(new TextComponent(ChatColor.LIGHT_PURPLE+"From "+ChatColor.LIGHT_PURPLE+sender.getName() + ": "+ChatColor.GRAY + msg));
     sender.sendMessage(new TextComponent(ChatColor.LIGHT_PURPLE+"To "+ ChatColor.LIGHT_PURPLE+ args[0] + ": "+ChatColor.GRAY + msg));
		
	}

}

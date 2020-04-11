package me.moose.LockItem;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public Main plugin;
	public void onEnable() {
		plugin = this;
		System.out.print("Made by Moose1301");
		this.getServer().getPluginManager().registerEvents(this, this);
		new LockItemCommand(this);
	}
	  ArrayList<String> LockedLore = new ArrayList<String>();

	   	@EventHandler(priority = EventPriority.HIGHEST)
		  public void OnDrop(PlayerDropItemEvent e){  
			  LockedLore.add("Locked");
			  Player p = e.getPlayer();
			  List<String> ItemLore = e.getItemDrop().getItemStack().getItemMeta().getLore();	
			  if(ItemLore.get(0).contains("Locked")) {
				  p.sendMessage("§cThat Item is Locked! To drop it please type /LockItem");
				  e.setCancelled(true);
			  }
		  }
}

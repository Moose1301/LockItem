package me.moose.LockItem;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LockItemCommand implements CommandExecutor {
	public Main plugin;
	ArrayList<String> RemoveLocked = new ArrayList<String>();
    ArrayList<String> LockedLore = new ArrayList<String>();
	public LockItemCommand(Main plugin) {
	  	  this.plugin = plugin;
	 	  plugin.getCommand("lockitem").setExecutor(this);
	 	  plugin.getCommand("LockI").setExecutor(this);
	 	  plugin.getCommand("locki").setExecutor(this);
	 	  plugin.getCommand("li").setExecutor(this);
	 	  RemoveLocked.add("PH");
	 	  LockedLore.add("PH");
		}


	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  RemoveLocked.set(0, new String("Unlocked"));
		  LockedLore.set(0, new String("Locked"));
		  if (!(sender instanceof Player)) {
	            sender.sendMessage("You must be a Player to run this command");
	            return true;
		  }
		  Player p = (Player) sender;
		  ItemStack item = p.getInventory().getItemInMainHand();
		  ItemMeta im = item.getItemMeta();
		  ItemMeta im2 = item.getItemMeta();
		  ItemMeta im3 = item.getItemMeta();
		  List<String> ItemLore = im.getLore();
		  if(!(p.hasPermission("LockItem.Use"))) {
			  p.sendMessage("§cNo Permissions");
		  }
		  if(p.hasPermission("LockItem.Use.All")) {
			  if (im.hasLore() == false) {				  
				  im.setLore(LockedLore);
				  item.setItemMeta(im);
				  p.sendMessage("§cItem locked!");
				  return true;

			  } 
			  if(ItemLore.get(0).contains("Locked")) {
				  im2.setLore(RemoveLocked);
				  item.setItemMeta(im2);
				  p.sendMessage("§aItem unlocked!");
				  return true;
			  }
			  if(!(ItemLore.get(0).contains("Locked"))) {
				  im3.setLore(LockedLore);
				  item.setItemMeta(im3);
				  p.sendMessage("§cItem locked!");
				  return true;

			  }
		  return false;
	  }
		  return false;
}
}
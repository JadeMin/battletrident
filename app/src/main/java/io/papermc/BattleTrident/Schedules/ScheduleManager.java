package io.papermc.BattleTrident.Schedules;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.papermc.BattleTrident.BattleTrident;
import io.papermc.BattleTrident.Games.GameManager;



public final class ScheduleManager {
	private final BattleTrident plugin;

	public ScheduleManager(final BattleTrident plugin) {
		this.plugin = plugin;
	}

	public final void register() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this.plugin, () -> {
			if(GameManager.getGameState() == GameManager.GameState.PLAYING) {
				Bukkit.getOnlinePlayers().forEach(player -> {
					final ItemStack itemTrident = new ItemStack(Material.TRIDENT, 1);
					final ItemStack itemEnderPearl = new ItemStack(Material.ENDER_PEARL, 1);
					/*final ItemMeta meta = item.getItemMeta();

					meta.setUnbreakable(true);
					meta.addEnchant(Enchantment.LOYALTY, 1, false);
					item.setItemMeta(meta);*/

					player.getInventory().setItem(0, itemTrident);
					player.getInventory().setItem(1, itemEnderPearl);
				});
			}
		}, 0, 0);
	}
}
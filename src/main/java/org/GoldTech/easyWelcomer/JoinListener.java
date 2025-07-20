package org.GoldTech.easyWelcomer;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class JoinListener implements Listener {

    private final String PREFIX = ChatColor.translateAlternateColorCodes('§',
            "§x§5§C§F§C§F§6§lE§x§5§6§F§3§E§8§la§x§4§F§E§A§D§A§ls§x§4§9§E§2§C§B§ly§x§4§2§D§9§B§D§lW§x§3§C§D§0§A§F§le§x§3§5§C§7§A§1§ll§x§2§F§B§E§9§3§lc§x§2§8§B§5§8§5§lo§x§2§2§A§D§7§6§lm§x§1§B§A§4§6§8§le§x§1§5§9§B§5§A§lr");

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = EasyWelcomer.getInstance().getConfig();


        if (config.getBoolean("onlyFirstJoin") && player.hasPlayedBefore()) return;


        if (config.getBoolean("enableMessage")) {
            String msg = config.getString("message");
            msg = replace(msg, player);
            player.sendMessage(msg);
        }


        if (config.getBoolean("enableTitle")) {
            String title = replace(config.getString("title"), player);
            String subtitle = replace(config.getString("subtitle"), player);
            player.sendTitle(title, subtitle, 10, 60, 10);
        }


        if (config.getBoolean("enableSound")) {
            try {
                Sound sound = Sound.valueOf(config.getString("sound"));
                player.playSound(player.getLocation(), sound, 1.0f, 1.0f);
            } catch (IllegalArgumentException e) {
                Bukkit.getConsoleSender().sendMessage(PREFIX + ChatColor.RED + " Niepoprawny dźwięk: §c" + config.getString("sound"));
            }
        }


        if (config.getBoolean("enableParticle")) {
            try {
                Particle particle = Particle.valueOf(config.getString("particle"));
                player.getWorld().spawnParticle(particle, player.getLocation().add(0, 2, 0), 20, 0.5, 0.5, 0.5, 0.1);
            } catch (IllegalArgumentException e) {
                Bukkit.getConsoleSender().sendMessage(PREFIX + ChatColor.RED + " Niepoprawny particle: §c" + config.getString("particle"));
            }
        }


        if (config.getBoolean("enableActionbar")) {
            String bar = replace(config.getString("actionbar"), player);
            player.spigot().sendMessage(
                    net.md_5.bungee.api.ChatMessageType.ACTION_BAR,
                    new net.md_5.bungee.api.chat.TextComponent(bar)
            );
        }


        if (config.getBoolean("starterItems.enabled")) {
            for (String entry : config.getStringList("starterItems.items")) {
                try {
                    String[] parts = entry.split(":");
                    Material material = Material.valueOf(parts[0]);
                    int amount = parts.length > 1 ? Integer.parseInt(parts[1]) : 1;
                    player.getInventory().addItem(new ItemStack(material, amount));
                } catch (Exception e) {
                    Bukkit.getConsoleSender().sendMessage(PREFIX + ChatColor.GOLD + " Niepoprawny item w starterItems: §e" + entry);
                }
            }
        }
    }

    private String replace(String text, Player player) {
        if (text == null) return "";
        String parsed = ChatColor.translateAlternateColorCodes('&', text.replace("%player%", player.getName()));

        Plugin papi = Bukkit.getPluginManager().getPlugin("PlaceholderAPI");
        if (papi != null && papi.isEnabled()) {
            try {
                parsed = me.clip.placeholderapi.PlaceholderAPI.setPlaceholders(player, parsed);
            } catch (Exception e) {
                Bukkit.getLogger().warning("[EasyWelcomer] Błąd przy przetwarzaniu PlaceholderAPI: " + e.getMessage());
            }
        }

        return parsed;
    }
}

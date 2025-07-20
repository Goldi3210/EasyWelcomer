package org.GoldTech.easyWelcomer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        EasyWelcomer.getInstance().reloadConfig();
        sender.sendMessage("§x§5§C§F§C§F§6§lE§x§5§6§F§3§E§8§la§x§4§F§E§A§D§A§ls§x§4§9§E§2§C§B§ly§x§4§2§D§9§B§D§lW§x§3§C§D§0§A§F§le§x§3§5§C§7§A§1§ll§x§2§F§B§E§9§3§lc§x§2§8§B§5§8§5§lo§x§2§2§A§D§7§6§lm§x§1§B§A§4§6§8§le§x§1§5§9§B§5§A§lr §aConfig przeładowany!");
        return true;
    }
}
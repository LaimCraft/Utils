package ru.laimcraft.utils;

import net.minecraft.network.protocol.Packet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_21_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.regex.Pattern;

public class Utils {
    public static void sendPacket(Packet<?> packet, CraftPlayer craftPlayer) {
        craftPlayer.getHandle().connection.send(packet);}

    public static String getSHA512(String input){
        String toReturn = null; try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(input.getBytes("utf8"));
            toReturn = String.format("%0128x", new BigInteger(1, digest.digest()));} catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(e.toString());}return toReturn;}

    public static boolean checkPlayerName(String player) {
        if(player == null || player.isEmpty()) return false;
        if(player.length() < 3 || player.length() > 16) return false;
        if(!Pattern.matches("^[a-zA-Z0-9_]+$", player)) return false;
        if(Character.isDigit(player.charAt(0))) return false;
        return true;}

    public static boolean checkInteger(String Integer) {
        if(Integer == null || Integer.isEmpty()) return false;
        if(Integer.length() > 6) return false;
        if(!Pattern.matches("^[0-9]+$", Integer)) return false;
        if(!Character.isDigit(Integer.charAt(0))) return false;
        return true;}

    public static void vanillaTabColorUpdate(Player player) {
        String world = player.getLocation().getWorld().getName();

        if(world.equalsIgnoreCase("world")) {
            player.setPlayerListName(ChatColor.DARK_GREEN + player.getName());
            return;}
        if(world.equalsIgnoreCase("world_nether")) {
            player.setPlayerListName(ChatColor.RED + player.getName());
            return;}
        if(world.equalsIgnoreCase("world_the_end")) {
            player.setPlayerListName(ChatColor.GOLD + player.getName());
            return;}}

    public static String vanillaGetTabColor(Player player) {
        String world = player.getLocation().getWorld().getName();

        if(world.equalsIgnoreCase("world")) {
            return ChatColor.DARK_GREEN + "";}
        if(world.equalsIgnoreCase("world_nether")) {
            return ChatColor.RED + "";}
        if(world.equalsIgnoreCase("world_the_end")) {
            return ChatColor.GOLD + "";}
        return ChatColor.WHITE + "";}
}

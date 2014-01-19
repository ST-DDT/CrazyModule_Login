package de.st_ddt.crazyutil.modules.login;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public final class LoginModule
{

	private final static List<Class<? extends LoginSystem>> LOGINSYSTEMCLASSES = LoginSystem.LOGINSYSTEMCLASSES;
	private static LoginSystem INSTANCE;
	static
	{
		registerLoginSystem(NoLoginSystem.class);
	}

	public static void registerLoginSystem(final Class<? extends LoginSystem> clazz)
	{
		LOGINSYSTEMCLASSES.add(clazz);
	}

	public static void registerFallbackLoginSystem(final Class<? extends LoginSystem> clazz)
	{
		LOGINSYSTEMCLASSES.add(LOGINSYSTEMCLASSES.size() - 1, clazz);
	}

	public static void initialize()
	{
		if (INSTANCE != null)
			return;
		for (final Class<? extends LoginSystem> clazz : LOGINSYSTEMCLASSES)
			try
			{
				INSTANCE = clazz.newInstance();
				break;
			}
			catch (final Throwable e)
			{}
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "[" + ChatColor.GREEN + "Crazy" + ChatColor.RED + "] " + ChatColor.GREEN + "Activated " + INSTANCE.getName() + "-LoginSystem-Module!");
	}

	public static void clear()
	{
		INSTANCE = null;
	}

	public boolean hasAccount(final OfflinePlayer player)
	{
		if (INSTANCE == null)
			initialize();
		return INSTANCE.hasAccount(player);
	}

	public boolean isLoggedIn(final Player player)
	{
		if (INSTANCE == null)
			initialize();
		return INSTANCE.isLoggedIn(player);
	}

	private LoginModule()
	{
	}
}

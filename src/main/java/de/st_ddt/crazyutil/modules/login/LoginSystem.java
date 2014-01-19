package de.st_ddt.crazyutil.modules.login;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import de.st_ddt.crazyutil.Named;

public interface LoginSystem extends Named
{

	/**
	 * An ordered list of Classes that implements this interface<br>
	 * and that can be initiated at runtime using the default constructor.
	 */
	public final static List<Class<? extends LoginSystem>> LOGINSYSTEMCLASSES = new ArrayList<Class<? extends LoginSystem>>();

	public String getName();

	public boolean hasAccount(OfflinePlayer player);

	public boolean isLoggedIn(Player player);
}

package vb.$tradingmobs;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDisable() {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event1(org.bukkit.event.player.PlayerInteractEntityEvent event) throws Exception {
		Object $d909d60c214372f6185a58cd1b31535a = null;
		Object $689058774afd6a623f14c666e3314cd4 = null;
		if (PluginMain.checkEquals(
				((org.bukkit.entity.EntityType) ((org.bukkit.entity.Entity) event.getRightClicked()).getType()),
				((org.bukkit.entity.EntityType) org.bukkit.entity.EntityType.PIG))) {
			$d909d60c214372f6185a58cd1b31535a = ((org.bukkit.inventory.Merchant) org.bukkit.Bukkit
					.createMerchant("pig"));
			$689058774afd6a623f14c666e3314cd4 = new org.bukkit.inventory.MerchantRecipe(
					new org.bukkit.inventory.ItemStack(((org.bukkit.Material) org.bukkit.Material.GOLDEN_CARROT),
							((int) (10d))),
					((int) (10d)));
			((org.bukkit.inventory.MerchantRecipe) (Object) $689058774afd6a623f14c666e3314cd4).addIngredient(
					new org.bukkit.inventory.ItemStack(((org.bukkit.Material) org.bukkit.Material.EMERALD),
							((int) (1d))));
			((org.bukkit.inventory.Merchant) (Object) $d909d60c214372f6185a58cd1b31535a)
					.setRecipes(new ArrayList(Arrays.asList($689058774afd6a623f14c666e3314cd4)));
			((org.bukkit.entity.HumanEntity) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
					.openMerchant(((org.bukkit.inventory.Merchant) (Object) $d909d60c214372f6185a58cd1b31535a), true);
		} else {
		}
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}

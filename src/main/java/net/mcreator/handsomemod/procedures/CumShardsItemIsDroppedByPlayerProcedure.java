package net.mcreator.handsomemod.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.Entity;

import net.mcreator.handsomemod.TheHandsomeModModElements;

import java.util.Map;

@TheHandsomeModModElements.ModElement.Tag
public class CumShardsItemIsDroppedByPlayerProcedure extends TheHandsomeModModElements.ModElement {
	public CumShardsItemIsDroppedByPlayerProcedure(TheHandsomeModModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CumShardsItemIsDroppedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.15)) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList()
							.sendMessage(new StringTextComponent((((entity.getDisplayName().getString())) + "" + (" couldn't resist."))));
			}
		}
	}
}

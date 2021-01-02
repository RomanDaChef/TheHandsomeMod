package net.mcreator.handsomemod.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.handsomemod.potion.PoggersPotion;
import net.mcreator.handsomemod.TheHandsomeModModElements;

import java.util.Map;

@TheHandsomeModModElements.ModElement.Tag
public class PogItemInInventoryTickProcedure extends TheHandsomeModModElements.ModElement {
	public PogItemInInventoryTickProcedure(TheHandsomeModModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure PogItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(PoggersPotion.potion, (int) 20, (int) 69, (true), (false)));
	}
}

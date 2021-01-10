package net.mcreator.handsomemod.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.handsomemod.TheHandsomeModModElements;

import java.util.Random;
import java.util.Map;

@TheHandsomeModModElements.ModElement.Tag
public class RichtungfliegenProcedure extends TheHandsomeModModElements.ModElement {
	public RichtungfliegenProcedure(TheHandsomeModModElements instance) {
		super(instance, 66);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Richtungfliegen!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure Richtungfliegen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double pitch = 0;
		double yaw = 0;
		double r = 0;
		double xaver = 0;
		double yolo = 0;
		double zumba = 0;
		pitch = (double) Math.toRadians(((entity.rotationPitch) * (-1)));
		yaw = (double) Math.toRadians(((entity.rotationYaw) * (-1)));
		yolo = (double) (Math.sin((pitch)) * 1.732);
		xaver = (double) Math.sin((yaw));
		zumba = (double) Math.cos((yaw));
		r = (double) (Math.sqrt((3 - ((yolo) * (yolo)))) / Math.sqrt((((xaver) * (xaver)) + ((zumba) * (zumba)))));
		{
			ItemStack _ist = (itemstack);
			if (_ist.attemptDamageItem((int) 4, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamage(0);
			}
		}
		entity.setMotion(((xaver) * (r)), (yolo), ((zumba) * (r)));
	}
}

package net.mcreator.handsomemod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.handsomemod.item.JizzBottleItem;
import net.mcreator.handsomemod.block.JizzBlock;
import net.mcreator.handsomemod.TheHandsomeModModVariables;
import net.mcreator.handsomemod.TheHandsomeModModElements;

import java.util.Map;

@TheHandsomeModModElements.ModElement.Tag
public class JackoffOnKeyPressedProcedure extends TheHandsomeModModElements.ModElement {
	public JackoffOnKeyPressedProcedure(TheHandsomeModModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure JackoffOnKeyPressed!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure JackoffOnKeyPressed!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure JackoffOnKeyPressed!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure JackoffOnKeyPressed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure JackoffOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			double _setval = (double) (((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new TheHandsomeModModVariables.PlayerVariables())).buttonpresses) + 1);
			entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.buttonpresses = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new TheHandsomeModModVariables.PlayerVariables())).buttonpresses) == 20)) {
			if (((entity instanceof PlayerEntity)
					? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(Items.GLASS_BOTTLE, (int) (1)))
					: false)) {
				if ((((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheHandsomeModModVariables.PlayerVariables())).howhorny) < 3)) {
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE, (int) (1));
						((PlayerEntity) entity).inventory.clearMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) 1);
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(JizzBottleItem.block, (int) (1));
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
				}
				{
					double _setval = (double) (((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheHandsomeModModVariables.PlayerVariables())).howhorny) + 1);
					entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.howhorny = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheHandsomeModModVariables.PlayerVariables())).howhorny) == 2)) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).attackEntityFrom(new DamageSource("Masturbated too much").setDamageBypassesArmor(), (float) 19);
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 200, (int) 4, (true), (true)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 200, (int) 4, (true), (true)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (true), (true)));
				}
				if ((((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheHandsomeModModVariables.PlayerVariables())).howhorny) >= 3)) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).attackEntityFrom(new DamageSource("Masturbated way too much").setDamageBypassesArmor(), (float) 100);
					}
				}
			} else {
				if ((((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheHandsomeModModVariables.PlayerVariables())).howhorny) < 3)) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), JizzBlock.block.getDefaultState(), 3);
				}
				{
					double _setval = (double) (((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new TheHandsomeModModVariables.PlayerVariables())).howhorny) + 1);
					entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.howhorny = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheHandsomeModModVariables.PlayerVariables())).howhorny) == 2)) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).attackEntityFrom(new DamageSource("Masturbated too much").setDamageBypassesArmor(), (float) 19);
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 200, (int) 4, (true), (true)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 200, (int) 4, (true), (true)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 4, (true), (true)));
				}
				if ((((entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new TheHandsomeModModVariables.PlayerVariables())).howhorny) >= 3)) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).attackEntityFrom(new DamageSource("Masturbated way too much").setDamageBypassesArmor(), (float) 100);
					}
				}
			}
			{
				double _setval = (double) 0;
				entity.getCapability(TheHandsomeModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.buttonpresses = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}

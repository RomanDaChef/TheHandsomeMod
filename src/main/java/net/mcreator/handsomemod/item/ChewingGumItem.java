
package net.mcreator.handsomemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.handsomemod.procedures.ChewingGumFoodEatenProcedure;
import net.mcreator.handsomemod.itemgroup.HandsomeFoodItemGroup;
import net.mcreator.handsomemod.TheHandsomeModModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@TheHandsomeModModElements.ModElement.Tag
public class ChewingGumItem extends TheHandsomeModModElements.ModElement {
	@ObjectHolder("the_handsome_mod:chewing_gum")
	public static final Item block = null;
	public ChewingGumItem(TheHandsomeModModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(HandsomeFoodItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(1).saturation(0.3f).build()));
			setRegistryName("chewing_gum");
		}

		@Override
		public int getUseDuration(ItemStack stack) {
			return 60;
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("It is even more delicious."));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				ChewingGumFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}

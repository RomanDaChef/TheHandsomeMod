
package net.mcreator.handsomemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.handsomemod.itemgroup.HandsomeOresItemGroup;
import net.mcreator.handsomemod.TheHandsomeModModElements;

@TheHandsomeModModElements.ModElement.Tag
public class CopperIngotItem extends TheHandsomeModModElements.ModElement {
	@ObjectHolder("the_handsome_mod:copper_ingot")
	public static final Item block = null;
	public CopperIngotItem(TheHandsomeModModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(HandsomeOresItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("copper_ingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}

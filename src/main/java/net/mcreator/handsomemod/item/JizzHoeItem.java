
package net.mcreator.handsomemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.handsomemod.TheHandsomeModModElements;

@TheHandsomeModModElements.ModElement.Tag
public class JizzHoeItem extends TheHandsomeModModElements.ModElement {
	@ObjectHolder("the_handsome_mod:jizz_hoe")
	public static final Item block = null;
	public JizzHoeItem(TheHandsomeModModElements instance) {
		super(instance, 41);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 1000;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return -1f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 20;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(JizzIngotItem.block, (int) (1)));
			}
		}, 1f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("jizz_hoe"));
	}
}

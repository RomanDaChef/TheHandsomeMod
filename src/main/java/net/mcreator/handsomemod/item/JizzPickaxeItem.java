
package net.mcreator.handsomemod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.handsomemod.itemgroup.HandsomeMiscItemGroup;
import net.mcreator.handsomemod.TheHandsomeModModElements;

@TheHandsomeModModElements.ModElement.Tag
public class JizzPickaxeItem extends TheHandsomeModModElements.ModElement {
	@ObjectHolder("the_handsome_mod:jizz_pickaxe")
	public static final Item block = null;
	public JizzPickaxeItem(TheHandsomeModModElements instance) {
		super(instance, 35);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 700;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 3f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(JizzIngotItem.block, (int) (1)));
			}
		}, 1, -2.6f, new Item.Properties().group(HandsomeMiscItemGroup.tab)) {
		}.setRegistryName("jizz_pickaxe"));
	}
}

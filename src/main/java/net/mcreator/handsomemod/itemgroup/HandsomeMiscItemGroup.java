
package net.mcreator.handsomemod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.handsomemod.item.LiandrysItem;
import net.mcreator.handsomemod.TheHandsomeModModElements;

@TheHandsomeModModElements.ModElement.Tag
public class HandsomeMiscItemGroup extends TheHandsomeModModElements.ModElement {
	public HandsomeMiscItemGroup(TheHandsomeModModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabhandsome_misc") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(LiandrysItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}


package net.mcreator.handsomemod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.handsomemod.block.CumOreBlock;
import net.mcreator.handsomemod.TheHandsomeModModElements;

@TheHandsomeModModElements.ModElement.Tag
public class HandsomeOresItemGroup extends TheHandsomeModModElements.ModElement {
	public HandsomeOresItemGroup(TheHandsomeModModElements instance) {
		super(instance, 17);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabhandsome_ores") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(CumOreBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}

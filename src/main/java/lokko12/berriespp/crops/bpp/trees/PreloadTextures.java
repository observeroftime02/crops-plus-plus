package lokko12.berriespp.crops.bpp.trees;

import java.io.IOException;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lokko12.croploadcore.Operators;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.TextureStitchEvent;

public class PreloadTextures {
	@SubscribeEvent
	public void onTextureStitchPre(TextureStitchEvent.Pre e) {
		
		if (e.map == Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationItemsTexture)) {
			/*for (Item item : BLItemRegistry.ITEMS) {
				if (item instanceof ICorrodible) {
					ICorrodible corrodibleItem = (ICorrodible) item;
					IIcon[] icons = corrodibleItem.getIcons();
					IIcon[][] corrosionIcons = new IIcon[icons.length][CorrodibleItemHelper.CORROSION_STAGE_COUNT];
					for (int i = 0; i < icons.length; i++) {
						for (int n = 0; n < CorrodibleItemHelper.CORROSION_STAGE_COUNT; n++) {
							String iconName = icons[i].getIconName();
							String corrosionIconName = iconName + "_corrosion_" + n;
							TextureCorrosion corrosionTexture = new TextureCorrosion(corrosionIconName, iconName, n, item.getUnlocalizedName().hashCode());
							e.map.setTextureEntry(corrosionIconName, corrosionTexture);
							corrosionIcons[i][n] = corrosionTexture;
						}
					}
					corrodibleItem.setCorrosionIcons(corrosionIcons);
				}*/
			for(int i=0; i < InstalledTreesGetter.savedNames.size(); i++) {
				if( Operators.AND(
						Operators.NOR( InstalledTreesGetter.savedNames.get(i).contains("Shimmerleaf"),
						InstalledTreesGetter.savedNames.get(i).contains("Cinderpearl") ),
						Operators.NOR(InstalledTreesGetter.savedNames.get(i).contains("Vishroom"),
						InstalledTreesGetter.savedNames.get(i).contains("Ethereal Bloom")))) 
				{
					ItemStack Sapling = InstalledTreesGetter.BaseSeed.get(i);
					/*try {
						BonsaiRenderer renderer = new BonsaiRenderer("bpp:"+Sapling.getIconIndex().getIconName().replaceAll(":","_"), InstalledTreesGetter.make_crop_IIcons(Sapling.getIconIndex(), Sapling.getIconIndex().getIconName()), (TextureAtlasSprite) Sapling.getIconIndex());
						e.map.setTextureEntry(renderer.getIconName(), renderer);
					} catch (IOException e1) {
						e1.printStackTrace();
					}		*/
				}
			}
		}
	}
}
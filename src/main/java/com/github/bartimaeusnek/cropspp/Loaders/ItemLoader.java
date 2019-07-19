package com.github.bartimaeusnek.cropspp.Loaders;

import com.github.bartimaeusnek.cropspp.Cropspp;
import com.github.bartimaeusnek.cropspp.items.CppBerries;
import com.github.bartimaeusnek.cropspp.items.CppItems;
import com.github.bartimaeusnek.cropspp.items.CreativeTab;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = Cropspp.modID)
public class ItemLoader {
    public static final HashSet<Block> blocks = new HashSet<>();
    public static final HashSet<Item> items = new HashSet<>();
    private ItemLoader() {
    }
    public static void registerItem(Item item, String registryName){
        item = item.setRegistryName(registryName);
        items.add(item);
    }
    public static void registerBlock(Block item, String registryName){
        item = item.setRegistryName(registryName);
        blocks.add(item);
    }


    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(items.toArray(new Item[0]));

    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> onBlockRegister) {
        onBlockRegister.getRegistry().registerAll(blocks.toArray(new Block[0]));
    }


    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item i : items) {
            if (!i.getHasSubtypes())
                ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(Objects.requireNonNull(i.getRegistryName()), "inventory"));
            else {
                CreativeTabs tab = i.getCreativeTab();
                NonNullList subitems = NonNullList.create();
                i.getSubItems(tab,subitems);
                for (int j = 0; j < subitems.size(); j++) {
                    ModelLoader.setCustomModelResourceLocation(i, j, new ModelResourceLocation(Objects.requireNonNull(i.getRegistryName())+"_"+j, "inventory"));
                }
            }
        }
    }
}
package com.github.bartimaeusnek.ASM;

import ic2.core.crop.TileEntityCrop;
import ic2.core.item.type.CropResItemType;
import ic2.core.ref.ItemName;
import ic2.core.util.StackUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CropStickTransformerReplaceMethod {

    private CropStickTransformerReplaceMethod(){}

    //for WeedingTrowel to accept custom Weeds
    public static EnumActionResult patchedonItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
        if (world.isRemote)
            return EnumActionResult.PASS;
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityCrop) {
            TileEntityCrop crop = (TileEntityCrop) te;
            if (crop.getCrop() != null && crop.getCrop().getProperties().getTier() < 1) {
                ItemStack drop = ItemName.crop_res.getItemStack(CropResItemType.weed).copy();
                drop.setCount(crop.getCurrentSize());
                StackUtil.dropAsEntity(world, pos, drop);
                crop.reset();
                return EnumActionResult.SUCCESS;
            }
        }
        return EnumActionResult.PASS;
    }
}

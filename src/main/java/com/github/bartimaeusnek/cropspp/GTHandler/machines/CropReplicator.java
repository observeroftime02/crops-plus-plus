package com.github.bartimaeusnek.cropspp.GTHandler.machines;

import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Utility;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class CropReplicator extends GT_MetaTileEntity_BasicMachine {

    public CropReplicator(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier, 6, new String[]{"It can replicate Crops", "It needs a Cell of UUM per crop's tier", "Takes in 6A", "Needs crop's (tier+2)/2 as Voltage level, round down (Tier 5 crop needs 7/2=~3=HV)"}, 2, 2, "Crop_Replicator.png", "", new ITexture[]{new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_SIDE_SCANNER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_SIDE_SCANNER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_SCANNER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_SCANNER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_TOP_SCANNER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_TOP_SCANNER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_BOTTOM_SCANNER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_BOTTOM_SCANNER)});
    }

    public CropReplicator(String mName, byte mTier, String[] mDescriptionArray, ITexture[][][] mTextures, String mGUIName, String mNEIName) {
        super(mName, mTier, 6, mDescriptionArray, mTextures, 2, 2, mGUIName, mNEIName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity arg0) {
        return new CropReplicator(this.mName, this.mTier, this.mDescriptionArray, this.mTextures, this.mGUIName, this.mNEIName);
    }

    @Override
    public int checkRecipe(boolean skipOC) {
        ItemStack aStack = getInputAt(0);
        ItemStack bStack = getInputAt(1);
        ItemStack tosave = getSpecialSlot();

        if (GT_Utility.areUnificationsEqual((ItemStack) aStack, Materials.UUMatter.getCells(1), true) && ItemList.IC2_Crop_Seeds.isStackEqual(bStack, true, true)) {
            ItemStack helper = bStack;
            bStack = aStack;
            aStack = helper;
            helper = null;
        }
        if (GT_Utility.areUnificationsEqual((ItemStack) bStack, Materials.UUMatter.getCells(1), true) && ItemList.IC2_Crop_Seeds.isStackEqual(aStack, true, true)) {


            NBTTagCompound tNBT = aStack.getTagCompound();

            if (tNBT == null || tNBT.getString("name").isEmpty() || tNBT.getString("name").equals("Primordial Berry"))
                return DID_NOT_FIND_RECIPE;
            if (getOutputAt(0) != null || getOutputAt(1) != null)
                return DID_NOT_FIND_RECIPE;

            CropCard card = Crops.instance.getCropCard(tNBT.getString("owner"), tNBT.getString("name"));

            if (bStack.stackSize < card.tier())
                return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;

            aStack.stackSize -= 1;
            bStack.stackSize -= card.tier();
            this.mOutputItems[0] = aStack.splitStack(2);
            this.mOutputItems[1] = Materials.Empty.getCells(card.tier());


            calculateOverclockedNess((int) (GT_Values.V[Math.round((card.tier() + 2) / 2)] - (GT_Values.V[Math.round((card.tier() + 2) / 2)] / 10)), 12000);
            if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
            return FOUND_AND_SUCCESSFULLY_USED_RECIPE;
        }
        return DID_NOT_FIND_RECIPE;
    }

    public void startSoundLoop(byte aIndex, double aX, double aY, double aZ) {
        super.startSoundLoop(aIndex, aX, aY, aZ);
        if (aIndex == 1) {
            GT_Utility.doSoundAtClient((String) GregTech_API.sSoundList.get(Integer.valueOf(212)), 10, 1.0F, aX, aY, aZ);
        }
    }

    public void startProcess() {
        sendLoopStart((byte) 1);
    }

    @Override
    public boolean canInsertItem(int aIndex, ItemStack aStack, int aSide) {
        if (GT_Utility.areUnificationsEqual((ItemStack) aStack, Materials.UUMatter.getCells(1), true) || ItemList.IC2_Crop_Seeds.isStackEqual(aStack, true, true))
            return isValidSlot(aIndex) && aStack != null && aIndex < mInventory.length && (mInventory[aIndex] == null || GT_Utility.areStacksEqual(aStack, mInventory[aIndex])) && allowPutStack(getBaseMetaTileEntity(), aIndex, (byte) aSide, aStack);
        return false;
    }

}

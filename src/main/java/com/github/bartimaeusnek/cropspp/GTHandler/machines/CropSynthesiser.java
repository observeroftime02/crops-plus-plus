package com.github.bartimaeusnek.cropspp.GTHandler.machines;

import gregtech.api.GregTech_API;
import gregtech.api.enums.GT_Values;
import gregtech.api.enums.ItemList;
import gregtech.api.enums.Textures;
import gregtech.api.interfaces.ITexture;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import gregtech.api.metatileentity.implementations.GT_MetaTileEntity_BasicMachine;
import gregtech.api.objects.GT_RenderedTexture;
import gregtech.api.util.GT_Utility;
import gregtech.common.items.behaviors.Behaviour_DataOrb;
import ic2.api.crops.CropCard;
import ic2.api.crops.Crops;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;

public class CropSynthesiser extends GT_MetaTileEntity_BasicMachine {

    public CropSynthesiser(int aID, String aName, String aNameRegional, int aTier) {
        super(aID, aName, aNameRegional, aTier, 16, new String[]{"It can make Crops from DataOrbs", "It needs a crop's tier/2*1000L of UUM per Crop", "Takes in 16A", "Needs crop's (tier+2)/2 as Voltage level, round down (Tier 5 crop needs 7/2=~3=HV)"}, 4, 1, "Crop_Synthesizer.png", "", new ITexture[]{new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_SIDE_SCANNER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_SIDE_SCANNER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_SCANNER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_FRONT_SCANNER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_TOP_SCANNER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_TOP_SCANNER), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_BOTTOM_SCANNER_ACTIVE), new GT_RenderedTexture(Textures.BlockIcons.OVERLAY_BOTTOM_SCANNER)});
    }

    public CropSynthesiser(String mName, byte mTier, String[] mDescriptionArray, ITexture[][][] mTextures, String mGUIName, String mNEIName) {
        super(mName, mTier, 16, mDescriptionArray, mTextures, 4, 1, mGUIName, mNEIName);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity arg0) {
        return new CropSynthesiser(this.mName, this.mTier, this.mDescriptionArray, this.mTextures, this.mGUIName, this.mNEIName);
    }

    @Override
    public int checkRecipe(boolean skipOC) {
        ItemStack[] aStacks = {getInputAt(0), getInputAt(1), getInputAt(2), getInputAt(3)};

        if (ItemList.Tool_DataOrb.isStackEqual(aStacks[0], true, true) && ItemList.Tool_DataOrb.isStackEqual(aStacks[1], true, true) && ItemList.Tool_DataOrb.isStackEqual(aStacks[2], true, true) && ItemList.Tool_DataOrb.isStackEqual(aStacks[3], true, true)) {

            if (!this.mFluid.getFluid().getName().equals("ic2uumatter"))
                return DID_NOT_FIND_RECIPE;

            if (getOutputAt(0) != null)
                return DID_NOT_FIND_RECIPE;

            HashMap<String, String> CropStats = new HashMap<String, String>();

            for (byte i = 0; i <= 3; ++i)
                CropStats.put(Behaviour_DataOrb.getDataTitle(aStacks[i]), Behaviour_DataOrb.getDataName(aStacks[i]));

            String owner = CropStats.get("Crop-Specimen-Scan");
            String name = owner.split(":")[1];
            owner = owner.split(":")[0];

            if (CropStats.get("Crop-Growth-Scan").isEmpty() || CropStats.get("Crop-Gain-Scan").isEmpty() || CropStats.get("Crop-Resistance-Scan").isEmpty() || CropStats.get("Crop-Specimen-Scan").isEmpty())
                return DID_NOT_FIND_RECIPE;

            CropCard card = Crops.instance.getCropCard(owner, name);

            if (card == null)
                return DID_NOT_FIND_RECIPE;

            long neededUUM = ((long) (((float) card.tier() / 2) * 1000));

            if (this.mFluid.amount < neededUUM)
                return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;

            NBTTagCompound tNBT = new NBTTagCompound();
            ItemStack op = ItemList.IC2_Crop_Seeds.get(1L);
            tNBT.setByte("growth", Byte.parseByte(CropStats.get("Crop-Growth-Scan")));
            tNBT.setByte("gain", Byte.parseByte(CropStats.get("Crop-Gain-Scan")));
            tNBT.setByte("resistance", Byte.parseByte(CropStats.get("Crop-Resistance-Scan")));
            tNBT.setString("owner", owner);
            tNBT.setString("name", name);
            tNBT.setByte("scan", (byte) 4);
            op.setTagCompound(tNBT);
            this.mOutputItems[0] = op;

            this.mFluid.amount -= neededUUM;

            calculateOverclockedNess((int) (GT_Values.V[Math.round((card.tier() + 2) / 2)] - (GT_Values.V[Math.round((card.tier() + 2) / 2)] / 10)), 12000);
            if (mMaxProgresstime == Integer.MAX_VALUE - 1 && mEUt == Integer.MAX_VALUE - 1)
                return FOUND_RECIPE_BUT_DID_NOT_MEET_REQUIREMENTS;
            return FOUND_AND_SUCCESSFULLY_USED_RECIPE;
        }
        return DID_NOT_FIND_RECIPE;
    }

    @Override
    public void startSoundLoop(byte aIndex, double aX, double aY, double aZ) {
        super.startSoundLoop(aIndex, aX, aY, aZ);
        if (aIndex == 1) {
            GT_Utility.doSoundAtClient((String) GregTech_API.sSoundList.get(Integer.valueOf(212)), 10, 1.0F, aX, aY, aZ);
        }
    }

    @Override
    public void startProcess() {
        sendLoopStart((byte) 1);
    }

    @Override
    public boolean isFluidInputAllowed(FluidStack aFluid) {
        return (aFluid.getFluid().getName().equals("ic2uumatter")) || (super.isFluidInputAllowed(aFluid));
    }

    @Override
    public int getCapacity() {
        return 3000 * mTier;
    }

    @Override
    public boolean canInsertItem(int aIndex, ItemStack aStack, int aSide) {
        if (ItemList.Tool_DataOrb.isStackEqual(aStack, true, true))
            return isValidSlot(aIndex) && aStack != null && aIndex < mInventory.length && (mInventory[aIndex] == null || GT_Utility.areStacksEqual(aStack, mInventory[aIndex])) && allowPutStack(getBaseMetaTileEntity(), aIndex, (byte) aSide, aStack);
        return false;
    }
}

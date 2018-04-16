package com.github.bartimaeusnek.cropspp.fluids;

import com.github.bartimaeusnek.cropspp.Cropspp;

import gregtech.GT_Mod;
import gregtech.api.enums.ItemList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;


public class CppFluids{
	
	public final static AlkoholImpure FWheat = new AlkoholImpure("potion.FWheat",40,"potion.alcopops");
	public final static AlkoholImpure Korn = new AlkoholImpure("potion.Korn",320,"potion.vodka");
	public final static AlkoholImpure DKorn = new AlkoholImpure("potion.DKorn",380,"potion.vodka");
	public final static AlkoholImpure FReed = new AlkoholImpure("potion.FReed",50,"potion.alcopops");
	public final static AlkoholImpure SWhine = new AlkoholImpure("potion.SWhine",700,"potion.reedwater");
	public final static AlkoholImpure Mash =  new AlkoholImpure("potion.Mash",25,"potion.reedwater");
	public final static AlkoholImpure Wash =  new AlkoholImpure("potion.Wash",50,"potion.alcopops");
	public final static AlkoholImpure GHP = new AlkoholImpure("potion.GHP",700,"potion.vodka");
	public final static AlkoholImpure jagi = new AlkoholImpure("potion.jagi",100000,"potion.alcopops");
	public final static AlkoholImpure njagi = new AlkoholImpure("potion.njagi",350,"potion.alcopops");
	//public final static AlkoholImpure NutrientSolution = new AlkoholImpure("Nutrient Solution",250,"for.honey");
	
	public CppFluids() {
		super();
	}

}

package com.github.bartimaeusnek.cropspp.commands;

import com.github.bartimaeusnek.cropspp.ConfigValues;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

public class EnableDebug extends CommandBase {

    @Override
    public String getName() {
        return "cropsDebug";
    }

    @Override
    public String getUsage(ICommandSender p_71518_1_) {
        return "/cropsDebug [on/true|off/false|toggle]";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender p_71515_1_, String[] p_71515_2_) throws CommandException {
        if (p_71515_2_.length != 1)
            throw new WrongUsageException(getUsage(p_71515_1_));
        else if (p_71515_2_[0].contains("on") || p_71515_2_[0].contains("true")){
            ConfigValues.debug=true;
            p_71515_1_.sendMessage(new TextComponentString("Crops++ Debug = true"));
        }
        else if (p_71515_2_[0].contains("off") || p_71515_2_[0].contains("false")){
            ConfigValues.debug=false;
            p_71515_1_.sendMessage(new TextComponentString("Crops++ Debug = false"));
        }
        else if (p_71515_2_[0].equals("toggle")) {
            ConfigValues.debug = !ConfigValues.debug;
            p_71515_1_.sendMessage(new TextComponentString("Crops++ Debug = "+ConfigValues.debug));
        }
        ConfigValues.c.tConfig.get("System", "Debug", false).set(ConfigValues.debug);
        ConfigValues.c.save();
    }
}

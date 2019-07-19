package com.github.bartimaeusnek.ASM;


import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.Arrays;
import java.util.List;

public class CropStickTransformer implements IClassTransformer {

    private final static String[] classesBeeingTransformed =
            {
                    "ic2.core.item.tool.ItemWeedingTrowel"
            };

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        boolean isObfuscated = name.equals(transformedName);
        int index = Arrays.asList(classesBeeingTransformed).indexOf(transformedName);
        return index != (-1) ? transform(index, 0, basicClass, isObfuscated) : basicClass;
    }

    private byte[] transform(int index, int method, byte[] basicClass, boolean isObfuscated) {
        try {
            switch (index) {
                case 0: {
                    CropLoadCoreASM.cppASMlogger.info("Patching WeedingTrowel to accept custom Weeds");
                    String name = "onItemUseFirst";
                    String desc = !isObfuscated ? "(Lnet/minecraft/entity/player/EntityPlayer;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/EnumFacing;FFFLnet/minecraft/util/EnumHand;)Lnet/minecraft/util/EnumActionResult;" : "(Ladd;Lyz;Lahb;IIIIFFF)Z";
                    ClassReader reader = new ClassReader(basicClass);
                    ClassNode classNode = new ClassNode();

                    reader.accept(classNode, 0);

                    final List<MethodNode> methods = classNode.methods;

                    for (MethodNode methodNode : methods) {
                        if (methodNode.name.equals(name)) {
                            InsnList insnList = new InsnList();
                            insnList.add(new VarInsnNode(Opcodes.ALOAD, 1));
                            insnList.add(new VarInsnNode(Opcodes.ALOAD, 2));
                            insnList.add(new VarInsnNode(Opcodes.ALOAD, 3));
                            insnList.add(new VarInsnNode(Opcodes.ILOAD, 4));
                            insnList.add(new VarInsnNode(Opcodes.ILOAD, 5));
                            insnList.add(new VarInsnNode(Opcodes.ILOAD, 6));
                            insnList.add(new VarInsnNode(Opcodes.ILOAD, 7));
                            insnList.add(new VarInsnNode(Opcodes.FLOAD, 8));
                            insnList.add(new VarInsnNode(Opcodes.FLOAD, 9));
                            insnList.add(new VarInsnNode(Opcodes.FLOAD, 10));
                            insnList.add(new MethodInsnNode(Opcodes.INVOKESTATIC, "com/github/bartimaeusnek/ASM/CropStickTransformerReplaceMethod", "patchedonItemUseFirst", desc, false));
                            insnList.add(new InsnNode(Opcodes.IRETURN));
                            methodNode.instructions = insnList;
                        }
                    }

                    ClassWriter cw = new ClassWriter(reader, ClassReader.EXPAND_FRAMES | ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
                    classNode.accept(cw);
                    return cw.toByteArray();
                }
            }
            return basicClass;

        } catch (Exception e) {
            e.printStackTrace();
            return basicClass;
        }

    }

}

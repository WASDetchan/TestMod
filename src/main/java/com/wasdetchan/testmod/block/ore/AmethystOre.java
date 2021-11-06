package com.wasdetchan.testmod.block.ore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AmethystOre extends Block {
    public AmethystOre() {
        super(Properties.from(new Block(Properties.create(Material.ROCK)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE).setRequiresTool()
                .hardnessAndResistance(5f))));
    }
}

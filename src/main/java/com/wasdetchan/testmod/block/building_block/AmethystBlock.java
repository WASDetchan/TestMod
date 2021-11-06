package com.wasdetchan.testmod.block.building_block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AmethystBlock extends Block {
    public AmethystBlock() {
        super(Properties.from(new Block(Properties.create(Material.ROCK)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE).setRequiresTool()
                .hardnessAndResistance(10f))));
    }
}

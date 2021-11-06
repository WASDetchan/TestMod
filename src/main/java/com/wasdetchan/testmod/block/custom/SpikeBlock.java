package com.wasdetchan.testmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class SpikeBlock extends Block {
    boolean isActive = true;

    public SpikeBlock() {
        super(Properties.from(new Block(Properties.create(Material.IRON)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE).setRequiresTool()
                .hardnessAndResistance(5f))));
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!world.isRemote()){
            if (!ItemStack.areItemsEqual(player.getHeldItemMainhand(), new ItemStack(Items.REDSTONE_TORCH, 1))&&
                    !ItemStack.areItemsEqual(player.getHeldItemOffhand(), new ItemStack(Items.REDSTONE_TORCH, 1))){
                System.out.println(isActive);
                player.setFire(5);
            }
            else if (!player.isSneaking()) {
                if (handIn == Hand.MAIN_HAND){
                    isActive = !isActive;
                }
            }
        }

        return super.onBlockActivated(state, world, pos, player, handIn, hit);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        if(isActive){
            entityIn.attackEntityFrom(DamageSource.CACTUS, 3.0f);
        }
        super.onEntityWalk(worldIn, pos, entityIn);
    }


}

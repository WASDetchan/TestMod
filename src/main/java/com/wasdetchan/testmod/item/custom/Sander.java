package com.wasdetchan.testmod.item.custom;

import com.wasdetchan.testmod.ModCreativeTabGroup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Sander extends Item {

    HashMap<Block, Block> blockPairs = new HashMap<>();

    public Sander() {
        super(new Item.Properties()
                .group(ModCreativeTabGroup.TEST_GROUP)
                .maxStackSize(1));
    }

    public void readFromConfig(){

    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context){
        World world = context.getWorld();

        if(!world.isRemote){
            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
            BlockState clickedBlock = world.getBlockState(context.getPos());

            rightClickOnCertainBlockState(clickedBlock,  world, context.getPos());
            stack.damageItem(1, playerEntity, player -> player.sendBreakAnimation(context.getHand()));
        }

        return super.onItemUseFirst(stack, context);
    }

    @Override
    public void addInformation(ItemStack itemStack, @Nullable World WorldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (Screen.hasShiftDown()){
            tooltip.add(new TranslationTextComponent("tooltip.testmod.sander_shift"));
        }
        else{
            tooltip.add(new TranslationTextComponent("tooltip.testmod.press_shift"));
        }
        super.addInformation(itemStack, WorldIn, tooltip, flagIn);
    }

    private void rightClickOnCertainBlockState(BlockState clickedBlock, World world, BlockPos pos) {
        if(IsValidBlock(clickedBlock)) {
            ChangeBlock(clickedBlock, world, pos);
        }
    }

    private Boolean IsValidBlock(BlockState clickedBlock){
        Block block = clickedBlock.getBlock();
        return block == Blocks.DIORITE || block == Blocks.ANDESITE || block == Blocks.GRANITE;
    }

    private void ChangeBlock(BlockState clickedBlock, World world, BlockPos pos){
        Block block = clickedBlock.getBlock();
        world.destroyBlock(pos, false);
        if (block == Blocks.DIORITE){
            world.setBlockState(pos, Blocks.POLISHED_DIORITE.getDefaultState());
        }
        if (block == Blocks.ANDESITE){
            world.setBlockState(pos, Blocks.POLISHED_ANDESITE.getDefaultState());
        }
        if (block == Blocks.GRANITE){
            world.setBlockState(pos, Blocks.POLISHED_GRANITE.getDefaultState());
        }
    }
}

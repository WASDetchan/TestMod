package com.wasdetchan.testmod.block;

import com.wasdetchan.testmod.ModCreativeTabGroup;
import com.wasdetchan.testmod.TestMod;
import com.wasdetchan.testmod.block.building_block.AmethystBlock;
import com.wasdetchan.testmod.block.custom.SpikeBlock;
import com.wasdetchan.testmod.block.ore.AmethystOre;
import com.wasdetchan.testmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS
            = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static final RegistryObject<Block> AMETHYST_ORE = registerBlock("amethyst_ore", AmethystOre::new);
    public static final RegistryObject<Block> AMETHYST_BLOCK = registerBlock("amethyst_block", AmethystBlock::new);
    public static final RegistryObject<Block> SPIKE_BLOCK = registerBlock("spike_block", SpikeBlock::new);


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().group(ModCreativeTabGroup.TEST_GROUP)));

    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);

    }
}

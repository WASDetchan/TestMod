package com.wasdetchan.testmod.item;

import com.wasdetchan.testmod.TestMod;
import com.wasdetchan.testmod.item.food.Coconut;
import com.wasdetchan.testmod.item.materials.Amethyst;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);


    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut", Coconut::new);
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", Amethyst::new);



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

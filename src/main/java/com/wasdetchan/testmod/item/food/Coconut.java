package com.wasdetchan.testmod.item.food;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class Coconut extends Item {

    public Coconut(){
        super(new Item.Properties()
                .group(ItemGroup.FOOD)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(7f)
                        .build()));
    }
}

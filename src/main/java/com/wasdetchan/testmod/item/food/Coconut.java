package com.wasdetchan.testmod.item.food;

import com.wasdetchan.testmod.item.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;

public class Coconut extends Item {

    public Coconut(){
        super(new Item.Properties()
                .group(ModItemGroup.TEST_GROUP)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(7f)
                        .build()));
    }
}

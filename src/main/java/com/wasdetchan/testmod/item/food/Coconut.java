package com.wasdetchan.testmod.item.food;

import com.wasdetchan.testmod.ModCreativeTabGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Coconut extends Item {

    public Coconut(){
        super(new Item.Properties()
                .group(ModCreativeTabGroup.TEST_GROUP)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(7f)
                        .build()));
    }
}

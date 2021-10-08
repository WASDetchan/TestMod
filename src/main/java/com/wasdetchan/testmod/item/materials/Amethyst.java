package com.wasdetchan.testmod.item.materials;

import com.wasdetchan.testmod.item.ModItemGroup;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Amethyst extends Item {
    public Amethyst(){
        super(new Item.Properties()
                .group(ModItemGroup.TEST_GROUP));
    }
}

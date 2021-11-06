package com.wasdetchan.testmod.item.materials;

import com.wasdetchan.testmod.ModCreativeTabGroup;
import net.minecraft.item.Item;

public class Amethyst extends Item {
    public Amethyst(){
        super(new Item.Properties()
                .group(ModCreativeTabGroup.TEST_GROUP));
    }
}

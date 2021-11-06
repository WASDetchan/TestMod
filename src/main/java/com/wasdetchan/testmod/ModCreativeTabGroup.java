package com.wasdetchan.testmod;

import com.wasdetchan.testmod.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModCreativeTabGroup {
    public static final ItemGroup TEST_GROUP = new ItemGroup("testModTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.COCONUT.get());
        }
    };
}

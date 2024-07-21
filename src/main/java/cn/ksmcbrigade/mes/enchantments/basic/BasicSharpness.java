package cn.ksmcbrigade.mes.enchantments.basic;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class BasicSharpness extends Enchantment {
    public BasicSharpness() {
        super(Rarity.UNCOMMON, Enchantments.SHARPNESS.category, new EquipmentSlot[]{EquipmentSlot.OFFHAND,EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        return 0.5f + level*0.25f;
    }
}

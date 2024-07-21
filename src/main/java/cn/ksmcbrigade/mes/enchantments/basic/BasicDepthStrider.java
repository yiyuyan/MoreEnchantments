package cn.ksmcbrigade.mes.enchantments.basic;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class BasicDepthStrider extends Enchantment {
    public BasicDepthStrider() {
        super(Rarity.UNCOMMON, Enchantments.DEPTH_STRIDER.category, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public int getMinCost(int p_44679_) {
        return 3 + 15 * (p_44679_ - 1);
    }

    @Override
    public int getMaxCost(int p_44679_) {
        return super.getMinCost(p_44679_) + 30;
    }

    public boolean checkCompatibility(Enchantment p_45286_) {
        return super.checkCompatibility(p_45286_) && p_45286_ != Enchantments.FROST_WALKER;
    }
}

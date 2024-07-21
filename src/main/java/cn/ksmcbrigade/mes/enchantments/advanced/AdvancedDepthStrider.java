package cn.ksmcbrigade.mes.enchantments.advanced;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class AdvancedDepthStrider extends Enchantment {
    public AdvancedDepthStrider() {
        super(Rarity.UNCOMMON, Enchantments.DEPTH_STRIDER.category, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMinCost(int p_44679_) {
        return 10 + 25 * (p_44679_ - 1);
    }

    @Override
    public int getMaxCost(int p_44679_) {
        return super.getMinCost(p_44679_) + 80;
    }

    public boolean checkCompatibility(Enchantment p_45286_) {
        return super.checkCompatibility(p_45286_) && p_45286_ != Enchantments.FROST_WALKER;
    }
}

package cn.ksmcbrigade.mes.enchantments.basic;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class BasicKnockback extends Enchantment {
    public BasicKnockback() {
        super(Rarity.UNCOMMON, Enchantments.KNOCKBACK.category, new EquipmentSlot[]{EquipmentSlot.OFFHAND,EquipmentSlot.MAINHAND});
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
}

package cn.ksmcbrigade.mes.enchantments.advanced;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

public class AdvancedLootBonus extends Enchantment {
    public AdvancedLootBonus() {
        super(Rarity.UNCOMMON, Enchantments.FISHING_LUCK.category, new EquipmentSlot[]{EquipmentSlot.OFFHAND,EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMinCost(int p_44679_) {
        return 15 + 9 * (p_44679_ - 1);
    }

    @Override
    public int getMaxCost(int p_44679_) {
        return super.getMinCost(p_44679_) + 80;
    }

    public boolean checkCompatibility(Enchantment p_45094_) {
        return super.checkCompatibility(p_45094_) && p_45094_ != Enchantments.SILK_TOUCH;
    }
}

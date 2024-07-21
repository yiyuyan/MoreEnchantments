package cn.ksmcbrigade.mes.enchantments.meme.curse;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class BloodlustMyself extends Enchantment {
    public BloodlustMyself() {
        super(Rarity.RARE, EnchantmentCategory.VANISHABLE, new EquipmentSlot[]{EquipmentSlot.OFFHAND,EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 6;
    }

    @Override
    public boolean isCurse() {
        return true;
    }
}

package cn.ksmcbrigade.mes.enchantments.meme.curse;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class wakeSharpness extends Enchantment {
    public wakeSharpness() {
        super(Rarity.UNCOMMON, EnchantmentCategory.VANISHABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND,EquipmentSlot.OFFHAND});
    }

    @Override
    public int getMaxLevel() {
        return 8;
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        return -(0.8f * level);
    }

    @Override
    public boolean isCurse() {
        return true;
    }
}

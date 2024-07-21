package cn.ksmcbrigade.mes.registry;

import cn.ksmcbrigade.mes.enchantments.advanced.*;
import cn.ksmcbrigade.mes.enchantments.basic.*;
import cn.ksmcbrigade.mes.enchantments.meme.*;
import cn.ksmcbrigade.mes.enchantments.meme.curse.*;
import cn.ksmcbrigade.mes.enchantments.other.UnLootBonus;
import net.minecraft.world.item.enchantment.ProtectionEnchantment;

public class MoreEnchantmentsRegistry {
    public static AdvancedSharpness advancedSharpness = new AdvancedSharpness();
    public static BasicSharpness basicSharpness = new BasicSharpness();

    public static AdvancedKnockback advancedKnockback = new AdvancedKnockback();
    public static BasicKnockback basicKnockback = new BasicKnockback();

    public static AdvancedFireAspect advancedFireAspect = new AdvancedFireAspect();
    public static BasicFireAspect basicFireAspect = new BasicFireAspect();

    public static AdvancedDepthStrider advancedDepthStrider = new AdvancedDepthStrider();
    public static BasicDepthStrider basicDepthStrider = new BasicDepthStrider();

    public static AdvancedEfficiency advancedEfficiency = new AdvancedEfficiency();
    public static BasicEfficiency basicEfficiency = new BasicEfficiency();

    public static AdvancedLootBonus advancedLootBonus = new AdvancedLootBonus();
    public static UnLootBonus unLootBonus = new UnLootBonus();

    public static AdvancedProtection advancedProtection = new AdvancedProtection(ProtectionEnchantment.Type.ALL);
    public static BasicProtection basicProtection = new BasicProtection(ProtectionEnchantment.Type.ALL);

    public static AdvancedFireProtection advancedFireProtection = new AdvancedFireProtection();
    public static BasicFireProtection basicFireProtection = new BasicFireProtection();

    public static AdvancedBlastProtection advancedBlastProtection = new AdvancedBlastProtection();
    public static BasicBlastProtection basicBlastProtection = new BasicBlastProtection();

    public static AdvancedFeatherFallingProtection advancedFeatherFallingProtection = new AdvancedFeatherFallingProtection();
    public static BasicFeatherFallingProtection basicFeatherFallingProtection = new BasicFeatherFallingProtection();

    public static AdvancedProjectileProtection advancedProjectileProtection = new AdvancedProjectileProtection();
    public static BasicProjectileProtection projectileProtection = new BasicProjectileProtection();

    public static AdvancedLooting advancedLooting = new AdvancedLooting();
    public static BasicLooting basicLooting = new BasicLooting();

    public static AdvancedLoyalty advancedLoyalty = new AdvancedLoyalty();
    public static BasicLoyalty basicLoyalty = new BasicLoyalty();

    public static AdvancedRiptide advancedRiptide = new AdvancedRiptide();
    public static BasicRiptide basicRiptide = new BasicRiptide();

    public static AdvancedSwiftSneak advancedSwiftSneak = new AdvancedSwiftSneak();
    public static BasicSwiftSneak basicSwiftSneak = new BasicSwiftSneak();

    public static AdvancedPunch advancedPunch = new AdvancedPunch();
    public static BasicPunch basicPunch = new BasicPunch();


    public static Bloodlust bloodlust = new Bloodlust();
    public static BloodlustMyself bloodlustMyself = new BloodlustMyself();
    public static Disarm disarm = new Disarm();

    public static wakeSharpness wakeSharpness = new wakeSharpness();
    public static HurtMyself hurtMyself = new HurtMyself();

    public static Clear clear = new Clear();

    public static Fire fire = new Fire();
    public static FireMyself fireMyself = new FireMyself();
    public static LightingMyself lightingMyself = new LightingMyself();
    public static Lighting lighting = new Lighting();

    public static Kill kill = new Kill();

}

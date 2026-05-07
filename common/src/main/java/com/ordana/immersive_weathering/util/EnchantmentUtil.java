package com.ordana.immersive_weathering.util;

import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

public class EnchantmentUtil {
    public static boolean hasEnchantment(LivingEntity entity, ResourceKey<Enchantment> enchantment)
    {
        return EnchantmentHelper.getEnchantmentLevel(entity.registryAccess().lookup(Registries.ENCHANTMENT).get().getOrThrow(enchantment), (LivingEntity) entity)>0;
    }
    public static boolean hasEnchantment(ItemStack item, RegistryAccess registryAccess, ResourceKey<Enchantment> enchantment)
    {
        return EnchantmentHelper.getItemEnchantmentLevel(registryAccess.lookup(Registries.ENCHANTMENT).get().getOrThrow(enchantment), item)>0;
    }
}

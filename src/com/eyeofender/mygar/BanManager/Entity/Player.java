package com.eyeofender.mygar.BanManager.Entity;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.*;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.Vector;

import javax.persistence.*;
import java.net.InetSocketAddress;
import java.util.*;

/**
 * Created by Maxim on 07/02/14.
 */
@javax.persistence.Entity
@Table(name = "player")
public class Player implements org.bukkit.entity.Player
{
    @Id
    @Column(name = "uuid")
    private String uuid;

    private String displayName;

    private String name;

    @OneToOne(targetEntity = PlayerBan.class, mappedBy = "player")
    private PlayerBan ban;

    public boolean isBanned()
    {
        return ban == null || !ban.isLifted();
    }

    public boolean hasBan()
    {
        return ban != null;
    }

    public PlayerBan getBan() {
        return ban;
    }

    public void setBan(PlayerBan ban) {
        this.ban = ban;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDisplayName() {
        return null;
    }

    public void setDisplayName(String s) {

    }

    public String getPlayerListName() {
        return null;
    }

    public void setPlayerListName(String s) {

    }

    public void setCompassTarget(Location location) {

    }

    public Location getCompassTarget() {
        return null;
    }

    public InetSocketAddress getAddress() {
        return null;
    }

    public void sendRawMessage(String s) {

    }

    public void kickPlayer(String s) {

    }

    public void chat(String s) {

    }

    public boolean performCommand(String s) {
        return false;
    }

    public boolean isSneaking() {
        return false;
    }

    public void setSneaking(boolean b) {

    }

    public boolean isSprinting() {
        return false;
    }

    public void setSprinting(boolean b) {

    }

    public void saveData() {

    }

    public void loadData() {

    }

    public void setSleepingIgnored(boolean b) {

    }

    public boolean isSleepingIgnored() {
        return false;
    }

    public void playNote(Location location, byte b, byte b2) {

    }

    public void playNote(Location location, Instrument instrument, Note note) {

    }

    public void playSound(Location location, Sound sound, float v, float v2) {

    }

    public void playSound(Location location, String s, float v, float v2) {

    }

    public void playEffect(Location location, Effect effect, int i) {

    }

    public <T> void playEffect(Location location, Effect effect, T t) {

    }

    public void sendBlockChange(Location location, Material material, byte b) {

    }

    public boolean sendChunkChange(Location location, int i, int i2, int i3, byte[] bytes) {
        return false;
    }

    public void sendBlockChange(Location location, int i, byte b) {

    }

    public void sendMap(MapView mapView) {

    }

    public void updateInventory() {

    }

    public void awardAchievement(Achievement achievement) {

    }

    public void incrementStatistic(Statistic statistic) {

    }

    public void incrementStatistic(Statistic statistic, int i) {

    }

    public void incrementStatistic(Statistic statistic, Material material) {

    }

    public void incrementStatistic(Statistic statistic, Material material, int i) {

    }

    public void setPlayerTime(long l, boolean b) {

    }

    public long getPlayerTime() {
        return 0;
    }

    public long getPlayerTimeOffset() {
        return 0;
    }

    public boolean isPlayerTimeRelative() {
        return false;
    }

    public void resetPlayerTime() {

    }

    public void setPlayerWeather(WeatherType weatherType) {

    }

    public WeatherType getPlayerWeather() {
        return null;
    }

    public void resetPlayerWeather() {

    }

    public void giveExp(int i) {

    }

    public void giveExpLevels(int i) {

    }

    public float getExp() {
        return 0;
    }

    public void setExp(float v) {

    }

    public int getLevel() {
        return 0;
    }

    public void setLevel(int i) {

    }

    public int getTotalExperience() {
        return 0;
    }

    public void setTotalExperience(int i) {

    }

    public float getExhaustion() {
        return 0;
    }

    public void setExhaustion(float v) {

    }

    public float getSaturation() {
        return 0;
    }

    public void setSaturation(float v) {

    }

    public int getFoodLevel() {
        return 0;
    }

    public void setFoodLevel(int i) {

    }

    public Location getBedSpawnLocation() {
        return null;
    }

    public void setBedSpawnLocation(Location location) {

    }

    public void setBedSpawnLocation(Location location, boolean b) {

    }

    public boolean getAllowFlight() {
        return false;
    }

    public void setAllowFlight(boolean b) {

    }

    public void hidePlayer(org.bukkit.entity.Player player) {

    }

    public void showPlayer(org.bukkit.entity.Player player) {

    }

    public boolean canSee(org.bukkit.entity.Player player) {
        return false;
    }

    public boolean isOnGround() {
        return false;
    }

    public boolean isFlying() {
        return false;
    }

    public void setFlying(boolean b) {

    }

    public void setFlySpeed(float v) throws IllegalArgumentException {

    }

    public void setWalkSpeed(float v) throws IllegalArgumentException {

    }

    public float getFlySpeed() {
        return 0;
    }

    public float getWalkSpeed() {
        return 0;
    }

    public void setTexturePack(String s) {

    }

    public void setResourcePack(String s) {

    }

    public Scoreboard getScoreboard() {
        return null;
    }

    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {

    }

    public boolean isHealthScaled() {
        return false;
    }

    public void setHealthScaled(boolean b) {

    }

    public void setHealthScale(double v) throws IllegalArgumentException {

    }

    public double getHealthScale() {
        return 0;
    }

    public void sendMessage(String s) {

    }

    public void sendMessage(String[] strings) {

    }

    public Map<String, Object> serialize() {
        return null;
    }

    public boolean isConversing() {
        return false;
    }

    public void acceptConversationInput(String s) {

    }

    public boolean beginConversation(Conversation conversation) {
        return false;
    }

    public void abandonConversation(Conversation conversation) {

    }

    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {

    }

    public String getName() {
        return null;
    }

    public PlayerInventory getInventory() {
        return null;
    }

    public Inventory getEnderChest() {
        return null;
    }

    public boolean setWindowProperty(InventoryView.Property property, int i) {
        return false;
    }

    public InventoryView getOpenInventory() {
        return null;
    }

    public InventoryView openInventory(Inventory itemStacks) {
        return null;
    }

    public InventoryView openWorkbench(Location location, boolean b) {
        return null;
    }

    public InventoryView openEnchanting(Location location, boolean b) {
        return null;
    }

    public void openInventory(InventoryView inventoryView) {

    }

    public void closeInventory() {

    }

    public ItemStack getItemInHand() {
        return null;
    }

    public void setItemInHand(ItemStack itemStack) {

    }

    public ItemStack getItemOnCursor() {
        return null;
    }

    public void setItemOnCursor(ItemStack itemStack) {

    }

    public boolean isSleeping() {
        return false;
    }

    public int getSleepTicks() {
        return 0;
    }

    public GameMode getGameMode() {
        return null;
    }

    public void setGameMode(GameMode gameMode) {

    }

    public boolean isBlocking() {
        return false;
    }

    public int getExpToLevel() {
        return 0;
    }

    public double getEyeHeight() {
        return 0;
    }

    public double getEyeHeight(boolean b) {
        return 0;
    }

    public Location getEyeLocation() {
        return null;
    }

    public List<Block> getLineOfSight(HashSet<Byte> bytes, int i) {
        return null;
    }

    public Block getTargetBlock(HashSet<Byte> bytes, int i) {
        return null;
    }

    public List<Block> getLastTwoTargetBlocks(HashSet<Byte> bytes, int i) {
        return null;
    }

    public Egg throwEgg() {
        return null;
    }

    public Snowball throwSnowball() {
        return null;
    }

    public Arrow shootArrow() {
        return null;
    }

    public <T extends Projectile> T launchProjectile(Class<? extends T> aClass) {
        return null;
    }

    public int getRemainingAir() {
        return 0;
    }

    public void setRemainingAir(int i) {

    }

    public int getMaximumAir() {
        return 0;
    }

    public void setMaximumAir(int i) {

    }

    public int getMaximumNoDamageTicks() {
        return 0;
    }

    public void setMaximumNoDamageTicks(int i) {

    }

    public double getLastDamage() {
        return 0;
    }

    public int _INVALID_getLastDamage() {
        return 0;
    }

    public void setLastDamage(double v) {

    }

    public void _INVALID_setLastDamage(int i) {

    }

    public int getNoDamageTicks() {
        return 0;
    }

    public void setNoDamageTicks(int i) {

    }

    public org.bukkit.entity.Player getKiller() {
        return null;
    }

    public boolean addPotionEffect(PotionEffect potionEffect) {
        return false;
    }

    public boolean addPotionEffect(PotionEffect potionEffect, boolean b) {
        return false;
    }

    public boolean addPotionEffects(Collection<PotionEffect> potionEffects) {
        return false;
    }

    public boolean hasPotionEffect(PotionEffectType potionEffectType) {
        return false;
    }

    public void removePotionEffect(PotionEffectType potionEffectType) {

    }

    public Collection<PotionEffect> getActivePotionEffects() {
        return null;
    }

    public boolean hasLineOfSight(Entity entity) {
        return false;
    }

    public boolean getRemoveWhenFarAway() {
        return false;
    }

    public void setRemoveWhenFarAway(boolean b) {

    }

    public EntityEquipment getEquipment() {
        return null;
    }

    public void setCanPickupItems(boolean b) {

    }

    public boolean getCanPickupItems() {
        return false;
    }

    public void setCustomName(String s) {

    }

    public String getCustomName() {
        return null;
    }

    public void setCustomNameVisible(boolean b) {

    }

    public boolean isCustomNameVisible() {
        return false;
    }

    public boolean isLeashed() {
        return false;
    }

    public Entity getLeashHolder() throws IllegalStateException {
        return null;
    }

    public boolean setLeashHolder(Entity entity) {
        return false;
    }

    public void damage(double v) {

    }

    public void _INVALID_damage(int i) {

    }

    public void damage(double v, Entity entity) {

    }

    public void _INVALID_damage(int i, Entity entity) {

    }

    public double getHealth() {
        return 0;
    }

    public int _INVALID_getHealth() {
        return 0;
    }

    public void setHealth(double v) {

    }

    public void _INVALID_setHealth(int i) {

    }

    public double getMaxHealth() {
        return 0;
    }

    public int _INVALID_getMaxHealth() {
        return 0;
    }

    public void setMaxHealth(double v) {

    }

    public void _INVALID_setMaxHealth(int i) {

    }

    public void resetMaxHealth() {

    }

    public Location getLocation() {
        return null;
    }

    public Location getLocation(Location location) {
        return null;
    }

    public void setVelocity(Vector vector) {

    }

    public Vector getVelocity() {
        return null;
    }

    public World getWorld() {
        return null;
    }

    public boolean teleport(Location location) {
        return false;
    }

    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        return false;
    }

    public boolean teleport(Entity entity) {
        return false;
    }

    public boolean teleport(Entity entity, PlayerTeleportEvent.TeleportCause teleportCause) {
        return false;
    }

    public List<Entity> getNearbyEntities(double v, double v2, double v3) {
        return null;
    }

    public int getEntityId() {
        return 0;
    }

    public int getFireTicks() {
        return 0;
    }

    public int getMaxFireTicks() {
        return 0;
    }

    public void setFireTicks(int i) {

    }

    public void remove() {

    }

    public boolean isDead() {
        return false;
    }

    public boolean isValid() {
        return false;
    }

    public Server getServer() {
        return null;
    }

    public Entity getPassenger() {
        return null;
    }

    public boolean setPassenger(Entity entity) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean eject() {
        return false;
    }

    public float getFallDistance() {
        return 0;
    }

    public void setFallDistance(float v) {

    }

    public void setLastDamageCause(EntityDamageEvent entityDamageEvent) {

    }

    public EntityDamageEvent getLastDamageCause() {
        return null;
    }

    public UUID getUniqueId() {
        return null;
    }

    public int getTicksLived() {
        return 0;
    }

    public void setTicksLived(int i) {

    }

    public void playEffect(EntityEffect entityEffect) {

    }

    public EntityType getType() {
        return null;
    }

    public boolean isInsideVehicle() {
        return false;
    }

    public boolean leaveVehicle() {
        return false;
    }

    public Entity getVehicle() {
        return null;
    }

    public void setMetadata(String s, MetadataValue metadataValue) {

    }

    public List<MetadataValue> getMetadata(String s) {
        return null;
    }

    public boolean hasMetadata(String s) {
        return false;
    }

    public void removeMetadata(String s, Plugin plugin) {

    }

    public boolean isOnline() {
        return false;
    }

    public void setBanned(boolean b) {

    }

    public boolean isWhitelisted() {
        return false;
    }

    public void setWhitelisted(boolean b) {

    }

    public org.bukkit.entity.Player getPlayer() {
        return null;
    }

    public long getFirstPlayed() {
        return 0;
    }

    public long getLastPlayed() {
        return 0;
    }

    public boolean hasPlayedBefore() {
        return false;
    }

    public boolean isPermissionSet(String s) {
        return false;
    }

    public boolean isPermissionSet(Permission permission) {
        return false;
    }

    public boolean hasPermission(String s) {
        return false;
    }

    public boolean hasPermission(Permission permission) {
        return false;
    }

    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
        return null;
    }

    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        return null;
    }

    public void removeAttachment(PermissionAttachment permissionAttachment) {

    }

    public void recalculatePermissions() {

    }

    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return null;
    }

    public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {

    }

    public Set<String> getListeningPluginChannels() {
        return null;
    }

    public boolean isOp() {
        return false;
    }

    public void setOp(boolean b) {

    }
}
package com.eyeofender.mygar.BanManager.Entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Maxim on 07/02/14.
 */

@Entity
@Table(name = "player_ban")
public class PlayerBan
{
    @OneToOne(targetEntity = Player.class, mappedBy = "playerBan")
    private Player player;

    @OneToOne(targetEntity = Player.class)
    private Player banner;

    private String reason;

    @Temporal(value = TemporalType.DATE)
    private Date bannedOn;

    @Temporal(value = TemporalType.DATE)
    private Date expiresOn;

    private boolean lifted = false;

    private boolean permanent = false;

    public PlayerBan()
    {
        Date date = new Date();
        this.bannedOn = new Timestamp(date.getTime());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getBanner() {
        return banner;
    }

    public void setBanner(Player banner) {
        this.banner = banner;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getBannedOn() {
        return bannedOn;
    }

    public void setBannedOn(Date bannedOn) {
        this.bannedOn = bannedOn;
    }

    public Date getExpiresOn() {
        return expiresOn;
    }

    public void setExpiresOn(Date expiresOn) {
        this.expiresOn = expiresOn;
    }

    public boolean isLifted() {
        return lifted;
    }

    public void setLifted(boolean lifted) {
        this.lifted = lifted;
    }

    public boolean isPermanent() {
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        this.permanent = permanent;
    }

    public String getReason() {
        return reason;
    }
}

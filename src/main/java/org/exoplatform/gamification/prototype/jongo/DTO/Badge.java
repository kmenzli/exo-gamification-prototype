package org.exoplatform.gamification.prototype.jongo.DTO;

import java.util.Date;

public class Badge {

    String badge_name;
    int badge_score;
    String badge_icon;
    Date badge_acquired_date;

    public Badge() {
    }

    public String getBadge_name() {
        return badge_name;
    }

    public void setBadge_name(String badge_name) {
        this.badge_name = badge_name;
    }

    public int getBadge_score() {
        return badge_score;
    }

    public void setBadge_score(int badge_score) {
        this.badge_score = badge_score;
    }

    public String getBadge_icon() {
        return badge_icon;
    }

    public void setBadge_icon(String badge_icon) {
        this.badge_icon = badge_icon;
    }

    public Date getBadge_acquired_date() {
        return badge_acquired_date;
    }

    public void setBadge_acquired_date(Date badge_acquired_date) {
        this.badge_acquired_date = badge_acquired_date;
    }
}

package com.deswaef.shadowfury.battlenet.api.challengemodes.model;

/**
 * Created by QuintenDes on 31/08/15.
 */
public class RealmLeaderboardChallengeGroupMemberSpec {
    private String name;
    private Role role;
    private String backgroundImage;
    private String icon;
    private String description;
    private long order;

    public String getName() {
        return name;
    }

    public RealmLeaderboardChallengeGroupMemberSpec setName(String name) {
        this.name = name;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public RealmLeaderboardChallengeGroupMemberSpec setRole(Role role) {
        this.role = role;
        return this;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public RealmLeaderboardChallengeGroupMemberSpec setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public RealmLeaderboardChallengeGroupMemberSpec setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RealmLeaderboardChallengeGroupMemberSpec setDescription(String description) {
        this.description = description;
        return this;
    }

    public long getOrder() {
        return order;
    }

    public RealmLeaderboardChallengeGroupMemberSpec setOrder(long order) {
        this.order = order;
        return this;
    }
}

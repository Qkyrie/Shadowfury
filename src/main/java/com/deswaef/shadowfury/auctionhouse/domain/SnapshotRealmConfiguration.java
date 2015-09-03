package com.deswaef.shadowfury.auctionhouse.domain;

import com.deswaef.shadowfury.realm.domain.Realm;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "snapshot_realm_configuration")
public class SnapshotRealmConfiguration {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Realm realm;

    @Column(name = "needs_update")
    private boolean needsUpdate;
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    public Long getId() {
        return id;
    }

    public SnapshotRealmConfiguration setId(Long id) {
        this.id = id;
        return this;
    }

    public Realm getRealm() {
        return realm;
    }

    public SnapshotRealmConfiguration setRealm(Realm realm) {
        this.realm = realm;
        return this;
    }

    public boolean isNeedsUpdate() {
        return needsUpdate;
    }

    public SnapshotRealmConfiguration setNeedsUpdate(boolean needsUpdate) {
        this.needsUpdate = needsUpdate;
        return this;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public SnapshotRealmConfiguration setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }
}

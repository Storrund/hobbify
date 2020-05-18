package com.hobbify.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@MappedSuperclass
public class BaseEntity{

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist(){
        if(this.uuid == null){
            this.uuid = UUID.randomUUID().toString().replace("-", "");
        }

        this.createdAt = LocalDateTime.now(ZoneOffset.UTC);
    }


}

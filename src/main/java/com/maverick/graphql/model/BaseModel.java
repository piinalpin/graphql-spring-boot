package com.maverick.graphql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@NoArgsConstructor
@MappedSuperclass
abstract class BaseModel {

    @JsonProperty("created_at")
    @Column(name = "CREATED_AT", nullable = false)
    @Getter
    @Setter
    private Timestamp createdAt;

    @JsonProperty("created_by")
    @Column(name = "CREATED_BY", nullable = false)
    @Getter
    @Setter
    private Long createdBy;

    @JsonProperty("updated_at")
    @Column(name = "UPDATED_AT")
    @Getter
    @Setter
    private Timestamp updatedAt;

    @JsonIgnore
    @Column(name = "DELETED_AT")
    @Getter
    @Setter
    private Timestamp deleted_at;

    @PrePersist
    void onCreate() {
        createdAt = Timestamp.valueOf(LocalDateTime.now());
        if (createdBy == null) createdBy = 0L;
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = Timestamp.valueOf(LocalDateTime.now());
    }

}

package com.projects.safeydiet.shared.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class MasterEntity {
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @Column(name = "deleted_by")
    private Long deletedBy;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (updatedAt == null) {
            this.updatedAt = createdAt;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public void update(Long updatedBy){
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = updatedBy;
    }

    public void delete(Long deletedBy) {
        this.deletedAt = LocalDateTime.now();
        this.deletedBy = deletedBy;
    }

    public void restore(Long createdBy) {
        this.deletedAt = null;
        this.deletedBy = null;
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }

    public void create(Long createdBy) {
        this.createdBy = createdBy;
        this.createdAt = LocalDateTime.now();
    }
}

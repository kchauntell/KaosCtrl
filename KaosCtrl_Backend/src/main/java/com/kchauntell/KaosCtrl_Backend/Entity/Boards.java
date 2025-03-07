package com.kchauntell.KaosCtrl_Backend.Entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Boards")
public class Boards {
    @Id
    @Column(name="board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int board_id;

    @Column(name ="name")
    private String name;

    @Column(name="description")
    private String description;

    @CreatedDate
    @Column (name="created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @CreatedDate
    @Column (name="updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name="user_id")
    private long user_id;

    public Boards() {}

    public Boards(
            String name,
            String description,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            long user_id) {
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user_id = user_id;
    }

    public int getBoard_id() { return board_id; }
    public void setBoard_id(int board_id) { this.board_id = board_id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public long getUser_id() { return user_id; }
    public void setUser_id(long user_id) { this.user_id = user_id; }

    @Override
    public String toString() {
        return "Boards [board_id=" + board_id
                + ", name=" + name
                + ", description=" + description
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + ", user_id=" + user_id + "]";
    }

}

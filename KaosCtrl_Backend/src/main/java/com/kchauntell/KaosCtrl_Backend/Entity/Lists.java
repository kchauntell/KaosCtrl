package com.kchauntell.KaosCtrl_Backend.Entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import org.springframework.data.annotation.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Lists")
public class Lists {
    @Id
    @Column(name="list_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="board_id")
    private int board_id;

    @Column(name="category")
    private String category;

    @Column(name="position")
    private Integer position;

    @CreatedDate
    @Column (name="created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @CreatedDate
    @Column (name="updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    public Lists() {}

    public Lists (
            int id,
            int board_id,
            String category,
            Integer position,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
            ) {
        this.id = id;
        this.board_id = board_id;
        this.category = category;
        this.position = position;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() { return id;}
    public void setId(int id) { this.id = id;}
    public int getBoard_id() { return board_id; }
    public void setBoard_id(int board_id) { this.board_id = board_id; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public String toString() {
        return "Lists [id=" + id
                + ", board_id=" + board_id
                + ", category=" + category
                + ", position=" + position
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + "]";
    }
}

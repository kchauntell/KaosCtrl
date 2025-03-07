package com.kchauntell.KaosCtrl_Backend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;
import com.kchauntell.KaosCtrl_Backend.Entity.Card_Status;
import com.kchauntell.KaosCtrl_Backend.Entity.Card_Priority;

@Entity
@Table(name="Cards")
public class Cards {
    @Id
    @Column(name="card_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int card_id;

    @Column(name="list_id")
    private int list_id;

    @Column(name="user_id")
    private long user_id;

    @Column(name="assigned_user")
    private long assigned_user;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="card_priority")
    private String card_priority;

    @Column(name="card_status")
    private String card_status;

    @CreatedDate
    @Column (name="created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @CreatedDate
    @Column (name="updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name="due_date")
    private LocalDateTime dueDate;

    public Cards() {};

    public Cards(
            int list_id,
            long user_id,
            long assigned_user,
            String title,
            String description,
            Enum card_priority,
            Enum card_status,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            LocalDateTime dueDate
    ) {
        this.list_id = list_id;
        this.user_id = user_id;
        this.assigned_user = assigned_user;
        this.title = title;
        this.description = description;
        this.card_priority = card_priority.name();
        this.card_status = card_status.name();
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.dueDate = dueDate;
    };

    public int getCard_id() { return card_id;}
    public void setCard_id(int card_id) { this.card_id = card_id;}
    public int getList_id() { return list_id;}
    public void setList_id(int list_id) { this.list_id = list_id;}
    public long getUser_id() { return user_id;}
    public void setUser_id(long user_id) { this.user_id = user_id;}
    public long getAssigned_user() { return assigned_user;}
    public void setAssigned_user(long assigned_user) { this.assigned_user = assigned_user;}
    public String getTitle() { return title;}
    public void setTitle(String title) { this.title = title;}
    public String getDescription() { return description;}
    public void setDescription(String description) { this.description = description;}
    public String getCard_priority() { return card_priority;}
    public void setCard_priority(String card_priority) { this.card_priority = card_priority;}
    public String getCard_status() { return card_status;}
    public void setCard_status(String card_status) { this.card_status = card_status;}
    public LocalDateTime getCreatedAt() { return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt;}
    public LocalDateTime getUpdatedAt() { return updatedAt;}
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt;}
    public LocalDateTime getDueDate() { return dueDate;}
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate;}
}

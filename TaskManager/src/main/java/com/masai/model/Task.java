package com.masai.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.masai.Enums.TaskStatus;
import com.masai.Enums.TaskType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@NotNull(message = "Title must be Field !")
	@Size(min = 5, max = 100 ,message = "Title must Contain 5 to 100 character !")
    private String title;
	@NotNull(message = "Description must be Field !")
	@Size(max=500 ,message = "Description must be less the 500 character !")
    private String description;
    private TaskType type;
    private TaskStatus status;
    
//    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User assignee;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Sprint sprint;

    // getters and setters
}

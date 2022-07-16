package com.jb.taas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {

    private int id;

    @NotBlank
    private String caption;

    @NotBlank
    private String info;

    @NotBlank
    private String classification;

    @NotBlank
    private LocalDateTime dueDate;

    public TaskDto(TaskPayloadDto payloadDto){
        this.caption = payloadDto.getCaption();
        this.classification = payloadDto.getClassification();
        this.dueDate = payloadDto.getDueDate();
        this.info = payloadDto.getInfo();
    }
}
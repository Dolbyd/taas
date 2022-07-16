package com.jb.taas.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatesBetweenReq {

    private Timestamp start;
    private Timestamp end;
}
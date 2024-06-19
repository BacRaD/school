package com.webler.school.entity.grades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class AvgDTO implements Comparable<AvgDTO>{
    private String name;
    private Double average;


    @Override
    public int compareTo(AvgDTO o) {
        return this.average.compareTo(o.getAverage());
    }
}

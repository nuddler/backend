package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feature {

    @Id
    private String id;

    private String name;

    private String prettyName;

    private String description;

    private String iconUrl;

    private String iconTitle;
}
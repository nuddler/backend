package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teaser {

    @Id
    public String id;

	private String headline;

    private String iconUrl;
    
    private String iconTitle;

    private String description;

    private String url;

}

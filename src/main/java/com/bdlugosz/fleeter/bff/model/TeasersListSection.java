package com.bdlugosz.fleeter.bff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeasersListSection {
    private String header;
    private List<Teaser> teaserList;
}

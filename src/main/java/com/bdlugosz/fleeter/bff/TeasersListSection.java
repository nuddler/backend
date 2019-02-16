package com.bdlugosz.fleeter.bff;

import com.bdlugosz.fleeter.bff.model.Teaser;
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

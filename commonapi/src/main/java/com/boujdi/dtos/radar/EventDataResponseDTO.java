package com.boujdi.dtos.radar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDataResponseDTO<T> {
    private String type;
    private T eventData;
}



package org.aston.homework5DK.homework5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailEvent {
    private String email;
    private String operation;
}

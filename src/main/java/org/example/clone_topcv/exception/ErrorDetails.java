package org.example.clone_topcv.exception;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}

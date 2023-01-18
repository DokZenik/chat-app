package com.example.testchatwithreact.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MessageDTO {
    private String senderName;
    private String recipientName;
    private String message;
    private String date;
    private Status status;
}

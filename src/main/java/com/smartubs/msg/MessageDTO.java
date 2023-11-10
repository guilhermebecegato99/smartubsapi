package com.smartubs.msg;

import java.util.List;

public record MessageDTO(
        List<Message> messages
) {
}

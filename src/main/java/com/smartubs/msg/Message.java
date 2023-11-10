package com.smartubs.msg;

import java.util.List;

public record Message(
        List<Destination> destinations,
        String text
) {
}

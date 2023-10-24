package com.kwingi.emailsmicroservice.dtos;

import java.util.Set;

public record EmailRecordDTO(String subject, String content, Set<String> tos, Set<String> ccs, Set<String> bccs) {}

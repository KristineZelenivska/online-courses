package com.example.onlinecourses.service;

import com.example.onlinecourses.dto.OCFeedbackDto;
import com.example.onlinecourses.model.OCAttachment;
import com.example.onlinecourses.model.OCComment;
import com.example.onlinecourses.model.OCEntity;
import com.example.onlinecourses.model.OCFeedback;
import com.example.onlinecourses.repository.OCAttachmentRepository;
import com.example.onlinecourses.repository.OCCommentRepository;
import com.example.onlinecourses.repository.OCFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public abstract class OCAbstractService {
    @Autowired
    private OCCommentRepository commentRepository;

    @Autowired
    private OCAttachmentRepository attachmentRepository;

    @Autowired
    private OCFeedbackRepository feedbackRepository;

    protected List<OCFeedbackDto> getFeedback(OCEntity entity) {

        return feedbackRepository.findBySourceTableAndSourceTableSysId(entity.getTableName(), entity.getSysId())
                .stream()
                .map(this::createFeedbackDto)
                .collect(Collectors.toList());
    }

    protected List<OCComment> getComment(OCEntity entity) {
        return commentRepository.findBySourceTableAndSourceTableSysId(entity.getTableName(), entity.getSysId());
    }

    protected List<OCAttachment> getAttachment(OCEntity entity) {
        return attachmentRepository.findBySourceTableAndSourceTableSysId(entity.getTableName(), entity.getSysId());
    }

    private OCFeedbackDto createFeedbackDto(OCFeedback ocFeedback) {
        return new OCFeedbackDto(
                new OCFeedbackDto.OCPersonDto(
                        ocFeedback.getPerson().getSysId(),
                        ocFeedback.getPerson().getName(),
                        ocFeedback.getPerson().getSurname(),
                        ocFeedback.getPerson().getPersonRole()),
                ocFeedback.getComment(),
                ocFeedback.getCreationTime(),
                ocFeedback.getRating());
    }
}

package com.solvd.newsPortal.services;

import com.solvd.newsPortal.models.comment.Comment;

public interface ICommentService {
    Comment getCommentById(Long id);
}
